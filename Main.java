import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String command = null;
		XboardCommands xboard = null;
		String move = "", bot = "black", playingColor = "white";
        int random;
        Piece piece;
        Piece [] blackPieces = null;
           

		while (true) {
			command = reader.readLine();

			if (command.equals("quit") == true) {
				System.exit(0);//inchidere program
			}
			if (command.equals("xboard") == true) {
                xboard = new XboardCommands();
                xboard.startGame("black");
                blackPieces = xboard.generateBlackPieces();
			}

			if (command.equals("protover 2")) {
				String command3 = "feature sigint=0 done=1\n";
				out.write(command3);
				out.flush();
			}
			//in cazul in care bot-ul joaca cu piesele albe se alege un alt pion
			//apoi se calculaeaza o mutare valida pentru alb si se executa prin afisare la stdout
			//currentPawn actualizeaza pozitia pionului de test
			if (((command.charAt(0) <= 'h' && command.charAt(0) >= 'a')
					&& (command.charAt(1) <= '8' && command.charAt(1) >= '1')
					&& (command.charAt(2) <= 'h' && command.charAt(2) >= 'a')
					&& (command.charAt(3) <= '8' && command.charAt(3) >= '1'))) {
                if (bot.equals("white")) {
                    playingColor = "white";
                    xboard.board.updateBoard(command, "black",xboard.findType(command));
                    //blackPieces = xboard.pieceTaken(blackPieces);
                }
                //daca bot-ul este negru in acest if se actualizeaza tabla dupa mutarea adversarului
                if (bot.equals("black")) {
                    playingColor = "black";
                    xboard.board.updateBoard(command, "white",xboard.findType(command));
                    blackPieces = xboard.pieceTaken(blackPieces);
                }
                if (bot.equals("white")) {
                    playingColor = "black";
                } else {
                    playingColor = "white";
                    move = xboard.chooseMove(blackPieces);
                }
                if (move.equals("resign\n") == false){//e7e5
                    random = xboard.getIndex(move,blackPieces);
                    blackPieces[random] = xboard.currentPiece(move,8, 7);
                }
                out.write(move);
                out.flush();
            }

            if (command.equals("force") == true) {
                command = reader.readLine();
                if (command.equals("analyze") == false) {
                    continue;
                }
                while (command.equals("go") == false) {
                    if (((command.charAt(0) <= 'h' && command.charAt(0) >= 'a')
                            && (command.charAt(1) <= '8' && command.charAt(1) >= '1')
                            && (command.charAt(2) <= 'h' && command.charAt(2) >= 'a')
                            && (command.charAt(3) <= '8' && command.charAt(3) >= '1'))) {
                        //se verifica ce culoare se afla la mutare si se actualizeaza tabla
                        if (playingColor.equals("white")) {
                            xboard.board.updateBoard(command, "white",xboard.findType(command));
                            playingColor = "black";
                        } else {
                            xboard.board.updateBoard(command, "black",xboard.findType(command));
                            playingColor = "white";
                        }
                        //se actualizeaza pozitia pionului de test daca acesta a fost mutat
                        for (int i = 0 ; i < blackPieces.length ; i++) {//e5e6
                            if ((command.charAt(0) == blackPieces[i].getPosition().getX())
                                 && (command.charAt(1) == blackPieces[i].getPosition().getY())) {
                               // if (move.equals("resign\n") == false)
                                   // System.out.println("inainte "+blackPieces[i].getName()+" "+blackPieces[i].getPosition().getX()+" "+blackPieces[i].getPosition().getY());
                                    blackPieces[i] = xboard.currentPiece(command,3, 2);
                                    //System.out.println("dupa "+blackPieces[i].getName()+" "+blackPieces[i].getPosition().getX()+" "+blackPieces[i].getPosition().getY());
                            }
                        }
                    }
                    blackPieces = xboard.pieceTaken(blackPieces);
                    command = reader.readLine();

                }
                if (command.equals("go")) {
                    move = xboard.chooseMove(blackPieces);
                    playingColor = "white";
                    if (move.equals("resign\n") == false){
                        random = xboard.getIndex(move,blackPieces);
                        blackPieces[random] = xboard.currentPiece(move, 8, 7);
                    }
                    out.write(move);
                    out.flush();
                }

            }
                // for(int i = 0; i < 8; i++) {
                //     for(int j = 0; j < 8; j++) {
                //         if(xboard.board.board[i][j]!= null) {
                //             System.out.print(xboard.board.board[i][j].getName()+" "+xboard.board.board[i][j].getPosition().x+xboard.board.board[i][j].getPosition().y+" "+xboard.board.board[i][j].getColor()+" ");
                //     }
                //     else{
                //         System.out.print(xboard.board.board[i][j]+" ");
                //     }
                   
                // }
                //     System.out.println();   
                // }
                //  System.out.println();   

	   }
    }
}