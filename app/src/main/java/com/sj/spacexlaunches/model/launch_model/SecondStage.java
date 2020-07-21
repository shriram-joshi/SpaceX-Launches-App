
package com.sj.spacexlaunches.model.launch_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecondStage {

    @SerializedName("block")
    @Expose
    private Object block;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = null;

    public Object getBlock() {
        return block;
    }

    public void setBlock(Object block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

}
