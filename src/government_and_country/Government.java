package government_and_country;

/**
 * <h1>Government.java</h1>
 * The Government class.
 * Superclass for different types of government.
 * 
 * @author dli20
 * @version 17-02-2019
 */
public class Government
{
    protected String ideology;
    protected float taxRate;
    protected double balance;
    protected double budget;
    protected String leader;
    protected Government[] allies;
    protected String[] passedLaws;
    protected Country country;
    
    public Government(Country c){
    	ideology = "undetermined";
    	taxRate = 0.10f;
    	balance = 1000000;
    	budget = 1000000;
    	leader = "none";
    	allies = new Government[0];
    	passedLaws = new String[0];
    	country = c;
    }
    
    public Government (String i, float tr, double ba, double bu, String l, Government[] a, Country c)
    {
        ideology = i;
        taxRate = tr;
        balance = ba;
        budget = bu;
        leader = l;
        allies = a;
        country = c;
        
        passedLaws = new String[0];
    }
    
    public static boolean majorityVote(){
    	if (Math.random() > 0.50)
    		return true;
    	return false;
    }
    
    public static boolean majorityVote(double percentTarget){
    	if (Math.random() > percentTarget)
    		return true;
    	return false;
    }
    
    public void govern(){
    	balance -= budget;
    }
    
    
    public void collectTaxes(){
    	balance += taxRate*country.getGDP();
    }

    public boolean passLaw (String law)
    {
        String[] temp = passedLaws;
        passedLaws = new String [passedLaws.length + 1];
        for (int i = 0 ; i < temp.length ; i++)
        {
            passedLaws [i] = temp [i];
        }
        passedLaws [passedLaws.length - 1] = law;
        return true;
    }
    
    public boolean repealLaw (int lawIndex)
    {
        if (lawIndex < passedLaws.length){
        	String[] temp = passedLaws;
            passedLaws = new String [passedLaws.length - 1];
            for (int i = 0 ; i<lawIndex; i++)
            	passedLaws[i] = temp[i];
            for (int i = lawIndex+1; i < temp.length; i++)
            	passedLaws[i-1] = temp[i];
            return true;
        }
        System.out.println("No such law exists to be repealed.");
        return false;
    }
    
    public void makeAlly(Government g){
    	Government[] temp = allies;
        allies = new Government [allies.length + 1];
        allies[allies.length-1] = g;
        for (int i = 0; i < temp.length; i++)
        	allies[i] = temp[i];
    }
    
    public void removeAlly(Government g){
    	Government[] temp = allies;
        allies = new Government [allies.length - 1];
        int i = 0;
        int j = 0;
        while (i < allies.length){
        	if (temp[i].equals(g))
        		j++;
        	allies[i] = temp[j];
        	i++;
        	j++;
        }
    }
    
    public String getLaw(int lawIndex){
    	if (lawIndex < passedLaws.length)
    		return lawIndex + ") " + passedLaws[lawIndex];
    	else 
    		return "No such law exists.";
    }

	public String getIdeology() {
		return ideology;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public double getBalance() {
		return balance;
	}

	public double getBudget() {
		return budget;
	}

	public String getLeader() {
		return leader;
	}
	
	public Government[] getAllies(){
		return allies;
	}

	public Country getCountry() {
		return country;
	}

	public void setIdeology(String ideology) {
		this.ideology = ideology;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	 public boolean wageWar(Government g)
	 {
	 	while(country.getMilitaryPop()>0 && g.country.getMilitaryPop()>0)
	    {
	    	if(Math.random()>0.5)
	        {
	        	country.setMilitaryPop(country.getMilitaryPop()-1);
	        }
	        else
	        {
	        	g.country.setMilitaryPop(country.getMilitaryPop()-1);
	        }
	    }
	 	if(country.getMilitaryPop()>0)
	 	{
	 		country.annex(g.country);
	 		return true;
	 	}
	 	else 
	 	{
	 		g.country.annex(country);
	 		return false;
	 	}
	}
	 
	public void sellRecources(double amt)
	{
		country.setNaturalResources(country.getNaturalResources()-amt);
		country.setGDP((int)(country.getGDP()+(amt*1000)));
		balance+=200*amt;
	}
	    
	public void draft(int amt)
	{
		if(country.getPopulation()>=amt && country.getGDP()>=amt*10 && budget>=amt*5)
		{
			country.setMilitaryPop(country.getMilitaryPop()+amt);
			country.setPopulation(country.getPopulation()-amt);
			country.setGDP((int)(country.getGDP()-(amt*10)));
			balance-=amt*5;
		}
	}    
}