package am.aua.game.farm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    public String storeItem(Plant p) {
        if(p.getStage() != Plant.PlantGrowthStages.Rotten && p.getStage() == Plant.PlantGrowthStages.Rotten) {
            return "The plant is not ready to collect";
        }
        if(p.getStage() == Plant.PlantGrowthStages.Rotten){
            this.bin.add(p);
            this.amount++;
        }
        else if(p.getStage() == Plant.PlantGrowthStages.AdultPlant) {
            this.items.add(p);
            System.out.println("added p to items\n===========\n"+this.items.get(0).toString());
            this.amount++;
        }

        this.updateStorage();
        return "Storage updated";
    }

    public void updateStorage() {
        try {
            PrintWriter pw = new PrintWriter(STORAGE_PATH);
            int potatoCount = 0, tomatoCount = 0, cucumberCount = 0, cabbageCount = 0;
            for (Plant item : this.items) {
                System.out.println(item.getClass().getSimpleName());
                switch (item.getClass().getSimpleName()) {
                    case "Potato" -> potatoCount++;
                    case "Tomato" -> tomatoCount++;
                    case "Cucumber" -> cucumberCount++;
                    case "Cabbage" -> cabbageCount++;
                }
            }
            int binCount = this.bin.size();
            pw.println("Potato stored: "+potatoCount+" kg");
            pw.println("Tomato stored: "+tomatoCount+" kg");
            pw.println("Cucumber stored: "+cucumberCount+" kg");
            pw.println("Cabbage stored: "+cabbageCount+" kg");
            pw.println(" \nBin filled: "+binCount+" kg");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save into the storage file.");
            System.exit(0);
        }
    }

    public String storageInfo() {
        try {
            Scanner sc = new Scanner(new FileInputStream(STORAGE_PATH));
            StringBuilder result = new StringBuilder();
            while (sc.hasNextLine()) {
                result.append(sc.nextLine()+"\n");
            }
            sc.close();
            return result.toString();
        } catch (FileNotFoundException e) {
            return "Cannot open the storage file.";
        }
    }
}
