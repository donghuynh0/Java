package Tic_Tac_Toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tic_Tac_Toe {
    int boardWith = 650; //px
    int boardHeight = 650;// 50px for text panel on top
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel controlPanel = new JPanel(); // Panel for scores and restart button
    JButton restartButton = new JButton("Restart");
    JButton scoreX = new JButton("X's Score: 0");
    JButton scoreO = new JButton("O's Score: 0");
    JButton[][] board = new JButton[3][3];
    int scoreXCount = 0; // Keep track of X's score
    int scoreOCount = 0; // Keep track of O's score
    String playerX = "X";
    String playerO = "O";
    boolean gameOver = false;
    String currentPlayer = playerX;
    int turns = 0;
    Tic_Tac_Toe(){
        //set configs for frame
        frame.setSize(boardWith,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Create and set configs for label of title
        textLabel.setBackground(Color.darkGray); // color of background
        textLabel.setForeground(Color.WHITE); // color of component
        textLabel.setFont(new Font("Arial",Font.BOLD,40));
        textLabel.setHorizontalAlignment(JLabel.CENTER); // set content in label at the center
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout()); // create a panel
        textPanel.add(textLabel); // add above label into panel
        frame.add(textPanel,BorderLayout.NORTH); // add this panel into frame

        //Create and set config for a panel
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel); // add panel into frame

        // Initialize control labels and panel for scores and restart button
        //set buttons
        scoreX.setFont(new Font("Arial",Font.PLAIN,20));
        scoreO.setFont(new Font("Arial",Font.PLAIN,20));
        restartButton.setFont(new Font("Arial",Font.BOLD,20));

        controlPanel.setLayout(new BorderLayout(10, 0));

        // Adding score buttons and restart button to the control panel
        JPanel scorePanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scorePanelLeft.add(scoreX);
        controlPanel.add(scorePanelLeft, BorderLayout.WEST);

        JPanel scorePanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        scorePanelRight.add(scoreO);
        controlPanel.add(scorePanelRight, BorderLayout.EAST);

        JPanel restartPanelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        restartPanelCenter.add(restartButton);
        controlPanel.add(restartPanelCenter, BorderLayout.CENTER);

        frame.add(controlPanel, BorderLayout.SOUTH); // Adding control panel to the frame

        // initialize the board and play
        initialize_play();

        // Restart button action
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        frame.setVisible(true);
    }

    void initialize_play(){
        for (int c = 0 ; c < 3  ; c++){
            for (int r = 0 ; r < 3 ; r++){
                JButton button = new JButton();
                board[c][r] = button;
                button.setBackground(Color.darkGray);
                button.setForeground(Color.BLACK);
                button.setFont(new Font("Arial",Font.BOLD,120));
                button.setFocusable(false);
                boardPanel.add(button);

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
//                      get action from user and set content of title
                        JButton title = (JButton)e.getSource();
                        if (title.getText().isEmpty()){
                            title.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver){
                                // check currentPlayer == playerX if true then currentPlayer = playerO and contrary
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer +"'s Turn"); //set content of label by currentPlayer
                            }
//
                        }

                    }
                });
            }
        }
    }
    void checkWinner(){
//        horizontally
        for (int c = 0; c < 3; c++){
            if (board[c][0].getText().isEmpty()) continue;
            if (board[c][0].getText().equals(board[c][1].getText())
                    && board[c][1].getText().equals(board[c][2].getText())){
                for(int j = 0; j < 3; j++){
                    setWinner(board[c][j]);
                }
                setScore();
                gameOver = true;
                return;
            }
        }
//         vertically
        for (int r = 0; r < 3; r++) {
            if (board[0][r].getText().isEmpty()) continue;
            if (board[0][r].getText().equals(board[1][r].getText())
                    && board[1][r].getText().equals(board[2][r].getText())){
                for(int j = 0; j < 3; j++){
                    setWinner(board[j][r]);
                }
                setScore();
                gameOver = true;
                return;
            }
        }
        // diagonally
        if (!board[0][0].getText().isEmpty() &&
                board[0][0].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][2].getText())){
            for (int i = 0; i < 3; i++) {
                setWinner(board[i][i]);
            }
            setScore();
            gameOver = true;
            return;
        }
        //anti-diagonally
        if (!board[0][2].getText().isEmpty() &&
                board[0][2].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][0].getText())){
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            setScore();
            gameOver = true;
            return;
        }
        // Tie
        if (turns == 9){
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }

    }
    void setWinner(JButton button){
        button.setForeground(Color.GREEN);
        button.setBackground(Color.GRAY);
        textLabel.setText(currentPlayer+" is the winner!");
    }
    void setTie(JButton button){
        button.setForeground(Color.orange);
        button.setBackground(Color.GRAY);
        textLabel.setText("Tie!");
    }
    void setScore(){
        if (currentPlayer.equals("X")){
            scoreXCount++;
            scoreX.setText(currentPlayer+"'s Score: "+scoreXCount);
        } else{
            scoreOCount++;
            scoreO.setText(currentPlayer+"'s Score: "+scoreOCount);
        }
    }
    void resetGame() {
        // Reset the game state
        currentPlayer = playerX;
        gameOver = false;
        turns = 0;
        textLabel.setText("Tic-Tac-Toe");

        // Clear the board
        for (int c = 0; c < 3; c++) {
            for (int r = 0; r < 3; r++) {
                board[c][r].setText("");
                board[c][r].setEnabled(true);
                board[c][r].setForeground(Color.BLACK);
            }
        }
    }

}

