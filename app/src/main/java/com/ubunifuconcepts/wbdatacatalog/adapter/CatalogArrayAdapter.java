package com.ubunifuconcepts.wbdatacatalog.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ubunifuconcepts.wbdatacatalog.R;
import com.ubunifuconcepts.wbdatacatalog.model.WBindicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 6/19/2017.
 */

public class CatalogArrayAdapter extends ArrayAdapter<WBindicator> {

    List<WBindicator> indicators;

    public CatalogArrayAdapter(Context context, int resource) {
        super(context, resource);

        indicators = new ArrayList<WBindicator>();
    }

    @Override
    public int getCount() {

        if(this.indicators!=null){
            return indicators.size();
        }
        return 0;
    }

    @Override
    public WBindicator getItem(int position) {
        WBindicator wbIn;
        if (this.indicators.size() <= position || this.indicators.size() <= 0) {
            wbIn = null;
        } else {
            wbIn = this.indicators.get(position);
        }
        return wbIn;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.catalog_list_item, null);
        }

        WBindicator p = getItem(position);

        if (p != null) {
            TextView tName = (TextView) v.findViewById(R.id.catalog_name);
            TextView tDescription = (TextView) v.findViewById(R.id.catalog_description);


            if (tName != null) {
                tName.setText(p.getName());
            }


            if (tDescription != null) {
                tDescription.setText(p.getDesciption());
            }

        }
        return v;
    }
    public void setData(List<WBindicator> data) {
        clear();
        if (data != null) {
            this.indicators =  data;
            notifyDataSetChanged();
        }
    }
}
