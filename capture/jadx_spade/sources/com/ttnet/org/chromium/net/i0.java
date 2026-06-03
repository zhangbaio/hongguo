package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

@JNINamespace("net")
@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i0 {
    private static CertificateFactory a;
    private static X509TrustManagerExtensions b;
    private static c c;
    private static X509TrustManagerExtensions d;
    private static KeyStore e;
    private static KeyStore f;
    private static File g;
    private static Set<Pair<X500Principal, PublicKey>> h;
    private static boolean i;
    private static final Object j;
    private static final char[] k;

    interface b {
        void a();
    }

    private static final class c extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(654566);
        }

        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean equals;
            if (Build.VERSION.SDK_INT >= 26) {
                if (!"android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) && !"android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction()) && (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false))) {
                    equals = false;
                } else {
                    equals = true;
                }
            } else {
                equals = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            }
            if (equals) {
                try {
                    i0.k();
                } catch (KeyStoreException e) {
                    com.ttnet.org.chromium.base.h.b("X509Util", "Unable to reload the default TrustManager", e);
                } catch (NoSuchAlgorithmException e2) {
                    com.ttnet.org.chromium.base.h.b("X509Util", "Unable to reload the default TrustManager", e2);
                } catch (CertificateException e3) {
                    com.ttnet.org.chromium.base.h.b("X509Util", "Unable to reload the default TrustManager", e3);
                }
            }
        }
    }

    private static void g() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        synchronized (j) {
            h();
        }
    }

    private static void l() throws KeyStoreException, NoSuchAlgorithmException {
        d = f(e);
    }

    public static void d() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        g();
        synchronized (j) {
            try {
                e.load(null);
                l();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        synchronized (j) {
            b = null;
            h = null;
            h();
        }
        j0.b().a();
    }

    static {
        Covode.recordClassIndex(654564);
        j = new Object();
        k = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private static void h() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (a == null) {
            a = CertificateFactory.getInstance("X.509");
        }
        if (b == null) {
            b = f(null);
        }
        if (!i) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                f = keyStore;
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
                g = new PolarisFileWrapper(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException unused2) {
            }
            i = true;
        }
        if (h == null) {
            h = new HashSet();
        }
        if (e == null) {
            KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
            e = keyStore2;
            try {
                keyStore2.load(null);
            } catch (IOException unused3) {
            }
        }
        if (d == null) {
            d = f(e);
        }
        if (c == null) {
            c = new c();
            IntentFilter intentFilter = new IntentFilter();
            if (Build.VERSION.SDK_INT >= 26) {
                intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
            } else {
                intentFilter.addAction("android.security.STORAGE_CHANGED");
            }
            com.ttnet.org.chromium.base.c.j(com.ttnet.org.chromium.base.c.f(), c, intentFilter);
        }
    }

    public static X509Certificate e(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        g();
        return (X509Certificate) a.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static void b(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        g();
        X509Certificate e2 = e(bArr);
        synchronized (j) {
            e.setCertificateEntry("root_cert_" + Integer.toString(e.size()), e2);
            l();
        }
    }

    private static String i(X500Principal x500Principal) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 2;
            char[] cArr2 = k;
            byte b2 = digest[3 - i2];
            cArr[i3] = cArr2[(b2 >> 4) & 15];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    static boolean m(X509Certificate x509Certificate) throws CertificateException {
        List<String> extendedKeyUsage;
        try {
            extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        } catch (NullPointerException unused) {
        }
        if (extendedKeyUsage == null) {
            return true;
        }
        for (String str : extendedKeyUsage) {
            if (str.equals("1.3.6.1.5.5.7.3.1") || str.equals("2.5.29.37.0") || str.equals("2.16.840.1.113730.4.1") || str.equals("1.3.6.1.4.1.311.10.3.3")) {
                return true;
            }
        }
        return false;
    }

    private static X509TrustManagerExtensions f(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        try {
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    try {
                        return new X509TrustManagerExtensions((X509TrustManager) trustManager);
                    } catch (IllegalArgumentException e2) {
                        com.ttnet.org.chromium.base.h.b("X509Util", "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e2, new Object[0]);
                    }
                }
            }
            com.ttnet.org.chromium.base.h.b("X509Util", "Could not find suitable trust manager", new Object[0]);
            return null;
        } catch (RuntimeException e3) {
            com.ttnet.org.chromium.base.h.b("X509Util", "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", e3);
            throw new KeyStoreException(e3);
        }
    }

    private static boolean j(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        if (f == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (h.contains(pair)) {
            return true;
        }
        String i2 = i(x509Certificate.getSubjectX500Principal());
        int i3 = 0;
        while (true) {
            String str = i2 + '.' + i3;
            if (!new PolarisFileWrapper(g, str).exists()) {
                return false;
            }
            Certificate certificate = f.getCertificate("system:" + str);
            if (certificate != null) {
                if (!(certificate instanceof X509Certificate)) {
                    com.ttnet.org.chromium.base.h.b("X509Util", "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName(), new Object[0]);
                } else {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        h.add(pair);
                        return true;
                    }
                }
            }
            i3++;
        }
    }

    public static AndroidCertVerifyResult n(byte[][] bArr, String str, String str2) throws KeyStoreException, NoSuchAlgorithmException {
        List<X509Certificate> c2;
        boolean z;
        if (bArr != null && bArr.length != 0 && bArr[0] != null) {
            try {
                g();
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(e(bArr[0]));
                    for (int i2 = 1; i2 < bArr.length; i2++) {
                        try {
                            arrayList.add(e(bArr[i2]));
                        } catch (CertificateException unused) {
                            com.ttnet.org.chromium.base.h.m("X509Util", "intermediate " + i2 + " failed parsing", new Object[0]);
                        }
                    }
                    X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    try {
                        x509CertificateArr[0].checkValidity();
                        if (!m(x509CertificateArr[0])) {
                            return new AndroidCertVerifyResult(-6);
                        }
                        synchronized (j) {
                            X509TrustManagerExtensions x509TrustManagerExtensions = b;
                            if (x509TrustManagerExtensions == null) {
                                return new AndroidCertVerifyResult(-1);
                            }
                            try {
                                c2 = c(x509TrustManagerExtensions, x509CertificateArr, str, str2);
                            } catch (CertificateException e2) {
                                try {
                                    c2 = c(d, x509CertificateArr, str, str2);
                                } catch (CertificateException unused2) {
                                    com.ttnet.org.chromium.base.h.h("X509Util", "Failed to validate the certificate chain, error: " + e2.getMessage(), new Object[0]);
                                    return new AndroidCertVerifyResult(-2);
                                }
                            }
                            if (c2.size() > 0) {
                                z = j(c2.get(c2.size() - 1));
                            } else {
                                z = false;
                            }
                            return new AndroidCertVerifyResult(0, z, c2);
                        }
                    } catch (CertificateExpiredException unused3) {
                        return new AndroidCertVerifyResult(-3);
                    } catch (CertificateNotYetValidException unused4) {
                        return new AndroidCertVerifyResult(-4);
                    } catch (CertificateException unused5) {
                        return new AndroidCertVerifyResult(-1);
                    }
                } catch (CertificateException unused6) {
                    return new AndroidCertVerifyResult(-5);
                }
            } catch (CertificateException unused7) {
                return new AndroidCertVerifyResult(-1);
            }
        }
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
    }

    private static List<X509Certificate> c(X509TrustManagerExtensions x509TrustManagerExtensions, X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        try {
            return x509TrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
        } catch (RuntimeException e2) {
            com.ttnet.org.chromium.base.h.b("X509Util", "checkServerTrusted() unexpectedly threw: %s", e2);
            throw new CertificateException(e2);
        }
    }
}
