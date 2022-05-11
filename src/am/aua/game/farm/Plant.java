package am.aua.game.farm;

public class Plant {
    public static enum PlantGrowthStages { Seed, Sprout, SmallPlant, AdultPlant }

    private PlantGrowthStages stage;
    private int growthDuration;
    private int timeSincePlanted;
    private int weight;
    private final int tickAmount=30;


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
        this.setTimeSincePlanted(this.timeSincePlanted + this.tickAmount);
        if(this.timeSincePlanted >= 0.25 * (double) this.growthDuration && this.timeSincePlanted <= 0.50 * (double) this.growthDuration) this.setStage(PlantGrowthStages.Sprout);
        if(this.timeSincePlanted >= 0.50 * (double) this.growthDuration && this.timeSincePlanted < (double) this.growthDuration) this.setStage(PlantGrowthStages.SmallPlant);
        if(this.timeSincePlanted >= this.growthDuration) this.setStage(PlantGrowthStages.AdultPlant);
    }

    public String toString(){return this.getStage() + " " + this.getClass().getSimpleName() + ", planted: " + this.getTimeSincePlanted() + " milliseconds ago with growth duration of "+ this.getGrowthDuration();
    }
}
