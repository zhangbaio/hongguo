package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BrandBtnColorChangeABValue {

    @SerializedName("style")
    public final int style;

    static {
        Covode.recordClassIndex(598321);
    }

    public BrandBtnColorChangeABValue() {
        this(0, 1, null);
    }

    public BrandBtnColorChangeABValue(int i) {
        this.style = i;
    }

    public /* synthetic */ BrandBtnColorChangeABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
