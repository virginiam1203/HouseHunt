/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package househunt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ginger
 */
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
    public void testHouseConstructorWithParams(){
        house = new House(120000, 100000, 115000);
        assertNotNull(house);
    }

}
