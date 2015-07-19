package com.example.jelo.gridviewtext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jelo.gridviewtext.adapters.CustomcheeseAdapter;
import com.example.jelo.gridviewtext.model.FoodCharacter;
import com.example.jelo.gridviewtext.model.Hungry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<FoodCharacter> listViewData=getFooodData();
        CustomcheeseAdapter adapter = new CustomcheeseAdapter(this,listViewData);

        ListView listView = (ListView) findViewById(R.id.listview);

       listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("FoodCharacter",(FoodCharacter)parent.getAdapter().getItem(position));
                startActivity(intent);
            }
        });

    }

    private ArrayList<FoodCharacter>getFooodData(){
        ArrayList<FoodCharacter>list = new ArrayList<>();

        for (int i = 0 ; i < Hungry.names.length;i++) {
            FoodCharacter meat = new FoodCharacter(Hungry.names[i], Hungry.desriptions[i], Hungry.images[i]);
            list.add(meat);
        }

return list;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public  static class DetailActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);

            FoodCharacter fish = (FoodCharacter)getIntent().getExtras().getSerializable("FoodCharacter");

            TextView discriptionView = (TextView) findViewById(R.id.description);

            ImageView imageView = (ImageView) findViewById(R.id.image);
            discriptionView.setText(fish.getName());
            Picasso.with(this)
                    .load(fish.getImage())
                    .resize(300,300)
                    .centerCrop()
                    .into(imageView);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_detail, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }

}
