package fr.mydigitalschool.spydogmanager.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.mydigitalschool.spydogmanager.R;

/**
 * Created by jp789 on 01/04/2018.
 */

public class ListVictimeHolder extends RecyclerView.ViewHolder {
    private TextView tv_victime_name;
    public ListVictimeHolder(View itemView) {
        super( itemView );
        tv_victime_name = (TextView) itemView.findViewById( R.id.tv_victime_name );
    }
    public void setTv_victime_name(TextView tv_victime_name) {
        this.tv_victime_name = tv_victime_name;
    }
    public TextView getTv_victime_name() {
        return tv_victime_name;
    }

}
