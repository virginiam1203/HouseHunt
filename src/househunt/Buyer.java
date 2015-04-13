package househunt;

public class Buyer {
    
    private int _budget = 120000;
    private int _credit = 600;
    private int _offer = 100000;
    
    public Buyer() {
        
    }

    public Buyer(int budget, int credit) {
        _budget = budget;
        _credit = credit;
    }
    
    public Buyer(int budget, int credit, int offer) {
        _budget = budget;
        _credit = credit;
        _offer = offer;
    }
    
    public int getBudget() {
        return _budget;
    }
            
    public void setBudget(int budget) {
        if (budget > 0)
            _budget = budget;
    }
    
    public int getCredit() {
        return _credit;
    }
    
    public void setCredit(int credit) {
        if (credit < 300)
            _credit = 300;
        else if (credit > 850)
            _credit = 850;
        else
            _credit = credit;
    }
    
    public int getOffer() {
        return _offer;
    }
    
    public void makeOffer(int amount) {
        _offer = amount;
    }
    
    public boolean applyMortgage() {
        if ((_offer < _budget && _credit >= 600) || 
            (_offer == _budget && _credit >= 700) || 
            (_offer <=(_budget + _budget * .1) && _credit >= 800)){
            return true;
        }
        else
            return false;
          
       
    }
    
}
