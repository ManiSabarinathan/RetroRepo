import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Stores {
	
	@SerializedName("store")
	private List<Store> storeList;

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}
}
