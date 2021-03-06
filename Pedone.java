public class Pedone extends Pedina {
	public Pedone(int x, int y, char funzione, int colore) {
		super(x, y, funzione, colore);
	}

	public boolean move(int destX, int destY, Pedina[][]scacchiera){
		//controllo confini scacchiera
		if ((destY<0||destY>7) || (destX<0 || destX>7)) 
			return false;

		//NERI
		if (scacchiera[x][y].funzione=='P') {
		//Muove
			if ((x-destX==-1) && (y-destY==0) && scacchiera[destX][destY]==null){ 
				scacchiera[x][y]=null;
				scacchiera[destX][destY]=this; 
				x=destX;
				y=destY;
				return true;
			}

		//Mangia
		if(scacchiera[destX][destY]==null)
			return false;

		if ((((x-destX==-1) && ((y-destY==-1) || (y-destY==1))) && scacchiera[destX][destY]!=null) &&
				avversario(x,y,destX,destY,scacchiera)){ 
				//se funzione != funzione, quindi diverso da p,t,c,a,k,q ma NON da T,C,A,K,Q

				// mangia

				scacchiera[destX][destY]=new Pedone(x,y,funzione,colore); //nuovo pedone nella destinazione
				scacchiera[x][y]=null; //vecchio posto prende nulla
				x=destX; //le nuove x e y diventano le destinazioni
				y=destY;

				//scacchiera[(destX+x)/2][(y+destY)/2].funzione=0; //prende zero significa che non appartiene a nessun giocatore
				scacchiera[destX][destY]=this;
				return true;
		}
	}

		//BIANCHI
		if (scacchiera[x][y].funzione=='p') { // da modificare, mangia in avanti
		//Muove
			if ((x-destX==-1) && (y-destY==0) && scacchiera[destX][destY]==null){ 
				scacchiera[x][y]=null;
				scacchiera[destX][destY]=this; 
				x=destX;
				y=destY;
				return true;
			}

		//Mangia
			if ((((x-destX==1) && ((y-destY==-1) || (y-destY==1))) && scacchiera[destX][destY]!=null) &&
					avversario(x,y,destX,destY,scacchiera)){ // mangia

				scacchiera[destX][destY]=new Pedone(x,y,funzione,colore);
				scacchiera[x][y]=null;
				//scacchiera[(destX+x)/2][(y+destY)/2]=null;
				x=destX;
				y=destY;

				//scacchiera[(destX+x)/2][(y+destY)/2].funzione=0; //prende zero significa che non appartiene a nessun giocatore
				scacchiera[destX][destY]=this;
				return true;
			}
		}
		return false;
	}
}

