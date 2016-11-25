package com.sw.rssnews.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sw.rssnews.R;
import com.sw.rssnews.ReadABC;

public class Fragment1 extends Fragment {
    RecyclerView recyclerView;
    final static public String address="http://feeds.abcnews.com/abcnews/usheadlines";

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        ReadABC readABC = new ReadABC(this.getContext(),recyclerView);
        readABC.address = address;
        readABC.execute();
        return rootView;
    }


}