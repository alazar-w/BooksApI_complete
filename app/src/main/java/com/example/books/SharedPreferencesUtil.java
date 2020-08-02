package com.example.books;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class SharedPreferencesUtil {
    private SharedPreferencesUtil(){};
    public static final String PREF_NAME = "BooksPreferences";
    public static final String POSITION = "position";
    public static final String QUERY = "query";

    //for the initialization of the shared preferences
    public static SharedPreferences getPrefs(Context context){
        //Context.MODE_PRIVATE = only the application creating the shared preference can read and write the preference
        return context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }
    //a method to read string from preferences
    public static String getPreferenceString(Context context,String key){
        //getString -> retrieve Data
        return getPrefs(context).getString(key,"");
    }
    public static int getPreferenceInt(Context context,String key){
        return getPrefs(context).getInt(key,0);
    }

    public static void setPreferencesString(Context context,String key,String value){
        //get an editor object
        SharedPreferences.Editor editor = getPrefs(context).edit();
        //putString -> write changes
        editor.putString(key,value);
        //commit changes
        editor.apply();
    }

    public static void setPreferencesInt(Context context,String key,int value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt(key,value);
        editor.apply();
    }
    public static ArrayList<String> getQueryList(Context context){
        ArrayList<String> queryList = new ArrayList<>();
        for (int i = 1; i<=5;i++){
            String query = getPrefs(context).getString(QUERY + i,"");
            if (!query.isEmpty()){
                query = query.replace(",","");
                queryList.add(query.trim());
            }
        }
        return queryList;
    }
}
