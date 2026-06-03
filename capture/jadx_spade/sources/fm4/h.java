package fm4;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.reader.state.v;
import com.dragon.read.kmp.reader.utils.p;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pm4.m;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h implements fm4.a {
    static {
        Covode.recordClassIndex(608460);
    }

    @Override // fm4.a
    public String b() {
        return "ReaderStateChangedListener";
    }

    @Override // fm4.a
    public void c(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void h(i activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void i(i activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void j(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void k(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public boolean l(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return false;
    }

    @Override // fm4.a
    public void m(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void n(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void o(i activity, int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    @Override // fm4.a
    public void p(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void q(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // fm4.a
    public void s(i activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // fm4.a
    public void t(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static final class a extends m {
        final /* synthetic */ i a;

        a(i iVar) {
            this.a = iVar;
        }

        @Override // pm4.f
        public void a(int i) {
            j.a.d(p.o("RSStateViewModel"), "更新主题");
            ((com.dragon.read.kmp.reader.state.m) v.a.a(this.a, Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.reader.state.m.class))).H0(i);
        }

        @Override // pm4.m, pm4.f
        public void b(int i) {
            super.b(i);
            j.a.d(p.o("RSStateViewModel"), "更新背景");
            ((com.dragon.read.kmp.reader.state.m) v.a.a(this.a, Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.reader.state.m.class))).F0(i);
        }

        @Override // pm4.m, pm4.f
        public void c(boolean z) {
            super.c(z);
            j.a.d(p.o("RSStateViewModel"), "更新分屏模式: " + z);
            ((com.dragon.read.kmp.reader.state.m) v.a.a(this.a, Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.reader.state.m.class))).G0(z);
        }
    }

    @Override // fm4.a
    public void g(i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        v.a.b(activity);
    }

    @Override // fm4.a
    public void d(i activity, pm4.h client) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(client, "client");
        client.a().a(new a(activity));
    }

    @Override // fm4.a
    public d r(i activity, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ev, "ev");
        return d.a.b();
    }

    @Override // fm4.a
    public d e(i activity, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        return d.a.b();
    }

    @Override // fm4.a
    public d f(i activity, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        return d.a.b();
    }
}
