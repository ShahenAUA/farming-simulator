package am.aua.game;

import am.aua.game.ui.FarmUI;

import javax.swing.*;
import java.awt.*;

public class FarmSetup {
    public  static void main(String[] args) {
        JFrame frame = new JFrame("Farming game");
        frame.setMinimumSize(new Dimension(800,600));
        frame.setContentPane(new FarmUI());
        frame.pack();
        frame.setVisible(true);
    }
}
