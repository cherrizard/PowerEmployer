package um.facehack.poweremployer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentDetailsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText genderEditText;
    private EditText ageEditText;
    private EditText phoneEditText;
    private EditText courseEditText;
    private Button companyListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        nameEditText = findViewById(R.id.name);
        genderEditText = findViewById(R.id.gender);
        ageEditText = findViewById(R.id.age);
        phoneEditText = findViewById(R.id.phone);
        courseEditText = findViewById(R.id.course);
        companyListButton = findViewById(R.id.company_list_button);

        Student student = (Student) CurrentUser.getInstance().getUser();

        nameEditText.setText(student.name);

        if (student.getGender() == 'M') {
            genderEditText.setText("Male");
        } else {
            genderEditText.setText("Female");
        }

        ageEditText.setText(String.valueOf(student.getAge()));
        phoneEditText.setText(student.getTelNo());
        courseEditText.setText(student.getCourse());

        companyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentCompanyListActivity.class);
                startActivity(intent);
            }
        });

    }
}
