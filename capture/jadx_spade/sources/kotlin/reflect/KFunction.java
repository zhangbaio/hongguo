package kotlin.reflect;

import kotlin.Function;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KFunction<R> extends KCallable<R>, Function<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();
}
