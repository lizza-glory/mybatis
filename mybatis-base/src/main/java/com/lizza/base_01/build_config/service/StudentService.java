package com.lizza.base_01.build_config.service;

import com.lizza.base_01.build_config.config.Config;
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

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-09-04
 */
public class StudentService {

//    public static void main(String[] args){
//    	String packageName = "com.lizza.base_01.build_config.dao.StudentMapper";
//        Config config = new Config();
//        SqlSessionFactory sqlSessionFactory = config.getSqlSessionFactory(packageName);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        for (int i = 0; i < 10; i++) {
//            Student student = new Student(i, i, "student-"+i);
//            sqlSession.insert("com.lizza.base_01.build_config.dao.StudentMapper.addOne", student);
//        }
//        sqlSession.commit();
//        sqlSession.close();
//    }
    public static void main(String[] args){
        DataSource dataSource = new PooledDataSource(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/learner",
                "root",
                "123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
        configuration.addMapper(StudentMapper.class);
//        configuration.addMappedStatement();
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession();
//        Student student = session.selectOne("com.lizza.base_01.build_config.entity.Student.findOneById", 1);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.findOneById(1);
        System.out.println(student);
        session.commit();
        session.close();
    }
}
