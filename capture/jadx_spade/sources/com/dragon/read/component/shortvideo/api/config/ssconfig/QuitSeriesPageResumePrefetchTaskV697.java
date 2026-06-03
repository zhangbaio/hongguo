package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class QuitSeriesPageResumePrefetchTaskV697 {
    public static final a a;
    private static final Lazy<QuitSeriesPageResumePrefetchTaskV697> b;

    @SerializedName("enableResume")
    public final boolean enableResume;

    public QuitSeriesPageResumePrefetchTaskV697() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598446);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuitSeriesPageResumePrefetchTaskV697 a() {
            return (QuitSeriesPageResumePrefetchTaskV697) QuitSeriesPageResumePrefetchTaskV697.b.getValue();
        }
    }

    static {
        Lazy<QuitSeriesPageResumePrefetchTaskV697> lazy;
        Covode.recordClassIndex(598445);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.b1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                QuitSeriesPageResumePrefetchTaskV697 c;
                c = QuitSeriesPageResumePrefetchTaskV697.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuitSeriesPageResumePrefetchTaskV697 c() {
        return (QuitSeriesPageResumePrefetchTaskV697) qq3.a.c("quit_series_page_resume_prefetch_task_v697", new QuitSeriesPageResumePrefetchTaskV697(false, 1, null), false, 4, null);
    }

    public QuitSeriesPageResumePrefetchTaskV697(boolean z) {
        this.enableResume = z;
    }

    public /* synthetic */ QuitSeriesPageResumePrefetchTaskV697(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
