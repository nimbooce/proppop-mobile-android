package com.proppop.mobile.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proppop.mobile.android.R;

/**
 * Created by animal@martus.org on 9/2/16.
 */

public class TenantsFragment extends AbstractBaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_layout_tenants, container, false);

        System.out.println("--------------TENANTS fragment");
        return rootView;
    }

    @Override
    public int getFragmentTitleResourceId() {
        return R.string.fragment_title_tenants;
    }
}
