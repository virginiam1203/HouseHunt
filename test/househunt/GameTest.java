package househunt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {
    
    private Game game;
    private Buyer mockBuyer;
    private House mockHouse1;
    private House mockHouse2;
    private House mockHouse3;
    private IntPrompter mockPrompter;
    
    @Before
    public void setUp() {
        mockBuyer = mock(Buyer.class);
        mockHouse1 = mock(House.class);
        mockHouse2 = mock(House.class);
        mockHouse3 = mock(House.class);
        mockPrompter = mock(IntPrompter.class);
        game = new Game(mockBuyer, mockHouse1, mockHouse2, mockHouse3, mockPrompter);
    }
    
    /*
     * Test that the game constructor returns non-null
     */
    @Test
    public void testGameConstructor() {
        game = null;
        game = new Game(mockBuyer, mockHouse1, mockHouse2, mockHouse3, mockPrompter);
        assertNotNull(game);
    }
    
    /*
     * Test that ask budget takes positive integer input and makes it the buyer budget
     * Requirement: FUN-BUDGET, FUN-COMMAND-PROMPT
     */
    @Test
    public void testAskBudget() {
        when(mockPrompter.ask(anyString())).thenReturn(117000);
        game.askBudget();
        verify(mockBuyer).setBudget(117000);
    }
  
    /*
     * Test that ask credit takes positive integer input and makes it the buyer credit
     * Requirement: FUN-CREDIT, FUN-COMMAND-PROMPT
     */
    @Test
    public void testAskCredit() {
        when(mockPrompter.ask(anyString())).thenReturn(500);
        game.askCredit();
        verify(mockBuyer).setCredit(500);
    }
    
    /*
     * Test that choose house lets player choose a valid house
     * Requirement: FUN-HOUSE-OPTIONS, FUN-COMMAND-PROMPT
     */
    @Test
    public void testChooseHouse() {
        when(mockPrompter.ask(anyString())).thenReturn(3);
        game.chooseHouse();
        assertEquals(game.getChosen(),game.getHouseThree());
    }
    
    /*
     * Test that a buyer makes an offer or counteroffer
     * Requirement: FUN-BUYER-OFFER, FUN-BUYER-COUNTER, FUN-COMMAND-PROMPT
     */
    @Test
    public void testNegotiateOffer() {
        when(mockPrompter.ask(anyString())).thenReturn(120000);
        boolean b = game.negotiateOffer();
        verify(mockBuyer).makeOffer(120000);
    }
    
    /*
     * Test that a seller makes a counter offer
     * Requirement: FUN-SELLER-COUNTER
     */
    @Test
    public void testSellerCounter() {
        when(mockPrompter.ask(anyString())).thenReturn(120000);
        boolean b = game.negotiateOffer();
        verify(mockHouse1).makeCounter(120000);
    }
    
    /*
     * Test that if seller counter and buyer offer are equal then the offer is accepted
     * Requirement: FUN-BUYER-ACCEPT
     */
    @Test
    public void testAcceptOffer() {
        when(mockPrompter.ask(anyString())).thenReturn(100000);
        when(mockHouse1.makeCounter(100000)).thenReturn(100000);
        when(mockBuyer.getOffer()).thenReturn(100000);
        boolean b = game.negotiateOffer();
        assertTrue(b);
    }
    
    /*
     * Test that -1 input stops negotiation and returns false
     */
    @Test
    public void testStopNegotiation() {
        when(mockPrompter.ask(anyString())).thenReturn(-1);
        when(mockHouse1.makeCounter(-1)).thenReturn(100000);
        boolean b = game.negotiateOffer();
        assertFalse(b);
    }
    
    /*
     * Test that on a win outcome prints win message
     * Requirements: FUN-WIN
     */
    @Test
    public void testPrintWin() {
        game.printOutcome(true, true, true);
        verify(mockPrompter).message("Congratulations! You bought a house.");
    }
    
    /*
     * Test that on a lose outcome prints lose message
     * Requirements: FUN-LOSE
     */
    @Test
    public void testPrintLose() {
        game.printOutcome(false, false, false);
        verify(mockPrompter).message("You failed to buy the house.");
    }
}
