import java.util.ArrayList;

public class Rack {
    private String rackName;
    private ArrayList<Shelf> shelves;
    private int rackHeight = 8;
    private Aisle aisle;

    public Rack(String n) {
        rackName = n;
        shelves =  new ArrayList<Shelf>();
    }


    public String getRackName() {
        return rackName;
    }

    public Shelf[] getShelf() {
        Shelf[] shelfArray = new Shelf[shelves.size()];
        shelfArray = shelves.toArray(shelfArray);
        return shelfArray;
    }

    public boolean hasShelves() {
        if (shelves.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addShelf(Shelf s) {
        shelves.add(s);
        return true;
    }

    public boolean removeShelf(Shelf s) {
        if (shelves.contains(s)) {
            shelves.remove(s);
            return true;
        }
        return false;
    }

    public void setAisle(Aisle a){
        aisle = a;
    }

    public Aisle getAisle(){
        return aisle;
    }
}
