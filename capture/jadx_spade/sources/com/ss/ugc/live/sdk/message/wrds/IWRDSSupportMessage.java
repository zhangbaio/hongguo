package com.ss.ugc.live.sdk.message.wrds;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IWRDSSupportMessage {
    String getWRDSKey();

    String getWRDSSubKey();

    long getWRDSVersion();

    boolean isWRDSMessage();

    void setWRDSMessage(boolean z);

    void setWRDSSubKey(String str);

    void setWRDSVersion(long j);
}
