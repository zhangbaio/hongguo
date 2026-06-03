package com.vivo.push.h;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ai {
    static {
        Covode.recordClassIndex(655052);
    }

    public static com.vivo.push.s a(com.vivo.push.v vVar) {
        com.vivo.push.s ahVar;
        int b = vVar.b();
        if (b != 20) {
            if (b != 100) {
                if (b != 101) {
                    switch (b) {
                        case 0:
                            break;
                        case 1:
                            ahVar = new ac(vVar);
                            break;
                        case 2:
                            ahVar = new l(vVar);
                            break;
                        case 3:
                            ahVar = new t(vVar);
                            break;
                        case 4:
                            ahVar = new u(vVar);
                            break;
                        case 5:
                            ahVar = new x(vVar);
                            break;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            ahVar = new z(vVar);
                            break;
                        case 7:
                            ahVar = new r(vVar);
                            break;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            ahVar = new p(vVar);
                            break;
                        case 9:
                            ahVar = new k(vVar);
                            break;
                        case 10:
                            ahVar = new h(vVar);
                            break;
                        case 11:
                            ahVar = new af(vVar);
                            break;
                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            ahVar = new j(vVar);
                            break;
                        default:
                            switch (b) {
                                case 2000:
                                case 2001:
                                case 2002:
                                case 2003:
                                case 2004:
                                case 2005:
                                case 2008:
                                case 2009:
                                case 2010:
                                case 2011:
                                case 2012:
                                case 2013:
                                case 2014:
                                case 2015:
                                    break;
                                case 2006:
                                    ahVar = new a(vVar);
                                    break;
                                case 2007:
                                    ahVar = new ak(vVar);
                                    break;
                                default:
                                    return null;
                            }
                    }
                    ahVar = new aj(vVar);
                } else {
                    ahVar = new c(vVar);
                }
            } else {
                ahVar = new b(vVar);
            }
        } else {
            ahVar = new ah(vVar);
        }
        return ahVar;
    }

    public static ab b(com.vivo.push.v vVar) {
        ab ahVar;
        int b = vVar.b();
        if (b != 20) {
            if (b != 2016) {
                if (b != 2023) {
                    switch (b) {
                        case 1:
                            ahVar = new ac(vVar);
                            break;
                        case 2:
                            ahVar = new l(vVar);
                            break;
                        case 3:
                            ahVar = new t(vVar);
                            break;
                        case 4:
                            ahVar = new u(vVar);
                            break;
                        case 5:
                            ahVar = new x(vVar);
                            break;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            ahVar = new z(vVar);
                            break;
                        case 7:
                            ahVar = new r(vVar);
                            break;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            ahVar = new p(vVar);
                            break;
                        case 9:
                            ahVar = new k(vVar);
                            break;
                        case 10:
                            ahVar = new h(vVar);
                            break;
                        case 11:
                            ahVar = new af(vVar);
                            break;
                        default:
                            return null;
                    }
                } else {
                    ahVar = new y(vVar);
                }
            } else {
                ahVar = new o(vVar);
            }
        } else {
            ahVar = new ah(vVar);
        }
        return ahVar;
    }
}
