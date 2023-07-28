package com.example.sananismayilov.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.sananismayilov.tablayout.Fragments.FirstFragment;
import com.example.sananismayilov.tablayout.Fragments.SecondFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> fragmentArrayListTitle = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getTabLayout();
    }

    public void getTabLayout(){
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.vpager);

        fragmentArrayList.add(FirstFragment.newInstance());
        fragmentArrayList.add(SecondFragment.newInstance());

        fragmentArrayListTitle.add("First");
        fragmentArrayListTitle.add("Second");



        PagerAdapter pagerAdapter = new PagerAdapter(this,fragmentArrayList);

        viewPager2.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragmentArrayListTitle.get(position));

            }
        }).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.one);
        tabLayout.getTabAt(1).setIcon(R.drawable.two);
    }
}