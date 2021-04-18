package com.example.radugym.ui.training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radugym.ExercisesAdapter;
import com.example.radugym.ExercisesModel;
import com.example.radugym.R;

import java.util.ArrayList;
import java.util.List;


public class trainingFragment extends Fragment {

    public static List<ExercisesModel> exerciseList = new ArrayList<>();

    public trainingFragment() {
        super(R.layout.fragment_training);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeExerciseList();
        ExercisesAdapter adapter = new ExercisesAdapter(exerciseList);
        RecyclerView rv = view.findViewById(R.id.recview);
        rv.setAdapter(adapter);

    }

    private void initializeExerciseList()
    {
        exerciseList.removeAll(exerciseList);
        exerciseList.add(new ExercisesModel("Target: Chest","40min", R.drawable.chest_muscles));
        exerciseList.add(new ExercisesModel("Target: Back", "30min", R.drawable.back_muscles));
        exerciseList.add(new ExercisesModel("Target: Arms", "35min", R.drawable.arm_muscles));
        exerciseList.add(new ExercisesModel("Target: Shoulders", "25min", R.drawable.deltoid_muscles));
        exerciseList.add(new ExercisesModel("Target: Legs", "45min", R.drawable.leg_muscles));
    }
}