package com.example.miral.projecte;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(TextView tv){
            super(tv);
            mTextView = tv;
        }
    }

    public MyAdapter(String[] myDataSet){
        mDataSet = myDataSet;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rvi_lista_ejers,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount(){
        return mDataSet.length;
    }

}
