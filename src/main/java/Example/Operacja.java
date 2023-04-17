package Example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operacja {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String walutaIN;
    private double valueIN;
    private String walutaOUT;
    private double valueOUT;
    private double prowizja;

    private String operator;

    private String wymiana;

    String [] operatorNames;
    String [] wymianaNames;


    public Operacja(){
        this.walutaIN = "";
        this.walutaOUT = "";
        this.valueIN = 0;
        this.valueOUT = 0;
        this.prowizja = 0;
    }



    public Operacja(String walutaIN, double valueIN, String walutaOUT, double valueOUT, double prowizja) {
        this.walutaIN = walutaIN;
        this.walutaOUT = walutaOUT;
        this.valueIN = valueIN;
        this.valueOUT = valueOUT;
        this.prowizja = prowizja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWalutaIN() {
        return walutaIN;
    }

    public void setWalutaIN(String walutaIN) {
        this.walutaIN = walutaIN;
    }

    public double getValueIN() {
        return valueIN;
    }

    public void setValueIN(double valueIN) {this.valueIN = valueIN;}

    public String getWalutaOUT() {
        return walutaOUT;
    }

    public void setWalutaOUT(String walutaOUT) {
        this.walutaOUT = walutaOUT;
    }

    public double getValueOUT() {
        return valueOUT;
    }

    public void setValueOUT(double valueIOUT) {this.valueOUT = valueOUT;}

    public double getProwizja() {
        return prowizja;
    }

    public void setProwizja(double prowizja) {this.prowizja = prowizja;}

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getWymiana() {
        return wymiana;
    }

    public void setWymiana(String wymiana) {
        this.wymiana = wymiana;
    }

    public String[] getOperatorNames() {
        return operatorNames;
    }

    public void setOperatorNames(String[] operatorNames) {
        this.operatorNames = operatorNames;
    }

    public String[] getWymianaNames() {
        return wymianaNames;
    }

    public void setWymianaNames(String[] wymianaNames) {
        this.wymianaNames = wymianaNames;
    }


    @Override
    public String toString() {
        return String.format("[%s - %s - %s - %s - %s - %s]", id, valueIN, walutaIN, valueOUT, walutaOUT, prowizja);
    }

}

