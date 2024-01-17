package pl.adrianek.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectGame extends JFrame implements ActionListener {

    JButton PlayerBot, TwoPlayers;
    SelectGame(){
        setLayout(null);

        setTitle("Kółko i krzyżyk");

        TwoPlayers = new JButton("Gracz vs Gracz");
        TwoPlayers.setBounds(100, 100, 200, 50);
        TwoPlayers.setBackground(Color.BLACK);
        TwoPlayers.setForeground(Color.WHITE);
        TwoPlayers.setBorderPainted(false);
        TwoPlayers.setOpaque(true);
        TwoPlayers.addActionListener(this);
        add(TwoPlayers);

        PlayerBot = new JButton("Gracz vs Bot");
        PlayerBot.setBounds(400, 100, 200, 50);
        PlayerBot.setBackground(Color.BLACK);
        PlayerBot.setForeground(Color.WHITE);
        PlayerBot.setBorderPainted(false);
        PlayerBot.setOpaque(true);
        PlayerBot.addActionListener(this);
        add(PlayerBot);

        setSize(700, 300);
        setLocation(300 ,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SelectGame();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(TwoPlayers)){
            setVisible(false);
            new TwoPlayers().setVisible(true);
        }
        if (e.getSource().equals(PlayerBot)){
            setVisible(false);
            new PlayerBot().setVisible(true);
        }
    }
}
