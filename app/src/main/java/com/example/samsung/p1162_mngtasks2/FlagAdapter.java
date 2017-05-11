package com.example.samsung.p1162_mngtasks2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by samsung on 11.05.2017.
 */

class FlagAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    long curFlag;

    FlagAdapter(final Context context) {
        this.context = context;
        this.curFlag = -1;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return context.getResources().getStringArray(R.array.data).length;
    }

    @Override
    public Object getItem(int position) {
        if (position < getCount()) {
            return context.getResources().getStringArray(R.array.data)[position];
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.flag_of_mode, parent, false);
        }

        String flag = view.getResources().getString(R.string.the_mode_difaind_on_flag) + " " + getItem(position).toString();
        ((TextView) view.findViewById(R.id.tvFlag)).setText(flag);

        Button btnStart = (Button) view.findViewById(R.id.btnStart);
        btnStart.setTag(Integer.valueOf(position));

        return view;
    }
}
