package com.macmanus.jamie.bikerentalapp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macmanus.jamie.bikerentalapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewBikesFragment extends Fragment {


    public ViewBikesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_bikes, container, false);
    }

}
