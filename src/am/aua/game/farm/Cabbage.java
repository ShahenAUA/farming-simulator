package am.aua.game.farm;

public class Cabbage extends Plant{
    public Cabbage(PlantGrowthStages stage, int gd, int tsp) {
        super(stage, gd, tsp);
    }

    public Cabbage() {
        super(PlantGrowthStages.Seed, 600, 0);
    }

    public String toString(){
        return "Cabbage stage: "+this.getStage()+"\nProgress: "+this.getTimeSincePlanted()+"/"+this.getGrowthDuration()+" days";
    }

}
