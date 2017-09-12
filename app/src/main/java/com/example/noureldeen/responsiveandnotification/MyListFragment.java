package com.example.noureldeen.responsiveandnotification;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by noureldeen on 9/12/2017.
 */

public class MyListFragment extends Fragment {
    public ListView myList;
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (MainActivity.IS_A_TABLET) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                ItemDescriptionFragment itemDescriptionFragment = new ItemDescriptionFragment();
                itemDescriptionFragment.setItemID(i);
                fragmentTransaction.replace(R.id.fragment_container, itemDescriptionFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            } else {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.ItemID, i);
                startActivity(intent);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mylist, container, false);
        myList = (ListView) view.findViewById(R.id.list_view_mylist);
        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getItemsname());
        myList.setAdapter(myListAdapter);
        myList.setOnItemClickListener(onItemClickListener);
        return view;
    }

    // we use this function to fill an array of names of our items
    public String[] getItemsname() {
        String[] itemsname = new String[MyList.myList.length];
        for (int i = 0; i < MyList.myList.length; i++)
            itemsname[i] = MyList.myList[i].getItem();
        return itemsname;
    }

}
