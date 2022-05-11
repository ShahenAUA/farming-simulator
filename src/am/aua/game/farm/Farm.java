package am.aua.game.farm;

import java.util.Timer;
import java.util.TimerTask;

public class Farm {
    private Plant[][] farmSpace;
    private int farmDimension;

    public Farm(int fd) {
        this.farmSpace = new Plant[fd][fd];
    }

    public Farm() {
        this(5);
    }

    public void setPlant(int x, int y, Plant p) {
        this.farmSpace[x][y] = new Plant(p);
    }

    public void intervalTimer() {
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 5; j++){
                        if(farmSpace[i][j] != null){
                            farmSpace[i][j].timeTick();
                            System.out.println(farmSpace[i][j].toString());
                        }
                    }
                }
                System.out.println("Everything updated");
            }
        },0,2000);
    }


}
