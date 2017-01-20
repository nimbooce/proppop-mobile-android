package com.proppop.mobile.android.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proppop.mobile.android.R;

/**
 * Created by animal@martus.org on 9/23/16.
 */

public class PayRentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("----------------------------------------BOOM pay rent framgnent onCreateView");

        return inflater.inflate(R.layout.fragment_pay_rent, container, false);
    }
}
