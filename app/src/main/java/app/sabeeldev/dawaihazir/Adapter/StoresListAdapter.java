package app.sabeeldev.dawaihazir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.sabeeldev.dawaihazir.R;
import app.sabeeldev.dawaihazir.RetrofitUtils.PostWebAPIData;
import app.sabeeldev.dawaihazir.RoomDatabase.Stores;

import static app.sabeeldev.dawaihazir.MainActivity.categories;
import static app.sabeeldev.dawaihazir.MainActivity.shop_card;
import static app.sabeeldev.dawaihazir.MainActivity.shop_contact;
import static app.sabeeldev.dawaihazir.MainActivity.shop_discount;
import static app.sabeeldev.dawaihazir.MainActivity.shop_name;
import static app.sabeeldev.dawaihazir.MainActivity.shop_photo;
import static app.sabeeldev.dawaihazir.MainActivity.shop_timings;

public class StoresListAdapter extends RecyclerView.Adapter<StoresListAdapter.ViewHolder> {
    List<Stores> storesList;
    PostWebAPIData postWebAPIData = new PostWebAPIData();
    Context context;

    public void setStores(Context context, List<Stores> storesList) {
        this.storesList = storesList;
        this.context = context;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_list, parent, false);
        return new StoresListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(storesList.get(position).getName());
        holder.off_percnet.setText(storesList.get(position).getShopdiscount());
        if (storesList.get(position).getShopdiscount().equals("0%")) {
            holder.off_percnet.setVisibility(View.GONE);
        } else if (Integer.parseInt(storesList.get(position).getShopdiscount().replace("%", "")) >= 30) {
            holder.off_percnet.setVisibility(View.VISIBLE);
            holder.off_percnet.setBackgroundResource(R.drawable.offer_bg_red);
        } else {
            holder.off_percnet.setVisibility(View.VISIBLE);
            holder.off_percnet.setBackgroundResource(R.drawable.offer_bg_yellow);
        }
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop_discount.setVisibility(View.VISIBLE);
                shop_timings.setVisibility(View.VISIBLE);
                shop_contact.setVisibility(View.VISIBLE);
                shop_photo.setVisibility(View.VISIBLE);
                shop_card.setVisibility(View.VISIBLE);
                shop_name.setVisibility(View.VISIBLE);
                categories.setVisibility(View.VISIBLE);

                shop_discount.setText(storesList.get(position).getShopdiscount() + " Discount");
                shop_name.setText(storesList.get(position).getName());
                shop_timings.setText("Shop Timings: " + storesList.get(position).getShopopen() + " - " + storesList.get(position).getShopclose());
                shop_contact.setText("Call Us at: " + storesList.get(position).getContact());
                //  shop_photo.setImageBitmap(getBitmapFromURL(storesList.get(position).getPic()));
                loadImage(storesList.get(position).getPic(), shop_photo);
                postWebAPIData.GetCategories("" + storesList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return storesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, off_percnet;
        RelativeLayout store_details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.store_names);
            off_percnet = itemView.findViewById(R.id.store_off_percent);
        }
    }

    public void loadImage(String src, ImageView imageView) {
        Picasso.get().load(src).into(imageView);

    }
}
