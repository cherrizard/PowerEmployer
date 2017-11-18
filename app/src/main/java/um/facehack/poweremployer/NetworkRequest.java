package um.facehack.poweremployer;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by calvinlow on 18/11/2017.
 */

public class NetworkRequest {
    private String TAG = "NetworkRequest";

    private static final NetworkRequest ourInstance = new NetworkRequest();

    public static NetworkRequest getInstance() {
        return ourInstance;
    }

    private static RequestQueue requestQueue;

    public static void init(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void login(String email, String password, String token, final Handler.Callback studentCallback) {
        String url = "http://192.168.70.97:8080/login?email=" + email + "&password=" + password + "&token=" + token;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getString("type").equals("Student")) {
                        CurrentUser.getInstance().setUser(Converter.jsonToStudent(response.getJSONObject("data")));
                        studentCallback.handleMessage(null);
                    } else {
                        CurrentUser.getInstance().setUser(Converter.jsonToCompany(response.getJSONObject("data")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
        requestQueue.start();
    }
}
