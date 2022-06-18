public class Minesweeper {
    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.run();
    }

    public void run() {
        Board board = new Board();
        board.printBoard();
    }

    public class Board {
        private int[] board;
        private int size;
        private int mines = 10;
        private int flags = 0;

        public Board() {
            size = 10;
            board = new int[size * size];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    board[j*size + i] = 0;
                }
            }
            // randomly place 10 mines on the board
            // TODO: select 10 spots with no duplicates efficiently
            for (int i = 0; i < mines; i++) {
                int x = (int) (Math.random() * size);
                int y = (int) (Math.random() * size);
                if (board[y*size + x] != -1){
                    board[y*size + x] = -1;
                }
                else {
                    i--;
                }
            }
        }
        public void printBoard() {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (board[j*size + i] == -1){
                        System.out.print("* ");
                    }
                    else {
                        System.out.print(board[j*size + i ] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}