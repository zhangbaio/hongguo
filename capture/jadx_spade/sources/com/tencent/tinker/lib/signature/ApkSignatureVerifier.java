package com.tencent.tinker.lib.signature;

import android.content.pm.Signature;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.hidden.q.DoubleReflector;
import com.tencent.tinker.lib.signature.ApkSignatureSchemeV3Verifier;
import com.tencent.tinker.lib.utils.OSUtil;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ApkSignatureVerifier {
    static {
        Covode.recordClassIndex(653794);
    }

    public static byte[] generateFsverityRootHash(String str) throws NoSuchAlgorithmException, DigestException, IOException {
        try {
            try {
                return ApkSignatureSchemeV3Verifier.generateFsverityRootHash(str);
            } catch (SignatureNotFoundException unused) {
                return null;
            }
        } catch (SignatureNotFoundException unused2) {
            return ApkSignatureSchemeV2Verifier.generateFsverityRootHash(str);
        }
    }

    public static byte[] getVerityRootHash(String str) throws IOException, SignatureNotFoundException, SecurityException {
        try {
            return ApkSignatureSchemeV3Verifier.getVerityRootHash(str);
        } catch (SignatureNotFoundException unused) {
            return ApkSignatureSchemeV2Verifier.getVerityRootHash(str);
        }
    }

    public static Signature[] convertToSignatures(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (OSUtil.isAndroidLP()) {
                Constructor constructor = DoubleReflector.getConstructor(Signature.class, Certificate[].class);
                if (constructor != null) {
                    constructor.setAccessible(true);
                }
                if (constructor != null && constructor.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructor.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }

    public static byte[] generateApkVerity(String str, ByteBufferFactory byteBufferFactory) throws IOException, SignatureNotFoundException, SecurityException, DigestException, NoSuchAlgorithmException {
        try {
            return ApkSignatureSchemeV3Verifier.generateApkVerity(str, byteBufferFactory);
        } catch (SignatureNotFoundException unused) {
            return ApkSignatureSchemeV2Verifier.generateApkVerity(str, byteBufferFactory);
        }
    }

    public static SigningDetails plsCertsNoVerifyOnlyCerts(String str, int i) throws VerifyException {
        Signature[] signatureArr;
        int[] iArr;
        if (i <= 3) {
            try {
                ApkSignatureSchemeV3Verifier.VerifiedSigner plsCertsNoVerifyOnlyCerts = ApkSignatureSchemeV3Verifier.plsCertsNoVerifyOnlyCerts(str);
                Signature[] convertToSignatures = convertToSignatures(new Certificate[][]{plsCertsNoVerifyOnlyCerts.certs});
                ApkSignatureSchemeV3Verifier.VerifiedProofOfRotation verifiedProofOfRotation = plsCertsNoVerifyOnlyCerts.por;
                if (verifiedProofOfRotation != null) {
                    int size = verifiedProofOfRotation.certs.size();
                    signatureArr = new Signature[size];
                    iArr = new int[plsCertsNoVerifyOnlyCerts.por.flagsList.size()];
                    for (int i2 = 0; i2 < size; i2++) {
                        signatureArr[i2] = new Signature(plsCertsNoVerifyOnlyCerts.por.certs.get(i2).getEncoded());
                        iArr[i2] = plsCertsNoVerifyOnlyCerts.por.flagsList.get(i2).intValue();
                    }
                } else {
                    signatureArr = null;
                    iArr = null;
                }
                return new SigningDetails(convertToSignatures, 3, signatureArr, iArr);
            } catch (SignatureNotFoundException e) {
                if (i < 3) {
                    if (i <= 2) {
                        try {
                            return new SigningDetails(convertToSignatures(ApkSignatureSchemeV2Verifier.plsCertsNoVerifyOnlyCerts(str)), 2);
                        } catch (SignatureNotFoundException e2) {
                            if (i < 2) {
                                if (i <= 1) {
                                    return ApkSignatureSchemeV1Verifier.verify(str, false);
                                }
                                throw new VerifyException(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            throw new VerifyException(4, "No APK Signature Scheme v2 signature in package " + str, e2);
                        } catch (Exception e3) {
                            throw new VerifyException(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                        }
                    }
                    throw new VerifyException(4, "No signature found in package of version " + i + " or newer for package " + str);
                }
                throw new VerifyException(4, "No APK Signature Scheme v3 signature in package " + str, e);
            } catch (Exception e4) {
                throw new VerifyException(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e4);
            }
        }
        throw new VerifyException(4, "No signature found in package of version " + i + " or newer for package " + str);
    }

    public static class Result {
        public final Certificate[][] certs;
        public final int signatureSchemeVersion;
        public final Signature[] sigs;

        static {
            Covode.recordClassIndex(653795);
        }

        public Result(Certificate[][] certificateArr, Signature[] signatureArr, int i) {
            this.certs = certificateArr;
            this.sigs = signatureArr;
            this.signatureSchemeVersion = i;
        }
    }

    public static SigningDetails verify(String str, int i, boolean z) throws VerifyException {
        if (i <= 3) {
            if (z) {
                try {
                    ApkSignatureSchemeV3Verifier.VerifiedSigner verify = ApkSignatureSchemeV3Verifier.verify(str);
                    convertToSignatures(new Certificate[][]{verify.certs});
                    ApkSignatureSchemeV3Verifier.VerifiedProofOfRotation verifiedProofOfRotation = verify.por;
                    if (verifiedProofOfRotation != null) {
                        int size = verifiedProofOfRotation.certs.size();
                        Signature[] signatureArr = new Signature[size];
                        int[] iArr = new int[verify.por.flagsList.size()];
                        for (int i2 = 0; i2 < size; i2++) {
                            signatureArr[i2] = new Signature(verify.por.certs.get(i2).getEncoded());
                            iArr[i2] = verify.por.flagsList.get(i2).intValue();
                        }
                    }
                    Log.i("Sign", "v3 found");
                } catch (SignatureNotFoundException e) {
                    if (i >= 3) {
                        throw new VerifyException(4, "No APK Signature Scheme v3 signature in package " + str, e);
                    }
                } catch (Exception e2) {
                    throw new VerifyException(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                }
            }
            if (i <= 2) {
                try {
                    Signature[] convertToSignatures = convertToSignatures(ApkSignatureSchemeV2Verifier.verify(str));
                    Log.d("Sign", "v2 found");
                    return new SigningDetails(convertToSignatures, 2);
                } catch (SignatureNotFoundException e3) {
                    if (i < 2) {
                        if (i <= 1) {
                            return ApkSignatureSchemeV1Verifier.verify(str, true);
                        }
                        throw new VerifyException(4, "No signature found in package of version " + i + " or newer for package " + str);
                    }
                    throw new VerifyException(4, "No APK Signature Scheme v2 signature in package " + str, e3);
                } catch (Exception e4) {
                    throw new VerifyException(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e4);
                }
            }
            throw new VerifyException(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        throw new VerifyException(4, "No signature found in package of version " + i + " or newer for package " + str);
    }
}
