package com.samelody.livebattery;

/**
 * The battery info.
 *
 * @author Belin Wu
 */
public class BatteryInfo {

    /**
     * The current battery status.
     */
    private int status;

    /**
     * The current battery health.
     */
    private int health;

    /**
     * The current battery plugged mode.
     */
    private int plugged;

    /**
     * The current battery level.
     */
    private int level;

    /**
     * The maximum battery level.
     */
    private int scale;

    /**
     * The current battery temperature.
     */
    private int temperature;

    /**
     * The current battery voltage.
     */
    private int voltage;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPlugged() {
        return plugged;
    }

    public void setPlugged(int plugged) {
        this.plugged = plugged;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getPercent() {
        float percent = (float)level / scale;
        return (int) (percent * 100);
    }

    @Override
    public String toString() {
        return "BatteryInfo{" +
                "status=" + status +
                ", health=" + health +
                ", plugged=" + plugged +
                ", level=" + level +
                ", scale=" + scale +
                ", percent=" + getPercent() +
                ", temperature=" + temperature +
                ", voltage=" + voltage +
                '}';
    }
}
