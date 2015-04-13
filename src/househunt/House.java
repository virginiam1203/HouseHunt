package househunt;

public class House {
    
    private static int _pseudoRand = 0;
    
    private int _list = 150000; //the list price
    private int _value = 120000; //the price below which seller will not sell
    private String _description;
    private String _inspection;
    private int _appraisal = 135000;
    
    public House() {
        _description = makeDescription();
        _inspection = makeInspection();
    }
    
    public House(int list, int value, int appraisal) {
        _list = list;
        _value = value;
        _appraisal = appraisal;
        _description = makeDescription();
        _inspection = makeInspection();
    }
    
    public String  getDescription() {
        return _description;
    }
    
    public String getInspection() {
        return _inspection;
    }
    
    public int getPrice() {
        return _list;
    }
    
    public int getValue() {
        return _value;
    }
    
    public int getAppraisal() {
        return _appraisal;
    }
    
    
    private String makeDescription() {
	String[] desc = { "A small 3 bedroom ranch house","A quaint 2 bedroom cottage", 
        "A massive 7 bedroom Victorian mansion", "A minimalist modern 3 bedroom", 
        "A well-maintained 4 bedroom Tudor", "A shoddy shack", "A clean 2 bedroom townhouse",
        "An update 3 bedroom home", "A 3 bedroom foreclosure", "A roomy 4 bedroom Edwardian"
         };
	
        return desc[(_pseudoRand++ % desc.length)];
    }
    
    private String makeInspection() {
	String[] insp = {"Nothing unusual found", "There is a cracked sewer line",
        "The electricity needs to be updated", "Pipes are leaking", "High radon levels",
        "House has termite infestation", "Minor cosmetic damage to walls", 
        "Retaining wall needs replacement", "Toilet does not flush"
         };
	
        return insp[(_pseudoRand++ % insp.length)];
    }
    
    public int makeCounter(int offer) {
        int counter = 0;
        //if the offer is at or higher than list price, accept it
        if (offer >= _list)
        {
            return offer;
        }
        //if the offer is at or above minimum value, ask for more up to list price
        else if (offer >= _value)
        {
            counter = offer + 5000;
            if (counter > _list)
            {
                counter = _list;
            }
        }
        //if the offer is less than the value, ask for the value
        else if (offer < _value)
        {
            counter = _value;
        }
        return counter;
    }
}
