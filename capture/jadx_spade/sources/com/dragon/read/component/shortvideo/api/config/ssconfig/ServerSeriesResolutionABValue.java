package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ServerSeriesResolutionABValue {
    public static final a a;
    private static final Lazy<ServerSeriesResolutionABValue> b;

    @SerializedName("enable_server")
    public final boolean enableServer;

    public ServerSeriesResolutionABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598508);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServerSeriesResolutionABValue a() {
            return (ServerSeriesResolutionABValue) ServerSeriesResolutionABValue.b.getValue();
        }
    }

    static {
        Lazy<ServerSeriesResolutionABValue> lazy;
        Covode.recordClassIndex(598507);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.w1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ServerSeriesResolutionABValue c;
                c = ServerSeriesResolutionABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ServerSeriesResolutionABValue c() {
        return (ServerSeriesResolutionABValue) qq3.a.a("server_series_resolution_v655", new ServerSeriesResolutionABValue(false, 1, null), true);
    }

    public ServerSeriesResolutionABValue(boolean z) {
        this.enableServer = z;
    }

    public /* synthetic */ ServerSeriesResolutionABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
