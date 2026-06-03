package com.vivo.push.listener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPushRequestListener<T, V> {
    void onFail(V v);

    void onSuccess(T t);
}
