package org.breeze.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author andy
 * @version 1.0.0
 */
public class JdbcUtils {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/test";

            // 2. 创建连接，可以接入连接池，HikariCP、Druid、C3P0等，然后通过连接池获取连接
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
//            config.setUsername("root");
//            config.setPassword("password");
//            config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
//            config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
//            config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
//            DataSource ds = new HikariDataSource(config);
//            connection = ds.getConnection();
            connection = DriverManager.getConnection(jdbcUrl, "root", "123456");
            // 2.1 事务设置：关闭自动提交，改成手动事务
            connection.setAutoCommit(false);
            // 2.2 隔离级别：读已提交
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            // 3. 创建Statement，即SQL
            String sql = "select * from test.user where `name` = ? and `age` = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "zhang");
            preparedStatement.setObject(2, 18);

            // 4. 执行SQL
            resultSet = preparedStatement.executeQuery();

            // 5. 处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getInt(3));
            }

            connection.commit();
        } catch (Exception e) {
            try {
                //事务回滚
                System.out.println(e);
                if (Objects.nonNull(connection)) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 6. 关闭连接
            if (Objects.nonNull(resultSet)) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(preparedStatement)) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
