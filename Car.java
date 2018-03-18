package Car;

public class Car 
{
	
	private int carNO;
	
	private String color;
	
	private String owner;
	
	public Car(int carNO,String color,String owner)
	{
		this.carNO=carNO;
		this.color=color;
		this.owner=owner;
	}
	
	public String details()
	{
		return owner+" "+carNO+" "+color;
	}

}
