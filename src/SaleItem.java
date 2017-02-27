import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItem {
    private double price;
    private String name;
    private String brand;
    private int upc;
    private int quantity;
    private String category;
    private double itemBase;
    private double itemHeight;
    private double itemArea;
    private double areaConsumed;
    private ArrayList<String> tags;
    private double salePrice;
    private String saleDescription;
    private Shelf shelf;

    SaleItem(double p, String n, String b, int u, int q, String c, double iB, double iH) {
        if (p > 0 && u > 0 && q >= 0 && iB > 0 && iH > 0 && !n.equals("")
                && !b.equals("") && !c.equals("")) {
            price = p;
            name = n;
            brand = b;
            upc = u;
            quantity = q;
            category = c;
            itemBase = iB;
            itemHeight = iH;
            itemArea = itemBase * itemHeight;
            areaConsumed = quantity * itemArea;
            tags = new ArrayList<String>();

        } else {
            throw new IllegalArgumentException();
        }
    }

    SaleItem(double p, String n, String b, int u, int q, String c, double iB, double iH, double sP, String sD) {
        if (b.equals(null) || c.equals(null) || sD.equals(null)) {
            throw new NullPointerException();
        }
        if (p > 0 && u > 0 && q >= 0 && iB > 0 && iH > 0 && sP >= 0 && sP < p && !n.equals("")
                && !b.equals("") && !c.equals("") && !sD.equals("")) {
            price = p;
            name = n;
            brand = b;
            upc = u;
            quantity = q;
            category = c;
            itemBase = iB;
            itemHeight = iH;
            itemArea = itemBase * itemHeight;
            areaConsumed = quantity * itemArea;
            salePrice = sP;
            saleDescription = sD;
            tags = new ArrayList<String>();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getUPC() {
        return upc;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getItemBase() {
        return itemBase;
    }

    public double getItemHeight() {
        return itemHeight;
    }

    public double getItemArea() {
        return itemArea;
    }

    public double getTotalAreaConsumed() {
        return areaConsumed;
    }

    public String[] getTags() {
        if(!tags.isEmpty()) {
            String[] theTags = new String[tags.size()];
            theTags = tags.toArray(theTags);
            return theTags;
        } else {
            throw new ArrayStoreException();
        }
    }

    public double getSalePrice() {
        return salePrice;
    }

    public String getSaleDescription() {
        return saleDescription;
    }

    public boolean addTag(String t) {
            return tags.add(t);
    }
    public boolean hasTags() {
        if (tags.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    public boolean removeTag(String t) {
        return tags.remove(t);
    }
    public void setShelf(Shelf s){
        shelf = s;
    }

    public Shelf getShelf(){
        return shelf;
    }
}
