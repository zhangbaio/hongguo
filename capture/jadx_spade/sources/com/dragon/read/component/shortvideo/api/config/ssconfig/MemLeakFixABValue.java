package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MemLeakFixABValue {
    public static final a a;
    private static final Lazy<MemLeakFixABValue> b;

    @SerializedName("fix")
    public final boolean fix;

    public MemLeakFixABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598386);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemLeakFixABValue a() {
            return (MemLeakFixABValue) MemLeakFixABValue.b.getValue();
        }
    }

    static {
        Lazy<MemLeakFixABValue> lazy;
        Covode.recordClassIndex(598385);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MemLeakFixABValue c;
                c = MemLeakFixABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemLeakFixABValue c() {
        return (MemLeakFixABValue) qq3.a.b("mem_leak_fix_v619", new MemLeakFixABValue(false, 1, null), true);
    }

    public MemLeakFixABValue(boolean z) {
        this.fix = z;
    }

    public /* synthetic */ MemLeakFixABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
