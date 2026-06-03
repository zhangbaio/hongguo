package com.tencent.tinker.lib.signature;

import android.util.ArrayMap;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ApkSignatureSchemeV3Verifier {
    static {
        Covode.recordClassIndex(653790);
    }

    private static boolean isSupportedSignatureAlgorithm(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
            return true;
        }
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
                return true;
            default:
                return false;
        }
    }

    private static class PlatformNotSupportedException extends Exception {
        static {
            Covode.recordClassIndex(653791);
        }

        PlatformNotSupportedException(String str) {
            super(str);
        }
    }

    private static SignatureInfo findSignature(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        return ApkSigningBlockUtils.findSignature(randomAccessFile, -262969152);
    }

    public static VerifiedSigner plsCertsNoVerifyOnlyCerts(String str) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(str, false);
    }

    public static VerifiedSigner verify(String str) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(str, true);
    }

    public static boolean hasSignature(String str) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            try {
                findSignature(randomAccessFile);
                randomAccessFile.close();
                return true;
            } finally {
            }
        } catch (SignatureNotFoundException unused) {
            return false;
        }
    }

    static byte[] generateFsverityRootHash(String str) throws NoSuchAlgorithmException, DigestException, IOException, SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            SignatureInfo findSignature = findSignature(randomAccessFile);
            byte[] bArr = verify(randomAccessFile, false).verityRootHash;
            if (bArr == null) {
                randomAccessFile.close();
                return null;
            }
            byte[] generateFsverityRootHash = ApkVerityBuilder.generateFsverityRootHash(randomAccessFile, ByteBuffer.wrap(bArr), findSignature);
            randomAccessFile.close();
            return generateFsverityRootHash;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    static byte[] getVerityRootHash(String str) throws IOException, SignatureNotFoundException, SecurityException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            findSignature(randomAccessFile);
            byte[] bArr = verify(randomAccessFile, false).verityRootHash;
            randomAccessFile.close();
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static class VerifiedProofOfRotation {
        public final List<X509Certificate> certs;
        public final List<Integer> flagsList;

        static {
            Covode.recordClassIndex(653792);
        }

        public VerifiedProofOfRotation(List<X509Certificate> list, List<Integer> list2) {
            this.certs = list;
            this.flagsList = list2;
        }
    }

    public static class VerifiedSigner {
        public final X509Certificate[] certs;
        public byte[] digest;
        public final VerifiedProofOfRotation por;
        public byte[] verityRootHash;

        static {
            Covode.recordClassIndex(653793);
        }

        public VerifiedSigner(X509Certificate[] x509CertificateArr, VerifiedProofOfRotation verifiedProofOfRotation) {
            this.certs = x509CertificateArr;
            this.por = verifiedProofOfRotation;
        }
    }

    private static VerifiedSigner verify(RandomAccessFile randomAccessFile, boolean z) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(randomAccessFile, findSignature(randomAccessFile), z);
    }

    static byte[] generateApkVerity(String str, ByteBufferFactory byteBufferFactory) throws IOException, SignatureNotFoundException, SecurityException, DigestException, NoSuchAlgorithmException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            byte[] generateApkVerity = ApkSigningBlockUtils.generateApkVerity(str, byteBufferFactory, findSignature(randomAccessFile));
            randomAccessFile.close();
            return generateApkVerity;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private static VerifiedSigner verify(String str, boolean z) throws SignatureNotFoundException, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            VerifiedSigner verify = verify(randomAccessFile, z);
            randomAccessFile.close();
            return verify;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private static VerifiedProofOfRotation verifyProofOfRotationStruct(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws SecurityException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            VerbatimX509Certificate verbatimX509Certificate = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
                ByteBuffer lengthPrefixedSlice2 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
                int i3 = lengthPrefixedSlice.getInt();
                int i4 = lengthPrefixedSlice.getInt();
                byte[] readLengthPrefixedByteArray = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice);
                if (verbatimX509Certificate != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> signatureAlgorithmJcaSignatureAlgorithm = ApkSigningBlockUtils.getSignatureAlgorithmJcaSignatureAlgorithm(i2);
                    PublicKey publicKey = verbatimX509Certificate.getPublicKey();
                    Signature signature = Signature.getInstance((String) signatureAlgorithmJcaSignatureAlgorithm.first);
                    signature.initVerify(publicKey);
                    Object obj = signatureAlgorithmJcaSignatureAlgorithm.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(lengthPrefixedSlice2);
                    if (!signature.verify(readLengthPrefixedByteArray)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) signatureAlgorithmJcaSignatureAlgorithm.first) + " when verifying Proof-of-rotation record");
                    }
                }
                lengthPrefixedSlice2.rewind();
                byte[] readLengthPrefixedByteArray2 = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice2);
                int i5 = lengthPrefixedSlice2.getInt();
                if (verbatimX509Certificate != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                verbatimX509Certificate = new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(readLengthPrefixedByteArray2)), readLengthPrefixedByteArray2);
                if (!hashSet.contains(verbatimX509Certificate)) {
                    hashSet.add(verbatimX509Certificate);
                    arrayList.add(verbatimX509Certificate);
                    arrayList2.add(Integer.valueOf(i3));
                    i2 = i4;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
            }
            return new VerifiedProofOfRotation(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }

    private static VerifiedSigner verify(RandomAccessFile randomAccessFile, SignatureInfo signatureInfo, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(signatureInfo.signatureBlock);
                int i = 0;
                VerifiedSigner verifiedSigner = null;
                while (lengthPrefixedSlice.hasRemaining()) {
                    try {
                        verifiedSigner = verifySigner(ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice), arrayMap, certificateFactory);
                        i++;
                    } catch (PlatformNotSupportedException unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i >= 1 && verifiedSigner != null) {
                    if (i == 1) {
                        if (!arrayMap.isEmpty()) {
                            if (z) {
                                ApkSigningBlockUtils.verifyIntegrity(arrayMap, randomAccessFile, signatureInfo);
                            }
                            if (arrayMap.containsKey(3)) {
                                verifiedSigner.verityRootHash = ApkSigningBlockUtils.parseVerityDigestAndVerifySourceLength((byte[]) arrayMap.get(3), randomAccessFile.length(), signatureInfo);
                            }
                            return verifiedSigner;
                        }
                        throw new SecurityException("No content digests found");
                    }
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static VerifiedSigner verifyAdditionalAttributes(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        VerifiedProofOfRotation verifiedProofOfRotation = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
            if (lengthPrefixedSlice.remaining() >= 4) {
                if (lengthPrefixedSlice.getInt() == 1000370060) {
                    if (verifiedProofOfRotation == null) {
                        verifiedProofOfRotation = verifyProofOfRotationStruct(lengthPrefixedSlice, certificateFactory);
                        try {
                            if (verifiedProofOfRotation.certs.size() > 0) {
                                if (!Arrays.equals(verifiedProofOfRotation.certs.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + lengthPrefixedSlice.remaining());
            }
        }
        return new VerifiedSigner(x509CertificateArr, verifiedProofOfRotation);
    }

    private static VerifiedSigner verifySigner(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException, PlatformNotSupportedException {
        ByteBuffer lengthPrefixedSlice = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer lengthPrefixedSlice2 = ApkSigningBlockUtils.getLengthPrefixedSlice(byteBuffer);
        byte[] readLengthPrefixedByteArray = ApkSigningBlockUtils.readLengthPrefixedByteArray(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i3 = -1;
        int i4 = 0;
        while (lengthPrefixedSlice2.hasRemaining()) {
            i4++;
            try {
                ByteBuffer lengthPrefixedSlice3 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice2);
                if (lengthPrefixedSlice3.remaining() >= 8) {
                    int i5 = lengthPrefixedSlice3.getInt();
                    arrayList.add(Integer.valueOf(i5));
                    if (isSupportedSignatureAlgorithm(i5) && (i3 == -1 || ApkSigningBlockUtils.compareSignatureAlgorithm(i5, i3) > 0)) {
                        bArr2 = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice3);
                        i3 = i5;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #" + i4, e);
            }
        }
        if (i3 == -1) {
            if (i4 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String signatureAlgorithmJcaKeyAlgorithm = ApkSigningBlockUtils.getSignatureAlgorithmJcaKeyAlgorithm(i3);
        Pair<String, ? extends AlgorithmParameterSpec> signatureAlgorithmJcaSignatureAlgorithm = ApkSigningBlockUtils.getSignatureAlgorithmJcaSignatureAlgorithm(i3);
        String str = (String) signatureAlgorithmJcaSignatureAlgorithm.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) signatureAlgorithmJcaSignatureAlgorithm.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(signatureAlgorithmJcaKeyAlgorithm).generatePublic(new X509EncodedKeySpec(readLengthPrefixedByteArray));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(generatePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(lengthPrefixedSlice);
            if (signature.verify(bArr2)) {
                lengthPrefixedSlice.clear();
                ByteBuffer lengthPrefixedSlice4 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
                ArrayList arrayList2 = new ArrayList();
                int i6 = 0;
                while (lengthPrefixedSlice4.hasRemaining()) {
                    i6++;
                    try {
                        ByteBuffer lengthPrefixedSlice5 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice4);
                        if (lengthPrefixedSlice5.remaining() >= 8) {
                            int i7 = lengthPrefixedSlice5.getInt();
                            arrayList2.add(Integer.valueOf(i7));
                            if (i7 == i3) {
                                bArr = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice5);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException | BufferUnderflowException e2) {
                        throw new IOException("Failed to parse digest record #" + i6, e2);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int signatureAlgorithmContentDigestAlgorithm = ApkSigningBlockUtils.getSignatureAlgorithmContentDigestAlgorithm(i3);
                    byte[] put = map.put(Integer.valueOf(signatureAlgorithmContentDigestAlgorithm), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(ApkSigningBlockUtils.getContentDigestAlgorithmJcaDigestAlgorithm(signatureAlgorithmContentDigestAlgorithm) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer lengthPrefixedSlice6 = ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice);
                    ArrayList arrayList3 = new ArrayList();
                    int i8 = 0;
                    while (lengthPrefixedSlice6.hasRemaining()) {
                        i8++;
                        byte[] readLengthPrefixedByteArray2 = ApkSigningBlockUtils.readLengthPrefixedByteArray(lengthPrefixedSlice6);
                        try {
                            arrayList3.add(new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(readLengthPrefixedByteArray2)), readLengthPrefixedByteArray2));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #" + i8, e3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(readLengthPrefixedByteArray, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            if (lengthPrefixedSlice.getInt() == i) {
                                if (lengthPrefixedSlice.getInt() == i2) {
                                    return verifyAdditionalAttributes(ApkSigningBlockUtils.getLengthPrefixedSlice(lengthPrefixedSlice), arrayList3, certificateFactory);
                                }
                                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                            }
                            throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    throw new SecurityException("No certificates listed");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            throw new SecurityException(str + " signature did not verify");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }
}
