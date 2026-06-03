package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MiniGameRetainDialog {
    public static final a a;
    private static final MiniGameRetainDialog b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("frequency_days")
    public final int frequencyDays;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniGameRetainDialog() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(588089);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniGameRetainDialog a() {
            Object aBValue = SsConfigMgr.getABValue("mini_game_retain_dialog_711", MiniGameRetainDialog.b);
            Intrinsics.checkNotNullExpressionValue(aBValue, "getABValue(...)");
            return (MiniGameRetainDialog) aBValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Covode.recordClassIndex(588088);
        DefaultConstructorMarker defaultConstructorMarker = null;
        a = new a(defaultConstructorMarker);
        SsConfigMgr.prepareAB("mini_game_retain_dialog_711", MiniGameRetainDialog.class, IMiniGameRetainDialog.class);
        b = new MiniGameRetainDialog(false, 0 == true ? 1 : 0, 3, defaultConstructorMarker);
    }

    public MiniGameRetainDialog(boolean z, int i) {
        this.enable = z;
        this.frequencyDays = i;
    }

    public /* synthetic */ MiniGameRetainDialog(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 14 : i);
    }
}
