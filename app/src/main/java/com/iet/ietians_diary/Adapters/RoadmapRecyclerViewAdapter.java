package com.iet.ietians_diary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.iet.ietians_diary.Models.RoadmapModel;
import com.iet.ietians_diary.R;

import java.util.ArrayList;

public class RoadmapRecyclerViewAdapter extends RecyclerView.Adapter<RoadmapRecyclerViewAdapter.viewHolder>{
    
    ArrayList<RoadmapModel> list;
    Context context;

    public RoadmapRecyclerViewAdapter(ArrayList<RoadmapModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_roadmap_card, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        RoadmapModel model = list.get(position);

        holder.name.setText(model.getName());
        holder.constraintLayout.setBackgroundResource(model.getBgColor());
        if(position %2 ==0){
            holder.linearLayout.setPadding(0,16,16,16);
        }
        else {
            holder.linearLayout.setPadding(16,16,0,16);
        }
    }

    @Override
    public int getItemCount() {
        
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ConstraintLayout constraintLayout;
        LinearLayout linearLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            constraintLayout = itemView.findViewById(R.id.clRoadmapCard);
            linearLayout = itemView.findViewById(R.id.llContainer);

        }

    }
}

