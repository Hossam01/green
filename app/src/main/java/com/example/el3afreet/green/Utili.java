package com.example.el3afreet.green;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Utili {

    Context context;
    public Utili(Context context)
    {
        this.context=context;
    }

    public void setBrightness(String item) {
        SharedPreferences.Editor editor =context.getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("idName", item);
        editor.apply();
        editor.commit();

    }

    public String getBrightness() {
        SharedPreferences prefs = context.getSharedPreferences("data", MODE_PRIVATE);
        String idName = prefs.getString("idName", "");
        return idName;
    }


    public void setTemperature(String item) {
        SharedPreferences.Editor editor =context.getSharedPreferences("temp", MODE_PRIVATE).edit();
        editor.putString("temperature", item);
        editor.apply();
        editor.commit();

    }

    public String getTemperature() {
        SharedPreferences prefs = context.getSharedPreferences("temp", MODE_PRIVATE);
        String idName = prefs.getString("temperature", "");
        return idName;
    }

    public void setWaterLevel(String item) {
        SharedPreferences.Editor editor =context.getSharedPreferences("water", MODE_PRIVATE).edit();
        editor.putString("level", item);
        editor.apply();
        editor.commit();

    }

    public String getWaterLevel() {
        SharedPreferences prefs = context.getSharedPreferences("water", MODE_PRIVATE);
        String idName = prefs.getString("level", "");
        return idName;
    }
    public void setAmbientLight(String item) {
        SharedPreferences.Editor editor =context.getSharedPreferences("AmbientLight", MODE_PRIVATE).edit();
        editor.putString("light", item);
        editor.apply();
        editor.commit();

    }

    public String getAmbientLight() {
        SharedPreferences prefs = context.getSharedPreferences("AmbientLight", MODE_PRIVATE);
        String idName = prefs.getString("light", "");
        return idName;
    }

    public void setPhLevel(String item) {
        SharedPreferences.Editor editor =context.getSharedPreferences("PhLevel", MODE_PRIVATE).edit();
        editor.putString("ph", item);
        editor.apply();
        editor.commit();

    }

    public String getPhLevel() {
        SharedPreferences prefs = context.getSharedPreferences("PhLevel", MODE_PRIVATE);
        String idName = prefs.getString("ph", "");
        return idName;
    }
    public void setPlantHigh(String item) {
        SharedPreferences.Editor editor =context.getSharedPreferences("plant", MODE_PRIVATE).edit();
        editor.putString("high", item);
        editor.apply();
        editor.commit();

    }

    public String getPlantHigh() {
        SharedPreferences prefs = context.getSharedPreferences("plant", MODE_PRIVATE);
        String idName = prefs.getString("high", "");
        return idName;
    }
}
