package com.longyinstudio.box.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.longyinstudio.box.R;
import com.longyinstudio.box.utils.Util;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView iv = getActivity().findViewById(R.id.iv);
        Glide.with(getActivity()).load("https://api.dongmanxingkong.com/suijitupian/acg/1080p/index.php").into(iv);
        final TextView tv = getActivity().findViewById(R.id.tv);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String sayurl = "http://api.btstu.cn/yan/api.php?charset=utf-8&encode=json";
                    String saydata = Util.loadHtml(sayurl);
                    JSONObject jsonObject = new JSONObject(saydata);
                    final String says = jsonObject.getString("text");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(says);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        final ImageView iv_refresh = getActivity().findViewById(R.id.iv_refresh);
        iv_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate_clockwise);
                iv_refresh.startAnimation(animation);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String sayurl = "http://api.btstu.cn/yan/api.php?charset=utf-8&encode=json";
                            String saydata = Util.loadHtml(sayurl);
                            JSONObject jsonObject = new JSONObject(saydata);
                            final String says = jsonObject.getString("text");
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(says);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }
}