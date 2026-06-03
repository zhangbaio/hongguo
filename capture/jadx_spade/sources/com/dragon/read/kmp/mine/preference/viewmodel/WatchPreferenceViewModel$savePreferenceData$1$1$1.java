package com.dragon.read.kmp.mine.preference.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.kmp.reading.model.UserPreferenceScene;
import com.bytedance.kmp.reading.model.bl0;
import com.bytedance.kmp.reading.model.xa0;
import com.bytedance.kmp.reading.model.ya0;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.j;
import ig4.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zm4.d;

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$savePreferenceData$1$1$1", f = "WatchPreferenceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferenceViewModel$savePreferenceData$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromDialog;
    final /* synthetic */ xa0 $setProfileResponse;
    final /* synthetic */ bl0 $userPreferenceSetResponse;
    int label;
    final /* synthetic */ WatchPreferenceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferenceViewModel$savePreferenceData$1$1$1(bl0 bl0Var, xa0 xa0Var, WatchPreferenceViewModel watchPreferenceViewModel, boolean z, Continuation<? super WatchPreferenceViewModel$savePreferenceData$1$1$1> continuation) {
        super(2, continuation);
        this.$userPreferenceSetResponse = bl0Var;
        this.$setProfileResponse = xa0Var;
        this.this$0 = watchPreferenceViewModel;
        this.$isFromDialog = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchPreferenceViewModel$savePreferenceData$1$1$1(this.$userPreferenceSetResponse, this.$setProfileResponse, this.this$0, this.$isFromDialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchPreferenceViewModel$savePreferenceData$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Integer num;
        String str;
        Integer num2;
        String str2;
        Integer num3;
        Integer num4;
        MutableState mutableState;
        MutableState mutableState2;
        Integer num5;
        SnapshotStateList snapshotStateList;
        SnapshotStateList snapshotStateList2;
        SnapshotStateList snapshotStateList3;
        MutableState mutableState3;
        MutableState mutableState4;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            bl0 bl0Var = this.$userPreferenceSetResponse;
            if (bl0Var != null && this.$setProfileResponse != null && (num3 = bl0Var.a) != null && num3.intValue() == 0 && (num4 = this.$setProfileResponse.a) != null && num4.intValue() == 0) {
                j.a.d("WatchPreferenceVideoModel", "savePreferenceData success");
                WatchPreferenceViewModel watchPreferenceViewModel = this.this$0;
                wj4.a aVar = watchPreferenceViewModel.b;
                mutableState = watchPreferenceViewModel.e;
                Object value = mutableState.getValue();
                mutableState2 = this.this$0.g;
                boolean z = !Intrinsics.areEqual(value, mutableState2.getValue());
                ya0 ya0Var = this.$setProfileResponse.c;
                if (ya0Var != null) {
                    num5 = ya0Var.a;
                } else {
                    num5 = null;
                }
                aVar.a(z, num5);
                snapshotStateList = this.this$0.f;
                snapshotStateList.clear();
                snapshotStateList2 = this.this$0.f;
                snapshotStateList3 = this.this$0.d;
                snapshotStateList2.addAll(snapshotStateList3);
                mutableState3 = this.this$0.g;
                mutableState4 = this.this$0.e;
                mutableState3.setValue(mutableState4.getValue());
                UserPreferenceScene userPreferenceScene = this.this$0.a.a;
                if (userPreferenceScene != UserPreferenceScene.my_read_preference && userPreferenceScene != UserPreferenceScene.single_col_category_select) {
                    g.b("已设置，可在「我的-看剧偏好」中修改", (ToastDuration) null, 2, (Object) null);
                } else {
                    g.b("偏好设置成功，将为你优化推荐内容", (ToastDuration) null, 2, (Object) null);
                }
                if (this.$isFromDialog) {
                    d.a.b();
                }
            } else {
                j jVar = j.a;
                StringBuilder sb = new StringBuilder();
                sb.append("savePreferenceData fail. userPreferenceSetResponse: {code:");
                bl0 bl0Var2 = this.$userPreferenceSetResponse;
                if (bl0Var2 != null) {
                    num = bl0Var2.a;
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", msg:");
                bl0 bl0Var3 = this.$userPreferenceSetResponse;
                if (bl0Var3 != null) {
                    str = bl0Var3.b;
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append("}, setProfileResponse: {code:");
                xa0 xa0Var = this.$setProfileResponse;
                if (xa0Var != null) {
                    num2 = xa0Var.a;
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(", msg:");
                xa0 xa0Var2 = this.$setProfileResponse;
                if (xa0Var2 != null) {
                    str2 = xa0Var2.b;
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append('}');
                jVar.d("WatchPreferenceVideoModel", sb.toString());
                g.b("保存失败，请点击重试", (ToastDuration) null, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
