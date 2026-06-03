package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cr {
    static {
        Covode.recordClassIndex(655423);
    }

    /* renamed from: com.xiaomi.push.cr$1, reason: invalid class name */
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
                a[ge.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ge.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ge.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ge.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a(ge geVar) {
        return dr.a(geVar.a());
    }

    public static int a(Context context, int i) {
        int i2;
        int a = fy.a(context);
        if (-1 == a) {
            return -1;
        }
        if (a == 0) {
            i2 = 13;
        } else {
            i2 = 11;
        }
        return (i * i2) / 10;
    }

    public static int a(hp hpVar, ge geVar) {
        int a;
        switch (AnonymousClass1.a[geVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case 7:
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
            case 9:
            case 10:
                return dr.a(geVar.a());
            case 11:
                a = dr.a(geVar.a());
                if (hpVar != null) {
                    try {
                        if (hpVar instanceof gv) {
                            String str = ((gv) hpVar).f614d;
                            if (!TextUtils.isEmpty(str) && dr.a(dr.m360a(str)) != -1) {
                                a = dr.a(dr.m360a(str));
                                break;
                            }
                        } else if (hpVar instanceof hd) {
                            String str2 = ((hd) hpVar).f673d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (dr.a(dr.m360a(str2)) != -1) {
                                    a = dr.a(dr.m360a(str2));
                                }
                                if (go.UploadTinyData.equals(dr.m360a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a;
                    }
                }
                break;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                a = dr.a(geVar.a());
                if (hpVar != null) {
                    try {
                        if (hpVar instanceof gz) {
                            String b = ((gz) hpVar).b();
                            if (!TextUtils.isEmpty(b) && ec.a(b) != -1) {
                                a = ec.a(b);
                                break;
                            }
                        } else if (hpVar instanceof gy) {
                            String a2 = ((gy) hpVar).a();
                            if (!TextUtils.isEmpty(a2) && ec.a(a2) != -1) {
                                return ec.a(a2);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a;
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            ha haVar = new ha();
            try {
                ho.a(haVar, bArr);
                a(str, context, haVar, bArr.length);
            } catch (ht unused) {
                com.xiaomi.channel.commonutils.logger.b.m54a("fail to convert bytes to container");
            }
        }
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i > 0 && i2 > 0) {
            int a = a(context, i2);
            if (i != dr.a(go.UploadTinyData)) {
                ds.a(context.getApplicationContext()).a(str, i, 1L, a);
            }
        }
    }

    public static void a(String str, Context context, ha haVar, int i) {
        ge a;
        if (context != null && haVar != null && (a = haVar.a()) != null) {
            int a2 = a(a);
            if (i <= 0) {
                byte[] a3 = ho.a(haVar);
                if (a3 != null) {
                    i = a3.length;
                } else {
                    i = 0;
                }
            }
            a(str, context, a2, i);
        }
    }

    public static void a(String str, Context context, hp hpVar, ge geVar, int i) {
        a(str, context, a(hpVar, geVar), i);
    }
}
