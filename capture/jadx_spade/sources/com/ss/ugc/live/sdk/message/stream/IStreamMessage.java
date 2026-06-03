package com.ss.ugc.live.sdk.message.stream;

import com.bytedance.covode.number.Covode;
import com.ss.ugc.live.sdk.message.data.IMessage;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IStreamMessage extends IMessage {
    DelayMode getDelayMode();

    long getProcessAtSeiTs();

    long getServerDelay();

    long getTargetSei();

    boolean ignoreCondition();

    boolean isStreamMessage();

    public enum DelayMode {
        DEFAULT,
        CLEAR,
        NOW,
        SEI_DIFF;

        static {
            Covode.recordClassIndex(652836);
        }
    }
}
