package com.dragon.read.kmp.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AppUtils {
    public static final AppUtils a;

    static {
        Covode.recordClassIndex(609519);
        a = new AppUtils();
    }

    private AppUtils() {
    }

    public final boolean b() {
        ac4.f a2 = ac4.f.a0.a();
        if (a2 != null) {
            return a2.isOfficialBuild();
        }
        return true;
    }

    public final Context a() {
        Context b = ig4.f.b();
        if (b != null) {
            return b;
        }
        throw new IllegalStateException(" App has not been initialized !".toString());
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ IntentFilter a;
        final /* synthetic */ BroadcastReceiver b;

        a(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation<? super Unit> continuation) {
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if (this.a.hasAction(intent.getAction())) {
                    this.b.onReceive(AppUtils.a.a(), intent);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.content.Intent r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.utils.AppUtils$sendLocalBroadcast$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.utils.AppUtils$sendLocalBroadcast$1 r0 = (com.dragon.read.kmp.utils.AppUtils$sendLocalBroadcast$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.utils.AppUtils$sendLocalBroadcast$1 r0 = new com.dragon.read.kmp.utils.AppUtils$sendLocalBroadcast$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r6 = r0.Z$0
            java.lang.Object r5 = r0.L$0
            android.content.Intent r5 = (android.content.Intent) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.kmp_compat.com.ss.android.messagebus.BusProvider r7 = com.dragon.read.kmp.kmp_compat.com.ss.android.messagebus.BusProvider.a
            r0.L$0 = r5
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.c(r5, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            if (r6 == 0) goto L54
            com.dragon.read.kmp.service.z0 r6 = com.dragon.read.kmp.service.z0.a
            android.content.Context r7 = r4.a()
            r6.c(r7, r5)
        L54:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.AppUtils.c(android.content.Intent, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object registerReceiver(android.content.BroadcastReceiver r5, android.content.IntentFilter r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.utils.AppUtils$registerReceiver$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.utils.AppUtils$registerReceiver$1 r0 = (com.dragon.read.kmp.utils.AppUtils$registerReceiver$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.utils.AppUtils$registerReceiver$1 r0 = new com.dragon.read.kmp.utils.AppUtils$registerReceiver$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L48
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.kmp_compat.com.ss.android.messagebus.BusProvider r7 = com.dragon.read.kmp.kmp_compat.com.ss.android.messagebus.BusProvider.a
            kotlinx.coroutines.flow.SharedFlow r7 = r7.b()
            com.dragon.read.kmp.utils.AppUtils$a r2 = new com.dragon.read.kmp.utils.AppUtils$a
            r2.<init>(r6, r5)
            r0.label = r3
            java.lang.Object r5 = r7.collect(r2, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.AppUtils.registerReceiver(android.content.BroadcastReceiver, android.content.IntentFilter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object d(AppUtils appUtils, Intent intent, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appUtils.c(intent, z, continuation);
    }
}
