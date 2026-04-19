import java.util.*;

public class AIPlayer {

    Random rand = new Random();

    public int findBestMove(GameBoard gb) {

        // EASY → random
        if (Settings.level == Settings.Difficulty.EASY) {
            return randomMove(gb);
        }

        // MEDIUM → 50% random
        if (Settings.level == Settings.Difficulty.MEDIUM && rand.nextBoolean()) {
            return randomMove(gb);
        }

        // HARD → full alpha-beta
        int bestScore = Integer.MIN_VALUE;
        int move = -1;

        for (int i = 0; i < 9; i++) {
            if (gb.board[i] == ' ') {
                gb.board[i] = 'O';

                int score = minimax(gb, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                gb.board[i] = ' ';

                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }
        return move;
    }

    private int randomMove(GameBoard gb) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (gb.board[i] == ' ') moves.add(i);
        }
        return moves.get(rand.nextInt(moves.size()));
    }

    private int minimax(GameBoard gb, int depth, boolean isMax, int alpha, int beta) {
        int result = gb.checkWinner();

        if (result != 2) {
            if (result == 10) return 10 - depth;
            if (result == -10) return depth - 10;
            return 0;
        }

        if (isMax) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < 9; i++) {
                if (gb.board[i] == ' ') {
                    gb.board[i] = 'O';

                    int score = minimax(gb, depth + 1, false, alpha, beta);
                    gb.board[i] = ' ';

                    best = Math.max(best, score);
                    alpha = Math.max(alpha, best);

                    if (beta <= alpha) break;
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < 9; i++) {
                if (gb.board[i] == ' ') {
                    gb.board[i] = 'X';

                    int score = minimax(gb, depth + 1, true, alpha, beta);
                    gb.board[i] = ' ';

                    best = Math.min(best, score);
                    beta = Math.min(beta, best);

                    if (beta <= alpha) break;
                }
            }
            return best;
        }
    }
}