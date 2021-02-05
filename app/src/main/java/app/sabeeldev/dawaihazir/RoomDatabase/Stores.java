package app.sabeeldev.dawaihazir.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stores_table")
public class Stores {
    @PrimaryKey(autoGenerate = false)
    private int id;

    @NonNull
    private String name, shopopen, shopclose, shopdiscount, contact, shoplat, shoplong, pic;

    public Stores(int id, @NonNull String name, @NonNull String shopopen, @NonNull String shopclose, @NonNull String shopdiscount, @NonNull String contact, @NonNull String shoplat, @NonNull String shoplong, @NonNull String pic) {
        this.id = id;
        this.name = name;
        this.shopopen = shopopen;
        this.shopclose = shopclose;
        this.shopdiscount = shopdiscount;
        this.contact = contact;
        this.shoplat = shoplat;
        this.shoplong = shoplong;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getShopopen() {
        return shopopen;
    }

    public void setShopopen(@NonNull String shopopen) {
        this.shopopen = shopopen;
    }

    @NonNull
    public String getShopclose() {
        return shopclose;
    }

    public void setShopclose(@NonNull String shopclose) {
        this.shopclose = shopclose;
    }

    @NonNull
    public String getShopdiscount() {
        return shopdiscount;
    }

    public void setShopdiscount(@NonNull String shopdiscount) {
        this.shopdiscount = shopdiscount;
    }

    @NonNull
    public String getContact() {
        return contact;
    }

    public void setContact(@NonNull String contact) {
        this.contact = contact;
    }

    @NonNull
    public String getShoplat() {
        return shoplat;
    }

    public void setShoplat(@NonNull String shoplat) {
        this.shoplat = shoplat;
    }

    @NonNull
    public String getShoplong() {
        return shoplong;
    }

    public void setShoplong(@NonNull String shoplong) {
        this.shoplong = shoplong;
    }

    @NonNull
    public String getPic() {
        return pic;
    }

    public void setPic(@NonNull String pic) {
        this.pic = pic;
    }
}
