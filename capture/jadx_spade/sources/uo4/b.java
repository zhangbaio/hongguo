package uo4;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uo4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b extends RecyclerView.OnScrollListener implements c {
    public static final a j;
    public static final int k;
    private vo4.a a;
    private final c b;
    private final int c;
    private final LogHelper d;
    private boolean e;
    private boolean f;
    private long g;
    private int h;
    private final Lazy i;

    public static final class a {
        static {
            Covode.recordClassIndex(609127);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609126);
        j = new a(null);
        k = 8;
    }

    /* renamed from: uo4.b$b, reason: collision with other inner class name */
    public static final class C0276b implements f54.d {
        final /* synthetic */ f54.a b;

        public void onCancel() {
            b.this.b();
        }

        public void onPause() {
            b.this.p();
        }

        public void onStart() {
            b.this.h();
        }

        public void onFinish() {
            b.this.d.i("the task is completed ", new Object[0]);
            b.this.n();
        }

        public void a(long j) {
            b.this.d.i("the task is running, left time: " + j, new Object[0]);
            b.this.updateProgress(this.b.a, j);
            if (b.this.g > 0 && SystemClock.elapsedRealtime() - b.this.g >= 5000) {
                b.this.d.i("user has not scrolled more than 5s, pause the task", new Object[0]);
                this.b.pause();
            }
        }

        C0276b(f54.a aVar) {
            this.b = aVar;
        }
    }

    private final f54.a x() {
        return (f54.a) this.i.getValue();
    }

    private final void y() {
        this.g = SystemClock.elapsedRealtime();
        B();
    }

    @Override // uo4.c
    public void b() {
        c.a.a(this);
        c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // uo4.c
    public void h() {
        c.a.d(this);
        c cVar = this.b;
        if (cVar != null) {
            cVar.h();
        }
    }

    @Override // uo4.c
    public void n() {
        c.a.b(this);
        c cVar = this.b;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // uo4.c
    public void p() {
        c.a.c(this);
        c cVar = this.b;
        if (cVar != null) {
            cVar.p();
        }
    }

    public void A() {
        this.d.i("try pause the task", new Object[0]);
        x().pause();
    }

    public void v() {
        this.d.i("try cancel the task", new Object[0]);
        x().cancel();
    }

    public void B() {
        this.d.i("try start the task", new Object[0]);
        if (x().f() instanceof g54.g) {
            this.d.i("the task is running, skip start", new Object[0]);
        } else if (x().f() instanceof g54.c) {
            this.d.i("the task has been complete, skip start", new Object[0]);
        } else {
            this.d.i("start the task", new Object[0]);
            x().start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f54.a w(b bVar) {
        f54.a aVar = new f54.a(bVar.a.c, bVar.c);
        aVar.e = bVar.new C0276b(aVar);
        return aVar;
    }

    public final void z(boolean z) {
        this.e = z;
        if (z) {
            if (!this.f) {
                y();
                this.f = true;
                return;
            }
            return;
        }
        this.f = false;
    }

    @Override // uo4.c
    public void updateProgress(long j2, long j3) {
        c.a.e(this, j2, j3);
        c cVar = this.b;
        if (cVar != null) {
            cVar.updateProgress(j2, j3);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        this.h = i;
        if (i == 0) {
            z(false);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (this.h == 1 && i2 > 0) {
            z(true);
        }
    }

    public b(vo4.a taskEntity, c cVar, int i) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(taskEntity, "taskEntity");
        this.a = taskEntity;
        this.b = cVar;
        this.c = i;
        this.d = new LogHelper("BaseTaskBrowseTimeManager_" + this.a.b);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: uo4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                f54.a w;
                w = b.w(b.this);
                return w;
            }
        });
        this.i = lazy;
    }
}
