package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OpenPreloadAndPrefetchABValue {
    public static final a a;
    private static final Lazy<OpenPreloadAndPrefetchABValue> b;

    @SerializedName("open_inner_preload_video")
    public final boolean openInnerPreloadVideo;

    @SerializedName("open_prefetch")
    public final boolean openPrefetch;

    @SerializedName("open_video_detail_refresh_after_page_exit")
    public final boolean openVideoDetailRefreshAfterPageExit;

    public OpenPreloadAndPrefetchABValue() {
        this(false, false, false, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598400);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OpenPreloadAndPrefetchABValue a() {
            return (OpenPreloadAndPrefetchABValue) OpenPreloadAndPrefetchABValue.b.getValue();
        }
    }

    static {
        Lazy<OpenPreloadAndPrefetchABValue> lazy;
        Covode.recordClassIndex(598399);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OpenPreloadAndPrefetchABValue c;
                c = OpenPreloadAndPrefetchABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpenPreloadAndPrefetchABValue c() {
        return (OpenPreloadAndPrefetchABValue) qq3.a.b("open_preload_and_prefetch", new OpenPreloadAndPrefetchABValue(false, false, false, 7, null), true);
    }

    public OpenPreloadAndPrefetchABValue(boolean z, boolean z2, boolean z3) {
        this.openInnerPreloadVideo = z;
        this.openPrefetch = z2;
        this.openVideoDetailRefreshAfterPageExit = z3;
    }

    public /* synthetic */ OpenPreloadAndPrefetchABValue(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3);
    }
}
