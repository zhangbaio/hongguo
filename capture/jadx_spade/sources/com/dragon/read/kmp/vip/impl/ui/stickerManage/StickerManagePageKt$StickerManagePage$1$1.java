package com.dragon.read.kmp.vip.impl.ui.stickerManage;

import androidx.compose.runtime.MutableState;
import com.bytedance.kmp.ugc.model.l20;
import com.bytedance.kmp.ugc.model.rd;
import com.bytedance.kmp.ugc.model.sd;
import com.bytedance.kmp.ugc.model.yu;
import com.dragon.read.kmp.j;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.vip.impl.ui.stickerManage.StickerManagePageKt$StickerManagePage$1$1", f = "StickerManagePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StickerManagePageKt$StickerManagePage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $params;
    final /* synthetic */ MutableState<yu> $selectedStickerState$delegate;
    final /* synthetic */ MutableState<List<yu>> $stickerListState$delegate;
    final /* synthetic */ MutableState<l20> $userStickerState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StickerManagePageKt$StickerManagePage$1$1(c cVar, MutableState<List<yu>> mutableState, MutableState<l20> mutableState2, MutableState<yu> mutableState3, Continuation<? super StickerManagePageKt$StickerManagePage$1$1> continuation) {
        super(2, continuation);
        this.$stickerListState$delegate = mutableState;
        this.$userStickerState$delegate = mutableState2;
        this.$selectedStickerState$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagePageKt$StickerManagePage$1$1(null, this.$stickerListState$delegate, this.$userStickerState$delegate, this.$selectedStickerState$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StickerManagePageKt$StickerManagePage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    private static final Unit invokeSuspend$lambda$2(Throwable th) {
        j jVar = j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("init-LaunchedEffect-error ");
        th.printStackTrace();
        Unit unit = Unit.INSTANCE;
        sb.append(unit);
        jVar.d("StickerManagePage", sb.toString());
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        d dVar = d.a;
        throw null;
    }

    private static final Unit invokeSuspend$lambda$0(c cVar, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, sd sdVar) {
        List emptyList;
        l20 l20Var;
        l20 d;
        boolean z;
        List<yu> b;
        l20 d2;
        int i;
        yu yuVar;
        Integer num;
        rd rdVar = sdVar.c;
        if (rdVar == null || (emptyList = rdVar.a) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        b.c(mutableState, emptyList);
        rd rdVar2 = sdVar.c;
        if (rdVar2 != null) {
            l20Var = rdVar2.b;
        } else {
            l20Var = null;
        }
        b.e(mutableState2, l20Var);
        d = b.d(mutableState2);
        if (d != null) {
            z = Intrinsics.areEqual(d.c, Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            a aVar = a.a;
            b = b.b(mutableState);
            d2 = b.d(mutableState2);
            if (d2 != null && (yuVar = d2.a) != null && (num = yuVar.a) != null) {
                i = num.intValue();
            } else {
                i = -1;
            }
            b.a(mutableState3, aVar.a(b, i));
            throw null;
        }
        throw null;
    }
}
