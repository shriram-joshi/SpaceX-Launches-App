
package com.sj.spacexlaunches.model.launch_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fairings {

    @SerializedName("reused")
    @Expose
    private Object reused;
    @SerializedName("recovery_attempt")
    @Expose
    private Boolean recoveryAttempt;
    @SerializedName("recovered")
    @Expose
    private Boolean recovered;
    @SerializedName("ship")
    @Expose
    private Object ship;

    public Object getReused() {
        return reused;
    }

    public void setReused(Object reused) {
        this.reused = reused;
    }

    public Boolean getRecoveryAttempt() {
        return recoveryAttempt;
    }

    public void setRecoveryAttempt(Boolean recoveryAttempt) {
        this.recoveryAttempt = recoveryAttempt;
    }

    public Boolean getRecovered() {
        return recovered;
    }

    public void setRecovered(Boolean recovered) {
        this.recovered = recovered;
    }

    public Object getShip() {
        return ship;
    }

    public void setShip(Object ship) {
        this.ship = ship;
    }

}
