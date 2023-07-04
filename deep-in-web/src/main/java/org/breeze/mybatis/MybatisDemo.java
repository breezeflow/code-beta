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

        // 一级缓存基本使用
//        localCacheDemo();

        // 测试一级缓存作用域
//        testLocalCacheScope();

        // 测试二级缓存
        testLevel2Cache();

    }

    public static void testLevel2Cache() throws IOException {
        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildFromXMLConfig();
        SqlSession session1 = sqlSessionFactory.openSession(false);
        SqlSession session2 = sqlSessionFactory.openSession(false);
        UserMapper userMapper1 = session1.getMapper(UserMapper.class);
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);

        // session1 查询数据
        System.out.println("userMapper1读取数据: " + userMapper1.selectById(1));
        session1.commit();
        // 二级缓存生效，这次查询不会执行SQL语句，直接从二级缓存中获取结果
        System.out.println("userMapper2读取数据: " + userMapper2.selectById(1));

        // session1 更新了数据，二级缓存失效，session2 再次查询徐重新执行 SQL
        System.out.println("userMapper1更新了" + userMapper1.updateById(new User(1, "road", 19)));
        System.out.println("userMapper2读取数据: " + userMapper2.selectById(1));
        System.out.println("userMapper1读取数据: " + userMapper1.selectById(1));

    }

    public static void localCacheDemo() throws IOException {
        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildFromXMLConfig();
        try {
            // 创建 SqlSession 执行 SQL
            SqlSession session = sqlSessionFactory.openSession(true);

            // 获取 Mapper 代理对象
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user1 = mapper.selectById(1);
            System.out.println(user1);

            // 更新数据：一级缓存失效
            mapper.updateById(new User(1, "zhang3", 19));

            User user2 = mapper.selectById(1);
            System.out.println(user2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试一级缓存作用域
     */
    public static void testLocalCacheScope() throws IOException {
        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = buildFromXMLConfig();
        SqlSession session1 = sqlSessionFactory.openSession(true);
        SqlSession session2 = sqlSessionFactory.openSession(true);
        UserMapper userMapper1 = session1.getMapper(UserMapper.class);
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);

        // session1 一级缓存
        System.out.println("userMapper1读取数据: " + userMapper1.selectById(1));
        // 一级缓存生效，这次查询不会执行SQL语句，直接从缓存中获取结果
        System.out.println("userMapper1读取数据: " + userMapper1.selectById(1));

        // session2 更新了数据，session2的一级缓存失效
        System.out.println("userMapper2更新了" + userMapper2.updateById(new User(1, "road", 19)));

        // session1 再次查询获取到了 更新之前的 脏数据
        System.out.println("userMapper1读取数据: " + userMapper1.selectById(1));

        // session2 读取到的是 更新之后的数据，所以证明 mybatis 一级缓存的作用域为session级，且多个session时，容易出现脏数据
        System.out.println("userMapper2读取数据: " + userMapper2.selectById(1));

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
