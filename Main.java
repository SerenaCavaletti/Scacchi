public class Main prova{
	public static void main(String[] args) {
		Scacchiera scacchiera = new Scacchiera();
		
		//Posiziono le pedine
		int i=0;
		int j=0;

		//sostituito tutti gli i,j ???????????

		//scacchiera.getScacchiera()[0][0]=new Torre(i,j,'T',0);

		scacchiera.getScacchiera()[0][0]=new Torre(0,0,'T',0);
		scacchiera.getScacchiera()[0][7]=new Torre(0,7,'T',0);
		scacchiera.getScacchiera()[0][1]=new Cavallo(0,1,'C',0);
		scacchiera.getScacchiera()[0][6]=new Cavallo(0,6,'C',0);
		scacchiera.getScacchiera()[0][2]=new Alfiere(0,2,'A',0);
		scacchiera.getScacchiera()[0][5]=new Alfiere(0,5,'A',0);
		scacchiera.getScacchiera()[0][4]=new Re(i,j,'K',0);
		/*scacchiera.getScacchiera()[0][3]=new Regina(i,j,'Q',0);*/

		for (i=1; i<2; i++)
			for (j=0; j<8; j++)
				scacchiera.getScacchiera()[i][j]=new Pedone(i,j,'P',0);

		scacchiera.getScacchiera()[7][0]=new Torre(7,0,'t',1);
		scacchiera.getScacchiera()[7][7]=new Torre(7,7,'t',1);
		scacchiera.getScacchiera()[7][1]=new Cavallo(7,1,'c',1);
		scacchiera.getScacchiera()[7][6]=new Cavallo(7,6,'c',1);
		scacchiera.getScacchiera()[7][2]=new Alfiere(7,2,'a',1);
		scacchiera.getScacchiera()[7][5]=new Alfiere(7,5,'a',1);
		scacchiera.getScacchiera()[7][4]=new Re(i,j,'k',1);

		/*scacchiera.getScacchiera()[7][3]=new Regina(i,j,'q',1);*/

		for (i=6; i<7; i++)
			for (j=0; j<8; j++)
				scacchiera.getScacchiera()[i][j]=new Pedone(i,j,'p',1);

		//scacchiera.getScacchiera()[0][1]=new Cavallo(0,1,'C',0);
		//scacchiera.getScacchiera()[1][3]=new Pedone(1,3,'P',1);
		scacchiera.getScacchiera()[3][3]=new Alfiere(3,3,'A',1);
		scacchiera.getScacchiera()[4][4]=new Alfiere(4,4,'a',0);
		//scacchiera.getScacchiera()[2][4]=new Pedone(2,4,'p',1);

		//System.out.print(((PedinaPc) scacchiera.getScacchiera()[0][4]).getDepth(scacchiera));		
		//System.out.println(((Cavallo) scacchiera.getScacchiera()[0][1]).move(2,2,scacchiera.getScacchiera()));
		//System.out.println(((Cavallo) scacchiera.getScacchiera()[0][6]).move(2,2,scacchiera.getScacchiera()));
		//System.out.println(((Torre) scacchiera.getScacchiera()[0][0]).move(0,1,scacchiera.getScacchiera()));
		//System.out.println(((Torre) scacchiera.getScacchiera()[0][7]).move(0,5,scacchiera.getScacchiera()));
		System.out.println(((Alfiere) scacchiera.getScacchiera()[0][2]).move(2,4,scacchiera.getScacchiera()));

		//System.out.println(((Pedone) scacchiera.getScacchiera()[1][3]).move(2,3,scacchiera.getScacchiera()));
		//System.out.println(((Pedone) scacchiera.getScacchiera()[1][3]).move(2,4,scacchiera.getScacchiera()));
		//System.out.println(checkScaccoMatto(0,3,scacchiera.getScacchiera()));

		System.out.print(scacchiera);
	}
}

/*
public static boolean checkScaccoMatto(int x, int y, Pedina[][]scacchiera) {

		int check;
		int scaccoMatto=0;
		int destX=x;
		int destY=y;

	if (scacchiera[x][y].funzione != 'K' && scacchiera[x][y].funzione != 'k')
		return false; //provo a fare il check su una pedina che NON è il Re

	if ( (x==0 && (y==0 || y== 7)) || (y==0 && (x==0 || x==7)) ) //sono nell'angolo
		check=3;
	else if ( x==0 || x==7 || y==0 || y==7) //sono sui bordi
		check=5;
	else //sono nel mezzo
		check=8;

	while (scaccoMatto<check){
		for (int pos=0; pos<=7; pos++){
			if ((scacchiera[pos][destY-1]!=null || scacchiera[destX-1][pos]!=null) && 
				(scacchiera[pos][destY-1]==avversario(x,y,pos,destY-1,scacchiera.getScacchiera()) || 
				scacchiera[destX-1][pos]==avversario(x,y,destX-1,pos,scacchiera.getScacchiera())) ){
			}
		}
	}
	return true;

}
}



/* inizio gioco: setto scacchiera

 * array di puntatori a pedina che calcola potenziale a ogni mossa.

 * funzione setSoffio=0/1

 * creazione classe PC e classe UTENTE

 * lista mosse per IA

 * 

 for(y=0;y<3;y++){ array pedine, i=pedine

 	for(x=0;x<7;x+=2){

 		arr[i++]=scacchiera[x][y];

 	}

 }*/

