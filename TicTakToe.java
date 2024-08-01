import java.util.Random;
import java.util.Scanner;

public class TicTakToe {
    static Random rand = new Random();

    //create a game board
    public static void drawBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();//create space after every role
        }
    }

    public static boolean winConditionRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') {
                return true;
            }
        }
        return false;
    }

    public static boolean winConditionCol(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x') {
                return true;
            }
        }
        return false;
    }

    public static boolean winConditionDiag(char[][] board) {
        if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
            return true;
        }
        if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
            return true;
        }
        return false;
    }


    public static boolean checkWinPath(board[][],int symbol)
    {
     for(int i=0;i<board.length;i++)
     {
        for(int j=0;j<board[i].length;j++){
         if (winConditionRow(gameBoard) || winConditionCol(gameBoard) || winConditionDiag(gameBoard)) {
             return true;
        }
     }
     return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char player = 'x';

        char[][] gameBoard = { {'-', '-', '-'},
                               {'-', '-', '-'},
                               {'-', '-', '-'} };

        drawBoard(gameBoard);

        boolean controlFlag = true;
        while (controlFlag) {
            System.out.println("Enter your move (1-9):");
            int playerMove = input.nextInt();
            
            int row = (playerMove - 1) / 3;
            int col = (playerMove - 1) % 3;

            if (playerMove < 1 || playerMove > 9 || gameBoard[row][col] != '-') {
                System.out.println("INVALID MOVE");
                continue;
            }

            gameBoard[row][col] = 'x';

            int cpuMove;
            do {
                cpuMove = rand.nextInt(9); // Generate a number between 0 and 8
            } while (gameBoard[cpuMove / 3][cpuMove % 3] != '-');

            gameBoard[cpuMove / 3][cpuMove % 3] = 'o';

            drawBoard(gameBoard);

            if (winConditionRow(gameBoard) || winConditionCol(gameBoard) || winConditionDiag(gameBoard)) {
                System.out.println("YOU WIN");
		 controlFlag = false;
            }
        }
    }
}
