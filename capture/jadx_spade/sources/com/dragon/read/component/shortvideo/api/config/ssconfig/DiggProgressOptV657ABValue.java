package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DiggProgressOptV657ABValue {
    public static final a a;
    private static final Lazy<DiggProgressOptV657ABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public DiggProgressOptV657ABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598335);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiggProgressOptV657ABValue a() {
            return (DiggProgressOptV657ABValue) DiggProgressOptV657ABValue.b.getValue();
        }
    }

    static {
        Lazy<DiggProgressOptV657ABValue> lazy;
        Covode.recordClassIndex(598334);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DiggProgressOptV657ABValue c;
                c = DiggProgressOptV657ABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiggProgressOptV657ABValue c() {
        return (DiggProgressOptV657ABValue) qq3.a.b("digg_progress_opt_v659", new DiggProgressOptV657ABValue(false, 1, null), true);
    }

    public DiggProgressOptV657ABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ DiggProgressOptV657ABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
