package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SeriesBookMallVisibilityFixV721;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesBookMallVisibilityFixV721 {
    public static final a a;
    private static final Lazy<SeriesBookMallVisibilityFixV721> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("targetTabType")
    public final int targetTabType;

    /* JADX WARN: Multi-variable type inference failed */
    public SeriesBookMallVisibilityFixV721() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598255);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesBookMallVisibilityFixV721 a() {
            return (SeriesBookMallVisibilityFixV721) SeriesBookMallVisibilityFixV721.b.getValue();
        }
    }

    static {
        Lazy<SeriesBookMallVisibilityFixV721> lazy;
        Covode.recordClassIndex(598254);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesBookMallVisibilityFixV721 c;
                c = SeriesBookMallVisibilityFixV721.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final SeriesBookMallVisibilityFixV721 c() {
        return (SeriesBookMallVisibilityFixV721) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "series_book_mall_visibility_fix_v721", new SeriesBookMallVisibilityFixV721(false, 0 == true ? 1 : 0, 3, null), false, 4, null);
    }

    public SeriesBookMallVisibilityFixV721(boolean z, int i) {
        this.enable = z;
        this.targetTabType = i;
    }

    public /* synthetic */ SeriesBookMallVisibilityFixV721(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 16 : i);
    }
}
