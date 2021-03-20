package dk.au.mad21spring.assignment2.au600586.models;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import java.util.List;

import dk.au.mad21spring.assignment2.au600586.database.WeatherDao;
import dk.au.mad21spring.assignment2.au600586.database.WeatherDatabase;
import dk.au.mad21spring.assignment2.au600586.models.Weather;

public class Repository {
    private WeatherDao weatherDao;
    private LiveData<List<Weather>> allWeather;

    public Repository(Application application) {
        WeatherDatabase database = WeatherDatabase.getInstance(application);
        weatherDao = database.weatherDao();
        allWeather = weatherDao.getAllWeather();
    }
    public void insert(Weather weather) {
        new InsertWeatherAsyncTask(weatherDao).execute(weather);
    }
    public void update(Weather weather) {
        new UpdateWeatherAsyncTask(weatherDao).execute(weather);
    }
    public void delete(Weather weather) {
        new DeleteWeatherAsyncTask(weatherDao).execute(weather);
    }
    public void deleteAllNotes() {
        new DeleteAllWeatherAsyncTask(weatherDao).execute();
    }
    public LiveData<List<Weather>> getAllWeather() {
        return allWeather;
    }
    private static class InsertWeatherAsyncTask extends AsyncTask<Weather, Void, Void> {
        private WeatherDao weatherDao;

        private InsertWeatherAsyncTask(WeatherDao weatherDao) {
            this.weatherDao = weatherDao;
        }
        @Override
        protected Void doInBackground(Weather... weathers) {
            weatherDao.insert(weathers[0]);
            return null;
        }
    }
    private static class UpdateWeatherAsyncTask extends AsyncTask<Weather, Void, Void> {
        private WeatherDao weatherDao;
        private UpdateWeatherAsyncTask(WeatherDao weatherDao) {
            this.weatherDao = weatherDao;
        }
        @Override
        protected Void doInBackground(Weather... weathers) {
            weatherDao.update(weathers[0]);
            return null;
        }
    }
    private static class DeleteWeatherAsyncTask extends AsyncTask<Weather, Void, Void> {
        private WeatherDao weatherDao;
        private DeleteWeatherAsyncTask(WeatherDao weatherDao) {
            this.weatherDao = weatherDao;
        }
        @Override
        protected Void doInBackground(Weather... weathers) {
            weatherDao.delete(weathers[0]);
            return null;
        }
    }
    private static class DeleteAllWeatherAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeatherDao weatherDao;

        private DeleteAllWeatherAsyncTask(WeatherDao weatherDao) {
            this.weatherDao = weatherDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            weatherDao.deleteAllWeather();
            return null;
        }
    }
}
