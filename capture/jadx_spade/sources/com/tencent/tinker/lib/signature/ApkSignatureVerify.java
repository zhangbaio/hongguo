package com.tencent.tinker.lib.signature;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.cert.CertificateException;
import java.util.HashSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ApkSignatureVerify {
    private static WeakReference<Signature[]> mHostSignatures;

    static {
        Covode.recordClassIndex(653796);
    }

    private static Object com_tencent_tinker_lib_signature_ApkSignatureVerify_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    private static boolean isSignaturesSame(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (Signature signature : signatureArr) {
            hashSet.add(signature);
        }
        HashSet hashSet2 = new HashSet();
        for (Signature signature2 : signatureArr2) {
            hashSet2.add(signature2);
        }
        if (!hashSet.equals(hashSet2)) {
            return false;
        }
        return true;
    }

    public static boolean verifyWithV1(Context context, String str) {
        Signature[] signatureArr;
        try {
            SigningDetails verify = ApkSignatureSchemeV1Verifier.verify(str, true);
            if (verify != null) {
                signatureArr = verify.signatures;
            } else {
                signatureArr = null;
            }
            WeakReference<Signature[]> weakReference = mHostSignatures;
            if (weakReference != null) {
                weakReference.get();
            }
            try {
                Signature[] signatureArr2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                mHostSignatures = new WeakReference<>(signatureArr2);
                try {
                    return SigningDetails.areEffectiveMatch(signatureArr2, signatureArr);
                } catch (CertificateException unused) {
                    MuteLog.w("ApkSignatureVerify", "host-plugin signature are effective match : " + str, new Object[0]);
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                MuteLog.w("ApkSignatureVerify", "get host signature error : " + str, new Object[0]);
                return false;
            }
        } catch (VerifyException e) {
            MuteLog.e("ApkSignatureVerify", "verify v1 plugin signature error : " + str, e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b A[Catch: InvocationTargetException -> 0x00ec, IllegalAccessException -> 0x00f3, ClassNotFoundException -> 0x00fa, TryCatch #7 {ClassNotFoundException -> 0x00fa, IllegalAccessException -> 0x00f3, InvocationTargetException -> 0x00ec, blocks: (B:9:0x0032, B:11:0x004b, B:13:0x0051), top: B:8:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean verify(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.signature.ApkSignatureVerify.verify(android.content.Context, java.lang.String):boolean");
    }

    private static Signature[] getApkPackageSignature(String str, int i, boolean z) {
        SigningDetails signingDetails;
        SigningDetails verify;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                verify = ApkSignatureVerifier.verify(str, i, z);
            } else {
                verify = ApkSignatureSchemeV1Verifier.verify(str, true);
            }
            if (verify == null) {
                return null;
            }
            try {
                return verify.signatures;
            } catch (VerifyException e) {
                signingDetails = verify;
                e = e;
                MuteLog.e("ApkSignatureVerify", "verify v3 plugin signature error : " + str, e);
                if (signingDetails == null) {
                    return null;
                }
                return signingDetails.signatures;
            }
        } catch (VerifyException e2) {
            e = e2;
            signingDetails = null;
        }
    }

    public static boolean verify(Context context, String str, boolean z) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Signature[] apkPackageSignature = getApkPackageSignature(str, 1, z);
        if (apkPackageSignature == null) {
            MuteLog.e("ApkSignatureVerify", "apk signature fail", new Object[0]);
            return false;
        }
        WeakReference<Signature[]> weakReference = mHostSignatures;
        if (weakReference != null) {
            signatureArr = weakReference.get();
        } else {
            signatureArr = null;
        }
        if (signatureArr == null) {
            signatureArr = getApkPackageSignature(context.getPackageCodePath(), 1, z);
            if (signatureArr != null) {
                mHostSignatures = new WeakReference<>(signatureArr);
            } else {
                MuteLog.e("ApkSignatureVerify", "host apk signature fail", new Object[0]);
                return false;
            }
        }
        try {
            return SigningDetails.areEffectiveMatch(signatureArr, apkPackageSignature);
        } catch (CertificateException unused) {
            MuteLog.w("ApkSignatureVerify", "host-plugin signature are not match : " + str, new Object[0]);
            return false;
        }
    }
}
