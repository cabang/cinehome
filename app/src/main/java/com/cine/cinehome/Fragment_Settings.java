package com.cine.cinehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_Settings extends Fragment {
    TextView tv_tittle;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        tv_tittle = (TextView) v.findViewById(R.id.tv_title);
        return v;
    }
}
