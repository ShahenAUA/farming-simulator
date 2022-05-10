package am.aua.game.farm;

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


}
