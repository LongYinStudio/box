package com.longyinstudio.box;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.longyinstudio.box.adapter.MyPagerAdapter;
import com.longyinstudio.box.entity.TabEntity;
import com.longyinstudio.box.fragments.HomeFragment;
import com.longyinstudio.box.fragments.MineFragment;
import com.longyinstudio.box.fragments.OthersFragment;
import com.longyinstudio.box.fragments.ToolsFragment;

import java.util.ArrayList;

/*
 *
 * 工程从2020年11月18日开始写
 * Developer：龙吟工作室(敬培全)
 * QQ：1606776851
 * QQ群：811138141
 *
 * */

public class MainActivity extends BaseActivity {

    private String[] mTitles = {"首页", "工具", "其他", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_tools_unselect,
            R.mipmap.tab_speech_unselect, R.mipmap.tab_mine_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_tools_select,
            R.mipmap.tab_speech_select, R.mipmap.tab_mine_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        //int theme = pref.getInt("app_theme",0);
        //setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ToolsFragment.newInstance());
        mFragments.add(OthersFragment.newInstance());
        mFragments.add(MineFragment.newInstance());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));

    }

    /*@Override
    public void setTheme(@Nullable Resources.Theme theme) {
        super.setTheme(theme);
    }*/
}