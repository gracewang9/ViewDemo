package com.example.viewdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.viewdemo.fragments.Fragment_0;
import com.example.viewdemo.views.DrawArcView;
import com.example.viewdemo.views.DrawArcView2;
import com.example.viewdemo.views.DrawArctToView;
import com.example.viewdemo.views.DrawBitmapView;
import com.example.viewdemo.views.DrawCircleView;
import com.example.viewdemo.views.DrawColorView;
import com.example.viewdemo.views.DrawLinesView;
import com.example.viewdemo.views.DrawOvalView;
import com.example.viewdemo.views.DrawPathLinerView;
import com.example.viewdemo.views.DrawPathView;
import com.example.viewdemo.views.DrawPointView;
import com.example.viewdemo.views.DrawRectView;
import com.example.viewdemo.views.DrawViewPractice1;
import com.example.viewdemo.views.DrawViewPractice2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tableTitle;
    private ViewPager viewPager;
    private List<String> listTitle;
    private List<Fragment> listFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableTitle=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.viewpager);
        setTitleData();
        init();
    }
    private void init(){
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),0);
        viewPager.setAdapter(adapter);
        tableTitle.setupWithViewPager(viewPager);
    }

    private void setTitleData(){
        listTitle=new ArrayList<>();
        listTitle.add("练习1");
        listTitle.add("练习2");
        listTitle.add("drawColor");
        listTitle.add("drawCircle");
        listTitle.add("drawBitmap");
        listTitle.add("饼图");
        listTitle.add("矩形");
        listTitle.add("绘制点");
        listTitle.add("绘制椭圆");
        listTitle.add("绘制线");
        listTitle.add("绘制扇形");
        listTitle.add("DrawPath");
        listTitle.add("DrawPathLiner");
        listTitle.add("DrawPathArctTo");


//



        listFragment=new ArrayList<>();
        listFragment.add(new Fragment_0(new DrawViewPractice1(this)));
        listFragment.add(new Fragment_0(new DrawViewPractice2(this)));
        listFragment.add(new Fragment_0(new DrawColorView(this)));
        listFragment.add(new Fragment_0(new DrawCircleView(this)));
        listFragment.add(new Fragment_0(new DrawBitmapView(this)));
        listFragment.add(new Fragment_0(new DrawArcView(this)));
        listFragment.add(new Fragment_0(new DrawRectView(this)));
        listFragment.add(new Fragment_0(new DrawPointView(this)));
        listFragment.add(new Fragment_0(new DrawOvalView(this)));
        listFragment.add(new Fragment_0(new DrawLinesView(this)));
        listFragment.add(new Fragment_0(new DrawArcView2(this)));
        listFragment.add(new Fragment_0(new DrawPathView(this)));
        listFragment.add(new Fragment_0(new DrawPathLinerView(this)));
        listFragment.add(new Fragment_0(new DrawArctToView(this)));

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return listTitle.get(position);
        }
    }
}