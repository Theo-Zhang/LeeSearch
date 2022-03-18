package service;

import pojo.Brand;

import java.util.List;

public interface BrandService {

/*
   查询所有
   @return
 */
    List<Brand> selectAll();
    Brand selectById();
}
