package am.aua.game.farm;

public class Potato extends Plant{
    public Potato(PlantGrowthStages stage, int gd, int tsp) {
        super(stage, gd, tsp);
    }

    public Potato() {
        super();
    }

    public String toString(){
        return this.getStage() + " potato, planted: " + this.getTimeSincePlanted() + " milliseconds ago";
    }

}
