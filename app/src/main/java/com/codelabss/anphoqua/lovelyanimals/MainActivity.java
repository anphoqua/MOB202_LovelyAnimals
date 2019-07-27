package com.codelabss.anphoqua.lovelyanimals;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ListView animalList;
    ArrayList<Animal> animalArrayList = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalList = findViewById(R.id.listViewID);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.pawprint);
        actionBar.setDisplayUseLogoEnabled(true);

        animalArrayList.add(new Animal(R.drawable.bear, "Bear"));
        animalArrayList.add(new Animal(R.drawable.tiger, "Tiger"));
        animalArrayList.add(new Animal(R.drawable.owl, "Owl"));
        animalArrayList.add(new Animal(R.drawable.eagle, "Eagle"));

        AnimalAdapter animalAdapter = new AnimalAdapter(MainActivity.this, animalArrayList);
        animalList.setAdapter(animalAdapter);

        registerForContextMenu(animalList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this,"Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_sky:
                Toast.makeText(this,"Sky", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ground:
                Toast.makeText(this,"Ground", Toast.LENGTH_SHORT).show();
            case R.id.action_water:
                Toast.makeText(this,"Water", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_items, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        switch (item.getItemId()) {
            case R.id.item_feed:
                Toast.makeText(this,"Feed " + animalArrayList.get(index).name, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_hug:
                Toast.makeText(this,"Hug " +animalArrayList.get(index).name, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_donate:
                Toast.makeText(this,"Donate " +animalArrayList.get(index).name, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
