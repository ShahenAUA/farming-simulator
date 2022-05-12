package am.aua.game.farm;

public class Cucumber extends Plant{
    public Cucumber(PlantGrowthStages stage, int gd, int tsp) {
        super(stage, gd, tsp);
    }

    public Cucumber() {
        super(PlantGrowthStages.Seed, 300, 0);
    }

    public String toString(){
        return "Cucumber stage: "+this.getStage()+"\nProgress: "+this.getTimeSincePlanted()+"/"+this.getGrowthDuration()+" days";
    }

}