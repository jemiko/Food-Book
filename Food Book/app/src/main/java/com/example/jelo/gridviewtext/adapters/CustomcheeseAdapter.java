package com.example.jelo.gridviewtext.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jelo.gridviewtext.R;
import com.example.jelo.gridviewtext.model.FoodCharacter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jelo on 7/17/2015.e
 */
public class CustomcheeseAdapter extends BaseAdapter {
  private ArrayList<FoodCharacter>lisData;
    private Context context;
    private LayoutInflater inflater;

  public CustomcheeseAdapter(Context context,ArrayList<FoodCharacter> data){
this.context=context;
      this.lisData=data;
      this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



  }


    @Override
    public int getCount() {
        return this.lisData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lisData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View itemView;
        Viewholder viewholder;
        if (convertView==null){

            itemView=View.inflate(context, R.layout.listview_item,null);
          viewholder = new Viewholder();

            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            TextView nameView = (TextView)itemView.findViewById(R.id.name);

            viewholder.imageView = imageView;
            viewholder.nameview= nameView;

            itemView.setTag(viewholder);

        }else {

            itemView=convertView;
            viewholder=(Viewholder)itemView.getTag();

        }
FoodCharacter rood = (FoodCharacter)getItem(position);
        viewholder.nameview.setText(rood.getName());


        Picasso.with(context)
                .load(rood.getImage())
                .resize(200,200)
                .centerCrop()
                .into(viewholder.imageView);






        return itemView;
    }
private class Viewholder {
    ImageView imageView;
    TextView  nameview;
}

}
