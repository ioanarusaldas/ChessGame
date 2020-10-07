
public class Rook extends Piece {

	public Rook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rook(String name, String color, Position position) {
		super(name, color, position);
		// TODO Auto-generated constructor stub
	}

    public Boolean kingInDanger(Board board,String opponentColor,String move,King king){
       Board cloneBoard =  board.copyBoard();
        int pos1K = Integer.parseInt(String.valueOf(king.getPosition().getY()));
        int pos2K = king.getPosition().getX() - 97;
        cloneBoard.updateBoard(move, "black","rook");
                 
        return king.sah(cloneBoard,opponentColor,pos1K,pos2K);
    }

    public String[] legalMoves(Board board, String opponentColor) {
        String[] moves = new String[14];
        char x = getPosition().getX();
        char y = getPosition().getY();
       
        int pos1 = Integer.parseInt(String.valueOf(y)) ;
        int pos2 = x - 97;
        String auxMove;
        King king = null;
            for(int i = 0; i < 8; i++) {
                int ok = 0;
                for(int j = 0; j < 8; j++) {

                    if((board.board[i][j] != null) && (board.board[i][j].getName().equals("king"))) {
                        king = (King) board.board[i][j];
                        ok = 1;
                        break;
                    }
                    if (ok == 1) {
                        break;
                    }
                }
            }


        //cloneBoard.updateBoard(auxMove, "black",pieces[random].getName());
      
        int index = 0;
        if (y >= '2') { //in fata
           
            
            for(int i = pos1 - 2; i >=0; i--) {
                    if ((board.board[i][pos2] == null)) { 
                        auxMove = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                        if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                            moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                            index ++;
                        }
                    }else {
                        if((board.board[i][pos2] != null)&&(board.board[i][pos2].getColor().equals(opponentColor))){
                            auxMove = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                                moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                                index++;
                               
                            }
                             break;
                        } else {
                            break;
                        }
                    }

                }
            
        }
        if (y <= '7') { //in spate 

            for(int i = pos1 ; i <=7; i++) {
               
                    if ((board.board[i][pos2] == null)) {
                        auxMove = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                        if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                            moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                            index ++;
                        }
                    }else{
                        if((board.board[i][pos2] != null)&&(board.board[i][pos2].getColor().equals(opponentColor))){
                            auxMove = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                                moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                                index++;
                                
                            }
                            break;
                        } else {
                            break;
                        }
                    }

                
            }
        }
        if (x >= 'b') { //in stanga
            for(int i = pos2 - 1 ; i >=0; i--) {
       
        
                if ((board.board[pos1-1][i] == null)) {
                    auxMove = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                    if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                        moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                        index ++;
                    }
                } else{
                    if((board.board[pos1-1][i] != null)&&(board.board[pos1 - 1][i].getColor().equals(opponentColor))){
                        auxMove = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                        if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                            moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                            index++;
                       
                        }
                        break;
                    } else {
                        break;
                    }
                }

                
            }
        }
        if (x <= 'g') { //in dreapta

            for(int i = pos2 + 1 ; i <= 6; i++) {
                    if ((board.board[pos1 - 1][i] == null)) {
                        auxMove = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                        if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                        moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                        index ++;
                    }
                    } else {
                        if((board.board[pos1 - 1][i] != null)&&(board.board[pos1 - 1][i].getColor().equals(opponentColor))){
                            auxMove = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                            moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                            index++;
                        
                            }
                            break;
                        } else {
                            break;
                        }
                    }
                

            }
        }




        String[] mutarivalide;
        if (index == 0) {//daca nu exista mutari valide este intors stringul again
            mutarivalide = new String[1];
            mutarivalide[0] = "again";
        } else {
            mutarivalide = new String[index];
            int index2 = 0;
            for (String mutare : moves)
                if (mutare != null) {
                    mutarivalide[index2] = mutare;//se construieste vectorul de mutari valide
                    index2++;
                }
        }
       

        return mutarivalide;
    }
	
}
