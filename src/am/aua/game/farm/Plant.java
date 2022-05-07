package am.aua.game.farm;

public class Plant {
    public static enum PlantGrowthStages { Seed, Sprout, SmallPlant, AdultPlant }

    private PlantGrowthStages stage;
    private int growthDuration;
    private int timeSincePlanted;


    public Plant(PlantGrowthStages s, int gd, int tsp) {
        this.stage = s;
        this.growthDuration = gd;
        this.timeSincePlanted = tsp;
    }

    public Plant() {
        this(PlantGrowthStages.Seed, 600, 0);
    }

    public Plant(Plant other) {
        this.stage = other.getStage();
        this.growthDuration = other.getGrowthDuration();
        this.timeSincePlanted = other.getTimeSincePlanted();
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
}
