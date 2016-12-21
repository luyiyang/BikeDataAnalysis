/**
 * This is a Time class
 * @author muyiyimiss
 *
 */
public class Time {
	
	/**
	 * These are instance variables of this class
	 */
	private int startTime;
	private int startDate;
	private int endTime;
	private int endDate;
	

	/**This is the constructor
	 * @param startDate, this is the start date of a trip
	 * @param startTime, this is the start time of a trip
	 * @param endDate, this is the end date of a trip
	 * @param endTime, this is the end time of a trip
	 */
	public Time(int startDate, int startTime, int endDate, int endTime) {
		this.startTime = startTime;
		this.startDate = startDate;
		this.endTime = endTime;
		this.endDate = endDate;
	}

	
	/**
	 * This is the get method of the start time
	 * @return start time 
	 */
	public int getStartTime() {
		return startTime;
	}


	
	/**
	 * This is the get method of the start date
	 * @return start date
	 */
	public int getStartDate() {
		return startDate;
	}


	
	/**
	 * This is the get method of the end time 
	 * @return end time 
	 */
	public int getEndTime() {
		return endTime;
	}


	
	/**
	 * This is the get method of the end date
	 * @return end date
	 */
	public int getEndDate() {
		return endDate;
	}


	
	


}
