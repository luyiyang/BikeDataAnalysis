import java.util.ArrayList;
/**
 * The Stations class has a list of OneStations
 * @author muyiyimiss
 *
 */
public class Stations {

	/**
	 * These are instance variables
	 */
	private FileReader stationTableFile;
	private ArrayList<OneStation> stations;

	/**
	 * This is the constructor of the station
	 */
	public Stations(){
		stations = new ArrayList<OneStation>();
		stationTableFile = new FileReader("Station-Table.csv");
		convertFile();
	}

	/**
	 * This method will add OneStation to the ArrayList<OneStations>();
	 * @param s The name of the OneStation that will be added
	 */
	public void addStation(OneStation s){
		stations.add(s);
	}

	/**
	 * This method will convert the Strings at ArrayList<Strings>() get from scanFile() to different variables for different uses 
	 */
	public void convertFile(){

		ArrayList<String> stationLines = stationTableFile.getLines();

		for(int j = 1; j<stationLines.size();j++){

			String[] info2 = stationLines.get(j).split(",");

			int stationId = Integer.parseInt(info2[0]);

			String stationName = null;

			long goLiveDate = 0;

			String status = null;

			OneStation st = null;

			CharSequence ch;
			ch = "\"";

			if(info2[1].contains(ch)){
				stationName = info2[1].concat(info2[2]);

				goLiveDate = Long.parseLong(info2[3].replaceAll("/", ""));

				status = info2[4];

			}else{
				stationName = info2[1];

				goLiveDate = Long.parseLong(info2[2].replaceAll("/", ""));

				status = info2[3];
			}

			st = new OneStation(stationId, stationName, goLiveDate, status);

			addStation(st);

		}
	}


	/**
	 * This is the return method of the ArrayList of stations
	 * @return
	 */
	public ArrayList<OneStation> getStations() {
		return stations;
	}

	/**
	 * This method will calculate how many stations that had some Go-Live year at some status
	 * @return
	 */
	public int activeStation(long l, String s){
		int activeStation = 0;
		for(int i = 0; i<stations.size(); i++){
			OneStation a = stations.get(i);
			if(l==2015){
				long b = a.getGoLiveDate();
				if(b%10 == 5 && a.getStatus().equalsIgnoreCase(s)){
					activeStation++;
				}
			}
			else{
				long b = a.getGoLiveDate();
				if(b%10 == 6 && a.getStatus().equalsIgnoreCase(s)){
					activeStation++;
				}
			}
		}

		return activeStation;
	}

	/**
	 * This method will get the number of stations that have a certain go live date
	 * @param l, the go live date
	 * @return, the number of stations
	 */
	public int stationsWithGLD(long l){
		int n = 0;
		for(int i = 0; i<stations.size(); i++){
			if(stations.get(i).getGoLiveDate() == l){
				n++;
			}
		}
		return n;
	}

	/**
	 * This method test whether a station is the only station to go live on its respective go-live date
	 * @return boolean, true if it is the only station, false it is not.
	 */

	public boolean onlyStation(OneStation i){
		boolean isOnlyStation = true;
		long l = i.getGoLiveDate();
		int count = 0;
		for(int j = 0; j<stations.size(); j++){
			if(l == stations.get(j).getGoLiveDate()){
				count ++;
			}
		}
		if(count != 1){
			isOnlyStation = false;
		}

		return isOnlyStation;
	}

	/**
	 * This method will print out the close pairs of two station
	 */
	public void getClosePairs(){
		for(int i = 0; i<stations.size(); i++){
			for(int j = i+1; j<stations.size(); j++){
				if(close(stations.get(i),stations.get(j))){
					System.out.println("[" + stations.get(i).getStationName() + ", " +stations.get(j).getStationName() + "]");
				}
			}
		}
	}

	/**
	 * This method will calculate whether two stations are close to each other
	 * @param a, OneStation a
	 * @param b, OneStation b
	 * @return close, true if the two stations are close to each other; false if the two stations are not close to each other
	 */
	public boolean close(OneStation a, OneStation b){
		boolean close = false;

		if(a.getLat() == Double.MAX_VALUE || a.getLon() == Double.MAX_VALUE || b.getLat() == Double.MAX_VALUE || b.getLon() == Double.MAX_VALUE){

			close = false;

		}else{

			double c = a.getLat();
			double d = b.getLat();

			double e = a.getLon();
			double f = b.getLon();

			double m = Math.abs(c-d);
			double n = Math.abs(e-f);
			double q = (m+n)/0.02;

			if(q<0.02){

				close = true;

			}
		}

		return close;

	}


}
