import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface API {
	
	@Headers({
	    "X-Macys-ClientId:WSSG",
	    "X-Macys-Webservice-Client-Id:bwjz3fjacqygdh2n97hv2sm3",
	    "x-macys-customer-id:bwjz3fjacqygdh2n97hv2sm3",
	    "Content-Type:text/json",
	    "Accept:application/json"
	})	
	
	 @GET("/store/v2/stores?_expand=buildings")
	Call<StoreDetailsResponse> loadStores(@Query("latitude") double lati,@Query("longitude") double longt);
}