package com.vivo.push.d;

import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.vivo.push.IPushActionListener;
import com.vivo.push.m;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private long a;

    static {
        Covode.recordClassIndex(655012);
    }

    private static class a {
        private static final b a;

        static {
            Covode.recordClassIndex(655013);
            a = new b((byte) 0);
        }
    }

    private b() {
        this.a = 0L;
    }

    public static b a() {
        return a.a;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    static /* synthetic */ int a(Activity activity) {
        boolean z;
        if (activity != null && !activity.isFinishing() && activity.getWindow() != null && activity.getWindow().getDecorView() != null && activity.getWindow().getDecorView().getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return 8105;
        }
        if (!com.vivo.push.restructure.a.a().g().a(16384)) {
            return 8106;
        }
        if (!com.vivo.push.restructure.a.a().f().b(activity)) {
            return 0;
        }
        return 8107;
    }

    public final void a(Activity activity, IPushActionListener iPushActionListener) {
        if (iPushActionListener == null) {
            return;
        }
        com.vivo.push.util.g.a().execute(new c(this, activity, iPushActionListener));
    }

    public final void a(Activity activity, IPushActionListener iPushActionListener, long j) {
        if (iPushActionListener == null) {
            return;
        }
        m.a();
        if (!m.a(this.a)) {
            t.c("NotifyGuideDialogManage", "tryShowGuideDialog: isCallingTooQuick, return");
            iPushActionListener.onStateChanged(1002);
        } else {
            this.a = SystemClock.elapsedRealtime();
            com.vivo.push.util.g.a().execute(new e(this, activity, iPushActionListener, j));
        }
    }
}
