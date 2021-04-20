package com.example.radugym.ui.home;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.radugym.MainActivity;
import com.example.radugym.R;

public class HomeFragment extends Fragment {

    private static final String CHANNEL_ID = "channel";

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button not = (Button) view.findViewById(R.id.butonNotificare);
        not.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
              //  TextView text = (TextView) view.findViewById(R.id.text_home);
              //  text.setText("Test de proba");


                Intent intent = new Intent(getContext(), MainActivity.class);
               // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getContext() , 0, intent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(),CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification).setContentTitle("Notificare")
                        .setContentText("Time to workout")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    CharSequence name = getString(R.string.channel_name);
                    int importance = NotificationManager.IMPORTANCE_DEFAULT;
                    NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

                    // Register the channel with the system; you can't change the importance
                    // or other notification behaviors after this
                    NotificationManager notificationManager = requireActivity().getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);
                }

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
                notificationManager.notify(1 , builder.build());


            }
        });

    }
}
