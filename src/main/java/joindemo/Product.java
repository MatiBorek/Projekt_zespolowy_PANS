package joindemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    private double price;
    private String description;

    protected Product() {}

    
    public Product(String nazwa, int price, String description) {
        this.name = nazwa;
        this.price = price;
        this.description = description;
    }

    
    @Override
    public String toString() { return String.format("Produkt[id=%d, name='%s', price='%d']",id, name, price);    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    
    
    

}

