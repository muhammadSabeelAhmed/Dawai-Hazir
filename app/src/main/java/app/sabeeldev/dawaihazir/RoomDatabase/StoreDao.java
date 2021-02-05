package app.sabeeldev.dawaihazir.RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StoreDao {

    @Insert
    void insert(Stores stores);

    @Update
    void update(Stores stores);

    @Query("DELETE FROM stores_table")
    void deleteAllStores();

    @Query("SELECT * FROM stores_table")
    LiveData<List<Stores>> getAllStores();
}
