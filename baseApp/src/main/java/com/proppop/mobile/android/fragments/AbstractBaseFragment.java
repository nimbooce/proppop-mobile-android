package com.proppop.mobile.android.fragments;

import android.app.Fragment;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by animal@martus.org on 9/2/16.
 */

abstract public class AbstractBaseFragment extends Fragment {

    protected DatabaseReference mDatabase;

    abstract public int getFragmentTitleResourceId();
}

