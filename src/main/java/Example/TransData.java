package Example;

public class TransData
{

    private String walutaIN;
    private String walutaOUT;
    private String valueIN;
    private String valueOUT;
    private String prowizja;

    private String operator;
    private String wymiana;
    String [] operatorNames;
    String [] wymianaNames;

    public TransData()
    {
        this.walutaIN = "";
        this.walutaOUT = "";
        this.valueIN = "";
        this.valueOUT = "";
        this.prowizja = "";
        this.operator= "";
        this.wymiana= "";

        operatorNames = new String[3];
        operatorNames[0] = "Euro (4,78)";
        operatorNames[1] = "Dollar (4,84)";
        operatorNames[2] = "Frank (4,85)";

        operator = operatorNames[0];

        wymianaNames = new String[2];
        wymianaNames[0] = "Tak";
        wymianaNames[1] = "Nie";

        wymiana = wymianaNames[0];
    }

    public String getWalutaIN() {
        return walutaIN;
    }

    public void setWalutaIN(String walutaIN) {
        this.walutaIN = walutaIN;
    }

    public String getWalutaOUT() {
        return walutaOUT;
    }

    public void setWalutaOUT(String walutaOUT) {
        this.walutaOUT = walutaOUT;
    }

    public String getValueIN() {
        return valueIN;
    }

    public void setValueIN(String valueIN) {
        this.valueIN = valueIN;
    }

    public String getValueOUT() {
        return valueOUT;
    }

    public void setValueOUT(String valueOUT) {
        this.valueOUT = valueOUT;
    }

    public String getProwizja() {
        return prowizja;
    }

    public void setProwizja(String prowizja) {
        this.prowizja = prowizja;
    }

    public String[] getOperatorNames() {
        return operatorNames;
    }

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

    public void setOperatorNames(String[] operatorNames) {
        this.operatorNames = operatorNames;
    }

    public String[] getWymianaNames() {
        return wymianaNames;
    }

    public void setWymianaNames(String[] wymianaNames) {
        this.wymianaNames = wymianaNames;
    }



}
