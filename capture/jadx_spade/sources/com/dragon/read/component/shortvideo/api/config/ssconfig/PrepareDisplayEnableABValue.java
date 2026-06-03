package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PrepareDisplayEnableABValue {
    public static final a a;
    private static final Lazy<PrepareDisplayEnableABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public PrepareDisplayEnableABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598437);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PrepareDisplayEnableABValue a() {
            return (PrepareDisplayEnableABValue) PrepareDisplayEnableABValue.b.getValue();
        }
    }

    static {
        Lazy<PrepareDisplayEnableABValue> lazy;
        Covode.recordClassIndex(598436);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.x0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PrepareDisplayEnableABValue c;
                c = PrepareDisplayEnableABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PrepareDisplayEnableABValue c() {
        return (PrepareDisplayEnableABValue) qq3.a.b("video_prepare_display_v603", new PrepareDisplayEnableABValue(false, 1, null), true);
    }

    public PrepareDisplayEnableABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ PrepareDisplayEnableABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
