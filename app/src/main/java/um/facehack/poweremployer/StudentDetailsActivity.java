package um.facehack.poweremployer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class StudentDetailsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText genderEditText;
    private EditText ageEditText;
    private EditText phoneEditText;
    private EditText courseEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        nameEditText = findViewById(R.id.name);
        genderEditText = findViewById(R.id.gender);
        ageEditText = findViewById(R.id.age);
        phoneEditText = findViewById(R.id.phone);
        courseEditText = findViewById(R.id.course);

        Student student = (Student) CurrentUser.getInstance().getUser();

        nameEditText.setText(student.name);

        if (student.getGender()) {
            genderEditText.setText("Male");
        } else {
            genderEditText.setText("Female");
        }

        ageEditText.setText(String.valueOf(student.getAge()));
        phoneEditText.setText(student.getTelNo());
        courseEditText.setText(student.getCourse());

    }
}
