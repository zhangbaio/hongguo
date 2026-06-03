package com.ss.ttm.player;

import android.content.Context;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TTPlayerConfiger {
    private static String APP_EXTERNAL_DATA_PATH = null;
    private static String APP_PATH = null;
    private static String CRASH_FILE_NAME = null;
    private static String CRASH_FILE_PATH = null;
    public static boolean IS_PRINT_INFO = false;
    private static final ConcurrentHashMap<Integer, Value> KEYS;
    public static final int KEY_IS_FORBID_CREATED_OS_PLAYER = 11;
    public static final int KEY_IS_IPTTPLAYER_ON = 2;
    public static final int KEY_IS_TTPLAYER_ON = 1;
    private static String LIBRARY_DIR = null;
    private static String PLAYER_LIBRARY_NAME = null;
    private static String TTPLAYER_FILE_CACHE_DIR = null;
    private static final int VERSION = 1;
    private static final String VERSION_NAME = "999.999.999.9";

    public static void checkDebugTTPlayerLib() {
    }

    public static final String getExternalStorageDirectoryCrashFilePath(Context context) {
        return null;
    }

    public static final int getVersion() {
        return 1;
    }

    static final class IntValue extends Value {
        private int mValue;

        static {
            Covode.recordClassIndex(652182);
        }

        public int getValue() {
            return this.mValue;
        }

        public void setValue(int i) {
            this.mValue = i;
        }

        public IntValue(int i, int i2) {
            super(i);
            this.mValue = i2;
        }
    }

    static class LongValue extends Value {
        private long mValue;

        static {
            Covode.recordClassIndex(652183);
        }

        public long getValue() {
            return this.mValue;
        }

        public void setValue(long j) {
            this.mValue = j;
        }

        public LongValue(int i, long j) {
            super(i);
            this.mValue = j;
        }
    }

    static class StringValue extends Value {
        private String mValue;

        static {
            Covode.recordClassIndex(652184);
        }

        public String getValue() {
            return this.mValue;
        }

        public void setValue(String str) {
            this.mValue = str;
        }

        public StringValue(int i, String str) {
            super(i);
            this.mValue = str;
        }
    }

    static class Value {
        private int mKey;

        static {
            Covode.recordClassIndex(652185);
        }

        public int getKey() {
            return this.mKey;
        }

        protected Value(int i) {
            this.mKey = i;
        }
    }

    public static final String getAppExternalDataPath() {
        return APP_EXTERNAL_DATA_PATH;
    }

    public static boolean isPrintInfo() {
        return IS_PRINT_INFO;
    }

    public static String getPlayerLibraryPath() {
        return getPlayerLibraryPath(null);
    }

    public static final boolean isOnTTPlayer() {
        if (getValue(6, 0) == 1) {
            return true;
        }
        if (getValue(1, 0) == 0) {
            return false;
        }
        if (getValue(11, 0) == 1) {
            return true;
        }
        if (getValue(7, 0) == 1 || getValue(8, 0) == 1 || getValue(10, 0) >= 3) {
            return false;
        }
        return true;
    }

    static {
        Covode.recordClassIndex(652181);
        PLAYER_LIBRARY_NAME = "libttmplayer.so";
        LIBRARY_DIR = null;
        TTPLAYER_FILE_CACHE_DIR = null;
        CRASH_FILE_NAME = "ttplayer_crash.log";
        CRASH_FILE_PATH = null;
        IS_PRINT_INFO = false;
        KEYS = new ConcurrentHashMap<>();
        setValue(13, 1);
        setValue(14, VERSION_NAME);
        setValue(15, "version code:1,name:999.999.999.9default sdk info 2016-12-05");
        setValue(0, false);
        setValue(1, true);
        setValue(2, true);
        setValue(3, false);
        setValue(4, false);
        setValue(5, false);
        setValue(6, false);
        setValue(7, false);
        setValue(8, false);
        setValue(10, 0);
        setValue(11, false);
        setValue(18, 2);
        setValue(25, 32);
        setValue(34, 0);
        setValue(35, 5242880);
        setValue(36, 0);
        setValue(39, 0);
        setValue(40, 131072);
        setValue(41, 0);
        setValue(42, 2);
        setValue(47, 3);
        setValue(48, 0);
        setValue(50, 20);
        setValue(51, 0);
        setValue(74, 0);
    }

    public static final void setCrashFileName(String str) {
        CRASH_FILE_NAME = str;
    }

    public static final void setCrashFilePath(String str) {
        CRASH_FILE_PATH = str;
    }

    public static final void setLibraryName(String str) {
        PLAYER_LIBRARY_NAME = str;
    }

    public static final void setLibrarysDir(String str) {
        LIBRARY_DIR = str;
    }

    public static final String getAppFileCachePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
        }
        String str = TTPLAYER_FILE_CACHE_DIR;
        if (str != null) {
            return str;
        }
        String str2 = APP_PATH;
        if (str2 != null) {
            return str2;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = context.getApplicationContext().getFilesDir().getAbsolutePath();
            APP_PATH = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getAppFilesPath(Context context) {
        String str = APP_PATH;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return null;
        }
        try {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
            try {
                File externalCacheDir = context.getApplicationContext().getExternalCacheDir();
                Objects.requireNonNull(externalCacheDir);
                File file = externalCacheDir;
                APP_EXTERNAL_DATA_PATH = externalCacheDir.getAbsolutePath();
            } catch (Exception unused) {
            }
            return APP_PATH;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String getPlayerLibrarysDir(Context context) {
        String str = LIBRARY_DIR;
        if (str == null) {
            String str2 = getAppFilesPath(context) + File.separatorChar;
            LIBRARY_DIR = str2;
            return str2;
        }
        if (str.endsWith(String.valueOf(File.separatorChar))) {
            return LIBRARY_DIR;
        }
        return LIBRARY_DIR + File.separatorChar;
    }

    public static final String getAppCrashFilePath(Context context) {
        if (CRASH_FILE_PATH == null && !new PolarisFileWrapper(getAppCrashFileStorePath(context)).exists()) {
            return APP_PATH + File.separatorChar + "plugins" + File.separatorChar + "com.ss.ttm" + File.separatorChar + "data" + File.separatorChar + "files" + File.separatorChar + CRASH_FILE_NAME;
        }
        if (isPrintInfo()) {
            Log.i("ttplayer", "<TTPlayerConfigure.java,getAppCrashFileStorePath,278>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static final String getAppCrashFilePath2(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
        }
        if (CRASH_FILE_PATH == null) {
            if (APP_PATH == null) {
                APP_PATH = getAppFilesPath(context);
            }
            if (isPrintInfo()) {
                Log.i("ttplayer", "<TTPlayerConfigure.java,getAppCrashFilePath2,211>app files path:" + APP_PATH);
            }
            if (APP_PATH != null) {
                return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
            }
            return null;
        }
        if (isPrintInfo()) {
            Log.i("ttplayer", "<TTPlayerConfigure.java,getAppCrashFileStorePath,195>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static final String getAppCrashFileStorePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
        }
        if (CRASH_FILE_PATH == null) {
            if (APP_PATH == null) {
                APP_PATH = getAppFilesPath(context);
            }
            if (isPrintInfo()) {
                Log.i("ttplayer", "<TTPlayerConfigure.java,getAppCrashFileStorePath,245>app files path:" + APP_PATH);
            }
            if (APP_PATH != null) {
                return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
            }
            return null;
        }
        if (isPrintInfo()) {
            Log.i("ttplayer", "<TTPlayerConfigure.java,getAppCrashFileStorePath,253>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static String getPlayerLibraryPath(Context context) {
        if (APP_PATH == null || context != null) {
            APP_PATH = getAppFilesPath(context);
        }
        if (APP_PATH == null && LIBRARY_DIR == null) {
            return null;
        }
        String str = LIBRARY_DIR;
        if (str != null) {
            if (str.endsWith(String.valueOf(File.separatorChar))) {
                return LIBRARY_DIR + PLAYER_LIBRARY_NAME;
            }
            return LIBRARY_DIR + File.separatorChar + PLAYER_LIBRARY_NAME;
        }
        return APP_PATH + File.separatorChar + PLAYER_LIBRARY_NAME;
    }

    public static final String getPlugerCrashFilePath(Context context) {
        return APP_PATH + File.separatorChar + "plugins" + File.separatorChar + "com.ss.ttm" + File.separatorChar + "data" + File.separatorChar + "files" + File.separatorChar + CRASH_FILE_NAME;
    }

    public static final void setValue(int i, boolean z) {
        setValue(i, z ? 1 : 0);
    }

    public static final int getValue(int i, int i2) {
        Value value = KEYS.get(Integer.valueOf(i));
        if (value != null && (value instanceof IntValue)) {
            return ((IntValue) value).getValue();
        }
        return i2;
    }

    public static final long getValue(int i, long j) {
        Value value = KEYS.get(Integer.valueOf(i));
        if (value != null && (value instanceof LongValue)) {
            return ((LongValue) value).getValue();
        }
        return j;
    }

    public static final void setValue(int i, int i2) {
        ConcurrentHashMap<Integer, Value> concurrentHashMap = KEYS;
        Value value = concurrentHashMap.get(Integer.valueOf(i));
        if (value != null) {
            if (value instanceof IntValue) {
                if (i == 2 && getValue(6, false)) {
                    return;
                }
                ((IntValue) value).setValue(i2);
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(i));
        }
        concurrentHashMap.put(Integer.valueOf(i), new IntValue(i, i2));
    }

    public static final String getValue(int i, String str) {
        if (i == 17) {
            return CRASH_FILE_NAME;
        }
        Value value = KEYS.get(Integer.valueOf(i));
        if (value != null && (value instanceof StringValue)) {
            return ((StringValue) value).getValue();
        }
        return str;
    }

    public static final void setValue(int i, long j) {
        ConcurrentHashMap<Integer, Value> concurrentHashMap = KEYS;
        Value value = concurrentHashMap.get(Integer.valueOf(i));
        if (value != null) {
            if (value instanceof LongValue) {
                ((LongValue) value).setValue(j);
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(i));
        }
        concurrentHashMap.put(Integer.valueOf(i), new LongValue(i, j));
    }

    public static final boolean getValue(int i, boolean z) {
        Value value = KEYS.get(Integer.valueOf(i));
        if (value != null && (value instanceof IntValue)) {
            if (((IntValue) value).getValue() == 1) {
                return true;
            }
            return false;
        }
        return z;
    }

    public static final void setValue(int i, String str) {
        ConcurrentHashMap<Integer, Value> concurrentHashMap = KEYS;
        Value value = concurrentHashMap.get(Integer.valueOf(i));
        if (value != null) {
            if (value instanceof StringValue) {
                ((StringValue) value).setValue(str);
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(i));
        }
        concurrentHashMap.put(Integer.valueOf(i), new StringValue(i, str));
    }

    public static final boolean moveFile(String str, String str2, boolean z) {
        return copyFile(str, str2, z, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0088 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #10 {IOException -> 0x0084, blocks: (B:67:0x0080, B:60:0x0088), top: B:66:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean copyFile(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) {
        /*
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            boolean r5 = r0.isFile()
            if (r5 != 0) goto L14
            return r1
        L14:
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r5 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r5.<init>(r4)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L2a
            if (r6 == 0) goto L3f
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r6 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r6.<init>(r4)
            r6.delete()
            goto L3f
        L2a:
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L3f
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L3f
            return r1
        L3f:
            r4 = 0
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r6 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L90 java.io.FileNotFoundException -> La3
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L90 java.io.FileNotFoundException -> La3
            com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper r2 = new com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L91 java.io.FileNotFoundException -> La4
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L91 java.io.FileNotFoundException -> La4
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
        L4e:
            int r5 = r6.read(r4)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            r3 = -1
            if (r5 == r3) goto L59
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            goto L4e
        L59:
            r2.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            r6.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            if (r7 == 0) goto L64
            r0.delete()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
        L64:
            r2.close()     // Catch: java.io.IOException -> L6b
            r6.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r4 = move-exception
            r4.printStackTrace()
        L6f:
            r4 = 1
            return r4
        L71:
            r4 = move-exception
            goto L7e
        L73:
            r4 = r2
            goto L91
        L75:
            r4 = r2
            goto La4
        L77:
            r5 = move-exception
            r2 = r4
            goto L7d
        L7a:
            r5 = move-exception
            r6 = r4
            r2 = r6
        L7d:
            r4 = r5
        L7e:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.io.IOException -> L84
            goto L86
        L84:
            r5 = move-exception
            goto L8c
        L86:
            if (r6 == 0) goto L8f
            r6.close()     // Catch: java.io.IOException -> L84
            goto L8f
        L8c:
            r5.printStackTrace()
        L8f:
            throw r4
        L90:
            r6 = r4
        L91:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L97
            goto L99
        L97:
            r4 = move-exception
            goto L9f
        L99:
            if (r6 == 0) goto La2
            r6.close()     // Catch: java.io.IOException -> L97
            goto La2
        L9f:
            r4.printStackTrace()
        La2:
            return r1
        La3:
            r6 = r4
        La4:
            if (r4 == 0) goto Lac
            r4.close()     // Catch: java.io.IOException -> Laa
            goto Lac
        Laa:
            r4 = move-exception
            goto Lb2
        Lac:
            if (r6 == 0) goto Lb5
            r6.close()     // Catch: java.io.IOException -> Laa
            goto Lb5
        Lb2:
            r4.printStackTrace()
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTPlayerConfiger.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }
}
