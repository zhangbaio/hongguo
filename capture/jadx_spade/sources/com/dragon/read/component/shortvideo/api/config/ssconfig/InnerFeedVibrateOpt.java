package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class InnerFeedVibrateOpt {
    public static final a a;
    private static final Lazy<InnerFeedVibrateOpt> b;

    @SerializedName("diggo_feed_vibrate_enable")
    public final boolean diggoFeedVibrateEnable;

    @SerializedName("speed_dismiss_handle_vibrate_enable")
    public final boolean speedDismissHandleVibrateEnable;

    @SerializedName("speed_longpress_handle_vibrate_enable")
    public final boolean speedLongPressHandleVibrateEnable;

    @SerializedName("speed_weak_vibrate_enable")
    public final boolean speedWeakVibrateEnable;

    public InnerFeedVibrateOpt() {
        this(false, false, false, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598372);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InnerFeedVibrateOpt a() {
            return (InnerFeedVibrateOpt) InnerFeedVibrateOpt.b.getValue();
        }
    }

    static {
        Lazy<InnerFeedVibrateOpt> lazy;
        Covode.recordClassIndex(598371);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InnerFeedVibrateOpt c;
                c = InnerFeedVibrateOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InnerFeedVibrateOpt c() {
        return (InnerFeedVibrateOpt) qq3.a.b("inner_feed_vibrate_opt_v671", new InnerFeedVibrateOpt(false, false, false, false, 15, null), true);
    }

    public InnerFeedVibrateOpt(boolean z, boolean z2, boolean z3, boolean z4) {
        this.speedLongPressHandleVibrateEnable = z;
        this.diggoFeedVibrateEnable = z2;
        this.speedDismissHandleVibrateEnable = z3;
        this.speedWeakVibrateEnable = z4;
    }

    public /* synthetic */ InnerFeedVibrateOpt(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}
