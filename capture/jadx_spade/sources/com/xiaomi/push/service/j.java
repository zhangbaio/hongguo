package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j {
    static {
        Covode.recordClassIndex(655718);
    }

    public static boolean a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ComponentName a(Context context, Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                return null;
            }
            if (TextUtils.isEmpty(resolveActivity.activityInfo.targetActivity)) {
                str = resolveActivity.activityInfo.name;
            } else {
                str = resolveActivity.activityInfo.targetActivity;
            }
            return new ComponentName(resolveActivity.activityInfo.packageName, str);
        } catch (Exception unused) {
            return null;
        }
    }
}
