package com.example.radugym.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.radugym.InsertUserOperation;
import com.example.radugym.R;
import com.example.radugym.User;
import com.example.radugym.UserOperations;

public class SlideshowFragment extends Fragment implements UserOperations {


    public SlideshowFragment(){super(R.layout.fragment_slideshow);}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnSlide = (Button) view.findViewById(R.id.butonSlideShow);
        btnSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUsers();
            }
        });

    }


    private void insertUsers(){
        User user1 = new User(
                1,
                "Irina",
                "Popescu",
                20,
                45,
                160


        );
        User user2 = new User(
                2,
                "Cristi",
                "Andrei",
                18,
                66,
                172

        );
        User[] userList = new User[]{user1, user2};

        new InsertUserOperation(this).execute(userList);
    }

    @Override
    public void insertUsers(String result) {
        if(result.equals("success"))
            Toast.makeText(getContext(), "Users inserted in the database sucessfully", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getContext(), "Users inserted in the database failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void findUser(User user) {
        if(user != null)
            Toast.makeText(getContext(), user.firstName + " is " + user.age, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getContext(), "fail", Toast.LENGTH_LONG).show();
    }

}