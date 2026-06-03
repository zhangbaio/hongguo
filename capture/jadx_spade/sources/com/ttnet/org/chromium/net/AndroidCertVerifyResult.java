package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JNINamespace("net::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AndroidCertVerifyResult {
    private final int a;
    private final boolean b;
    private final List<X509Certificate> c;

    static {
        Covode.recordClassIndex(654424);
    }

    public int getStatus() {
        return this.a;
    }

    public boolean isIssuedByKnownRoot() {
        return this.b;
    }

    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.c.size()][];
        for (int i = 0; i < this.c.size(); i++) {
            try {
                bArr[i] = this.c.get(i).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0][];
            }
        }
        return bArr;
    }

    public AndroidCertVerifyResult(int i) {
        this.a = i;
        this.b = false;
        this.c = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.a = i;
        this.b = z;
        this.c = new ArrayList(list);
    }
}
