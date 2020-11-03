package com.example.viewdemo.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewdemo.views.DrawColorView;
import com.example.viewdemo.views.DrawViewPractice0;

public class Fragment_0 extends Fragment {
  private View view;

    public Fragment_0(View view) {
        this.view = view;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        DrawColorView view=new DrawColorView(this.getContext());
//        DrawViewPractice0 drawViewPractice0= (DrawViewPractice0) view;
//        drawViewPractice0.setListener(new DrawViewPractice0.OnItemSelectListener() {
//            @Override
//            public void onItemSelect(int index) {
//                Log.e("log-->>","index = "+index);
//            }
//        });
        return view;//super.onCreateView(inflater, container, savedInstanceState);





    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
