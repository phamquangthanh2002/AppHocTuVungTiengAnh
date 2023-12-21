package com.example.edit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

// ...

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VocabularyFragment();
            case 1:
                return new Game1Fragment();
            case 2:
                return new Game2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // Số lượng Fragment
    }
}
