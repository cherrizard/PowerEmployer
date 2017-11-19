package um.facehack.poweremployer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentCompanyListActivity extends AppCompatActivity {

    CompanyFragment companyFragment = new CompanyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_company_list);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, companyFragment).commit();
    }

}
