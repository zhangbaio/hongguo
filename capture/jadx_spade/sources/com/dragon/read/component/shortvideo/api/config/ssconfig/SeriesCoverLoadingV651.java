package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesCoverLoadingV651 {
    public static final a a;
    private static final Lazy<SeriesCoverLoadingV651> b;

    @SerializedName("strategy")
    public final int strategy;

    public SeriesCoverLoadingV651() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598469);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesCoverLoadingV651 a() {
            return (SeriesCoverLoadingV651) SeriesCoverLoadingV651.b.getValue();
        }

        public final boolean b() {
            if (a().strategy == 3) {
                return true;
            }
            return false;
        }

        public final boolean d() {
            if (a().strategy == 1) {
                return true;
            }
            return false;
        }

        public final boolean c() {
            if (!d() && !e() && !b()) {
                return false;
            }
            return true;
        }

        public final boolean e() {
            if (a().strategy != 2 && !d()) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy<SeriesCoverLoadingV651> lazy;
        Covode.recordClassIndex(598468);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.i1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesCoverLoadingV651 c;
                c = SeriesCoverLoadingV651.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesCoverLoadingV651 c() {
        return (SeriesCoverLoadingV651) qq3.a.c("series_cover_loading_strategy", new SeriesCoverLoadingV651(0, 1, null), false, 4, null);
    }

    public SeriesCoverLoadingV651(int i) {
        this.strategy = i;
    }

    public /* synthetic */ SeriesCoverLoadingV651(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
