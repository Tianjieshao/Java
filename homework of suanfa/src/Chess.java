public class Chess {
	public static int tile;
	int[][] Board = new int[8][8]; 
	public static void main(String[] args) {
	   Chess chess = new Chess();	
	   chess.ChessBoard(0,0,5,5,8);
	   for(int i=0;i<8;i++) {
		  for(int j=0;j<8;j++)
		  {
			  System.out.printf("%4d",chess.Board[i][j]);
		  }  
		  System.out.println();  
	   }
	   System.out.println("覆盖完成后用的L形块的数量是："+tile);
	} 
	public void ChessBoard(int tr, int tc,int dr,int dc,int size){
		if(size == 1) {
			return ;
		}
		int t = tile++ ,s = size/2;
		if(dr<tr+s&&dc<tc+s) {
			ChessBoard(tr,tc,dr,dc,s);
		}
		else {
			Board[tr+s-1][tc+s-1] = t;
			ChessBoard(tr,tc,tr+s-1,tc+s-1,s);
		}
		if(dr<tr+s&&dc>=tc+s) {
			ChessBoard(tr,tc+s,dr,dc,s);
		}
		else {
			Board[tr+s-1][tc+s] = t;
			ChessBoard(tr,tc+s,tr+s-1,tc+s,s);
		}
		if(dr>=tr+s&&dc<tc+s) {
			ChessBoard(tr+s,tc,dr,dc,s);
		}
		else {
			Board[tr+s][tc+s-1] = t;
			ChessBoard(tr+s,tc,tr+s,tc+s-1,s);
		}
		if(dr>=tr+s&&dc>=tc+s) {
			ChessBoard(tr+s,tc+s,dr,dc,s);
		}
		else {
			Board[tr+s][tc+s] = t;
			ChessBoard(tr+s,tc+s,tr+s,tc+s,s);
		}
		
		
	}
	
	
	
}
