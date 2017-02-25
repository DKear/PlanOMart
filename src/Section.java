import java.util.ArrayList;

/**
 * Created by Jamie on 2/23/2017.
 */
public class Section {
    private String sectionName;
    private ArrayList<Aisle> aisles;
    private Store store;

    Section (String n){
        sectionName = n;
        aisles = new ArrayList<Aisle>();
    }

    public String getSectionName(){
        return sectionName;
    }

    public boolean hasAisle(){
        if(aisles.size()==0){
            return false;
        } else {
            return true;
        }
    }

    public boolean addAisle(Aisle s){
        aisles.add(s);
        return true;
    }

    public Aisle[] getAisles(){
        Aisle[] aisleArray = new Aisle[aisles.size()];
        aisleArray = aisles.toArray(aisleArray);
        return aisleArray;
    }

    public boolean removeAisle(Aisle a){
        if(aisles.contains(a)){
            aisles.remove(a);
            return true;
        }
        return false;
    }

    public void setStore(Store s){
        store = s;
    }

    public Store getStore(){
        return store;
    }
}
