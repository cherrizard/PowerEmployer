package um.facehack.poweremployer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CompanyFragment extends Fragment {

    private CompanyRecyclerViewAdapter companyRecyclerViewAdapter;

    public CompanyFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        companyRecyclerViewAdapter = new CompanyRecyclerViewAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.company_list);
        recyclerView.setAdapter(companyRecyclerViewAdapter);

        List<StudentCompanyModel> studentCompanyModels = AppDatabase.getAppDatabase(view.getContext()).SCDAO().getAll();

        for (StudentCompanyModel studentCompanyModel : studentCompanyModels) {
            companyRecyclerViewAdapter.addItem(studentCompanyModel);
        }


//        StudentCompanyModel studentCompanyModel = new StudentCompanyModel();
//        studentCompanyModel.setCompanyName("Name");
//        studentCompanyModel.setCompanyEmail("Email");
//        studentCompanyModel.setCompanyAddress("Address");


    }
}
