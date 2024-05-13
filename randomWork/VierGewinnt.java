package randomWork;

import java.util.Scanner;

public class VierGewinnt {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static char[][] board = new char[ROWS][COLUMNS];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        boolean isPlayer1Turn = true;

        while (true) {
            int column = getInput(isPlayer1Turn);
            if (isValidMove(column)) {
                int row = makeMove(column, isPlayer1Turn);
                printBoard();
                if (checkWin(row, column, isPlayer1Turn)) {
                    System.out.println(isPlayer1Turn ? "Spieler 1 gewinnt!" : "Spieler 2 gewinnt!");
                    break;
                }
                if (isBoardFull()) {
                    System.out.println("Unentschieden!");
                    break;
                }
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                System.out.println("Ungültiger Zug. Bitte erneut versuchen.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(" 1 2 3 4 5 6 7");
    }

    private static int getInput(boolean isPlayer1Turn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Spieler " + (isPlayer1Turn ? "1" : "2") + ", wähle eine Spalte (1-7): ");
        return scanner.nextInt() - 1;
    }

    private static boolean isValidMove(int column) {
        return column >= 0 && column < COLUMNS && board[0][column] == ' ';
    }

    private static int makeMove(int column, boolean isPlayer1Turn) {
        int row;
        for (row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = isPlayer1Turn ? 'X' : 'O';
                break;
            }
        }
        return row;
    }

    private static boolean checkWin(int row, int column, boolean isPlayer1Turn) {
        char symbol = isPlayer1Turn ? 'X' : 'O';

        // Überprüfe waagerecht
        int count = 0;
        for (int j = Math.max(0, column - 3); j <= Math.min(column + 3, COLUMNS - 1); j++) {
            if (board[row][j] == symbol) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        // Überprüfe senkrecht
        count = 0;
        for (int i = Math.max(0, row - 3); i <= Math.min(row + 3, ROWS - 1); i++) {
            if (board[i][column] == symbol) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        // Überprüfe diagonal (von links oben nach rechts unten)
        count = 0;
        int startRow = row - Math.min(row, column);
        int startColumn = column - Math.min(row, column);
        int endRow = row + Math.min(ROWS - 1 - row, COLUMNS - 1 - column);
        int endColumn = column + Math.min(ROWS - 1 - row, COLUMNS - 1 - column);
        for (int i = startRow, j = startColumn; i <= endRow && j <= endColumn; i++, j++) {
            if (board[i][j] == symbol) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        // Überprüfe diagonal (von links unten nach rechts oben)
        count = 0;
        startRow = row + Math.min(ROWS - 1 - row, column);
        startColumn = column - Math.min(ROWS - 1 - row, column);
        endRow = row - Math.min(row, COLUMNS - 1 - column);
        endColumn = column + Math.min(row, COLUMNS - 1 - column);
        for (int i = startRow, j = startColumn; i >= endRow && j <= endColumn; i--, j++) {
            if (board[i][j] == symbol) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int j = 0; j < COLUMNS; j++) {
            if (board[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }
}

