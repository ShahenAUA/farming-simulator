package am.aua.game;

import am.aua.game.ui.FarmUI;

import javax.swing.*;
import java.awt.*;

public class FarmSetup {
    public  static void main(String[] args) {
        JFrame frame = new JFrame("Farming game");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setMinimumSize(new Dimension(820,400));
        frame.setMaximumSize(new Dimension(820,400));
        frame.setContentPane(new FarmUI());
        frame.pack();
        frame.setVisible(true);
    }
}
