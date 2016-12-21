import java.util.Scanner;

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

		System.out.println("Here is the list of questions, enter the index to see the answers: ");

		System.out.println("1. How many Walk-Up trips were there in 2016?");
		System.out.println("2. How many stations that had a Go-Live Date in 2015 are still Active?");
		System.out.println("3. What percentage of trips started in Rittenhouse Square?");
		System.out.println("4. What percentage of trips made by Indego30 riders are round trips?");
		System.out.println("5. What is the ID of the bike that has traveled the most in terms of duration?");
		System.out.println("6. On 8/3/16 at 7:00am, how many bikes were being used?");
		System.out.println("7. Print all the trip information for the longest trip by distance.");
		System.out.println("8. Print the list of trip ids of all trips that involved a station which was the only station to go live on its respective go live date.");
		System.out.println("9. Find all pairs of stations that are considered close to each other: ");
		System.out.println("10. What is the least popular end station?");

		Scanner in = new Scanner(System.in);
		int questionIndex = in.nextInt();
		for(;;){

			if(questionIndex == 1){
				System.out.println("How many Walk-Up trips were there in 2016?");
				String passHolderType = "Walk-up";
				System.out.println(ps.getPassHolderType(passHolderType));	
			}

			if(questionIndex == 2){
				System.out.println("How many stations that had a Go-Live Date in 2015 are still Active?");
				int year = 2015;
				String status = "Active";
				System.out.println(s.activeStation(year, status));
			}

			if(questionIndex == 3){
				System.out.println("What percentage of trips started in Rittenhouse Square?");
				String locationName = "Rittenhouse Square";
				System.out.println(t.startStationPercentage(locationName));
			}

			if(questionIndex == 4){
				System.out.println("What percentage of trips made by Indego30 riders are round trips?");
				String passHolderType2 = "Indego30";
				String trip_route_category = "Round Trip";
				System.out.println(t.getPercentageOfTripRoute(passHolderType2, trip_route_category));
			}

			if(questionIndex == 5){
				System.out.println("What is the ID of the bike that has traveled the most in terms of duration?");
				b.getBikeId(b.getMostDuration());
			}

			if(questionIndex == 6){
				System.out.println("On 8/3/16 at 7:00am, how many bikes were being used?");
				String time = "8/3/2016 7:00";
				String[] time2 = time.split(" ");
				int date = Integer.parseInt(time2[0].replace("/", ""));
				int moment = Integer.parseInt(time2[1].replace(":", ""));
				System.out.println(t.getBikeNumbersAtTime(date, moment));
			}

			if(questionIndex == 7){
				System.out.println("Print all the trip information for the longest trip by distance.");
				t.printTrips(t.getLongestTrip());
			}



			if(questionIndex == 8){
				System.out.println("Print the list of trip ids of all trips that involved a station which was the only station to go live on its respective go live date.");
				t.tripIdofOnlyStation();
			}

			if(questionIndex == 9){
				System.out.println("Find all pairs of stations that are considered close to each other: ");
				s.getClosePairs();
			}

			if(questionIndex == 10){
				System.out.println("What is the least popular end station?");
				String keyword = "least";
				String station = "end Station";
				System.out.println(t.findPopularStation(keyword,station).getStationName());
			}
			if(questionIndex == 0){
				break;
			}

			System.out.println("Enter the question's index or 0 to quit");

			questionIndex = in.nextInt();


		}
	}
}
