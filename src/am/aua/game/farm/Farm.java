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
        return this.storage;
    }

    public Plant[][] getFarmSpace() {
        return this.farmSpace;
    }

    public void setFarmSpace(Plant[][] fs) {
        this.farmSpace = fs;
    }

    public void intervalTimer() {
        Plant[][] fs = this.getFarmSpace();
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 5; j++){
                        if(fs[i][j] != null && fs[i][j].getStage()!= Plant.PlantGrowthStages.Rotten){
                            fs[i][j].timeTick();
                        }
                    }
                }
            }
        },0,2000);
    }
}
