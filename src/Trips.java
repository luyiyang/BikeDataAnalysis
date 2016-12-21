
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * This class represents all trips
 * @author muyiyimiss
 *
 */
public class Trips {

	/**
	 * These are instance variables of this class
	 */
	private FileReader tripTable;
	private Stations stationList;
	private PassHolderTypes ps;
	private ArrayList<Trip> trips;
	private Times ts;
	private Bike bike;

	/**
	 * This is the constructor
	 * @param s, Stations s
	 * @param ps, PassHolderType ps
	 */
	public Trips (Stations s, PassHolderTypes ps, Times ts, Bike bike){
		tripTable = new FileReader("Q3_2016_trips 10.34.12 PM.csv");
		stationList = s;
		this.ps = ps;
		this.ts = ts;
		this.bike = bike;
		trips = new ArrayList<Trip>();
		convertFile();
	}

	/**
	 * This method will add a single trip to an ArrayList of Trips
	 * @param t, a trip
	 */
	public void addTrips(Trip t){
		trips.add(t);
	}

	/**
	 * This method will convert the ArrayList gotten from FileReader to various variables for different uses
	 */
	public void convertFile(){

		ArrayList<String> tripLines = tripTable.getLines();

		for(int i = 1; i<tripLines.size();i++){

			String[] info = tripLines.get(i).split(",");

			int tripId = Integer.parseInt(info[0]);

			int duration = Integer.parseInt(info[1]);
			
			String startTimeString = info[2];
			String[] sTimeArray = startTimeString.split(" ");
			String sDate = sTimeArray[0].replace("/", "");
			int startDate = Integer.parseInt(sDate);
			String sTime = sTimeArray[1].replace(":", "");
			int startTime = Integer.parseInt(sTime);
			String endTimeString = info[3];
			String[] eTimeArray = endTimeString.split(" ");
			String eDate = eTimeArray[0].replace("/", "");
			int endDate = Integer.parseInt(eDate);
			String eTime = eTimeArray[1].replace(":", "");
			int endTime = Integer.parseInt(eTime);
			
			Time tripTime = new Time(startDate, startTime, endDate, endTime);
			ts.addTime(tripTime);
			

			int startStationId = Integer.parseInt(info[4]);

			OneStation sst = null;
			double startLat = 0;
			double startLon = 0;

			if(info[5].equalsIgnoreCase("\\N")){
				startLat = Double.MAX_VALUE;
			}else{
				startLat = Double.parseDouble(info[5]);
			}

			if(info[6].equalsIgnoreCase("\\N")){
				startLon = Double.MAX_VALUE;
			}else{
				startLon = Double.parseDouble(info[6]);		
			}

			for(int n = 0; n< stationList.getStations().size(); n++){

				if(stationList.getStations().get(n).getStationId()==startStationId){

					stationList.getStations().get(n).setLat(startLat);
					stationList.getStations().get(n).setLon(startLon);

					sst = stationList.getStations().get(n);
					break;
				}
			}


			OneStation est = null;
			double endLat = 0;
			double endLon = 0;


			int endStationId = Integer.parseInt(info[7]);

			if(info[8].equalsIgnoreCase("\\N")){
				endLat = Double.MAX_VALUE;
			}else{
				endLat = Double.parseDouble(info[8]);
			}

			if(info[9].equalsIgnoreCase("\\N")){
				endLon = Double.MAX_VALUE;
			}else{
				endLon = Double.parseDouble(info[9]);
			}

			for(int n = 0; n< stationList.getStations().size(); n++){

				if(stationList.getStations().get(n).getStationId()==endStationId){

					stationList.getStations().get(n).setLat(endLat);

					stationList.getStations().get(n).setLon(endLon);

					est = stationList.getStations().get(n);

					break;
				}
			}


			int bikeId = Integer.parseInt(info[10]);
			
			bike.putHashMap(bikeId, duration);
			

			int planDuration = Integer.parseInt(info[11]);

			String tripRouteCategory = info[12];

			String passholderType = info[13];

			PassHolderType p = new PassHolderType(passholderType);
			ps.addPTpes(p);

			Trip aTrip = new Trip(tripId, duration, tripTime, bikeId, planDuration, sst, est, tripRouteCategory, passholderType);

			addTrips(aTrip);

		}
	}


	/**
	 * This is the get method of the ArrayList of trips
	 * @return, an ArrayList<Trip>()
	 */
	public ArrayList<Trip> getTrips() {
		return trips;
	}

	/**
	 * This method will count the number of trips with a start station called s
	 * @param s, the station's name
	 * @return the number of trips with a start station called s
	 */
	public int countStartStation(String s){
		int n = 0;
		for(int i = 0; i<trips.size(); i++){
			if(trips.get(i).getStartStation().getStationName().equalsIgnoreCase(s)){
				n++;
			}
		}
		return n;
	}

	/**
	 * This method will calculate the percentage of trips started in a certain location with the name s
	 * @param s, the station name
	 * @return, the percentage
	 */
	public String startStationPercentage(String s){
		int a = countStartStation(s);
		int b = trips.size();
		double c = 100.0*(double)a / (double)b;
		DecimalFormat df = new DecimalFormat("#.##");
		//df.format(c);
		return df.format(c).concat("%");	
	}

	/**
	 * This method will count the number of trips with a certain type of trip route category
	 * @param s, the name of the route category
	 * @return the number of trips with a certain type of trip route category
	 */
	public int getTripRouteCategory(String s){
		int b = 0;
		for(int i = 0; i<trips.size(); i++){
			if(trips.get(i).getTripRouteCategory().equalsIgnoreCase(s) ){	
				b++;
			}
		}
		return b;
	}	

	/**
	 * This method will get what percentage of trips made by a certain pass holder type are a trip route category?
	 * @param a, a pass holder type
	 * @param b, a trip route category
	 * @return the percentage
	 */
	public String getPercentageOfTripRoute(String a, String b){
		int n = ps.getPassHolderType(a);
		int m = 0;
		for(int i = 0; i<trips.size(); i++){
			if(trips.get(i).getTripRouteCategory().equalsIgnoreCase(b) && trips.get(i).getPassholderType().equalsIgnoreCase(a)){	
				m++;
			}
		}
		double q = 100.0*(double) (m)/ (double) (n);
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(q).concat("%");

	}

	/**
	 * This method will get the longest duration among all trips
	 * @return the longest duration
	 
	public int getMostDuration(){
		int mostDuration = 0;
		for(int i = 0; i<trips.size(); i++){
			if(trips.get(i).getBike().getDuration(bikeId)>mostDuration){

				mostDuration = trips.get(i).getDuration();

			}
		}
		return mostDuration;
	}
*/

	/**
	 * This method will print out the bike ID that has a certain duration
	 * @param duration, a certain duration
	
	public void getBikeIdWithDuration(int duration){
		for(int i = 0; i<trips.size(); i++){
			if(trips.get(i).getDuration() == duration){
				System.out.println(trips.get(i).getBike());
			}
		}
	}
*/

	/**
	 * This method will get how many bikes were being used at a specific time
	 * @param time, the specific time
	 * @return count, how many bikes being used
	 */
	public int getBikeNumbersAtTime(int date, int t){
		int count = 0;
		for(int i = 0; i<trips.size(); i++){
			int a = trips.get(i).getTime().getStartDate();
			int b = trips.get(i).getTime().getStartTime();
			int c = trips.get(i).getTime().getEndDate();
			int d = trips.get(i).getTime().getEndTime();
			
			if((a == date && b<= t && date == c && t<= d)||(a<date && date ==c && t<=d)){
				count ++;
				//System.out.println(trips.get(i).getTripId());
			}
		}
		return count;
		
	}

	/**
	 * This method will get the distance of the trip i
	 * @param i, the index of a trip
	 * @return, the distance that this trip travels
	 */
	public double getDistance(int i) {
		double distance = 0;

		double slat = trips.get(i).getStartStation().getLat();
		double slon = trips.get(i).getStartStation().getLon();
		double elat = trips.get(i).getEndStation().getLat();
		double elon = trips.get(i).getEndStation().getLon();


		if(slat == Double.MAX_VALUE || slon == Double.MAX_VALUE || elat == Double.MAX_VALUE || elon == Double.MAX_VALUE){
			
			distance = -1.0;

		}else{

			distance = Math.sqrt(Math.pow((slat - elat), 2.0) + Math.pow((slon - elon), 2.0));

		}
		return distance;
	}

	/**
	 * This method will get the longest distance among all trips
	 * @return the longest distance
	 */
	public double getLongestTrip(){
		double longestDistance = 0;

		for(int i = 0; i<trips.size(); i++){

			double distance = getDistance(i);

			if(distance > longestDistance){
				longestDistance = distance;
			}
		}

		return longestDistance;
	}

	/**
	 * This method will print all trip information given a certain trip distance
	 * @param d, the trip distance 
	 */
	public void printTrips(double d){

		for(int i = 0; i<trips.size(); i++){

			if(getDistance(i) == d){

				Trip t = trips.get(i);

				System.out.println(t.getTripId() + ", " + t.getDuration() +", " + t.getTime().getStartTime() + ", " + t.getTime().getEndTime() +  ", " + t.getStartStation().getStationId()+  ", " +t.getStartStation().getLat() +  ", " + t.getStartStation().getLon() +  ", " + t.getEndStation().getStationId() +  ", " +t.getEndStation().getLat() +  ", " + t.getEndStation().getLon() +  ", " +  t.getBikeId() +  ", " + t.getPlan_duration() +  ", " + t.getTripRouteCategory() +  ", " + t.getPassholderType() );
			}

		}
	}

	/**
	 * This method will find the most popular station, either end or start
	 * @param m, either most or least
	 * @param s, either end or not end(start), which station the user wants to know
	 * @return, OneStation, the most popular station
	 */
	public OneStation findPopularStation(String m, String s){
		OneStation station = null;

		if(m.equalsIgnoreCase("least")){

			station = leastPopularStation(s);

		}else{
			station = mostPopularStation(s);

		}
		return station;
	}

	/**
	 * This method will find the most popular station
	 * @param s, end station or not end station (start station)
	 * @return the most popular end station or the most popular start station
	 */
	private OneStation mostPopularStation(String s) {
		int count = 0;
		OneStation station = null;
		if(s.equalsIgnoreCase("end Station")){

			for(int i= 0; i<trips.size();i++){
				OneStation tempStation = trips.get(i).getEndStation();
				int tempCount = 0;
				for(int j= 0; j<trips.size();j++){
					if(trips.get(j).getEndStation() == tempStation){
						tempCount++;
					}
				}
				if(tempCount>count){
					station = tempStation;
					count = tempCount;
				}

			}
		}
		else{

			for(int i= 0; i<trips.size();i++){
				OneStation tempStation = trips.get(i).getStartStation();
				int tempCount = 0;
				for(int j= 0; j<trips.size();j++){
					if(trips.get(j).getStartStation() == tempStation){
						tempCount++;
					}
				}
				if(tempCount>count){
					station = tempStation;
					count = tempCount;
				}

			}
		}
		return station;
	}

	/**
	 * This method will find the least popular station
	 * @param s, end station or not end station (start station)
	 * @return The least popular end station or the least popular start station
	 */
	private OneStation leastPopularStation(String s) {
		int count = Integer.MAX_VALUE;
		OneStation station = null;
		if(s.equalsIgnoreCase("end Station")){

			for(int i= 0; i<trips.size();i++){
				OneStation tempStation = trips.get(i).getEndStation();
				int tempCount = 0;
				for(int j= 0; j<trips.size();j++){
					if(trips.get(j).getEndStation() == tempStation){
						tempCount++;
					}
				}
				if(tempCount<count){
					station = tempStation;
					count = tempCount;
				}

			}
		}
		else{

			for(int i= 0; i<trips.size();i++){
				OneStation tempStation = trips.get(i).getStartStation();
				int tempCount = 0;
				for(int j= 0; j<trips.size();j++){
					if(trips.get(j).getStartStation() == tempStation){
						tempCount++;
					}
				}
				if(tempCount<count){
					station = tempStation;
					count = tempCount;
				}

			}
		}
		return station;
	}


	/**
	 * This method will print out the trip id of the only station.
	 */
	public void tripIdofOnlyStation(){
		for(int i = 0; i<trips.size(); i++){
			if(stationList.onlyStation(trips.get(i).getStartStation()) || stationList.onlyStation(trips.get(i).getEndStation())){
				System.out.println("Trip ID: " + trips.get(i).getTripId());
			}
		}
	}

	/**
	 * This method will calculate the what is the longest plan duration?
	 * @return the longest plan duration
	 */
	public int longestPlanDuration(){

		int longestPlanDuration = 0;

		for(int i = 0; i<trips.size(); i++){
			int tempDuration = trips.get(i).getPlan_duration();

			if(tempDuration>longestPlanDuration)	{
				longestPlanDuration = tempDuration;
			}

		}		
		return longestPlanDuration;		
	}



	
















}
