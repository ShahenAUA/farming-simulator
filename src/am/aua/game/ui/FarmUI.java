package am.aua.game.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Shahen
 */
public class FarmUI extends JPanel {
    public FarmUI() {
        initComponents();
    }

    private void closeButtonAction(ActionEvent e) {
        System.exit(1);
    }

    private void farmFieldClicked(ActionEvent e) {
        if(e.getSource() instanceof FarmField btn)
            if(!btn.getHighlight()) btn.setHighlight(true);
    }

    private void plantButtonClicked(ActionEvent e) {
        if(e.getSource() instanceof FarmField btn)
            if(!btn.getHighlight()) btn.setHighlight(true);
    }

    private void displayStorageButtonClicked(ActionEvent e) {
        if(e.getSource() instanceof FarmField btn)
            if(!btn.getHighlight()) btn.setHighlight(true);
    }

    private void collectPlantButtonClicked(ActionEvent e) {
        if(e.getSource() instanceof FarmField btn)
            if(!btn.getHighlight()) btn.setHighlight(true);
    }

    private void initComponents() {
        MainPanel = new JPanel();
        FarmGrid = new JPanel();
        Menu = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        panel3 = new JPanel();
        panel1 = new JPanel();
        Potato = new JButton();
        Tomato = new JButton();
        panel2 = new JPanel();
        Cabbage = new JButton();
        Cucumber = new JButton();
        panel4 = new JPanel();
        Collect = new JButton();
        Storage = new JButton();
        panel5 = new JPanel();
        Close = new JButton();

        //======== this ========
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //======== MainPanel ========
        {
            MainPanel.setMinimumSize(new Dimension(800, 400));
            MainPanel.setPreferredSize(new Dimension(800, 400));
            MainPanel.setMaximumSize(new Dimension(800, 400));
            MainPanel.setLayout(new GridLayout(1, 2, 13, 0));

            //======== FarmGrid ========
            {
                FarmGrid.setBorder(LineBorder.createBlackLineBorder());
                FarmGrid.setMaximumSize(new Dimension(400, 400));
                FarmGrid.setMinimumSize(new Dimension(400, 400));
                FarmGrid.setPreferredSize(new Dimension(400, 400));
                FarmGrid.setLayout(new GridLayout(5, 5));

                for(int i = 0; i < 25; i++) {
                    FarmField btn = new FarmField(i/5, i%5);
                    btn.addActionListener(e -> farmFieldClicked(e));
                    FarmGrid.add(btn);

                }
            }
            MainPanel.add(FarmGrid);

            //======== Menu ========
            {
                Menu.setLayout(new GridLayout(2, 1));

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setText("Information will be displayed here");
                    textArea1.setEditable(false);
                    scrollPane1.setViewportView(textArea1);
                }
                Menu.add(scrollPane1);

                //======== panel3 ========
                {
                    panel3.setAlignmentX(0.0F);
                    panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

                    //======== panel1 ========
                    {
                        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

                        //---- Potato ----
                        Potato.setText("Plant Potato");
                        panel1.add(Potato);

                        //---- Tomato ----
                        Tomato.setText("Plant Tomato");
                        panel1.add(Tomato);
                    }
                    panel3.add(panel1);

                    //======== panel2 ========
                    {
                        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

                        //---- Cabbage ----
                        Cabbage.setText("Plant Cabbage");
                        panel2.add(Cabbage);

                        //---- Cucumber ----
                        Cucumber.setText("Plant Cucumber");
                        panel2.add(Cucumber);
                    }
                    panel3.add(panel2);

                    //======== panel4 ========
                    {
                        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

                        //---- Collect ----
                        Collect.setText("Collect Plant");
                        Collect.setActionCommand("Collect Plant");
                        panel4.add(Collect);

                        //---- Storage ----
                        Storage.setText("Display Storage");
                        Storage.setActionCommand("Collect Plant");
                        panel4.add(Storage);
                    }
                    panel3.add(panel4);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

                        //---- Close ----
                        Close.setText("Quit");
                        Close.addActionListener(e -> closeButtonAction(e));
                        panel5.add(Close);
                    }
                    panel3.add(panel5);
                }
                Menu.add(panel3);
            }
            MainPanel.add(Menu);
        }
        add(MainPanel);
    }

    private JPanel MainPanel;
    private JPanel FarmGrid;
    private JPanel Menu;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel panel3;
    private JPanel panel1;
    private JButton Potato;
    private JButton Tomato;
    private JPanel panel2;
    private JButton Cabbage;
    private JButton Cucumber;
    private JPanel panel4;
    private JButton Collect;
    private JButton Storage;
    private JPanel panel5;
    private JButton Close;

}
