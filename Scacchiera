public class Scacchiera {
	private Pedina[][] scacchiera;
	public Scacchiera(){
		this.scacchiera = new Pedina [8][8];
	}

	public Pedina [][] getScacchiera(){
		return scacchiera;
	}

	public String toString(){
		int i,j;
		String res="";
		res+=" ";

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

	/*public Scacchiera clone(){
		Scacchiera clone=new Scacchiera();
		for (int i=0; i<8; i++)
			for (int j=0; j<8; j++)
				if(scacchiera[i][j]!=null){
					clone.scacchiera[i][j]=new PedinaPc(0,0,'c',0);
					clone.scacchiera[i][j].x=scacchiera[i][j].x;
					clone.scacchiera[i][j].y=scacchiera[i][j].y;
					clone.scacchiera[i][j].player=scacchiera[i][j].player;
					clone.scacchiera[i][j].colore=scacchiera[i][j].colore;
					clone.scacchiera[i][j].potenziale=scacchiera[i][j].potenziale;
				}	

		return clone;
	}*/
}
