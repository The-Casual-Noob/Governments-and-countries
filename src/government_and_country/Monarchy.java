package government_and_country;

/**
 * <h1>Monarchy.java</h1>
 * Monarchies are ruled over by an all-powerful leader (monarch). The title
 * of monarch is hereditary. The general population has little to no say in
 * how the country is run.
 * Constitutional monarchies will be considered republics in this exercise.
 * The monarch is usually seen as the representative of God.
 * @author dli20
 *
 */
public class Monarchy extends Government{

	private String successor;
	
	public Monarchy(Country c){
		super(c);
	}
	
	public Monarchy (String i, float tr, double ba, double bu, String l, Government[] a, Country c)
    {
        super(i, tr, ba, bu, l, a, c);
        successor = "none";
    }
	
	public void abdicate(){
		leader = successor;
	}
	
	public void abdicate(String newLeader){
		leader = newLeader;
	}
	
	public boolean dealWithProtest(String message){
		if (country.getName().equals("France") || message.equals("Let them eat cake!")){
			abdicate();
			return false;
		}
		else if (country.getHappiness() < 50){
			abdicate();
			return false;
		}
		else{
			country.setHappiness(- 5);
			return true;
		}
			
	}
	
	public String getSuccessor(){
		return successor;
	}
	
	public void setSuccessor(String newSuccessor){
		successor = newSuccessor;
	}
}
