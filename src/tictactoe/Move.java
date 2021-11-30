package tictactoe;

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

    public class Move {
        int row;
        int col;
        int val;

        public Move (int v, int r, int c){
            val = v;
            row = r;
            col = c;
        }

        public Move (int v) {
            val = v;
            row = 0;
            col = 0;
        }


    }
