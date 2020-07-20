
package com.sj.spacexlaunches.model.launch_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core {

    @SerializedName("core_serial")
    @Expose
    private String coreSerial;
    @SerializedName("flight")
    @Expose
    private Integer flight;
    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("gridfins")
    @Expose
    private Boolean gridfins;
    @SerializedName("legs")
    @Expose
    private Boolean legs;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("land_success")
    @Expose
    private Boolean landSuccess;
    @SerializedName("landing_intent")
    @Expose
    private Boolean landingIntent;
    @SerializedName("landing_type")
    @Expose
    private String landingType;
    @SerializedName("landing_vehicle")
    @Expose
    private String landingVehicle;

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Boolean getGridfins() {
        return gridfins;
    }

    public void setGridfins(Boolean gridfins) {
        this.gridfins = gridfins;
    }

    public Boolean getLegs() {
        return legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(Boolean landSuccess) {
        this.landSuccess = landSuccess;
    }

    public Boolean getLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(Boolean landingIntent) {
        this.landingIntent = landingIntent;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(String landingVehicle) {
        this.landingVehicle = landingVehicle;
    }

}
