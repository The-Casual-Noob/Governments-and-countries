package government_and_country;

/**
 * <h1>Main.java</h1>
 * The driver class for this project.
 * Tests the mechanics of each class and subclass.
 * 
 * @author dli20
 * @version 18-02-2019
 */
public class Main {

	private Country placehold, c, usa;
	private Government germany, saudiArabia;
	private Government alliesArr[];

	public Main(){
		//Placeholder values
		placehold = new Country();
		//Creating a country to use: modeled off of real-life Canada
		c = new Country("Canada", 35000000, 100000, 11000000f, 100, 1500000000000.00, 100);
		usa = new Country("USA", 340000000, 100000, 10000000f, 100, 16000000000000.00, 100);
		germany = new Government(placehold);
		saudiArabia = new Government(placehold);
		alliesArr = new Government[1];
		alliesArr[0] = germany;
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.testGovernment();
		//m.testRepublic();
		//m.testDirectDemocracy();
		//m.testDictatorship();
		//m.testMonarchy();
	}
	
	public void testGovernment(){
		//Testing the mechanics of the Government superclass
		Government govCAN = new Government("Meritocracy", 0.13f, 40000000000.0, 338500000000.0, "Justin Trudeau", alliesArr, c);
		govCAN.setLeader("Jake B. Mayer");
		Government govUSA = new Government("Pediocracy", 0.02f, 1600000000000.0,1745600000000.0,"Donald Trump", alliesArr,usa);
		System.out.println("Current leader is: " + govCAN.getLeader());
		System.out.println();
		
		System.out.println("Current balance is: " + govCAN.getBalance());
		System.out.println("Tax season!");
		govCAN.collectTaxes();
		System.out.println("Current balance is: " + govCAN.getBalance());
		govCAN.setBudget(123379234578f);
		System.out.println("Current budget is: " + govCAN.getBudget());
		System.out.println();
		System.out.println("The country is being governed for the term of the budget...");
		System.out.println("Current balance is: " + govCAN.getBalance());
		System.out.println();
		
		System.out.println("Canada currently has " + govCAN.getAllies().length + " allies.");
		System.out.println("Let's make Saudi Arabia an ally.");
		govCAN.makeAlly(saudiArabia);
		System.out.println("Canada currently has " + govCAN.getAllies().length + " allies.");
		System.out.println("Current USA balance is: " + govUSA.getBalance());
		govUSA.sellRecources(80);
		System.out.println("Current USA balance is: " + govUSA.getBalance());
		System.out.println("\nWAR PLAN RED");
		
		if(govUSA.wageWar(govCAN))
		{
			System.out.println("Canada has lost the war, the USA has annexed Canada");
		}
		else
		{
			System.out.println("Canada has won the war, the USA has been annexed by Canada");
		}
	}
	
	public void testRepublic(){
		//Testing the mechanics of the Republic class
		String breakdownArr[][] = {{"Liberal", "168"}, {"Conservative", "81"}, {"NDP", "58"}, {"Green", "1"}};
		Republic repCAN = new Republic(308, "Democracy", 0.13f, 40000000000.0, 338500000000.0, "Justin Trudeau", alliesArr, breakdownArr, c);

		repCAN.passLaw("No murder.", false);
		repCAN.passLaw("No handling salmon under suspicious circumstances. (Salmon Act 1986)", false);
		System.out.println(repCAN.getLaw(0));
		System.out.println(repCAN.getLaw(1));
		repCAN.repealLaw(0);
		System.out.println(repCAN.getLaw(0));

		repCAN.printBreakdown();
		repCAN.holdElections();
		repCAN.printBreakdown();

		System.out.println("Success of dealing with this protest: " + repCAN.dealWithProtest());
		repCAN.printBreakdown();
	}

	public void testDirectDemocracy(){
		//Testing the mechanics of the Direct Democracy class
		//Don't mind that this government controls the same country
		//The republic was overthrown
		DirectDemocracy dirDemCAN = new DirectDemocracy(c);
		dirDemCAN.passLaw("No murder.", false);
		dirDemCAN.passLaw("No handling salmon under suspicious circumstances. (Salmon Act 1986)", false);
		System.out.println(dirDemCAN.getLaw(0));
		System.out.println(dirDemCAN.getLaw(1));
		dirDemCAN.repealLaw(0);
		System.out.println(dirDemCAN.getLaw(0));

		System.out.println("Success of dealing with this protest: " + dirDemCAN.dealWithProtest());
	}

	public void testDictatorship(){
		//Testing the mechanics of the Dictatorship class
		Dictatorship naziCAN = new Dictatorship(c);
		naziCAN.setLeader("Jake B. Meyer");
		naziCAN.distributePropoganda("ALL HAIL OUR GLORIOUS LEADER!");
		System.out.println("Current leader is: " + naziCAN.getLeader());
		System.out.println("Success of dealing with this protest: " + naziCAN.dealWithProtest(100000));
		naziCAN.removeLeader();
		System.out.println("Current leader is: " + naziCAN.getLeader());
	}

	public void testMonarchy(){
		//Testing the mechanics of the Monarchy class
		//Remember when the British monarch had more control than Parliament?
		Monarchy monarchyCAN = new Monarchy(c);
		monarchyCAN.setLeader("Edward VIII");
		monarchyCAN.setSuccessor("George VI");
		System.out.println("Current leader is: " + monarchyCAN.getLeader());
		System.out.println("Current successor is: " + monarchyCAN.getSuccessor());
		System.out.println("Success of dealing with this protest: " + monarchyCAN.dealWithProtest("I did not have sexual relations with that American actress."));
		monarchyCAN.abdicate();
		System.out.println("Current leader is: " + monarchyCAN.getLeader());
	}

}