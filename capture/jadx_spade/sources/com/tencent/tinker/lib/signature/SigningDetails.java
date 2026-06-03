package com.tencent.tinker.lib.signature;

import android.content.pm.Signature;
import android.util.ArraySet;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.hidden.p.HackHelper;
import com.tencent.tinker.lib.utils.ArrayUtils;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class SigningDetails {
    public static final SigningDetails UNKNOWN;
    public final Signature[] pastSigningCertificates;
    public final int[] pastSigningCertificatesFlags;
    public final ArraySet<PublicKey> publicKeys;
    public final int signatureSchemeVersion;
    public final Signature[] signatures;

    public @interface CertCapabilities {
    }

    public @interface SignatureSchemeVersion {
    }

    private static Object com_tencent_tinker_lib_signature_SigningDetails_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) throws CertificateException {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public boolean hasPastSigningCertificates() {
        Signature[] signatureArr = this.pastSigningCertificates;
        if (signatureArr != null && signatureArr.length > 0) {
            return true;
        }
        return false;
    }

    public boolean hasSignatures() {
        Signature[] signatureArr = this.signatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return true;
        }
        return false;
    }

    public static class Builder {
        private Signature[] mPastSigningCertificates;
        private int[] mPastSigningCertificatesFlags;
        private int mSignatureSchemeVersion = 0;
        private Signature[] mSignatures;

        static {
            Covode.recordClassIndex(653810);
        }

        public SigningDetails build() throws CertificateException {
            checkInvariants();
            return new SigningDetails(this.mSignatures, this.mSignatureSchemeVersion, this.mPastSigningCertificates, this.mPastSigningCertificatesFlags);
        }

        private void checkInvariants() {
            int[] iArr;
            if (this.mSignatures != null) {
                Signature[] signatureArr = this.mPastSigningCertificates;
                boolean z = true;
                if (signatureArr == null || (iArr = this.mPastSigningCertificatesFlags) == null ? !(signatureArr != null || this.mPastSigningCertificatesFlags != null) : signatureArr.length == iArr.length) {
                    z = false;
                }
                if (!z) {
                    return;
                } else {
                    throw new IllegalStateException("SigningDetails must have a one to one mapping between pastSigningCertificates and pastSigningCertificatesFlags");
                }
            }
            throw new IllegalStateException("SigningDetails requires the current signing certificates.");
        }

        public Builder setPastSigningCertificates(Signature[] signatureArr) {
            this.mPastSigningCertificates = signatureArr;
            return this;
        }

        public Builder setPastSigningCertificatesFlags(int[] iArr) {
            this.mPastSigningCertificatesFlags = iArr;
            return this;
        }

        public Builder setSignatureSchemeVersion(int i) {
            this.mSignatureSchemeVersion = i;
            return this;
        }

        public Builder setSignatures(Signature[] signatureArr) {
            this.mSignatures = signatureArr;
            return this;
        }
    }

    static {
        Covode.recordClassIndex(653809);
        UNKNOWN = new SigningDetails(null, 0, null, null, null);
    }

    public int hashCode() {
        int i;
        int hashCode = ((Arrays.hashCode(this.signatures) * 31) + this.signatureSchemeVersion) * 31;
        ArraySet<PublicKey> arraySet = this.publicKeys;
        if (arraySet != null) {
            i = arraySet.hashCode();
        } else {
            i = 0;
        }
        return ((((hashCode + i) * 31) + Arrays.hashCode(this.pastSigningCertificates)) * 31) + Arrays.hashCode(this.pastSigningCertificatesFlags);
    }

    public boolean hasCertificate(Signature signature) {
        return hasCertificateInternal(signature, 0);
    }

    public boolean signaturesMatchExactly(SigningDetails signingDetails) {
        return areExactMatch(this.signatures, signingDetails.signatures);
    }

    public boolean hasAncestorOrSelf(SigningDetails signingDetails) {
        SigningDetails signingDetails2 = UNKNOWN;
        if (this == signingDetails2 || signingDetails == signingDetails2) {
            return false;
        }
        Signature[] signatureArr = signingDetails.signatures;
        if (signatureArr.length > 1) {
            return signaturesMatchExactly(signingDetails);
        }
        return hasCertificate(signatureArr[0]);
    }

    public boolean hasCertificate(byte[] bArr) {
        return hasCertificate(new Signature(bArr));
    }

    public static ArraySet<PublicKey> toSigningKeys(Signature[] signatureArr) throws CertificateException {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = HackHelper.getMethod(Signature.class, "getPublicKey", new Class[0]);
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) com_tencent_tinker_lib_signature_SigningDetails_java_lang_reflect_Method_invoke(method, signature, new Object[0]));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public boolean hasAncestor(SigningDetails signingDetails) {
        SigningDetails signingDetails2 = UNKNOWN;
        if (this != signingDetails2 && signingDetails != signingDetails2 && hasPastSigningCertificates() && signingDetails.signatures.length == 1) {
            int i = 0;
            while (true) {
                Signature[] signatureArr = this.pastSigningCertificates;
                if (i >= signatureArr.length - 1) {
                    break;
                }
                if (signatureArr[i].equals(signingDetails.signatures[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public SigningDetails(SigningDetails signingDetails) {
        if (signingDetails != null) {
            Signature[] signatureArr = signingDetails.signatures;
            if (signatureArr != null) {
                this.signatures = (Signature[]) signatureArr.clone();
            } else {
                this.signatures = null;
            }
            this.signatureSchemeVersion = signingDetails.signatureSchemeVersion;
            this.publicKeys = new ArraySet<>((ArraySet) signingDetails.publicKeys);
            Signature[] signatureArr2 = signingDetails.pastSigningCertificates;
            if (signatureArr2 != null) {
                this.pastSigningCertificates = (Signature[]) signatureArr2.clone();
                this.pastSigningCertificatesFlags = (int[]) signingDetails.pastSigningCertificatesFlags.clone();
                return;
            } else {
                this.pastSigningCertificates = null;
                this.pastSigningCertificatesFlags = null;
                return;
            }
        }
        this.signatures = null;
        this.signatureSchemeVersion = 0;
        this.publicKeys = null;
        this.pastSigningCertificates = null;
        this.pastSigningCertificatesFlags = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SigningDetails)) {
            return false;
        }
        SigningDetails signingDetails = (SigningDetails) obj;
        if (this.signatureSchemeVersion != signingDetails.signatureSchemeVersion || !areExactMatch(this.signatures, signingDetails.signatures)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.publicKeys;
        if (arraySet != null) {
            if (!arraySet.equals(signingDetails.publicKeys)) {
                return false;
            }
        } else if (signingDetails.publicKeys != null) {
            return false;
        }
        if (Arrays.equals(this.pastSigningCertificates, signingDetails.pastSigningCertificates) && Arrays.equals(this.pastSigningCertificatesFlags, signingDetails.pastSigningCertificatesFlags)) {
            return true;
        }
        return false;
    }

    public SigningDetails(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public boolean hasCertificate(Signature signature, int i) {
        return hasCertificateInternal(signature, i);
    }

    public static boolean areEffectiveMatch(Signature signature, Signature signature2) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return bounce(certificateFactory, signature).equals(bounce(certificateFactory, signature2));
    }

    public static boolean areExactMatch(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr.length == signatureArr2.length && ArrayUtils.containsAll(signatureArr, signatureArr2) && ArrayUtils.containsAll(signatureArr2, signatureArr)) {
            return true;
        }
        return false;
    }

    public boolean checkCapability(SigningDetails signingDetails, int i) {
        SigningDetails signingDetails2 = UNKNOWN;
        if (this == signingDetails2 || signingDetails == signingDetails2) {
            return false;
        }
        Signature[] signatureArr = signingDetails.signatures;
        if (signatureArr.length > 1) {
            return signaturesMatchExactly(signingDetails);
        }
        return hasCertificate(signatureArr[0], i);
    }

    public static boolean areEffectiveMatch(Signature[] signatureArr, Signature[] signatureArr2) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Signature[] signatureArr3 = new Signature[signatureArr.length];
        for (int i = 0; i < signatureArr.length; i++) {
            signatureArr3[i] = bounce(certificateFactory, signatureArr[i]);
        }
        Signature[] signatureArr4 = new Signature[signatureArr2.length];
        for (int i2 = 0; i2 < signatureArr2.length; i2++) {
            signatureArr4[i2] = bounce(certificateFactory, signatureArr2[i2]);
        }
        return areExactMatch(signatureArr3, signatureArr4);
    }

    private boolean hasCertificateInternal(Signature signature, int i) {
        if (this == UNKNOWN) {
            return false;
        }
        if (hasPastSigningCertificates()) {
            int i2 = 0;
            while (true) {
                Signature[] signatureArr = this.pastSigningCertificates;
                if (i2 >= signatureArr.length - 1) {
                    break;
                }
                if (!signatureArr[i2].equals(signature) || (i != 0 && (this.pastSigningCertificatesFlags[i2] & i) != i)) {
                    i2++;
                }
            }
            return true;
        }
        Signature[] signatureArr2 = this.signatures;
        if (signatureArr2.length != 1 || !signatureArr2[0].equals(signature)) {
            return false;
        }
        return true;
    }

    public boolean checkCapabilityRecover(SigningDetails signingDetails, int i) throws CertificateException {
        SigningDetails signingDetails2 = UNKNOWN;
        if (signingDetails == signingDetails2 || this == signingDetails2) {
            return false;
        }
        if (hasPastSigningCertificates() && signingDetails.signatures.length == 1) {
            int i2 = 0;
            while (true) {
                Signature[] signatureArr = this.pastSigningCertificates;
                if (i2 >= signatureArr.length) {
                    return false;
                }
                if (areEffectiveMatch(signingDetails.signatures[0], signatureArr[i2]) && this.pastSigningCertificatesFlags[i2] == i) {
                    return true;
                }
                i2++;
            }
        } else {
            return areEffectiveMatch(signingDetails.signatures, this.signatures);
        }
    }

    public static Signature bounce(CertificateFactory certificateFactory, Signature signature) throws CertificateException {
        Signature signature2 = new Signature(((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getEncoded());
        int length = signature2.toByteArray().length;
        int length2 = signature.toByteArray().length;
        if (Math.abs(length - length2) <= 2) {
            return signature2;
        }
        throw new CertificateException("Bounced cert length looks fishy; before " + length2 + ", after " + length);
    }

    public SigningDetails(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, toSigningKeys(signatureArr), signatureArr2, iArr);
    }

    public SigningDetails(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.signatures = signatureArr;
        this.signatureSchemeVersion = i;
        this.publicKeys = arraySet;
        this.pastSigningCertificates = signatureArr2;
        this.pastSigningCertificatesFlags = iArr;
    }
}
