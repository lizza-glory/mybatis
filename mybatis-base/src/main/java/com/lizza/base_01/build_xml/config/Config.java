package com.lizza.base_01.build_xml.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-09-04
 */
public class Config {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String path = "";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        return sqlSessionFactory;
    }
}
