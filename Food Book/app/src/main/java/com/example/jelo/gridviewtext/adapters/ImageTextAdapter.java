package com.example.jelo.gridviewtext.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jelo.gridviewtext.R;

import java.io.Serializable;

/**
 * Created by jelo on 7/16/2015.
 */
public class ImageTextAdapter extends BaseAdapter {
    private Context mContext;

    public ImageTextAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        if (convertView == null) {

            grid = new View(mContext);


            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.cellgrid, parent, false);
        } else {

            grid = (View) convertView;
        }

            ImageView imageView = (ImageView) grid.findViewById(R.id.imagepart);
            TextView textView = (TextView) grid.findViewById(R.id.textpart);
            imageView.setImageResource(mThumbIds[position]);
            textView.setText("comeuli" + String.valueOf(position));

            return grid;
        }


        public Integer[] mThumbIds = {
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali,
                R.drawable.xinkali


        };




    }



