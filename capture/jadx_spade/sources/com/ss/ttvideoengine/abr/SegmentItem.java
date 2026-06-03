package com.ss.ttvideoengine.abr;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.ttvideoengine.utils.TTHelper;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SegmentItem {
    private static boolean loadClassFailed;
    private static Method sidxItemGetDuration;
    private static Method sidxItemGetIndex;
    private static Method sidxItemGetOffset;
    private static Method sidxItemGetSize;
    private static Method sidxItemGetTimeStamp;
    private static Class<?> sidxItemObjectClass;
    private boolean loadObjectSucceed;
    private Long mDuration;
    private Integer mIndex;
    private Long mOffset;
    private Long mSize;
    private Long mTimeStamp;
    private Object playerSidxItem;

    private static Object com_ss_ttvideoengine_abr_SegmentItem_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(652398);
        loadClassFailed = false;
    }

    public long getDuration() {
        Method method;
        Long l = this.mDuration;
        if (l != null) {
            return l.longValue();
        }
        if (!this.loadObjectSucceed || (method = sidxItemGetDuration) == null) {
            return -1L;
        }
        try {
            Long l2 = (Long) com_ss_ttvideoengine_abr_SegmentItem_java_lang_reflect_Method_invoke(method, this.playerSidxItem, new Object[0]);
            this.mDuration = l2;
            return l2.longValue();
        } catch (Exception unused) {
            this.mDuration = -1L;
            return -1L;
        }
    }

    public int getIndex() {
        Method method;
        Integer num = this.mIndex;
        if (num != null) {
            return num.intValue();
        }
        if (!this.loadObjectSucceed || (method = sidxItemGetIndex) == null) {
            return -1;
        }
        try {
            Integer num2 = (Integer) com_ss_ttvideoengine_abr_SegmentItem_java_lang_reflect_Method_invoke(method, this.playerSidxItem, new Object[0]);
            this.mIndex = num2;
            return num2.intValue();
        } catch (Exception unused) {
            this.mIndex = -1;
            return -1;
        }
    }

    public long getOffset() {
        Method method;
        Long l = this.mOffset;
        if (l != null) {
            return l.longValue();
        }
        if (!this.loadObjectSucceed || (method = sidxItemGetOffset) == null) {
            return -1L;
        }
        try {
            Long l2 = (Long) com_ss_ttvideoengine_abr_SegmentItem_java_lang_reflect_Method_invoke(method, this.playerSidxItem, new Object[0]);
            this.mOffset = l2;
            return l2.longValue();
        } catch (Exception unused) {
            this.mOffset = -1L;
            return -1L;
        }
    }

    public long getSize() {
        Method method;
        Long l = this.mSize;
        if (l != null) {
            return l.longValue();
        }
        if (!this.loadObjectSucceed || (method = sidxItemGetSize) == null) {
            return -1L;
        }
        try {
            Long l2 = (Long) com_ss_ttvideoengine_abr_SegmentItem_java_lang_reflect_Method_invoke(method, this.playerSidxItem, new Object[0]);
            this.mSize = l2;
            return l2.longValue();
        } catch (Exception unused) {
            this.mSize = -1L;
            return -1L;
        }
    }

    public long getTimestamp() {
        Method method;
        Long l = this.mTimeStamp;
        if (l != null) {
            return l.longValue();
        }
        if (!this.loadObjectSucceed || (method = sidxItemGetTimeStamp) == null) {
            return -1L;
        }
        try {
            Long l2 = (Long) com_ss_ttvideoengine_abr_SegmentItem_java_lang_reflect_Method_invoke(method, this.playerSidxItem, new Object[0]);
            this.mTimeStamp = l2;
            return l2.longValue();
        } catch (Exception unused) {
            this.mTimeStamp = -1L;
            return -1L;
        }
    }

    public SegmentItem(Object obj) {
        this.loadObjectSucceed = false;
        this.playerSidxItem = obj;
        Class<?> cls = sidxItemObjectClass;
        if (cls == null && !loadClassFailed) {
            try {
                Class<?> clzUsingPluginLoader = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.SidxListObject$SidxItem");
                sidxItemObjectClass = clzUsingPluginLoader;
                sidxItemGetIndex = clzUsingPluginLoader.getMethod("getIndex", new Class[0]);
                sidxItemGetOffset = sidxItemObjectClass.getMethod("getOffset", new Class[0]);
                sidxItemGetTimeStamp = sidxItemObjectClass.getMethod("getTimestamp", new Class[0]);
                sidxItemGetDuration = sidxItemObjectClass.getMethod("getDuration", new Class[0]);
                sidxItemGetSize = sidxItemObjectClass.getMethod("getSize", new Class[0]);
            } catch (Exception unused) {
                this.playerSidxItem = null;
                loadClassFailed = true;
            }
        } else if (cls == null) {
            this.playerSidxItem = null;
        }
        Object obj2 = this.playerSidxItem;
        if (obj2 != null && obj2.getClass().equals(sidxItemObjectClass)) {
            this.loadObjectSucceed = true;
        }
    }
}
