package com.example.miral.projecte;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.LinkedList;

public class rvi_lista_ejers extends AppCompatActivity {

        private final LinkedList<String> mWordList = new LinkedList<>();

        private RecyclerView mRecyclerView;
        private WordListAdapter mAdapter;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rvi_lista_ejers);

            mWordList.addLast("Cardio");
            mWordList.addLast("Speed");
            mWordList.addLast("Total body circuit");
            mWordList.addLast("AB interval");
            mWordList.addLast("Lower focus");
            mWordList.addLast("Double");

            mRecyclerView = findViewById(R.id.recyclerview);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(rvi_lista_ejers.this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);


            mAdapter = new WordListAdapter(this,mWordList);
            mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
            int id = item.getItemId();
            if(id==R.id.action_settings){
                return true;
            }
            return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            return true;
    }
/*
    public void onItemClick(View view,int position){
        switch(position){
            case A1:
                Intent listSong = new Intent(this,calendario.class);
                startActivity(listSong);
                break;
        }

        Intent listSong = new Intent(this,navegacion.class);
        startActivity(listSong);
    }*/
}
