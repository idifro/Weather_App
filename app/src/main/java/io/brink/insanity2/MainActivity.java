package io.brink.insanity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputlayoutCity;
    private TextInputEditText inputCity;
    private TextView Temp,Degree,Description,MinTemp,MaxTemp,weather1;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputlayoutCity = findViewById(R.id.input_layout_city);
        inputCity = findViewById(R.id.input_city);
        Temp = findViewById(R.id.tempnum);
        Description = findViewById(R.id.description);
        MinTemp = findViewById(R.id.MinTemp);
        MaxTemp  = findViewById(R.id.MaxTemp);
        btnSubmit = findViewById(R.id.btnSubmit);
        weather1 = findViewById(R.id.weather12);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = inputCity.getText().toString();

                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=c38496d67b56ec5b890637a361416f19";
                Log.d("url",url);
                jsonGetTask jsonG = new jsonGetTask(new WeatherTaskCompleteListener() {
                    @Override
                    public void onWeatherTaskCompleted(Weather weather) {
                        Temp.setText(weather.getTemp()+"°C");
                        MinTemp.setText(weather.getMinTemp()+"°C");
                        MaxTemp.setText(weather.getMaxTemp()+"°C");
                        weather1.setText(weather.getMainWeather());
                        Description.setText(weather.getDescWeather());

                    }
                });
                jsonG.execute(url);
            }
            });

    }
}
