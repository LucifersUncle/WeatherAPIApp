package dk.au.mad21spring.assignment2.au600586.database;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import dk.au.mad21spring.assignment2.au600586.models.Weather;

@Dao
public interface WeatherDao {
    @Insert
    void insert(Weather weather);

    @Update
    void update(Weather weather);

    @Delete
    void delete(Weather weather);

    @Query("DELETE FROM weather_table")
    void deleteAllWeather();

    @Query("SELECT * FROM weather_table ORDER BY priority DESC")
    LiveData<List<Weather>> getAllWeather();
}
