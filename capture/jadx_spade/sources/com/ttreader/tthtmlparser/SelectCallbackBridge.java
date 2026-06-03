package com.ttreader.tthtmlparser;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ttreader.tthtmlparser.highlight.SelectionState;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SelectCallbackBridge {
    private final Handler handler;
    private final ISelectCallback selectCallback;

    static {
        Covode.recordClassIndex(654723);
    }

    public SelectCallbackBridge(ISelectCallback selectCallback) {
        Intrinsics.checkNotNullParameter(selectCallback, "selectCallback");
        this.selectCallback = selectCallback;
        this.handler = new HandlerDelegate(Looper.getMainLooper());
    }

    private final void onSelectionChange(int i) {
        final SelectionState selectionState;
        boolean z = false;
        if (1 <= i && i < SelectionState.values().length) {
            z = true;
        }
        if (z) {
            selectionState = SelectionState.values()[i];
        } else {
            selectionState = SelectionState.NORMAL;
        }
        this.handler.post(new Runnable() { // from class: com.ttreader.tthtmlparser.a
            @Override // java.lang.Runnable
            public final void run() {
                SelectCallbackBridge.onSelectionChange$lambda$0(SelectCallbackBridge.this, selectionState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectionChange$lambda$0(SelectCallbackBridge selectCallbackBridge, SelectionState selectionState) {
        selectCallbackBridge.selectCallback.onSelectionChange(selectionState);
    }
}
