package com.dragon.read.kmp.story.impl.feeds.polaris;

import com.bytedance.covode.number.Covode;
import com.bytedance.ug.sdk.kmp.readerbar.model.ReaderProgressAnimationType;
import com.bytedance.ug.sdk.kmp.readerbar.model.ReaderProgressStatus;
import com.dragon.read.kmp.story.api.service.StoryGoldBarStatus;
import cp4.d;
import cp4.g;
import cp4.h;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.i;
import vh1.p;
import xh1.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryPolarisTaskCoordinator {
    public static final int p;
    private final cp4.c a;
    private final d b;
    private final MutableStateFlow<Boolean> c;
    public p d;
    private final CoroutineScope e;
    private Job f;
    private final b g;
    private long h;
    private long i;
    private long j;
    private String k;
    private String l;
    private int m;
    private boolean n;
    private boolean o;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609338);
            int[] iArr = new int[StoryGoldBarStatus.values().length];
            try {
                iArr[StoryGoldBarStatus.PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StoryGoldBarStatus.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StoryGoldBarStatus.HIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StoryGoldBarStatus.HIDE_FINISH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609337);
        p = 8;
    }

    public static final class b extends g {
        @Override // cp4.g
        public void a() {
            KmpStoryPolarisTaskCoordinator.this.r();
        }

        b() {
        }
    }

    public final StateFlow<Boolean> l() {
        return FlowKt.asStateFlow(this.c);
    }

    public final void o() {
        if (!this.n) {
            return;
        }
        u(false);
        cp4.c cVar = this.a;
        if (cVar != null) {
            cVar.M();
        }
    }

    public final void p() {
        if (this.n && com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a() && !this.o) {
            t();
        }
    }

    public final void q() {
        if (!this.n) {
            j();
        }
        if (com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a() && !this.o) {
            t();
            r();
        }
    }

    private final void m() {
        long j;
        cp4.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        h N5 = cVar.N5();
        if (N5 != null) {
            j = N5.f;
        } else {
            j = 0;
        }
        long j2 = this.i;
        if (j2 > 0) {
            cVar.r3(this.k, j2, false);
            this.i = 0L;
        }
        cVar.wa(this.k, this.l, j);
    }

    public final void n() {
        if (this.o) {
            return;
        }
        this.o = true;
        u(true);
        cp4.c cVar = this.a;
        if (cVar != null) {
            cVar.x1();
        }
        cp4.c cVar2 = this.a;
        if (cVar2 != null) {
            cVar2.U0(this.g);
        }
        this.d = null;
        CoroutineScopeKt.cancel$default(this.e, null, 1, null);
    }

    public KmpStoryPolarisTaskCoordinator() {
        eo0.c cVar = eo0.c.a;
        this.a = (cp4.c) cVar.a(Reflection.getOrCreateKotlinClass(cp4.c.class));
        this.b = (d) cVar.a(Reflection.getOrCreateKotlinClass(d.class));
        this.c = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.g = new b();
        this.j = 30000L;
        this.k = "";
        this.l = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        boolean z;
        p pVar;
        float coerceIn;
        p pVar2;
        d dVar;
        cp4.c cVar = this.a;
        if (cVar == null) {
            this.c.setValue(Boolean.FALSE);
            return;
        }
        if (cVar.na() && com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a()) {
            z = true;
        } else {
            z = false;
        }
        this.c.setValue(Boolean.valueOf(z));
        if (!z) {
            return;
        }
        if (this.d == null) {
            d dVar2 = this.b;
            if (dVar2 != null) {
                pVar2 = dVar2.da();
            } else {
                pVar2 = null;
            }
            this.d = pVar2;
            if (pVar2 != null && (dVar = this.b) != null) {
                dVar.t3(pVar2, this.m);
            }
            p pVar3 = this.d;
            if (pVar3 != null) {
                pVar3.j(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.polaris.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s;
                        s = KmpStoryPolarisTaskCoordinator.s(KmpStoryPolarisTaskCoordinator.this);
                        return s;
                    }
                });
            }
        }
        h N5 = cVar.N5();
        if (N5 != null && (pVar = this.d) != null) {
            coerceIn = RangesKt___RangesKt.coerceIn(N5.a, 0.0f, 1.0f);
            pVar.l(new e(coerceIn, N5.b, N5.c, v(N5.d), (ReaderProgressAnimationType) null, 16, (DefaultConstructorMarker) null));
        }
    }

    private final void t() {
        long coerceAtLeast;
        Job e;
        cp4.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        if (!cVar.na()) {
            this.c.setValue(Boolean.FALSE);
            return;
        }
        Job job = this.f;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            this.h = 0L;
            return;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(cVar.fa(), 1000L);
        this.h = 0L;
        e = i.e(this.e, null, null, new KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1(coerceAtLeast, this, cVar, null), 3, null);
        this.f = e;
    }

    public final void j() {
        cp4.c cVar;
        long j;
        p pVar;
        d dVar;
        if (this.n || this.o || !com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a() || (cVar = this.a) == null) {
            return;
        }
        boolean z = true;
        this.n = true;
        Long valueOf = Long.valueOf(cVar.getMaxPageReadingTimeMillis());
        if (valueOf.longValue() <= 0) {
            z = false;
        }
        if (!z) {
            valueOf = null;
        }
        if (valueOf != null) {
            j = valueOf.longValue();
        } else {
            j = 30000;
        }
        this.j = j;
        d dVar2 = this.b;
        if (dVar2 == null || (pVar = dVar2.da()) == null) {
            pVar = this.d;
        }
        this.d = pVar;
        if (pVar != null && (dVar = this.b) != null) {
            dVar.t3(pVar, this.m);
        }
        p pVar2 = this.d;
        if (pVar2 != null) {
            pVar2.j(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.polaris.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit k;
                    k = KmpStoryPolarisTaskCoordinator.k(KmpStoryPolarisTaskCoordinator.this);
                    return k;
                }
            });
        }
        cVar.Q4(this.g);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator) {
        kmpStoryPolarisTaskCoordinator.m();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator) {
        kmpStoryPolarisTaskCoordinator.m();
        return Unit.INSTANCE;
    }

    public final void x(int i) {
        d dVar;
        this.m = i;
        p pVar = this.d;
        if (pVar != null && (dVar = this.b) != null) {
            dVar.t3(pVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(boolean z) {
        Job job = this.f;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f = null;
        this.h = 0L;
        long j = this.i;
        if (j > 0) {
            cp4.c cVar = this.a;
            if (cVar != null) {
                cVar.r3(this.k, j, z);
            }
            this.i = 0L;
        }
    }

    private final ReaderProgressStatus v(StoryGoldBarStatus storyGoldBarStatus) {
        int i = a.a[storyGoldBarStatus.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return ReaderProgressStatus.HIDE_FINISH;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return ReaderProgressStatus.HIDE;
            }
            return ReaderProgressStatus.FINISH;
        }
        return ReaderProgressStatus.PROGRESS;
    }

    public final void w(String bookId, String chapterId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.k = bookId;
        this.l = chapterId;
    }
}
