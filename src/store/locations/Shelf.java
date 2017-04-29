package store.locations;

import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class Shelf {
    public String rowName;
    private ArrayList<SaleItem> products;
    private Rack rack;
    private Aisle aisle;
    private Section section;
    private ArrayList<String> tags;


    public Shelf(String n) {
            rowName = n;
            products = new ArrayList<SaleItem>();
        tags = new ArrayList<String>();

    }
    public String getRowName(){
        return rowName;
    }

    public String getRowDisplayName(){
        return rack.getRackDisplayName() + " " + rowName;
    }

    public void setRowName(String s){
        rowName = s;
    }

    public int getNumOfItemsOnShelf(){
        return products.size();
    }
    public SaleItem[] getItemsOnShelf() {
        if (!products.isEmpty()) {
            SaleItem[] itemsOnShelf = new SaleItem[products.size()];
            itemsOnShelf = products.toArray(itemsOnShelf);
            return itemsOnShelf;
        } else {
            throw new ArrayStoreException();
        }
    }
    public boolean addItem(SaleItem i) {
        return products.add(i);
    }
    public boolean hasItems() {
        return !products.isEmpty();
    }
    public boolean removeItems(SaleItem i) {
           return products.remove(i);
    }
    public void setRack(Rack r){
        rack = r;
    }
    public Rack getRack(){
        return rack;
    }
    public void setAisle(Aisle a){aisle = a;}
    public void setSection(Section s){section = s;}
    public Aisle getAisle(){return aisle;}
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
}
