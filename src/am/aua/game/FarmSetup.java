package am.aua.game;

import am.aua.game.farm.Farm;
import am.aua.game.farm.Storage;
import am.aua.game.ui.FarmUI;

import javax.swing.*;
import java.awt.*;

public class FarmSetup {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        JFrame frame = new JFrame("Farming game");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setMinimumSize(new Dimension(820,400));
        frame.setMaximumSize(new Dimension(820,400));
        Farm mainFarm = new Farm(5, new Storage());
        mainFarm.intervalTimer();
        frame.setContentPane(new FarmUI(mainFarm));
        frame.pack();
        frame.setVisible(true);
    }
}
