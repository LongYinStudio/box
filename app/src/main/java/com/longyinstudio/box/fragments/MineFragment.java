package com.longyinstudio.box.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.longyinstudio.box.R;
import com.longyinstudio.box.utils.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

//API：https://www.yunboys.cn/qqxt/api.php?qq=1606776851    返回值：{"code":1,"imgurl":"https://q.qlogo.cn/headimg_dl?dst_uin=1606776851&spec=100","name":"北栀向阳(敬培全)"}


public class MineFragment extends Fragment {

    //private AppCompatActivity activity;

    public MineFragment() {
    }

    public static Fragment newInstance() {
        return new MineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        //return inflater.inflate(R.layout.fragment_mine, container, false);
        @SuppressLint("UseSwitchCompatOrMaterialCode") final Switch switch_nightMode = view.findViewById(R.id.switch_nightMode);
        switch_nightMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(switch_nightMode.isChecked()){
                Toast.makeText(getActivity(),"开",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getActivity(),"关",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //final MainActivity activity = (MainActivity) getActivity();
        LinearLayout app_exit = Objects.requireNonNull(getActivity()).findViewById(R.id.app_exit);
        app_exit.setOnClickListener(v -> {
            //activity.finish();
        });
        /*final Switch switch_nightMode = getActivity().findViewById(R.id.switch_nightMode);
        switch_nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switch_nightMode.isChecked()){
                    Toast.makeText(getActivity(),"开",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(),"关",Toast.LENGTH_SHORT).show();
                }
                SharedPreferences.Editor editor = getSaredPreferrnces("data",MODE_PRIVATE).edit();
                //添加键值
                editor.putBoolean("NightMode", switch_nightMode.isChecked());
                //apply方法 提交
                editor.apply();

                activity.recreate();
            }
        });*/

        final TextView myname = getActivity().findViewById(R.id.mine_tv_nickname);
        final ImageView avatar = getActivity().findViewById(R.id.mine_avatar);
        LinearLayout sweepButton = getActivity().findViewById(R.id.toLogin);
        sweepButton.setOnClickListener(v -> {
            //startActivity(new Intent(getActivity(), LoginActivity.class));
        });

        new Thread(() -> {
            try {
                String qqAPI_url = "https://www.yunboys.cn/qqxt/api.php?qq=1606776851";
                String jsonData = Util.loadHtml(qqAPI_url);
                JSONObject jsonObject = new JSONObject(jsonData);
                final String code = jsonObject.getString("code");
                final String success = "1";
                final String name = jsonObject.getString("name");
                final String imgurl = jsonObject.getString("imgurl");
                getActivity().runOnUiThread(() -> {
                    if (code.equals(success)) {
                        myname.setText(name);
                        Glide.with(getActivity()).load(imgurl).into(avatar);
                    }else {
                        myname.setText("昵称");
                        avatar.setImageResource(R.drawable.avatar);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }).start();
    }
}