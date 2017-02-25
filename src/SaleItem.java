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
    private double itemSize;
    private double area;
    private ArrayList<String> tags;

    SaleItem(double p, String n, String b, int u, int q, String c, double s) {
        price = p;
        name =n;
        brand = b;
        upc = u;
        quantity = q;
        category = c;
        itemSize = s;
        area = quantity * itemSize;
        tags = new ArrayList<String>();
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
    public int getUpc() {
        return upc;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getCategory() {
        return category;
    }
    public double getItemSize(){
        return itemSize;
    }
    public double getArea() {
        return area;
    }
    public String[] getTags() {
        String[] theTags = new String[tags.size()];
        theTags = tags.toArray(theTags);
        return theTags;
    }
}
