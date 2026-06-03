package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.LandLockOptV705;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LandLockOptV705 {
    public static final a a;
    private static final Lazy<LandLockOptV705> b;

    @SerializedName("enable_lock")
    public final boolean enableLock;

    public LandLockOptV705() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598229);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LandLockOptV705 a() {
            return (LandLockOptV705) LandLockOptV705.b.getValue();
        }
    }

    static {
        Lazy<LandLockOptV705> lazy;
        Covode.recordClassIndex(598228);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LandLockOptV705 c;
                c = LandLockOptV705.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LandLockOptV705 c() {
        return (LandLockOptV705) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "landscape_func_config_v705", new LandLockOptV705(false, 1, null), false, 4, null);
    }

    public LandLockOptV705(boolean z) {
        this.enableLock = z;
    }

    public /* synthetic */ LandLockOptV705(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
