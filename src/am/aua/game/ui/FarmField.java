package am.aua.game.ui;

import javax.swing.*;
import java.awt.*;

public class FarmField extends JButton {
    private final Color HIGHLIGHT_COLOR = Color.WHITE;
    private final Color EMPTY_COLOR = new Color(95, 132, 241);
    private final Color PLANTED_COLOR = new Color(95, 132, 241);
    private final Color PLANTED_CLICKED_COLOR = new Color(16, 59, 180);

    private final Color COLLECTABLE_COLOR = new Color(95, 132, 241);
    private Color color;
    private int xCoordinate;
    private int yCoordinate;
    private boolean isHighlighted;
    private boolean isPlanted;
    private boolean isPlantedClicked;

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

    public void setField(String piece) {
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
                this.setField();
        }
    }

    public void setField() {
        this.setIcon(null);
    }

    public void setHighlight(boolean b) {
        if(b && !this.isHighlighted) { this.setBackground(HIGHLIGHT_COLOR); this.isHighlighted = true; }
        else if(!b && this.isHighlighted) { this.setBackground(this.color); this.isHighlighted = false; }
    }

    public boolean getHighlight() {
        return this.isHighlighted;
    }

    public void setPlanted(boolean b, String plant) {
        if(b && !this.isPlanted) { this.setBackground(PLANTED_COLOR); this.isPlanted = true; this.setField(plant);}
        else if(!b && this.isPlanted) { this.setBackground(this.color); this.isPlanted = false; this.setField();}
    }

    public boolean getPlanted() {
        return this.isPlanted;
    }

    public void setPlantedClicked(boolean b) {
        if(b && !this.isPlantedClicked) { this.setBackground(PLANTED_CLICKED_COLOR); this.isPlantedClicked = true;}
        else if(!b && this.isPlantedClicked) { this.setBackground(this.color); this.isPlantedClicked = false;}
    }

    public boolean getPlantedClicked() {
        return this.isPlantedClicked;
    }

}
