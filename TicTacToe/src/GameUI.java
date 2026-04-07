import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameUI extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[3][3];
    String currentPlayer = "X";
    boolean gameOver = false;

    public GameUI() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (!btn.getText().equals("") || gameOver) return;

        btn.setText(currentPlayer);

        if (checkWinner()) {
            JOptionPane.showMessageDialog(this, currentPlayer + " Wins!");
            Database.saveResult(currentPlayer);
            gameOver = true;
        } else if (isDraw()) {
            JOptionPane.showMessageDialog(this, "Draw!");
            Database.saveResult("Draw");
            gameOver = true;
        } else {
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
    }

    private boolean checkWinner() {
        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(currentPlayer) &&
                buttons[i][1].getText().equals(currentPlayer) &&
                buttons[i][2].getText().equals(currentPlayer)) return true;

            if (buttons[0][i].getText().equals(currentPlayer) &&
                buttons[1][i].getText().equals(currentPlayer) &&
                buttons[2][i].getText().equals(currentPlayer)) return true;
        }

        // Diagonals
        if (buttons[0][0].getText().equals(currentPlayer) &&
            buttons[1][1].getText().equals(currentPlayer) &&
            buttons[2][2].getText().equals(currentPlayer)) return true;

        if (buttons[0][2].getText().equals(currentPlayer) &&
            buttons[1][1].getText().equals(currentPlayer) &&
            buttons[2][0].getText().equals(currentPlayer)) return true;

        return false;
    }

    private boolean isDraw() {
        for (JButton[] row : buttons) {
            for (JButton btn : row) {
                if (btn.getText().equals("")) return false;
            }
        }
        return true;
    }
}