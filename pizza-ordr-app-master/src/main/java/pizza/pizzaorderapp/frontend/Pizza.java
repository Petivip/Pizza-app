package pizza.pizzaorderapp.frontend;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pizzaId;
    private String pic;
    private double price;
    private String size;
    private String crust;
    private String cut;
    private String bake;
    private String sauce;
    private String cheese;
    private String meat;
    private String veggie;



    @ManyToOne(fetch = FetchType.LAZY)
    public Input input;

    public Pizza() {
    }

    public Pizza(String pic, double price, String size, String crust, String cut, String bake
    , String sauce, String cheese, String meat, String veggie) {
        this.pic=pic;
        this.price=price;
        this.size=size;
        this.crust=crust;
        this.cut=cut;
        this.bake=bake;
        this.sauce=sauce;
        this.cheese=cheese;
        this.meat=meat;
        this.veggie=veggie;
    }


    public long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(long pizzaId) {
        this.pizzaId = pizzaId;
    }




    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getBake() {
        return bake;
    }

    public void setBake(String bake) {
        this.bake = bake;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getVeggie() {
        return veggie;
    }

    public void setVeggie(String veggie) {
        this.veggie = veggie;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
