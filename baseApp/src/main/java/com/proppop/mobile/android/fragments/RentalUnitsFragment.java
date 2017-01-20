package com.proppop.mobile.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.proppop.mobile.android.R;

/**
 * Created by animal@martus.org on 9/2/16.
 */

public class RentalUnitsFragment extends AbstractBaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_layout_rental_units, container, false);

        return rootView;
    }

    @Override
    public int getFragmentTitleResourceId() {
        return R.string.fragment_title_rental_units;
    }
}
