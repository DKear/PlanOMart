import java.util.ArrayList;

public class Rack {
    private String rackName;
    private ArrayList<Shelf> shelves;
    private int maxNumOfShelves = 8;

    public Rack(String n) {
        if (n.equals(null)) {
            throw new NullPointerException();
        }
        if (!n.equals("")) {
            rackName = n;
            shelves = new ArrayList<Shelf>();
        } else {
            throw new IllegalArgumentException();
        }
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
}
