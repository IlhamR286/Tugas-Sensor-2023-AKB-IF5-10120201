//10120201 - Ilham Ramdhan Putra Lesmana - IF5 - AKB 2023
package com.belajarkuy.tugas_akb_sensor_10120201_if5;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.belajarkuy.adapter.AdapterViewPager;
import com.belajarkuy.fragment.FragmentInfo;
import com.belajarkuy.fragment.FragmentLokasiSaya;
import com.belajarkuy.fragment.FragmentProfile;
import com.belajarkuy.fragment.FragmentSekitar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNav);

        fragmentArrayList.add(new FragmentProfile());
        fragmentArrayList.add(new FragmentSekitar());
        fragmentArrayList.add(new FragmentLokasiSaya());
        fragmentArrayList.add(new FragmentInfo());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        //Set Adapter
        pagerMain.setAdapter(adapterViewPager);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNav.setSelectedItemId(R.id.profile);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.sekitar);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.lokasiSaya);
                        break;
                    case 3:
                        bottomNav.setSelectedItemId(R.id.informasi);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.profile){
                    pagerMain.setCurrentItem(0);
                } else if (item.getItemId() == R.id.sekitar){
                    pagerMain.setCurrentItem(1);
                } else if (item.getItemId() == R.id.lokasiSaya){
                    pagerMain.setCurrentItem(2);
                } else if (item.getItemId() == R.id.informasi){
                    pagerMain.setCurrentItem(3);
                }
                return true;
            }
        });
    }
}