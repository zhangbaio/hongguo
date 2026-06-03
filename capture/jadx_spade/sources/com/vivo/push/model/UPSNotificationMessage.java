package com.vivo.push.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class UPSNotificationMessage {
    private String mAdClickCheckUrl;
    private int mCompatibleType;
    private String mContent;
    private String mCoverUrl;
    private String mCustomValue;
    private int mExtentStatus;
    private String mIconUrl;
    private int mIsMacroReplace;
    private long mMsgArriveTime;
    private long mMsgId;
    private int mNotifyType;
    private Map<String, String> mParams = new HashMap();
    private String mPurePicUrl;
    private boolean mShowTime;
    private String mSkipContent;
    private int mSkipType;
    private int mTargetType;
    private String mTitle;
    private String mTragetContent;

    public interface ExtentStatusFlag {
    }

    static {
        Covode.recordClassIndex(655094);
    }

    public String getAdClickCheckUrl() {
        return this.mAdClickCheckUrl;
    }

    public int getCompatibleType() {
        return this.mCompatibleType;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public String getCustomValue() {
        return this.mCustomValue;
    }

    public int getExtentStatus() {
        return this.mExtentStatus;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getIsMacroReplace() {
        return this.mIsMacroReplace;
    }

    public long getMsgArriveTime() {
        return this.mMsgArriveTime;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public int getNotifyType() {
        return this.mNotifyType;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public String getPurePicUrl() {
        return this.mPurePicUrl;
    }

    public String getSkipContent() {
        return this.mSkipContent;
    }

    public int getSkipType() {
        return this.mSkipType;
    }

    public String getTargetContent() {
        return this.mTragetContent;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isShowTime() {
        return this.mShowTime;
    }

    public void clearCoverUrl() {
        this.mIconUrl = "";
    }

    public void clearPurePicUrl() {
        this.mPurePicUrl = "";
    }

    public boolean isMacroReplace() {
        if (this.mIsMacroReplace == 1) {
            return true;
        }
        return false;
    }

    public String getThirdPackageName() {
        if (getExtentStatus() == 1) {
            return getCustomValue();
        }
        return null;
    }

    public boolean isAppInstallCompleteMsg() {
        if (getExtentStatus() == 1 && !TextUtils.isEmpty(getCustomValue())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "UPSNotificationMessage{mTargetType=" + this.mTargetType + ", mTragetContent='" + this.mTragetContent + "', mTitle='" + this.mTitle + "', mContent='" + this.mContent + "', mNotifyType=" + this.mNotifyType + ", mPurePicUrl='" + this.mPurePicUrl + "', mIconUrl='" + this.mIconUrl + "', mCoverUrl='" + this.mCoverUrl + "', mSkipContent='" + this.mSkipContent + "', mSkipType=" + this.mSkipType + ", mShowTime=" + this.mShowTime + ", mMsgId=" + this.mMsgId + ", mParams=" + this.mParams + ", mIsMacroReplace=" + this.mIsMacroReplace + ", mAdClickCheckUrl='" + this.mAdClickCheckUrl + "', mCompatibleType=" + this.mCompatibleType + ", mExtentStatus=" + this.mExtentStatus + ", mCustomValue='" + this.mCustomValue + "', mMsgArriveTime=" + this.mMsgArriveTime + '}';
    }

    public void setAdClickCheckUrl(String str) {
        this.mAdClickCheckUrl = str;
    }

    public void setCompatibleType(int i) {
        this.mCompatibleType = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
    }

    public void setCustomValue(String str) {
        this.mCustomValue = str;
    }

    public void setExtentStatus(int i) {
        this.mExtentStatus = i;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIsMacroReplace(int i) {
        this.mIsMacroReplace = i;
    }

    public void setMsgArriveTime(long j) {
        this.mMsgArriveTime = j;
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public void setNotifyType(int i) {
        this.mNotifyType = i;
    }

    public void setParams(Map<String, String> map) {
        this.mParams = map;
    }

    public void setPurePicUrl(String str) {
        this.mPurePicUrl = str;
    }

    public void setShowTime(boolean z) {
        this.mShowTime = z;
    }

    public void setSkipContent(String str) {
        this.mSkipContent = str;
    }

    public void setSkipType(int i) {
        this.mSkipType = i;
    }

    public void setTargetContent(String str) {
        this.mTragetContent = str;
    }

    public void setTargetType(int i) {
        this.mTargetType = i;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
