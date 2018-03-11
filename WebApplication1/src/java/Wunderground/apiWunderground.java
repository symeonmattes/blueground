/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wunderground;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author symeon
 */
public class apiWunderground {
    
    public static JSONObject json;
    
    public void apiWunderground(){
    }
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    
    public static JSONObject readJSONFromUrl(String url) throws Exception,JSONException{
   
        InputStream is = new URL(url).openStream();
        try {
                
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject js = new JSONObject(jsonText);
            return js; 
        } finally {
            is.close();
        }
    }
    
    public static void setJSONWunderground(){
        
        try{
            json = readJSONFromUrl("http://api.wunderground.com/api/4f5c6f5fc02cc1c2/history_20180305/q/NY/New_York.json");
        }catch(Exception e){
            e.toString();
        }
        
        
    }
    
    public static String getMaxPercentageHumidity() throws JSONException{
        
        String max;
        try{
            max=json.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getString("maxhumidity");
        }catch (JSONException e){
            max = e.toString();
        }
        
        return max;
    }
    
    public static String getMaxTempInCelcium(){
        String max;
        try{
            max=json.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getString("maxtempm");
        }catch (JSONException e){
            max = e.toString();
        }
        
        return max;
    }
    
    public static String getMinTempInCelcium(){
        String min;
        try{
            min=json.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getString("mintempm");
        }catch (JSONException e){
            min = e.toString();
        }
        
        return min;
    }
        
     public static String getPrecipitationInMM(){
        String val;
        try{
            val=json.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getString("precipm");
        }catch (JSONException e){
            val = e.toString();
        }
        
        return val;
    }   
    
}
