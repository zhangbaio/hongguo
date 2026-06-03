package com.vivo.push.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageBizType;
    private int mMessageType;
    private boolean mNoShowOnForeground = false;
    private int mNotifyDisplayStatus;
    private String mReactPackage;
    private String mSuitReactVersion;
    private String mWindowPeriod;

    static {
        Covode.recordClassIndex(655091);
    }

    public void noShowOnForeground() {
        this.mNoShowOnForeground = true;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getMessageBizType() {
        return this.mMessageBizType;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public String getWindowPeriod() {
        return this.mWindowPeriod;
    }

    public boolean isNoShowOnForeground() {
        return this.mNoShowOnForeground;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public boolean isOperateMsg() {
        if (this.mMessageBizType == 0) {
            return true;
        }
        return false;
    }

    private int parsingNotifyStyle() {
        int i = this.mDisplayStyle;
        if ((i & 32) != 0 || (i & 16) == 0) {
            return 0;
        }
        return 1;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public void setInnerPriority(int i) {
        this.mInnerPriority = i;
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        this.mIsShowBigPicOnMobileNet = z;
    }

    public void setMessageBizType(int i) {
        this.mMessageBizType = i;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }

    public void setWindowPeriod(String str) {
        this.mWindowPeriod = str;
    }

    public void setDisplayStyle(int i) {
        this.mDisplayStyle = i;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }
}
