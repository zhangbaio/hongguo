package com.dragon.read.kmp.vip.impl.ui.stickerManage;

import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.l20;
import com.bytedance.kmp.ugc.model.yu;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609617);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<yu> b(MutableState<List<yu>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l20 d(MutableState<l20> mutableState) {
        return (l20) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MutableState<yu> mutableState, yu yuVar) {
        mutableState.setValue(yuVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState<List<yu>> mutableState, List<yu> list) {
        mutableState.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableState<l20> mutableState, l20 l20Var) {
        mutableState.setValue(l20Var);
    }
}
