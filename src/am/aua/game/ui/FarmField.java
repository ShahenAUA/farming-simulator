package am.aua.game.ui;

import javax.swing.*;
import java.awt.*;

public class FarmField extends JButton {
    private final Color HIGHLIGHT_COLOR = Color.WHITE;
    private final Color EMPTY_COLOR = new Color(95, 132, 241);
    private final Color PLANTED_COLOR = new Color(95, 132, 241);
    private final Color COLLECTABLE_COLOR = new Color(95, 132, 241);
    private Color color;
    private int xCoordinate;
    private int yCoordinate;
    private boolean isHighlighted;

    public FarmField(int x, int y) {
        this.color = EMPTY_COLOR;
        this.setBackground(EMPTY_COLOR);
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.isHighlighted = false;
    }

    public int[] getCoordinates() {
        int[] coordinateArray = {this.xCoordinate, this.yCoordinate};
        return coordinateArray;
    }

    public void setPiece(String piece) {
        Icon icon = null;
        switch(piece){
            case "Potato":
                icon = new ImageIcon("icons/Potato.png");
                this.setIcon(icon);
                break;
            case "Tomato":
                icon = new ImageIcon("icons/Tomato.png");
                this.setIcon(icon);
                break;
            case "Cabbage":
                icon = new ImageIcon("icons/Cabbage.png");
                this.setIcon(icon);
                break;
            case "Cucumber":
                icon = new ImageIcon("icons/Cucumber.png");
                this.setIcon(icon);
                break;
            default:
                this.setPiece();
        }
    }

    public void setPiece() {
        this.setIcon(null);
    }

    public void setHighlight(boolean b) {
        if(b && !this.isHighlighted) { this.setBackground(Color.RED); this.isHighlighted = true; }
        else if(!b && this.isHighlighted) { this.setBackground(this.color); this.isHighlighted = false; }
    }

    public boolean getHighlight() {
        return this.isHighlighted;
    }

}
