package com.example.miral.projecte;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frecicler extends Fragment {

    private final LinkedList<String> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    public frecicler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_frecicler, container, false);
        mWordList.addLast("Cardio");
        mWordList.addLast("Speed");
        mWordList.addLast("Total body circuit");
        mWordList.addLast("AB interval");
        mWordList.addLast("Lower focus");
        mWordList.addLast("Double");

        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);


        mAdapter = new WordListAdapter(getActivity().getApplicationContext(),mWordList);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

}
