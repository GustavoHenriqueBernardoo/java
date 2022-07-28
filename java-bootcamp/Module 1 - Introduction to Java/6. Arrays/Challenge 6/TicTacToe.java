import java.util.Arrays;
import java.util.Scanner;

import javax.swing.border.Border;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.
    char[][] board = {
        { '_', '_', '_' },
        { '_', '_', '_' },
        { '_', '_', '_' },
    };

    // Task 2: Call the function printBoard();
    printBoard(board);

    System.out.print("\n");
    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        int[] arrX = askUser(board);

        board[arrX[0]][arrX[1]] = 'X';
        printBoard(board);

      } else {
        System.out.println("Turn: O");
        int[] arrO = askUser(board);

        board[arrO[0]][arrO[1]] = 'O';
        printBoard(board);
      }
      if (checkWin(board) == 3) {
        System.out.println("X Wins");
        break;
      } else if (checkWin(board) == -3) {
        System.out.println("O Wins");
        break;
      } else if (i == 8) {
        System.out.println("It's a tie!");
        break;
      }

    }

    /*
     * { Task 3: Loop through turns.
     * 
     * if (X) turn {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value.
     * } else {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value. Then, print it.
     * 
     * }
     * 
     * Task 6 - Call the function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */

    scan.close();
  }

  public static void printBoard(char[][] board) {
    System.out.print("\n");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public static int[] askUser(char[][] board) {
    System.out.print("Pick a row and column number:");

    int row = scan.nextInt();
    int column = scan.nextInt();

    while (board[row][column] != '_') {
      System.out.print("\nspot taken, try again:");
      row = scan.nextInt();
      column = scan.nextInt();
    }

    int[] spot = { row, column };
    return spot;
  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   *         int spot = new int[row, col];
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */

  public static int checkWin(char[][] board) {
    int count = 0;

    // rows
    if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
      count = 3;
    }
    if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
      count = 3;

    }
    if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
      count = 3;

    }
    if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
      count = -3;

    }
    if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
      count = -3;

    }
    if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
      count = -3;

    }

    // Diagonals

    if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
      count = 3;

    }
    if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
      count = 3;

    }
    if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
      count = -3;

    }
    if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
      count = -3;

    }

    // Columns

    if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
      count = 3;

    }
    if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
      count = 3;

    }
    if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
      count = 3;

    }
    if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
      count = -3;

    }
    if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
      count = -3;

    }
    if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
      count = -3;

    }

    if (count == 3 || count == -3) {
      return count;
    } else {
      return 0;
    }

    // return count;
  }

}
