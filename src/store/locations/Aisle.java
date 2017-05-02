package store.locations;

import java.util.ArrayList;

public class Aisle {
    public String aisleName;
    public ArrayList<Rack> racks;
    public ArrayList<String> tags;
    public Section section;

    public Aisle(String n) {
        aisleName = n;
        racks = new ArrayList<>();
        tags = new ArrayList<>();
    }


    public String getAisleName() {
        return aisleName;
    }

    public String getAisleDisplayName(){ return section.getSectionName() + " " + aisleName; }

    //public String getEditedName(){return section.getSectionName();}

    public void setAisleName(String s){
        aisleName = s;
    }

    public String[] getRacksNames() {
        String[] nameArray = new String[racks.size()];
        int i = 0;
        for (Rack r : racks) {
            nameArray[i] = r.getRackName();
            i++;
        }
        return nameArray;
    }
    public boolean hasRacks() {
        return !racks.isEmpty();
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

    public Object[] getTagsArray(){
        Object[] tagArray;
        tagArray = tags.toArray();
        return tagArray;
    }
    public ArrayList<String> getTags(){
        return tags;
    }

    public boolean validateAisle() {
        return !this.getAisleName().equals("");
    }
}