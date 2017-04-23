package store.locations;

import java.util.ArrayList;

public class Rack {
    private String rackName;
    private ArrayList<Shelf> shelves;
    private ArrayList<String> tags;
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
    public boolean addTag(String t){
        tags.add(t);
        return true;
    }

    public boolean removeTag(String t){
        if(tags.contains(t)) {
            tags.remove(t);
            return true;
        } else {
            return false;
        }
    }

    public String[] getTags(){
        String[] tagArray = new String[tags.size()];
        return tagArray;
    }
    public String[] getShelfNames(Shelf[] s){
        String[] nameArray = new String[s.length];
        for(int i = 0; i < s.length; i++){
            nameArray[i] = s[i].getRowName();
        }
        return nameArray;
    }
}
