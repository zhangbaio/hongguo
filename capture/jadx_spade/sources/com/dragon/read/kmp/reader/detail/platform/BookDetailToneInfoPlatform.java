package com.dragon.read.kmp.reader.detail.platform;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel;
import io.reactivex.disposables.Disposable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailToneInfoPlatform {
    public static final BookDetailToneInfoPlatform a;

    static {
        Covode.recordClassIndex(608390);
        a = new BookDetailToneInfoPlatform();
    }

    private BookDetailToneInfoPlatform() {
    }

    static final class a implements Function1<RelativeToneModel, Unit> {
        final /* synthetic */ CancellableContinuation<RelativeToneModel> a;

        a(CancellableContinuation<? super RelativeToneModel> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RelativeToneModel relativeToneModel) {
            a(relativeToneModel);
            return Unit.INSTANCE;
        }

        public final void a(RelativeToneModel relativeToneModel) {
            if (this.a.isActive()) {
                this.a.resumeWith(Result.m773constructorimpl(relativeToneModel));
            }
        }
    }

    static final class b implements Function1<Throwable, Unit> {
        final /* synthetic */ CancellableContinuation<RelativeToneModel> a;

        b(CancellableContinuation<? super RelativeToneModel> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }

        public final void a(Throwable th) {
            if (this.a.isActive()) {
                CancellableContinuation<RelativeToneModel> cancellableContinuation = this.a;
                Result.Companion companion = Result.Companion;
                Intrinsics.checkNotNull(th);
                cancellableContinuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(th)));
            }
        }
    }

    static final class c implements Function1<Throwable, Unit> {
        final /* synthetic */ Ref$ObjectRef<Disposable> a;

        c(Ref$ObjectRef<Disposable> ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }

        public final void a(Throwable th) {
            this.a.element.dispose();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, io.reactivex.disposables.Disposable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r10, boolean r11, kotlin.coroutines.Continuation<? super com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$requestRelativeToneModel$1
            if (r0 == 0) goto L13
            r0 = r12
            com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$requestRelativeToneModel$1 r0 = (com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$requestRelativeToneModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$requestRelativeToneModel$1 r0 = new com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$requestRelativeToneModel$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L33
            goto Lae
        L33:
            r11 = move-exception
            goto Lb3
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.ResultKt.throwOnFailure(r12)
            android.app.Application r12 = com.dragon.read.app.App.context()
            r2 = 2131104974(0x7f0614ce, float:1.7822458E38)
            java.lang.String r12 = r12.getString(r2)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            r0.L$0 = r10     // Catch: java.lang.Throwable -> Lb1
            r0.L$1 = r12     // Catch: java.lang.Throwable -> Lb1
            r0.Z$0 = r11     // Catch: java.lang.Throwable -> Lb1
            r0.label = r4     // Catch: java.lang.Throwable -> Lb1
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> Lb1
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch: java.lang.Throwable -> Lb1
            r2.<init>(r5, r4)     // Catch: java.lang.Throwable -> Lb1
            r2.initCancellability()     // Catch: java.lang.Throwable -> Lb1
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> Lb1
            r5.<init>()     // Catch: java.lang.Throwable -> Lb1
            com.dragon.read.component.audio.api.NsAudioModuleApi r6 = com.dragon.read.component.audio.api.NsAudioModuleApi.IMPL     // Catch: java.lang.Throwable -> Lb1
            xs2.r r6 = r6.requestToneInfo()     // Catch: java.lang.Throwable -> Lb1
            if (r11 == 0) goto L74
            r11 = 1
            goto L75
        L74:
            r11 = 0
        L75:
            io.reactivex.Single r10 = r6.a(r10, r11)     // Catch: java.lang.Throwable -> Lb1
            com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$a r11 = new com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$a     // Catch: java.lang.Throwable -> Lb1
            r11.<init>(r2)     // Catch: java.lang.Throwable -> Lb1
            com.dragon.read.kmp.reader.detail.platform.l r6 = new com.dragon.read.kmp.reader.detail.platform.l     // Catch: java.lang.Throwable -> Lb1
            r6.<init>(r11)     // Catch: java.lang.Throwable -> Lb1
            com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$b r11 = new com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$b     // Catch: java.lang.Throwable -> Lb1
            r11.<init>(r2)     // Catch: java.lang.Throwable -> Lb1
            com.dragon.read.kmp.reader.detail.platform.l r7 = new com.dragon.read.kmp.reader.detail.platform.l     // Catch: java.lang.Throwable -> Lb1
            r7.<init>(r11)     // Catch: java.lang.Throwable -> Lb1
            io.reactivex.disposables.Disposable r10 = r10.subscribe(r6, r7)     // Catch: java.lang.Throwable -> Lb1
            r5.element = r10     // Catch: java.lang.Throwable -> Lb1
            com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$c r10 = new com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform$c     // Catch: java.lang.Throwable -> Lb1
            r10.<init>(r5)     // Catch: java.lang.Throwable -> Lb1
            r2.invokeOnCancellation(r10)     // Catch: java.lang.Throwable -> Lb1
            java.lang.Object r10 = r2.getResult()     // Catch: java.lang.Throwable -> Lb1
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Throwable -> Lb1
            if (r10 != r11) goto La8
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch: java.lang.Throwable -> Lb1
        La8:
            if (r10 != r1) goto Lab
            return r1
        Lab:
            r8 = r12
            r12 = r10
            r10 = r8
        Lae:
            com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel r12 = (com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel) r12     // Catch: java.lang.Throwable -> L33
            return r12
        Lb1:
            r11 = move-exception
            r10 = r12
        Lb3:
            java.lang.String r12 = r11.getMessage()
            if (r12 == 0) goto Lbf
            int r0 = r12.length()
            if (r0 != 0) goto Lc0
        Lbf:
            r3 = 1
        Lc0:
            if (r3 != 0) goto Lce
            boolean r12 = android.text.TextUtils.equals(r12, r10)
            if (r12 == 0) goto Lce
            com.dragon.read.kmp.reader.detail.platform.BookDetailNoAudioSourceException r11 = new com.dragon.read.kmp.reader.detail.platform.BookDetailNoAudioSourceException
            r11.<init>(r10)
            throw r11
        Lce:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform.a(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(BookDetailToneInfoPlatform bookDetailToneInfoPlatform, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return bookDetailToneInfoPlatform.a(str, z, continuation);
    }
}
