package am.aua.game.farm;

public class Tomato extends Plant{
    public Tomato(PlantGrowthStages stage, int gd, int tsp) {
        super(stage, gd, tsp);
    }

    public Tomato() {
        super(PlantGrowthStages.Seed, 400, 0);
    }

    public String toString(){
        return "Tomato stage: "+this.getStage()+"\nProgress: "+this.getTimeSincePlanted()+"/"+this.getGrowthDuration()+" days";
    }

}