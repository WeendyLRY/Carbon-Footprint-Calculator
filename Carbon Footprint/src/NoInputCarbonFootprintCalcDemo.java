import java.util.ArrayList;

public class NoInputCarbonFootprintCalcDemo 
{
	public static void main (String [] args)
	{
		ArrayList<Object> CarbonFootprintCalculator = new ArrayList<Object>();
		Food food = new Food();
		Vehicles vehicle = new Vehicles();
		Electricity elec = new Electricity();
		
		CarbonFootprintCalculator.add(food);
		CarbonFootprintCalculator.add(vehicle);
		CarbonFootprintCalculator.add(elec);
		
		food.setDollarsSpentEachMonth(239);
		food.setSumCategory(5);
		food.setEmissionFactor("all");
		
		vehicle.setCarBrand("Perodua");
		vehicle.setFuelEfficiency(Vehicles.CarBrand.PERODUA);
		vehicle.setMilesPerWeek(67.3);
		
		elec.setMonthlyElectricBill(37.3);
		elec.setState("New London");
		elec.setPricePerKWH(0.13);
		
		System.out.println(food);
		System.out.println(vehicle);
		System.out.println(elec);
		
		
	}
}
