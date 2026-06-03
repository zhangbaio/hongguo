package com.tencent.tinker.lib.signature;

import android.content.pm.Signature;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.utils.ArrayUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ApkSignatureSchemeV1Verifier {
    private static final AtomicReference<byte[]> sBuffer;

    static {
        Covode.recordClassIndex(653787);
        sBuffer = new AtomicReference<>();
    }

    private static void readFullyIgnoringContents(InputStream inputStream) throws IOException {
        byte[] andSet = sBuffer.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        sBuffer.set(andSet);
    }

    private static Certificate[][] loadCertificates(JarFile jarFile, JarEntry jarEntry) throws VerifyException {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                readFullyIgnoringContents(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return certificateArr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException e3) {
            throw new VerifyException(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e3);
        }
    }

    public static SigningDetails verify(String str, boolean z) throws VerifyException {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        } catch (GeneralSecurityException e3) {
            e = e3;
        }
        try {
            ArrayList<JarEntry> arrayList = new ArrayList();
            JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            if (jarEntry != null) {
                Certificate[][] loadCertificates = loadCertificates(jarFile, jarEntry);
                if (!ArrayUtils.isEmpty(loadCertificates)) {
                    Signature[] convertToSignatures = ApkSignatureVerifier.convertToSignatures(loadCertificates);
                    if (z) {
                        Enumeration<JarEntry> entries = jarFile.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                String name = nextElement.getName();
                                if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                    arrayList.add(nextElement);
                                }
                            }
                        }
                        for (JarEntry jarEntry2 : arrayList) {
                            Certificate[][] loadCertificates2 = loadCertificates(jarFile, jarEntry2);
                            if (!ArrayUtils.isEmpty(loadCertificates2)) {
                                if (!SigningDetails.areExactMatch(convertToSignatures, ApkSignatureVerifier.convertToSignatures(loadCertificates2))) {
                                    throw new VerifyException(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                                }
                            } else {
                                throw new VerifyException(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                        }
                    }
                    Log.i("Sign", "v1 found");
                    SigningDetails signingDetails = new SigningDetails(convertToSignatures, 1, null, null, null);
                    try {
                        jarFile.close();
                    } catch (Exception unused) {
                    }
                    return signingDetails;
                }
                throw new VerifyException(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
            }
            throw new VerifyException(1, "Package " + str + " has no manifest");
        } catch (IOException e4) {
            e = e4;
            throw new VerifyException(4, "Failed to collect certificates from " + str, e);
        } catch (RuntimeException e5) {
            e = e5;
            throw new VerifyException(4, "Failed to collect certificates from " + str, e);
        } catch (GeneralSecurityException e6) {
            e = e6;
            throw new VerifyException(2, "Failed to collect certificates from " + str, e);
        } catch (Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
