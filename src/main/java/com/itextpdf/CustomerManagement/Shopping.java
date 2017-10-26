

public class Shopping{
	
     String ItemName;
    public double Units, Price;
    
    public Shopping() {
		
	         }
    
	public Shopping(String itemName, double units, double price) {
    	
		ItemName = itemName;
		Units = units;
		Price = price;
	}
	// Getter  s N Setters
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public double getUnits() {
		return Units;
	}
	public void setUnits(double units) {
		Units = units;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	
	public double calculateTotalPrice()
	{
	    return (Units *Price);
	}

	//i need method to calculate total cost for all items in array
	public double calculateAllItemsTotalPrice()             
	{
	    return (calculateTotalPrice() );                              
	}
    
	
	@Override
	public String toString() {
		return "Price [ItemName=" + ItemName + ", Units=" + Units + ", Price=" + Price + "]";
	}
	
	
}
