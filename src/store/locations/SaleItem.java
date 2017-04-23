package store.locations;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by joshu on 2/24/2017.
 */
public class SaleItem {
    private double price;
    private String name = "";
    private String brand = "";
    private String description = "";
    private ArrayList<String> tags;
    private double salePrice;
    private String saleDescription = "";
    private ArrayList<Shelf> shelves;
    private DecimalFormat df = new DecimalFormat("#.##");


    SaleItem(double p, String n, String b, String d) {
            df.format(p);
            price = p;
            name = n;
            brand = b;
            tags = new ArrayList<>();
            salePrice = price;
            description = d;
            shelves = new ArrayList<>();
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

    public String[] getTags() {
        if(!tags.isEmpty()) {
            String[] theTags = new String[tags.size()];
            theTags = tags.toArray(theTags);
            return theTags;
        } else {
            throw new ArrayStoreException();
        }
    }

    public void setSalePercentage(int salePercentage) {
        if (salePercentage > 0) {
            double amountOff = salePercentage * .01 * price;
            amountOff = Double.parseDouble(df.format(amountOff));
            salePrice = price - amountOff;
        } else {
            throw  new IllegalArgumentException();
        }

    }
    public double getSalePrice() {
        return salePrice;
    }

    public void setSaleDescription(String sD) {
        if (!sD.equals("")) {
            saleDescription = sD;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getSaleDescription() {
        return saleDescription;
    }

    public String getDescription() {
        return description;
    }

    public boolean addTag(String t) {
            return tags.add(t);
    }

    public boolean hasTags() {
        return !tags.isEmpty();
    }

    public boolean removeTag(String t) {
        return tags.remove(t);
    }

    public void setShelves(Shelf s){
        shelves.add(s);
    }

    public Shelf[] getShelvesWithItem(){
        if(!shelves.isEmpty()) {
            Shelf[] shelvesWithItem = new Shelf[shelves.size()];
            shelvesWithItem = shelves.toArray(shelvesWithItem);
            return shelvesWithItem;
        } else {
            throw new ArrayStoreException();
        }
    }

    public boolean validateItem(SaleItem i) {
        if (i.getPrice() > 0 || !i.getName().equals("") || !i.getBrand().equals("") || !i.getDescription().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}