package com.vivo.push.g;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.t;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements a {
    private PrivateKey a = null;
    private PublicKey b = null;
    private KeyStore c;
    private X500Principal d;
    private Context e;

    static {
        Covode.recordClassIndex(655041);
    }

    private void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.c = keyStore;
            keyStore.load(null);
            this.d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    @Override // com.vivo.push.g.a
    public final PublicKey a() {
        try {
            PublicKey publicKey = this.b;
            if (publicKey != null) {
                return publicKey;
            }
            KeyStore.Entry d = d(this.e);
            if (d instanceof KeyStore.PrivateKeyEntry) {
                PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) d).getCertificate().getPublicKey();
                this.b = publicKey2;
                return publicKey2;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
            return null;
        }
    }

    public c(Context context) {
        this.e = context;
        a(context);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    private PrivateKey c(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = this.a;
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            t.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry d = d(context);
        if (d instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) d).getPrivateKey();
            this.a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private KeyStore.Entry d(Context context) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        try {
            if (context == null) {
                t.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e) {
            b(context);
            KeyStore.Entry entry = this.c.getEntry("PushRsaKeyAlias", null);
            e.printStackTrace();
            t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return entry;
        }
    }

    private void b(Context context) {
        try {
            if (context == null) {
                t.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
        }
    }

    @Override // com.vivo.push.g.a
    public final String a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && c(this.e) != null) {
                byte[] bytes = str.getBytes("UTF-8");
                PrivateKey c = c(this.e);
                Signature signature = Signature.getInstance("SHA256withRSA");
                signature.initSign(c);
                signature.update(bytes);
                String encodeToString = Base64.encodeToString(signature.sign(), 2);
                t.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
                return encodeToString;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "signClientSDK error" + e.getMessage());
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.c == null) {
                b();
            }
            return this.c.containsAlias(str);
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.g.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
            return false;
        }
    }
}
