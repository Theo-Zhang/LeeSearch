package pojo;

public class GPower {
    private Integer thrustWattsId;
    private String thrust;
    private String watts;

    public Integer getthrustWattsId() {
        return thrustWattsId;
    }

    public void setthrustWattsId(Integer thrustWattsId) {
        this.thrustWattsId = thrustWattsId;
    }

    public String getThrust() {
        return thrust;
    }

    public void setThrust(String thrust) {
        this.thrust = thrust;
    }

    public String getWatts() {
        return watts;
    }

    public void setWatts(String watts) {
        this.watts = watts;
    }

    @Override
    public String toString() {
        return "GPower{" +
                "thrustWattsId=" + thrustWattsId +
                ", thrust='" + thrust + '\'' +
                ", watts='" + watts + '\'' +
                '}';
    }
}
