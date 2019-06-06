package io.brink.insanity2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class jsonGetTask extends AsyncTask<String, Void, String> {

    WeatherTaskCompleteListener mListener;


    public jsonGetTask(WeatherTaskCompleteListener listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        String resJson = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(strings[0])
                .build();
        try (Response response = client.newCall(request).execute()) {
            resJson = response.body().string();
            Log.d("resJson",resJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resJson;


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {

            JSONObject weatherObject = new JSONObject(s);
            JSONArray weatherArray = weatherObject.getJSONArray("weather");
            String mainWeather = weatherArray.getJSONObject(0).getString("main");
            String descWeather = weatherArray.getJSONObject(0).getString("description");

            JSONObject mainObject = weatherObject.getJSONObject("main");
            Double temp = mainObject.getDouble("temp");
            Double minTemp = mainObject.getDouble("temp_min");
            Double maxTemp = mainObject.getDouble("temp_max");
            String city = weatherObject.getString("name");

            Weather weather = new Weather(mainWeather,descWeather,temp,minTemp,maxTemp,city);

            mListener.onWeatherTaskCompleted(weather);




        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}

