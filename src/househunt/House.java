package househunt;

public class House {
    
    private int _list; //the list price
    private int _value; //the price below which seller will not sell
    private String _description;
    private String _inspection;
    private int _appraisal;
    
    public House(){
        
    }
    
    public House(int list, int value, int appraisal){
        _list = list;
        _value = value;
        _appraisal = appraisal;
    }
    
}
