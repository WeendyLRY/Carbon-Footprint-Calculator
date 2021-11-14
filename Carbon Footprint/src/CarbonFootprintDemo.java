import java.util.ArrayList;
import javax.swing.JOptionPane;



//this is the democlass for input and output
public class CarbonFootprintDemo 
{
	public static void main (String[] args)
	{
		try { //this is used to prevent error when user clicks the "cancel" or "x" button.
			
			
		//array list add object as called.
		ArrayList<Object> CarbonFootprintCalculator = new ArrayList<Object>();
		
		
		Food food = new Food();
		Vehicles vehicle = new Vehicles();
		Electricity elec = new Electricity();
		double expendSum = 0;
		int response = 1;
		
		
		while (response == 1) {
		//ask user to choose which carbon emmission would they like to calculate
		String chooseSource = JOptionPane.showInputDialog("CARBON FOOTPRINT SOURCE" +
				"\n[1] FOOD" + "\n[2] VEHICLES" + "\n[3] ELECTRICITY" );
				
				//store user's input in Source
				int Source = Integer.parseInt(chooseSource); 
					
				//validate input
				while (Source < 1 || Source > 3)
				{
					chooseSource = JOptionPane.showInputDialog("INVALID INPUT" + "\nCARBON FOOTPRINT SOURCE" +
							"\n[1] FOOD" + "\n[2] VEHICLES" + "\n[3] ELECTRICITY");
					Source = Integer.parseInt(chooseSource);
				} //end of while loop to ensure input is between 1 and 3
		
		//if the user chose food
		if (Source == 1)
			{
				CarbonFootprintCalculator.add(food);
				int categoryNo = 0;
				//get user to enter how many categories of food they consume 
				//by prompting them to enter the amount of money they contributes to each of the food category
				//for each category that user inputted a certain value, 
				//increment noOfCategory by 1
		
				
				
				String[] chooseExpend = {
										"How much do you spend on meat, fish and eggs? \n (in Dollars)", 
										"How much do you spend on cereals and bakery products?\n (in Dollars)",
										"How much do you spend on dairy, cheese, milk and yogurt? \n (in Dollars)",
										"How much do you spend on fruits and vegetables? \n (in Dollars)",
										"How much do you spend on eating out / buying takeouts? \n (in Dollars)",
										};
				String[] emission = 
				{ 
					"meat",
					"cereals",
					"dairy",
					"fruits",
					"takeout"
				};
				
				double[] foodExpenditure = {0, 0, 0, 0, 0};
				
				//meat, fish, eggs
				String chooseExpendOnMeat = JOptionPane.showInputDialog(chooseExpend[0]);
				foodExpenditure[0] = Double.parseDouble(chooseExpendOnMeat);	
				expendSum = expendSum + foodExpenditure[0];
				if (foodExpenditure[0] > 0)
				{
					food.setEmissionMeat(true);
					categoryNo++;
				}
				else 
				{
					food.setEmissionMeat(false);
				}
				
				//cereals and bakery products
				String chooseExpendOnWheat = JOptionPane.showInputDialog(chooseExpend[1]);
				foodExpenditure[1] = Double.parseDouble(chooseExpendOnWheat);	
				expendSum = expendSum + foodExpenditure[1];
				if (foodExpenditure[0] > 0)
				{
					food.setEmissionCereal(true);
					categoryNo++;
				}
				else 
				{
					food.setEmissionCereal(false);
				}
				
				//dairy, cheese, milk and yogurt
				String chooseExpendOnDairy = JOptionPane.showInputDialog(chooseExpend[2]);
				foodExpenditure[2] = Double.parseDouble(chooseExpendOnDairy);	
				expendSum = expendSum + foodExpenditure[2];
				if (foodExpenditure[0] > 0)
				{
					food.setEmissionDairy(true);
					categoryNo++;
				}
				else 
				{
					food.setEmissionDairy(false);
				}
				
				//fruits and vegetables
				String chooseExpendOnFresh = JOptionPane.showInputDialog(chooseExpend[3]);
				foodExpenditure[3] = Double.parseDouble(chooseExpendOnFresh);	
				expendSum = expendSum + foodExpenditure[3];
				if (foodExpenditure[0] > 0)
				{
					food.setEmissionFresh(true);
					categoryNo++;
				}
				else 
				{
					food.setEmissionFresh(false);
				}
				
				//eating out / buying takeouts
				String chooseExpendOnRestaurant = JOptionPane.showInputDialog(chooseExpend[4]);
				foodExpenditure[4] = Double.parseDouble(chooseExpendOnRestaurant);	
				expendSum = expendSum + foodExpenditure[4];
				if (foodExpenditure[0] > 0)
				{
					food.setEmissionRestaurant(true);
					categoryNo++;
				}
				else 
				{
					food.setEmissionRestaurant(false);
				}
				
	
				
				food.setDollarsSpentEachMonth(expendSum);
				food.setSumCategory(categoryNo);
			
				JOptionPane.showMessageDialog(null, food);
					
				//JOptionPane.showMessageDialog(null, "AREA OF CIRCLE IS " + circleArea);
			response = 1;		
			} //end of Source 1 - Food
				
				
		
		//if the user chose vehicles,
		if (Source == 2)
		{
			CarbonFootprintCalculator.add(vehicle);
			//ask user for car brand
			String whatCar = JOptionPane.showInputDialog(
														"Choose your car model."
														+ "\n1 PERODUA"
														+ "\n2 PROTON"
														+ "\n3 TOYOTA"
														+ "\n4 PORSCHE"
														+ "\n5 FERARI"
														+ "\n6 NOT IN THE LIST");
			int CarModel = Integer.parseInt(whatCar);	
			//then generate fuel efficiency from the carbrand by using setFuelEfficiency method
			
			//validate input
			while (CarModel < 1 || CarModel > 6)
			{
				whatCar = JOptionPane.showInputDialog(
						"Choose your car model."
						+ "\n1 PERODUA"
						+ "\n2 PROTON"
						+ "\n3 TOYOTA"
						+ "\n4 PORSCHE"
						+ "\n5 FERARI"
						+ "\n6 NOT IN THE LIST");
				 CarModel = Integer.parseInt(whatCar);
			}
			
			switch (CarModel)
			{
			case 1: 
				vehicle.setFuelEfficiency(Vehicles.CarBrand.PERODUA);
				break;
			case 2:
				vehicle.setFuelEfficiency(Vehicles.CarBrand.PROTON);
				break;
			case 3:
				vehicle.setFuelEfficiency(Vehicles.CarBrand.TOYOTA);
				break;
			case 4:
				vehicle.setFuelEfficiency(Vehicles.CarBrand.PORSCHE);
				break;
			case 5:
				vehicle.setFuelEfficiency(Vehicles.CarBrand.FERARI);
				break;
			case 6:
				vehicle.setFuelEfficiency(Vehicles.CarBrand.UNAVAILABLE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Wrong input. Bye!");
				break;
			}
			
			
			
			try 
			{
			String getMPW = JOptionPane.showInputDialog("What is the average Miles Per Week? ");
			double MPW = Integer.parseInt(getMPW);
			vehicle.setMilesPerWeek(MPW);
			
			//then calculate what is needed
			vehicle.calculateCarbonEmission();
			
			
			} //end of try
			
			catch (NumberFormatException ignore)
			{
				JOptionPane.showMessageDialog(null, "Invalid input bye!");
				System.exit(CarModel);
				
			} // end of catch
			
			
			//display vehicle
			JOptionPane.showMessageDialog(null, vehicle);
			response = 12;
		} // end of source 2
		
		
		//if the user chose electricity,
		
		if (Source == 3)
		{
			CarbonFootprintCalculator.add(elec);
			
			String getMonthlyElectricBill = JOptionPane.showInputDialog("Enter Average monthly electric bill");
			double monthlyElectricBill = Double.parseDouble(getMonthlyElectricBill);	
			
			//validate input
			while (monthlyElectricBill < 0)
			{
				getMonthlyElectricBill = JOptionPane.showInputDialog("Enter Average monthly electric bill");
				monthlyElectricBill = Double.parseDouble(getMonthlyElectricBill);
			}
			
			elec.setMonthlyElectricBill(monthlyElectricBill);
			
			String whichState = JOptionPane.showInputDialog("Which city of Connecticut are you living in?\n Choose amongst these only"
															+ "\n1 Hartford" + 
					"\n2 New Haven" + "\n3 Stamford" + "\n4 Bridgeport" + "\n5 New London" + "\n6 Willimantic");
			int State = Integer.parseInt(whichState);
			
			//validate input
			while (State < 1 || State > 6)
			{
				whichState = JOptionPane.showInputDialog(
						"Choose your car model."
						+ "\n1 Hartford"
						+ "\n2 New Haven"
						+ "\n3 Stamford"
						+ "\n4 Bridgeport"
						+ "\n5 New London"
						+ "\n6 Willimantic");
				State = Integer.parseInt(whichState);
			}
			
			String[] getState = {"Hartford", "New Haven", "Stamford", "Bridgeport", "New London", "Willimantic"};
			double[] getPricePerKW = {0.13, 0.16, 0.13, 0.16, 0.13, 0.15};
			
			//correspond the state with the unit price per kwh 
			switch (State)
			{
			case 1:
				elec.setState(getState[0]);
				elec.setPricePerKWH(getPricePerKW[0]);
				break;
			case 2:
				elec.setState(getState[1]);
				elec.setPricePerKWH(getPricePerKW[1]);
				break;
			case 3:
				elec.setState(getState[2]);
				elec.setPricePerKWH(getPricePerKW[2]);
				break;
			case 4:
				elec.setState(getState[3]);
				elec.setPricePerKWH(getPricePerKW[3]);
				break;
			case 5:
				elec.setState(getState[4]);
				elec.setPricePerKWH(getPricePerKW[4]);
				break;
			case 6:
				elec.setState(getState[5]);
				elec.setPricePerKWH(getPricePerKW[5]);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid input!");
				break;	
			}
			
			JOptionPane.showMessageDialog(null, elec);
			response = 1;
			
		} // end of source 3 = electricity
		
		else
		{
			response = 1;
		}
		
		} //end of try
		
		}//end of while response = 1
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Bye! Be aware of our carbon emission. You can make the change!");
		}
	} //end of main method
} // end of demo class
