package com.example.butterknifedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/7/21.
 */
public class MyAdatper extends BaseAdapter {
    private Context mContext;
    private List<Person> data;

    public MyAdatper(Context mContext, List<Person> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_lv, null);
//            holder = new viewHolder(convertView);
            holder=new viewHolder();
            holder.item_tv1= (TextView) convertView.findViewById(R.id.item_tv1);
            holder.item_tv2= (TextView) convertView.findViewById(R.id.item_tv2);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();

        }
        holder.item_tv1.setText(data.get(position).getName());
        holder.item_tv2.setText(data.get(position).getAge());
        return convertView;
    }

    static class viewHolder {
        TextView item_tv1;
        TextView item_tv2;
//        @BindView(R.id.item_tv1)
//        TextView item_tv1;
//        @BindView(R.id.item_tv2)
//        TextView item_tv2;
//
//        public viewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
    }


}
