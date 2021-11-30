package tictactoe;

import java.util.Random;

    /**
     * Überschrift:   Recursive Example
     * Beschreibung:
     * Copyright:     Based on the TicTacToe game of Mark Allen Weiss
     *                from the book "Algorithms and Data Structures in Java"
     *                Copyright (c) 2003
     * Organisation:
     * @author        Mark Allen Weiss
     *                Changes by Debora Weber-Wulff
     * @version 1.0
     */

    public class TicTacToe {

        public static final int EMPTY    = 0;
        public static final int HUMAN    = 1;
        public static final int COMPUTER = 2;

        public static final int HUMAN_WIN    = 4;
        public static final int COMPUTER_WIN = 7;
        public static final int DRAW         = 5;
        public static final int CONTINUE     = 6;


        public static final int SIZE = 3;
        private int[][] board = new int[SIZE][SIZE];
        private static long count = 0;

        public TicTacToe() {
            clearBoard();
        }

        public void clearBoard(){
            for (int i=0; i<SIZE; i++)
                for (int j=0; j<SIZE; j++)
                    board[i][j] = EMPTY;
        }

        public void printBoard() {
            System.out.println("-------");
            for (int i=0; i<SIZE; i++) {
                System.out.print("|");
                for (int j=0; j<SIZE; j++)
                    System.out.print (board[i][j] + "|");
                System.out.println();
                System.out.println("-------");
            }

        }

        public boolean boardIsFull(){
            for (int i=0; i<SIZE; i++)
                for (int j=0; j<SIZE; j++)
                    if (board[i][j] == EMPTY) return false;

            return true;
        }

        private int evaluatePosition (){
            return isAWin (COMPUTER)? COMPUTER_WIN :
                    isAWin (HUMAN)?    HUMAN_WIN :
                            boardIsFull() ?    DRAW : CONTINUE;

        }

        private boolean isAWin (int side){
            // only works for 3 right now, there are only 8 win situations
            boolean winner = false;
            // across top
            if ((board[0][0] == side)&&(board[0][1]==side)&&(board[0][2]==side))
                winner = true;
            // diagonal left to right
            if ((board[0][0] == side)&&(board[1][1]==side)&&(board[2][2]==side))
                winner = true;
            // down left side
            if ((board[0][0] == side)&&(board[1][0]==side)&&(board[2][0]==side))
                winner = true;
            // diagonal right to left
            if ((board[0][2] == side)&&(board[1][1]==side)&&(board[2][0]==side))
                winner = true;
            // across middle
            if ((board[1][0] == side)&&(board[1][1]==side)&&(board[1][2]==side))
                winner = true;
            // down middle
            if ((board[0][1] == side)&&(board[1][1]==side)&&(board[2][1]==side))
                winner = true;
            // across bottom
            if ((board[2][0] == side)&&(board[2][1]==side)&&(board[2][2]==side))
                winner = true;
            // down right side
            if ((board[0][2] == side)&&(board[1][2]==side)&&(board[2][2]==side))
                winner = true;

            return winner;
        }

        private void place (int row, int col, int piece){
            board [row][col] = piece;
        }

        private boolean squareIsEmpty (int row, int col) {
            return board [row][col] == EMPTY;
        }

        public Move chooseMove (int side) {

            int opp;      // The other side
            Move reply;   // Opponent's best reply
            int eval;     // Result of evaluatePosition
            int bestRow = 0;
            int bestCol = 0;
            int value;

            count++; // how often does this method get called?

            eval = evaluatePosition();

            if (eval != CONTINUE) return new Move (eval);

            opp   = (side==HUMAN)?COMPUTER:HUMAN;
            value = (side==HUMAN)?COMPUTER_WIN:HUMAN_WIN;

            for (int row = 0; row < SIZE; row++){
                for (int col = 0; col < SIZE; col++){
                    if (squareIsEmpty(row,col)){
                        place (row, col, side);
                        reply = chooseMove (opp);
                        place (row, col, EMPTY);

                        // update if better!
                        if (side == COMPUTER && reply.val > value ||
                                side == HUMAN    && reply.val < value) {
                            value   = reply.val;
                            bestRow = row;
                            bestCol = col;
                        }
                    }
                }

            }
            return new Move (value, bestRow, bestCol);
        }

        public static void main (String [] args){

            TicTacToe ttt = new TicTacToe();

  /*
  Random r = new Random();
  int row = r.nextInt(SIZE);
  int col = r.nextInt(SIZE);
  System.out.println("HUMAN moves to " + row + ", " + col);
  ttt.place(row, col, HUMAN);
  ttt.printBoard();
 */

            while (!ttt.boardIsFull()){
                Move nextC = ttt.chooseMove (COMPUTER);
                System.out.println("COMPUTER moves to "+ nextC.row + ", " + nextC.col
                        + " after " + count + " steps.");
                ttt.place (nextC.row, nextC.col, COMPUTER);
                ttt.printBoard();

                Move nextH = ttt.chooseMove (HUMAN);
                System.out.println("HUMAN moves to "+ nextH.row + ", " + nextH.col
                        + " after " + count + " steps.");
                ttt.place (nextH.row, nextH.col, HUMAN);
                ttt.printBoard();
            }

            switch (ttt.evaluatePosition()) {
                case COMPUTER_WIN : System.out.println ("COMPUTER wins"); break;
                case HUMAN_WIN    : System.out.println ("HUMAN wins");    break;
                case DRAW         : System.out.println ("DRAW");
            }
        }

    }
