

import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {
	
		 Scanner input = new Scanner( System.in );

		 Shopping p1 = new Shopping();

	        int number;
	        String ItemName = "";

	    System.out.print("How many items are to be put into inventory count?:  ");
	    number = input.nextInt();
	    input.nextLine();

	    Shopping[]inv = new Shopping[number];


	     for(int count = 0; count < inv.length; ++count)
	            {
	                    System.out.print("\nWhat is item " +(count +1) + "'s name?:  ");
	                            ItemName = input.nextLine();
	                            p1.setItemName(ItemName);
	                    System.out.print("How many " + ItemName + "s are there in inventory?:  ");
	                            double Units = input.nextDouble();
	                           p1.setUnits(Units);

	                    System.out.print(ItemName + "'s cost: ");
	                            double Price = input.nextDouble();
	                            p1.setPrice (Price);
	                            
	                            double totalPrice = 0;
	                            totalPrice += p1.getUnits() * p1.getPrice();

	                    inv[count] = new Shopping(ItemName, Price, Units);
	                    input.nextLine();

	                        System.out.print("\n Product Name:     " + p1.getItemName());
	                        System.out.print("\n Amount of Units in Stock:     " + p1.getUnits());
	                        System.out.print("\n Price per Unit:   " + p1.getPrice() + "\n\n");
	                        System.out.printf("\n Total cost for %s in stock: $%.2f", p1.getItemName(), p1.calculateTotalPrice());
	                        
	                        //i need to prompt for output to show total price for all items in array
	                        System.out.printf("Total Cost for all items entered: $%.2f", p1.calculateTotalPrice());   
	            }
	    }

	}


