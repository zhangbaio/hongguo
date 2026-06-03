package com.vivo.push.model;

import android.content.Intent;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NotifyArriveCallbackByUser {
    private Intent mIntent;
    private boolean mIsIntercept;

    static {
        Covode.recordClassIndex(655092);
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isIntercept() {
        return this.mIsIntercept;
    }

    public NotifyArriveCallbackByUser(Intent intent, boolean z) {
        this.mIntent = intent;
        this.mIsIntercept = z;
    }
}
