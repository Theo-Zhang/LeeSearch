package pojo;

public class MotorType {

    private Integer id;
    private String typeName;

    /*
    有些数据没有封装成功，显示为null？
    1.保持Java里面的名称与数据库名称一样，如brandName要和数据库的名字一样
    2.写sql语句时给这两个字段起别名，将别名定义成和属性名一致即可。
    3.使用resultMap解决上述问题
     */


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MotorType{" +
                "id=" + id +
                ", motorType='" + typeName + '\'' +
                '}';
    }
}
