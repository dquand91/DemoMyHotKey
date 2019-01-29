package quanduong.com.demomyhotkey.utils;

import android.util.Log;

import java.util.List;

public class LogUtils {

    private static final String TAG = "QUAN123";

    public static void LogListString(List<String> list){
        if(list == null || list.size() == 0){
            Log.d(TAG, "LogListString: NULL");
            return;
        }
        Log.d(TAG, "LogListString: START-------------------");
        for(int i = 0 ; i < list.size(); i++){
            Log.d(TAG, "LogListString: " + i + " --- " + list.get(i));
        }
        Log.d(TAG, "LogListString: END-------------------");
    }

}
