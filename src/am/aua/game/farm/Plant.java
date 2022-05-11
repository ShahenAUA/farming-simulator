package am.aua.game.farm;

public abstract class Plant implements Cloneable {
    public enum PlantGrowthStages { Seed, Sprout, SmallPlant, AdultPlant, Rotten }
    private static final int tickAmount=30;

    private PlantGrowthStages stage;
    private int growthDuration;
    private int timeSincePlanted;
    private int weight;


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

    public int getWeight() { return this.weight; }
    public void setWeight(int w) { this.weight = w; }

    public void timeTick() {
        this.setTimeSincePlanted(this.timeSincePlanted + tickAmount);
        if(this.timeSincePlanted >= 1.5 * (double) this.growthDuration) {
            if (this.getStage() != PlantGrowthStages.AdultPlant) this.setStage(PlantGrowthStages.Rotten);
            return;
        }
        if(this.timeSincePlanted >= (double) this.growthDuration) {
            if (this.getStage()!=PlantGrowthStages.AdultPlant) this.setStage(PlantGrowthStages.AdultPlant);
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
