/**
 * This class represents one station, which contains various information of this station
 * @author muyiyimiss
 *
 */
public class OneStation {
	
	/**
	 * These are instance variables a of station
	 */
	private int stationId;
	private String stationName;
	private long goLiveDate;
	private String status;
	private double lon;
	private double lat;
	
	/**
	 * This is the constructor of a station
	 * @param stationId, each station has an ID
	 * @param stationName, each station has a station name
	 * @param goLiveDate, each station has a go live date
	 * @param status, each station has a status
	 */
	public OneStation(int stationId, String stationName, long goLiveDate, String status) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.goLiveDate = goLiveDate;
		this.status = status;
	}
	
	/**
	 * This is the method to get station Id
	 * @return, station ID
	 */
	public int getStationId() {
		return stationId;
	}

	/**
	 * This is the method to get station name
	 * @return, station name
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * This is the method to get go live date
	 * @return go live date
	 */
	public long getGoLiveDate() {
		return goLiveDate;
	}

	/**
	 * This is the method to get a status of a station
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * This is the method to get the lon of a station
	 * @return lon
	 */
	public double getLon(){
		return lon;
	}
	
	/**
	 * This is the method to set lon
	 * @param lon
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	/**
	 * This is the method to set lat
	 * @return lat
	 */
	public double getLat(){
		return lat;
	}
	
	/**
	 * This is the method to set lat
	 * @param lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	

}
