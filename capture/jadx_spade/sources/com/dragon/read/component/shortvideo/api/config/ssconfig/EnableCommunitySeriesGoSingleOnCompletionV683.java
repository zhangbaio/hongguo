package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EnableCommunitySeriesGoSingleOnCompletionV683 {
    public static final a a;
    private static final Lazy<EnableCommunitySeriesGoSingleOnCompletionV683> b;

    @SerializedName("style")
    public final int style;

    public EnableCommunitySeriesGoSingleOnCompletionV683() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598339);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnableCommunitySeriesGoSingleOnCompletionV683 b() {
            return (EnableCommunitySeriesGoSingleOnCompletionV683) EnableCommunitySeriesGoSingleOnCompletionV683.b.getValue();
        }

        public final boolean a() {
            if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).n4() && b().style == 2) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<EnableCommunitySeriesGoSingleOnCompletionV683> lazy;
        Covode.recordClassIndex(598338);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EnableCommunitySeriesGoSingleOnCompletionV683 c;
                c = EnableCommunitySeriesGoSingleOnCompletionV683.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnableCommunitySeriesGoSingleOnCompletionV683 c() {
        return (EnableCommunitySeriesGoSingleOnCompletionV683) qq3.a.b("enable_community_series_go_single_on_completion_v683", new EnableCommunitySeriesGoSingleOnCompletionV683(0, 1, null), true);
    }

    public EnableCommunitySeriesGoSingleOnCompletionV683(int i) {
        this.style = i;
    }

    public /* synthetic */ EnableCommunitySeriesGoSingleOnCompletionV683(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
