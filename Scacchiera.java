package gioco;

public class Scacchiera {
	
	private Pedina[][] scacchiera;
	
	public Scacchiera(){

		this.scacchiera = new Pedina [8][8];
		
		//L'ASSE X E' y
		//l'asse Y E' x
		
		/*scacchiera = new Pedina[][] {	{ new Torre(0, 0, Colore.Nero), new Cavallo(0, 1, Colore.Nero), new Alfiere(0, 2, Colore.Nero), new Regina(0, 3, Colore.Nero), new Re(0, 4, Colore.Nero), new Alfiere(0, 5, Colore.Nero), new Cavallo(0, 6, Colore.Nero), new Torre(0, 7, Colore.Nero)},
										{ new Pedone(1, 0, Colore.Nero), new Pedone(1, 1, Colore.Nero), new Pedone(1, 2, Colore.Nero), new Pedone(1, 3, Colore.Nero), new Pedone(1, 4, Colore.Nero), new Pedone(1, 5, Colore.Nero), new Pedone(1, 6, Colore.Nero), new Pedone(1, 7, Colore.Nero)},
										{ new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
										{ new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
										{ new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
										{ new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
										{ new Pedone(6, 0, Colore.Bianco), new Pedone(6, 1, Colore.Bianco), new Pedone(6, 2, Colore.Bianco), new Pedone(6, 3, Colore.Bianco), new Pedone(6, 4, Colore.Bianco), new Pedone(6, 5, Colore.Bianco), new Pedone(6, 6, Colore.Bianco), new Pedone(6, 7, Colore.Bianco)},
										{ new Torre(7, 0, Colore.Bianco), new Cavallo(7, 1, Colore.Bianco), new Alfiere(7, 2, Colore.Bianco), new Regina(7, 3, Colore.Bianco), new Re(7, 4, Colore.Bianco), new Alfiere(7, 5, Colore.Bianco), new Cavallo(7, 6, Colore.Bianco), new Torre(7, 7, Colore.Bianco)}
									};
		*/
	}

	public Pedina [][] getScacchiera(){
		return scacchiera;
	}

	@Override
	public String toString(){
		int i,j;
		String res="";
		res+=" ";

		//stampa coordinate y
		for (j=0; j<8; j++)
			res+="  " + j + " ";
		res+="\n";

		res+=" ";

		for (j=0; j<8; j++)			
			res+=" ___";
		res+="\n";

		for (i=0; i<8; i++){
			res+=i;
			for (j=0; j<8; j++)	{
				if (scacchiera[i][j]==null)
					res+="|___";
				else
					res+="|_"+scacchiera[i][j]+"_";
			}

			res+="|\n";
		}

		return res;
	}	
		
	public boolean checkMovePedone(Pedina pedone, int newX, int newY){
		
		int x = pedone.getX();
		int y = pedone.getY();
		Colore colore = pedone.getColore();
		
		if ( (colore == Colore.Bianco && newX == x - 1) //se è bianco allora si trova in basso e deve solo salire
			|| (colore == Colore.Nero && newX == x + 1)) //se è nero allora si trova in alto e può solo scendere
		{
			if (newY == y && scacchiera[newX][newY] == null)
				return true; //mi muovo in avanti di uno e la casella è libera
			else if	((colore == Colore.Bianco && (newX == x - 1 && (newY == y + 1 || newY == y -1)) && scacchiera[newX][newY].getColore() == Colore.Nero) //se la nuova coordinata è in diagonale, allora deve essere occupatata dalla pedina dell'avversario
				|| (colore == Colore.Nero && (newX == x + 1 && (newY == y + 1 || newY == y -1)) && scacchiera[newX][newY].getColore() == Colore.Bianco) )
				return true; //posso mangiare
		}
		return false;
	}
	
	public boolean checkMoveRe(Pedina re, int newX, int newY) {
		
		int x = re.getX();
		int y = re.getY();
		Colore c = re.getColore();

		if (scacchiera[newX][newY] == null || scacchiera[newX][newY].getColore() != c) //se la destinazione è occupata dal mio stesso colore termino subito
		{
			if ( ((newX == x || newX == x + 1 || newX == x - 1) 
				&& (newY == y || newY == y + 1 || newY == y - 1) ) //se le nuove coordinate sono lecite 
				&& (newX != x && newY != y)) //con escluso il posto in cui sono ora
				return true;
		}
		return false;
		
	}

	public boolean checkMoveAlfiere(Pedina alfiere, int newX, int newY) {
		
		int x = alfiere.getX();
		int y = alfiere.getY();
		Colore c = alfiere.getColore();
		
		if (scacchiera[newX][newY] == null || scacchiera[newX][newY].getColore() != c){
		
			//controllo se lo spostamento su x è uguale a y
			//se lo è, si muove in diagonale.
			//Elimino il caso in cui si seleziona la posizione di partenza
			if ( (Math.abs(x - newX) == Math.abs(y - newY)) && (newX != x && newY != y) ){
					
				if (newX < x){ //vado in alto
					
					if (newY > y){//vado a destra
						int tmp = y + 1;
						for (int pos = x - 1; pos > newX; pos--){
							if (scacchiera[pos][tmp]!=null) //incontro un pezzo sul tragitto e termino
								return false;
							tmp++;
						}
					}
					else{ //sto andando verso sx
						int tmp = y - 1;
						for (int pos= x - 1; pos > newX; pos--){
							if (scacchiera[pos][tmp]!=null)
								return false;
							tmp--;
						}
					}
				}
				else { //sto andando in basso
					
					if (newY>y){ //sto andando verso dx
						int tmp = y + 1;
						for (int pos= x + 1; pos < newX; pos++){
							if (scacchiera[pos][tmp]!=null)
								return false;
							tmp++;
						}
					}
					else{ //sto andando verso sx
						int tmp = y - 1;
						for (int pos= x + 1; pos < newX; pos++){
							if (scacchiera[pos][tmp]!=null)
								return false;
							tmp--;
						}
					}		
				}
				return true;
			}
		}
		return false;
	}

	public boolean checkMoveCavallo(Pedina cavallo, int newX, int newY){
		
		int x = cavallo.getX();
		int y = cavallo.getY();
		Colore c = cavallo.getColore();
		
		if ( scacchiera[newX][newY] == null || scacchiera[newX][newY].getColore() != c )
			if ( (x-newX==2 && (y-newY==-1 || y-newY==1)) ||
					 (x-newX==-2 && (y-newY==-1 || y-newY==1)) ||
					 (y-newY==2 && (x-newX==-1 || x-newX==1)) ||
					 (y-newY==-2 && (x-newX==-1 || x-newX==1)) ) //controllo se il movimento è lecito
				return true;
		return false;
	}

	public boolean checkMoveTorre(Pedina torre, int newX, int newY) {
		
		int x = torre.getX();
		int y = torre.getY();
		Colore c = torre.getColore();
		
		if ( scacchiera[newX][newY] == null || scacchiera[newX][newY].getColore() != c ){
			
			if ( (newX != x && newY != y) || (newX == x && newY == y) ){
				//vuol dire che non ha mosso in " + "
				//e che ha cambiato posizione
				return false;
			}
			else if (newY == y) {//controllo orizzontale, se c'è qualcosa fra la torre e la dest, termino
				for (int tmp = x + 1; tmp < newX; tmp++)
					if (scacchiera[tmp][y] != null)
						return false;
			}
	
			else if (newX == x) { //controllo verticale, se c'è qualcosa fra la torre e la dest, termino
				for (int pos = y + 1; pos < newY; pos++)
					if (scacchiera[x][pos]!=null)
						return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean checkMoveRegina(Pedina regina, int newX, int newY) {
		
		if (checkMoveAlfiere(regina, newX, newY) && checkMoveTorre(regina, newX, newY) )
			return true;
		else
			return false;		
	}
	
	public void move(Pedina pezzo, int newX, int newY){
		
		int x = pezzo.getX();
		int y = pezzo.getY();
		scacchiera[newX][newY] = pezzo;
		scacchiera[x][y] = null; //Devo liberare la vecchia posizione
	}
	
	public Pedina getPezzo(int x, int y){
		return this.scacchiera[x][y];
	}
		
}
