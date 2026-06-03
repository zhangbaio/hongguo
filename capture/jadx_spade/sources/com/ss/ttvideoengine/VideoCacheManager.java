package com.ss.ttvideoengine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.model.VideoCacheInfo;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoCacheManager {
    private static String TAG;
    private static volatile File dir;
    private final LinkedHashMap<String, File> cache;
    private volatile float cleanFactor;
    private ClearTask clearTask;
    private volatile boolean isInited;
    private final LinkedHashMap<String, VideoCacheInfo> keyCache;
    private final ReentrantReadWriteLock lock;
    private volatile long maxSize;
    private final ProtectKeyManager protectKeyManager;
    private final ReentrantReadWriteLock.ReadLock readLock;
    private final ReentrantReadWriteLock.WriteLock writeLock;

    private static class VideoCacheManagerSingletonHolder {
        private static final VideoCacheManager instance;

        private VideoCacheManagerSingletonHolder() {
        }

        static {
            Covode.recordClassIndex(652379);
            instance = new VideoCacheManager();
        }
    }

    public static VideoCacheManager getInstance() {
        return VideoCacheManagerSingletonHolder.instance;
    }

    public void start() {
        this.clearTask.postMessage(this, 0);
    }

    private static final class ProtectKeyManager {
        private final Map<String, Integer> protectKeys;

        static {
            Covode.recordClassIndex(652378);
        }

        private ProtectKeyManager() {
            this.protectKeys = new HashMap();
        }

        synchronized boolean containsKey(String str) {
            if (!TextUtils.isEmpty(str)) {
                return this.protectKeys.containsKey(str);
            }
            return false;
        }

        synchronized void addProtectKey(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.protectKeys.get(str);
                if (num == null) {
                    this.protectKeys.put(str, 1);
                } else {
                    this.protectKeys.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void removeProtectKey(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.protectKeys.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.protectKeys.remove(str);
                } else {
                    this.protectKeys.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }
    }

    static {
        Covode.recordClassIndex(652376);
        TAG = "VideoCacheManager";
    }

    void clear() {
        TTVideoEngineLog.d(TAG, "start clear all cache");
        trimSize(0L);
        TTVideoEngineLog.d(TAG, "end clear all cache");
    }

    private static class ClearTask {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        static {
            Covode.recordClassIndex(652377);
        }

        public ClearTask() {
            try {
                HandlerThread handlerThread = new HandlerThread("clearCacheThread");
                this.mHandlerThread = handlerThread;
                handlerThread.start();
                this.mHandler = new HandlerDelegate(this.mHandlerThread.getLooper()) { // from class: com.ss.ttvideoengine.VideoCacheManager.ClearTask.1
                    public void handleMessage(Message message) {
                        try {
                            VideoCacheManager videoCacheManager = (VideoCacheManager) message.obj;
                            int i = message.what;
                            if (i != 0) {
                                if (i != 1) {
                                    if (i == 2) {
                                        videoCacheManager.cleanIfNecessary();
                                    }
                                } else {
                                    videoCacheManager.clear();
                                }
                            } else {
                                videoCacheManager.init();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                };
            } catch (Throwable unused) {
                this.mHandlerThread.quit();
                this.mHandlerThread = null;
                this.mHandler = null;
            }
        }

        public void postMessage(VideoCacheManager videoCacheManager, int i) {
            if (this.mHandler != null && this.mHandlerThread != null) {
                Message message = new Message();
                message.what = i;
                message.obj = videoCacheManager;
                this.mHandler.sendMessage(message);
            }
        }
    }

    void cleanIfNecessary() {
        TTVideoEngineLog.d(TAG, "start clean file maxSize: " + this.maxSize);
        trimSize(this.maxSize);
        TTVideoEngineLog.d(TAG, "end clean file maxSize: " + this.maxSize);
    }

    private VideoCacheManager() {
        this.cache = new LinkedHashMap<>(0, 0.75f, true);
        this.keyCache = new LinkedHashMap<>(0, 0.75f, true);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.maxSize = 209715200L;
        this.cleanFactor = 0.3f;
        this.isInited = false;
        this.protectKeyManager = new ProtectKeyManager();
        this.clearTask = new ClearTask();
    }

    void init() {
        String str;
        String customBase64Encode;
        TTVideoEngineLog.i(TAG, "start init videocachemanager");
        this.writeLock.lock();
        try {
            if (!this.isInited && isValidDir(dir)) {
                File[] listFiles = dir.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    final HashMap hashMap = new HashMap(listFiles.length);
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            arrayList.add(file);
                            hashMap.put(file, Long.valueOf(file.lastModified()));
                        }
                    }
                    Collections.sort(arrayList, new Comparator<File>() { // from class: com.ss.ttvideoengine.VideoCacheManager.1
                        @Override // java.util.Comparator
                        public int compare(File file2, File file3) {
                            return Long.valueOf(TTHelper.safelyUnbox((Long) hashMap.get(file2))).compareTo(Long.valueOf(TTHelper.safelyUnbox((Long) hashMap.get(file3))));
                        }
                    });
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        File file2 = (File) it2.next();
                        TTVideoEngineLog.i(TAG, String.format("add file:%s", file2.getName()));
                        this.cache.put(getKey(file2), file2);
                        String[] extractKeys = extractKeys(file2);
                        if (isValidKeys(extractKeys)) {
                            String format = String.format("%s_%s", extractKeys[0], extractKeys[1]);
                            String format2 = String.format("%s_%s_%s_%s", extractKeys[0], extractKeys[1], extractKeys[2], extractKeys[3]);
                            if (extractKeys.length == 5) {
                                str = extractKeys[4];
                            } else {
                                str = null;
                            }
                            String canonicalPath = file2.getCanonicalPath();
                            if (str != null && str.length() > 0 && (customBase64Encode = TTHelper.customBase64Encode(str)) != null && !customBase64Encode.equals(str)) {
                                canonicalPath = canonicalPath.replace(str, customBase64Encode);
                                file2.renameTo(new PolarisFileWrapper(canonicalPath));
                                str = customBase64Encode;
                            }
                            this.keyCache.put(format, new VideoCacheInfo(canonicalPath, format2, format2, str));
                        }
                    }
                }
                this.isInited = true;
            }
        } finally {
            try {
                TTVideoEngineLog.d(TAG, "end init videocachemanager");
            } finally {
            }
        }
        TTVideoEngineLog.d(TAG, "end init videocachemanager");
    }

    public void setMaxSize(long j) {
        this.maxSize = j;
    }

    private String getKey(File file) {
        return file.getName();
    }

    public static void setDir(File file) {
        if (file != null) {
            dir = file;
        }
    }

    private String[] extractKeys(File file) {
        String name = file.getName();
        if (name == null) {
            return null;
        }
        return extractKeys(name);
    }

    private String[] extractKeys(String str) {
        String[] split;
        if (str == null || (split = str.split("\\.")) == null || split.length <= 0) {
            return null;
        }
        return split[0].split("_");
    }

    boolean isValidDir(File file) {
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            return true;
        }
        return false;
    }

    boolean isValidKeys(String[] strArr) {
        if (strArr == null || (strArr.length != 4 && strArr.length != 5)) {
            return false;
        }
        for (String str : strArr) {
            if (str == null) {
                return false;
            }
        }
        return true;
    }

    public void addProtectKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            TTVideoEngineLog.i(TAG, String.format("start add protect key:%s", str));
            this.protectKeyManager.addProtectKey(str);
            TTVideoEngineLog.d(TAG, String.format("end add protect key:%s", str));
        }
    }

    public boolean isCacheInfoExist(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.readLock.tryLock()) {
            try {
                z = this.keyCache.containsKey(str);
            } finally {
                try {
                } finally {
                }
            }
        }
        return z;
    }

    public void removeProtectKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            TTVideoEngineLog.i(TAG, String.format("start remove protect key:%s", str));
            this.protectKeyManager.removeProtectKey(str);
            TTVideoEngineLog.d(TAG, String.format("end remove protect key:%s", str));
        }
    }

    public VideoCacheInfo getCacheInfo(String str) {
        VideoCacheInfo videoCacheInfo;
        String[] extractKeys;
        VideoCacheInfo videoCacheInfo2 = null;
        if (str == null) {
            return null;
        }
        if (this.readLock.tryLock()) {
            try {
                videoCacheInfo = this.keyCache.get(str);
            } catch (Throwable th) {
                th = th;
            }
            if (videoCacheInfo != null) {
                try {
                    videoCacheInfo.spadeaKey = TTHelper.customBase64Decode(videoCacheInfo.spadeaKey);
                    extractKeys = extractKeys(videoCacheInfo.fileName);
                } catch (Throwable th2) {
                    th = th2;
                    videoCacheInfo2 = videoCacheInfo;
                    try {
                        TTVideoEngineLog.d(th);
                        return videoCacheInfo2;
                    } finally {
                        this.readLock.unlock();
                    }
                }
                if (!isValidKeys(extractKeys) || !checkMD5(videoCacheInfo.filePath, extractKeys[2], Long.parseLong(extractKeys[3]))) {
                    TTVideoEngineLog.d(TAG, String.format("get info err", str));
                }
            }
            videoCacheInfo2 = videoCacheInfo;
        }
        return videoCacheInfo2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void trimSize(long r17) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.VideoCacheManager.trimSize(long):void");
    }

    public void addCacheInfo(String str, String str2) {
        String str3;
        if (this.writeLock.tryLock()) {
            try {
                String[] extractKeys = extractKeys(str);
                if (isValidKeys(extractKeys)) {
                    String format = String.format("%s_%s", extractKeys[0], extractKeys[1]);
                    String format2 = String.format("%s_%s_%s_%s", extractKeys[0], extractKeys[1], extractKeys[2], extractKeys[3]);
                    if (extractKeys.length == 5) {
                        str3 = extractKeys[4];
                    } else {
                        str3 = null;
                    }
                    VideoCacheInfo videoCacheInfo = new VideoCacheInfo(str2, format2, format2, str3);
                    if (!this.keyCache.containsKey(format)) {
                        this.keyCache.put(format, videoCacheInfo);
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static boolean checkCacheFileIntegrity(String str, String str2, long j) {
        MessageDigest messageDigest;
        FileInputStream polarisFileInputStreamWrapper;
        int i;
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (!polarisFileWrapper.exists() || !polarisFileWrapper.isFile() || polarisFileWrapper.length() < j) {
            return false;
        }
        int i2 = 10240;
        if (j < 10240) {
            i2 = (int) j;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(polarisFileWrapper);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[i2];
            boolean z = false;
            while (!z) {
                if (j < i2) {
                    i = (int) j;
                } else {
                    i = i2;
                }
                int read = polarisFileInputStreamWrapper.read(bArr, 0, i);
                messageDigest.update(bArr, 0, read);
                long j2 = read;
                if (j <= j2) {
                    z = true;
                } else {
                    j -= j2;
                }
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            String sb2 = sb.toString();
            try {
                polarisFileInputStreamWrapper.close();
            } catch (Throwable th2) {
                TTVideoEngineLog.d(th2);
            }
            if (sb2 == null) {
                return false;
            }
            return sb2.equals(str2);
        } catch (Exception e2) {
            e = e2;
            fileInputStream = polarisFileInputStreamWrapper;
            TTVideoEngineLog.d(e);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    TTVideoEngineLog.d(th3);
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = polarisFileInputStreamWrapper;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th5) {
                    TTVideoEngineLog.d(th5);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        com.ss.ttvideoengine.utils.TTVideoEngineLog.e(com.ss.ttvideoengine.VideoCacheManager.TAG, java.lang.String.format("read data err:%s", r16));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean checkMD5(java.lang.String r16, java.lang.String r17, long r18) {
        /*
            r15 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            if (r0 == 0) goto Lcf
            if (r1 == 0) goto Lcf
            r3 = 0
            int r5 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r5 > 0) goto L11
            goto Lcf
        L11:
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r5 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r5.<init>(r0)
            boolean r6 = r5.exists()
            r7 = 2
            r8 = 1
            if (r6 == 0) goto Laf
            long r9 = r5.length()
            int r6 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r6 >= 0) goto L28
            goto Laf
        L28:
            r6 = 16384(0x4000, float:2.2959E-41)
            byte[] r6 = new byte[r6]
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r9 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Exception -> Laa
            r9.<init>(r5)     // Catch: java.lang.Exception -> Laa
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.lang.Throwable -> L9b
        L37:
            long r10 = r18 - r3
            r12 = 16384(0x4000, double:8.095E-320)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L40
            r10 = r12
        L40:
            int r11 = (int) r10     // Catch: java.lang.Throwable -> L9b
            if (r11 != 0) goto L44
            goto L59
        L44:
            int r10 = r9.read(r6, r2, r11)     // Catch: java.lang.Throwable -> L9b
            if (r10 >= 0) goto L95
            java.lang.String r3 = com.ss.ttvideoengine.VideoCacheManager.TAG     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = "read data err:%s"
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L9b
            r6[r2] = r0     // Catch: java.lang.Throwable -> L9b
            java.lang.String r0 = java.lang.String.format(r4, r6)     // Catch: java.lang.Throwable -> L9b
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r3, r0)     // Catch: java.lang.Throwable -> L9b
        L59:
            r9.close()     // Catch: java.lang.Exception -> Laa
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r3 = r5.digest()
            r0.<init>(r8, r3)
            java.lang.Object[] r3 = new java.lang.Object[r8]
            r3[r2] = r0
            java.lang.String r4 = "%032x"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            java.lang.String r4 = com.ss.ttvideoengine.VideoCacheManager.TAG
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r2] = r1
            r6 = 16
            java.lang.String r0 = r0.toString(r6)
            r5[r8] = r0
            java.lang.String r0 = "cache md5:%s compute md5:%s"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            com.ss.ttvideoengine.utils.TTVideoEngineLog.i(r4, r0)
            boolean r0 = r1.equals(r3)
            if (r0 == 0) goto L94
            java.lang.String r0 = com.ss.ttvideoengine.VideoCacheManager.TAG
            java.lang.String r1 = "md5 match right"
            com.ss.ttvideoengine.utils.TTVideoEngineLog.i(r0, r1)
            return r8
        L94:
            return r2
        L95:
            long r11 = (long) r10
            long r3 = r3 + r11
            r5.update(r6, r2, r10)     // Catch: java.lang.Throwable -> L9b
            goto L37
        L9b:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch: java.lang.Throwable -> L9e
        L9e:
            r0 = move-exception
            r3 = r0
            r9.close()     // Catch: java.lang.Throwable -> La4
            goto La9
        La4:
            r0 = move-exception
            r4 = r0
            r1.addSuppressed(r4)     // Catch: java.lang.Exception -> Laa
        La9:
            throw r3     // Catch: java.lang.Exception -> Laa
        Laa:
            r0 = move-exception
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r0)
            return r2
        Laf:
            java.lang.String r1 = com.ss.ttvideoengine.VideoCacheManager.TAG
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r0
            long r4 = r5.length()
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            r3[r8] = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            r3[r7] = r0
            java.lang.String r0 = "file not exist or filesize not engough:%s length:%d filesize:%d"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r1, r0)
        Lcf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.VideoCacheManager.checkMD5(java.lang.String, java.lang.String, long):boolean");
    }
}
