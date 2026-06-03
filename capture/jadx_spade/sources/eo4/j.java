package eo4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.BookstoreTabType;
import com.bytedance.kmp.reading.model.fn;
import com.bytedance.kmp.reading.model.xl;
import com.bytedance.kmp.reading.rpc.BookApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.service.m0;
import com.dragon.read.kmp.service.q;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final a b;
    public static final int c;
    private final Lazy a;

    public static final class a {
        static {
            Covode.recordClassIndex(609013);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609012);
        b = new a(null);
        c = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.i d() {
        return new com.dragon.read.kmp.i("KmpShortSeriesRankingRepository");
    }

    public j() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: eo4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.dragon.read.kmp.i d;
                d = j.d();
                return d;
            }
        });
        this.a = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xl f(xl it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        bc4.b.c(bc4.b.a, new bc4.a(it2.a, it2.c, it2.b), false, 0, 6, (Object) null);
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xl g(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (xl) function1.invoke(p0);
    }

    public final Observable<xl> e(String selectedItems, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        String str8;
        int value;
        String str9;
        String str10;
        String str11;
        String str12;
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        if (z) {
            str8 = "video_topic_landpage";
        } else {
            str8 = "video_ranklist";
        }
        if (z) {
            value = BookstoreTabType.video_topic_landpage.getValue();
        } else {
            value = BookstoreTabType.ranklist_landpage.getValue();
        }
        int i = value;
        if (str == null) {
            str9 = "";
        } else {
            str9 = str;
        }
        if (str2 == null) {
            str10 = "";
        } else {
            str10 = str2;
        }
        if (str3 == null) {
            str11 = "";
        } else {
            str11 = str3;
        }
        q a2 = m0.a();
        if (a2 != null) {
            str12 = a2.getSessionId();
        } else {
            str12 = null;
        }
        Observable r = BookApiService.r(BookApiService.a, new fn(10, str8, (String) null, (String) null, (Boolean) null, (Integer) null, Integer.valueOf(i), (Boolean) null, (Integer) null, (String) null, (String) null, (Short) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, str5, selectedItems, str4, (String) null, (String) null, str12, (Integer) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (Long) null, str9, (String) null, (String) null, (String) null, (Long) null, str10, str11, str7, str6, 536870844, 31739, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
        final Function1 function1 = new Function1() { // from class: eo4.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                xl f;
                f = j.f((xl) obj);
                return f;
            }
        };
        Observable map = r.map(new Function() { // from class: eo4.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                xl g;
                g = j.g(Function1.this, obj);
                return g;
            }
        });
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable<xl> subscribeOn = map.subscribeOn(io2);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "subscribeOn(...)");
        return subscribeOn;
    }
}
