package com.example.miral.projecte.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.miral.projecte.R;
import com.example.miral.projecte.WordListAdapter;
import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class idioma extends Fragment implements WordListAdapter.ItemClickListener {

    private final LinkedList<String> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_idioma, container, false);
        mWordList.addLast("Castellano");
        mWordList.addLast("Catalan");
        mWordList.addLast("Ingles");

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
            case 0:
                Toast.makeText(getActivity().getApplicationContext(), "Traduciendo al castellano", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getActivity().getApplicationContext(), "Traduciendo al catalan", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getActivity().getApplicationContext(), "Traduciendo al ingles", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
