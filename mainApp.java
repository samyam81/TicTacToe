package TicTacToe;

import java.util.Scanner;

public class mainApp {

    
    public static void main(String[] args) {
         char[][] board=new char[3][3];
         initialize(board);
         game(board);
    }

    private static void game(char[][] board) {
      char player1='X';
      boolean gameover=false;
      Scanner scan=new Scanner(System.in);
      while (!gameover) {
         printBoard(board);
         System.out.println("Player "+player1+"enter: ");
         int row=scan.nextInt();
         int col=scan.nextInt();

         if (board[row][col]==' ') {
            board[row][col]=player1;
            gameover=haveWon(board,player1);
            if (gameover) {
               System.out.println("Player "+player1+" has won.");
            }
            else{
               player1=(player1=='X')?'0':'X';
            }
         }else{
            System.out.println("Invalid move.Try Again.");
         }
         printBoard(board);
         scan.close();
      }
   }
   public static boolean haveWon(char[][] board,char player1 ) {
      for (int i = 0; i < board.length; i++) {
        if (board[i][0]==player1
        &&
        board[i][1]==player1
        &&
        board[i][2]==player1) {
         return true;
        }
      }
      for (int i = 0; i < board.length; i++) {
         if (board[0][i]==player1
        &&
        board[1][i]==player1
        &&
        board[2][i]==player1) {
         return true;
        }
      }
      if (board[0][0] == player1 
      && 
      board[1][1] == player1 
      && 
      board[2][2]==player1) {
         return true;
      }
        if (board[0][2] == player1 
      && 
      board[1][1] == player1 
      && 
      board[2][0]==player1) {
         return true;
      }
      return false;
   }

   private static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
         for (int col = 0; col < board[row].length; col++) {
           System.out.print(board[row][col]+"|");
         }
          System.out.println();
       }
   }

   private static void initialize(char[][] board) {
       for (int row = 0; row < board.length; row++) {
         for (int col = 0; col < board[row].length; col++) {
            board[row][col]=' ';
         }
       }
    }
}
