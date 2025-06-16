package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private float cost;

    public SimpleProduct (String name, float cost){
        super(name);
        this.cost = cost;
    }
@Override
    public float getCost(){
        return this.cost;
    }

@Override
    public String toString() {
        return this.getName() + " : " + getCost();
    }
@Override
    public boolean isSpecial(){
        return false;
        }
}
