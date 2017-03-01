import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItem {
    private double price;
    private String name;
    private String brand;
    private String category;
    private ArrayList<String> tags;
    private double salePrice;
    private String saleDescription;
    private String description;
    private Shelf shelf;

    SaleItem(double p, String n, String b, String c, double sp, String d) {
        if (p > 0 && !n.equals("") && !b.equals("") && !c.equals("")) {
            price = p;
            name = n;
            brand = b;
            category = c;
            tags = new ArrayList<String>();
            salePrice = price;
            description = d;

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



    public String getCategory() {
        return category;
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
