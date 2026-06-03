package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ViewHolderLeakOptV655;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ViewHolderLeakOptV655 {
    public static final a a;
    private static final Lazy<ViewHolderLeakOptV655> b;

    @SerializedName("enable")
    public final boolean enable;

    public ViewHolderLeakOptV655() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598303);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewHolderLeakOptV655 a() {
            return (ViewHolderLeakOptV655) ViewHolderLeakOptV655.b.getValue();
        }
    }

    static {
        Lazy<ViewHolderLeakOptV655> lazy;
        Covode.recordClassIndex(598302);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewHolderLeakOptV655 c;
                c = ViewHolderLeakOptV655.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewHolderLeakOptV655 c() {
        return (ViewHolderLeakOptV655) qq3.a.c("series_holder_memory_leak_opt_v655", new ViewHolderLeakOptV655(false, 1, null), false, 4, null);
    }

    public ViewHolderLeakOptV655(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ ViewHolderLeakOptV655(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
