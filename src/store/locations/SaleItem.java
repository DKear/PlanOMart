package store.locations;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SaleItem {
    private double price;
    private String name = "";
    private String description = "";
    private ArrayList<String> tags;
    private boolean sale = false;
    private double salePrice;
    private String saleDescription = "";
    private Shelf shelf;
    private DecimalFormat df = new DecimalFormat("#.##");

    public SaleItem(double p, String n, String d) {
            df.format(p);
            price = p;
            name = n;
            tags = new ArrayList<>();
            salePrice = price;
            description = d;
        }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTags(){
        return tags;
    }
    public Object[] getTagsArray(){
        Object[] tagArray;
        tagArray = tags.toArray();
        return tagArray;
    }

/*    public void setSalePercentage(int salePercentage) {
        if (salePercentage > 0) {
            double amountOff = salePercentage * .01 * price;
            amountOff = Double.parseDouble(df.format(amountOff));
            salePrice = price - amountOff;
        } else {
            throw  new IllegalArgumentException();
        }

    }
    */
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double d){
        df.format(d);
        salePrice = d;}

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

    public void setDescription(String s){description = s;}

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

    public void setShelf(Shelf s) {
        shelf = s;
    }

    public Shelf getShelf(){
        return shelf;
    }

    public boolean validateItem() {
        return !(this.getPrice() <= 0 || this.getName().equals("") || this.getDescription().equals(""));
    }
    public boolean onSale(){
        return sale;
    }

    public void setSaleTrue(){
        sale = true;
    }
    public void setSaleFalse(){
        sale = false;
    }
    public void setName(String s){
        name = s;
    }
    public void setPrice(Double d){
        df.format(d);
        price = d;
    }
}