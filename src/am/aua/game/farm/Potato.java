package am.aua.game.farm;

public class Potato extends Plant{
    public Potato(PlantGrowthStages stage, int gd, int tsp) {
        super(stage, gd, tsp);
    }

    public Potato() {
        super();
    }

    public String toString(){
        return "Potato stage: "+this.getStage()+"\nProgress: "+this.getTimeSincePlanted()+"/"+this.getGrowthDuration();
    }

}
