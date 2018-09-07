package store.locations;

import java.util.ArrayList;
import java.util.Objects;

public class Rack {
    private String rackName;
    private ArrayList<Shelf> shelves;
    private ArrayList<String> tags;
    private int rackHeight = 8;
    private Aisle aisle;
    private Section section;

    public Rack(String n) {
        rackName = n;
        shelves =  new ArrayList<Shelf>();
        tags = new ArrayList<String>();
    }


    public String getRackName() {
        return rackName;
    }

    public String getRackDisplayName(){
        return aisle.getAisleDisplayName() + " " + rackName;
    }

    public void setRackName(String s){
        rackName = s;
    }

    public Shelf[] getShelf() {
        Shelf[] shelfArray = new Shelf[shelves.size()];
        shelfArray = shelves.toArray(shelfArray);
        return shelfArray;
    }

    public String[] getShelvesNames() {
        String[] nameArray = new String[shelves.size()];
        int i = 0;
        for (Shelf s : shelves) {
            nameArray[i] = s.getRowName();
            i++;
        }
        return nameArray;
    }

    public boolean hasShelves() {
       return !shelves.isEmpty();
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
    public void setSection(Section s){ section= s;}

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

    public Object[] getTagsArray(){
        Object[] tagArray;
        tagArray = tags.toArray();
        return tagArray;
    }
    public String[] getShelfNames(Shelf[] s){
        String[] nameArray = new String[s.length];
        for(int i = 0; i < s.length; i++){
            nameArray[i] = s[i].getRowName();
        }
        return nameArray;
    }

    public ArrayList<String> getTags(){
        return tags;
    }

    public boolean validateRack() {
        return !this.getRackName().equals("");
    }
}
