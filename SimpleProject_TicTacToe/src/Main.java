import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = ' ';
            }
        }

        boolean X_turn = true;
        char player = 'X';
        boolean hasWin = check(board, player);
        Scanner sc = new Scanner(System.in);
        while (!hasWin) {

            System.out.println(player + " turn");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                if (X_turn) {//X turn
                    player = 'X';
                    board[row][col] = player;
                    draw(board, player);
                    X_turn = false;
                    hasWin = check(board, player);
                    if (hasWin) {
                        System.out.println(player + " WON!");
                        break;
                    }
                    player = 'O';
                }
                else { // O turn
                    board[row][col] = player;
                    draw(board, player);
                    X_turn = true;
                    hasWin = check(board, player);
                    if (hasWin) {
                        System.out.println(player + " WON!");
                        break;
                    }
                    player = 'X';
                }
            } else {
                draw(board,player);
                System.out.println("Invalid move!");

            }
        }


        if (!hasWin) {
            System.out.println("Withdraw - no win!");
        }
    }


    public static void draw(char[][]board, char player){

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean check(char[][] board,char player){
        //row Wins
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //col Wins
        for (int col = 0; col < board.length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //diagonal Wins
        if(board[0][0] == player && board[1][1]== player && board[2][2]== player){
            return true;
        }


        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return  false;
    }
}