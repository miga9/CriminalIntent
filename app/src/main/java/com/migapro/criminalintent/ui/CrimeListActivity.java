package com.migapro.criminalintent.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import com.migapro.criminalintent.R;
import com.migapro.criminalintent.model.Crime;

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        // Using alias defined in refs.xml in order to keep both phone & tablet layouts in one directory
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detailFragmentContainer) == null) {
            // Start an instance of CrimePagerActivity
            Intent intent = new Intent(this, CrimePagerActivity.class);
            intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
            startActivity(intent);
        } else {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            Fragment oldDetailFragment = fm.findFragmentById(R.id.detailFragmentContainer);
            Fragment newDetailFragment = CrimeFragment.newInstance(crime.getId());

            if (oldDetailFragment != null) {
                ft.remove(oldDetailFragment);
            }

            ft.add(R.id.detailFragmentContainer, newDetailFragment);
            ft.commit();
        }
    }
}
