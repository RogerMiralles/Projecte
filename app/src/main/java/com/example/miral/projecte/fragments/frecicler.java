package com.example.miral.projecte.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miral.projecte.MainActivity;
import com.example.miral.projecte.R;
import com.example.miral.projecte.WordListAdapter;
import com.example.miral.projecte.ventanasVideos.vCardio;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frecicler extends Fragment implements WordListAdapter.ItemClickListener {

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
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }
    public void onItemClick(View view,int position){
        switch(position){
            case 1:
                Intent intCardio = new Intent(getActivity().getApplicationContext(), vCardio.class);
                startActivity(intCardio);
                break;
            case 2:
                Intent intSpeed = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intSpeed);
                break;
            case 3:
                Intent intTBC = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intTBC);
                break;
            case 4:
                Intent intABint = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intABint);
                break;
            case 5:
                Intent intLowFoc = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intLowFoc);
                break;
            case 6:
                Intent intDouble = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intDouble);
                break;
        }
    }
}
