import com.google.gson.annotations.SerializedName;

public class Store {
	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name;	
	@SerializedName("locationNumber")
	private int locationNumber;
	@SerializedName("storeNumber")
	private int storeNumber;
	@SerializedName("divisionId")
	private int divisionId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLocationNumber() {
		return locationNumber;
	}
	public void setLocationNumber(int locationNumber) {
		this.locationNumber = locationNumber;
	}
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	
}
