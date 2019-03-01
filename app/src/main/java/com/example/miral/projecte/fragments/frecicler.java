package com.example.miral.projecte.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.miral.projecte.MainActivity;
import com.example.miral.projecte.R;
import com.example.miral.projecte.WordListAdapter;
import com.example.miral.projecte.ventanasVideos.vABinterval;
import com.example.miral.projecte.ventanasVideos.vCardio;
import com.example.miral.projecte.ventanasVideos.vDouble;
import com.example.miral.projecte.ventanasVideos.vLowerFocus;
import com.example.miral.projecte.ventanasVideos.vSpeed;
import com.example.miral.projecte.ventanasVideos.vTBC;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frecicler extends Fragment implements WordListAdapter.ItemClickListener {

    private final LinkedList<String> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

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
            case 0:
                Intent intCardio = new Intent(getActivity().getApplicationContext(), vCardio.class);
                startActivity(intCardio);
                break;
            case 1:
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(getActivity());
                myAlertBuilder.setTitle("Elije");
                myAlertBuilder.setMessage("Prefieres ver el video en youtube o en tu aplicacion?");
                myAlertBuilder.setPositiveButton("youtube",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent mediaIntent = new Intent(Intent.ACTION_VIEW);
                                mediaIntent.setData(Uri.parse(
                                        "https://www.youtube.com/watch?v=X4MOI5Q0NlU"));
                                if (mediaIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                                    startActivity(mediaIntent);
                                }
                            }
                        });

                myAlertBuilder.setNegativeButton("aplicacion",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intSpeed = new Intent(getActivity().getApplicationContext(), vSpeed.class);
                                startActivity(intSpeed);
                            }
                        });
                myAlertBuilder.show();
                break;
            case 2:
                Intent intTBC = new Intent(getActivity().getApplicationContext(), vTBC.class);
                startActivity(intTBC);
                break;
            case 3:
                Intent intABint = new Intent(getActivity().getApplicationContext(), vABinterval.class);
                startActivity(intABint);
                break;
            case 4:
                Intent intLowFoc = new Intent(getActivity().getApplicationContext(), vLowerFocus.class);
                startActivity(intLowFoc);
                break;
            case 5:
                Intent intDouble = new Intent(getActivity().getApplicationContext(), vDouble.class);
                startActivity(intDouble);
                break;
        }
    }
}
