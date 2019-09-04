package com.lizza.base_01.build_config.config;

import com.lizza.base_01.build_config.dao.StudentMapper;
import com.lizza.base_01.build_config.entity.Student;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-09-04
 */
public class Config {
    private String driverClass = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/learner?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true";
    private String username = "root";
    private String password = "123456";

    public SqlSessionFactory getSqlSessionFactory(String packageName){
        // 1.数据源
        DataSource dataSource = new PooledDataSource(
                driverClass,
                url,
                username,
                password
        );
        // 2.创建事务
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        // 3.绑定接口路径
//        configuration.addMappers(packageName);
        configuration.addMapper(StudentMapper.class);
        // 4.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        System.out.println(sqlSessionFactory);
        return sqlSessionFactory;
    }
}
