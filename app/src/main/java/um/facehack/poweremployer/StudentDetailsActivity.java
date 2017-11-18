package um.facehack.poweremployer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class StudentDetailsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText genderEditText;
    private EditText ageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


    }
}
