package um.facehack.poweremployer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class CompanyDetailsActivity extends AppCompatActivity {

    private EditText companyName;
    private EditText address;
    private EditText phone;
    private RadioButton male;
    private RadioButton female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        companyName = findViewById(R.id.companyName);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        Company company = (Company) CurrentUser.getInstance().getUser();

        companyName.setText(company.getName());
        address.setText(company.getAddress());
        phone.setText(company.getTelNo());
        if (company.getGenderCriteria() == 'M') {
            male.setChecked(true);
        } else {
            female.setChecked(true);
        }
    }
}
