
public class Board {

	public Piece[][] board;

	public Board() {
		this.board = new Piece[8][8];
	}
	//configBoard realizeaza configurarea tablei in functie de culoarea bot-ului
	public void configBoard(String botColor) {
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn("pawn", "white", new Position((char) (i + 97), '2'));
			board[6][i] = new Pawn("pawn", "black", new Position((char) (i + 97), '7'));
		}

		board[0][0] = new Rook("rook", "white", new Position((char) (0 + 97), '1'));
		board[0][7] = new Rook("rook", "white", new Position((char) (7 + 97), '1'));

		board[0][1] = new Knight("knight", "white", new Position((char) (1 + 97), '1'));
		board[0][6] = new Knight("knight", "white", new Position((char) (6 + 97), '1'));

		board[0][2] = new Bishop("bishop", "white", new Position((char) (2 + 97), '1'));
		board[0][5] = new Bishop("bishop", "white", new Position((char) (5 + 97), '1'));

		if (botColor.equals("white") == true) {
			board[0][4] = new Queen("queen", "white", new Position((char) (4 + 97), '1'));
			board[0][3] = new King("king", "white", new Position((char) (3 + 97), '1'));

			board[7][4] = new Queen("queen", "black", new Position((char) (4 + 97), '8'));
			board[7][3] = new King("king", "black", new Position((char) (3 + 97), '8'));
		} else {
			board[0][3] = new Queen("queen", "white", new Position((char) (3 + 97), '1'));
			board[0][4] = new King("king", "white", new Position((char) (4 + 97), '1'));

			board[7][3] = new Queen("queen", "black", new Position((char) (3 + 97), '8'));
			board[7][4] = new King("king", "black", new Position((char) (4 + 97), '8'));
		}

		board[7][0] = new Rook("rook", "black", new Position((char) (0 + 97), '8'));
		board[7][7] = new Rook("rook", "black", new Position((char) (7 + 97), '8'));

		board[7][1] = new Knight("knight", "black", new Position((char) (1 + 97), '8'));
		board[7][6] = new Knight("knight", "black", new Position((char) (6 + 97), '8'));

		board[7][2] = new Bishop("bishop", "black", new Position((char) (2 + 97), '8'));
		board[7][5] = new Bishop("bishop", "black", new Position((char) (5 + 97), '8'));
	}
    public Board copyBoard() {
        Board clone = new Board();
        for( int i = 0 ; i < 8;i++) {
            for(int j = 0; j< 8; j++) {
                clone.board[i][j] = board[i][j];

            }
        }
        return clone;
    }











	//updateBoard actualizeaza tabla in functie de miscarea primita si culoarea piesei
	public void updateBoard(String move, String color,String type) {
		char x = move.charAt(0);
		char y = move.charAt(1);
		char newX = move.charAt(2);
		char newY = move.charAt(3);
        switch(type) {
            case "pawn":
		      board[Integer.parseInt(String.valueOf(newY)) - 1][(int) (newX - 97)] = new Pawn("pawn", color,new Position(newX, newY));
              break;
            case "knight":
              board[Integer.parseInt(String.valueOf(newY)) - 1][(int) (newX - 97)] = new Knight("knight", color,new Position(newX, newY));
              break;
            case "queen":
              board[Integer.parseInt(String.valueOf(newY)) - 1][(int) (newX - 97)] = new Queen("queen", color,new Position(newX, newY));
              break;
            case "king":
              board[Integer.parseInt(String.valueOf(newY)) - 1][(int) (newX - 97)] = new King("king", color,new Position(newX, newY));
              break;
            case "bishop":
              board[Integer.parseInt(String.valueOf(newY)) - 1][(int) (newX - 97)] = new Bishop("bishop", color,new Position(newX, newY));
              break;
            case "rook":
              board[Integer.parseInt(String.valueOf(newY)) - 1][(int) (newX - 97)] = new Rook("rook", color,new Position(newX, newY));
              break;
            default:
                break;
        }

		board[Integer.parseInt(String.valueOf(y)) - 1][(int) (x - 97)] = null;
	}

	//verifica daca regele se afla in Sah 
	//se considera regele in sah in momentul in care piesele aflate in jurul acestuia isi schimba culoarea
	public Boolean kingCheckMate(String color) {
		Boolean verify = false;
		//verifiacere piese albe
		if (color.equals("white") == true) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] != null && board[i][j].getName().equals("King")
							&& board[i][j].getColor().equals(color)) {
						if ((board[i + 1][j] != null
								&& board[i + 1][j].getColor().equals(board[i][j].getColor()) == false)
								|| (board[i + 1][j + 2] != null
										&& board[i + 1][j + 2].getColor().equals(board[i][j].getColor()) == false)
								|| (board[i][j] != null
										&& board[i][j].getColor().equals(board[i][j].getColor()) == false)
								|| (board[i][j + 2] != null
										&& board[i][j + 2].getColor().equals(board[i][j].getColor()) == false)) {
							verify = true;
						}

					}

				}

			}
		} else {//verificare piese negre
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] != null && board[i][j].getName().equals("King")
							&& board[i][j].getColor().equals(color)) {
						if ((board[i - 1][j + 1] != null
								&& board[i - 1][j + 1].getColor().equals(board[i][j].getColor()) == false)
								|| (board[i - 1][j - 1] != null
										&& board[i - 1][j - 1].getColor().equals(board[i][j].getColor()) == false)
								|| (board[i][j - 1] != null
										&& board[i][j - 1].getColor().equals(board[i][j].getColor()) == false)
								|| (board[i][j + 1] != null
										&& board[i][j + 1].getColor().equals(board[i][j].getColor()) == false)) {
							verify = true;
						}

					}

				}

			}

		}
		return verify;
	}

}
