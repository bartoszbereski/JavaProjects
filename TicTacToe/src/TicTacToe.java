import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    Font bigFont = new Font("Serif", Font.BOLD, 18);
    Font NewFont = new Font("Comic Sans MS", Font.BOLD, 24);
    JButton[] userButtons = new JButton[9];
    JButton PlayVsPc = new JButton();
    JButton ResetButton = new JButton("RESET");
    boolean gameEnded;
    int numberOfMoves = 0;
    int userTurn;

    TicTacToe() {
        Random rand = new Random();
        userTurn = rand.nextInt(2);
        PlayVsPc.addActionListener(this);
        PlayVsPc.setFocusable(false);
        PlayVsPc.setFont(bigFont);
        PlayVsPc.setText("Player vs PC");
        ResetButton.addActionListener(this);
        ResetButton.setFocusable(false);
        ResetButton.setFont(bigFont);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 9; i++) {
            userButtons[i] = new JButton("");
            userButtons[i].addActionListener(this);
            userButtons[i].setFocusable(false);
            userButtons[i].setFont(NewFont);
        }
        if (userTurn == 1) {
            label.setText("X turn");
        } else {
            label.setText("O turn");
        }
        label.setBounds(0, 0, 400, 50);
        label.setFont(new Font("MV Bondi", Font.PLAIN, 30));
        label.setBackground(Color.black);
        label.setForeground(Color.green);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setBounds(0, 60, 400, 300);
        panel.setLayout(new GridLayout(4, 3));
        panel.add(userButtons[0]);
        panel.add(userButtons[1]);
        panel.add(userButtons[2]);
        panel.add(userButtons[3]);
        panel.add(userButtons[4]);
        panel.add(userButtons[5]);
        panel.add(userButtons[6]);
        panel.add(userButtons[7]);
        panel.add(userButtons[8]);
        panel.add(PlayVsPc);
        panel.add(ResetButton);
        frame.add(label);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new TicTacToe();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PlayVsPc) {
            
        }
        if (e.getSource() == ResetButton) {
            new TicTacToe();
        }
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == userButtons[i]) {
                if (gameEnded) {
                    break;
                }
                if (userTurn == 1) {
                    if (userButtons[i].getText().isEmpty()) {
                        userButtons[i].setForeground(Color.red);
                        userButtons[i].setText("X");
                        userTurn = 0;
                        numberOfMoves++;
                        label.setText("O turn");
                    } else {
                        label.setText("POSITION TAKEN!");
                    }
                } else {
                    if (userButtons[i].getText().isEmpty()) {
                        userButtons[i].setForeground(Color.blue);
                        userButtons[i].setText("O");
                        userTurn = 1;
                        numberOfMoves++;
                        label.setText("X turn");
                    } else {
                        label.setText("POSITION TAKEN!");
                    }
                }
                if (numberOfMoves >= 4) {
                    if (userButtons[0].getText().equals(userButtons[1].getText()) && userButtons[0].getText().equals(userButtons[2].getText())) {
                        if (!userButtons[0].getText().isEmpty()) {
                            label.setText(userButtons[0].getText() + " won!!");
                            gameEnded = true;
                        }
                    } else if (userButtons[0].getText().equals(userButtons[3].getText()) && userButtons[0].getText().equals(userButtons[6].getText())) {
                        if (!userButtons[0].getText().isEmpty()) {
                            label.setText(userButtons[0].getText() + " won!!");
                            gameEnded = true;
                        }
                    } else if (userButtons[0].getText().equals(userButtons[4].getText()) && userButtons[0].getText().equals(userButtons[8].getText())) {
                        if (!userButtons[0].getText().isEmpty()) {
                            label.setText(userButtons[0].getText() + " won!!");
                            gameEnded = true;
                        }
                    } else if (userButtons[3].getText().equals(userButtons[4].getText()) && userButtons[3].getText().equals(userButtons[5].getText())) {
                        if (!userButtons[3].getText().isEmpty()) {
                            label.setText(userButtons[3].getText() + " won!!");
                            gameEnded = true;
                        }
                    } else if (userButtons[6].getText().equals(userButtons[7].getText()) && userButtons[6].getText().equals(userButtons[8].getText())) {
                        if (!userButtons[6].getText().isEmpty()) {
                            label.setText(userButtons[6].getText() + " won!!");
                            gameEnded = true;
                        }
                    } else if (numberOfMoves == 9) {
                        label.setText("DRAW!!!");
                    }
                }
            }
        }
    }
}
