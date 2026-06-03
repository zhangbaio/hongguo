package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FastPlayDisableABValue {
    public static final a a;
    private static final Lazy<FastPlayDisableABValue> b;

    @SerializedName("disable")
    public final boolean disable;

    public FastPlayDisableABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598353);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FastPlayDisableABValue a() {
            return (FastPlayDisableABValue) FastPlayDisableABValue.b.getValue();
        }
    }

    static {
        Lazy<FastPlayDisableABValue> lazy;
        Covode.recordClassIndex(598352);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FastPlayDisableABValue c;
                c = FastPlayDisableABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastPlayDisableABValue c() {
        return (FastPlayDisableABValue) qq3.a.b("ios_fastplay_disable_v629", new FastPlayDisableABValue(false, 1, null), true);
    }

    public FastPlayDisableABValue(boolean z) {
        this.disable = z;
    }

    public /* synthetic */ FastPlayDisableABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
