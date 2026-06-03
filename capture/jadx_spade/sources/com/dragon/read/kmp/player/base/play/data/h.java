package com.dragon.read.kmp.player.base.play.data;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.player.base.play.data.g;
import com.ss.ttvideoengine.Resolution;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607981);
            int[] iArr = new int[Resolution.values().length];
            try {
                iArr[Resolution.Undefine.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Resolution.Standard.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Resolution.High.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Resolution.SuperHigh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Resolution.ExtremelyHigh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Resolution.FourK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Resolution.HDR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Resolution.Auto.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Resolution.L_Standard.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Resolution.H_High.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Resolution.TwoK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Resolution.ExtremelyHigh_50F.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[Resolution.TwoK_50F.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[Resolution.FourK_50F.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[Resolution.ExtremelyHigh_60F.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[Resolution.TwoK_60F.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[Resolution.FourK_60F.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[Resolution.ExtremelyHigh_120F.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[Resolution.TwoK_120F.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[Resolution.FourK_120F.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[Resolution.L_Standard_HDR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[Resolution.Standard_HDR.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[Resolution.High_HDR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[Resolution.H_High_HDR.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[Resolution.SuperHigh_HDR.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[Resolution.ExtremelyHigh_HDR.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[Resolution.TwoK_HDR.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[Resolution.FourK_HDR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[Resolution.EightK.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[Resolution.ExtremelyHighPlus.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(607980);
    }

    public static final g a(Resolution resolution) {
        Intrinsics.checkNotNullParameter(resolution, "<this>");
        switch (a.a[resolution.ordinal()]) {
            case 1:
                return g.e0.d;
            case 2:
                return g.v.d;
            case 3:
                return g.r.d;
            case 4:
                return g.x.d;
            case 5:
                return g.C0023g.d;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return g.m.d;
            case 7:
                return g.o.d;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return g.a.d;
            case 9:
                return g.t.d;
            case 10:
                return g.p.d;
            case 11:
                return g.c0.d;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return g.e.d;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return g.a0.d;
            case 14:
                return g.k.d;
            case 15:
                return g.f.d;
            case 16:
                return g.b0.d;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return g.l.d;
            case 18:
                return g.d.d;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return g.z.d;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return g.j.d;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return g.u.d;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return g.w.d;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                return g.s.d;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return g.q.d;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                return g.y.d;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                return g.h.d;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                return g.d0.d;
            case 28:
                return g.n.d;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                return g.c.d;
            case 30:
                return g.i.d;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
