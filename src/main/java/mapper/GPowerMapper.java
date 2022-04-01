package mapper;

import pojo.GPower;


import java.util.List;
// Mapper接口
public interface GPowerMapper {
    List<GPower> selectById(int id);

}
