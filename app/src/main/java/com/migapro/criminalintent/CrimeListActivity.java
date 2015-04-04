package com.migapro.criminalintent;

import android.app.Fragment;

/**
 * Created by Miga on 12/26/2014.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
