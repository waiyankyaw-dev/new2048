package menu;

import javax.swing.*;
import java.awt.*;

public class ChangeThemeFrame extends JFrame {
    public String imagePath = "src/image/";
    public String Theme;
    JButton changeButton = new JButton();

    public ChangeThemeFrame(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(false);



        setBackground();


        changeButton = new JButton("change");
        changeButton.setBounds(100,100,100,100);
        changeButton.addActionListener(e -> {
            setTheme("a.jpg");
            System.out.println(Theme);
        });
        this.add(changeButton);
    }

//    private void createChangeTheme(){
//
//        String[] themeList = {"MenuBackground.jpg", "optionFrame.jpg"};
//        JComboBox themeBox = new JComboBox<>(themeList);
//        themeBox.setFont(new Font("Ink Free", Font.BOLD , 14));
//        themeBox.setBounds(350,100,80,30);
//
//
//        themeBox.addActionListener(e ->{
//
//
//            if (e.getSource() == themeBox){
////                System.out.print("selected: "+ themeBox);
//                System.out.println();
//                Theme = (String) themeBox.getItemAt(themeBox.getSelectedIndex());
//
//                System.out.println(Theme);
//            }
//        });
//        this.add(themeBox);
//    }



    private void setBackground() {

        String backgroundIconPath = imagePath +Theme;
        ImageIcon backgroundIcon = new ImageIcon(new ImageIcon(backgroundIconPath).getImage().getScaledInstance
                (1200, 600, Image.SCALE_DEFAULT));
        JLabel background = new JLabel(backgroundIcon);
        background.setBounds(200, 500, 300, 200);
        this.add(background);
    }

    public String getTheme(){
        return Theme;
    }

    public void setTheme(String theme){
        this.Theme = theme;
    }


}
