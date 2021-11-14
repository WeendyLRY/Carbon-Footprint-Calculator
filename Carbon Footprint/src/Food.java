
public class Food implements CarbonFootprintCalculator
{
	private int sumCategory;
	private double dollarsEachCategoryPerMonth;
	private double emissionFactor = 0;
	private final int MONTHSPERYEAR = 12;
	private final double G2P = 0.022;

	public Food()
	{
		this.sumCategory = 0;
		this.dollarsEachCategoryPerMonth = 0;
		this.emissionFactor = 0;
	}
	
	public Food(int s, double d, double f)
	{
		this.sumCategory = s;
		this.dollarsEachCategoryPerMonth = d;
		this.emissionFactor = f;
	}
	
	public Food(int s, double d)
	{
		this.sumCategory = s;
		this.dollarsEachCategoryPerMonth = d;
	}
	
	public void setSumCategory(int s)
	{
		this.sumCategory = s;
	}
	
	//to set this method, ask user in the main method for the sum they spent on each category that they consumed

	public void setDollarsSpentEachMonth(double d)
	{
		this.dollarsEachCategoryPerMonth = d;
	}
	
	public void setEmissionFactor(String food)
	{
		if (food == "meat" || food == "fish" || food == "eggs")
		{
			this.emissionFactor += 1452; 
		}
		
		if (food == "cereals" || food == "bakery products")
		{
			this.emissionFactor = 741;
		}
		
		if (food == "dairy" || food == "cheese" || food == "milk" || food == "yogurt")
		{
			this.emissionFactor = 1911;
		}
		
		if (food == "fruits" || food == "vegetable")
		{
			this.emissionFactor = 1176;
		}
		
		if (food == "chinese takeout" || food == "fastfood takeout" || food == "takeout" || food == "mexican takeout" || food == "thai takeout")
		{
			this.emissionFactor = 368;	
		}
		if (food == "all")
		{
			this.emissionFactor = 5647;
		}
		
	}
	
	public void setEmissionMeat(boolean a)
	{
		if (a == true)
		{
			this.emissionFactor += 1452;
		}
		else 
		{
			this.emissionFactor += 0;
		}
	}
	
	public void setEmissionCereal(boolean a)
	{
		if (a == true)
		{
			this.emissionFactor += 741;
		}
		else 
		{
			this.emissionFactor += 0;
		}
	}
	
	public void setEmissionDairy(boolean a)
	{
		if (a == true)
		{
			this.emissionFactor += 1911;
		}
		else 
		{
			this.emissionFactor += 0;
		}
	}
	
	public void setEmissionFresh(boolean a)
	{
		if (a == true)
		{
			this.emissionFactor += 1176;
		}
		else 
		{
			this.emissionFactor += 0;
		}
	}
	
	public void setEmissionRestaurant(boolean a)
	{
		if (a == true)
		{
			this.emissionFactor += 368;
		}
		else 
		{
			this.emissionFactor += 0;
		}
	}

	
	
	
	private int getSumCategory()
	{
		return this.sumCategory;
	}
	
	private double getDollarsEachCategory()
	{
		return this.dollarsEachCategoryPerMonth;
	}
	
	private double getEmmisionFactor()
	{
		return this.emissionFactor;
	}
	
	@Override
	public double calculateCarbonEmission() 
	{
		double a = this.getSumCategory();
		double b = this.getDollarsEachCategory() * this.getEmmisionFactor() * this.MONTHSPERYEAR;
		double c = this.G2P;
		
		double CarbonEmission = a * b * c;
		
		return CarbonEmission;
	}

	public String toString()
	{
		String a = "\nFOR FOOD: " + this.calculateCarbonEmission() + " pounds of CO2 is emitted every year";
		String b = "\nTotal money spent on food every month: " + this.getDollarsEachCategory();
		String c = "\nTotal Emmision factor " + this.getEmmisionFactor();
		String d = "\nTotal category: " + this.sumCategory;
		return a+b+c+d;
	}
	
	
	
}
