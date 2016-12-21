/**
 * This class represents a single trip and its various information
 * @author muyiyimiss
 *
 */
public class Trip {
	
	/**
	 * These are the instance variables of a trip.
	 */
	private int tripId;
	private int duration;
	private Time time;
	private int bikeId;
	//private Bike bike;
	private int plan_duration;
	private OneStation startStation;
	private OneStation endStation;
	private String tripRouteCategory;
	private String passholderType;
	
	/**
	 * This is the constructor
	 * @param tripId, each trip has a unique ID;
	 * @param duration, each trip has a duration;
	 * @param time, each trip has a time, which contains start time and end time
	 * @param bike, each trip has a bike id
	 * @param plan_duration, each trip has a planned duration
	 * @param startStation, each trip has a start station, which contains the station's specific information
	 * @param endStation, each trip has a end station, which contains the station's specific information
	 * @param tripRouteCategory, each trip has a trip route category
	 * @param passholderType, each trip has a pass holder type
	 */
	public Trip(int tripId, int duration, Time time, int bike, int plan_duration, OneStation startStation, OneStation endStation, String tripRouteCategory, String passholderType) {
		
		this.tripId = tripId;
		this.duration = duration;
		this.time = time;
		this.bikeId = bike;
		this.plan_duration = plan_duration;
		this.startStation = startStation;
		this.endStation = endStation;
		this.tripRouteCategory = tripRouteCategory;
		this.passholderType = passholderType;
	}
	
	/**
	 * This is the get method of tripId
	 * @return, int, trip ID
	 */
	public int getTripId() {
		return tripId;
	}
	
	/**
	 * This is the get method of a trip's duration
	 * @return, int, trip duration
	 */
	public int getDuration(){
		return duration;
	}
	
	/**
	 * This is the get method of a trip's start time
	 * @return, Time, time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * This is the get method of a trip's bike ID
	 * @return, int, bike Id
	 */
	public int getBikeId() {
		return bikeId;
	}

	/**
	 * This is the get method of a trip's planned duration
	 * @return, int, plan duration
	 */
	public int getPlan_duration() {
		return plan_duration;
	}
	
	/**
	 * This is the get method of a trip's start station
	 * @return, Station, start station
	 */
	public OneStation getStartStation() {
		return startStation;
	}
	

	/**
	 * This is the get method of a trip's end station
	 * @return, Station, end station
	 */
	public OneStation getEndStation() {
		return endStation;
	}

	/**
	 * This is the get method of a trip's route category
	 * @return, String, trip Route Category
	 */
	public String getTripRouteCategory() {
		return tripRouteCategory;
	}

	/**
	 * This is the get method of a trip's pass holder type
	 * @return, String, pass Holder Type
	 */
	public String getPassholderType() {
		return passholderType;
	}


}
