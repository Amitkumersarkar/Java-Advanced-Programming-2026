import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameUI extends JFrame implements ActionListener {

    CellButton[] btn = new CellButton[9];
    JLabel score = new JLabel("You: 0  pc: 0");
    JButton reset = new JButton("Restart");

    GameBoard board = new GameBoard();
    AIPlayer ai = new AIPlayer();

    int human = 0, comp = 0;

    public GameUI() {
        setTitle("Tic Tac Toe");
        setSize(420,520);
        getContentPane().setBackground(Theme.BG);
        setLayout(new BorderLayout(10,10));

        JPanel top = new JPanel();
        top.setBackground(Theme.PANEL);

        score.setForeground(Theme.NEON_BLUE);
        score.setFont(new Font("Consolas", Font.BOLD, 20));
        top.add(score);

        JPanel grid = new JPanel(new GridLayout(3,3,8,8));
        grid.setBackground(Theme.BG);
        grid.setBorder(BorderFactory.createLineBorder(Theme.GRID,2));

        for (int i=0;i<9;i++) {
            btn[i] = new CellButton();
            int index = i;

            btn[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    if (board.isMoveValid(index))
                        btn[index].setBackground(new Color(50,50,90));
                }
                public void mouseExited(MouseEvent e) {
                    btn[index].setBackground(Theme.CELL);
                }
            });

            btn[i].addActionListener(this);
            grid.add(btn[i]);
        }

        JPanel bottom = new JPanel();
        bottom.setBackground(Theme.PANEL);

        reset.setBackground(Theme.CELL);
        reset.setForeground(Theme.NEON_PINK);
        reset.setBorder(BorderFactory.createLineBorder(Theme.NEON_PINK));
        reset.addActionListener(e -> resetGame());

        bottom.add(reset);

        add(top,BorderLayout.NORTH);
        add(grid,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<9;i++) {
            if (e.getSource()==btn[i] && board.isMoveValid(i)) {

                board.makeMove(i,'X');
                btn[i].setValue('X');

                if (!gameOver()) {
                    int move = ai.findBestMove(board);
                    board.makeMove(move,'O');
                    btn[move].setValue('O');
                    gameOver();
                }
            }
        }
    }

    private boolean gameOver() {
        int r = board.checkWinner();

        if (r == 10 || r == -10) {
            for (int i : board.winLine)
                btn[i].setBackground(new Color(0,255,255,60));

            if (r == 10) {
                comp++;
                JOptionPane.showMessageDialog(this,"AI Wins!");
            } else {
                human++;
                JOptionPane.showMessageDialog(this,"You Win!");
            }

            score.setText("You: "+human+"  AI: "+comp);
            resetGame();
            return true;
        }

        if (r == 0) {
            JOptionPane.showMessageDialog(this,"Draw!");
            resetGame();
            return true;
        }
        return false;
    }

    private void resetGame() {
        board.reset();
        for (CellButton b : btn) {
            b.setValue(' ');
            b.setBackground(Theme.CELL);
        }
    }
}