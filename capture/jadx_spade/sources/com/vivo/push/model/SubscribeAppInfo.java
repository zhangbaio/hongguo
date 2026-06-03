package com.vivo.push.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SubscribeAppInfo {
    private int mActualStatus;
    private String mName;
    private int mTargetStatus;

    static {
        Covode.recordClassIndex(655093);
    }

    public int getActualStatus() {
        return this.mActualStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getTargetStatus() {
        return this.mTargetStatus;
    }

    public int hashCode() {
        int hashCode;
        String str = this.mName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode + 31) * 31) + this.mTargetStatus;
    }

    public String toString() {
        return "SubscribeAppInfo [mName=" + this.mName + ", mTargetStatus=" + this.mTargetStatus + ", mActualStatus=" + this.mActualStatus + "]";
    }

    public void setActualStatus(int i) {
        this.mActualStatus = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setTargetStatus(int i) {
        this.mTargetStatus = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) obj;
        String str = this.mName;
        if (str == null) {
            if (subscribeAppInfo.mName != null) {
                return false;
            }
        } else if (!str.equals(subscribeAppInfo.mName)) {
            return false;
        }
        if (this.mTargetStatus == subscribeAppInfo.mTargetStatus) {
            return true;
        }
        return false;
    }

    public SubscribeAppInfo(String str, int i, int i2) {
        this.mName = str;
        this.mTargetStatus = i;
        this.mActualStatus = i2;
    }
}
