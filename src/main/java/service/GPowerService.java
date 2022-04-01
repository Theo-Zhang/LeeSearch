package service;

import pojo.GPower;

import java.util.List;

public interface GPowerService {
/*
   查询所有
   @return
 */

    List<GPower> selectById(int ids);
}
