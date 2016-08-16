package com.alex.gy.sci.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alex.gy.sci.R;
import com.alex.gy.sci.domain.MenuData;

import java.util.List;

/**
 * Created by gy on 2016/8/15.
 */
public class SliderMenuAdapter extends BaseAdapter{

    private List<MenuData> data;
    private Context context;

    private LayoutInflater layoutInflater;

    private Typeface font;

    public SliderMenuAdapter(List<MenuData> beans, Context context) {
        this.context = context;
        this.data = beans;
        layoutInflater = LayoutInflater.from(context);
        font = Typeface.createFromAsset(context.getAssets(), "Gy.ttf");
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.slide_menu_listitem,parent,false);
            holder.icon = (TextView) convertView.findViewById(R.id.item_icon);
            holder.title = (TextView) convertView.findViewById(R.id.item_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setTypeface(font);
        holder.icon.setText(data.get(position).getIcon());
        holder.title.setText(data.get(position).getTitle());
        return convertView;
    }


    class ViewHolder{
        public TextView icon;
        public TextView title;
    }
}
