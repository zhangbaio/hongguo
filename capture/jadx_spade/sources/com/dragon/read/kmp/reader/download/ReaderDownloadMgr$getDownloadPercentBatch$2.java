package com.dragon.read.kmp.reader.download;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getDownloadPercentBatch$2", f = "ReaderDownloadMgr.kt", i = {}, l = {732}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$getDownloadPercentBatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, Double>>, Object> {
    final /* synthetic */ List<String> $bookIdList;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$getDownloadPercentBatch$2(List<String> list, Continuation<? super ReaderDownloadMgr$getDownloadPercentBatch$2> continuation) {
        super(2, continuation);
        this.$bookIdList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReaderDownloadMgr$getDownloadPercentBatch$2(this.$bookIdList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HashMap<String, Double>> continuation) {
        return ((ReaderDownloadMgr$getDownloadPercentBatch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String M;
        com.dragon.read.kmp.i iVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ReaderDownloadMgr readerDownloadMgr = ReaderDownloadMgr.a;
            M = readerDownloadMgr.M();
            List<String> list = this.$bookIdList;
            this.label = 1;
            obj = readerDownloadMgr.L(M, list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Map map = (Map) obj;
        HashMap hashMap = new HashMap();
        if (!map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                double doubleValue = ((Number) entry.getValue()).doubleValue();
                String substring = str.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "t", 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                hashMap.put(substring, Boxing.boxDouble(doubleValue));
            }
        }
        iVar = ReaderDownloadMgr.h;
        iVar.d("批量查询进度成功: " + hashMap);
        return hashMap;
    }
}
