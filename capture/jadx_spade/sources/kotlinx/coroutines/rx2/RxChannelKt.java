package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import kotlinx.coroutines.channels.ReceiveChannel;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class RxChannelKt {
    static {
        Covode.recordClassIndex(659302);
    }

    public static final <T> ReceiveChannel<T> c(MaybeSource<T> maybeSource) {
        g gVar = new g();
        maybeSource.subscribe(gVar);
        return gVar;
    }

    public static final <T> ReceiveChannel<T> d(ObservableSource<T> observableSource) {
        g gVar = new g();
        observableSource.subscribe(gVar);
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:15:0x0065, B:17:0x006d, B:33:0x0078), top: B:14:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:15:0x0065, B:17:0x006d, B:33:0x0078), top: B:14:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0061 -> B:13:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(io.reactivex.MaybeSource<T> r5, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxChannelKt$collect$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.rx2.RxChannelKt$collect$1 r0 = (kotlinx.coroutines.rx2.RxChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.rx2.RxChannelKt$collect$1 r0 = new kotlinx.coroutines.rx2.RxChannelKt$collect$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3a
            r4 = r0
            r0 = r6
            r6 = r2
        L37:
            r2 = r1
            r1 = r4
            goto L65
        L3a:
            r5 = move-exception
            goto L91
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = c(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L8d
            r4 = r7
            r7 = r5
            r5 = r4
        L52:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L8a
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L8a
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L8a
            r0.label = r3     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r2 = r5.a(r0)     // Catch: java.lang.Throwable -> L8a
            if (r2 != r1) goto L61
            return r1
        L61:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L37
        L65:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L87
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L87
            if (r7 == 0) goto L78
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L87
            r6.invoke(r7)     // Catch: java.lang.Throwable -> L87
            r7 = r0
            r0 = r1
            r1 = r2
            goto L52
        L78:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L87
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.e.b(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L87:
            r5 = move-exception
            r6 = r0
            goto L91
        L8a:
            r5 = move-exception
            r6 = r7
            goto L91
        L8d:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L91:
            throw r5     // Catch: java.lang.Throwable -> L92
        L92:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.e.b(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.a(io.reactivex.MaybeSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:15:0x0065, B:17:0x006d, B:33:0x0078), top: B:14:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:15:0x0065, B:17:0x006d, B:33:0x0078), top: B:14:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0061 -> B:13:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(io.reactivex.ObservableSource<T> r5, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxChannelKt$collect$2
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.rx2.RxChannelKt$collect$2 r0 = (kotlinx.coroutines.rx2.RxChannelKt$collect$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.rx2.RxChannelKt$collect$2 r0 = new kotlinx.coroutines.rx2.RxChannelKt$collect$2
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3a
            r4 = r0
            r0 = r6
            r6 = r2
        L37:
            r2 = r1
            r1 = r4
            goto L65
        L3a:
            r5 = move-exception
            goto L91
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = d(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L8d
            r4 = r7
            r7 = r5
            r5 = r4
        L52:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L8a
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L8a
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L8a
            r0.label = r3     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r2 = r5.a(r0)     // Catch: java.lang.Throwable -> L8a
            if (r2 != r1) goto L61
            return r1
        L61:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L37
        L65:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L87
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L87
            if (r7 == 0) goto L78
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L87
            r6.invoke(r7)     // Catch: java.lang.Throwable -> L87
            r7 = r0
            r0 = r1
            r1 = r2
            goto L52
        L78:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L87
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.e.b(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L87:
            r5 = move-exception
            r6 = r0
            goto L91
        L8a:
            r5 = move-exception
            r6 = r7
            goto L91
        L8d:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L91:
            throw r5     // Catch: java.lang.Throwable -> L92
        L92:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.e.b(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxChannelKt.b(io.reactivex.ObservableSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
