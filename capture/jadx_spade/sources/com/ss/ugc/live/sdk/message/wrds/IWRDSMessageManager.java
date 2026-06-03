package com.ss.ugc.live.sdk.message.wrds;

import com.ss.ugc.live.sdk.message.data.IMessage;
import com.ss.ugc.live.sdk.message.interfaces.OnMessageListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IWRDSMessageManager {
    void addWRDSMessageListener(int i, OnMessageListener onMessageListener);

    void addWRDSMessageListener(int i, OnMessageListener onMessageListener, String str);

    void addWRDSMessageListener(String str, OnMessageListener onMessageListener);

    void addWRDSMessageListener(String str, OnMessageListener onMessageListener, String str2);

    IMessage getNewestWRDSMessage(int i);

    IMessage getNewestWRDSMessage(int i, String str);

    IMessage getNewestWRDSMessage(String str);

    IMessage getNewestWRDSMessage(String str, String str2);
}
