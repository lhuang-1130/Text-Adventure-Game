package package01;

import javax.swing.*;
import java.awt.*;

public class userInterface {

    JFrame window;
    JPanel titleNamePanel, start, mainTextPanel, choiceButtonPanel, playerPanel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public void createUI(Game.ChoiceHandler choiceHandler){
        //Window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.pink);
        window.setLayout(null);


        //Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 500);
        titleNamePanel.setBackground(Color.pink);

        //contain.add(titleNamePanel);

        titleNameLabel = new JLabel();
        titleNameLabel = new JLabel("Lily's Wonderland");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        start = new JPanel();
        start.setBounds(300, 400, 200, 100);
        start.setBackground(Color.pink);
        //contain.add(start);
        startButton = new JButton("Start!");
        startButton.setBackground(Color.pink);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("Start");
        startButton.setFocusPainted(false);
        start.add(startButton);

        window.add(titleNamePanel);
        window.add(start);
        window.setVisible(true);

        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.lightGray);
        //contain.add(mainTextPanel);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("Hello World!");
        mainTextArea.setBounds(100, 100, 600, 200);
        mainTextArea.setBackground(Color.lightGray);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 350, 150);
        choiceButtonPanel.setBackground(Color.pink);
        window.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.pink);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("choice1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.pink);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("choice2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.pink);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("choice3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.pink);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("choice4");
        choiceButtonPanel.add(choice4);

        choiceButtonPanel.setLayout(new GridLayout(4,1));
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600,50);
        playerPanel.setBackground(Color.lightGray);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        //playerSetup();

    }




}
