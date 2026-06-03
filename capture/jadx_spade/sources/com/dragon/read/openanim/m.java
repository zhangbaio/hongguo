package com.dragon.read.openanim;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final m a;
    private static final List<BookOpenAnimTask> b;
    private static List<g> c;
    public static final int d;

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        g0.b(c);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        g0.b(c);
        return Unit.INSTANCE;
    }

    public static final BookOpenAnimTask j() {
        return (BookOpenAnimTask) g0.a(b);
    }

    public static final boolean i() {
        g gVar = (g) g0.a(c);
        if (gVar == null || !gVar.h) {
            return false;
        }
        return true;
    }

    public static final boolean m() {
        Rect rect;
        BookOpenAnimTask j = j();
        if (j == null || (rect = j.b) == null || rect.isEmpty()) {
            return false;
        }
        return true;
    }

    public final g e() {
        BookOpenAnimTask bookOpenAnimTask = (BookOpenAnimTask) g0.b(b);
        if (bookOpenAnimTask != null) {
            g gVar = new g(bookOpenAnimTask, new Function0() { // from class: com.dragon.read.openanim.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit f;
                    f = m.f();
                    return f;
                }
            });
            g0.c(c, gVar);
            return gVar;
        }
        return null;
    }

    public final d0 g() {
        BookOpenAnimTask bookOpenAnimTask = (BookOpenAnimTask) g0.b(b);
        if (bookOpenAnimTask != null) {
            d0 d0Var = new d0(bookOpenAnimTask, new Function0() { // from class: com.dragon.read.openanim.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit h;
                    h = m.h();
                    return h;
                }
            });
            g0.c(c, d0Var);
            return d0Var;
        }
        return null;
    }

    static {
        Covode.recordClassIndex(612633);
        a = new m();
        b = new ArrayList();
        c = new ArrayList();
        AppUtils.context().registerActivityLifecycleCallbacks(new a());
        d = 8;
    }

    public static final void k(BookOpenAnimTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        LogWrapper.info("BookOpenAnimTaskManager", "pushAnimTask->" + task, new Object[0]);
        g0.c(b, task);
    }

    public static final void d(String name, Runnable runnable) {
        BookOpenAnimTask bookOpenAnimTask;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        g gVar = (g) g0.a(c);
        if (gVar != null && (bookOpenAnimTask = gVar.a) != null) {
            bookOpenAnimTask.b(name, runnable);
        }
    }

    public static final void l(String name, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (i()) {
            d(name, runnable);
        } else {
            runnable.run();
        }
    }

    public static final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!m.b.isEmpty()) {
                Iterator it2 = m.b.iterator();
                while (it2.hasNext()) {
                    ((BookOpenAnimTask) it2.next()).e();
                }
                m.b.clear();
                LogWrapper.error("BookOpenAnimTaskManager", activity + " 不支持动画", new Object[0]);
            }
        }
    }
}
