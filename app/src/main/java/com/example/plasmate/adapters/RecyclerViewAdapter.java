package com.example.plasmate.adapters;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.plasmate.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
//    private ArrayList<String> mnames = new ArrayList<>();
//    private Context mContext;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plasma_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset(collection of data like arraylist) at this position and replace the
        // contents of the view with that element
        Log.d(TAG, String.valueOf(position));
        if(position==6){
            holder.personName.setText("Sachin Baghel");
        }

        holder.listParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick:  ");
            }
        });
    }

    @Override
    public int getItemCount() {
        // Return the size of your dataset
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView personName,personEmail,personNo, personLocation;
        ImageView bldIcon;
        RelativeLayout listParentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.person_name);
            personEmail = itemView.findViewById(R.id.person_email);
            personNo = itemView.findViewById(R.id.person_no);
            personLocation = itemView.findViewById(R.id.person_location);
            bldIcon = itemView.findViewById(R.id.bld_icon);
            listParentLayout = itemView.findViewById(R.id.list_parent_layout);

        }
    }
    public static class EqualSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mSpaceHeight;

        public EqualSpaceItemDecoration(int mSpaceHeight) {
            this.mSpaceHeight = mSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mSpaceHeight;
            outRect.top = mSpaceHeight;
            outRect.left = mSpaceHeight;
            outRect.right = mSpaceHeight;
        }
    }

}
