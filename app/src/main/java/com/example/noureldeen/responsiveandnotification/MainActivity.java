package com.example.noureldeen.responsiveandnotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public ListView myList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (ListView) findViewById(R.id.list_view_mylist);
        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,getItemsname());
        myList.setAdapter(myListAdapter);
    }

    // we use this function to fill an array of names of our items
    public String[] getItemsname() {
        String[] itemsname = new String[MyList.myList.length];
        for (int i = 0; i < MyList.myList.length; i++)
            itemsname[i] = MyList.myList[i].getItem();
        return itemsname;
    }

}
