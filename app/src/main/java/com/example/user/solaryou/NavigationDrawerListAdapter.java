package com.example.user.solaryou;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 9/3/2014.
 */
public class NavigationDrawerListAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<NavigationDrawerIcon> navDrawerIcons;

    public NavigationDrawerListAdapter(Context context, ArrayList<NavigationDrawerIcon> navDrawerIcons) {
        this.context = context;
        this.navDrawerIcons = navDrawerIcons;
    }

    @Override
    public int getCount() {
        return navDrawerIcons.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerIcons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.planet_drawer_layout, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        imgIcon.setImageResource(navDrawerIcons.get(position).getIcon());
        txtTitle.setText(navDrawerIcons.get(position).getTitle());

        // displaying count
        // check whether it set visible or not
        if (navDrawerIcons.get(position).getCounterVisibility()) {
            txtCount.setText(navDrawerIcons.get(position).getCount());
        } else {
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }

        return convertView;
    }
}
