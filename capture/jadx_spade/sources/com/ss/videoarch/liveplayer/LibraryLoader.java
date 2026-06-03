package com.ss.videoarch.liveplayer;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LibraryLoader {
    private static final String TAG;
    private static Loader sLoader;

    public interface Loader {
        void loadLibrary(String str) throws Exception;

        void loadLibraryFromPath(String str) throws Exception;

        boolean loadPlayerLibrary(String str);

        boolean loadPluginLibrary(String str, String str2) throws Exception;
    }

    static {
        Covode.recordClassIndex(652922);
        TAG = LibraryLoader.class.getSimpleName();
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }

    public static void loadLibrary(String str) throws Exception {
        Loader loader = sLoader;
        if (!TextUtils.isEmpty(str)) {
            if (loader != null) {
                com.ss.videoarch.liveplayer.log.a.a(TAG, "Loading [" + str + "] with external loader " + loader);
                loader.loadLibrary(str);
                return;
            }
            System.loadLibrary(str);
            return;
        }
        throw new Exception("Invalid library name.");
    }

    public static boolean loadPlayerLibrary(String str) {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            com.ss.videoarch.liveplayer.log.a.a(TAG, "Invalid library name.");
            return false;
        }
        if (loader != null) {
            com.ss.videoarch.liveplayer.log.a.a(TAG, "Loading [" + str + "] with external loader " + loader);
            return loader.loadPlayerLibrary(str);
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void loadLibraryFromPath(String str) throws Exception {
        Loader loader = sLoader;
        if (!TextUtils.isEmpty(str)) {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
            if (polarisFileWrapper.exists()) {
                if (loader != null) {
                    com.ss.videoarch.liveplayer.log.a.a(TAG, "Loading [" + polarisFileWrapper.getAbsolutePath() + "] with external loader " + loader);
                    loader.loadLibraryFromPath(polarisFileWrapper.getAbsolutePath());
                    return;
                }
                System.load(polarisFileWrapper.getAbsolutePath());
                return;
            }
            throw new Exception("Not found library '" + str + "' file.");
        }
        throw new Exception("Invalid library name.");
    }

    public static boolean loadPluginLibrary(String str, String str2) throws Exception {
        Loader loader = sLoader;
        if (!TextUtils.isEmpty(str)) {
            if (loader != null) {
                com.ss.videoarch.liveplayer.log.a.a(TAG, "Loading [" + str + "] with external loader " + loader);
                return loader.loadPluginLibrary(str, str2);
            }
            System.loadLibrary(str);
            return true;
        }
        throw new Exception("Invalid library name.");
    }
}
