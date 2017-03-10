package com.lc.liao.mygithub.dataprovider.api.db.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lc.liao.mygithub.dataprovider.api.db.DbContact;
import com.lc.liao.mygithub.dataprovider.api.db.helper.HistoryDataOpenHelper;
import com.lc.liao.mygithub.objectprovider.result.Location;
import com.lc.liao.mygithub.objectprovider.result.pub.City;

import java.util.ArrayList;

/**
 * Created by liao on 2017/3/9.
 */

public class HistoryDataApi {
    private HistoryDataOpenHelper openHelper;

    public static HistoryDataApi dataApi;

    public static HistoryDataApi getInstall(Context context){
        if(dataApi == null) dataApi = new HistoryDataApi(context);
        return dataApi;
    }

    public HistoryDataApi(Context context){
        openHelper = new HistoryDataOpenHelper(context);
    }

    /**
     * 插入一条数据
     * @param location
     * @return
     */
    public Long insert(Location location){
        if(findStreet(location.getStreet(), location.getCity().name)){
            return null;
        }
        delAddressHeadData();
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbContact.STREET, location.getStreet());
        values.put(DbContact.CITY_NAME, location.getCity().name);
        values.put(DbContact.CITY_CODE, location.getCity().code);
        values.put(DbContact.CITY_AD_CODE, location.getCity().adcode);
        values.put(DbContact.LATITUDE, location.getLat());
        values.put(DbContact.LONGITUDE, location.getLng());
        Long curId = db.insert(DbContact.HISTORY_ADDRESS, null, values);
        db.close();
        return curId;
    }

    /**
     * 查询历史记录是否存在
     * @param street
     * @param city_name
     * @return
     */
    public boolean findStreet(String street, String city_name){
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor cursor = db.query(DbContact.HISTORY_ADDRESS, null, DbContact.STREET + "=? and " + DbContact.CITY_NAME + "=?", new String[]{street, city_name}, null, null, null);
        boolean result = cursor.moveToNext();
        cursor.close();
        db.close();
        return result;
    }

    /**
     * 确保历史地址列表数据量小于15，大于15就删除一条
     * @return
     */
    public int delAddressHeadData(){
        ArrayList<Location> localArrayList = new ArrayList<Location>();
        localArrayList = findAll();
        if(localArrayList.size() >= DbContact.MAX_LENGTH){
            Location item = localArrayList.get(DbContact.MAX_LENGTH);
            delete_last_data(item);
        }
        return 0;
    }

    /**
     * 查询数据库，查找所以数据
     * @return
     */
    public ArrayList<Location> findAll(){
        SQLiteDatabase db = openHelper.getReadableDatabase();
        ArrayList<Location> list = new ArrayList<Location>();
        Cursor cursor = null;
        try {
            cursor = db.query(DbContact.HISTORY_ADDRESS, null, null, null, null, null, null);
            while (cursor.moveToNext()){
                Location item = new Location();
                item.setStreet(cursor.getString(cursor.getColumnIndex(DbContact.STREET)));
                City city = new City();
                city.name = cursor.getString(cursor.getColumnIndex(DbContact.CITY_NAME));
                city.adcode = cursor.getString(cursor.getColumnIndex(DbContact.CITY_AD_CODE));
                city.code = cursor.getString(cursor.getColumnIndex(DbContact.CITY_CODE));
                item.setCity(city);
                item.setLat(cursor.getDouble(cursor.getColumnIndex(DbContact.LATITUDE)));
                item.setLng(cursor.getDouble(cursor.getColumnIndex(DbContact.LONGITUDE)));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            db.close();
        }
        return list;
    }

    /**
     * 删除最后一条数据
     * @param location
     */
    public void delete_last_data(Location location){
        delete(location.getStreet(), location.getCity().name);
    }

    /**
     * 根据地址和城市名称来删除一条数据
     * @param street
     * @param city_name
     * @return
     */
    public int delete(String street, String city_name){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        int number = 0;
        try {
            number = db.delete(DbContact.HISTORY_ADDRESS, DbContact.STREET + " =? and " + DbContact.CITY_NAME + "=?", new String[]{street, city_name});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return number;
    }
}
