package org.breeze.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.breeze.mybatis.domain.User;
import org.breeze.mybatis.factory.DataSourceFactory;
import org.breeze.mybatis.mapper.UserMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author andy
 * @version 2023/06/30
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {
        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildFromXMLConfig();

        // 创建 SqlSession 执行 SQL
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 Mapper 代理对象
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.select(2);
            System.out.println(user);
        }
    }

    /**
     * 通过 XML 配置文件获取 SqlSessionFactory
     *
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory buildFromXMLConfig() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 通过 Java 配置类获取 SqlSessionFactory
     *
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory buildFromNonXMLConfig() throws IOException {
        DataSource dataSource = DataSourceFactory.getMysqlDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }


}
