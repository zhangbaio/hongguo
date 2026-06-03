package com.tencent.tauth;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);

    void onWarning(int i);
}
