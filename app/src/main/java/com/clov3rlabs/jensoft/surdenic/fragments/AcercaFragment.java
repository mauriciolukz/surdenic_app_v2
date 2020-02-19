package com.clov3rlabs.jensoft.surdenic.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcercaFragment extends Fragment {


    public AcercaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_acerca));
        return inflater.inflate(R.layout.fragment_acerca, container, false);
    }

}
