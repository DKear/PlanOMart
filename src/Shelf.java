import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class Shelf {
    private int rowNum;
    private double availableSize;
    private ArrayList<SaleItem> products;
    private double maxShelfSize = 1440; // square inches based on 2.5 feet deep and 4 feet across


    public Shelf(int n, int s) {
        if(n > -1 && s > -1 && s < maxShelfSize) {
            rowNum = n;
            availableSize = s;
        } else {
            throw new IllegalArgumentException();
        }

        products = new ArrayList<SaleItem>();
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
    public SaleItem[] getProductsOnShelf() {
        SaleItem[] itemsOnShelf = new SaleItem[products.size()];
        itemsOnShelf = products.toArray(itemsOnShelf);
        return itemsOnShelf;
    }
    public boolean addItem(SaleItem i) {
        if (availableSize < i.getItemSize()) {
            return false;
        } else {
            availableSize -= i.getItemSize();
            return products.add(i);
        }
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
}
