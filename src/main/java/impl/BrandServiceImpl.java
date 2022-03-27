package impl;


import util.SqlSessionFactoryUtils;
import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    // 1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<Brand> selectAll() {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        List<Brand> brands = mapper.selectAll();

        //5.释放资源
        sqlSession.close();

        return brands;
    }

//    @Override
//    public Brand selectById() {
//        return null;
//    }
}
