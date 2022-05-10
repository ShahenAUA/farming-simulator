package am.aua.game.farm;

public class Plant {
    public static enum PlantGrowthStages { Seed, Sprout, SmallPlant, AdultPlant }

    private PlantGrowthStages stage;
    private int growthDuration;
    private int timeSincePlanted;
    private int weight;
    private int tickAmount;


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
        this.weight = other.getWeight();
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
        this.timeSincePlanted += this.tickAmount;
        if(timeSincePlanted >= 0.25 * (double) this.growthDuration) this.setStage(PlantGrowthStages.Sprout);
        if(timeSincePlanted >= 0.50 * (double) this.growthDuration) this.setStage(PlantGrowthStages.SmallPlant);
        if(timeSincePlanted == this.growthDuration) this.setStage(PlantGrowthStages.AdultPlant);
    }
}
