package com.ss.ttvideoengine.playermetrcis;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.NativeThreadInterface;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ThreadCPU {
    public static NativeThreadInterface gNativeThreadInterface;
    public static boolean sCpuRefreshFix;
    public static boolean sUseNativeThread;
    private final ConcurrentHashMap<String, Object> mCpuMap = new ConcurrentHashMap<>();
    private CopyOnWriteArrayList<ThreadInfo> mStaticThreads = null;
    private CopyOnWriteArrayList<ThreadInfo> mSingleThreads = null;
    private CopyOnWriteArrayList<Integer> mNativeTids = null;
    private ThreadInfo total = null;
    private int mMdlCpuOverZero = 0;

    public void refreshWhenBegin() {
        refreshForVV();
    }

    public void refreshWhenEnd() {
        refreshForVV();
    }

    public Map<String, Object> getPlayerThreads() {
        return new HashMap(this.mCpuMap);
    }

    static {
        Covode.recordClassIndex(652601);
        sCpuRefreshFix = false;
        sUseNativeThread = false;
        gNativeThreadInterface = null;
    }

    public void refresh() {
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.playermetrcis.b
            @Override // java.lang.Runnable
            public final void run() {
                ThreadCPU.this.lambda$refresh$0();
            }
        });
    }

    public void refreshStaticThreads() {
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.playermetrcis.a
            @Override // java.lang.Runnable
            public final void run() {
                ThreadCPU.this.lambda$refreshStaticThreads$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshForVV$1() {
        for (int i = 0; i < this.mSingleThreads.size(); i++) {
            refreshInternal(this.mSingleThreads.get(i));
        }
    }

    private void refreshForVV() {
        CopyOnWriteArrayList<ThreadInfo> copyOnWriteArrayList = this.mSingleThreads;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        if (this.mSingleThreads.size() > 0 && this.mSingleThreads.get(0).cpuTime == -1) {
            return;
        }
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.playermetrcis.c
            @Override // java.lang.Runnable
            public final void run() {
                ThreadCPU.this.lambda$refreshForVV$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshStaticThreads$2() {
        File[] listFiles;
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper("/proc/" + Process.myPid() + "/task/");
            if (polarisFileWrapper.isDirectory() && (listFiles = polarisFileWrapper.listFiles()) != null) {
                for (File file : listFiles) {
                    String readFile = readFile(file.getPath() + "/stat");
                    if (!readFile.isEmpty()) {
                        try {
                            transStaticThread(parseStat(readFile));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$0() {
        HashSet<String> hashSet;
        String str;
        NativeThreadInterface nativeThreadInterface;
        if (sUseNativeThread && (nativeThreadInterface = gNativeThreadInterface) != null) {
            nativeThreadInterface.carethreadList(this.mNativeTids);
        }
        for (int i = 0; i < this.mStaticThreads.size(); i++) {
            ThreadInfo threadInfo = this.mStaticThreads.get(i);
            if (!sCpuRefreshFix || i != 0) {
                if (threadInfo.type == 2 && (hashSet = threadInfo.pids) != null && hashSet.size() > 0 && (str = threadInfo.pidName) != null && str.contains("MediaLoad")) {
                    this.mCpuMap.put("mdl_cpu_rate", Float.valueOf((float) (this.mMdlCpuOverZero / (threadInfo.pids.size() * 1.0d))));
                }
                refreshInternal(threadInfo);
            }
        }
        for (int i2 = 0; i2 < this.mSingleThreads.size(); i2++) {
            refreshInternal(this.mSingleThreads.get(i2));
        }
        ThreadInfo threadInfo2 = this.total;
        if (threadInfo2 != null && sCpuRefreshFix) {
            getProcInfo(threadInfo2);
        }
    }

    protected ThreadInfo getProcInfo(ThreadInfo threadInfo) {
        if (sUseNativeThread && gNativeThreadInterface != null) {
            getSingleCpuTime(null, threadInfo);
        } else {
            getSingleCpuTime(readFile("/proc/self/stat"), threadInfo);
        }
        float f = threadInfo.cpuUsage;
        if (f > 0.0f) {
            this.mCpuMap.put("proc", Float.valueOf(f));
        }
        return threadInfo;
    }

    protected String[] parseStat(String str) {
        String[] strArr = new String[2];
        char[] charArray = str.toCharArray();
        String str2 = null;
        String str3 = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            char c = charArray[i];
            if (c == ' ' && str3 == null) {
                str3 = new String(charArray, 0, i);
            }
            if (c == '(') {
                i2 = i + 1;
            }
            if (c == ')') {
                str2 = new String(charArray, i2, i - i2);
                break;
            }
            i++;
        }
        strArr[0] = str3;
        strArr[1] = str2;
        return strArr;
    }

    private ThreadInfo refreshCpu(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return null;
        }
        ThreadInfo threadInfo2 = this.total;
        if (threadInfo2 != null && !sCpuRefreshFix) {
            getProcInfo(threadInfo2);
        }
        int i = threadInfo.type;
        if (i == 1) {
            getSingleThreadInfoByID(threadInfo.pid, threadInfo);
        } else if (i == 2) {
            if (threadInfo.pids == null) {
                return threadInfo;
            }
            threadInfo.cpuTime = 0L;
            if (threadInfo.currentTime == 0) {
                threadInfo.currentTime = System.currentTimeMillis();
            }
            getMultiThreadInfoByID(threadInfo.pids, threadInfo);
            if (threadInfo.cpuTimeStart == 0) {
                threadInfo.cpuTimeStart = threadInfo.cpuTime;
            } else {
                threadInfo.cpuUsage = (threadInfo.cpuTime - r2) / (System.currentTimeMillis() - threadInfo.currentTime);
            }
        }
        return threadInfo;
    }

    private void refreshInternal(ThreadInfo threadInfo) {
        String str;
        String lowerCase;
        refreshCpu(threadInfo);
        if (threadInfo != null && (str = threadInfo.pidName) != null) {
            if (str.contains("-")) {
                int indexOf = threadInfo.pidName.indexOf("-");
                if (indexOf > 0) {
                    lowerCase = threadInfo.pidName.substring(0, indexOf);
                    if (lowerCase != null) {
                        lowerCase = lowerCase.toLowerCase(Locale.ROOT);
                    }
                } else {
                    lowerCase = null;
                }
            } else {
                lowerCase = threadInfo.pidName.toLowerCase(Locale.ROOT);
            }
            if (lowerCase != null) {
                if (sCpuRefreshFix) {
                    float f = threadInfo.cpuUsage;
                    if (f != -1.0f) {
                        this.mCpuMap.put(lowerCase, Float.valueOf(f));
                        return;
                    }
                    return;
                }
                this.mCpuMap.put(lowerCase, Float.valueOf(threadInfo.cpuUsage));
            }
        }
    }

    boolean initThreadMonitor(ArrayList<String> arrayList) {
        int i = 0;
        if (arrayList == null) {
            return false;
        }
        this.mStaticThreads = new CopyOnWriteArrayList<>();
        this.mSingleThreads = new CopyOnWriteArrayList<>();
        this.mNativeTids = new CopyOnWriteArrayList<>();
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.pidName = "proc";
        threadInfo.type = 1;
        this.total = threadInfo;
        ThreadInfo threadInfo2 = new ThreadInfo();
        threadInfo2.pidName = "self";
        threadInfo2.pid = Process.myPid() + "";
        threadInfo2.type = 1;
        this.mStaticThreads.add(threadInfo2);
        while (i < arrayList.size()) {
            String str = arrayList.get(i);
            i++;
            initProc(str, i);
        }
        return true;
    }

    protected long parseTime(String str) {
        if (str == null || str.isEmpty()) {
            return -1L;
        }
        char[] charArray = str.toCharArray();
        String str2 = null;
        int i = 0;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            char c = charArray[i];
            if (c == ' ') {
                if (i2 == 12) {
                    str3 = new String(charArray, i3, i - i3);
                } else if (i2 == 13) {
                    str2 = new String(charArray, i3, i - i3);
                    break;
                }
                if (z) {
                    i2++;
                    i3 = i + 1;
                }
            }
            if (c == ')') {
                z = true;
            }
            i++;
        }
        if (str3 == null || str2 == null) {
            return -1L;
        }
        try {
            return (Integer.parseInt(str3) + Integer.parseInt(str2)) * 10;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    protected String readFile(String str) {
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(str);
            try {
                bufferedInputStream = new BufferedInputStream(polarisFileInputStreamWrapper);
                try {
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    String sb2 = sb.toString();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        polarisFileInputStreamWrapper.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return sb2;
                } catch (Exception unused) {
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (polarisFileInputStreamWrapper != null) {
                        try {
                            polarisFileInputStreamWrapper.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (polarisFileInputStreamWrapper != null) {
                        try {
                            polarisFileInputStreamWrapper.close();
                            throw th;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Exception unused3) {
            polarisFileInputStreamWrapper = null;
        } catch (Throwable th4) {
            polarisFileInputStreamWrapper = null;
            th = th4;
            bufferedInputStream = null;
        }
    }

    public void refreshSingleThreads(String str) {
        if (TextUtils.isEmpty(str) || this.mSingleThreads == null) {
            return;
        }
        String[] split = str.split("=|;");
        this.mSingleThreads.clear();
        this.mNativeTids.clear();
        for (int i = 0; i < split.length - 1; i += 2) {
            ThreadInfo threadInfo = new ThreadInfo();
            threadInfo.type = 1;
            threadInfo.pidName = split[i];
            int i2 = i + 1;
            threadInfo.pid = split[i2];
            this.mSingleThreads.add(threadInfo);
            if (sUseNativeThread) {
                try {
                    this.mNativeTids.add(Integer.valueOf(Integer.parseInt(split[i2])));
                } catch (Exception unused) {
                }
            }
        }
    }

    void transStaticThread(String[] strArr) {
        for (int i = 1; i < this.mStaticThreads.size() + 1; i++) {
            if (strArr.length == 2 && strArr[1].startsWith(this.mStaticThreads.get(i).pidName)) {
                if (this.mStaticThreads.get(i).type == 2) {
                    transMulti(strArr, i);
                    return;
                }
                ThreadInfo threadInfo = this.mStaticThreads.get(i);
                threadInfo.reset();
                threadInfo.pid = strArr[0];
                threadInfo.currentTime = System.currentTimeMillis();
                return;
            }
        }
    }

    protected void initProc(String str, int i) {
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.pidName = str;
        if (str != null && str.equals("MediaLoad")) {
            threadInfo.type = 2;
        } else {
            threadInfo.type = 1;
        }
        this.mStaticThreads.add(threadInfo);
    }

    protected ThreadInfo getSingleThreadInfoByID(String str, ThreadInfo threadInfo) {
        if (threadInfo == null) {
            threadInfo = new ThreadInfo();
        }
        if (str == null) {
            return threadInfo;
        }
        getSingleCpuTime(readFile("/proc/self/task/" + str + "/stat"), threadInfo);
        return threadInfo;
    }

    private ThreadInfo getSingleCpuTime(String str, ThreadInfo threadInfo) {
        NativeThreadInterface nativeThreadInterface;
        if (threadInfo == null) {
            threadInfo = new ThreadInfo();
        }
        if (sUseNativeThread && (nativeThreadInterface = gNativeThreadInterface) != null) {
            try {
                threadInfo.cpuUsage = nativeThreadInterface.getThreadCpuUsage(Integer.parseInt(threadInfo.pid));
            } catch (Exception unused) {
            }
        } else {
            long parseTime = parseTime(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (threadInfo.currentTime != 0) {
                if (parseTime == -1) {
                    threadInfo.cpuUsage = -1.0f;
                } else {
                    threadInfo.cpuUsage = (parseTime - threadInfo.cpuTime) / (currentTimeMillis - r4);
                }
            } else {
                threadInfo.cpuUsage = -1.0f;
            }
            threadInfo.cpuTime = parseTime;
            threadInfo.currentTime = currentTimeMillis;
        }
        return threadInfo;
    }

    protected ThreadInfo getMultiThreadInfoByID(HashSet<String> hashSet, ThreadInfo threadInfo) {
        if (threadInfo == null) {
            threadInfo = new ThreadInfo();
        }
        this.mMdlCpuOverZero = 0;
        Iterator<String> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            String readFile = readFile("/proc/self/task/" + next + "/stat");
            if (readFile != null && !readFile.isEmpty()) {
                getMultiCpuTime(readFile, threadInfo, next);
            } else {
                it2.remove();
            }
        }
        return threadInfo;
    }

    protected boolean transMulti(String[] strArr, int i) {
        HashSet<String> hashSet;
        if (this.mStaticThreads.get(i).pids == null) {
            this.mStaticThreads.get(i).pids = new HashSet<>();
        }
        if (this.mStaticThreads.get(i).mMutiThreadUsage == null) {
            this.mStaticThreads.get(i).mMutiThreadUsage = new HashMap<>();
        }
        if (this.mStaticThreads.get(i).pids != null && (hashSet = this.mStaticThreads.get(i).pids) != null && !hashSet.contains(strArr[0])) {
            hashSet.add(strArr[0]);
            return true;
        }
        return true;
    }

    private ThreadInfo getMultiCpuTime(String str, ThreadInfo threadInfo, String str2) {
        Object obj;
        if (threadInfo == null) {
            threadInfo = new ThreadInfo();
        }
        long parseTime = parseTime(str);
        if (parseTime != -1) {
            HashMap<String, Object> hashMap = threadInfo.mMutiThreadUsage;
            if (hashMap != null) {
                if (hashMap.containsKey(str2) && (obj = threadInfo.mMutiThreadUsage.get(str2)) != null && parseTime - ((Long) obj).longValue() > 0) {
                    this.mMdlCpuOverZero++;
                }
                threadInfo.mMutiThreadUsage.put(str2, Long.valueOf(parseTime));
            }
            threadInfo.cpuTime += parseTime;
        }
        return threadInfo;
    }
}
