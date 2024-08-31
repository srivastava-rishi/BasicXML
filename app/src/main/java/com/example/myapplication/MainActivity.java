package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.fragmemt.MatchFragment;
import com.example.myapplication.fragmemt.RoomFagment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    // Final BottomNavigationBar
    final Fragment fragment1 = new RoomFagment();
    final Fragment fragment2 = new MatchFragment();

    Fragment active = fragment1;

    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        fragmentManager.beginTransaction().add(R.id.changeable_view, fragment2, "2").hide(fragment2).commit();
        fragmentManager.beginTransaction().add(R.id.changeable_view, fragment1, "1").commit();

        bottomNavigation();

    }


    private void bottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.rooms:
                        if (active == fragment2) {
                            fragmentManager.beginTransaction().hide(active).show(fragment1).commit();
                        }
                        active = fragment1;
                        return true;

                    case R.id.match:
                        if (active == fragment1) {
                            fragmentManager.beginTransaction().hide(active).show(fragment2).commit();
                        }
                        active = fragment2;
                        return true;
                }
                return false;
            }
        });

    }
}