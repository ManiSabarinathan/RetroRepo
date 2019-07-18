

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<StoreDetailsResponse> {
	 // static final String Store_URL = "https://api.macys.com/store/v2/stores?_expand=buildings&latitude=40.75066929&longitude=-73.98908937";
	 static final String Store_URL="https://api.macys.com/store/v2/";
	 
	    public void start() {
	    	//GSON declaration
	        Gson gson = new GsonBuilder()
	                .setLenient()
	                .create();

	        //Create okHttpClient
	        OkHttpClient.Builder okhttpclientBuilder = new OkHttpClient.Builder();
	        
	        //Interceptor
	        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
	        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
	        okhttpclientBuilder.addInterceptor(logging);
	        
	      	        
	        //Retrofit Builder
	        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
	                .baseUrl(Store_URL)
	                .addConverterFactory(GsonConverterFactory.create(gson))
	                .client(okhttpclientBuilder.build());
	        
	        //Build Retrofit
	        Retrofit retrofit = retrofitBuilder.build();
	        API api = retrofit.create(API.class);

	        //Invoke a service  
	        Call<StoreDetailsResponse> call = api.loadStores(Double.valueOf("40.75066929"),Double.valueOf("-73.98908937"));		       
	        call.enqueue(this);

	    }

		
		@Override
		public void onFailure(Call<StoreDetailsResponse> call, Throwable t) {
			System.out.println("Inside Failure block:: " + call.request().url().toString());
			System.out.println(t);
			
		}

		@Override
		public void onResponse(Call<StoreDetailsResponse> call, retrofit2.Response<StoreDetailsResponse> response) {
			System.out.println("*****Inside onResponse*****");
			System.out.println("HttpStatus::      " + response.message());
			System.out.println("HttpStatusCode::  " + response.code());
			System.out.println("URL ::            " + call.request().url().toString());
			if(response.isSuccessful()) {
				System.out.println("Received Successful Response");
				System.out.println("Response Body :::"+ new Gson().toJson(response.body()) );
				System.out.println("Specific Names " + response.body().getStores().getStoreList().get(3).getName());
			} else {
				System.out.println("Received failed Response");
			}
			
		}
}