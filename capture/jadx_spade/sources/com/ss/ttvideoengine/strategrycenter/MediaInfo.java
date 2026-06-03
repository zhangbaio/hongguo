package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MediaInfo {
    private int mComments;
    private double mDuration;
    private String mFormat;
    private int mLikes;
    private String mMediaID;
    private List<Representation> mRepresentations;
    private int mUserComment;
    private int mUserLike;
    private int mUserShare;

    static {
        Covode.recordClassIndex(652710);
    }

    public int getComments() {
        return this.mComments;
    }

    public double getDuration() {
        return this.mDuration;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public int getLikes() {
        return this.mLikes;
    }

    public String getMediaID() {
        return this.mMediaID;
    }

    public int getUserComment() {
        return this.mUserComment;
    }

    public int getUserLike() {
        return this.mUserLike;
    }

    public int getUserShare() {
        return this.mUserShare;
    }

    public void setComments(int i) {
        this.mComments = i;
    }

    public void setDuration(double d) {
        this.mDuration = d;
    }

    public void setFormat(String str) {
        this.mFormat = str;
    }

    public void setLikes(int i) {
        this.mLikes = i;
    }

    public void setMediaID(String str) {
        this.mMediaID = str;
    }

    public void setUserComment(int i) {
        this.mUserComment = i;
    }

    public void setUserLike(int i) {
        this.mUserLike = i;
    }

    public void setUserShare(int i) {
        this.mUserShare = i;
    }
}
