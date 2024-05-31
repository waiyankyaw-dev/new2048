package view;

import controller.GameController;
import util.ColorMap;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private GameController controller;
    private JButton restartBtn;
    private JButton saveBtn;
    private JButton loadBtn;
    private JButton redoBtn;
    private JButton exitBtn;
    private JButton timeBtn;

    private JLabel stepLabel;
    private JLabel scoreLabel;
    private JLabel highestScoreLabel;
    private JLabel timeLabel;


    private GamePanel gamePanel;

    private String username;
    private int size;

    private int winScore;

    int elapsedTime = 12000;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;

    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer;

    public GameFrame(int width, int height, String username, int size, int winScore) {
        this.winScore = winScore;
        this.username = username;
        this.size = size;
        this.setTitle("2024 CS109 Project Demo");
        this.setLayout(null);
        this.setSize(width, height);
        ColorMap.InitialColorMap();
        gamePanel = new GamePanel((int) (this.getHeight() * 0.8), username, size, winScore);
        gamePanel.setLocation(this.getHeight() / 15, this.getWidth() / 15);
        this.add(gamePanel);

        this.controller = new GameController(gamePanel, gamePanel.getModel());

        this.restartBtn = createButton("Restart", new Point(500, 150), 80, 30);
        this.saveBtn = createButton("Save", new Point(500, 190), 80, 30);
        if (username.isEmpty()){
            saveBtn.setEnabled(false);
        }
        this.loadBtn = createButton("Load", new Point(500, 230), 80, 30);
        if (username.isEmpty()){
            loadBtn.setEnabled(false);
        }
        this.redoBtn = createButton("Redo", new Point(500, 270), 80, 30);
        this.exitBtn = createButton("Exit", new Point(500, 310), 80, 30);

        this.stepLabel = createLabel("Step: 0", new Font("serif", Font.ITALIC, 22), new Point(520, 10), 180, 50);
        this.scoreLabel = createLabel("Score: 0", new Font("serif", Font.ITALIC, 22), new Point(520, 50), 180, 50);
        this.highestScoreLabel = createLabel("HighScore: 0", new Font("serif", Font.ITALIC, 22), new Point(520, 90), 180, 50);
        this.timeLabel = createLabel("Time: 0:00", new Font("serif", Font.ITALIC, 22), new Point(520, 350), 180, 50);
//        this.timeLabel = new JLabel();






         timer = new Timer(1000, e -> {

                elapsedTime -= 1000;



            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) %60;
             seconds_string = String.format("%02d", seconds);
             minutes_string = String.format("%02d", minutes);
             hours_string = String.format("%02d", hours);

            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

            if(hours == 0 && minutes ==0) {
                if(seconds == 0){
                    System.out.println("wai");
                    this.stop();
                }

            }


        });



        timer.start();






        gamePanel.setStepLabel(stepLabel);
        gamePanel.setScoreLabel(scoreLabel);
        gamePanel.setHighestsScoreLabel(highestScoreLabel);




        //automatic load
        if(!username.isEmpty()){
            System.out.println("from gameframe"+ username + size);
            controller.loadGame(username, username, size);// the first username is filename, the second one is folder name, automatic load
        }



        this.restartBtn.addActionListener(e -> {
            controller.restartGame();
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.saveBtn.addActionListener(e -> {
            String string = JOptionPane.showInputDialog(this, "Input path:");
            controller.saveGame(string);
            System.out.println(string);
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.loadBtn.addActionListener(e -> {
            String string = JOptionPane.showInputDialog(this, "Input path:");
            controller.loadGame(string, username, size);
            System.out.println(string);
            gamePanel.requestFocusInWindow();//enable key listener
        });

        this.redoBtn.addActionListener(e -> {
            controller.redoGame();
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.exitBtn.addActionListener(e -> {
            if(!username.isEmpty()){ //if he is guest
                controller.exitGame(username);
                System.out.println("guest won't run");
            }
            gamePanel.requestFocusInWindow();//enable key listener
            System.exit(0);
        });






        //todo: add other button here
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    private void stop(){
        timer.stop();
        new GameoverFrame();
    }
    private JButton createButton(String name, Point location, int width, int height) {
        JButton button = new JButton(name);
        button.setLocation(location);
        button.setSize(width, height);
        this.add(button);
        return button;
    }

    private JLabel createLabel(String name, Font font, Point location, int width, int height) {
        JLabel label = new JLabel(name);
        label.setFont(font);
        label.setLocation(location);
        label.setSize(width, height);
        this.add(label);
        return label;
    }
}
