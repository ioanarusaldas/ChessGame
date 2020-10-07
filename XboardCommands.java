import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;
import java.util.Arrays;


public class XboardCommands {
	public Board board;

	public XboardCommands() {
		this.board = new Board();
	}

	public XboardCommands(Board board) {
		this.board = board;
	}

	public void startGame(String botColor) {
		board.configBoard(botColor);
	}

	 public String black(Piece piece) {

		String[] moves = null ;
		String legalMove = null;
        switch(piece.getName()) {
            case "pawn":
               moves = ((Pawn )piece).legalMovesForBlackBot(board);
              break;
            case "knight":
              moves = ((Knight)piece).legalMoves(board,"white");
              break;
            case "queen":
              moves = ((Queen )piece).legalMoves(board,"white");
              break;
            case "king":
              moves = ((King)piece).legalMoves(board,"white");
              break;
            case "bishop":
              moves = ((Bishop )piece).legalMoves(board,"white");
              break;
            case "rook":
             moves = ((Rook)piece).legalMoves(board,"white");
              break;
            default:
                break;
        }


           

		if (moves[0].equals("again") == true) {
			legalMove = "resign\n";
		} else {
			int nrmoves = new Random().nextInt(moves.length);
			legalMove = moves[nrmoves];
			board.updateBoard(legalMove, "black",piece.getName());
			legalMove = "move " + legalMove;
		}
		return legalMove;
	}
    public Piece [] generateBlackPieces() {
        Piece [] blackPieces = new Piece [16];
        for(int i = 0; i <= 7; i++) {
            blackPieces[i] = new Pawn();
            blackPieces[i] = (Pawn) board.board[6][i];
        }
        blackPieces[8] = (Rook) board.board[7][0];
        blackPieces[9] = (Knight) board.board[7][1];
        blackPieces[10] = (Bishop) board.board[7][2];
        blackPieces[11] = (Queen) board.board[7][3];
        blackPieces[12] = (King) board.board[7][4];
        blackPieces[13] = (Bishop) board.board[7][5];
        blackPieces[14] = (Knight) board.board[7][6];
        blackPieces[15] = (Rook) board.board[7][7];
        return blackPieces;
    }
    public String findType (String move) {
        int x = Integer.parseInt(String.valueOf(move.charAt(1))) - 1;
        int y = Integer.parseInt(String.valueOf(move.charAt(0) - 97));

        return  board.board[x][y].getName();
    }
    public Piece[] remove (Piece[] pieces,int index) {
        Piece[] newPieces = new Piece [pieces.length - 1];

        for(int i = 0; i < pieces.length - 1; i++){
            if ( i < index){
                newPieces[i] = pieces[i];
            } else {
                newPieces[i] = pieces[i+1];
            }
        }
      return newPieces;
    }
    public String chooseMove(Piece[] pieces) {
        int random, nr = pieces.length;
        String move;
      // Board cloneBoard = new Board();
      // String auxMove;

        random = new Random().nextInt(nr);

       // move = "resign1\n";
       //  for(int j = 0 ; j< pieces.length;j++)
       //      if(pieces[j].getName().equals("king")) {
       //          System.out.println("am ales rege");
       //          move =  black(pieces[j]);
       //      }
        
        move =  black(pieces[random]);
        while((move.equals("resign\n")) && (nr > 0)) {
            pieces = remove(pieces,random);
            nr--;
            random = new Random().nextInt(nr);
            if(pieces[random].getName().equals("king")) {
                continue;
            }
            move =  black(pieces[random]);
        }
        return move;

    }
    public int getIndex(String move, Piece[] pieces) {
        for(int i = 0; i < pieces.length; i++) {
            if ((move.charAt(5) == pieces[i].getPosition().getX())
                && (move.charAt(6) == pieces[i].getPosition().getY())) {
                return i;
            }
        }
        return -1;
    }


	// //newCommand reinitializeaza tabla interna si alege pionul de test
	// public Pawn newCommand(String color, int pos) {
	// 	Pawn pawn;
	// 	board = new Board();
	// 	startGame(color);
	// 	int random = new Random().nextInt(8);
	// 	pawn = (Pawn) board.board[pos][random];
	// 	return pawn;
	// }
    // public Knight newCommandKnight(String color, int pos) {
    //     Knight knight;
    //     board = new Board();
    //     startGame(color);
    //     int random = new Random().nextInt(2);
    //     if(random == 0)
    //         knight = (Knight) board.board[pos][1];
    //     else 
    //         knight = (Knight) board.board[pos][6];
    //     return knight;
    // }
	//xboardCommand configureaza tabla si seteaza bot-ul default pe negru
	// public Pawn xboardCommand() {
	// 	Pawn pawn;
	// 	startGame("black");
	// 	int random = new Random().nextInt(8);
	// 	pawn = (Pawn) board.board[6][random];
	// 	return pawn;
	// }
    public Knight xboardCommandKnight() {
        Knight knight;
        startGame("black");
        int random = new Random().nextInt(2);
        if(random == 0)
            knight = (Knight) board.board[7][1];
        else 
            knight = (Knight) board.board[7][6];
        return knight;
    }
    public Rook xboardCommandRook() {
        Rook rook;
        startGame("black");
        int random = new Random().nextInt(2);
        if(random == 0)
            rook = (Rook) board.board[7][0];
        else 
            rook = (Rook) board.board[7][7];
        return rook;
    }
    public Queen xboardCommandQueen() {
        Queen queen;
        startGame("black");
        
        queen = (Queen) board.board[7][3];
        return queen;
    }
    public Bishop xboardCommandBishop() {
        Bishop bishop;
        startGame("black");
        int random = new Random().nextInt(2);
        if(random == 0)
            bishop = (Bishop) board.board[7][2];
        else 
            bishop = (Bishop) board.board[7][5];
        return bishop;
}
 public King xboardCommandKing() {
        King king;
        startGame("black");
        
        king = (King) board.board[7][4];
        return king;
}




    public Piece currentPiece(String move, int pos1, int pos2) {
     Piece piece;
     int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
     int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
     piece = board.board[x][y];
     return piece;

    }

        //current Pawn actualizeaza pozitia pionului dupa o mutare
    public Knight currentKnight(String move, int pos1, int pos2) {
     Knight knight;
     int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
     int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
     knight = (Knight) board.board[x][y];
     return knight;

    }
    public Rook currentRook(String move, int pos1, int pos2) {
     Rook rook;
     int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
     int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
     rook = (Rook) board.board[x][y];
     return rook;

    }
    public Bishop currentBishop(String move, int pos1, int pos2) {
     Bishop bishop;
     int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
     int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
     bishop = (Bishop) board.board[x][y];
     return bishop;

    }
    public Queen currentQueen(String move, int pos1, int pos2) {
     Queen queen;
     int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
     int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
     queen = (Queen) board.board[x][y];
     return queen;

    }
    public King currentKing(String move, int pos1, int pos2) {
     King king;
     int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
     int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
     king = (King) board.board[x][y];
     return king;

    }

	//current Pawn actualizeaza pozitia pionului dupa o mutare
	// public Pawn currentPawn(String move, int pos1, int pos2) {
	// 	Pawn pawn;
	// 	int x = Integer.parseInt(String.valueOf(move.charAt(pos1))) - 1;
	// 	int y = Integer.parseInt(String.valueOf(move.charAt(pos2) - 97));
	// 	pawn = (Pawn) board.board[x][y];
	// 	return pawn;

	// }
	//pawnTaken verifica daca pionul a fost luat de catre adversar
	public Piece[] pieceTaken(Piece [] pieces) {
        int x,y;

        for (int i = 0; i < pieces.length; i++ ) {
            x = Integer.parseInt(String.valueOf(pieces[i].getPosition().getY())) - 1;
            y = Integer.parseInt(String.valueOf(pieces[i].getPosition().getX() - 97));
            if (board.board[x][y] != null && board.board[x][y].getColor().equals("white"))  {
                pieces = remove (pieces,i);
                break;
            }
        }
        return pieces;

	}
}