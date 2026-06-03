package kotlinx.coroutines.reactive;

import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.z;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AwaitKt$awaitOne$2$1<T> implements Subscriber<T> {
    private Subscription a;
    private T b;
    private boolean c;
    private boolean d;
    final /* synthetic */ CancellableContinuation<T> e;
    final /* synthetic */ Mode f;
    final /* synthetic */ T g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Mode.SINGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Mode.SINGLE_OR_DEFAULT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public void onComplete() {
        if (!b("onComplete")) {
            return;
        }
        if (this.c) {
            Mode mode = this.f;
            if (mode != Mode.FIRST_OR_DEFAULT && mode != Mode.FIRST && this.e.isActive()) {
                CancellableContinuation<T> cancellableContinuation = this.e;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m773constructorimpl(this.b));
                return;
            }
            return;
        }
        Mode mode2 = this.f;
        if (mode2 != Mode.FIRST_OR_DEFAULT && mode2 != Mode.SINGLE_OR_DEFAULT) {
            if (this.e.isActive()) {
                CancellableContinuation<T> cancellableContinuation2 = this.e;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.f))));
                return;
            }
            return;
        }
        CancellableContinuation<T> cancellableContinuation3 = this.e;
        Result.Companion companion3 = Result.Companion;
        cancellableContinuation3.resumeWith(Result.m773constructorimpl(this.g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void c(Function0<Unit> function0) {
        function0.invoke();
    }

    private final boolean b(String str) {
        if (!this.d) {
            this.d = true;
            return true;
        }
        AwaitKt.g(this.e.getContext(), str);
        return false;
    }

    public void onError(Throwable th) {
        if (b("onError")) {
            CancellableContinuation<T> cancellableContinuation = this.e;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public void onSubscribe(final Subscription subscription) {
        if (this.a != null) {
            c(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    subscription.cancel();
                }
            });
            return;
        }
        this.a = subscription;
        this.e.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                AwaitKt$awaitOne$2$1 awaitKt$awaitOne$2$1 = AwaitKt$awaitOne$2$1.this;
                final Subscription subscription2 = subscription;
                awaitKt$awaitOne$2$1.c(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        subscription2.cancel();
                    }
                });
            }
        });
        final Mode mode = this.f;
        c(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                long j;
                Subscription subscription2 = subscription;
                Mode mode2 = mode;
                if (mode2 != Mode.FIRST && mode2 != Mode.FIRST_OR_DEFAULT) {
                    j = Long.MAX_VALUE;
                } else {
                    j = 1;
                }
                subscription2.request(j);
            }
        });
    }

    public void onNext(T t) {
        final Subscription subscription = this.a;
        CancellableContinuation<T> cancellableContinuation = this.e;
        if (subscription == null) {
            z.a(cancellableContinuation.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
            return;
        }
        if (!this.d) {
            int i = a.a[this.f.ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 || i == 4 || i == 5) {
                    Mode mode = this.f;
                    if ((mode == Mode.SINGLE || mode == Mode.SINGLE_OR_DEFAULT) && this.c) {
                        c(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onNext$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                subscription.cancel();
                            }
                        });
                        if (this.e.isActive()) {
                            CancellableContinuation<T> cancellableContinuation2 = this.e;
                            Result.Companion companion = Result.Companion;
                            cancellableContinuation2.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.f))));
                            return;
                        }
                        return;
                    }
                    this.b = t;
                    this.c = true;
                    return;
                }
                return;
            }
            if (!this.c) {
                this.c = true;
                c(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onNext$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        subscription.cancel();
                    }
                });
                this.e.resumeWith(Result.m773constructorimpl(t));
                return;
            }
            AwaitKt.h(this.e.getContext(), this.f);
            return;
        }
        AwaitKt.g(cancellableContinuation.getContext(), "onNext");
    }

    /* JADX WARN: Multi-variable type inference failed */
    AwaitKt$awaitOne$2$1(CancellableContinuation<? super T> cancellableContinuation, Mode mode, T t) {
        this.e = cancellableContinuation;
        this.f = mode;
        this.g = t;
    }
}
