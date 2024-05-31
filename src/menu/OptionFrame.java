package menu;

import view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OptionFrame extends JFrame implements MouseListener {
    JLabel storeChooseMaxScore;
    JLabel t1,t2,t3,t4, difficultyText, scoreToWinText;
    JPanel storePanel, storeText, storeRadio;
    JButton button4by4;
    JButton button5by5;
    JButton button6by6;
    JButton button8by8;
    JRadioButton mode1, mode2, mode3;
    JButton  backToMenuButton;
    JPanel storeDifficutlyText, storeScoreToWinText;

    public String imagePath = "src/image/";
    private ButtonGroup group;

    private  String username = "";
    private  int size = 4;
    private  int winscore = 32;


    public OptionFrame(String username){
        this.username = username;

        storePanel = new JPanel(new GridLayout(1, 4, 20,5));
        storePanel.setBackground(new Color(0,0,0,0)); // set background to transparency
        storeText = new JPanel(new GridLayout(1, 4, 20,5));
        storeText.setBackground(new Color(0,0,0,0));
        storeDifficutlyText = new JPanel(new GridLayout(1, 1, 20,5));
        storeDifficutlyText.setBackground(new Color(0,0,0,0));
        storeScoreToWinText = new JPanel(new GridLayout(1, 1, 20,5));
        storeScoreToWinText.setBackground(new Color(0,0,0,0));

        storePanel.setBounds(100,200, 600, 150);
        storeText.setBounds(100,300, 600, 150);
        storeDifficutlyText.setBounds(100,400, 400, 150);
        storeScoreToWinText.setBounds(650,30,200,100);


        button4by4 = new JButton();
        t1 = new JLabel("4 x 4");
        String grid4by4 = imagePath + "4by4gridImage.png";
        ImageIcon grid = new ImageIcon(new ImageIcon(grid4by4).getImage().getScaledInstance
                (140,150, Image.SCALE_DEFAULT));
        button4by4.setIcon(grid);

//        ImageIcon icon = new ImageIcon(imagePath+"4by4gridImage.jpeg");
//        panel4by4.setIcon(icon);

        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Ink Free", Font.BOLD, 25));
        t1.setBackground(Color.BLACK);
//        panel4by4.setBackground(new Color(0x69E8B6));
        button4by4.addMouseListener(this);
        storePanel.add(button4by4);
        storeText.add(t1);


        button5by5 = new JButton();
        String gridImage5by5 = imagePath + "5by5gridImage.png";
        ImageIcon grid5by5 = new ImageIcon(new ImageIcon(gridImage5by5).getImage().getScaledInstance
                (140,150, Image.SCALE_DEFAULT));
        button5by5.setIcon(grid5by5);
        t2 = new JLabel("5 x 5");
        t2.setForeground(Color.WHITE);
        t2.setFont(new Font("Ink Free", Font.BOLD, 25));
        t2.setBackground(Color.BLACK);
        button5by5.setBackground(new Color(0x26C1E1));
        button5by5.addMouseListener(this);
        storePanel.add(button5by5);
        storeText.add(t2);


        button6by6 = new JButton();
        String gridImage6by6 = imagePath + "6by6gridImage.png";
        ImageIcon grid6by6 = new ImageIcon(new ImageIcon(gridImage6by6).getImage().getScaledInstance
                (140,140, Image.SCALE_DEFAULT));
        button6by6.setIcon(grid6by6);
        t3 = new JLabel("6 x 6");
        t3.setForeground(Color.WHITE);
        t3.setFont(new Font("Ink Free", Font.BOLD, 25));
        t3.setBackground(Color.BLACK);
        button6by6.setBackground(new Color(0x1266D3));
        button6by6.addMouseListener(this);
        storePanel.add(button6by6);
        storeText.add(t3);

        button8by8 = new JButton();
        String gridImage8by8 = imagePath + "8by8gridImage.png";
        ImageIcon grid8by8 = new ImageIcon(new ImageIcon(gridImage8by8).getImage().getScaledInstance
                (135, 150, Image.SCALE_DEFAULT));
        button8by8.setIcon(grid8by8);
        t4 = new JLabel("8 x 8");
        t4.setForeground(Color.WHITE);
        t4.setFont(new Font("Ink Free", Font.BOLD, 25));
        t4.setBackground(Color.BLACK);
        button8by8.setBackground(new Color(0x7413FF));
        button8by8.addMouseListener(this);
        storePanel.add(button8by8);
        storeText.add(t4);



        difficultyText = new JLabel("Please select 1 mode");
        difficultyText.setFont(new Font("Ink Free", Font.BOLD, 20));
        difficultyText.setForeground(Color.WHITE);
        storeDifficutlyText.add(difficultyText);

        scoreToWinText = new JLabel("Select score to win");
        scoreToWinText.setFont(new Font("Ink Free", Font.BOLD, 15));
        scoreToWinText.setForeground(Color.WHITE);
        storeScoreToWinText.add(scoreToWinText);


        button4by4.addActionListener(e-> {
            System.out.println("Load Game Frame");
            GameFrame gameFrame = new GameFrame(700,500, username, 4, winscore );
            gameFrame.setVisible(true);
            this.setVisible(false);
        });

        button5by5.addActionListener(e-> {
            System.out.println("Load Game Frame");
            GameFrame gameFrame = new GameFrame(700,500, username, 5, winscore );
            gameFrame.setVisible(true);
            this.setVisible(false);
        });

        button6by6.addActionListener(e-> {
            System.out.println("Load Game Frame");
            GameFrame gameFrame = new GameFrame(700,500, username, 6, winscore );
            gameFrame.setVisible(true);
            this.setVisible(false);
        });


        button8by8.addActionListener(e-> {
            System.out.println("Load Game Frame");
            GameFrame gameFrame = new GameFrame(700,500, username, 8, winscore );
            gameFrame.setVisible(true);
            this.setVisible(false);
        });


        group = new ButtonGroup();

        this.setSize(800, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.createMode1();
        this.createMode2();
        this.createMode3();
        this.createBackToMenuButton();
        this.createStartButton();
        this.createSelectMaxScoreBox();

        this.add(storePanel);
        this.add(storeText);
        this.add(storeDifficutlyText);
        this.add(storeScoreToWinText);
        this.setLocationRelativeTo(null);
        this.setBackground();

    }
    public void createStartButton(){
        button4by4 = new JButton("Start New Game");
        button4by4.setBounds(200,50,400,80);
        button4by4.setFont(new Font("Ink Free" , Font.BOLD , 30));

        button4by4.setFocusable(false);// these 3 lines make button transparent
        button4by4.setBackground(Color.white);
        button4by4.setOpaque(false);

        button4by4.setContentAreaFilled(false);
//        startbutton.setBorderPainted(false);
        button4by4.addActionListener(e-> {
            System.out.println("Load Game Frame");
            GameFrame gameFrame = new GameFrame(700,500, username, 4, winscore );
            gameFrame.setVisible(true);
            this.setVisible(false);
        });
        this.add(button4by4);
    }
    public void createBackToMenuButton(){
        backToMenuButton = new JButton("BACK");
        backToMenuButton.setFocusable(false);// these 3 lines make button transparent
        backToMenuButton.setBackground(Color.white);
        backToMenuButton.setOpaque(false);
        backToMenuButton.setBounds(40,50,100,50);
        backToMenuButton.setFont(new Font("Ink Free" , Font.BOLD , 15));
        backToMenuButton.setFocusable(false);
        backToMenuButton.setBackground(Color.white);
        backToMenuButton.addActionListener(e ->{
            MenuFrame menuFrame = new MenuFrame();
            System.out.println("Load Menu Frame");
            menuFrame.setVisible(true);
            this.dispose();
        });
        this.add(backToMenuButton);
    }
    private void createMode1(){
        mode1 = new JRadioButton("mode1");
        mode1.setFocusable(false);// these 3 lines make button transparent
        mode1.setBackground(Color.RED);
        mode1.setOpaque(false);
        mode1.setFont(new Font("Ink Free", Font.BOLD, 15));
        mode1.setForeground(Color.WHITE);
        mode1.setFocusable(false);
        mode1.setBounds(100,500,150,30);
        group.add(mode1);
        this.add(mode1);

    };
    private void createMode2(){
        mode2 = new JRadioButton("mode2");
        mode2.setFocusable(false);// these 3 lines make button transparent
        mode2.setBackground(Color.RED);
        mode2.setOpaque(false);
        mode2.setFont(new Font("Ink Free", Font.BOLD, 15));
        mode2.setForeground(Color.WHITE);
        mode2.setFocusable(false);
        mode2.setBounds(300,500,150,30);
        group.add(mode2);
        this.add(mode2);

    };
    private void createMode3(){
        mode3 = new JRadioButton("mode3");
        mode3.setFocusable(false);// these 3 lines make button transparent
        mode3.setBackground(Color.RED);
        mode3.setOpaque(false);
        mode3.setFont(new Font("Ink Free", Font.BOLD, 15));
        mode3.setForeground(Color.WHITE);
        mode3.setFocusable(false);
        mode3.setBounds(500,500,150,30);
        group.add(mode3);
        this.add(mode3);
    };
    private void createSelectMaxScoreBox(){ // combo box
        Integer[] scores = {16,32, 64,256, 512, 1028, 2048, 4096};
        JComboBox comboBox = new JComboBox(scores);
        comboBox.setSelectedIndex(1);
        comboBox.setFont(new Font("Ink Free", Font.BOLD , 14));
        comboBox.setBounds(650,100,80,30);
        comboBox.setBackground(new Color(0xFFFFFF));
        comboBox.setFocusable(false);// these 3 lines make button transparent
        comboBox.setOpaque(true);
        comboBox.setLightWeightPopupEnabled(false);
        comboBox.setForeground(Color.BLACK);



        comboBox.addActionListener(e->{
            if (e.getSource() == comboBox){

                this.winscore = (int) comboBox.getSelectedItem();
                System.out.println(this.winscore);
                System.out.println("Selected " + comboBox.getSelectedItem());

                // set it to the max score
            }
        });
        this.add(comboBox);
    }



    private void setBackground() {

        String backgroundIconPath = imagePath +"optionFrame.jpg";
        ImageIcon backgroundIcon = new ImageIcon(new ImageIcon(backgroundIconPath).getImage().getScaledInstance
                (800, 600, Image.SCALE_DEFAULT));
        JLabel background = new JLabel(backgroundIcon);
        background.setBounds(0, 0, 800, 600);
        this.add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.getSource().equals(panel4by4)){
//            panel4by4.setBorder(new LineBorder(Color.black));
//            panel5by5.setBorder(null);
//            panel6by6.setBorder(null);
//            panel8by8.setBorder(null);
//        }
//        else if (e.getSource().equals(panel5by5)){
//            panel5by5.setBorder(new LineBorder(Color.black));
//            panel4by4.setBorder(null);
//            panel6by6.setBorder(null);
//            panel8by8.setBorder(null);
//        }
//        else if (e.getSource().equals(panel6by6)){
//            panel6by6.setBorder(new LineBorder(Color.black));
//            panel4by4.setBorder(null);
//            panel5by5.setBorder(null);
//            panel8by8.setBorder(null);
//        }
//        else if (e.getSource().equals(panel8by8)){
//            panel8by8.setBorder(new LineBorder(Color.black));
//            panel4by4.setBorder(null);
//            panel5by5.setBorder(null);
//            panel6by6.setBorder(null);
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        if (e.getSource().equals(panel4by4)){
//            panel4by4.setBackground(Color.white);
//        }
//        if (e.getSource().equals(panel5by5)){
//            panel5by5.setBackground(Color.white);
//        }
//        if (e.getSource().equals(panel6by6)){
//            panel6by6.setBackground(Color.white);
//        }
//        if (e.getSource().equals(panel8by8)){
//            panel8by8.setBackground(Color.white);
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        if (e.getSource().equals(panel4by4)){
//            panel4by4.setBackground(new Color(0x69E8B6));
//
//        }
//        if (e.getSource().equals(panel5by5)){
//            panel5by5.setBackground(new Color(0x26C1E1));
//        }
//        if (e.getSource().equals(panel6by6)){
//            panel6by6.setBackground(new Color(0x1266D3));
//
//        }
//        if (e.getSource().equals(panel8by8)){
//            panel8by8.setBackground(new Color(0x7413FF));
//        }
    }
}

//class MaxScoreOptionPanel extends JFrame{
//    String maxScore;
//    public MaxScoreOptionPanel(){
//
//        ButtonGroup group = new ButtonGroup();
//        JRadioButton score_256;
//        JRadioButton score_512;
//        JRadioButton score_1028;
//        JRadioButton score_2048;
//        JRadioButton score_4096;
//
//
//        score_256 = new JRadioButton("256");
//        score_256.setSelected(true);
//        score_256.setFont(new Font("Ink Free", Font.BOLD , 15));
//        score_256.setBounds(10, 10 ,60,60);
//        score_256.setFocusable(false);
//        score_256.addActionListener(e ->{
//            System.out.println("Selected 256");
//            maxScore = "256";
//            score_256.setSelected(true);
//            this.setVisible(false);
//        });
//
//        score_512 = new JRadioButton("512");
//        score_512.setFont(new Font("Ink Free", Font.BOLD , 15));
//        score_512.setBounds(10, 80 ,60,60);
//        score_512.setFocusable(false);
//        score_512.addActionListener(e ->{
//            System.out.println("Selected 512");
//            this.setVisible(false);
//        });
//
//        score_1028 = new JRadioButton("1028");
//        score_1028.setFont(new Font("Ink Free", Font.BOLD , 15));
//        score_1028.setBounds(10, 150 ,100,60);
//        score_1028.setFocusable(false);
//        score_1028.addActionListener(e ->{
//            System.out.println("Selected 1028");
//            score_1028.setSelected(true);
//            this.setVisible(false);
//        });
//
//        score_2048 = new JRadioButton("2048");
//        score_2048.setFont(new Font("Ink Free", Font.BOLD , 15));
//        score_2048.setBounds(10, 220 ,100,60);
//        score_2048.setFocusable(false);
//        score_2048.addActionListener(e ->{
//            System.out.println("Selected 2048");
//            score_2048.setSelected(true);
//            this.setVisible(false);
//        });
//
//        score_4096 = new JRadioButton("4096");
//        score_4096.setFont(new Font("Ink Free", Font.BOLD , 15));
//        score_4096.setBounds(10, 290 ,100,60);
//        score_4096.setFocusable(false);
//        score_4096.addActionListener(e ->{
//            System.out.println("Selected 4096");
//            score_4096.setSelected(true);
//            this.setVisible(false);
//        });
//
//        group.add(score_256);
//        group.add(score_512);
//        group.add(score_1028);
//        group.add(score_2048);
//        group.add(score_4096);
//
//        this.add(score_256);
//        this.add(score_512);
//        this.add(score_1028);
//        this.add(score_2048);
//        this.add(score_4096);
//
//        this.setBounds(0,0,200,400);
//        this.setBackground(Color.WHITE);
//        this.setLayout(null);
//        this.setLocationRelativeTo(null);
//
//        this.setVisible(false);
//    }

