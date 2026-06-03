package uo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import fh1.a;
import gh1.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e extends b {
    public static final int p;
    public final vo4.b l;
    public boolean m;
    public boolean n;
    private final LogHelper o;

    static {
        Covode.recordClassIndex(609132);
        p = 8;
    }

    public final boolean C() {
        D();
        if (this.m && !this.n) {
            return true;
        }
        return false;
    }

    @Override // uo4.b
    public void B() {
        D();
        if (!this.m) {
            this.o.i("the task is not active, skip start", new Object[0]);
        } else if (this.n) {
            this.o.i("the task has been finished, skip start", new Object[0]);
        } else {
            super.B();
        }
    }

    @Override // uo4.b, uo4.c
    public void n() {
        super.n();
        fh1.a a = ch1.a.a.a(Reflection.getOrCreateKotlinClass(fh1.a.class));
        if (a != null) {
            a.a.a(a, this.l.d, 0, 2, (Object) null);
        }
        this.n = true;
    }

    public final void D() {
        String str;
        boolean z;
        fh1.a a = ch1.a.a.a(Reflection.getOrCreateKotlinClass(fh1.a.class));
        if (a != null) {
            str = a.i5(String.valueOf(this.l.a));
        } else {
            str = null;
        }
        b.b bVar = gh1.b.Companion;
        if (str == null) {
            str = "";
        }
        gh1.b a2 = bVar.a(str);
        boolean z2 = true;
        if (a2 != null && a2.a) {
            z = true;
        } else {
            z = false;
        }
        this.m = z;
        if (com.bytedance.ug.sdk.kmp.novel.consumestrategy.c.a.p((int) this.l.a).o <= 0) {
            z2 = false;
        }
        this.n = z2;
    }

    @Override // uo4.b, uo4.c
    public void updateProgress(long j, long j2) {
        super.updateProgress(j, j2);
        D();
        if (!this.m) {
            this.o.i("the task is not active, cancel it", new Object[0]);
            v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(vo4.b taskEntity, c cVar, int i) {
        super(taskEntity, cVar, i);
        Intrinsics.checkNotNullParameter(taskEntity, "taskEntity");
        this.l = taskEntity;
        this.o = new LogHelper("SpringFestivalTaskBrowseTimeManager" + taskEntity.b);
        D();
    }

    public /* synthetic */ e(vo4.b bVar, c cVar, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i2 & 2) != 0 ? null : cVar, (i2 & 4) != 0 ? 1000 : i);
    }
}
