package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OffScreenCloseOpt {
    public static final a a;
    private static final Lazy<OffScreenCloseOpt> b;

    @SerializedName("enable")
    public final boolean enable;

    public OffScreenCloseOpt() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598393);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OffScreenCloseOpt a() {
            return (OffScreenCloseOpt) OffScreenCloseOpt.b.getValue();
        }
    }

    static {
        Lazy<OffScreenCloseOpt> lazy;
        Covode.recordClassIndex(598392);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OffScreenCloseOpt c;
                c = OffScreenCloseOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OffScreenCloseOpt c() {
        return (OffScreenCloseOpt) ISeriesAbValueApi.Companion.c().getABValue2("offscreen_close_opt", new OffScreenCloseOpt(false, 1, null), true);
    }

    public OffScreenCloseOpt(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ OffScreenCloseOpt(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
