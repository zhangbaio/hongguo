package com.xiaomi.push.service;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.push.ge;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.gz;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bc {
    static {
        Covode.recordClassIndex(655706);
    }

    /* renamed from: com.xiaomi.push.service.bc$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ge.values().length];
            a = iArr;
            try {
                iArr[ge.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ge.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ge.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ge.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ge.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ge.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ge.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ge.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ge.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ge.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static hp a(Context context, ha haVar) {
        if (haVar.m541b()) {
            return null;
        }
        byte[] m539a = haVar.m539a();
        hp a = a(haVar.a(), haVar.f657b);
        if (a != null) {
            ho.a(a, m539a);
        }
        return a;
    }

    private static hp a(ge geVar, boolean z) {
        switch (AnonymousClass1.a[geVar.ordinal()]) {
            case 1:
                return new hf();
            case 2:
                return new hl();
            case 3:
                return new hj();
            case 4:
                return new hn();
            case 5:
                return new hh();
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return new gu();
            case 7:
                return new gz();
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return new hg();
            case 9:
                if (z) {
                    return new hd();
                }
                gv gvVar = new gv();
                gvVar.a(true);
                return gvVar;
            case 10:
                return new gz();
            default:
                return null;
        }
    }
}
