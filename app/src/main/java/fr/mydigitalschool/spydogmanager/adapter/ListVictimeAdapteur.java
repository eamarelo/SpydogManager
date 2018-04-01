package fr.mydigitalschool.spydogmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.mydigitalschool.spydogmanager.R;
import fr.mydigitalschool.spydogmanager.activity.SingleVictimeActivity;
import fr.mydigitalschool.spydogmanager.model.Position;
import fr.mydigitalschool.spydogmanager.model.Victime;
import fr.mydigitalschool.spydogmanager.viewholder.ListVictimeHolder;

/**
 * Created by jp789 on 01/04/2018.
 */

public class ListVictimeAdapteur extends RecyclerView.Adapter<ListVictimeHolder>  {
    private List<Victime> victimes;
    private Context context;
    private View.OnClickListener onClickListener;


    public ListVictimeAdapteur(List<Victime> victimes, Context context){
        this.victimes = victimes;
        this.context = context;
    }


    @Override
    public ListVictimeHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final ListVictimeHolder toto =  new ListVictimeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_victime,parent,false));
        Log.d( "onCreateViewHolder: ", toto.itemView.toString() );


        return toto;
    }

    @Override
    public void onBindViewHolder(ListVictimeHolder holder, int position) {
        final Victime o = victimes.get(position);
        holder.getTv_victime_name().setText(o.getIdentification());
        Log.d("error", String.valueOf( o.getId() ) );
        holder.getTv_victime_name().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext(), SingleVictimeActivity.class );
                intent.putExtra("listpos", (Serializable) o.getPostion() );
                intent.putExtra( "nameVic", o.getIdentification() );
                context.startActivity(intent);
                Log.d( "onClick: ", o.getDate() );
                //onClickListener.onClick(view);
            }
        });
    }
    public void setOnClickListener(View.OnClickListener onClickListener){

        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return victimes.size();
    }
}
