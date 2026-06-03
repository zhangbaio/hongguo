package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.w1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ThreadUtils {
    public static final ThreadUtils a;
    private static final Lazy b;
    private static final Lazy c;
    private static final CoroutineScope d;
    private static final Channel<Function1<Continuation<? super Unit>, Object>> e;
    private static final Channel<Unit> f;
    private static final xm6.e<a> g;
    public static final int h;

    private ThreadUtils() {
    }

    private final CoroutineScope f() {
        return (CoroutineScope) c.getValue();
    }

    private final CoroutineScope g() {
        return (CoroutineScope) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope h() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope i() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<Continuation<? super Unit>, Object> j() {
        xm6.e<a> eVar;
        a aVar;
        do {
            eVar = g;
            aVar = eVar.b;
            if (aVar == null) {
                return null;
            }
        } while (!eVar.a(aVar, aVar.b));
        return aVar.a;
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Covode.recordClassIndex(609572);
        a = new ThreadUtils();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.utils.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CoroutineScope i;
                i = ThreadUtils.i();
                return i;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.utils.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CoroutineScope h2;
                h2 = ThreadUtils.h();
                return h2;
            }
        });
        c = lazy2;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(w1.b("SerialThread")));
        d = CoroutineScope;
        e = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        f = ChannelKt.Channel$default(-1, null, null, 6, null);
        g = xm6.b.g(null);
        kotlinx.coroutines.i.e(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        h = 8;
    }

    public final void k(Function1<? super Continuation<? super Unit>, ? extends Object> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        e.mo1078trySendJP2dKIU(runnable);
    }

    public final void l(Function1<? super Continuation<? super Unit>, ? extends Object> runnable) {
        xm6.e<a> eVar;
        a aVar;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        do {
            eVar = g;
            aVar = eVar.b;
        } while (!eVar.a(aVar, new a(runnable, aVar)));
        f.mo1078trySendJP2dKIU(Unit.INSTANCE);
    }

    public final void m(Function1<? super Continuation<? super Unit>, ? extends Object> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        kotlinx.coroutines.i.e(g(), null, null, new ThreadUtils$postInForeground$1(runnable, null), 3, null);
    }

    public final void n(Function1<? super Continuation<? super Unit>, ? extends Object> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        kotlinx.coroutines.i.e(f(), null, null, new ThreadUtils$postInIO$1(runnable, null), 3, null);
    }

    public final void o(Function1<? super Continuation<? super Unit>, ? extends Object> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        kotlinx.coroutines.i.e(g(), Dispatchers.getMain().getImmediate(), null, new ThreadUtils$runInMain$1(runnable, null), 2, null);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.utils.ThreadUtils$1", f = "ThreadUtils.kt", i = {}, l = {44, 129}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.utils.ThreadUtils$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0034 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1d
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1d
            Lf:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L17:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L1b
                goto L20
            L1b:
                goto L20
            L1d:
                kotlin.ResultKt.throwOnFailure(r8)
            L20:
                r8 = r7
            L21:
                com.dragon.read.kmp.utils.ThreadUtils r1 = com.dragon.read.kmp.utils.ThreadUtils.a
                kotlin.jvm.functions.Function1 r1 = com.dragon.read.kmp.utils.ThreadUtils.e(r1)
                if (r1 == 0) goto L34
                r8.label = r3     // Catch: java.lang.Exception -> L32
                java.lang.Object r1 = r1.invoke(r8)     // Catch: java.lang.Exception -> L32
                if (r1 != r0) goto L21
                return r0
            L32:
                goto L21
            L34:
                kotlinx.coroutines.selects.SelectImplementation r1 = new kotlinx.coroutines.selects.SelectImplementation
                kotlin.coroutines.CoroutineContext r4 = r8.getContext()
                r1.<init>(r4)
                kotlinx.coroutines.channels.Channel r4 = com.dragon.read.kmp.utils.ThreadUtils.c()
                kotlinx.coroutines.selects.SelectClause1 r4 = r4.getOnReceive()
                com.dragon.read.kmp.utils.ThreadUtils$1$1$1 r5 = new com.dragon.read.kmp.utils.ThreadUtils$1$1$1
                r6 = 0
                r5.<init>(r6)
                r1.invoke(r4, r5)
                kotlinx.coroutines.channels.Channel r4 = com.dragon.read.kmp.utils.ThreadUtils.d()
                kotlinx.coroutines.selects.SelectClause1 r4 = r4.getOnReceive()
                com.dragon.read.kmp.utils.ThreadUtils$1$1$2 r5 = new com.dragon.read.kmp.utils.ThreadUtils$1$1$2
                r5.<init>(r6)
                r1.invoke(r4, r5)
                r8.label = r2
                java.lang.Object r1 = r1.doSelect(r8)
                if (r1 != r0) goto L21
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.ThreadUtils.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private static final class a {
        public final Function1<Continuation<? super Unit>, Object> a;
        public final a b;

        static {
            Covode.recordClassIndex(609573);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Continuation<? super Unit>, ? extends Object> task, a aVar) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.a = task;
            this.b = aVar;
        }
    }
}
