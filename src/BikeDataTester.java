/**
 * This is the main method, it will ask all the questions
 * @author muyiyimiss
 *
 */
public class BikeDataTester {

	public static void main(String[] args) {
		
		
		
		PassHolderTypes ps = new PassHolderTypes();
		Stations s = new Stations();
		Times times = new Times();
		Bike b = new Bike();
		Trips t = new Trips(s, ps, times, b);
		
		
		System.out.println("How many Walk-Up trips were there in 2016?");	
		String passHolderType = "Walk-up";
		System.out.println(ps.getPassHolderType(passHolderType));	
		
		
		System.out.println("How many stations that had a Go-Live Date in 2015 are still Active?");
		int year = 2015;
		String status = "Active";
		System.out.println(s.activeStation(year, status));
		
		System.out.println("What percentage of trips started in Rittenhouse Square?");
		String locationName = "Rittenhouse Square";
		System.out.println(t.startStationPercentage(locationName));

		System.out.println("What percentage of trips made by Indego30 riders are round trips?");
		String passHolderType2 = "Indego30";
		String trip_route_category = "Round Trip";
		System.out.println(t.getPercentageOfTripRoute(passHolderType2, trip_route_category));
		
		System.out.println("What is the ID of the bike that has traveled the most in terms of duration?");
		b.getBikeId(b.getMostDuration());
		
		
		System.out.println("On 8/3/16 at 7:00am, how many bikes were being used?");
		String time = "8/3/2016 7:00";
		String[] time2 = time.split(" ");
		int date = Integer.parseInt(time2[0].replace("/", ""));
		int moment = Integer.parseInt(time2[1].replace(":", ""));
		System.out.println(t.getBikeNumbersAtTime(date, moment));
		
		System.out.println("Print all the trip information for the longest trip by distance.");
		t.printTrips(t.getLongestTrip());
		
		System.out.println("Wild card: How many stations have a go live date of 4/23/15?");
		String goLiveDate = "4/23/15";
		int goLiveDate2 = Integer.parseInt(goLiveDate.replace("/", ""));
		System.out.println(s.stationsWithGLD(goLiveDate2));
		
		System.out.println("Print the list of trip ids of all trips that involved a station which was the only station to go live on its respective go live date.");
		t.tripIdofOnlyStation();
		
		//Extra Credit:
		
		System.out.println("Find all pairs of stations that are considered close to each other: ");
		s.getClosePairs();
		
		System.out.println("What is the least popular end station?");
		String keyword = "least";
		String station = "end Station";
		System.out.println(t.findPopularStation(keyword,station).getStationName());

		System.out.println("Wild card: What is the longest plan? ");
		System.out.println("The longest plan is: " + t.longestPlanDuration());
		
	}
}
