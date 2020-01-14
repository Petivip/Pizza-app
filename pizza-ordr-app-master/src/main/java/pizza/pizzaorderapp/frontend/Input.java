package pizza.pizzaorderapp.frontend;


import pizza.pizzaorderapp.Security.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Input {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long orderId;
    private double orderPrice;
    private String orderStatus;
    private String orderDate;
    private double tax;
    private double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    public User user;

    @OneToMany( mappedBy = "input")

    public List<Pizza> pizzaSet;

    public Input() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Pizza> getPizzaSet() {
        return pizzaSet;
    }

    public void setPizzaSet(List<Pizza> pizzaSet) {
        this.pizzaSet = pizzaSet;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
