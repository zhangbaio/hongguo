package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StopAreaImproveOptV683 {
    public static final a a;
    private static final Lazy<StopAreaImproveOptV683> b;

    @SerializedName("enable")
    public final Boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public StopAreaImproveOptV683() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598540);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StopAreaImproveOptV683 a() {
            return (StopAreaImproveOptV683) StopAreaImproveOptV683.b.getValue();
        }
    }

    static {
        Lazy<StopAreaImproveOptV683> lazy;
        Covode.recordClassIndex(598539);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.k2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StopAreaImproveOptV683 c;
                c = StopAreaImproveOptV683.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final StopAreaImproveOptV683 c() {
        return (StopAreaImproveOptV683) qq3.a.c("stop_area_improve_v683", new StopAreaImproveOptV683(null, 1, 0 == true ? 1 : 0), false, 4, null);
    }

    public StopAreaImproveOptV683(Boolean bool) {
        this.enable = bool;
    }

    public /* synthetic */ StopAreaImproveOptV683(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }
}
