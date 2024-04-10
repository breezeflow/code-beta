package org.breeze.mybatis.factory;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

/**
 * 
 * 
 */
public class DataSourceFactory {

    public static DataSource getMysqlDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

}
