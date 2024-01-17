package pl.adrianek.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class PlayerBot extends JFrame implements ActionListener {

    JButton b1,b2,b3, b4, b5, b6, b7, b8, b9;

    PlayerBot(){
        setLayout(null);

        setTitle("Tryb: Gracz vs Bot");

        setBackground(Color.BLACK);

        b1 = new JButton();
        b1.setBounds(100, 100, 140, 140);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBorderPainted(false);
        b1.setOpaque(true);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton();
        b2.setBounds(280, 100, 140, 140);//180
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBorderPainted(false);
        b2.setOpaque(true);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton();
        b3.setBounds(460, 100, 140, 140);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBorderPainted(false);
        b3.setOpaque(true);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton();
        b4.setBounds(100, 280, 140, 140);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBorderPainted(false);
        b4.setOpaque(true);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton();
        b5.setBounds(280, 280, 140, 140);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBorderPainted(false);
        b5.setOpaque(true);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton();
        b6.setBounds(460, 280, 140, 140);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBorderPainted(false);
        b6.setOpaque(true);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton();
        b7.setBounds(100, 460, 140, 140);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBorderPainted(false);
        b7.setOpaque(true);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton();
        b8.setBounds(280, 460, 140, 140);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBorderPainted(false);
        b8.setOpaque(true);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton();
        b9.setBounds(460, 460, 140, 140);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBorderPainted(false);
        b9.setOpaque(true);
        b9.addActionListener(this);
        add(b9);

        setSize(700, 800);
        setLocation(300 ,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked.getText().equals("")) {
            clicked.setText("X");
            clicked.setEnabled(false);

            if (czyWygrana()) {
                JOptionPane.showMessageDialog(null, "Wygrywa gracz: X");
                select();
            }  else if (czyRemis()) {
                JOptionPane.showMessageDialog(null, "Remis!");
                select();
            } else {
                List<JButton> dostepnePrzyciski = new ArrayList<>();

                for (Component c : getContentPane().getComponents()) {
                    if (c instanceof JButton && ((JButton) c).getText().equals("")) {
                        dostepnePrzyciski.add((JButton) c);
                    }
                }

                if (!dostepnePrzyciski.isEmpty()) {
                    Random rand = new Random();
                    JButton losowyPrzycisk = dostepnePrzyciski.get(rand.nextInt(dostepnePrzyciski.size()));
                    losowyPrzycisk.setText("O");
                    losowyPrzycisk.setEnabled(false);

                    if (czyWygrana()) {
                        JOptionPane.showMessageDialog(null, "Wygrywa gracz: O");
                        select();
                    } else if (czyRemis()) {
                        JOptionPane.showMessageDialog(null, "Remis!");
                        select();
                    }
                }
            }
        }
    }

    private boolean czyWygrana() {
        String[][] plansza = {
                {b1.getText(), b2.getText(), b3.getText()},
                {b4.getText(), b5.getText(), b6.getText()},
                {b7.getText(), b8.getText(), b9.getText()},
                {b1.getText(), b5.getText(), b9.getText()},
                {b3.getText(), b5.getText(), b7.getText()},
                {b2.getText(), b5.getText(), b8.getText()},
                {b3.getText(), b6.getText(), b9.getText()},
                {b1.getText(), b4.getText(), b7.getText()}
        };

        for (int i = 0; i < 8; i++) {
            if (plansza[i][0].equals(plansza[i][1]) && plansza[i][1].equals(plansza[i][2]) && (!plansza[i][0].equals(""))) {
                return true;
            }
        }
        return false;
    }

    private void select(){
        String[] options = {"Graj ponownie", "Menu główne"};
        int result = JOptionPane.showOptionDialog(null,
                "Grasz ponownie?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if(result == JOptionPane.YES_OPTION){
            setVisible(false);
            new PlayerBot().setVisible(true);
        }else if (result == JOptionPane.NO_OPTION){
            setVisible(false);
            new SelectGame().setVisible(true);
        }else {
            setVisible(false);
            new SelectGame().setVisible(true);
        }
    }

    private boolean czyRemis() {
        for (Component c : getContentPane().getComponents()) {
            if (c instanceof JButton && ((JButton) c).getText().equals("")) {
                return false;
            }
        }
        return true;
    }
}
