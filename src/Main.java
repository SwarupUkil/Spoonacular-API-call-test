import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class Main {
    private static final String API_TOKEN = "79837527486348c3922776a6ebb6290a";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spoonacular.com/recipes/complexSearch?query=pasta&number=2")
                .addHeader("x-api-key", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
//            System.out.println(response);
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());
            System.out.println(responseBody);
            JSONArray responseArray = responseBody.getJSONArray("results");
            System.out.println(responseArray);
            System.out.println(responseArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}