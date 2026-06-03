package com.dragon.read.nuwa;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.covode.number.Covode;
import com.bytedance.shadowhook.ShadowHook;
import com.dragon.read.nuwa.base.report.IReporter;
import com.dragon.read.nuwa.base.util.ReflectUtils;
import com.dragon.read.nuwa.ctrl.BitmapSetSlowPathVisitorCtrl;
import com.dragon.read.nuwa.ctrl.ColorFilterFixCtrl;
import com.dragon.read.nuwa.ctrl.EglBadAccessCtrl;
import com.dragon.read.nuwa.ctrl.EglBadAllocCtrl;
import com.dragon.read.nuwa.ctrl.GCCalmDownCtrl;
import com.dragon.read.nuwa.ctrl.GcStepOptCtrl;
import com.dragon.read.nuwa.ctrl.GetPortFormatCtrl;
import com.dragon.read.nuwa.ctrl.MediaCodecFixCtrl;
import com.dragon.read.nuwa.ctrl.MinFreeHeapOptCtrl;
import com.dragon.read.nuwa.ctrl.ProfileOptCtrl;
import com.dragon.read.nuwa.ctrl.ThreadSuspendCtrl;
import com.dragon.read.nuwa.ctrl.VectorReleaseCtrl;
import com.dragon.read.nuwa.ctrl.WeakRefOverFlowFixCtrl;
import java.util.List;
import java.util.Map;
import l3.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Nuwa {
    private static int KB;
    private static long MB;
    private static boolean heapInited;
    private static boolean isLibLoaded;
    static IReporter sReporter;

    private static native boolean nDestroyFilterFixN();

    private static native boolean nFindHeapFieldOffset(int i, int i2, float f, float f2, float f3);

    private static native boolean nFixBitmapSetSlowPathVisitor();

    private static native boolean nFixEglBadAccess();

    private static native boolean nFixEglBadAlloc();

    private static native boolean nFixMediaCodecSubOverFlow();

    private static native boolean nFixVectorReleaseStorage(int i);

    private static native boolean nGetHeapInitResultAndUnHook();

    private static native boolean nGetPortFormatAddOverFlow();

    private static native boolean nHeapExpand(int i);

    private static native boolean nHookGetTotalMemory();

    private static native void nMinFreeHeapOpt(double d);

    private static native boolean nOptimizeGCStep(long j, long j2, long j3, float f, float f2);

    private static native int nRegisterProfileOptClasses(long j, String[] strArr);

    private static native boolean nRenderNodeWeakRefOverFixN();

    private static native boolean nStopProfileSaverHook();

    private static native boolean nThreadSuspendByPeerWarningFix();

    private static native int nWakeupProfileSaver();

    public static boolean fixVectorReleaseStorage() {
        return fixVectorReleaseStorage(0);
    }

    public static void fixBitmapSetSlowPathVisitor() {
        if (BitmapSetSlowPathVisitorCtrl.enable() && loadLibrary()) {
            nFixBitmapSetSlowPathVisitor();
        }
    }

    public static void fixGetPortFormatAddOverFlow() {
        if (GetPortFormatCtrl.enable() && loadLibrary()) {
            nGetPortFormatAddOverFlow();
        }
    }

    public static void fixMediaCodecSubOverFlow() {
        if (MediaCodecFixCtrl.enable() && loadLibrary()) {
            nFixMediaCodecSubOverFlow();
        }
    }

    public static void stopProfileSaverHook() {
        if (loadLibrary()) {
            nStopProfileSaverHook();
            ProfileOptCtrl.sListener = null;
        }
    }

    static {
        Covode.recordClassIndex(612589);
        sReporter = null;
        heapInited = false;
        isLibLoaded = false;
        KB = 1024;
        MB = 1048576L;
    }

    public static boolean destroyFilterFixN() {
        if (ColorFilterFixCtrl.enable() && loadLibrary()) {
            return nDestroyFilterFixN();
        }
        return false;
    }

    public static boolean fixEglBadAccess() {
        if (EglBadAccessCtrl.enable() && loadLibrary()) {
            return nFixEglBadAccess();
        }
        return false;
    }

    public static boolean fixEglBadAlloc() {
        if (EglBadAllocCtrl.enable() && loadLibrary()) {
            return nFixEglBadAlloc();
        }
        return false;
    }

    private static boolean heapInit() {
        if (!heapInited) {
            boolean nHookGetTotalMemory = nHookGetTotalMemory();
            heapInited = nHookGetTotalMemory;
            if (nHookGetTotalMemory) {
                Runtime.getRuntime().totalMemory();
                heapInited = nGetHeapInitResultAndUnHook();
            }
            return heapInited;
        }
        return true;
    }

    public static boolean threadSuspendByPeerWarningFix() {
        if (ThreadSuspendCtrl.enable() && loadLibrary()) {
            return nThreadSuspendByPeerWarningFix();
        }
        return false;
    }

    public static boolean weakRefOverFlowFixN() {
        if (WeakRefOverFlowFixCtrl.enable() && loadLibrary()) {
            return nRenderNodeWeakRefOverFixN();
        }
        return false;
    }

    public static synchronized boolean loadLibrary() {
        synchronized (Nuwa.class) {
            if (isLibLoaded) {
                return true;
            }
            try {
                ShadowHook.init();
                ByteHook.init();
                System.loadLibrary("nuwa");
                isLibLoaded = true;
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    public static void setReporter(IReporter iReporter) {
        if (sReporter == null) {
            sReporter = iReporter;
        }
    }

    public static void minFreeHeapOpt(double d) {
        if (MinFreeHeapOptCtrl.enable() && loadLibrary()) {
            nMinFreeHeapOpt(d);
        }
    }

    public static int wakeupProfileSaver(ProfileOptCtrl.onProfileChangedListener onprofilechangedlistener) {
        if (loadLibrary()) {
            ProfileOptCtrl.sListener = onprofilechangedlistener;
            return nWakeupProfileSaver();
        }
        return -1;
    }

    public static boolean fixVectorReleaseStorage(int i) {
        if (VectorReleaseCtrl.enable() && loadLibrary()) {
            return nFixVectorReleaseStorage(i);
        }
        return false;
    }

    public static void heapExpand(int i) {
        if (Build.VERSION.SDK_INT <= 34 && loadLibrary() && heapInit()) {
            nHeapExpand(i);
        }
    }

    public static void e(String str, String str2) {
        IReporter iReporter = sReporter;
        if (iReporter != null) {
            iReporter.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        IReporter iReporter = sReporter;
        if (iReporter != null) {
            iReporter.i(str, str2);
        }
    }

    public static void onClassProfileChanged(int i, int i2) {
        ProfileOptCtrl.onProfileChangedListener onprofilechangedlistener = ProfileOptCtrl.sListener;
        if (onprofilechangedlistener != null) {
            onprofilechangedlistener.onClassProfileChanged(i, i2);
        }
    }

    public static void w(String str, String str2) {
        IReporter iReporter = sReporter;
        if (iReporter != null) {
            iReporter.w(str, str2);
        }
    }

    public static void report2Slardar(String str, String str2) {
        if (sReporter != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, str2);
                sReporter.report2Slardar(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static int registerProfileOptClasses(ClassLoader classLoader, List<String> list) {
        if (!loadLibrary()) {
            return 0;
        }
        int i = 0;
        for (Map.Entry<Long, List<String>> entry : ProfileOptCtrl.convertToDexFileAndClassDescriptorMap(classLoader, list).entrySet()) {
            Long key = entry.getKey();
            List<String> value = entry.getValue();
            String[] strArr = new String[value.size()];
            for (int i2 = 0; i2 < value.size(); i2++) {
                strArr[i2] = value.get(i2);
            }
            i += nRegisterProfileOptClasses(key.longValue(), strArr);
        }
        return i;
    }

    public static void gcInactive(float f, float f2, float f3) {
        int i;
        int i2;
        if (GCCalmDownCtrl.enable() && loadLibrary()) {
            Class[] clsArr = {String.class};
            try {
                String str = (String) ReflectUtils.invokeStaticMethod(a.q("android.os.SystemProperties"), "get", clsArr, new Object[]{"dalvik.vm.heapmaxfree"});
                String str2 = (String) ReflectUtils.invokeStaticMethod(a.q("android.os.SystemProperties"), "get", clsArr, new Object[]{"dalvik.vm.heapminfree"});
                i("nuwa", "dalvik.vm.heapmaxfree:" + str);
                i("nuwa", "dalvik.vm.heapminfree:" + str2);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    if (str2.endsWith("m") || str2.endsWith("k")) {
                        if (!str.endsWith("m") && !str.endsWith("k")) {
                            return;
                        }
                        if (str2.endsWith("k")) {
                            i = Integer.valueOf(str2.replace("k", "")).intValue() * KB;
                        } else {
                            i = -1;
                        }
                        if (str2.endsWith("m")) {
                            int intValue = Integer.valueOf(str2.replace("m", "")).intValue();
                            int i3 = KB;
                            i = intValue * i3 * i3;
                        }
                        if (str.endsWith("k")) {
                            i2 = Integer.valueOf(str.replace("k", "")).intValue() * KB;
                        } else {
                            i2 = -1;
                        }
                        if (str.endsWith("m")) {
                            int intValue2 = Integer.valueOf(str.replace("m", "")).intValue();
                            int i4 = KB;
                            i2 = intValue2 * i4 * i4;
                        }
                        if (i != -1 && i2 != -1 && nFindHeapFieldOffset(i, i2, f, f2, f3)) {
                            Runtime.getRuntime().totalMemory();
                        }
                    }
                }
            } catch (Exception e) {
                e("gcInactive", Log.getStackTraceString(e));
            }
        }
    }

    public static void onSetIdealFootPrint(long j, long j2, long j3, float f) {
        long j4;
        GcStepOptCtrl.IGcListener iGcListener = GcStepOptCtrl.sListener;
        if (iGcListener != null) {
            long j5 = j - j3;
            long j6 = j2 - j3;
            if (j6 <= 0) {
                j4 = 0;
            } else {
                j4 = j6;
            }
            if (j5 > 0) {
                iGcListener.onGcStepUpdate(j5, j4, f);
            }
        }
    }

    public static boolean optimizeGCStep(int i, int i2, int i3, float f, float f2) {
        if (!loadLibrary()) {
            return false;
        }
        long j = MB;
        return nOptimizeGCStep(i * j, i2 * j, i3 * j, f, f2);
    }
}
