package com.tencent.mm.opensdk.diffdev;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}
