
import java.util.*;

public class Pawn extends Piece {

	public Pawn() {

	}

	public Pawn(String name, String color, Position position) {
		super(name, color, position);
	}
    public Boolean kingInDanger(Board board,String opponentColor,String move,King king){
        Board cloneBoard =  board.copyBoard();
        int pos1K = Integer.parseInt(String.valueOf(king.getPosition().getY()));
        int pos2K = king.getPosition().getX() - 97;
        cloneBoard.updateBoard(move, "black","pawn");
                              
                   
        return king.sah(cloneBoard,opponentColor,pos1K,pos2K);
    }
	//legalMovesForBlackBot genereaza mutarile valide pentru bot-ul de culoare neagra
	public String[] legalMovesForBlackBot(Board board) {
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

		String[] moves = new String[4];
		char x = getPosition().getX();
		char y = getPosition().getY();
		int pos1 = Integer.parseInt(String.valueOf(y));
		int pos2 = x - 97;
		int index = 0;

		if (getPosition().getY() == '7') {//se verifica daca pionul poate inainta 2 casute
                auxMove = "" + x + "7" + x + "5\n";
                if (kingInDanger(board,"white",auxMove,king) == false) {
        			if ((board.board[4][pos2] == null) && (board.board[5][pos2] == null) ){
        				moves[index] = "" + x + "7" + x + "5\n";
        				index++;
        			}
                }
		}

		if (pos1 > 1) {//se verifica daca pionul poate inainta
            auxMove = "" + x + y + x + (pos1 - 1) + "\n";
            if (kingInDanger(board,"white",auxMove,king) == false) {
    			if (board.board[pos1 - 2][pos2] == null) {
    				int ch = (pos1 - 1);
    				moves[index] = "" + x + y + x + ch + "\n";
    				index++;
    			}
            }
		}
		//se verifica daca pionul poate captura ce se afla pe diagonale
		if ((pos1 > 1) && (pos2 <= 6)) {
            auxMove = "" + x + y + (char) (pos2 + 1 + 97) + (pos1 - 1) + "\n";
            if (kingInDanger(board,"white",auxMove,king) == false) {
    			if (board.board[pos1 - 2][pos2 + 1] != null && board.board[pos1 - 2][pos2 + 1].getColor().equals("white")) {
    				int ch = (pos1 - 1);
    				moves[index] = "" + x + y + (char) (pos2 + 1 + 97) + ch + "\n";
    				index++;
    			}
            }
		}

		if ((pos1 > 1) && (pos2 >= 1)) {
            auxMove = "" + x + y + (char) (pos2 - 1 + 97) + (pos1 - 1) + "\n";
            if (kingInDanger(board,"white",auxMove,king) == false) {
    			if (board.board[pos1 - 2][pos2 - 1] != null && board.board[pos1 - 2][pos2 - 1].getColor().equals("white")) {
    				int ch = (pos1 - 1);
    				moves[index] = "" + x + y + (char) (pos2 - 1 + 97) + ch + "\n";
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
	//legalMovesForWhiteBot genereaza mutarile valide pentru bot-ul de culoare alba
	public String[] legalMovesForWhiteBot(Board board) {
		String[] moves = new String[4];
		char x = getPosition().getX();
		char y = getPosition().getY();
		int pos1 = Integer.parseInt(String.valueOf(y));

		int pos2 = x - 97;
		int index = 0;

		if (getPosition().getY() == '2') {//se verifica daca pionul iese din tabla
			if (board.board[3][pos2] == null) {
				moves[index] = "" + x + "2" + x + "4\n";
				index++;
			}
		}

		if (pos1 < 8) {//se verifica daca pionul poate inainta
			if (board.board[pos1][pos2] == null) {
				int ch = (pos1 + 1);
				moves[index] = "" + x + y + x + ch + "\n";
				index++;
			}
		}
		//se verifica daca pionul poate captura ce se afla pe diagonale
		if ((pos1 < 8) && (pos2 <= 6)) {
			if (board.board[pos1][pos2 + 1] != null && board.board[pos1][pos2 + 1].getColor().equals("black")) {
				int ch = (pos1 + 1);
				moves[index] = "" + x + y + (char) (pos2 + 1 + 97) + ch + "\n";
				index++;
			}
		}

		if ((pos1 < 8) && (pos2 >= 1)) {
			if (board.board[pos1][pos2 - 1] != null && board.board[pos1][pos2 - 1].getColor().equals("black")) {
				int ch = (pos1 + 1);
				moves[index] = "" + x + y + (char) (pos2 - 1 + 97) + ch + "\n";
				index++;
			}
		}

		String[] mutarivalide;
		if (index == 0) {
			mutarivalide = new String[1];
			mutarivalide[0] = "again";//daca nu exista mutari valide este intors stringul again
		} else {
			mutarivalide = new String[index];//se construieste vectorul de mutari valide
			int index2 = 0;
			for (String mutare : moves)
				if (mutare != null) {
					mutarivalide[index2] = mutare;
					index2++;
				}
		}

		return mutarivalide;

	}

}
