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
    private ArrayList<Plant> items = new ArrayList<>();
    private ArrayList<Plant> bin = new ArrayList<>();
    private int potatoCount;
    private int tomatoCount;
    private int cucumberCount;
    private int cabbageCount;

    public Storage(){
        this.amount = 0;
        this.items = new ArrayList<>();
        this.bin = new ArrayList<>();
        this.potatoCount = 0;
        this.tomatoCount = 0;
        this.cucumberCount = 0;
        this.cabbageCount = 0;
    }

    public Storage(Storage other){
        this.amount = other.amount;
        other.items = new ArrayList<Plant>();
        for(int i = 0; i < this.getItemsSize(); i++) {
            other.items.set(i, this.items.get(i).clone());
        }
        other.bin = new ArrayList<Plant>();
        for(int i = 0; i < this.getBinSize(); i++) {
            other.bin.set(i, this.bin.get(i).clone());
        }
    }

    public int getItemsSize() {
        if(this.items != null)
            return this.items.size();
        return 0;
    }

    public int getBinSize() {
        if(this.bin != null)
            return this.bin.size();
        return 0;
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
            this.amount++;
        }

        this.updateStorage();
        return "Storage updated";
    }

    public void updateStorage() {
        try {
            PrintWriter pw = new PrintWriter(STORAGE_PATH);
            for(int i = 0; i < this.getItemsSize(); i++) {
                switch (this.items.get(i).getClass().getSimpleName()) {
                    case "Potato" -> this.potatoCount++;
                    case "Tomato" -> this.tomatoCount++;
                    case "Cucumber" -> {
                        System.out.println("entered cucumber case "+this.cucumberCount );
                        this.cucumberCount++;
                        System.out.println("After: "+this.cucumberCount);
                    }
                    case "Cabbage" -> this.cabbageCount++;
                }
            }
            System.out.println("After everything: "+this.cucumberCount);
            pw.println("Potato stored: "+this.potatoCount+" kg");
            pw.println("Tomato stored: "+this.tomatoCount+" kg");
            pw.println("Cucumber stored: "+this.cucumberCount+" kg");
            pw.println("Cabbage stored: "+this.cabbageCount+" kg");
            pw.println(" \nBin filled: "+this.getBinSize()+" kg");
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
                String line = sc.nextLine();
                String[] strings = line.split(" ");
                for(int i = 0; i < strings.length; i++)
                    switch (strings[0]) {
                        case "Potato" -> this.potatoCount = Integer.parseInt(strings[2]);
                        case "Tomato" -> this.tomatoCount = Integer.parseInt(strings[2]);
                        case "Cucumber" ->  this.cucumberCount = Integer.parseInt(strings[2]);
                        case "Cabbage" -> this.cabbageCount = Integer.parseInt(strings[2]);
                    }
                result.append(line).append("\n");
            }
            sc.close();
            return result.toString();
        } catch (FileNotFoundException e) {
            return "Cannot open the storage file.";
        }
    }
}
