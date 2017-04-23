package store.locations;

import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class Shelf {
    public String rowName;
    private ArrayList<SaleItem> products;
    private Rack rack;
    private ArrayList<String> tags;


    public Shelf(String n) {
            rowName = n;
            products = new ArrayList<SaleItem>();

    }
    public String getRowName(){
        return rowName;
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
