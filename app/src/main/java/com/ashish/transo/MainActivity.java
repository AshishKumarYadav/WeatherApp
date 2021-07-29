package com.ashish.transo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.ashish.transo.Fragments.TodayFragment;
import com.ashish.transo.Fragments.TomorrowFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    String TAG=MainActivity.class.getSimpleName();

    private TabLayout tab;
    private ViewPager viewPager;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager =  findViewById(R.id.viewPager);
        tab = findViewById(R.id.tabLayout);
        frameLayout=findViewById(R.id.frame_layout);

        tab.addTab(tab.newTab().setText("Today"));
        tab.addTab(tab.newTab().setText("Next 4 Days"));


        fragment = new TodayFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

         tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {


                 switch (tab.getPosition()) {
                     case 0:
                         fragment = new TodayFragment();
                         break;
                     case 1:
                         fragment = new TomorrowFragment();
                         break;
                 }

                 FragmentManager fm = getSupportFragmentManager();
                 FragmentTransaction ft = fm.beginTransaction();
                 ft.replace(R.id.frame_layout, fragment);
                 ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                 ft.commit();
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });


    }
}