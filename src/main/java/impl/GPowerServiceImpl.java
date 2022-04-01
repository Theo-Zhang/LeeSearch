package impl;



import mapper.GPowerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pojo.GPower;

import service.GPowerService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class GPowerServiceImpl implements GPowerService {

    // 1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<GPower> selectById(int ids) {


        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        GPowerMapper mapper = sqlSession.getMapper(GPowerMapper.class);

        //4.调用方法
        List<GPower> GPower =  mapper.selectById(ids);

        //5.释放资源
        sqlSession.close();

        return GPower;
    }
}
