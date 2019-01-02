package com.example.zhao.geeknewss.fragments.collecting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhao.geeknewss.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectingFragment extends Fragment {


    public CollectingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collecting, container, false);
    }

}
