package am.aua.game.farm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Storage {
    private static final String STORAGE_PATH = "storage.txt";
    private int amount;
    private ArrayList<Plant> items;

    public Storage(){
        this.amount = 0;
        this.items = new ArrayList<>();
    }

    public void collectPlant(Plant p) {
        items.add(p);
        try {
            PrintWriter pw = new PrintWriter(STORAGE_PATH);
            for (int i = 0; i < items.size(); i++)
                pw.println(items.get(i).toString());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save into the storage file.");
            System.exit(0);
        }
    }
}
