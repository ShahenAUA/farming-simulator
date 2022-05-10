package am.aua.game.farm;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args){

//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("5 seconds past");
//            }
//        }, 5000L);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("3 seconds past");
//            }
//        }, 3000L);
//        new Timer().scheduleAtFixedRate(new TimerTask(){
//            @Override
//            public void run(){
//                System.out.println("Every 2 seconds");
//            }
//        },0,2000);
        Potato p = new Potato();
        Potato p2 = new Potato(Plant.PlantGrowthStages.SmallPlant, 100, 50);
        Storage st = new Storage();
        st.collectPlant(p);
        st.collectPlant(p2);
    }
}
