package com.wellhome.cloudgroup.wechattest;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ViewPager mviewPager;

    //适配器
    private PagerAdapter mAdapter;
    private List<View> mViewlist = new ArrayList<>();


    private LinearLayout mTabWeixin;
    private LinearLayout mTabadr;
    private LinearLayout mTabonekey;
    private LinearLayout mTabfrd;
    private LinearLayout mTabmine;


    private ImageButton mWeixinimg;
    private ImageButton mfrdimg;
    private ImageButton madrimg;
    private ImageButton mmineimg;
    private ImageButton monekeyimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initview();

        initEvent();
    }

    private void initEvent() {
        mTabmine.setOnClickListener(this);
        mTabWeixin.setOnClickListener(this);
        mTabfrd.setOnClickListener(this);
        mTabadr.setOnClickListener(this);
        mTabonekey.setOnClickListener(this);
    }

    private void initview() {

        mviewPager = findViewById(R.id.id_viewpager);
        //tab
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabadr = (LinearLayout) findViewById(R.id.id_tab_adr);
        mTabonekey = (LinearLayout) findViewById(R.id.id_tab_onekey);
        mTabfrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabmine = (LinearLayout) findViewById(R.id.id_tab_mine);
        //imagebutton
        mWeixinimg = (ImageButton) findViewById(R.id.id_tab_winxinimg);
        madrimg = (ImageButton) findViewById(R.id.id_tab_adrmg);
        monekeyimg = (ImageButton) findViewById(R.id.id_tab_onekeyimg);
        mfrdimg = (ImageButton) findViewById(R.id.id_tab_frdimg);
        mmineimg = (ImageButton) findViewById(R.id.id_tab_mineimg);


        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab01, null);
        View tab02 = mInflater.inflate(R.layout.tab02, null);
        View tab03 = mInflater.inflate(R.layout.tab03, null);
        View tab04 = mInflater.inflate(R.layout.tab04, null);
        View tab05 = mInflater.inflate(R.layout.tab05, null);

        mViewlist.add(tab01);
        mViewlist.add(tab02);
        mViewlist.add(tab03);
        mViewlist.add(tab04);
        mViewlist.add(tab05);


        mAdapter = new PagerAdapter() {

            //还需要重写两个方法

            @Override
            public int getCount() {
                return mViewlist.size();
            }

            //初始化方法
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViewlist.get(position);

                container.addView(view);
                return view;
            }

            //摧毁方法
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                View view = mViewlist.get(position);
                container.removeView(view);

            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };


        mviewPager.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
     //0.1.2.3.4出现两次，优化的时候可以设置为常量
        resetIimg();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                mviewPager.setCurrentItem(0);
                mWeixinimg.setImageResource(R.drawable.icon_main_home_selected);
                break;
            case R.id.id_tab_adr:
                mviewPager.setCurrentItem(1);
                madrimg.setImageResource(R.drawable.icon_main_category_selected);
                break;
            case R.id.id_tab_onekey:
                mviewPager.setCurrentItem(2);
                monekeyimg.setImageResource(R.drawable.icon_main_home_selected);
                break;
            case R.id.id_tab_frd:
                mviewPager.setCurrentItem(3);
                mfrdimg.setImageResource(R.drawable.icon_main_service_selected);
                break;
            case R.id.id_tab_mine:
                mviewPager.setCurrentItem(4);
                mmineimg.setImageResource(R.drawable.icon_main_mine_selected);
                break;
            default:
                break;

        }

    }

    /**
     * //更换暗色图片
     */
    private void resetIimg() {
        mWeixinimg.setImageResource(R.drawable.icon_main_home_normal);
        madrimg.setImageResource(R.drawable.icon_main_category_normal);
        monekeyimg.setImageResource(R.drawable.icon_main_home_normal);
        mfrdimg.setImageResource(R.drawable.icon_main_service_normal);
        mmineimg.setImageResource(R.drawable.icon_main_mine_normal);

        //滑动事件的监听事件
        mviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mviewPager.getCurrentItem();
                //先重新reset
                resetIimg();

                switch (currentItem) {
                    case 0:
                        mWeixinimg.setImageResource(R.drawable.icon_main_home_selected);
                        break;
                    case 1:
                        madrimg.setImageResource(R.drawable.icon_main_category_selected);
                        break;
                    case 2:
                        monekeyimg.setImageResource(R.drawable.icon_main_home_selected);
                        break;
                    case 3:
                        mfrdimg.setImageResource(R.drawable.icon_main_service_selected);
                        break;
                    case 4:
                        mmineimg.setImageResource(R.drawable.icon_main_mine_selected);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
