package com.application.padc.retrofiteventbus.view.holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.application.padc.retrofiteventbus.R;
import com.application.padc.retrofiteventbus.vo.RestaurantVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wm02 on 6/23/2017.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    private static final String LOG_TAG = RestaurantViewHolder.class.getName();

    @BindView(R.id.rbRating)
    RatingBar rbRating;

    @BindView(R.id.tvrating)
    TextView tvrating;

    @BindView(R.id.tvname)
    TextView tvname;

    @BindView(R.id.tvloc)
    TextView tvloc;

    @BindView(R.id.tvdeliverytime)
    TextView tvdeliverytime;

    public RestaurantViewHolder(View itemView) {
        super(itemView);
        Log.i(LOG_TAG, "TEST: RestaurantViewHolder() called...");

        ButterKnife.bind(this,itemView);
    }

    public void bind(RestaurantVO data)
    {
        Log.i(LOG_TAG, "TEST: bind() called...");

        rbRating.setRating((float) data.getAverageratingvalue());
        tvrating.setText("("+data.getTotalratingcount()+")");
        if(data.getAddrshort()!=null)
        tvname.setText(data.getTitle()+"("+data.getAddrshort()+")");
        else
            tvname.setText(data.getTitle());
        StringBuilder string = new StringBuilder();
        for(int i=0;i<data.getTags().length;i++)
        {
            string.append(data.getTags()[i]+" ");
        }
        tvloc.setText(string);
        tvdeliverytime.setText("delivers in "+data.getLeadtimeinmin()+" mins.");
    }
}
