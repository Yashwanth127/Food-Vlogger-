package com.example.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.food.WasteItem;

import java.util.ArrayList;

public class WasteAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<WasteItem> wasteList;

    public WasteAdapter(Context context, ArrayList<WasteItem> wasteList) {
        this.context = context;
        this.wasteList = wasteList;
    }

    @Override
    public int getCount() {
        return wasteList.size();
    }

    @Override
    public Object getItem(int position) {
        return wasteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_waste, parent, false);
        }

        WasteItem wasteItem = wasteList.get(position);

        TextView typeTextView = convertView.findViewById(R.id.typeTextView);
        TextView quantityTextView = convertView.findViewById(R.id.quantityTextView);
        TextView reasonTextView = convertView.findViewById(R.id.reasonTextView);

        typeTextView.setText(wasteItem.getType());
        quantityTextView.setText(wasteItem.getQuantity());
        reasonTextView.setText(wasteItem.getReason());

        return convertView;
    }
}
