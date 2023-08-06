import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test WolfpackFinance methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Riya Gunda
 */
public class WolfpackFinanceTest {
 
    /** Delta value used for interest rate tests */
    public static final double DELTA = .001;
    
    /**
     * Test the isValidDate method using a non-boundary value in June
     */
    @Test
    public void testIsValidDateValidJunNonBoundary() {

        assertTrue(WolfpackFinance.isValidDate(6, 23), "WolfpackFinance.isValidDate(6, 23)");

    }
    
    /**
     * Test the isValidDate method using a boundary value in June
     */
    @Test
    public void testIsValidDateInvalidJunBoundary() {

        assertFalse(WolfpackFinance.isValidDate(6, 31), "WolfpackFinance.isValidDate(6, 31)");

    }
    
    /**
     * Test the isValidDate method using a boundary value in July
     */
    @Test
    public void testIsValidDateInvalidJulBoundary() {

        assertFalse(WolfpackFinance.isValidDate(7, 32), "WolfpackFinance.isValidDate(7, 32)");

    }    
    
    /**
     * Test the isValidDate method using an invalid month
     */
    @Test
    public void testIsValidDateInvalidMonth() {

        assertFalse(WolfpackFinance.isValidDate(9, 30), "WolfpackFinance.isValidDate(9, 30)");

    } 
    
    /**
     * Test the isValidDate method using a negative day value in July
     */
    @Test
    public void testIsValidDateJulDayNegative() {

        assertFalse(WolfpackFinance.isValidDate(7, -1), "WolfpackFinance.isValidDate(7, -1)");

    }

    /**
     * Test the isValidDate method using month = 0
     */
    @Test
    public void testIsValidDateMonthZero() {

        assertFalse(WolfpackFinance.isValidDate(0, 1), "WolfpackFinance.isValidDate(0, 1)");

    }  

    /**
     * Test the isValidDate method using a negative month value 
     */
    @Test
    public void testIsValidDateMonthNegative() {

        assertFalse(WolfpackFinance.isValidDate(-1, 1), "WolfpackFinance.isValidDate(-1, 1)");

    }        
 
    /**
     * Test the isValidDate method using June 1st
     */
    @Test
    public void testIsValidDateJun01() {
        
        assertTrue(WolfpackFinance.isValidDate(6, 1), "WolfpackFinance.isValidDate(6, 1)"); 

    }   

    /**
     * Test the isValidDate method using June 30th
     */
    @Test
    public void testIsValidDateJune30() {
        
        assertTrue(WolfpackFinance.isValidDate(6, 30), "WolfpackFinance.isValidDate(6, 30)"); 

    } 
    
    /**
     * Test the isValidDate method using July 1st
     */
    @Test
    public void testIsValidDateJul01() {
            
        assertTrue(WolfpackFinance.isValidDate(7, 1), "WolfpackFinance.isValidDate(7, 1)");

    }
    
    /**
     * Test the isValidDate method using a non-boundary value in July
     */
    @Test
    public void testIsValidDateValidJulNonBoundary() {
        
        assertTrue(WolfpackFinance.isValidDate(7, 12), "WolfpackFinance.isValidDate(7, 12)");

    }    
    
    /**
     * Test the isValidDate method using July 31st
     */
    @Test
    public void testIsValidDateJuly31() {
        
        assertTrue(WolfpackFinance.isValidDate(7, 31), "WolfpackFinance.isValidDate(7, 31)");

    }     
 
    /**
     * Test the isValidDate method using August 1st
     */
    @Test
    public void testIsValidDateAug01() {
        
        assertTrue(WolfpackFinance.isValidDate(8, 01), "WolfpackFinance.isValidDate(8, 01)");

    }   
        
    /**
     * Test the isValidDate method using a non-boundary value in August
     */ 
    @Test
    public void testIsValidDateValidAugNonBoundary() {
        
        assertTrue(WolfpackFinance.isValidDate(8, 8), "WolfpackFinance.isValidDate(8, 8)"); 

    }      

    /**
     * Test the isValidDate method using August 15th
     */
    @Test
    public void testIsValidDateAug15() {
            
        assertTrue(WolfpackFinance.isValidDate(8, 15), "WolfpackFinance.isValidDate(8, 15)");
    }
    
    /**
     * Test the isValidDate method using August 16th; an invalid date
     */
    @Test
    public void testIsValidDateAug16() {
        
        assertFalse(WolfpackFinance.isValidDate(8, 16), "WolfpackFinance.isValidDate(8, 16)");
    }      
    
    /**
     * Test the isValidDate method using July 0; an invalid date
     */
    @Test
    public void testIsValidDateJulDayZero() {
        
        assertFalse(WolfpackFinance.isValidDate(7, 0), "WolfpackFinance.isValidDate(7, 0)");
    } 

    /**
     * Testing the getInterestRate method with values to output a rate of 7.5%
     */
    @Test
    public void testGetInterestRate75() {
        
        assertEquals(7.5, WolfpackFinance.getInterestRate(2000, 720, 2000), DELTA, 
                     "WolfpackFinance.getInterestRate(2000, 720, 2000)" );
        
    }

    /**
     * Testing the getInterestRate method with not approved credit score
     */
    @Test
    public void testGetInterestRateNotApprovedCredit() {
        
        assertEquals(-1.0, WolfpackFinance.getInterestRate(1000, 300, 2000), DELTA,
                     "WolfpackFinance.getInterestRate(1000, 300, 2000)");
        
    }
    
    /**
     * Testing the getInterestRate method with not approved income
     */
    @Test
    public void testGetInterestRateNotApprovedIncome() {
        
        assertEquals(-1.0, WolfpackFinance.getInterestRate(1000, 350, 1900), DELTA, 
                     "WolfpackFinance.getInterestRate(1000, 350, 1900)");
        
    } 

    /**
     * Testing the getInterestRate method with lowest possible income value
     * to get an output of 9.0%
     */
    @Test
    public void testGetInterestRate90LowIncome() {
        
        assertEquals(9.0, WolfpackFinance.getInterestRate(1000, 600, 2000), DELTA,
                     "WolfpackFinance.getInterestRate(1000, 600, 2000)");
        
    } 

    /**
     * Testing the getInterestRate method with lowest possible credit score
     * to get an output of 9.0%
     */
    @Test
    public void testGetInterestRate90LowCredit() {
        
        assertEquals(9.0, WolfpackFinance.getInterestRate(1000, 400, 4000), DELTA,
                     "WolfpackFinance.getInterestRate(1000, 400, 4000)");
        
    } 

    /**
     * Testing the getInterestRate method with loan value greater than 10000
     */
    @Test
    public void testGetInterestRateLoanMore10000() {
        
        assertEquals(7.5, WolfpackFinance.getInterestRate(11000, 800, 2000), DELTA, 
                     "WolfpackFinance.getInterestRate(11000, 800, 2000)" );
        
    }     
    
    /**
     * Testing the getInterestRate method with credit score of 300 to 
     * output an interest rate of 8.0%
     */
    @Test
    public void testGetInterestRate80Credit300() {
        
        assertEquals(8.0, WolfpackFinance.getInterestRate(1000, 300, 6000), DELTA, 
                     "WolfpackFinance.getInterestRate(1000, 300, 6000)" );        
        
    }    


    /**
     * Testing the getInterestRate method with credit score of 500 to 
     * output an interest rate of 8.5%
     */
    @Test
    public void testGetInterestRate85Credit500() {
        
        assertEquals(8.5, WolfpackFinance.getInterestRate(6100, 500, 18500), DELTA, 
                     "WolfpackFinance.getInterestRate(6100, 800, 18500)" );                     
        
    } 

    /**
     * Testing the getInterestRate method with a loan value less than 1000
     */
    @Test
    public void testGetInterestRateLoanLess1000() {
        assertEquals(7.5, WolfpackFinance.getInterestRate(900, 800, 2000), DELTA, 
                     "WolfpackFinance.getInterestRate(11000, 800, 2000)" );
        
    }  

    /**
     * Testing the getMonthlyPayment method with a non-standard interest rate
     */
    @Test
    public void testGetMonthlyPaymentNonStandardInterest() {
        
        assertEquals(660.257, WolfpackFinance.getMonthlyPayment(26890, 8.3, 48), DELTA,
                     "WolfpackFinance.getMonthlyPayment(26890, 8.3, 48)");
        
    }
    
    /**
     * Testing the getMonthlyPayment method with a high loan amount
     */
    @Test
    public void testGetMonthlyPaymentHighLoanAmount() {
        
        assertEquals(245.545, WolfpackFinance.getMonthlyPayment(10058, 8.0, 48), DELTA,
                     "WolfpackFinance.getMonthlyPayment(10058, 8.0, 48)");
        
    }
    
    /**
     * Testing the getMonthlyPayment method with a low interest rate
     */
    @Test
    public void testGetMonthlyPaymentLowInterestRate() {
        
        assertEquals(71.559, WolfpackFinance.getMonthlyPayment(3400, 0.5, 48), DELTA,
                     "WolfpackFinance.getMonthlyPayment(3400, 0.5, 48)");
        
    }  

    /**
     * Testing the getMonthlyPayment method with a low loan amount
     */
    @Test
    public void testGetMonthlyPaymentLowLoanAmount() {
        
        assertEquals(20.503, WolfpackFinance.getMonthlyPayment(100, 10.0, 5), DELTA,
                     "WolfpackFinance.getMonthlyPayment(100, 10.0, 5)");
        
    } 

    /**
     * Testing the getMonthlyPayment method with a time period of 60 months
     */
    @Test
    public void testGetMonthlyPayment60Months() {
        
        assertEquals(149.499, WolfpackFinance.getMonthlyPayment(7550, 7.0, 60), DELTA,
                     "WolfpackFinance.getMonthlyPayment(7550, 7.0, 60)");
        
    }    

    /**
     * Testing the getMonthlyPayment method with an interest rate of 7.5%
     */
    @Test
    public void testGetMonthlyPayment75InterestRate() {
        
        assertEquals(60.496, WolfpackFinance.getMonthlyPayment(2502, 7.5, 48), DELTA,
                     "WolfpackFinance.getMonthlyPayment(2502, 7.5, 48)");
        
    }       

    /**
     * Testing the getMonthlyPayment method with an interest rate of 8.5%
     */
    @Test
    public void testGetMonthlyPayment85InterestRate() {
        
        assertEquals(123.242, WolfpackFinance.getMonthlyPayment(5000, 8.5, 48), DELTA,
                    "WolfpackFinance.getMonthlyPayment(5000, 8.5, 48)");
        
    } 
 
    /**
     * Testing the getMonthlyPayment method with an interest rate of 9.0%
     */
    @Test
    public void testGetMonthlyPayment90InterestRate() {
        
        assertEquals(24.885, WolfpackFinance.getMonthlyPayment(1000, 9.0, 48), DELTA,
                     "WolfpackFinance.getMonthlyPayment(1000, 9.0, 48)");
        
    }   

    /**
     * Testing the getMonthlyPayment method with a time period fo 30 months
     */
    @Test
    public void testGetMonthlyPayment30Months() {
        
        assertEquals(236.518, WolfpackFinance.getMonthlyPayment(9005, 9.0, 45), DELTA,
                     "WolfpackFinance.getMonthlyPayment(9005, 9.0, 45)");
        
    }
       
    /**
     * Testing the getDisbursementDate method with an application dated June 1st
     * with express processing
     */
    @Test
    public void testGetDisbursementDateJune1Express() {
        
        assertEquals("Sun, 6 4 2023", WolfpackFinance.getDisbursementDate(6, 1, true), 
                     "WolfpackFinance.getDisbursementDate(6, 1, true)");
        
    }

    /**
     * Testing the getDisbursementDate method with an application dated August 15th
     * without express processing
     */
    @Test
    public void testGetDisbursementDateAugust15NotExpress() {
        
        assertEquals("Tue, 9 5 2023", WolfpackFinance.getDisbursementDate(8, 15, false), 
                     "WolfpackFinance.getDisbursementDate(8, 15, false)");
        
    }
  
    /**
     * Testing the getDisbursementDate method with an application dated June 9th
     * without express processing
     */
    @Test
    public void testGetDisbursementDateJune9NotExpress() {
        
        assertEquals("Fri, 6 30 2023", WolfpackFinance.getDisbursementDate(6, 9, false), 
                     "WolfpackFinance.getDisbursementDate(6, 9, false)");
        
    }

    /**
     * Testing the getDisbursementDate method with an application dated August 2nd
     * without express processing
     */    
    @Test
    public void testGetDisbursementDateAugust2NotExpress() {
        
        assertEquals("Wed, 8 23 2023", WolfpackFinance.getDisbursementDate(8, 2, false),
                     "WolfpackFinance.getDisbursementDate(8, 2, false)");
        
    } 

    /**
     * Testing the getDisbursementDate method with an application dated August 10th
     * without express processing
     */
    @Test
    public void testGetDisbursementDateAugust10NotExpress() {
        
        assertEquals("Thu, 8 31 2023", WolfpackFinance.getDisbursementDate(8, 10, false),
                     "WolfpackFinance.getDisbursementDate(8, 10, false)");
        
    } 
    
    /**
     * Testing the getDisbursementDate method with an application dated June 28th
     * with express processing
     */
    @Test
    public void testGetDisbursementDateJune28Express() {
        
        assertEquals("Sat, 7 1 2023", WolfpackFinance.getDisbursementDate(6, 28, true),
                     "WolfpackFinance.getDisbursementDate(6, 28, true)");
        
    }    

    /**
     * Testing the getDisbursementDate method with an application dated July 28th
     * with express processing
     */
    @Test
    public void testGetDisbursementDateJuly28Express() {
        
        assertEquals("Mon, 7 31 2023", WolfpackFinance.getDisbursementDate(7, 28, true),
                     "WolfpackFinance.getDisbursementDate(7, 28, true)");
        
    }  

    /**
     * Testing the getDisbursementDate method with an application dated July 30th
     * without express processing
     */
    @Test
    public void testGetDisbursementDateJuly30NotExpress() {
        
        assertEquals("Sun, 8 20 2023", WolfpackFinance.getDisbursementDate(7, 30, false),
                     "WolfpackFinance.getDisbursementDate(7, 30, false)");
        
    } 

    
    
    /**
     * Test the WolfpackFinance methods with invalid values
     */ 
    @Test
    public void testInvalidMethods() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getInterestRate(0, 500, 5000),
                "Testing invalid loan amount");
        assertEquals("Invalid loan amount", exception.getMessage(),
                "Testing invalid loan amount - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getInterestRate(1000, 200, 5000),
                "Testing invalid credit score");
        assertEquals("Invalid credit score", exception.getMessage(),
                "Testing invalid credit score - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getInterestRate(1000, 500, -20),
                "Testing invalid income");
        assertEquals("Invalid income", exception.getMessage(),
                "Testing invalid income - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getMonthlyPayment(-5, 5.5, 20),
                "Testing invalid loan amount");
        assertEquals("Invalid loan amount", exception.getMessage(),
                "Testing invalid cloan amount - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getMonthlyPayment(3000, 0.49, 20),
                "Testing invalid interest rate");
        assertEquals("Invalid interest rate", exception.getMessage(),
                "Testing invalid interest rate - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getMonthlyPayment(4500, 5.5, 0),
                "Testing invalid scoret");
        assertEquals("Invalid number of months", exception.getMessage(),
                "Testing invalid number of months - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getDisbursementDate(13, 4, true),
                "Testing invalid date");
        assertEquals("Invalid date", exception.getMessage(),
                "Testing invalid date - exception message");

        exception = assertThrows(
                IllegalArgumentException.class, () -> 
                WolfpackFinance.getDisbursementDate(4, 31, false),
                "Testing invalid date");
        assertEquals("Invalid date", exception.getMessage(),
                "Testing invalid date - exception message");
    }
}