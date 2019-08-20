package com.example.easymed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


/**
 * The type Main activity.
 * Main activity is all about search medicine and list of avilable medicines
 *
 */
public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pageAdapter;
    private TabItem tabStore;
    private TabItem tabBrand;
    private TabItem tabSuggestion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tabLayout);
        tabStore = findViewById(R.id.tab_store);
        tabBrand = findViewById(R.id.tab_brand);
        tabSuggestion = findViewById(R.id.tab_suggestion);
        viewPager = findViewById(R.id.viewpager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                Fragment selectedFragment = null;
                if(tab.getPosition() == 1){

                    selectedFragment = new FragmentStore();

                }
                if(tab.getPosition() == 2){

                    selectedFragment = new FragmentBrand();

                }
                if(tab.getPosition() == 3){

                    selectedFragment = new FragmentSuggestion();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));








    }
}
