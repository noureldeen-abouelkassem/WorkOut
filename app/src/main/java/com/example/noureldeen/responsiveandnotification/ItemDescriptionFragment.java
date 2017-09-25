package com.example.noureldeen.responsiveandnotification;

import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by noureldeen on 9/12/2017.
 */

public class ItemDescriptionFragment extends Fragment {
    TextView itemDescription;
    private int ItemID = 0;
    Button showNotification;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int mNotificationId = 1;
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
            builder.setContentTitle("First Notification");
            builder.setContentText("say hello to my first notification");
            builder.setSmallIcon(R.drawable.ic_stat_name);
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getActivity());
            taskStackBuilder.addParentStack(TestActivity.class);
            taskStackBuilder.addNextIntent(intent);
            //as we see when we added adifferent parentStack the back button behaviour has been changed
            //taskStackBuilder.addNextIntentWithParentStack(intent);
            builder.setContentIntent(taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT));
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState!=null){
            ItemID = savedInstanceState.getInt(DetailsActivity.ItemID);
        }
        View view = inflater.inflate(R.layout.fragment_itemdetails, container, false);
        itemDescription = (TextView) view.findViewById(R.id.textView_itemDescription);
        itemDescription.setText(MyList.myList[ItemID].getDescription());
        showNotification = (Button) view.findViewById(R.id.button_showNotification);
        showNotification.setOnClickListener(onClickListener);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(DetailsActivity.ItemID,ItemID);
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

}
