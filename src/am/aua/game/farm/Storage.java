package am.aua.game.farm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Storage {
    private static final String STORAGE_PATH = "storage.txt";
    private int amount;
    private ArrayList<Plant> items;
    private ArrayList<Plant> bin;

    public Storage(){
        this.amount = 0;
        this.items = new ArrayList<>();
        this.bin = new ArrayList<>();
    }

    public Storage(Storage other){
        this.amount = other.amount;
        other.items = new ArrayList<Plant>();
        for(int i = 0; i < items.size(); i++) {
            other.items.set(i, this.items.get(i).clone());
        }
        other.bin = new ArrayList<Plant>();
        for(int i = 0; i < bin.size(); i++) {
            other.bin.set(i, this.bin.get(i).clone());
        }
    }

    public void storeItem(Plant p) {
        if(p.getStage() == Plant.PlantGrowthStages.Rotten)
            this.bin.add(p);
        else
            this.items.add(p);
            this.updateStorage();

    }

    public void updateStorage() {
        try {
            PrintWriter pw = new PrintWriter(STORAGE_PATH);
            int potatoCount = 0, otherCount = 0;
            for (int i = 0; i < this.items.size(); i++){
                if(this.items.get(i).getClass().getSimpleName().equals("Potato"))
                    potatoCount++;
                else
                    otherCount++;
            }
            pw.println("Potato stored: "+potatoCount+" kg");
            pw.println("Other vegetables stored: "+otherCount+" kg");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save into the storage file.");
            System.exit(0);
        }
    }
}
