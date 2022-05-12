package am.aua.game.ui;

import am.aua.game.farm.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Shahen
 */
public class FarmUI extends JPanel {
    private Farm farm;
    private FarmField[][] farmButtons = new FarmField[5][5];

    public FarmUI(Farm f) {
        this.farm = f;
        initComponents();
    }

    private void closeButtonAction(ActionEvent e) {
        System.exit(1);
    }

    private void farmFieldClicked(ActionEvent e) {
        if(e.getSource() instanceof FarmField btn) {
            int xCo = btn.getCoordinates()[0], yCo = btn.getCoordinates()[1];
            String str = "Empty field";
            if(this.farm.getFarmSpace()[xCo][yCo] != null)
                str = this.farm.getFarmSpace()[xCo][yCo].toString();
            textArea1.setText(str);
            if (!btn.getHighlight() && !btn.getPlanted()) {
                clearAllHighlights(true, true);
                btn.setHighlight(true);
            }
            if(btn.getPlanted() && !btn.getPlantedClicked()) {
                clearAllHighlights(true, true);
                btn.setPlantedClicked(true);
            }
        }
    }

    private void clearAllHighlights(boolean highlighted, boolean plantedClicked) {
        for(int k = 0; k < 5; k++) {
            for(int p = 0; p < 5; p++){
                if(highlighted) farmButtons[k][p].setHighlight(false);
                if(plantedClicked) farmButtons[k][p].setPlantedClicked(false);
            }
        }
    }

    private void plantButtonClicked(ActionEvent e) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++){
                if(farmButtons[i][j] != null && farmButtons[i][j].getHighlight())
                    if(farmButtons[i][j].getPlanted()) {
                        textArea1.setText("Field is not empty");
                        farmButtons[i][j].setHighlight(false);
                    }
                    else if(e.getSource() instanceof JButton btn){
                        switch (btn.getText()) {
                            case "Plant Potato" -> {
                                this.farm.setPlant(i, j, new Potato());
                                farm.getFarmSpace()[i][j].setUiButton(farmButtons[i][j]);
                                farmButtons[i][j].setPlanted(true, "Potato");
                            }
                            case "Plant Tomato" -> {
                                this.farm.setPlant(i, j, new Tomato());
                                farm.getFarmSpace()[i][j].setUiButton(farmButtons[i][j]);
                                farmButtons[i][j].setPlanted(true, "Tomato");
                            }
                            case "Plant Cucumber" -> {
                                this.farm.setPlant(i, j, new Cucumber());
                                farm.getFarmSpace()[i][j].setUiButton(farmButtons[i][j]);
                                farmButtons[i][j].setPlanted(true, "Cucumber");
                            }
                            case "Plant Cabbage" -> {
                                this.farm.setPlant(i, j, new Cabbage());
                                farm.getFarmSpace()[i][j].setUiButton(farmButtons[i][j]);
                                farmButtons[i][j].setPlanted(true, "Cabbage");
                            }
                        }
                        farmButtons[i][j].setHighlight(false);
                    }
            }
        }



    }

    private void displayStorageButtonClicked(ActionEvent e) {
        textArea1.setText(this.farm.getStorage().storageInfo());
    }

    private void collectPlantButtonClicked(ActionEvent e) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.farmButtons[i][j].getPlantedClicked()) {
                    Plant p = this.farm.getFarmSpace()[i][j];
                    if(p.getStage() == Plant.PlantGrowthStages.AdultPlant || p.getStage() == Plant.PlantGrowthStages.Rotten) {
                        this.farm.getStorage().storeItem(p);
                        farmButtons[i][j].setPlanted(false, this.farm.getFarmSpace()[i][j].getClass().getSimpleName());
                        this.farm.getFarmSpace()[i][j] = null;
                        farmButtons[i][j].setColor(farmButtons[i][j].EMPTY_COLOR);
                    }
                    else{
                        textArea1.setText("The plant is not ready to collect");
                    }
                }
            }
        }

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
                    int xCo = i/5, yCo = i%5;
                    FarmField btn = new FarmField(xCo, yCo);
                    this.farmButtons[xCo][yCo] = btn;
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
                        Potato.addActionListener(e -> plantButtonClicked(e));
                        panel1.add(Potato);

                        //---- Tomato ----
                        Tomato.setText("Plant Tomato");
                        Tomato.addActionListener(e -> plantButtonClicked(e));
                        panel1.add(Tomato);
                    }
                    panel3.add(panel1);

                    //======== panel2 ========
                    {
                        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

                        //---- Cabbage ----
                        Cabbage.setText("Plant Cabbage");
                        Cabbage.addActionListener(e -> plantButtonClicked(e));
                        panel2.add(Cabbage);

                        //---- Cucumber ----
                        Cucumber.setText("Plant Cucumber");
                        Cucumber.addActionListener(e -> plantButtonClicked(e));
                        panel2.add(Cucumber);
                    }
                    panel3.add(panel2);

                    //======== panel4 ========
                    {
                        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

                        //---- Collect ----
                        Collect.setText("Collect Plant");
                        Collect.addActionListener(e -> collectPlantButtonClicked(e));
                        panel4.add(Collect);

                        //---- Storage ----
                        Storage.setText("Display Storage");
                        Storage.addActionListener(e -> displayStorageButtonClicked(e));
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
