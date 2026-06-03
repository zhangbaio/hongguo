package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InlineExecutionProhibitedException extends RejectedExecutionException {
    static {
        Covode.recordClassIndex(654473);
    }

    public InlineExecutionProhibitedException() {
        super("Inline execution is prohibited for this request");
    }
}
