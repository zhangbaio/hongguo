package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StopAreaImproveOptV701 {
    public static final a a;
    private static final Lazy<StopAreaImproveOptV701> b;

    @SerializedName("enable")
    public final Boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public StopAreaImproveOptV701() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598542);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StopAreaImproveOptV701 a() {
            return (StopAreaImproveOptV701) StopAreaImproveOptV701.b.getValue();
        }
    }

    static {
        Lazy<StopAreaImproveOptV701> lazy;
        Covode.recordClassIndex(598541);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.l2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StopAreaImproveOptV701 c;
                c = StopAreaImproveOptV701.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final StopAreaImproveOptV701 c() {
        return (StopAreaImproveOptV701) qq3.a.c("stop_area_improve_v701", new StopAreaImproveOptV701(null, 1, 0 == true ? 1 : 0), false, 4, null);
    }

    public StopAreaImproveOptV701(Boolean bool) {
        this.enable = bool;
    }

    public /* synthetic */ StopAreaImproveOptV701(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }
}
