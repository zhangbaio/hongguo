package yr3;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.AppLifecycleCallback;
import com.dragon.read.app.AppLifecycleMonitor;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.component.shortvideo.api.scheduledstopplay.ScheduledStopPlayOptionType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final i a;
    private static final LogHelper b;
    private static Disposable c;
    private static long d;
    private static ScheduledStopPlayOptionType e;
    private static final BehaviorSubject<Pair<ScheduledStopPlayOptionType, Long>> f;
    private static final CompositeDisposable g;
    private static final PublishSubject<Pair<ScheduledStopPlayOptionType, Long>> h;
    private static final PublishSubject<l> i;
    private static final d j;
    private static final List<k> k;
    private static String l;
    private static boolean m;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(598850);
            int[] iArr = new int[ScheduledStopPlayOptionType.values().length];
            try {
                iArr[ScheduledStopPlayOptionType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduledStopPlayOptionType.DIY_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScheduledStopPlayOptionType.FIXED_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScheduledStopPlayOptionType.PLAY_CURRENT_SERIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    private i() {
    }

    public final String h() {
        return l;
    }

    public final ScheduledStopPlayOptionType i() {
        return e;
    }

    public final Observable<Pair<ScheduledStopPlayOptionType, Long>> j() {
        return f;
    }

    public final Observable<Pair<ScheduledStopPlayOptionType, Long>> k() {
        return h;
    }

    public final PublishSubject<l> m() {
        return i;
    }

    public final boolean n() {
        return m;
    }

    public final Observable<l> l() {
        Observable<l> hide = i.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    private final void g() {
        Disposable disposable;
        boolean z = false;
        b.d("cancelCountDown", new Object[0]);
        Disposable disposable2 = c;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z = true;
        }
        if (z && (disposable = c) != null) {
            disposable.dispose();
        }
    }

    public final void q() {
        b.d("resetScheduledState", new Object[0]);
        h.onNext(new Pair<>(ScheduledStopPlayOptionType.CLOSED, 0L));
    }

    static {
        Covode.recordClassIndex(598849);
        i iVar = new i();
        a = iVar;
        b = new LogHelper("ScheduledStopPlayController");
        e = ScheduledStopPlayOptionType.UNKNOW;
        BehaviorSubject<Pair<ScheduledStopPlayOptionType, Long>> createDefault = BehaviorSubject.createDefault(new Pair(ScheduledStopPlayOptionType.CLOSED, 0L));
        Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault(...)");
        f = createDefault;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        g = compositeDisposable;
        PublishSubject<Pair<ScheduledStopPlayOptionType, Long>> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        h = create;
        PublishSubject<l> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        i = create2;
        j = new d();
        k = new ArrayList();
        l = "";
        Observable<Pair<ScheduledStopPlayOptionType, Long>> observeOn = create.observeOn(AndroidSchedulers.mainThread());
        final Function1 function1 = new Function1() { // from class: yr3.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e2;
                e2 = i.e((Pair) obj);
                return e2;
            }
        };
        Disposable subscribe = observeOn.subscribe(new Consumer() { // from class: yr3.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i.f(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        iVar.p(compositeDisposable, subscribe);
        AppLifecycleMonitor.getInstance().addCallback(new a());
    }

    public static final class a implements AppLifecycleCallback {
        a() {
        }

        public void onEnterBackground(WeakReference<Activity> weakReference) {
            i iVar = i.a;
            iVar.o(iVar);
        }

        public void onEnterForeground(WeakReference<Activity> weakReference) {
            i iVar = i.a;
            iVar.r(iVar);
        }
    }

    public final void s(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        l = seriesId;
        m = true;
    }

    public final void o(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        b.d("pauseCountDown", new Object[0]);
        j.d(obj);
    }

    public final void r(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        b.d("resumeCountDown", new Object[0]);
        j.f(obj);
    }

    private final void t(long j2) {
        if (j2 <= 0) {
            b.d("start count down failed, duration < 0", new Object[0]);
            return;
        }
        d = j2;
        f.onNext(TuplesKt.to(e, Long.valueOf(j2)));
        Disposable disposable = c;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1 function1 = new Function1() { // from class: yr3.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u;
                u = i.u((Long) obj);
                return u;
            }
        };
        c = observeOn.subscribe(new Consumer() { // from class: yr3.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i.v(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Pair pair) {
        LogHelper logHelper = b;
        logHelper.d("receive stateSubject type " + ((ScheduledStopPlayOptionType) pair.getFirst()).getIndex() + " duration " + ((Number) pair.getSecond()).longValue() + " currentType " + e, new Object[0]);
        if (e == pair.getFirst() && ((Number) pair.getSecond()).longValue() == d) {
            logHelper.d("receive invalidate state, drop", new Object[0]);
            return Unit.INSTANCE;
        }
        e = (ScheduledStopPlayOptionType) pair.getFirst();
        int i2 = b.a[((ScheduledStopPlayOptionType) pair.getFirst()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                if (i2 != 4) {
                    a.g();
                } else {
                    a.g();
                    f.onNext(new Pair<>(ScheduledStopPlayOptionType.PLAY_CURRENT_SERIES, 0L));
                }
            } else {
                a.t(((Number) pair.getSecond()).longValue());
            }
        } else {
            a.g();
            f.onNext(new Pair<>(ScheduledStopPlayOptionType.CLOSED, 0L));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Long l2) {
        LogHelper logHelper = b;
        logHelper.d("tick " + d, new Object[0]);
        if (j.e()) {
            d--;
            f.onNext(new Pair<>(e, Long.valueOf(d)));
            if (d == 0) {
                Iterator<k> it2 = k.iterator();
                while (it2.hasNext()) {
                    if (it2.next().intercept()) {
                        b.d("intercept by interceptor! cancel event sent", new Object[0]);
                        a.g();
                        return Unit.INSTANCE;
                    }
                }
                b.d("count down ! stop play", new Object[0]);
                i.onNext(new l());
                f.onNext(new Pair<>(ScheduledStopPlayOptionType.CLOSED, 0L));
                a.g();
            }
        } else {
            logHelper.d("paused by consumer", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final void p(CompositeDisposable compositeDisposable, Disposable disposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "<this>");
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        compositeDisposable.add(disposable);
    }
}
