package com.example.noureldeen.responsiveandnotification;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by noureldeen on 9/12/2017.
 */

public class ItemDescriptionFragment extends Fragment {
    TextView itemDescription;
    private int ItemID = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState!=null){
            ItemID = savedInstanceState.getInt(DetailsActivity.ItemID);
        }
        View view = inflater.inflate(R.layout.fragment_itemdetails, container, false);
        itemDescription = (TextView) view.findViewById(R.id.textView_itemDescription);
        itemDescription.setText(MyList.myList[ItemID].getDescription());
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
