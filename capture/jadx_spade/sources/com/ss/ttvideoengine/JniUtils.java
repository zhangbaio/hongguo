package com.ss.ttvideoengine;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.ttvideodecode.Native;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JniUtils {
    public static volatile String exception;
    public static volatile boolean isLibraryLoaded;
    public static volatile LibraryLoaderProxy mProxy;

    public static int getSupportedMethod() {
        return Native.getSupportedMethod();
    }

    static {
        Covode.recordClassIndex(652293);
        mProxy = null;
        isLibraryLoaded = false;
        exception = "";
        if (EngineGlobalConfig.getInstance().getLazyLoadVideodec() == 1) {
            TTVideoEngineLog.d("JniUtils", "JniUtils.loadLibrary in static block");
            loadLibrary();
        }
    }

    public static synchronized void loadLibrary() {
        synchronized (JniUtils.class) {
            try {
                if (!isLibraryLoaded) {
                    TTVideoEngineLog.d("JniUtils", "JniUtils.loadLibrary");
                    if (mProxy != null) {
                        mProxy.loadLibrary("videodec");
                    } else {
                        System.loadLibrary("videodec");
                    }
                    isLibraryLoaded = true;
                }
            } finally {
            }
        }
    }

    public static int getDecodeMethod() throws Exception {
        String str = "exception is null";
        if (!isLibraryLoaded) {
            StringBuilder sb = new StringBuilder();
            sb.append("library not load suc exception:");
            if (exception != null) {
                str = exception;
            }
            sb.append(str);
            throw new Exception(sb.toString());
        }
        try {
            return getSupportedMethod();
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getDecodedStr exception:");
            if (th.toString() != null) {
                str = th.toString();
            }
            sb2.append(str);
            throw new Exception(sb2.toString());
        }
    }

    public static byte[] getSignature(String str) {
        return Native.getSignature(str);
    }

    public static void setLoadProxy(LibraryLoaderProxy libraryLoaderProxy) {
        if (libraryLoaderProxy != null) {
            mProxy = libraryLoaderProxy;
        }
    }

    public static byte[] getSettingSignature(String str) {
        if (!isLibraryLoaded) {
            TTVideoEngineLog.d("JniUtils", "library not load exception:" + exception);
            return null;
        }
        if (str == null) {
            TTVideoEngineLog.d("JniUtils", "getSettingSignature content is null");
            return null;
        }
        try {
            return getSignature(str);
        } catch (Throwable th) {
            TTVideoEngineLog.d("JniUtils", "getSettingSignature throwable:" + th);
            return null;
        }
    }

    private static byte[] encryptAesCbc128(byte[] bArr, byte[] bArr2) {
        return Native.encryptAesCbc128(bArr, bArr2);
    }

    public static String getDecodedStr(byte[] bArr, byte[] bArr2) {
        return Native.getDecodedStr(bArr, bArr2);
    }

    public static String encryptTimestamp(String str, String str2) {
        if (!isLibraryLoaded) {
            TTVideoEngineLog.d("JniUtils", "library not load exception:" + exception);
            return "";
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        byte[] encryptAesCbc128 = encryptAesCbc128(str.getBytes(), str2.getBytes());
        if (encryptAesCbc128.length <= 0) {
            return "";
        }
        return new String(Base64.encode(encryptAesCbc128, 0));
    }

    public static String getDecodedStrWithKey(byte[] bArr, byte[] bArr2) throws Exception {
        String str = "exception is null";
        if (!isLibraryLoaded) {
            StringBuilder sb = new StringBuilder();
            sb.append("library not load suc exception:");
            if (exception != null) {
                str = exception;
            }
            sb.append(str);
            throw new Exception(sb.toString());
        }
        try {
            return getDecodedStr(bArr, bArr2);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getDecodedStr exception:");
            if (th.toString() != null) {
                str = th.toString();
            }
            sb2.append(str);
            throw new Exception(sb2.toString());
        }
    }
}
