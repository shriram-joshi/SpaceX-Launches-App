
package com.sj.spacexlaunches.model.launch_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links {

    @SerializedName("mission_patch")
    @Expose
    private Object missionPatch;
    @SerializedName("mission_patch_small")
    @Expose
    private Object missionPatchSmall;
    @SerializedName("reddit_campaign")
    @Expose
    private String redditCampaign;
    @SerializedName("reddit_launch")
    @Expose
    private String redditLaunch;
    @SerializedName("reddit_recovery")
    @Expose
    private String redditRecovery;
    @SerializedName("reddit_media")
    @Expose
    private String redditMedia;
    @SerializedName("presskit")
    @Expose
    private Object presskit;
    @SerializedName("article_link")
    @Expose
    private String articleLink;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("video_link")
    @Expose
    private String videoLink;
    @SerializedName("youtube_id")
    @Expose
    private String youtubeId;
    @SerializedName("flickr_images")
    @Expose
    private List<String> flickrImages = null;

    public Object getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(Object missionPatch) {
        this.missionPatch = missionPatch;
    }

    public Object getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(Object missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getRedditCampaign() {
        return redditCampaign;
    }

    public void setRedditCampaign(String redditCampaign) {
        this.redditCampaign = redditCampaign;
    }

    public String getRedditLaunch() {
        return redditLaunch;
    }

    public void setRedditLaunch(String redditLaunch) {
        this.redditLaunch = redditLaunch;
    }

    public String getRedditRecovery() {
        return redditRecovery;
    }

    public void setRedditRecovery(String redditRecovery) {
        this.redditRecovery = redditRecovery;
    }

    public String getRedditMedia() {
        return redditMedia;
    }

    public void setRedditMedia(String redditMedia) {
        this.redditMedia = redditMedia;
    }

    public Object getPresskit() {
        return presskit;
    }

    public void setPresskit(Object presskit) {
        this.presskit = presskit;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public List<String> getFlickrImages() {
        return flickrImages;
    }

    public void setFlickrImages(List<String> flickrImages) {
        this.flickrImages = flickrImages;
    }

}
