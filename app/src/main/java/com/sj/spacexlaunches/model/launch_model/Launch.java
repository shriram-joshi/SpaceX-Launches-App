
package com.sj.spacexlaunches.model.launch_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Launch {

    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("mission_id")
    @Expose
    private List<Object> missionId = null;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("is_tentative")
    @Expose
    private Boolean isTentative;
    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @SerializedName("tbd")
    @Expose
    private Boolean tbd;
    @SerializedName("launch_window")
    @Expose
    private Object launchWindow;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("ships")
    @Expose
    private List<Object> ships = null;
    @SerializedName("telemetry")
    @Expose
    private Telemetry telemetry;
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("static_fire_date_utc")
    @Expose
    private Object staticFireDateUtc;
    @SerializedName("static_fire_date_unix")
    @Expose
    private Object staticFireDateUnix;
    @SerializedName("timeline")
    @Expose
    private Object timeline;
    @SerializedName("crew")
    @Expose
    private Object crew;
    @SerializedName("last_date_update")
    @Expose
    private String lastDateUpdate;
    @SerializedName("last_ll_launch_date")
    @Expose
    private Object lastLlLaunchDate;
    @SerializedName("last_ll_update")
    @Expose
    private Object lastLlUpdate;
    @SerializedName("last_wiki_launch_date")
    @Expose
    private String lastWikiLaunchDate;
    @SerializedName("last_wiki_revision")
    @Expose
    private String lastWikiRevision;
    @SerializedName("last_wiki_update")
    @Expose
    private String lastWikiUpdate;
    @SerializedName("launch_date_source")
    @Expose
    private String launchDateSource;

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<Object> getMissionId() {
        return missionId;
    }

    public void setMissionId(List<Object> missionId) {
        this.missionId = missionId;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public void setTbd(Boolean tbd) {
        this.tbd = tbd;
    }

    public Object getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(Object launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<Object> getShips() {
        return ships;
    }

    public void setShips(List<Object> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public Object getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(Object staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public Object getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(Object staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    public Object getTimeline() {
        return timeline;
    }

    public void setTimeline(Object timeline) {
        this.timeline = timeline;
    }

    public Object getCrew() {
        return crew;
    }

    public void setCrew(Object crew) {
        this.crew = crew;
    }

    public String getLastDateUpdate() {
        return lastDateUpdate;
    }

    public void setLastDateUpdate(String lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    public Object getLastLlLaunchDate() {
        return lastLlLaunchDate;
    }

    public void setLastLlLaunchDate(Object lastLlLaunchDate) {
        this.lastLlLaunchDate = lastLlLaunchDate;
    }

    public Object getLastLlUpdate() {
        return lastLlUpdate;
    }

    public void setLastLlUpdate(Object lastLlUpdate) {
        this.lastLlUpdate = lastLlUpdate;
    }

    public String getLastWikiLaunchDate() {
        return lastWikiLaunchDate;
    }

    public void setLastWikiLaunchDate(String lastWikiLaunchDate) {
        this.lastWikiLaunchDate = lastWikiLaunchDate;
    }

    public String getLastWikiRevision() {
        return lastWikiRevision;
    }

    public void setLastWikiRevision(String lastWikiRevision) {
        this.lastWikiRevision = lastWikiRevision;
    }

    public String getLastWikiUpdate() {
        return lastWikiUpdate;
    }

    public void setLastWikiUpdate(String lastWikiUpdate) {
        this.lastWikiUpdate = lastWikiUpdate;
    }

    public String getLaunchDateSource() {
        return launchDateSource;
    }

    public void setLaunchDateSource(String launchDateSource) {
        this.launchDateSource = launchDateSource;
    }

}
