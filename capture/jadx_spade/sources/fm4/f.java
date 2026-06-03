package fm4;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.reader.lib.ReaderClient;
import i35.b;
import kotlin.jvm.internal.Intrinsics;
import pm4.j;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f implements i35.b {
    public static final int b;
    private final a a;

    static {
        Covode.recordClassIndex(608458);
        b = 8;
    }

    public String b() {
        return this.a.b();
    }

    public f(a impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }

    public void c(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.j(activity.h2());
    }

    public void e(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.g(activity.h2());
    }

    public void f(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.m(activity.h2());
    }

    public void g(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.c(activity.h2());
    }

    public void j(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.t(activity.h2());
    }

    public void k(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.n(activity.h2());
    }

    public void l(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.p(activity.h2());
    }

    public void n(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.q(activity.h2());
    }

    public boolean o(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.a.l(activity.h2());
    }

    public void q(NsReaderActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.k(activity.h2());
    }

    public void p(NsReaderActivity nsReaderActivity, Configuration configuration) {
        b.a.a(this, nsReaderActivity, configuration);
    }

    public void r(NsReaderActivity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.i(activity.h2(), bundle);
    }

    public d h(NsReaderActivity activity, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ev, "ev");
        return this.a.r(activity.h2(), ev);
    }

    public void i(NsReaderActivity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.a.s(activity.h2(), outState);
    }

    public void m(NsReaderActivity activity, ReaderClient client) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(client, "client");
        a aVar = this.a;
        i h2 = activity.h2();
        j e = activity.h2().e();
        Intrinsics.checkNotNull(e);
        aVar.d(h2, e);
    }

    public d t(NsReaderActivity activity, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        return this.a.e(activity.h2(), i, event);
    }

    public d w(NsReaderActivity activity, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        return this.a.f(activity.h2(), i, event);
    }

    public void s(NsReaderActivity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.h(activity.h2(), i, i2, intent);
    }

    public void v(NsReaderActivity activity, int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        this.a.o(activity.h2(), i, permissions, grantResults);
    }
}
