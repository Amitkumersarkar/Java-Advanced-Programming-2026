public class GameBoard {
    public char[] board = new char[9];
    public int[] winLine = new int[3];

    public GameBoard() { reset(); }

    public void reset() {
        for (int i = 0; i < 9; i++) board[i] = ' ';
    }

    public boolean isMoveValid(int i) {
        return board[i] == ' ';
    }

    public void makeMove(int i, char p) {
        board[i] = p;
    }

    public int checkWinner() {
        int[][] win = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] w : win) {
            if (board[w[0]] == board[w[1]] &&
                board[w[1]] == board[w[2]] &&
                board[w[0]] != ' ') {

                winLine = w;
                return board[w[0]] == 'O' ? 10 : -10;
            }
        }

        for (char c : board) if (c == ' ') return 2;
        return 0;
    }
}