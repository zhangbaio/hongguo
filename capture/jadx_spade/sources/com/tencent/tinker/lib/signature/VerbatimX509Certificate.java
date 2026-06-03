package com.tencent.tinker.lib.signature;

import com.bytedance.covode.number.Covode;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class VerbatimX509Certificate extends WrappedX509Certificate {
    private final byte[] mEncodedVerbatim;
    private int mHash;

    static {
        Covode.recordClassIndex(653813);
    }

    @Override // com.tencent.tinker.lib.signature.WrappedX509Certificate, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.mEncodedVerbatim;
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.mHash == -1) {
            try {
                this.mHash = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.mHash = 0;
            }
        }
        return this.mHash;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerbatimX509Certificate)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((VerbatimX509Certificate) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    VerbatimX509Certificate(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.mHash = -1;
        this.mEncodedVerbatim = bArr;
    }
}
