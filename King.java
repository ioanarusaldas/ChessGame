
public class King extends Piece{

	public King() {
		super();
		// TODO Auto-generated constructor stub
	}

	public King(String name, String color, Position position) {
		super(name, color, position);
		// TODO Auto-generated constructor stub
	}
    public String[] legalMoves(Board board, String opponentColor) {
        String[] moves = new String[8];
        char x = getPosition().getX();
        char y = getPosition().getY();
        int pos1 = Integer.parseInt(String.valueOf(y)) ;
        int pos2 = x - 97;
        int index = 0;
        //System.out.println("x= "+x+"y= "+y);
        //System.out.println((x >= 'b')  );
        //System.out.println ((y <= '7'));

        if (y >= '2') { //in fata
            // System.out.println("in fata");
            if ((board.board[pos1 - 2][pos2] == null)) {
               // System.out.println("null");
                if(sah( board,  opponentColor, pos1 - 1, pos2) == false) {
                  //  System.out.println("nu ma pun in sah");
                    moves[index] = "" + x + y + (char) (pos2 + 97) +  (pos1 - 1)+"\n";
                    index ++;
                }
            }
            if((board.board[pos1 - 2][pos2] != null)&&(board.board[pos1 - 2][pos2].getColor().equals(opponentColor))){
                if(sah( board,  opponentColor, pos1 -1, pos2) == false) {
                    moves[index] = "" + x + y + (char) (pos2 + 97) +  (pos1 - 1)+"\n";
                    index++;
                }
            }

            
        }

        if (y <= '7') { //in spate 
           // System.out.println("in spate");
            if ((board.board[pos1][pos2] == null)) {
               // System.out.println("null");
                if(sah( board,  opponentColor, pos1 + 1, pos2) == false) {
                  //  System.out.println("nu ma pun in sah");
                    moves[index] = "" + x + y + (char) (pos2 + 97) +  (pos1 + 1)+"\n";
                    index ++;
                }
            }
            if((board.board[pos1][pos2] != null)&&(board.board[pos1][pos2].getColor().equals(opponentColor))){
              //  System.out.println(" diferit null");
                if(sah( board,  opponentColor, pos1 + 1, pos2) == false) {
                    moves[index] = "" + x + y + (char) (pos2 + 97) +  (pos1 + 1)+"\n";
                    index++;
                }        
            } 

        }
        if (x >= 'b') { //in stanga
           // System.out.println("in stanga");
            if ((board.board[pos1-1][pos2 - 1] == null)) {
              // System.out.println("null");

                if(sah( board,  opponentColor, pos1, pos2 - 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 - 1) + 97) +  pos1 +"\n";
                    index ++;
                }
            } 
            if((board.board[pos1-1][pos2 - 1] != null)&&(board.board[pos1 - 1][pos2 - 1].getColor().equals(opponentColor))){
                if(sah( board,  opponentColor, pos1, pos2 - 1) == false) {
              //  System.out.println(" diferit null");
                    moves[index] = "" + x + y + (char) ((pos2 - 1) + 97) +  pos1 +"\n";
                    index++;
                }
            }         
        }
        if (x <= 'g') { //in dreapta
            //System.out.println("in dreapta");
            if ((board.board[pos1 - 1][pos2 + 1] == null)) {
              // System.out.println("null");
                if(sah( board,  opponentColor, pos1, pos2 + 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 + 1) + 97) +  pos1 +"\n";
                    index ++;
                }
            } 
            if((board.board[pos1 - 1][pos2 + 1] != null)&&(board.board[pos1 - 1][pos2 + 1].getColor().equals(opponentColor))){
               // System.out.println(" diferit null");
                if(sah( board,  opponentColor, pos1, pos2 + 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 + 1) + 97) +  pos1 +"\n";
                    index++;
                }
                    
            } 
        }
        if ((x >= 'b') && (y >= '2') ){ //diagonala stanga sus(intern) stanga jos (extern)
           //System.out.println("stanga jos");
            if ((board.board[pos1 - 2][pos2 - 1] == null)) {
                if(sah( board,  opponentColor, pos1 - 1, pos2 - 1) == false) {
                //System.out.println("null");
                    moves[index] = "" + x + y + (char) ((pos2 - 1) + 97) +  (pos1 - 1) +"\n";
                    index ++;
                 }
            } 
            if((board.board[pos1 - 2][pos2 - 1] != null)&&(board.board[pos1 - 2][pos2 - 1].getColor().equals(opponentColor))){
                //System.out.println(" diferit null");
                if(sah( board,  opponentColor, pos1 - 1, pos2 - 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 - 1) + 97) +  (pos1 - 1) +"\n";
                    index++;
                }   
            } 
        }


        if ((x >= 'b') && (y <= '7') ){ //diagonala stanga jos(intern)
          //  System.out.println("stanga sus");
            if ((board.board[pos1 ][pos2 - 1] == null)) {
                if(sah( board,  opponentColor, pos1 + 1, pos2 - 1) == false) {
             //   System.out.println("null");
                    moves[index] = "" + x + y + (char) ((pos2 - 1) + 97) +  (pos1 + 1) +"\n";
                    index ++;
                }
            } 
            if((board.board[pos1][pos2 - 1] != null)&&(board.board[pos1 ][pos2 - 1].getColor().equals(opponentColor))){
            //    System.out.println(" diferit null");
                if(sah( board,  opponentColor, pos1 + 1, pos2 - 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 - 1) + 97) +  (pos1 + 1) +"\n";
                    index++;
                }    
            } 
        }

        if ((x <= 'g') && (y >= '2') ){ //diagonala dreapta sus(intern)
           // System.out.println("dreapta jos");
            if ((board.board[pos1 - 2][pos2 + 1] == null)) {
              // System.out.println("null");
                if(sah( board,  opponentColor, pos1 - 1, pos2 + 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 + 1) + 97) +  (pos1 - 1) +"\n";
                    index ++;
                }
            } 
            if((board.board[pos1 - 2][pos2 + 1] != null)&&(board.board[pos1 - 2][pos2 + 1].getColor().equals(opponentColor))){
                if(sah( board,  opponentColor, pos1 - 1, pos2 + 1) == false) {
              //  System.out.println("diferit null");
                    moves[index] = "" + x + y + (char) ((pos2 + 1) + 97) +  (pos1 - 1) +"\n";
                    index++;
                }
                    
            } 
        }
        if ((x <= 'g') && (y <= '7') ){ //diagonala dreapta jos(intern)
           // System.out.println("dreapta sus");
            if ((board.board[pos1][pos2 + 1] == null)) {
                if(sah( board,  opponentColor, pos1 + 1, pos2 + 1) == false) {
               // System.out.println("null");
                    moves[index] = "" + x + y + (char) ((pos2 + 1) + 97) +  (pos1 + 1) +"\n";
                    index ++;
                }
            } 
            if((board.board[pos1 ][pos2 + 1] != null)&&(board.board[pos1 ][pos2 + 1].getColor().equals(opponentColor))){
             //   System.out.println("diferit null");
                if(sah( board,  opponentColor, pos1 + 1, pos2 + 1) == false) {
                    moves[index] = "" + x + y + (char) ((pos2 + 1) + 97) +  (pos1 + 1) +"\n";
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
    


public Boolean sahFromKnight(Board board, String opponentColor,int pos1, int pos2) {
    int a,b;

        a = pos1 - 3;
        b = pos2 - 1;

        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 - 3][pos2 - 1] != null) && (board.board[pos1 - 3][pos2 - 1].getColor().equals(opponentColor)) && 
            (board.board[pos1 - 3][pos2 - 1].getName().equals("knight")))//sus stanga
            return true;
        a = pos1 - 3;
        b = pos2 + 1;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 - 3][pos2 + 1] != null) && (board.board[pos1 - 3][pos2 + 1].getColor().equals(opponentColor)) && 
            (board.board[pos1 - 3][pos2 + 1].getName().equals("knight")))//sus dreapta
            return true;
        a = pos1 - 2;
        b = pos2 - 2;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 - 2][pos2 - 2] != null) && (board.board[pos1 - 2][pos2 - 2].getColor().equals(opponentColor)) && 
            (board.board[pos1 - 2][pos2 - 2].getName().equals("knight")))//lateral stanga sus
            return true;
        a = pos1;
        b = pos2 - 2;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 ][pos2 - 2] != null) && (board.board[pos1 ][pos2 - 2].getColor().equals(opponentColor)) && 
            (board.board[pos1 ][pos2 - 2].getName().equals("knight")))//lateral stanga jos
            return true;
        a = pos1 - 2;
        b = pos2 + 2;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 - 2][pos2 + 2] != null) && (board.board[pos1 - 2][pos2 + 2].getColor().equals(opponentColor)) && 
            (board.board[pos1 - 2][pos2 + 2].getName().equals("knight")))//lateral dreapta sus
            return true;
        a = pos1;
        b = pos2 + 2;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 ][pos2 + 2] != null) && (board.board[pos1 ][pos2 + 2].getColor().equals(opponentColor)) && 
            (board.board[pos1 ][pos2 + 2].getName().equals("knight")))//lateral dreapta jos
            return true;
        a = pos1 + 1;
        b = pos2 - 1;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 + 1][pos2 - 1] != null) && (board.board[pos1 + 1][pos2 - 1].getColor().equals(opponentColor)) && 
            (board.board[pos1 + 1][pos2 - 1].getName().equals("knight")))//jos stanga
            return true;
        a = pos1 + 1;
        b = pos2 + 1;
        if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
            (board.board[pos1 + 1][pos2 + 1] != null) && (board.board[pos1 + 1][pos2 + 1].getColor().equals(opponentColor)) && 
            (board.board[pos1 + 1][pos2 + 1].getName().equals("knight")))//jos dreapta
            return true;
    return false;
}
public Boolean sahFromPawn(Board board, String opponentColor,int pos1, int pos2) {
        int a, b;


        if(opponentColor.equals("white")) {
            a = pos1 - 2;
            b = pos2 - 1;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[pos1 - 2][pos2 - 1] != null) && (board.board[pos1 - 2][pos2 - 1].getColor().equals(opponentColor)) && 
                (board.board[pos1 - 2][pos2 - 1].getName().equals("pawn")))
                return true;
            a = pos1 - 2;
            b = pos2 + 1;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[pos1 - 2][pos2 + 1] != null) && (board.board[pos1 - 2][pos2 + 1].getColor().equals(opponentColor)) && 
                (board.board[pos1 - 2][pos2 + 1].getName().equals("pawn")))
                return true;

        }

        if(opponentColor.equals("black")) {
            a = pos1 ;
            b = pos2 - 1;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[pos1][pos2 - 1] != null) && (board.board[pos1 ][pos2 - 1].getColor().equals(opponentColor)) && 
                (board.board[pos1][pos2 - 1].getName().equals("pawn")))
                return true;
            a = pos1 ;
            b = pos2 + 1;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[pos1][pos2 + 1] != null) && (board.board[pos1 ][pos2 + 1].getColor().equals(opponentColor)) && 
                (board.board[pos1][pos2 + 1].getName().equals("pawn")))
                return true;

        }
        return false;


}
public Boolean sahFromRook(Board board, String opponentColor,int pos1, int pos2, String type,int x) {
    int a, b;
    System.out.println("sahFromRook " + type);
    for (int i = pos1-2; i >= 0; i--) {//deasupra
            a = i;
            b = pos2;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[i][pos2 ] != null) && (board.board[i ][pos2].getColor().equals(opponentColor)) && 
                (board.board[i][pos2].getName().equals(type))) {
               // System.out.println("tura "+"a= "+a+"b="+b);
                return true;
            } 
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7) &&
                (board.board[i][pos2 ] != null) && (board.board[i][pos2].getColor().equals(opponentColor) == false)  ) {
               // System.out.println("tura break "+"a= "+a+"b="+b);
                break;
            } 
            // System.out.println("------");

    }

    for (int i = pos1; i <= 7; i++) {//sub
            a = i;
            b = pos2;

            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7)&&
                (board.board[i][pos2] != null) && (board.board[i][pos2].getColor().equals(opponentColor)) && 
                (board.board[i][pos2].getName().equals(type))) {
              //  System.out.println("tura "+"a= "+a+"b="+b);
                return true;
             }
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7)&& 
                (board.board[i][pos2] != null) && (board.board[i][pos2].getColor().equals(opponentColor) == false)) {
               // System.out.println("tura break "+"a= "+a+"b="+b);
                break;
        }
    }

    for (int i = pos2 - 1; i >= 0; i--) {//stanga
            a = pos1 - 1;
            b = i;
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[pos1 - 1][i] != null) && (board.board[pos1 - 1][i].getColor().equals(opponentColor)) && 
                (board.board[pos1 - 1][i].getName().equals(type))) {

               // System.out.println("tura "+"a= "+a+"b="+b);
                return true;
            }
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[pos1 - 1][i] != null) &&  (board.board[pos1 - 1][i].getColor().equals(opponentColor) == false)){
                       //      System.out.println("tura break "+"a= "+a+"b="+b);
                break;
            }
           //  System.out.println("-------");
    }

    for (int i = pos2 + 1; i <= 7; i++) {//dreapta
            a = pos1 - 1;
            b = i;
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[pos1 - 1][i] != null) && (board.board[pos1 - 1][i].getColor().equals(opponentColor)) && 
                (board.board[pos1 - 1][i].getName().equals(type))) {
             //   System.out.println("tura "+"a= "+a+"b="+b);
                return true;
            }
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[pos1 - 1][i] != null) &&  (board.board[pos1 - 1 ][i].getColor().equals(opponentColor) == false)){
             //    System.out.println("tura break "+"a= "+a+"b="+b);
                break;
        }
         //System.out.println("----------");
    }
    return false;
}
public Boolean sahFromBishop(Board board, String opponentColor,int pos1, int pos2, String type) {
 
    int a = pos1 - 1;
    int b = pos2;
     //   System.out.println("sahFromBishops " + type);
    while ((a >= 0) && (b >= 0)) {//intern stanga sus //xboard stanga jos
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals(type))) {
            //System.out.println("bishop "+"a= "+a+"b="+b);
                return true;
        }
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) && 
                (board.board[a][b] != null) &&  (board.board[a][b].getColor().equals(opponentColor) == false))
                break;
        a--;
        b--;    
    }
    a = pos1 - 1;
    b = pos2;
    while ((a <= 7) && (b >= 0)) {//intern stanga jos
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals(type))) {
            //System.out.println("bishop "+"a= "+a+"b="+b);
                return true;}
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) && 
                (board.board[a][b] != null) &&  (board.board[a][b].getColor().equals(opponentColor) == false))
                break;
        a++;
        b--;    
    }
    a = pos1 - 1;
    b = pos2;
    while ((a >= 0) && (b <= 7)) { //intern dreapta sus //xboard dreapta jos
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals(type))) {
           // System.out.println("bishop "+"a= "+a+"b="+b);
                return true;
            }
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) &&   (board.board[a][b].getColor().equals(opponentColor) == false) )
                break;
        a--;
        b++;    
    }
    a = pos1 - 1;
    b = pos2;
    while ((a <= 7) && (b <= 7)) { //intern dreapta sus //xboard dreapta jos
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals(type))) {
           // System.out.println("bishop "+"a= "+a+"b="+b);

                return true;}
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) && 
                (board.board[a][b] != null) &&  (board.board[a][b].getColor().equals(opponentColor) == false) )
                break;
        a++;
        b++;    
    }
    return false;


}
public Boolean sahFromQueen(Board board, String opponentColor,int pos1, int pos2,int x) {
    if (sahFromBishop(board, opponentColor,pos1, pos2, "queen") == true)
        return true;
    if (sahFromRook(board, opponentColor,pos1, pos2, "queen",x) == true)
        return true;
    return false;
}
public Boolean sahFromKing(Board board, String opponentColor,int pos1, int pos2) {
    int a, b;
    
            a = pos1 - 2;
            b = pos2;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[a][pos2 ] != null) && (board.board[a][pos2].getColor().equals(opponentColor)) && 
                (board.board[a][pos2].getName().equals("king"))) {
                return true;
            } 
    
            a = pos1;
            b = pos2;
            if ((a >= 0)&& (a <= 7) && (b >=0) && (b <= 7)&&
                (board.board[a][pos2 ] != null) && (board.board[a][pos2].getColor().equals(opponentColor)) && 
                (board.board[a][pos2].getName().equals("king"))) {
                return true;
            } 
   
            a = pos1 - 1;
            b = pos2 - 1;
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[pos1 - 1][b] != null) && (board.board[pos1 - 1][b].getColor().equals(opponentColor)) && 
                (board.board[pos1 - 1][b].getName().equals("king")))
                return true;
    
            a = pos1 - 1;
            b = pos2 + 1;
            if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[pos1 - 1][b] != null) && (board.board[pos1 - 1][b].getColor().equals(opponentColor)) && 
                (board.board[pos1 - 1][b].getName().equals("king")))
                return true;

        a = pos1 - 1;
        b = pos2;
    
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals("king")))
                return true;

        a = pos1 - 1;
        b = pos2;
    
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals("king")))
                return true;

        a = pos1 - 1;
        b = pos2;
    
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals("king")))
                return true;

        a = pos1 - 1;
        b = pos2;
    
        if ((a >= 0)&& (a <= 7) && (b >= 0) && (b <= 7) &&
                (board.board[a][b] != null) && (board.board[a][b].getColor().equals(opponentColor)) && 
                (board.board[a][b].getName().equals("king")))
                return true;

    return false;
    
}
public Boolean sah (Board board, String opponentColor,int pos1, int pos2) {
    if(sahFromKnight(board,opponentColor,pos1,pos2))
        return true;
    if(sahFromPawn(board,opponentColor,pos1,pos2))
        return true;
    if(sahFromRook(board,opponentColor,pos1,pos2,"rook",1)){
        return true;
    }
    if(sahFromBishop(board,opponentColor,pos1,pos2,"bishop"))
        return true;
    if(sahFromQueen(board,opponentColor,pos1,pos2,0)) {
        return true;
    }
    if(sahFromKing(board,opponentColor,pos1,pos2))
        return true;
    return false;
}
}
    
	


