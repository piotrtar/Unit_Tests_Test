import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    Sale sale;
    String productName;
    BigDecimal netValue;
    int taxRate;
    BigDecimal grossValue;
    BigDecimal taxRateInBD;
    BigDecimal taxCost;
    BigDecimal totalCost;

    @BeforeEach
    void setUp() {
        productName = "testProductName";
        netValue = new BigDecimal("10.10");
        taxRate = 20;

        sale = new Sale(productName, netValue, taxRate);
    }


    @Test
    public void constructorNotNull1(){
        Sale sale2 = new Sale();
        assertNotNull(sale2);
    }


    @Test
    void testGetProductName() {
        String actual = sale.getProductName();
        assertEquals(productName, actual);
    }

    @Test
    void testSetProductName() {
        String testProductName = "testPName";
        sale.setProductName(testProductName);
        String actual = sale.getProductName();
        assertEquals(testProductName, actual);
    }

    @Test
    void testGetNetValue() {
        BigDecimal actual = sale.getNetValue();
        assertEquals(netValue, actual);
    }

    @Test
    void testSetNetValue() {
        BigDecimal testNetV = new BigDecimal("20.00");
        sale.setNetValue(testNetV);
        BigDecimal actual = sale.getNetValue();
        assertEquals(testNetV, actual);
    }

    @Test
    void testGetTaxRate() {
        int actual = sale.getTaxRate();
        assertEquals(taxRate, actual);
    }

    @Test
    void testSetTaxRate() {
        int testTaxR = 20;
        sale.setTaxRate(testTaxR);
        int actual = sale.getTaxRate();
        assertEquals(testTaxR, actual);
    }

    @Test
    void testCalculateGrossValue() {
        BigDecimal testGrossValue = sale.getGrossValue();
        BigDecimal actual = new BigDecimal("12.12");
        assertEquals(testGrossValue, actual);
    }

    @Test
    void testIsProductNameIsNotNull() {
        assertNotNull(sale.getProductName());
    }

    @Test
    void testIsNetValueIsPositive() {
        BigDecimal testNetValue = new BigDecimal("-10");
        assertThrows(IllegalArgumentException.class, ()-> {
            sale.setNetValue(testNetValue);
        });
    }

    @Test
    void testIsNetValueHasTwoDecimalPointPlaces() {
        BigDecimal testNetValue = new BigDecimal("10.5555");
        assertThrows(IllegalArgumentException.class, ()-> {
            sale.setNetValue(testNetValue);
        });
    }

    @Test
    void testIsTaxRateInRangeFirstCase() {
        int testTaxRate = 200;
        assertThrows(IllegalArgumentException.class, ()-> {
            sale.setTaxRate(testTaxRate);
        });
    }

    @Test
    void testIsTaxRateInRangeSecondCase() {
        int testTaxRate = -20;
        assertThrows(IllegalArgumentException.class, ()-> {
            sale.setTaxRate(testTaxRate);
        });
    }
}