package government_and_country;
/**
 * <h1>Country.java</h1>
 * Class storing data for country of government
 * 
 * @author dli20
 * @version 17-02-2019
 */
public class Country {
	
	String name;
	private int population;
	private int militaryPop;
	private double area;
	private double naturalResources;
	private double GDP;
	private int happiness;
	
	public Country(){
		//For placeholder countries only
	}
	
	public Country(String name, int population, int militaryPop,
			float area, double naturalResourceLevel, double GDP, int happiness){
		this.name = name;
		this.population = population;
		this.militaryPop = militaryPop;
		this.area = area;
		this.naturalResources = naturalResourceLevel;
		this.GDP = GDP;
		this.happiness = happiness;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public int getMilitaryPop() {
		return militaryPop;
	}

	public double getArea() {
		return area;
	}

	public double getNaturalResources() {
		return naturalResources;
	}

	public double getGDP() {
		return GDP;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setMilitaryPop(int militaryPop) {
		this.militaryPop = militaryPop;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setNaturalResources(double naturalResources) {
		this.naturalResources = naturalResources;
	}

	public void setGDP(int gDP) {
		GDP = gDP;
	}

	public void setHappiness(int happiness) {
		this.happiness -= happiness;
		if (happiness < 0)
			happiness = 0;
		else if (happiness > 100)
			happiness = 100;
	}
	
	public void annex (Country c)
    {
        name = name+" - "+c.name;
        population += c.population;
        militaryPop += c.militaryPop;
        area += c.area;
        naturalResources += c.naturalResources;
        GDP += c.GDP;
        happiness -= 20;
    }
	
	
}
