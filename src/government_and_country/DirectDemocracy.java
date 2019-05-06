package government_and_country;

/**
 * <h1>DirectDemocracy.java</h1>
 * Direct democracies have all citizens vote directly on propositions
 * instead of a few hundred representatives. The population is perfectly
 * represented because they are all part of the government.
 * @author dli20
 * @version 17-02-2019
 *
 */
public class DirectDemocracy extends Government{
	
	public DirectDemocracy(Country c){
		super(c);
	}
	
	public DirectDemocracy (String i, float tr, double ba, double bu, String l, Government[] a, Country c)
    {
        super(i, tr, ba, bu, l, a, c);
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
		System.out.println("The issue was resolved by a majority vote.");
		System.out.println("Since everyone had a vote, nobody contested the result.");
		return true;
	}
	
}
