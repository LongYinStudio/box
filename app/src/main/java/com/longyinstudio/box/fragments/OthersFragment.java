package com.longyinstudio.box.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.longyinstudio.box.R;

import static com.longyinstudio.box.utils.Util.openWeb;

public class OthersFragment extends Fragment {

    public static Fragment newInstance() {
        return new OthersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_others, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button web_tools_online_PS = getActivity().findViewById(R.id.web_tools_online_PS);
        Button web_tools_tencent_computer_software = getActivity().findViewById(R.id.web_tools_tencent_computer_software);
        web_tools_online_PS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb(getActivity(),"https://www.photopea.com/");
            }
        });
        web_tools_tencent_computer_software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb(getActivity(),"https://pc.qq.com/");
            }
        });
    }
}