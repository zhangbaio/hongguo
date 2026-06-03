package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ic {
    private static int a;

    static {
        Covode.recordClassIndex(655608);
        a = Integer.MAX_VALUE;
    }

    public static void a(hz hzVar, byte b) {
        a(hzVar, b, a);
    }

    public static void a(hz hzVar, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    hzVar.mo617a();
                    return;
                case 3:
                    hzVar.a();
                    return;
                case 4:
                    hzVar.mo604a();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    hzVar.mo614a();
                    return;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    hzVar.mo605a();
                    return;
                case 10:
                    hzVar.mo606a();
                    return;
                case 11:
                    hzVar.mo613a();
                    return;
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    hzVar.mo611a();
                    while (true) {
                        byte b2 = hzVar.mo607a().a;
                        if (b2 == 0) {
                            hzVar.f();
                            return;
                        } else {
                            a(hzVar, b2, i - 1);
                            hzVar.g();
                        }
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    hy mo609a = hzVar.mo609a();
                    while (i2 < mo609a.f832a) {
                        int i3 = i - 1;
                        a(hzVar, mo609a.a, i3);
                        a(hzVar, mo609a.b, i3);
                        i2++;
                    }
                    hzVar.h();
                    return;
                case 14:
                    id mo610a = hzVar.mo610a();
                    while (i2 < mo610a.f836a) {
                        a(hzVar, mo610a.a, i - 1);
                        i2++;
                    }
                    hzVar.j();
                    return;
                case 15:
                    hx mo608a = hzVar.mo608a();
                    while (i2 < mo608a.f831a) {
                        a(hzVar, mo608a.a, i - 1);
                        i2++;
                    }
                    hzVar.i();
                    return;
            }
        } else {
            throw new ht("Maximum skip depth exceeded");
        }
    }
}
