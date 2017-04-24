package store.locations;

import java.util.ArrayList;

/**
 * Created by Jamie on 2/23/2017.
 */
public class Section {
    private String sectionName;
    private ArrayList<Aisle> aisles;
    private ArrayList<String> tags;
    private Store store;

    public Section(String n){
        sectionName = n;
        aisles = new ArrayList<Aisle>();
        tags = new ArrayList <String>();
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

    public String [] getAislesNames() {
        String[] nameArray = new String[aisles.size()];
        int i = 0;
        for (Aisle a : aisles) {
            nameArray[i] = a.getAisleName();
            i++;
        }
        return nameArray;
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

    public String[] getAisleNames(Aisle[] s){
        String[] nameArray = new String[s.length];
        for(int i = 0; i < s.length; i++){
            nameArray[i] = s[i].getAisleName();
        }
        return nameArray;
    }
}
