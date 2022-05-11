package am.aua.game.console;

import am.aua.game.ui.FarmUI;

import javax.swing.*;

public class FarmConsole {
    public  static void main(String[] args) {
        JFrame frame = new JFrame("asd");
        frame.setContentPane(new FarmUI());
        frame.pack();
        frame.setVisible(true);
    }
}
