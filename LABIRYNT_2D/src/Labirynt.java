import java.util.Random;

public class Labirynt {
	
	private int lab_szer,lab_wys;
	private boolean[][][] cell;// = new boolean[42][42][4];
	private boolean[][] cell_bool;
	private int[][] kroki;
	private int krok;
	private int x_akt,y_akt;
	private Random generator = new Random();
	private int nr_scianki;
	
	
	public Labirynt(int szer,int wys) {
		
		
	    generuj(szer,wys);
	    buduj();
	    
	    
	                            
	}
	
	public void reset(){
		
		for(int a=0;a<lab_szer+2;a++)
	        for(int b=0;b<lab_wys+2;b++)
	            for(int c=0;c<4;c++)
	            {
	              cell[a][b][c] = true;
	              cell_bool[a][b] = true;
	            }

	    for(int a=1;a<lab_szer+1;a++)
	        for(int b=1;b<lab_wys+1;b++)
	                cell_bool[a][b] = false;
	    this.krok = 0;
	    buduj();
	}
	
	private void generuj(int szer,int wys){
		
		
		if(szer>=5 && szer<=120 && wys >= 5 && wys<=120) {
			cell = new boolean[szer+2][wys+2][4];
			cell_bool = new boolean[szer+2][wys+2];
			kroki = new int[(szer+2)*(wys+2)][2];
		}
		
		for(int a=0;a<szer+2;a++)
	        for(int b=0;b<wys+2;b++)
	            for(int c=0;c<4;c++)
	            {
	              cell[a][b][c] = true;
	              cell_bool[a][b] = true;
	            }

	    for(int a=1;a<szer+1;a++)
	        for(int b=1;b<wys+1;b++)
	                cell_bool[a][b] = false;

	     this.krok = 0;
	     this.lab_szer = szer;
	     this.lab_wys = wys;
	}
	
	public int getSize_x(){
		return lab_szer;
	}
	
	public int getSize_y(){
		return lab_wys;
	}
	
	public boolean getCell(int a,int b,int c){
		return cell[a][b][c];
	}
	
	private void losuj_start(){
		x_akt = generator.nextInt(lab_szer);
		y_akt = generator.nextInt(lab_wys);
		krok++;
	}
	
	/* private boolean sprawdz_scianke(int a){
		
		 switch(a){
		        case 1: return !cell_bool[x_akt][y_akt-1];
		        case 2: return !cell_bool[x_akt+1][y_akt]; 
		        case 3: return !cell_bool[x_akt][y_akt+1];  
		        case 4: return !cell_bool[x_akt-1][y_akt]; 
		        default: return false;
		    }
		
		 
	} */
	
	private int losuj_scianke(){
	 
	    boolean zgoda = false;

	    while(!zgoda){
	        nr_scianki = generator.nextInt(4);

	        switch(nr_scianki){
	                case 0: if(y_akt>0)zgoda = !cell_bool[x_akt][y_akt-1]; break;
	                case 1: if(x_akt<lab_szer)zgoda = !cell_bool[x_akt+1][y_akt]; break;
	                case 2: if(y_akt<lab_wys)zgoda = !cell_bool[x_akt][y_akt+1];  break;
	                case 3: if(x_akt>0)zgoda = !cell_bool[x_akt-1][y_akt]; break;
	            }
	    }

	    return  nr_scianki;
	}
	
	
	private void usun_scianke(int a){
		
	    cell[x_akt][y_akt][a] = false;

	    switch(a){
	        case 0: cell[x_akt][y_akt-1][2] = false; y_akt--; break;
	        case 1: cell[x_akt+1][y_akt][3] = false; x_akt++; break;
	        case 2: cell[x_akt][y_akt+1][0] = false; y_akt++; break;
	        case 3: cell[x_akt-1][y_akt][1] = false; x_akt--; break;
	    }
	    krok++;
	    kroki[krok][0] = x_akt;
	    kroki[krok][1] = y_akt;
	    
	    cell_bool[x_akt][y_akt] = true;
	}
	
	
	private boolean koniec(){
	    boolean koniec = true;

	    for(int a=1;a<lab_szer+2;a++)
	        for(int b=1;b<lab_wys+2;b++)
	                if(cell_bool[a][b] == false)
	                    koniec = false;

	    return koniec;
	}
	
	private boolean test(){
	    boolean zgoda = false;

	    if(x_akt>0)
	    if(cell_bool[x_akt - 1][y_akt] == false) zgoda = true;
	    
	    if(x_akt<lab_szer)
	    if(cell_bool[x_akt + 1][y_akt] == false) zgoda = true;
	    
	    if(y_akt>0)
	    if(cell_bool[x_akt][y_akt - 1] == false) zgoda = true;
	    
	    if(y_akt<lab_wys)
	    if(cell_bool[x_akt][y_akt + 1] == false) zgoda = true;

	    return zgoda;
	}
	
	private void ruch(boolean zgoda)
	{
	    if(zgoda == false)
	    {
	        if(krok!=0) krok--;

	        x_akt = kroki[krok][0];
	        y_akt = kroki[krok][1];
	    }
	    else
	    {

	    }

	}
	
	public void buduj() // buduje labirynt
	{
		
	    losuj_start();
	    
	    while(!koniec())
	    {
	    while(!test())
	    {
	    ruch(test());
	    }
	    usun_scianke(losuj_scianke());
	    }
	    
	}
	
	

}
