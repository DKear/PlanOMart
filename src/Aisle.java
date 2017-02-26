import java.util.ArrayList;

public class Aisle {
    private String aisleName;
    private ArrayList<Rack> racks;
    private Section section;

    public Aisle(String n) {
        aisleName = n;
        racks = new ArrayList<Rack>();
    }

    public String getAisleName() {
        return aisleName;
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
}