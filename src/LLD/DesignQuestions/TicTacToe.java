package LLD.DesignQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

enum PieceType {
    X,
    O
}
class Player {
    int id;
    String name;
    PieceType pieceType;

    public Player(int id, String name, PieceType pieceType) {
        this.id = id;
        this.name = name;
        this.pieceType = pieceType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
class TicTacToeGame {
    Deque<Player> players;
    PieceType[][] board;
    Scanner sc;

    TicTacToeGame(Deque<Player> players , int boardSize) {
        this.players =  players;
        board = new PieceType[boardSize][boardSize];
        sc= new Scanner(System.in);
    }

    public void start(){
        int count = board.length*board.length;
        while (true) {
            if (count == 0) {
                System.out.println("Draw");
                return;
            }
            Player player = players.removeFirst();
            System.out.println("Player : " +player.getId()+" turn");
            printBoard();
            System.out.println("Enter row and column");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            if(row < board.length && col < board.length && board[row][col] == null){
                count--;
                board[row][col] = player.getPieceType();
                if(checkWinner(board, row , col, player.getPieceType())){
                    System.out.println("WINNER : " +  player.getName());
                    return;
                }
                players.addLast(player);
            } else {
                System.out.println("Enter Valid row and col");
                players.addFirst(player);
            }
        }
    }

    private void printBoard() {
        int n = board.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].name() + " ");
                }
            }
            System.out.println();
        }
    }

    private boolean checkWinner(PieceType[][] board, int row, int col, PieceType pieceType) {
        int n = board.length;

        // Check row
        boolean win = true;
        for (int j = 0; j < n; j++) {
            if (board[row][j] != pieceType) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check column
        win = true;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != pieceType) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check main diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != pieceType) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check anti-diagonal
        if (row + col == n - 1) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - 1 - i] != pieceType) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // No winner found
        return false;
    }



}

public class TicTacToe {
    public static void main(String[] args) {
        Deque<Player> players = new ArrayDeque<>();
        players.addLast(new Player(1,"Player 1", PieceType.X));
        players.addLast(new Player(2,"Player 2", PieceType.O));
        TicTacToeGame game = new TicTacToeGame(players,3);
        game.start();
    }
}
