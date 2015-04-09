

public class Alfiere extends Pedina {

	public Alfiere(int x, int y, char funzione, int colore) {
		super(x, y, funzione, colore);
	}

	public boolean move(int destX, int destY, Pedina[][]scacchiera){

		if ((destY<0||destY>7) || (destX<0 || destX>7)) //controllo confini scacchiera
			return false;

		// NERI

		if (scacchiera[x][y].funzione=='A') {
			//controlli
			if (x-destX==y-destY || x-destX==-(y-destY)){ //mi sto muovendo in obliquo

				if (scacchiera[destX][destY]==null){ //Muovo
					if (percorsoLibero(destX,destY,scacchiera)==true){
						scacchiera[x][y]=null;
						scacchiera[destX][destY]=this; 
						x=destX;
						y=destY;
						return true;
					}
				}

				else { //Mangia
					if (percorsoLibero(destX,destY,scacchiera)==true){
						if (avversario(x,y,destX,destY,scacchiera)){ // controllo di poterlo mangiare
							//controllo pedone avversario
							scacchiera[destX][destY]=new Alfiere(x,y,funzione,colore);
							scacchiera[x][y]=null; 
							x=destX;
							y=destY;
							scacchiera[destX][destY]=this;
							return true;
						}
					}
				}
			}
		}


		// BIANCHI
				if (scacchiera[x][y].funzione=='a') {
					//controlli

					if (x-destX==y-destY || x-destX==-(y-destY)){ //mi sto muovendo in obliquo
						if (scacchiera[destX][destY]==null){ //Muovo
							if (percorsoLibero(destX,destY,scacchiera)==true){
								scacchiera[x][y]=null;
								scacchiera[destX][destY]=this; 
								x=destX;
								y=destY;
								return true;
							}
						}

						else { //Mangia
							if (percorsoLibero(destX,destY,scacchiera)==true){
								if (avversario(x,y,destX,destY,scacchiera)){ // controllo di poterlo mangiare
									//controllo pedone avversario
									scacchiera[destX][destY]=new Alfiere(x,y,funzione,colore);
									scacchiera[x][y]=null; 
									x=destX;
									y=destY;
									scacchiera[destX][destY]=this;
									return true;
								}
							}
						}
				}
	}

		return false;

}

	public boolean percorsoLibero(int destX, int destY, Pedina[][]scacchiera){
		if (destX<x){ //sto andando verso l'alto
			if (destY>y){ //sto andando verso dx
				for (int pos= x-1; pos > destX; pos--){
					int tmp=y+1;

					if (scacchiera[pos][tmp]!=null){
						return false;
					}

					tmp++;
				}
			}

			else{ //sto andando verso sx
				for (int pos= x-1; pos > destX; pos--){
					int tmp=y-1;

					if (scacchiera[pos][tmp]!=null){
						return false;
					}

					tmp--;
				}
			}
		}

		else { //sto andando in basso
			if (destY>y){ //sto andando verso dx
				for (int pos= x+1; pos < destX; pos++){
					int tmp=y+1;
					if (scacchiera[pos][tmp]!=null){
						return false;
					}

					tmp++;
				}
			}

			else{ //sto andando verso sx
				for (int pos= x+1; pos < destX; pos++){
					int tmp=y-1;
					if (scacchiera[pos][tmp]!=null){
						return false;
					}

					tmp--;
				}
			}		
		}

	return true;
	}
}

