package pq3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final a c;
    private static final Lazy<i> d;
    private final int a;
    private final boolean b;

    /* JADX WARN: Multi-variable type inference failed */
    public i() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598235);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return (i) i.d.getValue();
        }
    }

    static {
        Lazy<i> lazy;
        Covode.recordClassIndex(598234);
        c = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i d2;
                d2 = i.d();
                return d2;
            }
        });
        d = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i d() {
        return ((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).v();
    }

    public final boolean c() {
        if (this.b && !ShortSeriesApi.Companion.c().isNowInHotTime()) {
            return true;
        }
        return false;
    }

    public i(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public /* synthetic */ i(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
    }
}
