package com.example.groceryapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.groceryapp.foodtypes.Dairy;
import com.example.groceryapp.foodtypes.Organics;
import com.example.groceryapp.foodtypes.Item;
import com.example.groceryapp.foodtypes.Toiletries;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> shoppingListItems = null;
    ArrayAdapter<String> adapter = null;
    ListView lv = null;
    ArrayList<String> shoppingList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shoppingList = new ArrayList<>();
        shoppingListItems = new ArrayList<>();

        Dairy Eggs = new Dairy("Eggs", 9, 3.99, false);
        shoppingListItems.add(Eggs);
        Dairy Milk = new Dairy("Milk", 5, 5.99, true);
        shoppingListItems.add(Milk);
        Toiletries Chapstick = new Toiletries("Chapstick", 2.99, false);
        shoppingListItems.add(Chapstick);
        Organics Bananas = new Organics("Bananas", 4, 0.59, 1.45);
        shoppingListItems.add(Bananas);
        Organics Peaches = new Organics("Peaches", 6, 1.25, 2.56);
        shoppingListItems.add(Peaches);
        Toiletries Tide = new Toiletries("Tide", 20.99, true);
        shoppingListItems.add(Tide);


        for (int i = 0; i < shoppingListItems.size(); i++){
            shoppingListItems.get(i).setArrLoc(i);
            shoppingList.add(shoppingListItems.get(i).name + "     " + shoppingListItems.get(i).getPrice());
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_sort_alph) {
            sortListAlph();
            lv.setAdapter(adapter);
        }
        if (id == R.id.action_sort_num) {
            sortListNum();
            lv.setAdapter(adapter);
        }

        return super.onOptionsItemSelected(item);
    }

    public void sortListAlph(){
        int count = shoppingListItems.size();
        Log.println(Log.INFO, "Count Size", "" + count);
        Item temp;
        String tempi;

        for (int i = 0; i < count; i++){

            for (int j = i + 1; j < count; j++){
                if (shoppingListItems.get(i).name.compareTo(shoppingListItems.get(j).name) > 0) {
                    temp = shoppingListItems.get(i);
                    tempi = shoppingList.get(i);
                    shoppingListItems.set(i, shoppingListItems.get(j));
                    shoppingList.set(i, shoppingList.get(j));
                    shoppingListItems.set(j, temp);
                    shoppingList.set(j, tempi);
                }
            }
        }
        /*
        for (int i = 0; i < count; i++){
            shoppingList.add(shoppingListItems.get(i).name);
            Log.println(Log.INFO, "Shoppinglist I", "" + i);
        }
         */
    }

    public void sortListNum(){
        int count = shoppingListItems.size();
        Log.println(Log.INFO, "Count Size", "" + count);
        Item temp;
        String tempi;

        for (int i = 0; i < count; i++) {

            for (int j = i + 1; j < count; j++) {
                if (shoppingListItems.get(i).getPrice() < shoppingListItems.get(j).getPrice()){
                    temp = shoppingListItems.get(i);
                    tempi = shoppingList.get(i);
                    shoppingListItems.set(i, shoppingListItems.get(j));
                    shoppingList.set(i, shoppingList.get(j));
                    shoppingListItems.set(j, temp);
                    shoppingList.set(j, tempi);
                }
            }
        }
    }
}
