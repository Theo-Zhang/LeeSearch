package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Brand;


import java.util.List;
//BrandMapper
public interface BrandMapper {

    //查询所有sql语句
    @Select("select * from motor_brand")
    List<Brand> selectAll();

    Brand selectById(int id);
    //带参数查询
    Brand select(@Param("id") int id,@Param("brandName") String brandName);

}
