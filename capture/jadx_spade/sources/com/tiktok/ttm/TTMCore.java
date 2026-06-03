package com.tiktok.ttm;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tiktok.ttm.TTMOutput;
import com.tiktok.ttm.action.TTMAppLog;
import com.tiktok.ttm.storage.TTMCoreKVManager;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTMCore {
    private static final TTMCore sInstance;
    private volatile boolean isInited = false;
    private volatile Config mConfig;

    public static class Config {
        public boolean crashDumpEnable;
        public boolean debugModeEnable;
        public boolean globalEnable;
        public boolean isLocalTest;
        public String machineWorkDir;
        public MetricReporter metricReporter;
        public boolean monitorRuleRunException;
        public int multiInstCacheDefaultSize;
        public boolean multiInstCacheEnable;
        public int multiInstCacheMaxSize;
        public boolean reportEnable;
        public SendAppLog sendAppLog;
        public int timeStaticConfig;
        public boolean openJniCallOptimize = true;
        public int ttmHostStaticCacheSize = -1;
        public int coreBuriedSamplingRate = 100;
        public int generalBuriedSamplingRate = 1000;

        static {
            Covode.recordClassIndex(653988);
        }
    }

    public interface MetricReporter {
        void report(String str, String str2);
    }

    public interface SendAppLog {
        void sendAppLog(String str, JSONObject jSONObject);
    }

    private static class JNIHelper {
        static {
            Covode.recordClassIndex(653989);
        }

        private JNIHelper() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static native String dumpInfo(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native void execute(TTMParamData tTMParamData, int i, long j, long j2, long j3, TTMOutput tTMOutput, TTMContext tTMContext);

        /* JADX INFO: Access modifiers changed from: private */
        public static native void execute(TTMParamData tTMParamData, int i, long j, String str, long j2, TTMOutput tTMOutput, TTMContext tTMContext);

        /* JADX INFO: Access modifiers changed from: private */
        public static native void execute(TTMParamData tTMParamData, int i, long j, byte[] bArr, int i2, long j2, TTMOutput tTMOutput, TTMContext tTMContext);

        /* JADX INFO: Access modifiers changed from: private */
        public static native void init(long[] jArr, int i, String str);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long parseTTMRuleByteCode(String str, long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long parseTTMRuleByteCode(byte[] bArr, long j, long j2);

        /* JADX INFO: Access modifiers changed from: private */
        public static native void prepareAsNeeded();

        /* JADX INFO: Access modifiers changed from: private */
        public static native byte[] processTTMRuleByteCode(String str, long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native void releaseTTMRuleByteCode(long j);

        private static void reportMetric(String str, String str2) {
            TTMCore.getInstance().reportMetric(str, str2);
        }
    }

    public static TTMCore getInstance() {
        return sInstance;
    }

    public boolean isInit() {
        return this.isInited;
    }

    private TTMCore() {
    }

    public void prepareAsNeeded() {
        if (!isEnable()) {
            return;
        }
        JNIHelper.prepareAsNeeded();
    }

    static {
        Covode.recordClassIndex(653987);
        sInstance = new TTMCore();
        TTMCoreKVManager.forceInit();
    }

    public boolean isEnable() {
        if (isInit() && this.mConfig != null && this.mConfig.globalEnable) {
            return true;
        }
        return false;
    }

    private long generateSampleRate(Config config) {
        return (config.coreBuriedSamplingRate << 32) | config.generalBuriedSamplingRate;
    }

    public void releaseTTMRuleByteCode(long j) {
        if (isEnable()) {
            JNIHelper.releaseTTMRuleByteCode(j);
        }
    }

    private int generateMutilInstCfg(Config config) {
        if (config.multiInstCacheEnable) {
            return (config.multiInstCacheDefaultSize & 255) | ((config.multiInstCacheMaxSize & 255) << 8);
        }
        return 0;
    }

    private long[] makeTTMConfig(Config config) {
        return new long[]{generateCommonCfg(config), generateMutilInstCfg(config), generateSampleRate(config), config.ttmHostStaticCacheSize};
    }

    public String dump(long j) {
        if (!isEnable()) {
            return "null";
        }
        if (this.mConfig.crashDumpEnable) {
            return JNIHelper.dumpInfo(j);
        }
        return "d-null";
    }

    public void initTTM(Config config) {
        if (this.isInited) {
            return;
        }
        synchronized (this) {
            if (this.isInited) {
                return;
            }
            if (config.machineWorkDir == null) {
                return;
            }
            TTMAppLog.initAppLogCallBack(config.sendAppLog);
            this.mConfig = config;
            long[] makeTTMConfig = makeTTMConfig(config);
            JNIHelper.init(makeTTMConfig, makeTTMConfig.length, config.machineWorkDir);
            this.isInited = true;
        }
    }

    private long generateCommonCfg(Config config) {
        long j;
        long j2 = 0;
        if (config == null) {
            return 0L;
        }
        if (config.globalEnable) {
            j2 = 1;
        }
        int i = config.timeStaticConfig;
        if (i == 1) {
            j = 4;
        } else if (i == 2) {
            j = 8;
        } else {
            j = 2;
        }
        long j3 = j2 | j;
        if (config.reportEnable) {
            j3 |= 16;
        }
        if (config.multiInstCacheEnable) {
            j3 |= 32;
        }
        if (config.openJniCallOptimize) {
            j3 |= 64;
        }
        if (config.monitorRuleRunException) {
            j3 |= 128;
        }
        if (config.isLocalTest) {
            return j3 | 256;
        }
        return j3;
    }

    public TTMOutput execute(TTMInput tTMInput) {
        TTMOutput tTMOutput = new TTMOutput();
        tTMOutput.type = TTMOutput.ReturnType.ERROR;
        tTMOutput.msg = "ttm not init ";
        if (!isEnable()) {
            return tTMOutput;
        }
        long j = tTMInput.machineCodeAddress;
        if (j == 0) {
            byte[] bArr = tTMInput.machineCodeByte;
            if (bArr == null) {
                String str = tTMInput.machineCode;
                if (str == null) {
                    tTMOutput.msg = "ttm machine rule is null";
                } else {
                    JNIHelper.execute(tTMInput.paramData, tTMInput.paramType.typeVal, tTMInput.nativeParamAddress, str, tTMInput.extendedFunc, tTMOutput, tTMInput.ttmContext);
                }
            } else {
                JNIHelper.execute(tTMInput.paramData, tTMInput.paramType.typeVal, tTMInput.nativeParamAddress, bArr, bArr.length, tTMInput.extendedFunc, tTMOutput, tTMInput.ttmContext);
            }
        } else {
            JNIHelper.execute(tTMInput.paramData, tTMInput.paramType.typeVal, tTMInput.nativeParamAddress, j, tTMInput.extendedFunc, tTMOutput, tTMInput.ttmContext);
        }
        return tTMOutput;
    }

    public long parseTTMRuleByteCode(String str, long j) {
        if (isEnable()) {
            return JNIHelper.parseTTMRuleByteCode(str, j);
        }
        return 0L;
    }

    public byte[] processTTMRuleByteCode(String str, long j) {
        if (isEnable()) {
            return JNIHelper.processTTMRuleByteCode(str, j);
        }
        return null;
    }

    public long parseTTMRuleByteCode(byte[] bArr, long j) {
        if (!isEnable()) {
            return 0L;
        }
        return JNIHelper.parseTTMRuleByteCode(bArr, bArr.length, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMetric(String str, String str2) {
        if (this.mConfig.debugModeEnable) {
            Log.d("TTM/TTMCore", "tt-metrics: eventName: " + str + " | " + str2);
        }
        try {
            if (this.mConfig.metricReporter != null) {
                this.mConfig.metricReporter.report(str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
