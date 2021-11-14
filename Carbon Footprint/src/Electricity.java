
public class Electricity implements CarbonFootprintCalculator
{

	private double monthlyElectricBill;
	private double pricePerKWH;
	private String state;
	private final double ELECTRICITYEMISSIONFACTOR = 1.37;
	private final int MONTHINAYEAR = 12;
	
	public Electricity()
	{
		this.monthlyElectricBill = 1;
		this.pricePerKWH = 1;
	}
	
	public Electricity(int m, double p)
	{
		this.monthlyElectricBill = m;
		this.pricePerKWH = p;
	}
	
	public void setMonthlyElectricBill(double v)
	{
		this.monthlyElectricBill = v;
	}
	
	public void setPricePerKWH(double p)
	{
		this.pricePerKWH = p;
	}
	
	public void setState(String s)
	{
		this.state = s;
	}
	
	public double getMonthly()
	{
		return this.monthlyElectricBill;
	}
	
	public double getPricePerKWH()
	{
		return this.pricePerKWH;
	}
	
	public String getState()
	{
		return state;
	}
	
	@Override
	public double calculateCarbonEmission() 
	{
		double a = this.getMonthly() / this.getPricePerKWH();
		double b = this.ELECTRICITYEMISSIONFACTOR * this.MONTHINAYEAR;
		
		return a*b;
 	}
	
	public String toString()
	{
		String a = "\nState: \t\t\t" + this.getState();
		String b = "\n" + this.getState() + "'s" + " unit price per KWH is: \t\t\t" + " $" + this.getPricePerKWH();
		String c = "\n" + "Avg monthly electric bill: \t\t\t" + "$" + this.monthlyElectricBill;
		String d = "\n" + "Carbon Emmision from Electricity: " + this.calculateCarbonEmission() + " pound per year.";
		
		return a+b+c+d;
	}

}
