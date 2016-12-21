import java.util.ArrayList;
/**
 * This is a times class
 * it has an ArrayList of times
 * @author muyiyimiss
 *
 */
public class Times {
	private ArrayList<Time> times;
	
	/**
	 * This is the constructor of times
	 */
	public Times() {
		times = new ArrayList<Time>();
	}
	
	/**
	 * This is the get method of the times 
	 * @return an ArrayList<Time>();
	 */
	public ArrayList<Time> getTimes() {
		return times;
	}
	
	/**
	 * This method will add a Time to the ArrayList of Times
	 * @param a
	 */
	public void addTime(Time a){
		times.add(a);
	}
	
}
