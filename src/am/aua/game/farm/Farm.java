package am.aua.game.farm;

import java.util.Timer;
import java.util.TimerTask;

public class Farm {
    private static final int farmDimension = 5;
    private Plant[][] farmSpace;
    private Storage storage;

    public Farm(int fd, Storage storage) {
        this.farmSpace = new Plant[fd][fd];
        this.storage = storage;
    }

    public Farm() {
        this(farmDimension, new Storage());
    }

    public void setPlant(int x, int y, Plant p) {
        this.farmSpace[x][y] = p.clone();
    }

    public void collectPlant(int x, int y) {
        this.storage.storeItem(this.farmSpace[x][y]);
    }

    public Storage getStorage(){
        return new Storage(this.storage);
    }

    public Plant[][] getFarmSpace() {
        return this.farmSpace;
    }

    public void intervalTimer() {
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 5; j++){
                        if(farmSpace[i][j] != null && farmSpace[i][j].getStage()!= Plant.PlantGrowthStages.Rotten){
                            farmSpace[i][j].timeTick();
                        }
                    }
                }
            }
        },0,2000);
    }
}
