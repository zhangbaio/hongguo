package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreloadTimeABValue {
    public static final a a;
    private static final Lazy<PreloadTimeABValue> b;

    @SerializedName("preload_time_enable")
    public final boolean enable;

    public PreloadTimeABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598434);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PreloadTimeABValue a() {
            return (PreloadTimeABValue) PreloadTimeABValue.b.getValue();
        }
    }

    static {
        Lazy<PreloadTimeABValue> lazy;
        Covode.recordClassIndex(598433);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.w0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PreloadTimeABValue c;
                c = PreloadTimeABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadTimeABValue c() {
        return (PreloadTimeABValue) qq3.a.a("preload_time_v615", new PreloadTimeABValue(false, 1, null), true);
    }

    public PreloadTimeABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ PreloadTimeABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
