import java.util.ArrayList;
/**
 * This class has a list of pass Holder types
 * @author muyiyimiss
 *
 */
public class PassHolderTypes {
	
	private ArrayList<PassHolderType> ptypes;
	
	
	/**
	 * This is the constructor, it will initialize an ArrayList of pass holder types
	 */
	public PassHolderTypes() {
		ptypes = new ArrayList<PassHolderType>();
	}
	
	/**
	 * This is the return method of getPtypes
	 * @return an array list of ptypes
	 */
	public ArrayList<PassHolderType> getPtypes() {
		return ptypes;
	}
	
	/**
	 * This method will ass a pass Holder type to the array list
	 * @param p
	 */
	public void addPTpes(PassHolderType p){
		ptypes.add(p);
	}
	
	
	/**
	 * This method will get the number of pass holder types with a certain name
	 * @param s, the name of the pass holder type
	 * @return, the number of pass holder types with a certain name
	 */
	public int getPassHolderType(String s){
		int n = 0;
		for(int i = 0; i<ptypes.size(); i++){
			if(ptypes.get(i).getPassHolderType().equalsIgnoreCase(s)){
				n++;
			}
		}
		return n;
	}
	
	
}
