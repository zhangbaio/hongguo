package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("base::android")
@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TraceEvent implements AutoCloseable {
    private static volatile boolean b;
    private static AtomicBoolean c;
    private static AtomicBoolean d;
    private static boolean e;
    private final String a;

    interface e {
        void a(String str);

        boolean b();

        void c(String str);

        void d();

        void e(String str, String str2);

        void f(String str, String str2);

        void g(int i, int i2, boolean z, boolean z2, String str, String str2, long j);

        void h(String str, String str2);

        long i(String str, long j);
    }

    private static final class c extends b implements MessageQueue.IdleHandler {
        private long c;
        private long d;
        private int e;
        private int f;
        private int g;
        private boolean h;

        static {
            Covode.recordClassIndex(654279);
        }

        private c() {
        }

        private final void f() {
            if (TraceEvent.b && !this.h) {
                this.c = s.a();
                Looper.myQueue().addIdleHandler(this);
                this.h = true;
                Log.v("TraceEvent_LooperMonitor", "attached idle handler");
                return;
            }
            if (this.h && !TraceEvent.b) {
                Looper.myQueue().removeIdleHandler(this);
                this.h = false;
                Log.v("TraceEvent_LooperMonitor", "detached idle handler");
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long a = s.a();
            if (this.c == 0) {
                this.c = a;
            }
            long j = a - this.c;
            this.f++;
            TraceEvent.d("Looper.queueIdle", this.g + " tasks since last idle.");
            if (j > 48) {
                g(3, this.e + " tasks and " + this.f + " idles processed so far, " + this.g + " tasks bursted and " + j + "ms elapsed since last idle");
            }
            this.c = a;
            this.g = 0;
            return true;
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.b
        final void a(String str) {
            if (this.g == 0) {
                TraceEvent.f("Looper.queueIdle");
            }
            this.d = s.a();
            f();
            super.a(str);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.b
        final void b(String str) {
            long a = s.a() - this.d;
            if (a > 16) {
                g(5, "observed a task that took " + a + "ms: " + str);
            }
            super.b(str);
            f();
            this.e++;
            this.g++;
        }

        private static void g(int i, String str) {
            TraceEvent.h("TraceEvent.LooperMonitor:IdleStats", str);
            Log.println(i, "TraceEvent_LooperMonitor", str);
        }
    }

    private static final class d {
        private static final b a;

        static {
            b bVar;
            Covode.recordClassIndex(654280);
            if (com.ttnet.org.chromium.base.b.a().b("enable-idle-tracing")) {
                bVar = new c();
            } else {
                bVar = new b();
            }
            a = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class f implements MessageQueue.IdleHandler {
        private static boolean b;
        private static f c;
        private long a;

        static {
            Covode.recordClassIndex(654282);
        }

        private f() {
        }

        private static void c() {
            ThreadUtils.b();
            if (b) {
                Looper.myQueue().removeIdleHandler(c);
                b = false;
            }
        }

        private static void e() {
            ThreadUtils.b();
            if (!b) {
                Looper.myQueue().addIdleHandler(c);
                b = true;
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long a = s.a();
            long j = this.a;
            if (j == 0 || a - j > 1000) {
                this.a = a;
                u.j().d();
                return true;
            }
            return true;
        }

        public static void g() {
            if (!ThreadUtils.k()) {
                ThreadUtils.f(new Runnable() { // from class: com.ttnet.org.chromium.base.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        TraceEvent.f.g();
                    }
                });
                return;
            }
            if (u.j().b()) {
                if (c == null) {
                    c = new f();
                }
                e();
            } else if (c != null) {
                c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(int i, View view, long j) {
            String str;
            ThreadUtils.b();
            int id = view.getId();
            try {
                if (view.getResources() != null) {
                    if (id != 0) {
                        str = view.getResources().getResourceName(id);
                    } else {
                        str = "__no_id__";
                    }
                } else {
                    str = "__no_resources__";
                }
            } catch (Resources.NotFoundException unused) {
                str = "__name_not_found__";
            }
            u.j().g(id, i, view.isShown(), view.isDirty(), view.getClass().getSimpleName(), str, j);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    d(id, viewGroup.getChildAt(i2), j);
                }
            }
        }
    }

    public static boolean e() {
        return b;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        f(this.a);
    }

    static class b implements Printer {
        private static final int b;
        private String a;

        b() {
        }

        static {
            Covode.recordClassIndex(654278);
            b = 18;
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                a(str);
            } else {
                b(str);
            }
        }

        private static String c(String str) {
            int indexOf;
            int indexOf2 = str.indexOf(40, b);
            if (indexOf2 == -1) {
                indexOf = -1;
            } else {
                indexOf = str.indexOf(41, indexOf2);
            }
            if (indexOf != -1) {
                return str.substring(indexOf2 + 1, indexOf);
            }
            return "";
        }

        private static String d(String str) {
            int indexOf;
            int indexOf2 = str.indexOf(125, b);
            if (indexOf2 == -1) {
                indexOf = -1;
            } else {
                indexOf = str.indexOf(58, indexOf2);
            }
            if (indexOf == -1) {
                indexOf = str.length();
            }
            if (indexOf2 != -1) {
                return str.substring(indexOf2 + 2, indexOf);
            }
            return "";
        }

        static String e(String str) {
            if (TraceEvent.e) {
                return "Looper.dispatch: EVENT_NAME_FILTERED";
            }
            return "Looper.dispatch: " + c(str) + "(" + d(str) + ")";
        }

        void a(String str) {
            boolean e = EarlyTraceEvent.e();
            if (TraceEvent.b || e) {
                this.a = e(str);
                if (TraceEvent.b) {
                    u.j().c(this.a);
                } else {
                    EarlyTraceEvent.a(this.a, true);
                }
            }
        }

        void b(String str) {
            boolean e = EarlyTraceEvent.e();
            if ((TraceEvent.b || e) && this.a != null) {
                if (TraceEvent.b) {
                    u.j().a(this.a);
                } else {
                    EarlyTraceEvent.f(this.a, true);
                }
            }
            this.a = null;
        }
    }

    static void i() {
        d.set(true);
        if (b) {
            f.g();
        }
    }

    static {
        Covode.recordClassIndex(654275);
        c = new AtomicBoolean();
        d = new AtomicBoolean();
    }

    public static void setEventNameFilteringEnabled(boolean z) {
        e = z;
    }

    public static void f(String str) {
        g(str, null);
    }

    public static TraceEvent k(String str) {
        return m(str, null);
    }

    public static void dumpViewHierarchy(long j) {
        if (!ApplicationStatus.e()) {
            return;
        }
        for (Activity activity : ApplicationStatus.d()) {
            f.d(0, activity.getWindow().getDecorView().getRootView(), u.j().i(activity.getClass().getName(), j));
        }
    }

    public static void setEnabled(boolean z) {
        b bVar;
        if (z) {
            EarlyTraceEvent.b();
        }
        if (b != z) {
            b = z;
            Looper d2 = ThreadUtils.d();
            if (z) {
                bVar = d.a;
            } else {
                bVar = null;
            }
            d2.setMessageLogging(bVar);
        }
        if (d.get()) {
            f.g();
        }
    }

    private TraceEvent(String str, String str2) {
        this.a = str;
        d(str, str2);
    }

    public static void d(String str, String str2) {
        EarlyTraceEvent.a(str, false);
        if (b) {
            u.j().e(str, str2);
        }
    }

    public static void g(String str, String str2) {
        EarlyTraceEvent.f(str, false);
        if (b) {
            u.j().f(str, str2);
        }
    }

    public static void h(String str, String str2) {
        if (b) {
            u.j().h(str, str2);
        }
    }

    public static TraceEvent m(String str, String str2) {
        if (!EarlyTraceEvent.e() && !e()) {
            return null;
        }
        return new TraceEvent(str, str2);
    }
}
