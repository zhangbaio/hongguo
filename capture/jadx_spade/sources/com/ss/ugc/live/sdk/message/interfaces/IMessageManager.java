package com.ss.ugc.live.sdk.message.interfaces;

import com.ss.ugc.live.sdk.message.data.IMessage;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IMessageManager {
    void addFirstRequestMessageListener(OnFirstRequestMessageListener onFirstRequestMessageListener);

    void addInterceptor(IInterceptor iInterceptor);

    void addMessageListener(int i, OnMessageListener onMessageListener);

    void addMessageListener(String str, OnMessageListener onMessageListener);

    void addOnInterceptListener(OnInterceptListener onInterceptListener);

    void insertMessage(IMessage iMessage);

    void insertMessage(IMessage iMessage, boolean z);

    void release();

    void removeFirstRequestMessageListener(OnFirstRequestMessageListener onFirstRequestMessageListener);

    void removeInterceptor(IInterceptor iInterceptor);

    void removeMessageListener(int i, OnMessageListener onMessageListener);

    void removeMessageListener(OnMessageListener onMessageListener);

    void removeMessageListener(String str, OnMessageListener onMessageListener);

    void removeOnInterceptListener(OnInterceptListener onInterceptListener);

    void startMessage();

    void stopMessage(boolean z);
}
