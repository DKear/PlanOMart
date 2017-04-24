package store.locations;

import java.util.ArrayList;

public class Aisle {
    private String aisleName;
    private ArrayList<Rack> racks;
    private ArrayList<String> tags;
    private Section section;

    public Aisle(String n) {
        aisleName = n;
        racks = new ArrayList<Rack>();
    }

    public String getAisleName() {
        return aisleName;
    }

    public String [] getRacksNames() {
        String[] nameArray = new String[racks.size()];
        int i = 0;
        for (Rack r : racks) {
            nameArray[i] = r.getRackName();
            i++;
        }
        return nameArray;
    }
    public boolean hasRacks() {
        if (racks.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addRack(Rack r) {
        racks.add(r);
        return true;
    }

    public boolean removeRack(Rack r) {
        if (racks.contains(r)) {
            racks.remove(r);
            return true;
        }
        return false;
    }

    public Rack[] getRack() {
        Rack[] rackArray = new Rack[racks.size()];
        rackArray = racks.toArray(rackArray);
        return rackArray;
    }
    public void setSection(Section s){
        section = s;
    }

    public Section getSection(){
        return section;
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
}