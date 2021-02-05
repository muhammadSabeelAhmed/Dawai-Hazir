package app.sabeeldev.dawaihazir.RetrofitUtils;

import app.sabeeldev.dawaihazir.General.CateogoryResult;
import app.sabeeldev.dawaihazir.General.Result;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("allstores.php")
    Call<Result> getAllStores();

    @FormUrlEncoded
    @POST("categories.php")
    Call<CateogoryResult> getCategories(@Field("vendorid") String vendorid);
}
