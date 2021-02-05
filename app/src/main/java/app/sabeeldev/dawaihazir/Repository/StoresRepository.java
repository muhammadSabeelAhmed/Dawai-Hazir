package app.sabeeldev.dawaihazir.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import app.sabeeldev.dawaihazir.RoomDatabase.StoreDao;
import app.sabeeldev.dawaihazir.RoomDatabase.Stores;
import app.sabeeldev.dawaihazir.RoomDatabase.StoresDatabase;

public class StoresRepository {
    StoreDao storeDao;
    private LiveData<List<Stores>> currentStore;

    public StoresRepository(Application application) {
        StoresDatabase usersDatabase = StoresDatabase.getInstance(application);
        storeDao = usersDatabase.storesDao();
        currentStore = storeDao.getAllStores();
    }

    public void insert(Stores stores) {
        new insertAsyncTask(storeDao).execute(stores);
    }

    public void delete() {
        new deleteAsyncTask(storeDao).execute();
    }

    public void update(Stores stores) {
        new updateAsyncTask(storeDao).execute(stores);
    }

    public LiveData<List<Stores>> getAllStores() {
        return currentStore;
    }

    private static class insertAsyncTask extends AsyncTask<Stores, Void, Void> {
        private StoreDao storeDao;

        private insertAsyncTask(StoreDao storeDao) {
            this.storeDao = storeDao;
        }

        @Override
        protected Void doInBackground(Stores... stores) {
            storeDao.insert(stores[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<Stores, Void, Void> {
        private StoreDao storeDao;

        private updateAsyncTask(StoreDao storeDao) {
            this.storeDao = storeDao;
        }

        @Override
        protected Void doInBackground(Stores... stores) {
            storeDao.update(stores[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Void, Void, Void> {
        private StoreDao storeDao;

        private deleteAsyncTask(StoreDao storeDao) {
            this.storeDao = storeDao;
        }

        @Override
        protected Void doInBackground(Void... stores) {
            storeDao.deleteAllStores();
            return null;
        }
    }
}
