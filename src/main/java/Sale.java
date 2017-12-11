import java.math.BigDecimal;

public class Sale {

    private String productName;
    private BigDecimal netValue;
    private int taxRate;
    private BigDecimal grossValue;
    private BigDecimal taxRateInBD;
    private BigDecimal taxCost;
    private BigDecimal totalCost;


    public Sale() {
    }

    public Sale(String productName, BigDecimal netValue, int taxRate) {
        this.productName = productName;
        this.netValue = netValue;
        this.taxRate = taxRate;
        this.grossValue = calculateGrossValue();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName == null) throw new IllegalArgumentException("ProductName is obligatory. Please provide ProductName.");
        this.productName = productName;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        if (netValue.compareTo(BigDecimal.ZERO) < 0 || netValue.scale() > 2) throw new IllegalArgumentException("NetValue has to be positive number with only 2 decimal point places.");
        this.netValue = netValue;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        if (taxRate > 100 | taxRate <0 ) throw new IllegalArgumentException("TaxRate can only be in range 0 - 100.");
        this.taxRate = taxRate;
    }

    public BigDecimal calculateGrossValue() {

        double taxRatePerDouble = taxRate/100.0;
        taxRateInBD = BigDecimal.valueOf(taxRatePerDouble);
        taxCost = netValue.multiply(taxRateInBD);
        totalCost = netValue.add(taxCost);
        BigDecimal result = totalCost.setScale(2, BigDecimal.ROUND_UP);
        return result;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }
}
