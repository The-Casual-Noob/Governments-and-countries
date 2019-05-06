package government_and_country;

/**
 * <h1>Dictatorship.java</h1>
 * Dictatorships are ruled over by an all-powerful leader that is
 * not bound by any law.
 * Dictators rely on the popular support of the people and fear of the
 * people and high-ranking officials to retaliation.
 * @author dli20
 * @version 17-02-2019
 */
public class Dictatorship extends Government{
	
	public Dictatorship(Country c){
		super(c);
	}
	
	public Dictatorship (String i, float tr, double ba, double bu, String l, Government[] a, Country c)
    {
        super(i, tr, ba, bu, l, a, c);
    }
	
	public void removeLeader(){
		leader = "none";
	}
	
	public boolean dealWithProtest(int numberOfSoldiers){
		int protestors = (int)(Math.random()*country.getPopulation()*(100-country.getHappiness())/500);
		if (numberOfSoldiers*10 < protestors){
			removeLeader();
			return false;
		}
		else{
			country.setPopulation(country.getPopulation() - protestors);
			country.setHappiness(-20);
			return true;
		}
	}
	
	public void distributePropoganda(String message){
		System.out.println("Propoganda has been released: " + message);
		country.setHappiness(1);
	}
	
}
