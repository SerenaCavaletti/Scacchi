public abstract class Pedina {

	int x;
	int y;
	char funzione; 
	int colore; //0=nero 1=bianco

	public Pedina(int x, int y, char funzione, int colore){
		this.x=x;
		this.y=y;
		this.funzione=funzione;
		this.colore=colore;
	}

	public String toString(){
		return ""+funzione;
	}

	public boolean avversario(int x, int y, int destX, int destY, Pedina[][]scacchiera){

		if(Character.isUpperCase (scacchiera[x][y].funzione)){ //se il carattere è maiuscolo
			if(scacchiera[destX][destY].funzione=='p'||
				scacchiera[destX][destY].funzione=='t'||
				scacchiera[destX][destY].funzione=='c'||
				scacchiera[destX][destY].funzione=='a'||
				scacchiera[destX][destY].funzione=='k'||
				scacchiera[destX][destY].funzione=='q')

				return true;
			return false;
		}

		else { //se il carattere è maiuscolo
			if(scacchiera[destX][destY].funzione=='P'||
			scacchiera[destX][destY].funzione=='T'||
			scacchiera[destX][destY].funzione=='C'||
			scacchiera[destX][destY].funzione=='A'||
			scacchiera[destX][destY].funzione=='K'||
			scacchiera[destX][destY].funzione=='Q')

				return true;

			return false;
		}
	}
}
