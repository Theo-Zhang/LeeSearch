//package com.leesearch;
//
//import mapper.BrandMapper;
//import mapper.MotorTypeMapper;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import pojo.Brand;
//import pojo.MotorType;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
///*
//* Mybatis Demo代码
// */
//public class MyBatisDemo {
//    public static void main(String[] args) throws IOException {
//        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
//        String resources = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resources);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        //2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //3.执行sql
////        List<User> users = sqlSession.selectList("test.selectAll");
//        //3.1 获取UserMapper接口的代理对象
//        MotorTypeMapper motorTypeMapper = sqlSession.getMapper(MotorTypeMapper.class);
//        List<MotorType> motorTypes = motorTypeMapper.selectAll();
//
//        System.out.println(motorTypes);
//
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brand = brandMapper.selectAll();
//
//        System.out.println(brand);
//
//
//        //4.释放资源
//        sqlSession.close();
//    }
//}
