package app.sabeeldev.dawaihazir;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.sabeeldev.dawaihazir.Adapter.CustomGrid;
import app.sabeeldev.dawaihazir.Adapter.StoresListAdapter;
import app.sabeeldev.dawaihazir.RetrofitUtils.PostWebAPIData;
import app.sabeeldev.dawaihazir.RoomDatabase.Stores;
import app.sabeeldev.dawaihazir.ViewModel.StoresViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView store_recyclers;
    StoresListAdapter storesListAdapter;
    PostWebAPIData postWebAPIData;
    StoresViewModel viewModel;
    public static TextView shop_discount, shop_timings, shop_contact, shop_name, categories;
    public static ImageView shop_photo;
    public static CardView shop_card;
    public static GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postWebAPIData = new PostWebAPIData();
        init();
    }

    private void init() {
        postWebAPIData.GetStoresData(MainActivity.this);
        // set up the RecyclerView
        store_recyclers = findViewById(R.id.stores_recyclers);
        store_recyclers.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        store_recyclers.setHasFixedSize(false);

        storesListAdapter = new StoresListAdapter();
        store_recyclers.setAdapter(storesListAdapter);

        shop_discount = findViewById(R.id.shop_discount);
        shop_timings = findViewById(R.id.shop_timings);
        shop_contact = findViewById(R.id.shop_contact);
        shop_photo = findViewById(R.id.shop_photo);
        shop_card = findViewById(R.id.shop_card);
        shop_name = findViewById(R.id.shop_name);
        categories = findViewById(R.id.categories);
        databasehandling();

        grid = (GridView) findViewById(R.id.grid);

    }

    private void databasehandling() {
        viewModel = ViewModelProviders.of(this).get(StoresViewModel.class);
        viewModel.getAllStores().observe(this, new Observer<List<Stores>>() {
            @Override
            public void onChanged(List<Stores> stores) {
                storesListAdapter.setStores(MainActivity.this, stores);
//                Toast.makeText(MainActivity.this, "onChanged\n" + stores.get(1).getName() + "\n" + stores.get(1).getContact(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}