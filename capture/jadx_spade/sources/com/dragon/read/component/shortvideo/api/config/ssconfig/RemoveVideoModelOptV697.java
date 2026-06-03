package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RemoveVideoModelOptV697 {
    public static final a a;
    private static final Lazy<RemoveVideoModelOptV697> b;

    @SerializedName("enable_clean_error_code")
    public final List<Long> cleanErrorCode;

    @SerializedName("enable")
    public final boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public RemoveVideoModelOptV697() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598457);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RemoveVideoModelOptV697 a() {
            return (RemoveVideoModelOptV697) RemoveVideoModelOptV697.b.getValue();
        }
    }

    static {
        Lazy<RemoveVideoModelOptV697> lazy;
        Covode.recordClassIndex(598456);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.e1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RemoveVideoModelOptV697 c;
                c = RemoveVideoModelOptV697.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final RemoveVideoModelOptV697 c() {
        return (RemoveVideoModelOptV697) qq3.a.c("enable_remove_video_model_for_play_error_697", new RemoveVideoModelOptV697(false, null, 3, 0 == true ? 1 : 0), false, 4, null);
    }

    public RemoveVideoModelOptV697(boolean z, List<Long> cleanErrorCode) {
        Intrinsics.checkNotNullParameter(cleanErrorCode, "cleanErrorCode");
        this.enable = z;
        this.cleanErrorCode = cleanErrorCode;
    }

    public /* synthetic */ RemoveVideoModelOptV697(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new ArrayList() : list);
    }
}
