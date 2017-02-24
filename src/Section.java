/**
 * Created by Jamie on 2/23/2017.
 */
public class Section {
    private String sectionName;

    Section (String n){
        sectionName = n;
    }

    public String getSectionName(){
        return sectionName;
    }

    /*public boolean hasSections(){
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
    }*/
}
