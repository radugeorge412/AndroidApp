package com.example.radugym;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import com.example.radugym.R;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder> {

    private List<ExercisesModel> data;

    public ExercisesAdapter(List<ExercisesModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training,parent, false);
        return new ExercisesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ExercisesViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView time;
        private final ImageView exerciseImage;
        private final ConstraintLayout layout;

        public ExercisesViewHolder(@NonNull View view) {
            super(view);
            title=view.findViewById(R.id.exercise_title);
            time=view.findViewById(R.id.exercise_description);
            exerciseImage=view.findViewById(R.id.exercise_pic);
            layout =view.findViewById(R.id.container);
        }



        public void bind(ExercisesModel item)
        {
            title.setText(item.getTitle());
            time.setText(item.getTime());
            exerciseImage.setImageDrawable(ContextCompat.getDrawable(exerciseImage.getContext(),item.getImageId()));

        }
    }


}
