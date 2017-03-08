import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class Shelf {
    private int rowNum;
    private double availableSize;
    private ArrayList<SaleItem> products;
    private double maxShelfSize = 1440; // square inches based on 2.5 feet deep and 4 feet across
    private Rack rack;
    private ArrayList<String> tags;


    public Shelf(int n, int s) {
        if(n >= 0 && s >= 0 && s < maxShelfSize) {
            rowNum = n;
            availableSize = s;
            products = new ArrayList<SaleItem>();
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getRowNum(){
        return rowNum;
    }
    public int getNumOfItemsOnShelf(){
        return products.size();
    }
    public double getAvailableSize() {
        return availableSize;
    }
    public double getShelfMaxSize() {
        return maxShelfSize;
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

        /*if (availableSize < i.getTotalAreaConsumed()) {
            return false;
        } else {
            availableSize -= i.getTotalAreaConsumed();
            return products.add(i);
        }*/
    }
    public boolean hasItems() {
        if (products.size() == 0) {
            return false;
        } else {
            return true;
        }
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
