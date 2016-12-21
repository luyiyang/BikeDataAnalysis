import java.util.HashMap;
/**
 * This is a bike class
 * @author muyiyimiss
 *
 */
public class Bike {
	
	/**
	 * This is the instance variable of the class
	 */
	private HashMap<Integer, Integer> bike;
	
	/**
	 * This is the constructor
	 * It initialized the HashMap
	 */
	public Bike(){
		bike = new HashMap<Integer, Integer>();	
	}
	
	/**
	 * This method will put a pair of values into the hashmap
	 * @param a, bike Id
	 * @param b, bike duration
	 */
	public void putHashMap(Integer a, Integer b){
		
		if(bike.containsKey(a)){
			int duration = bike.get(a)+b;
			bike.put(a, duration);
		}else{
		bike.put(a, b);
		}
	}
	
	/**
	 * This method will return the value, given the key
	 * @param bikeId
	 * @return
	 */
	public int getDuration(int bikeId){
		int duration = 0;
		duration = bike.get(bikeId);
		return duration;
	}
	
	/**
	 * This method will get the value of most duration
	 * @return most duration
	 */
	public int getMostDuration(){
		int mostDuration = 0;
		for(int duration: bike.values()){
			if(duration > mostDuration){
				mostDuration = duration;
			}
			
		}
		
		return mostDuration;
	}
	
	/**
	 * This method will print out the bike ID that travels the most duration
	 * @param d
	 */
	public void getBikeId(int d){
		for(int bikeID: bike.keySet()){
			if(bike.get(bikeID) == getMostDuration()){
				System.out.println(bikeID);
			}
		}
	}
	
		
}
