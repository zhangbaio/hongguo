package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OfflinePlayABValue {
    public static final a a;
    private static final Lazy<OfflinePlayABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public OfflinePlayABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598395);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OfflinePlayABValue a() {
            return (OfflinePlayABValue) OfflinePlayABValue.b.getValue();
        }
    }

    static {
        Lazy<OfflinePlayABValue> lazy;
        Covode.recordClassIndex(598394);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OfflinePlayABValue c;
                c = OfflinePlayABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePlayABValue c() {
        int i = 1;
        OfflinePlayABValue enableDownload = ((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableDownload(true);
        if (enableDownload == null) {
            return (OfflinePlayABValue) qq3.a.b("offline_play", new OfflinePlayABValue(false, i, null), true);
        }
        return enableDownload;
    }

    public OfflinePlayABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ OfflinePlayABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
