package um.facehack.poweremployer;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CompanyRecyclerViewAdapter extends RecyclerView.Adapter<CompanyRecyclerViewAdapter.ViewHolder> {

    private final List<StudentCompanyModel> mValues = new ArrayList<>();

    private final String TAG = "CompanyRecyclerViewAdapter";

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_company, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.companyEmailVIew.setText(mValues.get(position).getCompanyEmail());
        holder.companyNameView.setText(mValues.get(position).getCompanyName());
        holder.companyAddressView.setText(mValues.get(position).getCompanyAddress());
        final int pos = position;
        holder.showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, mValues.get(pos).getMessages());
            }
        });
    }

    public void addItem(StudentCompanyModel studentCompanyModel) {
        mValues.add(studentCompanyModel);
        notifyItemInserted(mValues.size());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView companyNameView;
        public final TextView companyAddressView;
        public final TextView companyEmailVIew;
        public final Button showButton;

        public StudentCompanyModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            companyAddressView = view.findViewById(R.id.companyAddress);
            companyNameView = view.findViewById(R.id.companyName);
            companyEmailVIew = view.findViewById(R.id.companyEmail);
            showButton = view.findViewById(R.id.show_button);
        }

    }
}
