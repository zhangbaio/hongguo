package com.ss.ugc.live.sdk.message.data;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IMessage {
    long getDelayDispatchMs();

    int getGeneralMessageType();

    int getIntType();

    int getMessageFrom();

    long getMessageId();

    String getMessageMethod();

    int getPriority();

    long getRoomId();

    boolean isFromFirstRequest();

    boolean isGlobalMessage();

    boolean needMonitor();

    void setConsumeTime(long j);

    void setDecodeEndTime(long j);

    void setDecodeStartTime(long j);

    void setEnqueueDispatchTime(long j);

    void setHttpSendTime(long j);

    void setIsFromFirstRequest(boolean z);

    void setIsInsert(boolean z);

    void setMessageMethod(String str);

    void setReceiveTime(long j);
}
