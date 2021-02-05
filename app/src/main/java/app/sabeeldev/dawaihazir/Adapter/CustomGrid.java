package app.sabeeldev.dawaihazir.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import app.sabeeldev.dawaihazir.General.CateogoryResult;
import app.sabeeldev.dawaihazir.R;

public class CustomGrid extends BaseAdapter {
    ArrayList<CateogoryResult.Categories> categories;

    public CustomGrid(ArrayList<CateogoryResult.Categories> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(parent.getContext());
            grid = inflater.inflate(R.layout.grid_category_items, null);
            TextView catName = (TextView) grid.findViewById(R.id.cat_name);
            ImageView catImage = (ImageView) grid.findViewById(R.id.cat_image);
            catName.setText(categories.get(position).getCategoryname());
            Log.d("MyImages", "" + categories.get(position).getCategoryimage());
            Picasso.get().load(categories.get(position).getCategoryimage()).into(catImage);

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}