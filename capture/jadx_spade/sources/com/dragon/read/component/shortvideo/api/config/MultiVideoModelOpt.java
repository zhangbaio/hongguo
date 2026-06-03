package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.MultiVideoModelOpt;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MultiVideoModelOpt {
    public static final a a;
    private static final Lazy<MultiVideoModelOpt> b;

    @SerializedName("enable")
    public final boolean enable;

    public MultiVideoModelOpt() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598233);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiVideoModelOpt a() {
            return (MultiVideoModelOpt) MultiVideoModelOpt.b.getValue();
        }
    }

    static {
        Lazy<MultiVideoModelOpt> lazy;
        Covode.recordClassIndex(598232);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MultiVideoModelOpt c;
                c = MultiVideoModelOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MultiVideoModelOpt c() {
        return (MultiVideoModelOpt) qq3.a.c("multi_video_model_opt_v668", new MultiVideoModelOpt(false, 1, null), false, 4, null);
    }

    public MultiVideoModelOpt(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ MultiVideoModelOpt(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
