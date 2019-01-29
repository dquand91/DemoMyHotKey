package quanduong.com.demomyhotkey.RetrofitService;

public class APIUtils {

    public static final String BASE_URL = "https://gist.githubusercontent.com/talenguyen/38b790795722e7d7b1b5db051c5786e5/raw/63380022f5f0c9a100f51a1e30887ca494c3326e/";

    public static DataClientListener getDataRetrofit(){
        return RetrofitClient.getRetrofitClient(BASE_URL).create(DataClientListener.class);
    }

}
