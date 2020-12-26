package com.acexams.aceexam.activity.adpater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.acexams.aceexam.R;
import com.acexams.aceexam.activity.modal.ListItemRow;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListItemRowAdapter extends ArrayAdapter<ListItemRow> {


    private Context context;

    public ListItemRowAdapter(Context context, int resourceId,
                              List<ListItemRow> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {
        ImageView imageView,iconarrow;
        TextView txtTitle;
        View view;
    }

    public View getView(int position, View convertView, @NotNull ViewGroup parent) {
        ViewHolder holder = null;
        ListItemRow rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.drawer_layout, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.textViewName);
            holder.imageView = (ImageView) convertView.findViewById(R.id.drawer_image);
            holder.view = (View) convertView.findViewById(R.id.view1);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
      /*  if (position == 8) {
            holder.view.setVisibility(View.VISIBLE);
        } else {
            holder.view.setVisibility(View.GONE);
        }*/
        holder.txtTitle.setText(rowItem.getName());
        holder.imageView.setImageResource(rowItem.getImage());
       // holder.imageView.setImageResource(rowItem.getIcon());
        return convertView;

    }
}
