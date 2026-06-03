package com.xiaomi.push.service;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ai {
    static {
        Covode.recordClassIndex(655671);
    }

    /* renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[gl.values().length];
            b = iArr;
            try {
                iArr[gl.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[gl.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[gl.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[gl.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[gk.values().length];
            a = iArr2;
            try {
                iArr2[gk.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[gk.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static int a(ah ahVar, gk gkVar) {
        int i = 1;
        if (AnonymousClass1.a[gkVar.ordinal()] != 1) {
            i = 0;
        }
        return ahVar.a(gkVar, i);
    }

    public static void a(ah ahVar, hb hbVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", ahVar, ", configMessage=", hbVar);
        ahVar.a(a(hbVar.a(), true));
        ahVar.b();
    }

    public static void a(ah ahVar, hc hcVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", ahVar, ", configMessage=", hcVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (gn gnVar : hcVar.a()) {
            arrayList.add(new Pair<>(gnVar.m480a(), Integer.valueOf(gnVar.a())));
            List<Pair<Integer, Object>> a = a(gnVar.f527a, false);
            if (!com.xiaomi.push.y.a(a)) {
                arrayList2.addAll(a);
            }
        }
        ahVar.a(arrayList, arrayList2);
        ahVar.b();
    }

    private static List<Pair<Integer, Object>> a(List<gp> list, boolean z) {
        Pair pair;
        if (com.xiaomi.push.y.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gp gpVar : list) {
            int a = gpVar.a();
            gl a2 = gl.a(gpVar.b());
            if (a2 != null) {
                if (z && gpVar.f535a) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    int i = AnonymousClass1.b[a2.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    pair = null;
                                } else {
                                    pair = new Pair(Integer.valueOf(a), Boolean.valueOf(gpVar.g()));
                                }
                            } else {
                                pair = new Pair(Integer.valueOf(a), gpVar.m485a());
                            }
                        } else {
                            pair = new Pair(Integer.valueOf(a), Long.valueOf(gpVar.m484a()));
                        }
                    } else {
                        pair = new Pair(Integer.valueOf(a), Integer.valueOf(gpVar.c()));
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }
}
