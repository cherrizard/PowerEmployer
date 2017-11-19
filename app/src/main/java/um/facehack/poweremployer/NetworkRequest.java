package um.facehack.poweremployer;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;

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

    public void login(String email, String password, String token, final Handler.Callback studentCallback, final Handler.Callback companyCallback) {
        String url = "http://192.168.70.97:8080/login?email=" + email + "&password=" + password + "&token=" + token;
        Log.d(TAG, url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {
                    if (response.getString("type").equals("Student")) {
                        Log.d(TAG, "Student");
                        CurrentUser.getInstance().setUser(Converter.jsonToStudent(response));
                        studentCallback.handleMessage(null);
                    } else {
                        Log.d(TAG, "Company");
                        CurrentUser.getInstance().setUser(Converter.jsonToCompany(response));
                        companyCallback.handleMessage(null);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    public void accept(String name, String companyId) {
        String url = "http://192.168.70.97:8080/sendStudentInvitation?name=" + name + "&companyId=" + companyId;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonObjectRequest);
        requestQueue.start();
    }
}
