package com.example.api_weather;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    Button btnSearch;
    TextView txtName, txtCounty, txtTemp, txtStatus, txtHumidity, txtCloud, txtWind, txtDay;
    ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Anhxa();

        btnSearch.setOnClickListener(v -> {
            String city = edtSearch.getText().toString();
            GetCurrentWeatherData(city);
        });
    }

    public void GetCurrentWeatherData(String data) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + data + "&appid=0e95c823951bd8898ce62701d0a88dc2&units=metric";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("API Response", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String day = jsonObject.getString("dt");
                            String name = jsonObject.getString("name");
                            txtName.setText("Tên thành phố : " + name);

                            long l = Long.valueOf(day);
                            Date date = new Date(l * 1000L);
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE yyyy-MM-dd HH-mm--ss");
                            String Day = simpleDateFormat.format(date);

                            txtDay.setText(Day);
                            JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
                            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
                            String status = jsonObjectWeather.getString("main");
                            String icon = jsonObjectWeather.getString("icon");

                            Picasso.get().load("https://openweathermap.org/img/wn/" + icon + ".png").into(imgIcon);
                            txtStatus.setText(status);

                            JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                            String nhietdo = jsonObjectMain.getString("temp");
                            String doam = jsonObjectMain.getString("humidity");

                            Double a = Double.valueOf(nhietdo);
                            String Nhietdo = String.valueOf(a.intValue());

                            txtTemp.setText(Nhietdo + "°C");
                            txtHumidity.setText(doam + "%");

                            JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                            String gio = jsonObjectWind.getString("speed");
                            txtWind.setText(gio + "m/s");

                            JSONObject jsonObjectClouds = jsonObject.getJSONObject("clouds");
                            String may = jsonObjectClouds.getString("all");
                            txtCloud.setText(may + "%");

                            JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
                            String country = jsonObjectSys.getString("country");
                            txtCounty.setText("Tên quốc gia : " + country);
                        } catch (JSONException e) {
                            Log.e("JSON Error", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("API Error", error.toString());
                    }
                });
        requestQueue.add(stringRequest);
    }

    private void Anhxa() {
        edtSearch = findViewById(R.id.edittextSearch);
        btnSearch = findViewById(R.id.buttonSearch);
        txtName = findViewById(R.id.textViewName);
        txtCounty = findViewById(R.id.textViewCountry);
        txtTemp = findViewById(R.id.textviewTemp);
        txtStatus = findViewById(R.id.textViewStatus);
        txtHumidity = findViewById(R.id.textviewHumidity);
        txtCloud = findViewById(R.id.textviewCloud);
        txtWind = findViewById(R.id.textviewWind);
        txtDay = findViewById(R.id.textviewDay);
        imgIcon = findViewById(R.id.imageIcon);

        Log.d("UI Elements", "txtName: " + txtName + ", txtTemp: " + txtTemp);
    }
}
