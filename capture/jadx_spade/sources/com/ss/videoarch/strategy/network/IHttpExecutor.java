package com.ss.videoarch.strategy.network;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IHttpExecutor {
    String executeGet(String str) throws Exception;

    String executePost(String str, byte[] bArr, String str2, String str3) throws Exception;
}
