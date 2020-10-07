
public class Knight extends Piece {

	public Knight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Knight(String name, String color, Position position) {
		super(name, color, position);
		// TODO Auto-generated constructor stub
	}
    public Boolean kingInDanger(Board board,String opponentColor,String move,King king){
        Board cloneBoard =  board.copyBoard();
        int pos1K = Integer.parseInt(String.valueOf(king.getPosition().getY()));
        int pos2K = king.getPosition().getX() - 97;
        cloneBoard.updateBoard(move, "black","knight");
                   
        return king.sah(cloneBoard,opponentColor,pos1K,pos2K);
    }

    public String[] legalMoves(Board board, String opponentColor) {
        String[] moves = new String[8];
        char x = getPosition().getX();
        char y = getPosition().getY();

        int pos1 = Integer.parseInt(String.valueOf(y)) ;
        int pos2 = x - 97;

        int index = 0;
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

        if ((x != 'a') && (y >= '3')) {//sus 2 - 1 stanga 
            auxMove =  "" + x + y + (char) (pos2 - 1 + 97) + (pos1 - 2 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if (board.board[pos1 - 3][pos2 - 1] == null) {
                    
                    moves[index] = "" + x + y + (char) (pos2 - 1 + 97) + (pos1 - 2 )+"\n";
                    index++;
                }
            }
            auxMove =  "" + x + y + (char) (pos2 - 1 + 97) + (pos1 - 2 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 - 3][pos2 - 1] != null) && 
                                        (board.board[pos1 - 3][pos2 - 1].getColor().equals(opponentColor))) {
                    moves[index] = "" + x + y + (char) (pos2 - 1 + 97) + (pos1 - 2 )+"\n";
                    index++;
                }  
            }
        }

        if ((x != 'h') && (y >= '3')) {//sus 2 -dreapta 1
           auxMove =  "" + x + y + (char) (pos2 + 1 + 97) + (pos1 - 2 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 - 3][pos2 + 1] == null) || 
                    ((board.board[pos1 - 3][pos2 + 1] != null) && 
                        (board.board[pos1 - 3][pos2 + 1].getColor().equals(opponentColor)))) {
                    
                    moves[index] = "" + x + y + (char) (pos2 + 1 + 97) + (pos1 - 2 )+"\n";
                    index++;
                }
            }
        }

        if ((x != 'a') && (y <= '6')) {//2 jos - stanga 1
            auxMove =  "" + x + y + (char) (pos2 - 1 + 97) + (pos1 + 2 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 + 1][pos2 - 1] == null) || 
                    ((board.board[pos1 + 1][pos2 - 1] != null) && 
                        (board.board[pos1 + 1][pos2 - 1].getColor().equals(opponentColor)))) {
                    moves[index] = "" + x + y + (char) (pos2 - 1 + 97) + (pos1 + 2 )+"\n";
                    index++;
                }
            }
        } 
        if ((x != 'h') && (y <= '6')) {//2 jos - dreapta 1
            auxMove = "" + x + y + (char) (pos2 + 1 + 97) + (pos1 + 2 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 + 1][pos2 + 1] == null) || 
                    ((board.board[pos1 + 1][pos2 + 1] != null) && 
                        (board.board[pos1 + 1][pos2 + 1].getColor().equals(opponentColor)))) {
                    moves[index] = "" + x + y + (char) (pos2 + 1 + 97) + (pos1 + 2 )+"\n";
                    index++;
                }
            }
        }       
        if ((x >= 'c') && (y >= '2')) {//2 stanga - 1 sus
            auxMove = "" + x + y + (char) (pos2 - 2 + 97) + (pos1 - 1 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 - 2][pos2 - 2] == null) || 
                    ((board.board[pos1 - 2][pos2 - 2] != null) && 
                        (board.board[pos1 - 2][pos2 - 2].getColor().equals(opponentColor)))) {
                    moves[index] = "" + x + y + (char) (pos2 - 2 + 97) + (pos1 - 1 )+"\n";
                    index++;
                }
            }
        }
        if ((x >= 'c') && (y <= '7')) {//2 stanga - 1 jos
            auxMove = "" + x + y + (char) (pos2 - 2 + 97) + (pos1 + 1 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 ][pos2 - 2] == null) || 
                    ((board.board[pos1 ][pos2 - 2] != null) && 
                        (board.board[pos1 ][pos2 - 2].getColor().equals(opponentColor)))) {
                    moves[index] = "" + x + y + (char) (pos2 - 2 + 97) + (pos1 + 1 )+"\n";
                    index++;
                }
            }
        }
        if ((x <= 'f') && (y >= '2')) {//2 dreapta -1 sus
            auxMove = "" + x + y + (char) (pos2 + 2 + 97) +  (pos1 - 1 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 - 2][pos2 + 2] == null) || 
                    ((board.board[pos1 - 2][pos2 + 2] != null) && 
                        (board.board[pos1 - 2][pos2 + 2].getColor().equals(opponentColor)))) {
                    moves[index] = "" + x + y + (char) (pos2 + 2 + 97) +  (pos1 - 1 )+"\n";
                    index++;
                }
            }
        }
        if ((x <= 'f') && (y <= '7')) { //2 dreapta - 1 jos
            auxMove = "" + x + y + (char) (pos2 + 2 + 97) +  (pos1 + 1 )+"\n";
            if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[pos1 ][pos2 + 2] == null) || 
                    ((board.board[pos1 ][pos2 + 2] != null) && 
                        (board.board[pos1 ][pos2 + 2].getColor().equals(opponentColor)))) {
                    moves[index] = "" + x + y + (char) (pos2 + 2 + 97) +  (pos1 + 1 )+"\n";
                    index++;
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
