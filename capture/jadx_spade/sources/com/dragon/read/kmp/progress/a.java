package com.dragon.read.kmp.progress;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {

    static final class d implements Consumer {
        private final /* synthetic */ Function1 a;

        d(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.a = function;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object obj) {
            this.a.invoke(obj);
        }
    }

    static {
        Covode.recordClassIndex(608222);
    }

    /* renamed from: com.dragon.read.kmp.progress.a$a, reason: collision with other inner class name */
    static final class C0034a implements Function1<Throwable, Unit> {
        final /* synthetic */ Disposable a;

        C0034a(Disposable disposable) {
            this.a = disposable;
        }

        public final void a(Throwable th) {
            this.a.dispose();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class b<T> implements Function1<T, Unit> {
        final /* synthetic */ CancellableContinuation<T> a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super T> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }

        public final void a(T t) {
            if (t != null) {
                this.a.resumeWith(Result.m773constructorimpl(t));
                return;
            }
            CancellableContinuation<T> cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(new NullPointerException("Result is null"))));
        }
    }

    static final class c implements Function1<Throwable, Unit> {
        final /* synthetic */ CancellableContinuation<T> a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super T> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }

        public final void a(Throwable th) {
            Continuation continuation = this.a;
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(th);
            continuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object b(Observable<T> observable, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new C0034a(observable.firstElement().subscribe(new d(new b(cancellableContinuationImpl)), new d(new c(cancellableContinuationImpl)))));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
