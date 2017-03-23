/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeshop;

import javax.swing.JButton;

/**
 *
 * @author Ghin
 */
public class Button extends JButton{
    private int ID;
    private String name;
    private String des;
    private double price;
    private int qty = 0;
    private Item item;
    public Button(int ID, String name, String des, double price) {
        this.ID = ID;
        this.name = name;
        this.des = des;
        this.price = price;
        item = new Item(ID, name, this.price);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    
    public int getQty() {
        return qty;
    }

    public void setQty(int qtyy) {
        qty = qtyy;
        item.setQty(qty);
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}
