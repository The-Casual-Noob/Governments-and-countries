package government_and_country;

/**
 * <h1>Republic.java</ha>
 * Republics use a body of representatives to represent the population
 * of a country in government. These representatives are chosen in
 * frequent elections, and they propose and vote for legislation in the
 * stead of the population.
 * 
 * @author dli20
 * @version 17-02-2019
 */
public class Republic extends Government{

	private String[] [] breakdown;
	private int numReps;
	
	public Republic(Country c){
		super(c);
	}
	
	public Republic (int nr, String i, float tr, double ba, double bu, String l, Government[] a, String[] [] bd, Country c)
    {
        super(i, tr, ba, bu, l, a, c);
        breakdown = bd;
        numReps = nr;
    }
	
	public void holdElections ()
    {
        double total = 0;
        double temp;
        for (int i = 0 ; i < breakdown.length ; i++)
        {
            temp = Math.random () * 80;
            if (temp + total <= 100)
            {
                total += temp;
            }
            else
            {
                temp = 100 - total;
                total = 100;
            }
            breakdown [i] [1] = Double.toString (temp);
        }
    }
	
	public boolean passLaw(String law, boolean isConstitutionAmend){
		if ((isConstitutionAmend && majorityVote(0.66)) || (!isConstitutionAmend && majorityVote())){
			String[] temp = passedLaws;
	        passedLaws = new String [passedLaws.length + 1];
	        for (int i = 0 ; i < temp.length ; i++)
	        {
	            passedLaws [i] = temp [i];
	        }
	        passedLaws [passedLaws.length - 1] = law;
		}
		return false;
	}
	
	public boolean repealLaw(int lawIndex, boolean isConstitutionAmend){
		if (lawIndex < passedLaws.length){
			if ((isConstitutionAmend && majorityVote(0.66)) || (!isConstitutionAmend && majorityVote())){
				return false;
			}
			else{
				String[] temp = passedLaws;
		        passedLaws = new String [passedLaws.length - 1];
		        for (int i = 0 ; i<lawIndex; i++)
		        	passedLaws[i] = temp[i];
		        for (int i = lawIndex+1; i < temp.length; i++)
		        	passedLaws[i-1] = temp[i];
			}
			return true;
        }
        System.out.println("No such law exists to be repealed.");
        return false;
	}
	
	public boolean dealWithProtest(){
		double rng = Math.random();
		if (rng < 0.1){
			holdElections();
			return false;
		}
		else if (Math.random() < 0.5){
			country.setHappiness(- 5);
			return false;
		}
		return true;
	}
	
	public void printBreakdown(){
		for (int i = 0; i < breakdown.length; i++){
			System.out.println(breakdown[i][0] + ": " + breakdown[i][1]);
		}
		System.out.println();
	}
	
	public int getNumReps(){
		return numReps;
	}
	
	public void setNumReps(int newNumReps){
		numReps = newNumReps;
	}
	
}
