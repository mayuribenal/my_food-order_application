package com.mayuri.foodorderapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mayuri.foodorderapplication.Adapters.MainAdapters;
import com.mayuri.foodorderapplication.Models.MainModel;
import com.mayuri.foodorderapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Chiken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.burgerking, "BurgerKing", "35", "A BK Original Burger With Cheese."));
        list.add(new MainModel(R.drawable.pizzaa, "Pizza", "55", "One of the simplest and most traditional pizzas ."));
        list.add(new MainModel(R.drawable.burgerpizza, "BurgerPizza", "50", "Burger Pizza is burger . "));
        list.add(new MainModel(R.drawable.mushroom, "Portobello Mushroom", "26", "mushroom chicken Burger "));
        list.add(new MainModel(R.drawable.burger, "Burger", "10", "veg burger with extra creamy"));
        list.add(new MainModel(R.drawable.c_donuts, "Donuts", "15", "all flaours of Donuts with extra cream"));
        list.add(new MainModel(R.drawable.c_momos, "Momos", "24", "Veg momos with Extra cheese"));
        list.add(new MainModel(R.drawable.finger, "FingerChips", "15", "finger chips with cheese"));
        list.add(new MainModel(R.drawable.gobi, "Gobi Manchurian", "25", "Manchurian with Extra cheese"));
        list.add(new MainModel(R.drawable.roll, "Paneer Roll", "20", "paneer roll with Extra cheese"));
        list.add(new MainModel(R.drawable.samosa, "Samosa", "5", "vegis with Extra cheese"));
        list.add(new MainModel(R.drawable.lava, "Lava ChocoCake", "5", "Chocolate cake with Extra choco cream"));
        list.add(new MainModel(R.drawable.lavaa, "Blackforestcake ", "60", "Chocolate cake with cream"));
        list.add(new MainModel(R.drawable.noodles, "Veg Noodles ", "22", "veg noodles Extra cheese"));
        list.add(new MainModel(R.drawable.staw, "Stawberry Cake", "75", "Stawberry cake with Extra cream"));

        MainAdapters adapters = new MainAdapters(list,this);
        binding.recylerview.setAdapter(adapters);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);

    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}