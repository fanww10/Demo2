package com.iflytek.demo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyFragment extends Fragment {

    private ArrayList<ImageItem> imageData;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mMyRecyclerViewAdapter;
    private View mView;

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        mView = inflater.inflate(R.layout.activity_fragment,container,false);

        initView();
        initData();
        return mView;
    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL, false));

    }

    private void initData(){
        imageData = new ArrayList<>();
        mMyRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), imageData);
        mRecyclerView.setAdapter(mMyRecyclerViewAdapter);
        for (int i = 0; i < 20; i++) {
            ImageItem imageItem = new ImageItem();
            imageItem.setImageName("heshan");
            imageData.add(imageItem);
        }
        mMyRecyclerViewAdapter.notifyDataSetChanged();
    }

}
