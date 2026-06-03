package kotlin.concurrent;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TimersKt {
    static {
        Covode.recordClassIndex(658269);
    }

    public static final class a extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.a.invoke(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super TimerTask, Unit> function1) {
            this.a = function1;
        }
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new a(action);
    }

    public static final Timer timer(String str, boolean z) {
        if (str == null) {
            return new PthreadTimer("rent/TimersKt", z);
        }
        return new PthreadTimer(str, z);
    }

    private static final TimerTask schedule(Timer timer, long j, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j);
        return aVar;
    }

    private static final TimerTask schedule(Timer timer, Date time, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time);
        return aVar;
    }

    private static final TimerTask schedule(Timer timer, long j, long j2, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j, j2);
        return aVar;
    }

    private static final TimerTask scheduleAtFixedRate(Timer timer, long j, long j2, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, j, j2);
        return aVar;
    }

    private static final TimerTask scheduleAtFixedRate(Timer timer, Date time, long j, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, time, j);
        return aVar;
    }

    private static final TimerTask schedule(Timer timer, Date time, long j, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time, j);
        return aVar;
    }

    private static final Timer fixedRateTimer(String str, boolean z, long j, long j2, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new a(action), j, j2);
        return timer;
    }

    private static final Timer fixedRateTimer(String str, boolean z, Date startAt, long j, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new a(action), startAt, j);
        return timer;
    }

    private static final Timer timer(String str, boolean z, long j, long j2, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.schedule(new a(action), j, j2);
        return timer;
    }

    private static final Timer timer(String str, boolean z, Date startAt, long j, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.schedule(new a(action), startAt, j);
        return timer;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, long j, long j2, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new a(action), j, j2);
        return timer;
    }

    static /* synthetic */ Timer timer$default(String str, boolean z, long j, long j2, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.schedule(new a(action), j, j2);
        return timer;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, Date startAt, long j, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new a(action), startAt, j);
        return timer;
    }

    static /* synthetic */ Timer timer$default(String str, boolean z, Date startAt, long j, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(str, z);
        timer.schedule(new a(action), startAt, j);
        return timer;
    }
}
