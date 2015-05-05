package com.migapro.criminalintent.ui;

import android.app.Fragment;

import com.migapro.criminalintent.R;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        // Using alias defined in refs.xml in order to keep both phone & tablet layouts in one directory
        return R.layout.activity_masterdetail;
    }
}
