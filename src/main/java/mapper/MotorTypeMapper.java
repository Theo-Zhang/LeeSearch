package mapper;

import pojo.MotorType;

import java.util.List;

public interface MotorTypeMapper {

    List<MotorType> selectAll();

    MotorType selectById(int id);

}
