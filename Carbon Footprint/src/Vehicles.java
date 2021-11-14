
public class Vehicles implements CarbonFootprintCalculator //the vehicles in this context refers to the landed personal vehicle which is car
{
	public enum CarBrand {UNAVAILABLE,PERODUA, PROTON, TOYOTA, PORSCHE, FERARI};
	private CarBrand car;
	private double milesPerWeek;
	private final int WEEKSPERYEAR = 52;
	private double fuelEfficiency; //calculated in milespergallon //the higher the better
	private final double CO2POUNDEMMISIONPERGALLON = 19.4;
	private final double OTHERGASES = 100/95;
	private String carBrand;
	
	public Vehicles()
	{
		this.car = CarBrand.UNAVAILABLE;
		this.milesPerWeek = 0;
	}
	
	public Vehicles(CarBrand a, double miles, double fuel)
	{
		this.car = a;
		this.milesPerWeek = miles;
	}
	
	public Vehicles(String a, double miles, double fuel)
	{
		this.carBrand = a;
		this.milesPerWeek = miles;
		this.fuelEfficiency = fuel;
	}
	
	public void setMilesPerWeek(double m)
	{
		this.milesPerWeek = m;
	}
	
	public String getCarBrand()
	{
		if (this.car == CarBrand.PERODUA)
		{
			carBrand = "Perodua";
		}
		
		else if (this.car == CarBrand.PROTON)
		{
			carBrand = "Proton";
		}
		
		else if (this.car == CarBrand.TOYOTA)
		{
			carBrand = "Toyota";
		}
		
		else if (this.car == CarBrand.PORSCHE)
		{
			carBrand = "Porsche";
		}
		
		else if (this.car == CarBrand.FERARI)
		{
			carBrand = "Ferari";
		}
		
		else
		{
			carBrand = "Other brand";
		}
		
		return carBrand;
	}
	
	public void setFuelEfficiency(CarBrand a)
	{
		if (a == CarBrand.PERODUA)
		{
			this.car = a;
			this.fuelEfficiency = 30;
		}
		
		else if (a == CarBrand.PROTON)
		{
			this.car = a;
			this.fuelEfficiency = 26;
		}
		
		else if (a == CarBrand.TOYOTA)
		{
			this.car = a;
			this.fuelEfficiency = 24;
		}
		
		else if (a == CarBrand.PORSCHE)
		{
			this.car = a;
			this.fuelEfficiency = 33;
		}
		
		else if (a == CarBrand.FERARI)
		{
			this.car = a;
			this.fuelEfficiency = 27;
		}
		
		else //other generic car
		{
			this.car = a;
			this.fuelEfficiency = 23;
		}
	}
	
	public void setCarBrand(String brand)
	{
		this.carBrand = brand;
	}
	
	public double getMilesPerWeek()
	{
		return milesPerWeek;
	}
	
	public double getFuelEfficiency()
	{
		return fuelEfficiency;
	}
	
	@Override
	public double calculateCarbonEmission() 
	{
		double numerator = this.getMilesPerWeek() * this.WEEKSPERYEAR;
		double denominator = this.getFuelEfficiency();
		double coefficientA = numerator / denominator;
		double coefficientB = this.CO2POUNDEMMISIONPERGALLON * this.OTHERGASES;
		
		double CarbonEmmision = coefficientA * coefficientB;
		
		return CarbonEmmision;
	}
	
	public String toString()
	{
		String a = "\nCar brand: \t\t" + this.getCarBrand() 
					+ "\n Car Miles Per Week: \t\t" + this.getMilesPerWeek() + " miles"
					+ "\n Fuel Efficiency: \t\t " + this.getFuelEfficiency() + " MPG"
					+ "\n Carbon Emmision: \t\t" + this.calculateCarbonEmission() + " pounds";
		
		return a;
				
	}

}
