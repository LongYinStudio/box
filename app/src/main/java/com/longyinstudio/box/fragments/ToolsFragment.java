package com.longyinstudio.box.fragments;

import static com.longyinstudio.box.utils.Util.goActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.longyinstudio.box.R;
import com.longyinstudio.box.tools.QQTemporarySession;
import com.longyinstudio.box.tools.TextToVoice;

public class ToolsFragment extends Fragment {

    public static Fragment newInstance() {
        ToolsFragment fragment = new ToolsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tools, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] titles = {"QQ临时会话","文字转语音","t3","t4","t5","敬请期待"};
        String[] descriptions = {"不加好友也可以发消息","文字转语音","d3","d4","d5","....."};
        int[] images = {R.drawable.qq_temporary_session,R.drawable.text_to_speech,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.stay_tuned};
        GridView gridView = getActivity().findViewById(R.id.gridView);
        MyAdapter adapter = new MyAdapter(getActivity(),titles,descriptions,images);
        gridView.setAdapter(adapter);

    }
}

class MyAdapter extends ArrayAdapter {
    int[] imageArray;
    String[] titleArray;
    String[] descArray;
    public MyAdapter(Context context, String[] titles1, String[] descriptions1, int[] img1){
        super(context, R.layout.tools_item,R.id.idTitle,titles1);
        this.imageArray = img1;
        this.titleArray = titles1;
        this.descArray = descriptions1;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.tools_item,parent,false);
        ImageView myImage = row.findViewById(R.id.idPic);
        TextView myTitle = row.findViewById(R.id.idTitle);
        TextView myDescription = row.findViewById(R.id.idDescription);
        myImage.setImageResource(imageArray[position]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descArray[position]);
        CardView cardView = row.findViewById(R.id.idCard);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        goActivity((Activity) getContext(), QQTemporarySession.class);
                        break;
                    case 1:
                        goActivity((Activity) getContext(), TextToVoice.class);
                        break;
                    case 2:
                        Toast.makeText(getContext(),"",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(),"4",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(),"5",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(),"敬请期待",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        return row;
    }
}