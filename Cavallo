public class Cavallo extends Pedina{
	public Cavallo(int x, int y, char funzione, int colore) {
		super(x, y, funzione, colore);
	}

	public boolean move(int destX, int destY, Pedina[][]scacchiera){
		if ((destY<0||destY>7) || (destX<0 || destX>7)) //controllo confini scacchiera
			return false;

		// NERI
		if (scacchiera[x][y].funzione=='C') {
			if ( (x-destX==2 && (y-destY==-1 || y-destY==1)) ||
				 (x-destX==-2 && (y-destY==-1 || y-destY==1)) ||
				 (y-destY==2 && (x-destX==-1 || x-destX==1)) ||
				 (y-destY==-2 && (x-destX==-1 || x-destX==1)) ){

				if (scacchiera[destX][destY]==null){ //Muovo
					scacchiera[x][y]=null;
					scacchiera[destX][destY]=this; 
					x=destX;
					y=destY;
					return true;
				} 

				else //Mangia
					if (avversario(x,y,destX,destY,scacchiera)) {// controllo di poterlo mangiare
						//controllo pedone avversario
						scacchiera[destX][destY]=new Cavallo(x,y,funzione,colore);
						scacchiera[x][y]=null; 
						x=destX;
						y=destY;
						scacchiera[destX][destY]=this;
						return true;
					}
			}
		}
		//BIANCHI

		if (scacchiera[x][y].funzione=='t') {
			if ( (x-destX==2 && (y-destY==-1 || y-destY==1)) ||
				 (x-destX==-2 && (y-destY==-1 || y-destY==1)) ||
				 (y-destY==2 && (x-destX==-1 || x-destX==1)) ||
				 (y-destY==-2 && (x-destX==-1 || x-destX==1)) ){

					if (scacchiera[destX][destY]==null){ //Muovo
						scacchiera[x][y]=null;
						scacchiera[destX][destY]=this; 
						x=destX;
						y=destY;
						return true;
					} 
					else //Mangia
						if (avversario(x,y,destX,destY,scacchiera)) {// controllo di poterlo mangiare
							//controllo pedone avversario
							scacchiera[destX][destY]=new Cavallo(x,y,funzione,colore);
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
}
