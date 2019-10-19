package com.cine.cinehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_Home extends Fragment {
    TextView tv_tittle;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        tv_tittle = (TextView) v.findViewById(R.id.tv_title);
        tv_tittle.setText("SOY UN FRAGMENTADO");
        tv_tittle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Activity_Splash.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return v;
    }
}
