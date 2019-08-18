package com.example.easymed;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentStore();

            case 1:
                return new FragmentBrand();

            case 2:
                return new FragmentSuggestion();

            default:
                return new FragmentStore();
        }

    }


    @Override
    public int getCount() {
        return numOfTabs;
    }

}
