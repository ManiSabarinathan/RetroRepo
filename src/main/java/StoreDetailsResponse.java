import com.google.gson.annotations.SerializedName;

public class StoreDetailsResponse {
	
	@SerializedName("stores")
	private Stores stores;

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "StoreDetailsResponse [stores=" + stores + "]";
	}
	
}
