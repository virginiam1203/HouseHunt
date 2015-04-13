package househunt;

public class Game {
    
    private Buyer _buyer;
    private final House _house1;
    private final House _house2;
    private final House _house3;
    private House _chosen;
    private final IntPrompter _prompter;
    
    public Game() {
        _buyer = new Buyer();
        _house1 = new House(150000, 120000, 170000);
        _house2 = new House(100000, 90000, 90000);
        _house3 = new House(500000, 300000, 500000);
        _chosen = _house1;
        _prompter = new IntPrompter(System.in, System.out);
    }
    
    public Game(Buyer b, House h1, House h2, House h3, IntPrompter p) {
        _buyer = b;
        _house1 = h1;
        _house2 = h2;
        _house3 = h3;
        _chosen = _house1;
        _prompter = p;
    }
    
    public Buyer getBuyer() {
        return _buyer;
    }
    
    public void setBuyer(Buyer b) {
        _buyer = b;
    }
    
    public House getHouseOne() {
        return _house1;
    }
    
    public House getHouseTwo() {
        return _house2;
    }
    
    public House getHouseThree() {
        return _house3;
    }
    
    public House getChosen() {
        return _chosen;
    }
    
    public void askBudget() {
        int input = -1;
        while (input < 0)
        {
            input = _prompter.ask("Enter the buyer budget (a positive integer).");
        }
        _buyer.setBudget(input);
    }
    
    public void askCredit() {
        int input = -1;
        while (input < 0) {
            input = _prompter.ask("Enter the buyer credit score (a number between 300-850).");
        }      
        _buyer.setCredit(input);
    }
    
    public void chooseHouse() {
        int input = -1;
        while (input < 0) {
            _prompter.message("Here are your house options. Enter the number of the house you would like to purchase.");
            _prompter.message("1: " + _house1.getDescription() + " Price: " + _house1.getPrice());
            _prompter.message("2: " + _house2.getDescription() + " Price: " + _house2.getPrice());
            input = _prompter.ask("3: " + _house3.getDescription() + " Price: " + _house3.getPrice());

            if (input == 1)
               _chosen = _house1;
            else if (input == 2)
               _chosen = _house2;
            else if (input ==3)
               _chosen = _house3;
            else
               input = -1;
        }
    }
    
    public boolean negotiateOffer() {
        int sellerCounter;
        int input;
        input = _prompter.ask("Enter the amount of your offer (a positive integer):");
        _buyer.makeOffer(input);
        sellerCounter = _chosen.makeCounter(input);
        boolean cont = true;
        while(sellerCounter != _buyer.getOffer() && cont) {
            input = _prompter.ask("The seller has countered with " + sellerCounter +
            ". Make another offer, accept the offer by confirming the amount, or enter '-1' to stop negotiating.");
            if(input == -1) {
                cont = false;         
            }
            else if (input == sellerCounter) {
                _buyer.makeOffer(input);
            }
            else {
                _buyer.makeOffer(input);
                sellerCounter = _chosen.makeCounter(input);
            }
        }
        return cont;
    }
    
    public boolean getMortgage() {
        _prompter.message("The seller has accepted your offer.");
        boolean approved = _buyer.applyMortgage();
        if (approved) {
            _prompter.message("Your mortgage was approved!");
            return true;
        }
        else {
            _prompter.message("Your mortgage was denied.");
            return false;
        }
    }
    
    public boolean getAppraised() {
       if (_chosen.getAppraisal() >= _buyer.getOffer()) {
           _prompter.message("The house passed the appraisal.");
           return true;
       }           
        else {
            _prompter.message("The house failed the appraisal.");
            return false;
        }
    }
    
    public void printOutcome(boolean win) {
        if (win)
            _prompter.message("Congratulations! You bought a house.");
        else
            _prompter.message("You failed to buy the house.");
    }
               
    public void runGame() {   
        boolean offer;
        boolean approved = false;
        boolean appraised = false;
        //Get the budget
        askBudget();
       
        //Get the credit score
        askCredit();
        
        //Let player look at houses
        chooseHouse();
     
        //Negotiate offer
        offer = negotiateOffer();
               
        //apply for mortgage
        if (offer) {
            approved = getMortgage();
            if (approved) {
                appraised = getAppraised();
            }
        } 
        
        //print win or lose
        if (offer && approved && appraised)
            printOutcome(true);
        else
            printOutcome(false);
    }
}