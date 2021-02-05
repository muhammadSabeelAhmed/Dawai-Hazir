package app.sabeeldev.dawaihazir.RetrofitUtils;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import app.sabeeldev.dawaihazir.Adapter.CustomGrid;
import app.sabeeldev.dawaihazir.General.CateogoryResult;
import app.sabeeldev.dawaihazir.General.Global;
import app.sabeeldev.dawaihazir.General.Result;
import app.sabeeldev.dawaihazir.MainActivity;
import app.sabeeldev.dawaihazir.RoomDatabase.Stores;
import app.sabeeldev.dawaihazir.ViewModel.StoresViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static app.sabeeldev.dawaihazir.MainActivity.grid;

public class PostWebAPIData {
    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
    StoresViewModel storesViewModel;

    public PostWebAPIData() {
    }

    public void GetStoresData(AppCompatActivity context) {
        storesViewModel = ViewModelProviders.of(context).get(StoresViewModel.class);
        if (NetworkConnectivity.isOnline()) {
            Call<Result> call = apiInterface.getAllStores();
            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    if (response.isSuccessful()) {
                        storesViewModel.delete();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            Result.Store jsonObject = response.body().getData().get(i);
                            storesViewModel.insert(new Stores(Integer.parseInt(jsonObject.getId()), jsonObject.getName(), jsonObject.getShopopen(), jsonObject.getShopclose(), jsonObject.getShopdiscount(), jsonObject.getContact(), jsonObject.getShoplat(), jsonObject.getShoplong(), jsonObject.getPic()));
                        }
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Log.d("MyResponse", "failure" + t.getMessage());
                }
            });
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    GetStoresData(context);
                }
            }, 4000);
        }
    }

    public void GetCategories(String vendorId) {
        if (NetworkConnectivity.isOnline()) {
            Call<CateogoryResult> call = apiInterface.getCategories(vendorId);
            call.enqueue(new Callback<CateogoryResult>() {
                @Override
                public void onResponse(Call<CateogoryResult> call, Response<CateogoryResult> response) {
                    if (response.isSuccessful()) {
                        Global.categoriesList.clear();
                        Global.categoriesItem.clear();
                        if (response.body().getStatus().equals("true")) {
                            Global.categoriesItem.add(new CateogoryResult(response.body().getStatus(), response.body().getMedicalstore(), response.body().getBanner(), response.body().getBanner(), response.body().getRating()));
                            for (int i = 0; i < response.body().getCategories().size(); i++) {
                                CateogoryResult.Categories jsonObject = response.body().getCategories().get(i);
                                Global.categoriesList.add(new CateogoryResult.Categories(jsonObject.getCategoryid(), jsonObject.getCategoryname(), jsonObject.getCategoryimage(), jsonObject.getVendorid(), jsonObject.getCreated_at(), jsonObject.getCategorystatus()));
                            }
                        }
                    }

                    CustomGrid adapter = new CustomGrid(Global.categoriesList);
                    grid.setAdapter(adapter);
//                    grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view,
//                                                int position, long id) {
//                            Toast.makeText(MainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
//
//                        }
//                    });
                }

                @Override
                public void onFailure(Call<CateogoryResult> call, Throwable t) {
                    Log.d("MyResponse", "failure" + t.getMessage());
                }
            });
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    GetCategories(vendorId);
                }
            }, 4000);
        }
    }
}
