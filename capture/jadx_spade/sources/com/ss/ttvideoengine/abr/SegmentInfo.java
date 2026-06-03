package com.ss.ttvideoengine.abr;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.ttvideoengine.utils.TTHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SegmentInfo {
    private static boolean loadClassFailed;
    private static Method sidxGetBitRate;
    private static Method sidxGetEndIndex;
    private static Method sidxGetFileId;
    private static Method sidxGetItem;
    private static Method sidxGetMediaType;
    private static Method sidxGetStartIndex;
    private static Method sidxGetTotalNum;
    private static Class<?> sidxListObjectClass;
    private boolean loadObjectSucceed;
    private Long mBitrate;
    private Integer mEndIndex;
    private String mFileId;
    private Integer mMediaType;
    private Integer mStartIndex;
    private Integer mTotalNum;
    private Object playerSidxList;

    private static Object com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(652397);
        loadClassFailed = false;
    }

    public long getBitrate() {
        Method method;
        Long l = this.mBitrate;
        if (l != null) {
            return l.longValue();
        }
        if (!this.loadObjectSucceed || (method = sidxGetBitRate) == null) {
            return -1L;
        }
        try {
            Long l2 = (Long) com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(method, this.playerSidxList, new Object[0]);
            this.mBitrate = l2;
            return l2.longValue();
        } catch (Exception unused) {
            this.mBitrate = -1L;
            return -1L;
        }
    }

    public int getEndIndex() {
        Method method;
        Integer num = this.mEndIndex;
        if (num != null) {
            return num.intValue();
        }
        if (!this.loadObjectSucceed || (method = sidxGetEndIndex) == null) {
            return 0;
        }
        try {
            Integer num2 = (Integer) com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(method, this.playerSidxList, new Object[0]);
            this.mEndIndex = num2;
            return num2.intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getFileId() {
        Method method;
        String str = this.mFileId;
        if (str != null) {
            return str;
        }
        if (this.loadObjectSucceed && (method = sidxGetFileId) != null) {
            try {
                this.mFileId = (String) com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(method, this.playerSidxList, new Object[0]);
            } catch (Exception unused) {
                this.mFileId = null;
            }
        }
        return this.mFileId;
    }

    public List<Object> getItems() {
        ArrayList arrayList = new ArrayList();
        if (this.loadObjectSucceed && sidxGetItem != null) {
            for (int i = 0; getStartIndex() + i <= getEndIndex(); i++) {
                try {
                    arrayList.add(new SegmentItem(com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(sidxGetItem, this.playerSidxList, new Object[]{Integer.valueOf(i)})));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public int getMediaType() {
        Method method;
        Integer num = this.mMediaType;
        if (num != null) {
            return num.intValue();
        }
        if (!this.loadObjectSucceed || (method = sidxGetMediaType) == null) {
            return -1;
        }
        try {
            Integer num2 = (Integer) com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(method, this.playerSidxList, new Object[0]);
            this.mMediaType = num2;
            return num2.intValue();
        } catch (Exception unused) {
            this.mMediaType = -1;
            return -1;
        }
    }

    public int getStartIndex() {
        Method method;
        Integer num = this.mStartIndex;
        if (num != null) {
            return num.intValue();
        }
        if (!this.loadObjectSucceed || (method = sidxGetStartIndex) == null) {
            return 0;
        }
        try {
            Integer num2 = (Integer) com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(method, this.playerSidxList, new Object[0]);
            this.mStartIndex = num2;
            return num2.intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public int getTotalNum() {
        Method method;
        Integer num = this.mTotalNum;
        if (num != null) {
            return num.intValue();
        }
        if (!this.loadObjectSucceed || (method = sidxGetTotalNum) == null) {
            return -1;
        }
        try {
            Integer num2 = (Integer) com_ss_ttvideoengine_abr_SegmentInfo_java_lang_reflect_Method_invoke(method, this.playerSidxList, new Object[0]);
            this.mTotalNum = num2;
            return num2.intValue();
        } catch (Exception unused) {
            this.mTotalNum = -1;
            return -1;
        }
    }

    public SegmentInfo(Object obj) {
        this.loadObjectSucceed = false;
        this.playerSidxList = obj;
        Class<?> cls = sidxListObjectClass;
        if (cls == null && !loadClassFailed) {
            try {
                Class<?> clzUsingPluginLoader = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.SidxListObject");
                sidxListObjectClass = clzUsingPluginLoader;
                sidxGetMediaType = clzUsingPluginLoader.getMethod("getMediaType", new Class[0]);
                sidxGetTotalNum = sidxListObjectClass.getMethod("getTotalNum", new Class[0]);
                sidxGetStartIndex = sidxListObjectClass.getMethod("getStartIndex", new Class[0]);
                sidxGetEndIndex = sidxListObjectClass.getMethod("getEndIndex", new Class[0]);
                sidxGetBitRate = sidxListObjectClass.getMethod("getBitrate", new Class[0]);
                sidxGetFileId = sidxListObjectClass.getMethod("getFileId", new Class[0]);
                sidxGetItem = sidxListObjectClass.getMethod("getItem", Integer.TYPE);
            } catch (Exception unused) {
                this.playerSidxList = null;
                loadClassFailed = true;
            }
        } else if (cls == null) {
            this.playerSidxList = null;
        }
        Object obj2 = this.playerSidxList;
        if (obj2 != null && obj2.getClass().equals(sidxListObjectClass)) {
            this.loadObjectSucceed = true;
        }
    }
}
