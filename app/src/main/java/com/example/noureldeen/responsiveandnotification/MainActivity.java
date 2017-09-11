package com.example.noureldeen.responsiveandnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public ListView myList;
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra(DetailsActivity.ItemID,i);
            startActivity(intent);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (ListView) findViewById(R.id.list_view_mylist);
        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getItemsname());
        myList.setAdapter(myListAdapter);
        myList.setOnItemClickListener(onItemClickListener);
    }

    // we use this function to fill an array of names of our items
    public String[] getItemsname() {
        String[] itemsname = new String[MyList.myList.length];
        for (int i = 0; i < MyList.myList.length; i++)
            itemsname[i] = MyList.myList[i].getItem();
        return itemsname;
    }

}
