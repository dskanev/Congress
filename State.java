import java.lang.Math;

public class State implements Comparable<State> {
	private String name;
	private int population;
	private int numberOfSeats = 1;
	
	
	public State(String name, int population){
		this.name = name;
		this.population = population;
	}
	
	
	@Override
	public int compareTo(State other)
	{
		return (int)Math.round(other.prioritize() - prioritize());
	}
	
	public double prioritize()
	{
		double priority = population/(Math.sqrt(Math.pow(numberOfSeats, 2) + numberOfSeats));
		return priority;				
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSeats()
	{
		return numberOfSeats;
	}
	
	public void addSeat(){
		this.numberOfSeats++;
	}
	
}