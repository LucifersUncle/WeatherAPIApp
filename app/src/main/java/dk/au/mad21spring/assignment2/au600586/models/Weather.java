package dk.au.mad21spring.assignment2.au600586.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "weather_table")
public class Weather {

    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String City;
    private int Temperature;
    private int Priority;

    public Weather(){};

    public Weather(String city, int temperature, int priority)
    {
        this.City = city;
        this.Temperature = temperature;
        this.Priority = priority;
    }

    public void setCity(String city)
    {
        this.City = city;
    }

    public String getCity()
    {
        return City;
    }

    public void setTemperature(int temperature)
    {
        this.Temperature = temperature;
    }

    public int getTemperature()
    {
        return Temperature;
    }

    public int getPriority()
    {
        return Priority;
    }

    public  void setPriority(int priority)
    {
        this.Priority = priority;
    }

    public void setId(int id)
    {
        this.Id = id;
    }

    public int getId()
    {
        return Id;
    }


}
