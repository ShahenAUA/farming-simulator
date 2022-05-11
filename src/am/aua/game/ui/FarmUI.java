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
        if(e.getSource() instanceof JButton btn)
            System.out.println("X: "+btn.getX()/79+" Y: "+btn.getY()/79+"\n");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Shahen
        MainPanel = new JPanel();
        FarmGrid = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();
        button17 = new JButton();
        button18 = new JButton();
        button19 = new JButton();
        button20 = new JButton();
        button21 = new JButton();
        button22 = new JButton();
        button23 = new JButton();
        button24 = new JButton();
        button25 = new JButton();
        Menu = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        panel3 = new JPanel();
        Potato = new JButton();
        Close = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //======== MainPanel ========
        {
            MainPanel.setMinimumSize(new Dimension(800, 400));
            MainPanel.setPreferredSize(new Dimension(800, 400));
            MainPanel.setMaximumSize(new Dimension(800, 400));
            MainPanel.setLayout(new GridLayout(1, 2, 13, 0));

            //======== FarmGrid ========
            {
                FarmGrid.setBackground(new Color(51, 51, 0));
                FarmGrid.setBorder(LineBorder.createBlackLineBorder());
                FarmGrid.setMaximumSize(new Dimension(400, 400));
                FarmGrid.setMinimumSize(new Dimension(400, 400));
                FarmGrid.setPreferredSize(new Dimension(400, 400));
                FarmGrid.setLayout(new GridLayout(5, 5));

                //---- button1 ----
                button1.setBackground(new Color(51, 51, 0));
                button1.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button1);

                //---- button2 ----
                button2.setBackground(new Color(51, 51, 0));
                button2.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button2);

                //---- button3 ----
                button3.setBackground(new Color(51, 51, 0));
                button3.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button3);

                //---- button4 ----
                button4.setBackground(new Color(51, 51, 0));
                button4.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button4);

                //---- button5 ----
                button5.setBackground(new Color(51, 51, 0));
                button5.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button5);

                //---- button6 ----
                button6.setBackground(new Color(51, 51, 0));
                button6.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button6);

                //---- button7 ----
                button7.setBackground(new Color(51, 51, 0));
                button7.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button7);

                //---- button8 ----
                button8.setBackground(new Color(51, 51, 0));
                button8.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button8);

                //---- button9 ----
                button9.setBackground(new Color(51, 51, 0));
                button9.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button9);

                //---- button10 ----
                button10.setBackground(new Color(51, 51, 0));
                button10.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button10);

                //---- button11 ----
                button11.setBackground(new Color(51, 51, 0));
                button11.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button11);

                //---- button12 ----
                button12.setBackground(new Color(51, 51, 0));
                button12.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button12);

                //---- button13 ----
                button13.setBackground(new Color(51, 51, 0));
                button13.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button13);

                //---- button14 ----
                button14.setBackground(new Color(51, 51, 0));
                button14.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button14);

                //---- button15 ----
                button15.setBackground(new Color(51, 51, 0));
                button15.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button15);

                //---- button16 ----
                button16.setBackground(new Color(51, 51, 0));
                button16.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button16);

                //---- button17 ----
                button17.setBackground(new Color(51, 51, 0));
                button17.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button17);

                //---- button18 ----
                button18.setBackground(new Color(51, 51, 0));
                button18.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button18);

                //---- button19 ----
                button19.setBackground(new Color(51, 51, 0));
                button19.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button19);

                //---- button20 ----
                button20.setBackground(new Color(51, 51, 0));
                button20.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button20);

                //---- button21 ----
                button21.setBackground(new Color(51, 51, 0));
                button21.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button21);

                //---- button22 ----
                button22.setBackground(new Color(51, 51, 0));
                button22.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button22);

                //---- button23 ----
                button23.setBackground(new Color(51, 51, 0));
                button23.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button23);

                //---- button24 ----
                button24.setBackground(new Color(51, 51, 0));
                button24.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button24);

                //---- button25 ----
                button25.setBackground(new Color(51, 51, 0));
                button25.addActionListener(e -> farmFieldClicked(e));
                FarmGrid.add(button25);
            }
            MainPanel.add(FarmGrid);

            //======== Menu ========
            {
                Menu.setLayout(new GridLayout(2, 1));

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setText("Information will be displayed here");
                    scrollPane1.setViewportView(textArea1);
                }
                Menu.add(scrollPane1);

                //======== panel3 ========
                {
                    panel3.setAlignmentX(0.0F);
                    panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

                    //---- Potato ----
                    Potato.setText("Plant Potato");
                    panel3.add(Potato);

                    //---- Close ----
                    Close.setText("Quit");
                    Close.addActionListener(e -> closeButtonAction(e));
                    panel3.add(Close);
                }
                Menu.add(panel3);
            }
            MainPanel.add(Menu);
        }
        add(MainPanel);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Shahen
    private JPanel MainPanel;
    private JPanel FarmGrid;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JButton button21;
    private JButton button22;
    private JButton button23;
    private JButton button24;
    private JButton button25;
    private JPanel Menu;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel panel3;
    private JButton Potato;
    private JButton Close;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
