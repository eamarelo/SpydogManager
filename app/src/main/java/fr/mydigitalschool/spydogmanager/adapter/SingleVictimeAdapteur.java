package fr.mydigitalschool.spydogmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;

import fr.mydigitalschool.spydogmanager.R;
import fr.mydigitalschool.spydogmanager.activity.SingleVictimeActivity;
import fr.mydigitalschool.spydogmanager.model.Position;
import fr.mydigitalschool.spydogmanager.viewholder.SingleVictimeHolder;

/**
 * Created by jp789 on 01/04/2018.
 */

public class SingleVictimeAdapteur extends RecyclerView.Adapter<SingleVictimeHolder> {
    private ArrayList<Position> positions;
    private Context context;
    private View.OnClickListener onClickListener;


    public SingleVictimeAdapteur(ArrayList<Position> positions, Context context){
        this.positions = positions;
        this.context = context;
    }


    public SingleVictimeHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final SingleVictimeHolder toto =  new SingleVictimeHolder( LayoutInflater.from(parent.getContext()).inflate( R.layout.item_position,parent,false));
        Log.d( "onCreateViewHolder: ", toto.itemView.toString() );


        return toto;
    }

    public void onBindViewHolder(SingleVictimeHolder holder, int position) {
        final Position o = positions.get(position);
        holder.getTv_position_time().setText(o.getDate());
        holder.getTv_position_longitude().setText(o.getLongitude());
        holder.getTv_victime_latitude().setText(o.getLatitude());
    }
    public void setOnClickListener(View.OnClickListener onClickListener){

        this.onClickListener = onClickListener;
    }

    public int getItemCount() {
        return positions.size();
    }
}
