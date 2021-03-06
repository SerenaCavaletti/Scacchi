public class Regina extends Pedina {
	public Regina(int x, int y, char funzione, int colore) {
		super(x, y, funzione, colore);
	}

	public boolean move(int destX, int destY, Pedina[][]scacchiera){
		if ((destY<0||destY>7) || (destX<0 || destX>7)) //controllo confini scacchiera
			return false;

		// NERI
		if (scacchiera[x][y].funzione=='Q') {
			if (x-destX==0 || y-destY==0){ //mi sto muovendo in verticale/orizzontale
				if (scacchiera[destX][destY]==null){ //Muovo
					if (percorsoLibero(destX,destY,scacchiera)==true){
						scacchiera[x][y]=null;
						scacchiera[destX][destY]=this; 
						x=destX;
						y=destY;

						return true;
					}
				}
			}

			else { //Mangia
					if (percorsoLibero(destX,destY,scacchiera)==true){
						if (avversario(x,y,destX,destY,scacchiera)){ // controllo di poterlo mangiare
							//controllo pedone avversario
							scacchiera[destX][destY]=new Regina(x,y,funzione,colore);
							scacchiera[x][y]=null; 
							x=destX;
							y=destY;
							scacchiera[destX][destY]=this;

							return true;
						}
					}
			}
		}

		//BIANCHI

		if (scacchiera[x][y].funzione=='q') {
			if (scacchiera[destX][destY]==null){ //Muovo
					scacchiera[x][y]=null;
					scacchiera[destX][destY]=this; 
					x=destX;
					y=destY;

					return true;
			}

			else { //Mangia
				if (avversario(x,y,destX,destY,scacchiera)){ // controllo di poterlo mangiare
					//controllo pedone avversario
					scacchiera[destX][destY]=new Regina(x,y,funzione,colore);
					scacchiera[x][y]=null; 
					x=destX;
					y=destY;
					scacchiera[destX][destY]=this;

					return true;
				}
			}
		}
		return false;
	}

		public boolean percorsoLibero(int destX, int destY, Pedina[][]scacchiera){
			if (y==destY) { //controllo verticale, se c'è qualcosa fra T e la dest, return false
				for (int tmp=x+1; tmp<destX; tmp++){
					if (scacchiera[tmp][y]!=null)
						return false;
				}
			}

			else { //controllo orizzontale, se c'è qualcosa fra T e la dest, return false
				for (int pos=y+1; pos<destY; pos++){
					if (scacchiera[x][pos]!=null)
						return false;
				}
			}

		return true;
		}
}
