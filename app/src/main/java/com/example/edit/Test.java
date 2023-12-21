package com.example.edit;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.*;

public class Test extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = findViewById(R.id.appBar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ViewPager viewPager = findViewById(R.id.viewpager);

        // Khai báo Adapter
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        // Set Adapter cho ViewPager
        viewPager.setAdapter(pagerAdapter);

        // Set TabLayout kết nối với ViewPager
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.learn_icon).setText("vocabulary");
        tabLayout.getTabAt(1).setIcon(R.drawable.aorb).setText("Game1");
        tabLayout.getTabAt(2).setIcon(R.drawable.quiz).setText("Game2");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
         if (id == R.id.nav_home) {
             Toast.makeText(Test.this, "Menu Item 1 clicked", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(Test.this, Profile.class);
             startActivity(intent);

         }else if (id == R.id.nav_time){
             Toast.makeText(Test.this, "Menu Item 2 clicked", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(Test.this, DashboardActivity.class);
             startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}