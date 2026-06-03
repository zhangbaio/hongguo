package com.vivo.push.util;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NotifyUtil {
    private static BaseNotifyDataAdapter sNotifyData;
    private static String sNotifyDataAdapter;
    private static BaseNotifyLayoutAdapter sNotifyLayout;
    private static String sNotifyLayoutAdapter;

    static {
        Covode.recordClassIndex(655174);
        sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
        sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";
    }

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context context) {
        initAdapter(context);
        return sNotifyData;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context context) {
        initAdapter(context);
        return sNotifyLayout;
    }

    private static synchronized void initAdapter(Context context) {
        synchronized (NotifyUtil.class) {
            if (sNotifyData == null) {
                BaseNotifyDataAdapter baseNotifyDataAdapter = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new k());
                sNotifyData = baseNotifyDataAdapter;
                baseNotifyDataAdapter.init(context);
            }
            if (sNotifyLayout == null) {
                BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new l());
                sNotifyLayout = baseNotifyLayoutAdapter;
                baseNotifyLayoutAdapter.init(context);
            }
        }
    }

    private static Object getObjectByReflect(String str, Object obj) {
        Class cls;
        Object obj2 = null;
        try {
            cls = l3.a.q(str);
        } catch (Exception unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                obj2 = cls.newInstance();
            } catch (Exception unused2) {
            }
        }
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }
}
