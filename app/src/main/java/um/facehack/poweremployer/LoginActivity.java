package um.facehack.poweremployer;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";

    private Button signInButton;
    private EditText emailEdittext;
    private EditText passwordEdittext;
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        signInButton = findViewById(R.id.sign_in_button);
        signUpTextView = findViewById(R.id.signUpTextView);
        emailEdittext = findViewById(R.id.email);
        passwordEdittext = findViewById(R.id.password);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdittext.getText().toString().trim();
                String pass = passwordEdittext.getText().toString().trim();

                if (email.isEmpty()) {
                    emailEdittext.setError("Please enter an email address.");
                    return;
                } else if (pass.isEmpty()) {
                    passwordEdittext.setError("Please enter password.");
                    return;
                } else {
                    String token = FirebaseInstanceId.getInstance().getToken();
                    Log.d(TAG, token);
                    Handler.Callback studentCallback = new Handler.Callback() {
                        @Override
                        public boolean handleMessage(Message message) {
                            Intent intent = new Intent(getApplicationContext(), StudentDetailsActivity.class);
                            startActivity(intent);
                            return false;
                        }
                    };

                    Handler.Callback companyCallback = new Handler.Callback() {
                        @Override
                        public boolean handleMessage(Message message) {
                            Intent intent = new Intent(getApplicationContext(), CompanyDetailsActivity.class);
                            startActivity(intent);
                            return false;
                        }
                    };

                    NetworkRequest.getInstance().login(email, pass, token, studentCallback, companyCallback);
                }
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        NetworkRequest.init(getApplicationContext());
    }
}
