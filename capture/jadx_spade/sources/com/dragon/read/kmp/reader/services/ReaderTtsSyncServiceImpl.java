package com.dragon.read.kmp.reader.services;

import android.app.Activity;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.router.SmartRoute;
import com.bytedance.router.SmartRouter;
import com.dragon.read.reader.services.t0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderTtsSyncServiceImpl implements o {
    public static final ReaderTtsSyncServiceImpl a;

    static {
        Covode.recordClassIndex(608563);
        a = new ReaderTtsSyncServiceImpl();
    }

    private ReaderTtsSyncServiceImpl() {
    }

    @Override // com.dragon.read.kmp.reader.services.o
    public boolean c(String str) {
        return t0.a.c(str);
    }

    @Override // com.dragon.read.kmp.reader.services.o
    public void e(cm4.i reader, String str) {
        Activity activity;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Context b = reader.b();
        if (b instanceof Activity) {
            activity = (Activity) b;
        } else {
            activity = null;
        }
        if (activity == null || str == null) {
            return;
        }
        SmartRoute buildRoute = SmartRouter.buildRoute(activity, "//audioDetail");
        buildRoute.withParam("originBookId", str);
        buildRoute.open();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ac A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.dragon.read.kmp.reader.services.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(im4.b r25, kotlin.coroutines.Continuation<? super im4.a> r26) {
        /*
            r24 = this;
            r0 = r25
            r1 = r26
            boolean r2 = r1 instanceof com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1
            if (r2 == 0) goto L19
            r2 = r1
            com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1 r2 = (com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r24
            goto L20
        L19:
            com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1 r2 = new com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1
            r3 = r24
            r2.<init>(r3, r1)
        L20:
            java.lang.Object r1 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            r6 = 1
            if (r5 == 0) goto L39
            if (r5 != r6) goto L31
            kotlin.ResultKt.throwOnFailure(r1)
            goto L6f
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.throwOnFailure(r1)
            nt2.c r1 = new nt2.c
            java.lang.String r8 = r0.a
            java.lang.String r9 = r0.b
            long r10 = r0.c
            boolean r12 = r0.d
            boolean r13 = r0.e
            java.lang.String r14 = r0.f
            java.lang.String r15 = r0.g
            boolean r5 = r0.h
            java.lang.String r7 = r0.i
            r17 = r7
            r7 = r1
            r16 = r5
            r7.<init>(r8, r9, r10, r12, r13, r14, r15, r16, r17)
            boolean r5 = r0.j
            r1.k = r5
            boolean r0 = r0.k
            r1.l = r0
            com.dragon.read.reader.services.t0 r0 = com.dragon.read.reader.services.t0.a
            io.reactivex.Observable r0 = r0.m(r1)
            r2.label = r6
            java.lang.Object r1 = kotlinx.coroutines.rx2.RxAwaitKt.b(r0, r2)
            if (r1 != r4) goto L6f
            return r4
        L6f:
            com.dragon.read.component.audio.data.audiosync.AudioSyncReaderModel r1 = (com.dragon.read.component.audio.data.audiosync.AudioSyncReaderModel) r1
            if (r1 == 0) goto Lac
            im4.a r0 = new im4.a
            r4 = r0
            long r5 = r1.startTime
            long r7 = r1.endTime
            int r9 = r1.startPara
            int r10 = r1.startParaOff
            int r11 = r1.endPara
            int r12 = r1.endParaOff
            java.lang.String r13 = r1.audioItemId
            java.lang.String r14 = r1.novelItemId
            boolean r15 = r1.isTitle
            int r2 = r1.startContainerId
            r16 = r2
            int r2 = r1.startElementIndex
            r17 = r2
            int r2 = r1.startElementOffset
            r18 = r2
            int r2 = r1.endContainerId
            r19 = r2
            int r2 = r1.endElementIndex
            r20 = r2
            int r2 = r1.endElementOffset
            r21 = r2
            int r2 = r1.startElementOrder
            r22 = r2
            int r1 = r1.endElementOrder
            r23 = r1
            r4.<init>(r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            goto Lad
        Lac:
            r0 = 0
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl.d(im4.b, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
