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
        aisles = new ArrayList<>();
        tags = new ArrayList <String>();
    }

    public void setSectionName(String s){
        sectionName = s;
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

    public Object[] getTagsArray(){
        Object[] tagArray;
        tagArray = tags.toArray();
        return tagArray;
    }

    public ArrayList<String> getTags(){
        return tags;
    }

    public String[] getAisleNames(Aisle[] s){
        String[] nameArray = new String[s.length];
        for(int i = 0; i < s.length; i++){
            nameArray[i] = s[i].getAisleName();
        }
        return nameArray;
    }

    @Override
    public String toString()
    {
        return getSectionName();
    }
}
