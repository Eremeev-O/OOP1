package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    public float cost;
    public int discount;

    public DiscountedProduct(String name, float cost, int discount){
        super(name);
        this.cost = cost;
        this.discount = discount;
    }
    public int getDiscount(){
        return this.discount;
    }
@Override
    public float getCost(){
        return this.cost * (1 - (float) this.getDiscount()/100);
    }
@Override
    public String toString() {
        return this.getName() + " : " + getCost() + " (скидка " + getDiscount() + "%)";
    }
@Override
    public boolean isSpecial(){
        return true;
    }
}
