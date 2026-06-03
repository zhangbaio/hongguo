package com.dragon.read.kmp.reader.font.manager;

import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDataManager$preloadFontDataList$1", f = "FontDataManager.kt", i = {}, l = {84, DataLoaderHelper.DATALOADER_KEY_INT_ENABLE_P2P_STRAGETY_CONTROL}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDataManager$preloadFontDataList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    FontDataManager$preloadFontDataList$1(Continuation<? super FontDataManager$preloadFontDataList$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDataManager$preloadFontDataList$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontDataManager$preloadFontDataList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0095 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L13
            goto La0
        L13:
            r7 = move-exception
            goto L96
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L22
            goto L54
        L22:
            r7 = move-exception
            goto L81
        L24:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.font.manager.FontDataManager.d()     // Catch: java.lang.Exception -> L22
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L22
            r1.<init>()     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = "data source:"
            r1.append(r4)     // Catch: java.lang.Exception -> L22
            com.dragon.read.kmp.reader.font.manager.FontDataManager r4 = com.dragon.read.kmp.reader.font.manager.FontDataManager.a     // Catch: java.lang.Exception -> L22
            com.dragon.read.kmp.reader.font.manager.h r5 = com.dragon.read.kmp.reader.font.manager.FontDataManager.c(r4)     // Catch: java.lang.Exception -> L22
            r1.append(r5)     // Catch: java.lang.Exception -> L22
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L22
            r7.d(r1)     // Catch: java.lang.Exception -> L22
            com.dragon.read.kmp.reader.font.manager.h r7 = com.dragon.read.kmp.reader.font.manager.FontDataManager.c(r4)     // Catch: java.lang.Exception -> L22
            if (r7 == 0) goto L8b
            r6.label = r3     // Catch: java.lang.Exception -> L22
            java.lang.Object r7 = r7.b(r6)     // Catch: java.lang.Exception -> L22
            if (r7 != r0) goto L54
            return r0
        L54:
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> L22
            if (r7 == 0) goto L8b
            com.dragon.read.kmp.i r1 = com.dragon.read.kmp.reader.font.manager.FontDataManager.d()     // Catch: java.lang.Exception -> L22
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L22
            r4.<init>()     // Catch: java.lang.Exception -> L22
            java.lang.String r5 = "data source get local font config:"
            r4.append(r5)     // Catch: java.lang.Exception -> L22
            r4.append(r7)     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L22
            r1.d(r4)     // Catch: java.lang.Exception -> L22
            boolean r1 = r7.isEmpty()     // Catch: java.lang.Exception -> L22
            r1 = r1 ^ r3
            if (r1 == 0) goto L8b
            com.dragon.read.kmp.reader.font.manager.FontDataManager r1 = com.dragon.read.kmp.reader.font.manager.FontDataManager.a     // Catch: java.lang.Exception -> L22
            java.util.List r7 = kotlin.collections.CollectionsKt.toMutableList(r7)     // Catch: java.lang.Exception -> L22
            com.dragon.read.kmp.reader.font.manager.FontDataManager.g(r1, r7)     // Catch: java.lang.Exception -> L22
            goto L8b
        L81:
            com.dragon.read.kmp.i r1 = com.dragon.read.kmp.reader.font.manager.FontDataManager.d()
            java.lang.String r3 = "预加载：获取本地字体缓存失败"
            r1.b(r3, r7)
        L8b:
            com.dragon.read.kmp.reader.font.manager.FontDataManager r7 = com.dragon.read.kmp.reader.font.manager.FontDataManager.a     // Catch: java.lang.Exception -> L13
            r6.label = r2     // Catch: java.lang.Exception -> L13
            java.lang.Object r7 = com.dragon.read.kmp.reader.font.manager.FontDataManager.f(r7, r6)     // Catch: java.lang.Exception -> L13
            if (r7 != r0) goto La0
            return r0
        L96:
            com.dragon.read.kmp.i r0 = com.dragon.read.kmp.reader.font.manager.FontDataManager.d()
            java.lang.String r1 = "预加载：获取远程字体失败"
            r0.b(r1, r7)
        La0:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.manager.FontDataManager$preloadFontDataList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
