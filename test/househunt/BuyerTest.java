package househunt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ginger
 */
public class BuyerTest {
    
    private Buyer buyer;
    
    @Before
    public void setUp() {
        buyer = null;
    }
    
    /*
     * Test to see if a non-null value is returned when the Buyer() constructor 
     * is called
     */
    @Test
    public void testBuyerConstructorNoParams() {
        buyer = new Buyer();
        assertNotNull(buyer);
    }
    
    /*
     * Test to see if a non-null value is returned when the Buyer() constructor 
     * is called with parameters
     */
    @Test
    public void testBuyerConstructorWithParams() {
        buyer = new Buyer(120000, 790);
        assertNotNull(buyer);
    }
    
    /*
     * Test to see if a non-null value is returned when the Buyer() constructor 
     * is called with the single offer parameter
     */
    @Test
    public void testBuyerConstructorOfferParams() {
        buyer = new Buyer(120000, 790, 100000);
        assertNotNull(buyer);
    }
    
    /*
     * Test to see if you can get the budget you just set using parameters
     */
    @Test
    public void testGetBudget(){
        buyer = new Buyer (120000, 790);
        int val = buyer.getBudget();
        assertEquals(val, 120000);
    }
    
    /*
     * Test to see if set budget works on a buyer with null parameters
     */
    @Test
    public void testSetBudget() {
        buyer = new Buyer();
        buyer.setBudget(50000);
        int val = buyer.getBudget();
        assertEquals(val, 50000);
    }
    
    /*
     * Test to see if you can get the credit you just set using parameters
     */
    @Test
    public void testGetCredit(){
        buyer = new Buyer (120000, 790);
        int val = buyer.getCredit();
        assertEquals(val, 790);
    }
    
    /*
     * Test to see if set credit works on a buyer with null parameters
     */
    @Test
    public void testSetCredit() {
        buyer = new Buyer();
        buyer.setCredit(650);
        int val = buyer.getCredit();
        assertEquals(val, 650);
    }
    
    /*
     * Test that if a budget is negative, the default budget is set
     */
    @Test
    public void testNegBudget(){
        buyer = new Buyer();
        buyer.setBudget(-100);
        int val = buyer.getBudget();
        assertEquals(val, 120000);
    }
    
    /*
     * Test that if a credit score is too low, the default score is set
     */
    @Test
    public void testLowCredit(){
        buyer = new Buyer();
        buyer.setCredit(0);
        int val = buyer.getCredit();
        assertEquals(val, 300);
    }
    
    /*
     * Test that if a credit score is too high, the default score is set
     */
    @Test
    public void testHighCredit(){
        buyer = new Buyer();
        buyer.setCredit(1000);
        int val = buyer.getCredit();
        assertEquals(val, 850);
    }
    
    /*
     * Test that we can return the offer value of a buyer once it is set
     */
    @Test
    public void testGetOffer(){
        buyer = new Buyer(100000, 500, 100000);
        int val = buyer.getOffer();
        assertEquals(val, 100000);
    }
    
    /*
     * Test that we can set the offer amount
     */
    @Test
    public void testMakeOffer(){
        buyer = new Buyer();
        buyer.makeOffer(90000);
        int val = buyer.getOffer();
        assertEquals(val, 90000);
    }
    
    /*
     * Test that the buyer can get a mortgage with good credit and within budget
     */
    @Test
    public void testGoodMortgage() {
        buyer = new Buyer(500000,800,350000);
        assertTrue(buyer.applyMortgage());
    }
    
    /*
     * Test that the buyer cannot get a mortgage with a bad credit score
     */
    @Test
    public void testBadCreditMortgage() {
        buyer = new Buyer(500000,400,350000);
        assertFalse(buyer.applyMortgage());
    }
    
    /*
     * Test that a buyer with great credit can get a house 10% above budget
     */
    @Test
    public void testGoodCreditHighMortgage(){
        buyer = new Buyer(100000, 850, 110000);
        assertTrue(buyer.applyMortgage());
    }
    
    /*
     * Test that a buyer cannot get mortgage above budget
     */
    @Test
    public void testHighMortgage(){
        buyer = new Buyer(100000, 700, 112000);
        assertFalse(buyer.applyMortgage());
    }
    
    /*
     * Test that a buyer with mediocre credit can buy a house under budget
     */
    @Test
    public void testUnderBudgetMortgage(){
        buyer = new Buyer(100000, 600, 95000);
        assertTrue(buyer.applyMortgage());
    }
}
