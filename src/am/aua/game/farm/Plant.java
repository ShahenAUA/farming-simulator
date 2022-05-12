package am.aua.game.farm;

import am.aua.game.ui.FarmField;

import java.awt.*;

public abstract class Plant implements Cloneable {
    public enum PlantGrowthStages { Seed, Sprout, SmallPlant, AdultPlant, Rotten }
    private final Color ROTTEN_PLANT_COLOR = new Color(22, 49, 13);
    private final Color ADULT_PLANT_COLOR = new Color(48, 206, 43);
    private static final int tickAmount=30;

    private PlantGrowthStages stage;
    private int growthDuration;
    private int timeSincePlanted;
    private FarmField uiButton;

    public Plant(PlantGrowthStages s, int gd, int tsp) {
        this.stage = s;
        this.growthDuration = gd;
        this.timeSincePlanted = tsp;
    }

    public Plant() {
        this(PlantGrowthStages.Seed, 600, 0);
    }

    public PlantGrowthStages getStage() {
        return this.stage;
    }
    public void setStage(PlantGrowthStages st) {
        this.stage = st;
    }

    public int getGrowthDuration() {
        return this.growthDuration;
    }
    public void setGrowthDuration(int gd) {
        this.growthDuration = gd;
    }

    public int getTimeSincePlanted() {
        return this.timeSincePlanted;
    }
    public void setTimeSincePlanted(int tsp) {
        this.timeSincePlanted = tsp;
    }

    public void setUiButton(FarmField btn){
        this.uiButton = btn;
    }

    public void timeTick() {
        if(this.getStage() != PlantGrowthStages.Rotten) this.setTimeSincePlanted(this.timeSincePlanted + tickAmount);
        if(this.timeSincePlanted >= 1.5 * (double) this.growthDuration) {
            this.uiButton.setBackground(ROTTEN_PLANT_COLOR);
            this.uiButton.setColor(ROTTEN_PLANT_COLOR);
            this.setStage(PlantGrowthStages.Rotten);
            return;
        }
        if(this.timeSincePlanted >= (double) this.growthDuration) {
            if (this.getStage()!=PlantGrowthStages.AdultPlant) {
                this.uiButton.setBackground(ADULT_PLANT_COLOR);
                this.uiButton.setColor(ADULT_PLANT_COLOR);
                this.setStage(PlantGrowthStages.AdultPlant);
            }
            return;
        }
        if(this.timeSincePlanted >= 0.50 * (double) this.growthDuration) {
            if (this.getStage()!=PlantGrowthStages.SmallPlant) this.setStage(PlantGrowthStages.SmallPlant);
            return;
        }
        if(this.timeSincePlanted >= 0.25 * (double) this.growthDuration) {
            if (this.getStage()!=PlantGrowthStages.Sprout) this.setStage(PlantGrowthStages.Sprout);
        }

    }

    public Plant clone() {
        try {
            return (Plant) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
