package com.win.fragmentslip;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.win.fragmentslip.fragment.FiveFragment;
import com.win.fragmentslip.fragment.FourFragment;
import com.win.fragmentslip.fragment.OneFragment;
import com.win.fragmentslip.fragment.ThreeFragment;
import com.win.fragmentslip.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;
//需要继承 FragmentActivity 实现 ViewPager.OnPageChangeListener 接口
public class MainActivity extends FragmentActivity  implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private ViewPager viewPager; //碎片布局容器
    private RadioButton mHomeRb, mSleepRb, mStatisticsRb,mFindRb, mMySelfRb; //碎片的五个按钮
    private RadioButton[] rbs;
    //碎片布局
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;

    //用来存放 Fragment
    private List<Fragment> listFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
    }

    public void init(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mHomeRb = (RadioButton) findViewById(R.id.home_rb);
        mSleepRb = (RadioButton) findViewById(R.id.sleep_rb);
        mStatisticsRb = (RadioButton) findViewById(R.id.Statistics_rb);
        mFindRb = (RadioButton) findViewById(R.id.find_rb);
        mMySelfRb = (RadioButton) findViewById(R.id.myself_rb);
        mHomeRb.setOnClickListener(this);
        mSleepRb.setOnClickListener(this);
        mStatisticsRb.setOnClickListener(this);
        mFindRb.setOnClickListener(this);
        mMySelfRb.setOnClickListener(this);
        mHomeRb.setChecked(true);  //设置默认显示的界面为 mHomeRb
        viewPager.setOnPageChangeListener(this);

        //设置导航图片的大小
        rbs = new RadioButton[5];
        rbs[0] = mHomeRb;
        rbs[1] = mSleepRb;
        rbs[2] = mStatisticsRb;
        rbs[3] = mFindRb;
        rbs[4] = mMySelfRb;
        for (RadioButton rb : rbs) {
            Drawable[] drs = rb.getCompoundDrawables();
            Rect r = new Rect(0, 0, drs[1].getMinimumWidth() * 2 / 3 - 5, drs[1].getMinimumHeight() * 2 / 3 - 5);
            drs[1].setBounds(r);
            rb.setCompoundDrawables(null, drs[1], null, null);
        }
    }

    //将五个 Fragment 布局放在 listFragment 中，通过 adapter 放入碎片容器 viewPager 中
    public void initData(){
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();
        fiveFragment = new FiveFragment();
        listFragment.add(oneFragment);
        listFragment.add(twoFragment);
        listFragment.add(threeFragment);
        listFragment.add(fourFragment);
        listFragment.add(fiveFragment);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager() , listFragment));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //监听到页面更改后，更改布局页面
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mHomeRb.setChecked(true);
                break;
            case 1:
                mSleepRb.setChecked(true);
                break;
            case 2:
                mStatisticsRb.setChecked(true);
                break;
            case 3:
                mFindRb.setChecked(true);
                break;
            case 4:
                mMySelfRb.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //点击导航栏设置当前布局 （将布局更改为点击的。。）
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_rb:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.sleep_rb:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.Statistics_rb:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.find_rb:
                viewPager.setCurrentItem(3,false);
                break;
            case R.id.myself_rb:
                viewPager.setCurrentItem(4,false);
                break;
        }
    }
}
