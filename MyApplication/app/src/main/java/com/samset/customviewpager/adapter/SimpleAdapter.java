package com.samset.customviewpager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samset.customviewpager.R;

/**
 * Created by karamjeetsingh on 13/01/16.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyHolder> {

    private final int numItems;

    public SimpleAdapter(int numItems) {
        this.numItems = numItems;
    }

    @Override public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card, viewGroup, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder fakePageVH, int i) {
        // do nothing
    }

    @Override public int getItemCount() {
        return numItems;
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }

}
