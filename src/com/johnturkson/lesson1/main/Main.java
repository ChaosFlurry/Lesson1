package com.johnturkson.lesson1.main;

import com.johnturkson.lesson1.model.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        Board board = new Board();
        // Game loop
        while (true) {
            if (!board.hasValidMove()) {
                System.out.println("It's a draw.");
                break;
            }
            // Human player goes first
            System.out.println("Player's move: ");
            // Assume the input was a valid integer
            int position = Integer.parseInt(reader.readLine());
            while(position >= 9 || position < 0) {
                System.out.println("Invalid Move!");
                position = Integer.parseInt(reader.readLine());
            }
            board.makeHumanMove(position);
            board.printBoard();
            if (board.hasWinner()) {
                System.out.println("Player wins.");
                break;
            }
    
            System.out.println("Computer's move: ");
            int computerLastMove = board.makeComputerMove();
            System.out.println(computerLastMove);
            board.printBoard();
            if (board.hasWinner()) {
                System.out.println("Computer wins.");
                break;
            }
        }
    }
}
