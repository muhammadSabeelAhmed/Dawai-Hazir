package app.sabeeldev.dawaihazir.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import app.sabeeldev.dawaihazir.Repository.StoresRepository;
import app.sabeeldev.dawaihazir.RoomDatabase.Stores;

public class StoresViewModel extends AndroidViewModel {

    private StoresRepository storesRepository;
    private LiveData<List<Stores>> currentStore;

    public StoresViewModel(@NonNull Application application) {
        super(application);
        storesRepository = new StoresRepository(application);
        currentStore = storesRepository.getAllStores();
    }

    public void insert(Stores stores) {
        storesRepository.insert(stores);
    }

    public void delete() {
        storesRepository.delete();
    }

    public void update(Stores stores) {
        storesRepository.update(stores);
    }

    public LiveData<List<Stores>> getAllStores() {
        return currentStore;
    }

}
