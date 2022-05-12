package am.aua.game.farm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String STORAGE_PATH = "storage.txt";
    private ArrayList<Plant> items;
    private ArrayList<Plant> bin;
    private int potatoCount;
    private int tomatoCount;
    private int cucumberCount;
    private int cabbageCount;

    public Storage(){
        load();
    }

    public void load() {
        try {
            this.items = new ArrayList<>();
            this.bin = new ArrayList<>();
            Scanner sc = new Scanner(new FileInputStream(STORAGE_PATH));
            StringBuilder result = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] strings = line.split(" ");
                for(int i = 0; i < strings.length; i++) {
                    switch(strings[0]){
                        case "Potato" -> this.setPotatoCount(Integer.parseInt(strings[2]));
                        case "Tomato" ->  this.setTomatoCount(Integer.parseInt(strings[2]));
                        case "Cucumber" -> this.setCucumberCount(Integer.parseInt(strings[2]));
                        case "Cabbage" -> this.setCabbageCount(Integer.parseInt(strings[2]));
                    }
                }
                result.append(line).append("\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the storage file.");
            System.exit(1);
        }
    }

    public int getPotatoCount() {
        return this.potatoCount;
    }

    public void setPotatoCount(int c) {
        this.potatoCount = c;
    }

    public int getTomatoCount() {
        return this.tomatoCount;
    }

    public void setTomatoCount(int c) {
        this.tomatoCount = c;
    }

    public int getCabbageCount() {
        return this.cabbageCount;
    }

    public void setCabbageCount(int c) {
        this.cabbageCount = c;
    }

    public int getCucumberCount() {
        return this.cucumberCount;
    }

    public void setCucumberCount(int c) {
        this.cucumberCount = c;
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

    public void storeItem(Plant p) {
        try {
            if(p.getStage() == Plant.PlantGrowthStages.Rotten){
                this.bin.add(p);
            }
            else if(p.getStage() == Plant.PlantGrowthStages.AdultPlant){
                this.items.add(p);
                switch (p.getClass().getSimpleName()) {
                    case "Potato" -> this.setPotatoCount(this.getPotatoCount()+1);
                    case "Tomato" ->  this.setTomatoCount(this.getTomatoCount()+1);
                    case "Cucumber" -> this.setCucumberCount(this.getCucumberCount()+1);
                    case "Cabbage" -> this.setCabbageCount(this.getCabbageCount()+1);
                }
            }

            PrintWriter pw = new PrintWriter(STORAGE_PATH);

            pw.println("Potato stored: "+this.getPotatoCount()+" kg");
            pw.println("Tomato stored: "+this.getTomatoCount()+" kg");
            pw.println("Cucumber stored: "+this.getCucumberCount()+" kg");
            pw.println("Cabbage stored: "+this.getCabbageCount()+" kg");
            pw.println("Bin filled: "+this.getBinSize()+" kg");
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
                result.append(line).append("\n");
            }
            sc.close();
            return result.toString();
        } catch (FileNotFoundException e) {
            return "Cannot open the storage file.";
        }
    }
}
