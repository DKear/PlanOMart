package store.locations;

import java.util.ArrayList;
/**
 * Created by Jamie on 2/23/2017.
 */
public class Store {
    public String storeName;
    public ArrayList<Section> sections;


    public Store(String n){
        storeName = n;
        sections = new ArrayList<Section>();
    }
    public String getStoreName(){
        return storeName;
    }

    public boolean hasSections(){
        if(sections.size()==0){
            return false;
        } else {
            return true;
        }
    }

    public boolean addSection(Section s){
        sections.add(s);
        return true;
    }

    public Section[] getSections(){
        Section[] sectionArray = new Section[sections.size()];
        sectionArray = sections.toArray(sectionArray);
        return sectionArray;
    }

    public boolean removeSection(Section s){
        if(sections.contains(s)){
            sections.remove(s);
            return true;
        }
        return false;
    }

    public String[] getSectionsNames(Section[] s){
        String[] nameArray = new String[s.length];
        for(int i = 0; i < s.length; i++){
            nameArray[i] = s[i].getSectionName();
        }
        return nameArray;
    }



}
