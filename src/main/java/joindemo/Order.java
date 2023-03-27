package joindemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String payment;
    private int payed;
    private String delivery;
    private String status;

    
    protected Order()   {   }


    public Order(int id, String payment, int payed, String delivery, String status) {
        this.id = id;
        this.payment = payment;
        this.payed = payed;
        this.delivery = delivery;
        this.status = status;
    }

    @Override
    public String toString() { return String.format("Order[id=%d, ]",id);    }


    public int getId() {        return id;    }
    public void setId(int id) {        this.id = id;    }

    public String getPayment() {        return payment;    }
    public void setPayment(String payment) {        this.payment = payment;    }

    public int getPayed() {        return payed;    }
    public void setPayed(int payed) {        this.payed = payed;    }

    public String getDelivery() {        return delivery;    }
    public void setDelivery(String delivery) {        this.delivery = delivery;    }

    public String getStatus() {        return status;    }
    public void setStatus(String status) {        this.status = status;    }
}

