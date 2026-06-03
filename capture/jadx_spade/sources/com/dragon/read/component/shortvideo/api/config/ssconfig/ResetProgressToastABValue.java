package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResetProgressToastABValue {

    @SerializedName("enable")
    public final boolean enable;

    static {
        Covode.recordClassIndex(598458);
    }

    public ResetProgressToastABValue() {
        this(false, 1, null);
    }

    public ResetProgressToastABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ ResetProgressToastABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
