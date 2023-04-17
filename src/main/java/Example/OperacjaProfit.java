package Example;



public class OperacjaProfit {

    private String walutaIN;

    private double prowizja;

    public OperacjaProfit(String walutaIN, Double profit) {
        this.walutaIN = walutaIN;
        this.prowizja = profit;
    }

    public void setWalutaIN(String walutaIN) {
        this.walutaIN = walutaIN;
    }

    public void setProwizja(double prowizja) {
        this.prowizja = prowizja;
    }

    public String getWalutaIN() {
        return walutaIN;
    }

    public double getProwizja() {
        return prowizja;
    }
}
