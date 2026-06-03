package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.push.ax;
import com.xiaomi.push.ge;
import com.xiaomi.push.gt;
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
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class r {
    static {
        Covode.recordClassIndex(655318);
    }

    /* renamed from: com.xiaomi.mipush.sdk.r$1, reason: invalid class name */
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
        byte[] m539a;
        if (haVar.m541b()) {
            byte[] a = f.a(context, haVar, d.ASSEMBLE_PUSH_FCM);
            if (a == null) {
                a = ax.m165a(b.m79a(context).d());
            }
            try {
                m539a = com.xiaomi.push.h.a(a, haVar.m539a());
            } catch (Exception e) {
                throw new l("the aes decrypt failed.", e);
            }
        } else {
            m539a = haVar.m539a();
        }
        hp a2 = a(haVar.a(), haVar.f657b);
        if (a2 != null) {
            ho.a(a2, m539a);
        }
        return a2;
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

    protected static <T extends hp<T, ?>> ha a(Context context, T t, ge geVar) {
        return a(context, t, geVar, !geVar.equals(ge.Registration), context.getPackageName(), b.m79a(context).m80a());
    }

    protected static <T extends hp<T, ?>> ha a(Context context, T t, ge geVar, boolean z, String str, String str2) {
        return a(context, t, geVar, z, str, str2, true);
    }

    protected static <T extends hp<T, ?>> ha b(Context context, T t, ge geVar, boolean z, String str, String str2) {
        return a(context, t, geVar, z, str, str2, false);
    }

    protected static <T extends hp<T, ?>> ha a(Context context, T t, ge geVar, boolean z, String str, String str2, boolean z2) {
        byte[] a = ho.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        ha haVar = new ha();
        if (z) {
            String d = b.m79a(context).d();
            if (TextUtils.isEmpty(d)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("regSecret is empty, return null");
                return null;
            }
            try {
                a = com.xiaomi.push.h.b(ax.m165a(d), a);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        gt gtVar = new gt();
        gtVar.f577a = 5L;
        gtVar.f578a = "fakeid";
        haVar.a(gtVar);
        haVar.a(ByteBuffer.wrap(a));
        haVar.a(geVar);
        haVar.b(z2);
        haVar.b(str);
        haVar.a(z);
        haVar.a(str2);
        return haVar;
    }
}
