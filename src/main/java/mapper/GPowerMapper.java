package mapper;

import pojo.GPower;
import pojo.MotorType;

import java.util.List;

public interface GPowerMapper {


    List<GPower> selectById(int id);

}
