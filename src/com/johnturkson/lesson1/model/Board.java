package com.johnturkson.lesson1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    // A board with 9 squares
    // Assume: squares always has 9 values (each square)
    // pos 0 - 2 1st row
    // pos 3 - 5 2nd row
    // pos 6 - 8 3rd row
    public List<Integer> squares = new ArrayList<>();
    
    public Board() {
        squares.add(0);
        squares.add(0);
        squares.add(0);
        squares.add(0);
        squares.add(0);
        squares.add(0);
        squares.add(0);
        squares.add(0);
        squares.add(0);
    }
    
    // X = human's move
    // O = computer's move
    
    // Assume that the board is empty at position
    // Assume that the board has an empty position to place an X
    public void makeHumanMove(int position) {
        squares.set(position, 1);
    }
    
    // Assume that the board has an empty position to place an O
    public int makeComputerMove() {
        Random generator = new Random();
        while (true) {
            // Generates a random number between 0 and 9
            int position = generator.nextInt(9);
            // if board at position is blank
            if (squares.get(position) == 0) {
                // make move
                squares.set(position, -1);
                return position;
            }
            // else: keep generating until we find a blank square
        }
    }
    
    // return true if board has at least one blank square
    public boolean hasValidMove() {
        // we want to see if ANY square on the board is blank
        
        // going through every square,
        for (int i = 0; i < 9; i++) {
            //check if the current square is blank:
            if (squares.get(i) == 0) {
                // the board has a blank square
                return true;
            }
        }
        // If we've went through all the squares, and none of them are blank, 
        return false;
        
        // && - AND
        // || - OR
        // ! - NOT
        
        // true && true = true;
        // true && false = false;
        // true || true = true;
        // true || false = true;
    }
    
    // return true if either the human or the computer has won the game
    public boolean hasWinner() {
        return (squares.get(0) + squares.get(1) + squares.get(2) == 3 ||
                squares.get(3) + squares.get(4) + squares.get(5) == 3 ||
                squares.get(6) + squares.get(7) + squares.get(8) == 3 ||
                squares.get(0) + squares.get(3) + squares.get(6) == 3 ||
                squares.get(1) + squares.get(4) + squares.get(7) == 3 ||
                squares.get(2) + squares.get(5) + squares.get(8) == 3 ||
                squares.get(0) + squares.get(4) + squares.get(8) == 3 ||
                squares.get(2) + squares.get(4) + squares.get(6) == 3)
                ||
                (squares.get(0) + squares.get(1) + squares.get(2) == -3 ||
                squares.get(3) + squares.get(4) + squares.get(5) == -3 ||
                squares.get(6) + squares.get(7) + squares.get(8) == -3 ||
                squares.get(0) + squares.get(3) + squares.get(6) == -3 ||
                squares.get(1) + squares.get(4) + squares.get(7) == -3 ||
                squares.get(2) + squares.get(5) + squares.get(8) == -3 ||
                squares.get(0) + squares.get(4) + squares.get(8) == -3 ||
                squares.get(2) + squares.get(4) + squares.get(6) == -3);
    }
    
    public void printBoard() {
            String board = "";
            board += "-------------\n";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int square = squares.get(i * 3 + j);
                    if (square == 1) {
                        board += "| X ";
                    } else if (square == -1) {
                        board += "| O ";
                    } else {
                        board += "|   ";
                    }
                }
                board += "|\n";
                board += "-------------\n";
            }
            System.out.println(board);
        }
}

