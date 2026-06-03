package com.vivo.push.restructure.request;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPushRequestCallback<T> {
    void onError(int i);

    void onSuccess(T t);
}
