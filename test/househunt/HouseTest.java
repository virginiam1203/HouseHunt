package househunt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HouseTest {
    
    private House house;
    
    @Before
    public void setUp() {
        house = null;
    }
    
    /*
     * Test to see if the House constructor without parameters returns non-null value
     */
    @Test
    public void testHouseConstructorNoParams() {
        house = new House();
        assertNotNull(house);
    }
   
    /*
     * Test to see if the House constructor with parameters returns non-null value
     */
    @Test
    public void testHouseConstructorWithParams() {
        house = new House(120000, 100000, 115000);
        assertNotNull(house);
    }
    
    /*
     * Test to see that a constructed house has a description
     */
    @Test
    public void testHouseDescription() {
        house = new House();
        String desc = house.getDescription();
        assertNotNull(desc);
    }
    
    /*
     * Test to see that a constructed house has an inspection
     */
    @Test
    public void testHouseInspection() {
        house = new House();
        String insp = house.getInspection();
        assertNotNull(insp);
    }
    
    /*
     * Test to see that a constructed house has a list price
     */
    @Test
    public void testHasPrice() {
        house = new House(120000, 100000, 115000);
        int price = house.getPrice();
        assertEquals(price, 120000);
    }
    
    /*
     * Test to see that a constructed house has a seller value
     */
    @Test
    public void testHasValue() {
        house = new House(120000, 100000, 115000);
        int val = house.getValue();
        assertEquals(val, 100000);
    }
    
    /*
     * Test to see that a constructed house has an appraised price
     */
    @Test
    public void testHasAppraisal() {
        house = new House(120000, 100000, 115000);
        int appraise = house.getAppraisal();
        assertEquals(appraise, 115000);
    }
    
    /*
     * Test that the seller of a house accepts a list price offer
     * Acceptance is when the counter is equal to the offer
     */
    @Test
    public void testMakeCounter() {
        house = new House(120000, 100000, 115000);
        int offer = 120000;
        int counter = house.makeCounter(offer);
        assertEquals(offer,counter);
    }
    
    /*
     * Test that if the offer is between the list and value, seller counters 
     * with offer + 5000
     */
    @Test
    public void testInRangeOffer() {
        house = new House(150000, 100000, 160000);
        int offer = 130000;
        int counter = house.makeCounter(offer);
        assertEquals(counter, 135000);   
    }
    
    /*
     * Test that if the offer is less than 5000 below the list, seller counters
     * with list price
     */
    @Test
    public void testCloseOffer() {
        house = new House(150000, 100000, 160000);
        int offer = 145000;
        int counter = house.makeCounter(offer);
        assertEquals(counter, house.getPrice());   
    }
    
    /*
     * Test that an offer lower than the seller value is countered with seller value
     */
    @Test
    public void testLowOffer() {
        house = new House(150000, 100000, 160000);
        int offer = 60000;
        int counter = house.makeCounter(offer);
        assertEquals(counter, house.getValue());   
    }
}
