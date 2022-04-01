package pojo;

public class GPower {
    private Integer thrustWattsId;// 拉力功率的Id值
    private String thrust;// 拉力
    private String watts;// 功率
    // 获取拉力功率的Id值
    public Integer getthrustWattsId() {
        return thrustWattsId;
    }
    // 设置拉力功率的Id值
    public void setthrustWattsId(Integer thrustWattsId) {
        this.thrustWattsId = thrustWattsId;
    }
    // 获取拉力
    public String getThrust() {
        return thrust;
    }
    // 设置拉力
    public void setThrust(String thrust) {
        this.thrust = thrust;
    }
    // 获取功率
    public String getWatts() {
        return watts;
    }
    // 设置功率
    public void setWatts(String watts) {
        this.watts = watts;
    }
    // toString()方法
    @Override
    public String toString() {
        return "GPower{" +
                "thrustWattsId=" + thrustWattsId +
                ", thrust='" + thrust + '\'' +
                ", watts='" + watts + '\'' +
                '}';
    }
}
