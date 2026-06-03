package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InnerFeedActorConfigABValue {
    public static final a a;
    private static final Lazy<InnerFeedActorConfigABValue> b;

    @SerializedName("style")
    public final int style;

    public InnerFeedActorConfigABValue() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598366);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final InnerFeedActorConfigABValue b() {
            return (InnerFeedActorConfigABValue) InnerFeedActorConfigABValue.b.getValue();
        }

        public final boolean a() {
            if (b().style != 0) {
                return true;
            }
            return false;
        }

        public final boolean d() {
            if (b().style == 2) {
                return true;
            }
            return false;
        }

        public final boolean e() {
            if (b().style == 1) {
                return true;
            }
            return false;
        }

        public final boolean c() {
            if (b().style != 3 && b().style != 2) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy<InnerFeedActorConfigABValue> lazy;
        Covode.recordClassIndex(598365);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InnerFeedActorConfigABValue c;
                c = InnerFeedActorConfigABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InnerFeedActorConfigABValue c() {
        return (InnerFeedActorConfigABValue) qq3.a.a("inner_feed_data_opt_episode_actor_v661", new InnerFeedActorConfigABValue(0, 1, null), true);
    }

    public InnerFeedActorConfigABValue(int i) {
        this.style = i;
    }

    public /* synthetic */ InnerFeedActorConfigABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
