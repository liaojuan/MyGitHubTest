package com.lc.liao.mygithub.dataprovider.api.db;

/**
 * Created by liao on 2017/3/9.
 *
 * 数据库公用常量
 */

public interface DbContact {
    /**
     * 数据库名称
     */
    String PUBLIC_DB = "public_db.db";

    /**
     * 表名称
     */
    String HISTORY_ADDRESS = "history_address";

    /**
     * 创建数据库sql
     */
    String CREATE_TABLE = "create table if not exists ";

    /**
     * sql语句
     */
    String SQL_STATEMENT = "(street String primary key,city_name varchar(20),city_code varchar(10), city_ad_code varchar(10), latitude double,longitude double)";

    /**
     * 关键字
     */
    String STREET = "street";

    /**
     * 城市名称
     */
    String CITY_NAME = "city_name";

    /**
     * 城市code
     */
    String CITY_CODE = "city_code";

    /**
     * 城市adcode
     */
    String CITY_AD_CODE = "city_ad_code";

    /**
     * 纬度
     */
    String LATITUDE = "latitude";

    /**
     * 经度
     */
    String LONGITUDE ="longitude";

    /**
     * 数据库最大的条数
     */
    int MAX_LENGTH = 15;
}
