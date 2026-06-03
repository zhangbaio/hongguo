package com.ss.ugc.live.sdk.message.stream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IStreamMessageManager {
    void addMessageListener(int i, IStreamMessageListener iStreamMessageListener);

    void addMessageListener(String str, IStreamMessageListener iStreamMessageListener);

    void release();

    void removeMessageListener(int i, IStreamMessageListener iStreamMessageListener);

    void removeMessageListener(String str, IStreamMessageListener iStreamMessageListener);

    void updateStreamDelay(long j);
}
