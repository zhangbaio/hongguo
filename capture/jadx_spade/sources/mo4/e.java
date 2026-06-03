package mo4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.xl;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.kmp.utils.a1;
import com.dragon.read.kmp.utils.c0;
import eo4.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oo4.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements hz4.b<io4.e> {
    public static final a m;
    public static final int n;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final boolean g;
    private final String h;
    private final String i;
    private final CountDownLatch j;
    private io4.e k;
    private final j l;

    public static final class a {
        static {
            Covode.recordClassIndex(609094);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609093);
        m = new a(null);
        n = 8;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public io4.e loadData() {
        String str;
        LogWrapper.info("KmpRankingDataLoaderCallback", "start preload ranking data, selectedItems=" + this.a + ", isTopic=" + this.g, new Object[0]);
        oo4.e eVar = oo4.e.b;
        if (this.g) {
            str = "topic";
        } else {
            str = "ranking";
        }
        eVar.a(str);
        final long n2 = a1.n(a1.a, null, null, 3, null);
        Observable<xl> observeOn = this.l.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i).observeOn(AndroidSchedulers.mainThread());
        final Function1 function1 = new Function1() { // from class: mo4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = e.f(e.this, n2, (xl) obj);
                return f;
            }
        };
        Consumer<? super xl> consumer = new Consumer() { // from class: mo4.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e.g(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: mo4.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h;
                h = e.h(e.this, n2, (Throwable) obj);
                return h;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: mo4.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e.i(Function1.this, obj);
            }
        });
        try {
            this.j.await();
        } catch (InterruptedException unused) {
            this.k = new io4.e(false, null);
            Thread.currentThread().interrupt();
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(e eVar, long j, xl xlVar) {
        int i;
        x7 x7Var;
        List list;
        LogWrapper.info("KmpRankingDataLoaderCallback", "preload ranking data done", new Object[0]);
        g gVar = g.a;
        String str = eVar.a;
        String str2 = eVar.b;
        String str3 = eVar.c;
        String str4 = eVar.d;
        List list2 = xlVar.c;
        if (!c0.a(list2)) {
            list2 = null;
        }
        if (list2 != null && (x7Var = (x7) list2.get(0)) != null && (list = x7Var.u) != null) {
            i = list.size();
        } else {
            i = 0;
        }
        gVar.a(false, str, str2, str3, str4, j, null, null, null, i, true);
        eVar.k = new io4.e(true, xlVar);
        eVar.j.countDown();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(e eVar, long j, Throwable th) {
        LogWrapper.info("KmpRankingDataLoaderCallback", "preload ranking data error " + th.getMessage(), new Object[0]);
        g.a.a(false, eVar.a, eVar.b, eVar.c, eVar.d, j, null, th, Integer.valueOf(po4.b.c(th)), 0, true);
        eVar.k = new io4.e(false, null);
        eVar.j.countDown();
        return Unit.INSTANCE;
    }

    public e(String selectedItems, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        this.a = selectedItems;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = z;
        this.h = str6;
        this.i = str7;
        this.j = new CountDownLatch(1);
        this.k = new io4.e(false, null);
        this.l = new j();
    }
}
