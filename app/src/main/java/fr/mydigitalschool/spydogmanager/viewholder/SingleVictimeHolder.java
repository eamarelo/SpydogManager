package fr.mydigitalschool.spydogmanager.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.mydigitalschool.spydogmanager.R;

/**
 * Created by jp789 on 01/04/2018.
 */

public class SingleVictimeHolder extends RecyclerView.ViewHolder {
    private TextView tv_position_time, tv_position_longitude,tv_victime_latitude;

    public SingleVictimeHolder(View itemView) {
        super( itemView );
        tv_position_time = (TextView) itemView.findViewById( R.id.tv_position_time );
        tv_position_longitude = (TextView) itemView.findViewById( R.id.tv_position_longitude );
        tv_victime_latitude = (TextView) itemView.findViewById( R.id.tv_victime_latitude );


    }
    public void setTv_position_time(TextView tv_position_time) {
        this.tv_position_time = tv_position_time;
    }
    public TextView getTv_position_time() {
        return tv_position_time;
    }

    public void setTv_position_longitude(TextView tv_position_longitude) {
        this.tv_position_longitude = tv_position_longitude;
    }

    public void setTv_victime_latitude(TextView tv_victime_latitude) {
        this.tv_victime_latitude = tv_victime_latitude;
    }

    public TextView getTv_position_longitude() {
        return tv_position_longitude;
    }

    public TextView getTv_victime_latitude() {
        return tv_victime_latitude;
    }

}
