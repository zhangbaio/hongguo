package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.push.g;
import com.xiaomi.push.service.ag;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static final SparseArray<ag.a<String, String, String>> a;

    static {
        Covode.recordClassIndex(655656);
        a = new SparseArray<ag.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.a.1
            {
                put(1, ag.g);
                put(2, ag.f);
                put(4, ag.e);
                put(8, ag.b);
                put(16, ag.c);
                put(32, ag.h);
            }
        };
    }

    private static Bundle a(String str) {
        return ag.a(com.xiaomi.push.q.m640a(), str, (String) null);
    }

    private static int a(String str, int i) {
        return ag.a(com.xiaomi.push.q.m640a(), str, null, a.get(i));
    }

    public static int a(Context context, String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            g.b a2 = com.xiaomi.push.g.a(context, str, true);
            if (a2 == g.b.ALLOWED) {
                i6 = 1;
            } else if (a2 == g.b.NOT_ALLOWED) {
                i6 = 2;
            }
            int i7 = 32;
            int i8 = 8;
            if (ag.a()) {
                Bundle a3 = a(str);
                ag.a<String, String, String> aVar = ag.g;
                if (a3.containsKey(aVar.c)) {
                    if (a3.getBoolean(aVar.c)) {
                        i8 = 4;
                    }
                    i6 |= i8;
                }
                ag.a<String, String, String> aVar2 = ag.e;
                if (a3.containsKey(aVar2.c)) {
                    if (a3.getBoolean(aVar2.c)) {
                        i7 = 16;
                    }
                    i6 |= i7;
                }
                ag.a<String, String, String> aVar3 = ag.f;
                if (a3.containsKey(aVar3.c)) {
                    if (a3.getBoolean(aVar3.c)) {
                        i5 = 64;
                    } else {
                        i5 = 128;
                    }
                    i6 |= i5;
                }
                ag.a<String, String, String> aVar4 = ag.b;
                if (a3.containsKey(aVar4.c)) {
                    if (a3.getBoolean(aVar4.c)) {
                        i4 = 256;
                    } else {
                        i4 = MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                    }
                    i6 |= i4;
                }
                ag.a<String, String, String> aVar5 = ag.c;
                if (a3.containsKey(aVar5.c)) {
                    if (a3.getBoolean(aVar5.c)) {
                        i3 = 1024;
                    } else {
                        i3 = 2048;
                    }
                    i6 |= i3;
                }
                ag.a<String, String, String> aVar6 = ag.h;
                if (a3.containsKey(aVar6.c)) {
                    if (a3.getBoolean(aVar6.c)) {
                        i2 = 4096;
                    } else {
                        i2 = 8192;
                    }
                    return i6 | i2;
                }
                return i6;
            }
            int a4 = a(str, 1);
            if (a4 == 1) {
                i6 |= 4;
            } else if (a4 == 0) {
                i6 |= 8;
            }
            int a5 = a(str, 4);
            if (a5 == 1) {
                i6 |= 16;
            } else if (a5 == 0) {
                i6 |= 32;
            }
            int a6 = a(str, 2);
            if (a6 == 1) {
                i6 |= 64;
            } else if (a6 == 0) {
                i6 |= 128;
            }
            int a7 = a(str, 8);
            if (a7 == 1) {
                i6 |= 256;
            } else if (a7 == 0) {
                i6 |= MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
            }
            int a8 = a(str, 16);
            if (a8 == 1) {
                i6 |= 1024;
            } else if (a8 == 0) {
                i6 |= 2048;
            }
            int a9 = a(str, 32);
            if (a9 == 1) {
                i = i6 | 4096;
            } else if (a9 == 0) {
                i = i6 | 8192;
            } else {
                return i6;
            }
            return i;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("context | packageName must not be null");
        return 0;
    }
}
