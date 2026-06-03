package com.dragon.read.component.shortvideo.api.config.ssconfig;

import android.app.Activity;
import android.view.Window;
import com.bytedance.covode.number.Covode;
import com.dragon.read.util.kotlin.ContextKt;
import com.dragon.read.util.kotlin.UIKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BottomTabHeightCompressionV679 {
    public static final a a;
    private static final Lazy<BottomTabHeightCompressionV679> b;

    @SerializedName("enable")
    public final boolean enable;

    public BottomTabHeightCompressionV679() {
        this(false, 1, null);
    }

    public static final boolean d() {
        return a.d();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598320);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean d() {
            return a().enable;
        }

        private final BottomTabHeightCompressionV679 a() {
            return (BottomTabHeightCompressionV679) BottomTabHeightCompressionV679.b.getValue();
        }

        public final int b(Activity activity) {
            Window window;
            if (activity == null) {
                activity = ContextKt.getCurrentActivityOrNull();
            }
            if (activity != null) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            if (com.dragon.read.util.a1.I(window)) {
                return 0;
            }
            return UIKt.getDp(6);
        }

        public static /* synthetic */ int c(a aVar, Activity activity, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            return aVar.b(activity);
        }
    }

    static {
        Lazy<BottomTabHeightCompressionV679> lazy;
        Covode.recordClassIndex(598319);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                BottomTabHeightCompressionV679 c;
                c = BottomTabHeightCompressionV679.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomTabHeightCompressionV679 c() {
        return (BottomTabHeightCompressionV679) qq3.a.c("bottom_tab_height_compression_v679", new BottomTabHeightCompressionV679(false, 1, null), false, 4, null);
    }

    public BottomTabHeightCompressionV679(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ BottomTabHeightCompressionV679(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
