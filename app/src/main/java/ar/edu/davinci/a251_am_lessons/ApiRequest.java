package ar.edu.davinci.a251_am_lessons;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiRequest extends AsyncTask<String, Number, String> {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = run(url);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(String s) {
        try {

            JSONObject volumes = new JSONObject(s);
            JSONArray items = (JSONArray) volumes.get("items");
            int cantidadItems = items.length();
            ArrayList<String> titles = new ArrayList<>();
            for (int i = 0; i < cantidadItems; i++) {
                JSONObject primerElememto = (JSONObject) items.get(i);
                JSONObject volumeInfo = (JSONObject) primerElememto.get("volumeInfo");
                String title = (String) volumeInfo.get("title");
                titles.add(title);
            }
            Log.i("api-request", String.valueOf(titles));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        super.onPostExecute(s);
    }
}
