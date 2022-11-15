import java.util.Scanner;

public class TicTacToe1 {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
            };
            printBoard(board);
              
             for (int i = 0; i < 9; i++) {

                 if (i % 2 == 0) {
                     System.out.println("Turn: X");
                     int[] spot = askUser(board);  
                     board[spot[0]][spot[1]] = 'X';
                     printBoard(board);

                 } else {
                     System.out.println("Turn: O");
                     int[] spot = askUser(board);
                     board[spot[0]][spot[1]] = 'O';
                     printBoard(board);
                 }

                 if (checkWin(board) == 3) {
                     System.out.println("X wins!!");
                     break;
                 } else if (checkWin(board) == -3) {
                     System.out.println("O wins!!");
                     break;
                 } else if (i == 8) {
                     System.out.println("It's a tie!");
                 }
    
            }

            scan.close();
        }
       
    public static void printBoard(char[][] board) {
        System.out.print("\n");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.print("\n\n");
        }
    }

     public static int[] askUser(char[][] board) {   
         System.out.print(" - pick a row and column number: ");

         int row = scan.nextInt();
         int column = scan.nextInt();

         while (board[row][column] != ('_')){
             System.out.print("Spot taken, try again: ");
             row = scan.nextInt();
             column = scan.nextInt();
         }
        
         int[] spot = {row, column};
         return spot; 
     }


     public static int checkWin(char[][] board) {
        
         int count = 0;

         for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[i].length; j++) {
                 if (board[i][j] == 'X') {
                     count++;
                 } else if (board[i][j] == 'O') { 
                     count--; 
                 }
             }
             if (count == 3 || count == -3) {
                 return count;
             } else {
                 count = 0;
             }

         }

         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {

                 if (board[j][i] == 'X') {
                     count++;
                 } else if (board[j][i] == 'O') { 
                     count--; 
                 }
             }
             if (count == 3 || count == -3) {
                 return count;
             } else {
                 count = 0;
             }
         }

         for (int i = 0; i < 3; i++) {
             if (board[i][i] == 'X') {
                 count++; 
             } else if (board[i][i] == 'O') { 
                 count--; 
             }
         }

         if (count == 3 || count == -3) {
             return count;
         } else {
             count = 0;
         }

         for (int i = 0; i < 3; i++) {
             if (board[i][2-i] == 'X') {
                 count++;
             } else if (board[i][2-i] == 'O') { 
                 count--;
             }
         }

         return count;
     }

}
