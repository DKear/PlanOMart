import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItem {
    private double price;
    private String brand;
    private int upc;
    private int quantity;
    private String category;
    private double itemSize;
    private double area;
    private ArrayList<String> tags;
    private double salePrice;
    private String saleDescription;

    SaleItem(double p, String b, int u, int q, String c, double iS) {
        if (b.equals(null) || c.equals(null)) {
            throw new NullPointerException();
        }
        if (p > 0 && u > 0 && q >= 0 && iS > 0 && b != "" && c != "") {
            price = p;
            brand = b;
            upc = u;
            quantity = q;
            category = c;
            itemSize = iS;
            area = quantity * itemSize;
            tags = new ArrayList<String>();
        } else {
            throw new IllegalArgumentException();
        }
    }

    SaleItem(double p, String b, int u, int q, String c, double iS, double sp, String sd) {
        if (b.equals(null) || c.equals(null) || sd.equals(null)) {
            throw new NullPointerException();
        }
        if (p > 0 && u > 0 && q >= 0 && iS > 0 && sp >= 0) {
            price = p;
            brand = b;
            upc = u;
            quantity = q;
            category = c;
            itemSize = iS;
            salePrice = sp;
            saleDescription = sd;
            area = quantity * itemSize;
            tags = new ArrayList<String>();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getPrice() {
        return price;
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

    public double getItemSize() {
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

    public double getSalePrice() {
        return salePrice;
    }

    public String getSaleDescription() {
        return saleDescription;
    }
}
