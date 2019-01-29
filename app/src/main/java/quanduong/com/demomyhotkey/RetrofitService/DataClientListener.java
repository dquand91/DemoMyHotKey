package quanduong.com.demomyhotkey.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClientListener {

	@GET("keywords.json")
	Call<List<String>> getData();

}
