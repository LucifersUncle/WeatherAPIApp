package dk.au.mad21spring.assignment2.au600586.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import dk.au.mad21spring.assignment2.au600586.models.Weather;

@Database(entities = {Weather.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase
{
    private static WeatherDatabase instance;

    public abstract WeatherDao weatherDao();

    public static synchronized WeatherDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WeatherDatabase.class, "weather_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        new PopulateDbAsyncTask(instance).execute();
    }
};

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeatherDao weatherDao;

        private PopulateDbAsyncTask(WeatherDatabase db) {
            weatherDao = db.weatherDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            weatherDao.insert(new Weather("Title 1", 1, 1));
            weatherDao.insert(new Weather("Title 2", 2, 2));
            weatherDao.insert(new Weather("Title 3", 3, 3));
            return null;
        }
    }

}

