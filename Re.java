public class Re extends Pedina {
	public Re(int x, int y, char funzione, int colore) {
		super(x, y, funzione, colore);
	}

public boolean move(int destX, int destY, Pedina[][]scacchiera){
		if ((destY<0||destY>7) || (destX<0 || destX>7)) //controllo confini scacchiera
			return false;

		// NERI
		if (scacchiera[x][y].funzione=='R') {
			//controlli

			if (x-destX==1 && ((y-destY==1)||(y-destY==-1)||(y-destY==0)) ||
				x-destX==0 && ((y-destY==1)||(y-destY==-1)) ||
				x-destX==-1 && ((y-destY==1)||(y-destY==-1)||(y-destY==0)) ){ //mossa legale

				if (scacchiera[destX][destY]==null){ //Muovo
					scacchiera[x][y]=null;
					scacchiera[destX][destY]=this; 
					x=destX;
					y=destY;

					return true;
				}

				//Invece di mangiare controllo ogni volta lo scacco matto
				//?????????????????????????????????????????????????????????
			}
		}

		// BIANCHI
		//Invece di mangiare controllo ogni volta lo scacco matto

		//?????????????????????????????????????????????????????????
		if (scacchiera[x][y].funzione=='r') {
			//controlli
			if (x-destX==1 && ((y-destY==1)||(y-destY==-1)||(y-destY==0)) ||
				x-destX==0 && ((y-destY==1)||(y-destY==-1)) ||
				x-destX==-1 && ((y-destY==1)||(y-destY==-1)||(y-destY==0)) ){ //mossa legale

				if (scacchiera[destX][destY]==null){ //Muovo
					scacchiera[x][y]=null;
					scacchiera[destX][destY]=this; 
					x=destX;
					y=destY;

					return true;
				}
			}
		}
		return false;
	}
}
