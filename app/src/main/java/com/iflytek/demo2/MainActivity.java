package com.iflytek.demo2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<String> title;
    private List<Fragment> mFragmentList;
    private FragmentManager mFragmentManager;

    private MyFragmentAdapter mMyAdapter;
    MyFragment mFirstFragment;
    MyFragment mSecondFragment;
    MyFragment mThirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {

        title = new ArrayList<>();
        title.add("标签一");
        title.add("标签二");
        title.add("标签三");
        mTabLayout = findViewById(R.id.tab);
        mViewPager = findViewById(R.id.view_page);

        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(0)),true);
        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(1)),false);
        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(2)),false);

        mFragmentList = new ArrayList<>();
        mFirstFragment = new MyFragment();
        mSecondFragment = new MyFragment();
        mThirdFragment = new MyFragment();

        mFragmentList.add(mFirstFragment);
        mFragmentList.add(mSecondFragment);
        mFragmentList.add(mThirdFragment);

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        mFragmentManager = getSupportFragmentManager();
        mMyAdapter = new MyFragmentAdapter(mFragmentManager,0, title, mFragmentList);

        mViewPager.setAdapter(mMyAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

    }
}