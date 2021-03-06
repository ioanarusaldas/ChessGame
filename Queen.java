
public class Queen extends Piece {

	public Queen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Queen(String name, String color, Position position) {
		super(name, color, position);
		// TODO Auto-generated constructor stub
	}
    public Boolean kingInDanger(Board board,String opponentColor,String move,King king){
        Board cloneBoard =  board.copyBoard();
        int pos1K = Integer.parseInt(String.valueOf(king.getPosition().getY()));
        int pos2K = king.getPosition().getX() - 97;
        cloneBoard.updateBoard(move, "black","queen");
                    
        return king.sah(cloneBoard,opponentColor,pos1K,pos2K);
    }
    public String[] legalMoves(Board board, String opponentColor) {
        String[] moves = new String[40];
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

        if (y >= '2') { //in fata
            for(int i = pos1 - 2; i >=0; i--) {
                auxMove =  "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {

                    if ((board.board[i][pos2] == null)) {
                        
                        moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                        index ++;
                    }else {
                        if((board.board[i][pos2] != null)&&(board.board[i][pos2].getColor().equals(opponentColor))){
                           
                            moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                            index++;
                            break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        if (y <= '7') { //in spate 
            for(int i = pos1 ; i <=7; i++) {
                auxMove =  "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                    if ((board.board[i][pos2] == null)) {
                        moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                        index ++;
                    }else{
                        if((board.board[i][pos2] != null)&&(board.board[i][pos2].getColor().equals(opponentColor))){
                            moves[index] = "" + x + y + (char) (pos2 + 97) +  (i + 1)+"\n";
                            index++;
                            break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        if (x >= 'b') { //in stanga
            for(int i = pos2 - 1 ; i >=0; i--) {
                auxMove = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                    if ((board.board[pos1-1][i] == null)) {
                        moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                        index ++;
                    } else{
                        if((board.board[pos1-1][i] != null)&&(board.board[pos1 - 1][i].getColor().equals(opponentColor))){
                            moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                            index++;
                            break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        if (x <= 'g') { //in dreapta
            for(int i = pos2 + 1 ; i <= 6; i++) {
                auxMove = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                    if ((board.board[pos1 - 1][i] == null)) {
                        moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                        index ++;
                    } else {
                        if((board.board[pos1 - 1][i] != null)&&(board.board[pos1 - 1][i].getColor().equals(opponentColor))){
                            moves[index] = "" + x + y + (char) (i + 97) +  pos1 +"\n";
                            index++;
                            break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        int line = pos1 -2;
        int column = pos2 -1;
        while ((line >= 0) && (column >= 0)) {//intern stanga sus //xboard stanga jos
                auxMove = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
                if ((board.board[line][column] == null)) {
                  
                    moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                    index ++;
                }else{
                    if((board.board[line][column] != null)&&(board.board[line][column].getColor().equals(opponentColor))){
                      
                        moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                        index++;
                        break;
                    } else {
                            break;
                    }

                }
            }
            column--;
            line--;

            
        }
        line = pos1;
        column = pos2 -1;
        while ((line <= 7) && (column >= 0)) {//intern stanga jos //xboard stanga sus
                auxMove = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
         
                if ((board.board[line][column] == null)) {
                   
                    moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                    index ++;
                }else{
                    if((board.board[line][column] != null)&&(board.board[line][column].getColor().equals(opponentColor))){
                       
                        moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                        index++;
                        break;
                    } else {
                            break;
                    }

                }
            }
            column--;
            line++;

            
        }
        line = pos1 - 2;
        column = pos2 + 1;
        while ((line >= 0) && (column <= 7)) {//intern dreapta sus //xboard dreapta jos
                auxMove = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
           
                if ((board.board[line][column] == null)) {
                  
                    moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                    index ++;
                }else{
                    if((board.board[line][column] != null)&&(board.board[line][column].getColor().equals(opponentColor))){
                     
                        moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                        index++;
                        break;
                    } else {
                            break;
                    }

                }
            }
            column++;
            line--;

            
        }
        line = pos1 ;
        column = pos2 +1;
        while ((line <= 7) && (column <= 7)) {//intern stanga sus //xboard stanga jos
                auxMove ="" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                if (kingInDanger(board,opponentColor,auxMove,king) == false) {
         
                    if ((board.board[line][column] == null)) {
                        
                        moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                        index ++;
                    }else{
                        if((board.board[line][column] != null)&&(board.board[line][column].getColor().equals(opponentColor))){
                         
                            moves[index] = "" + x + y + (char) (column + 97) +  (line + 1)+"\n";
                            index++;
                            break;
                        } else {
                                break;
                        }

                    }
                }
            column++;
            line++;

            
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
