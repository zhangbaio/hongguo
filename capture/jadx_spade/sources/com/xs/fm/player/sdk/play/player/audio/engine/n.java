package com.xs.fm.player.sdk.play.player.audio.engine;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.CacheFilePathListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoInfo;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.BalanceData;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfoFromServer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n {
    private static final bl6.a a;

    static {
        Covode.recordClassIndex(655960);
        a = new bl6.a("FMPlayer-EngineConfig");
    }

    public static final void a(boolean z) {
        boolean z2;
        nk6.b bVar = lk6.c.a.l;
        if (bVar != null) {
            z2 = bVar.s();
        } else {
            z2 = true;
        }
        if (z && z2) {
            TTVideoEngine.setIntValue(1156, lk6.c.a.l.w0());
            TTVideoEngine.setIntValue(1157, lk6.c.a.l.F());
            TTVideoEngine.setIntValue(1163, 1);
            return;
        }
        TTVideoEngine.setIntValue(1163, 0);
    }

    public static final void e(TTVideoEngine tTVideoEngine) {
        gl6.a aVar;
        lk6.b bVar = lk6.c.a;
        gl6.c cVar = bVar.t;
        if (cVar != null && (aVar = bVar.s) != null) {
            if (cVar.d()) {
                j.f();
                tTVideoEngine.setIntOption(160, 1);
                if (aVar.f()) {
                    tTVideoEngine.setIntOption(0, aVar.c());
                } else {
                    tTVideoEngine.setIntOption(0, cVar.g());
                }
                tTVideoEngine.setIntOption(161, cVar.i());
            } else {
                tTVideoEngine.setIntOption(160, 0);
            }
            tTVideoEngine.setIntOption(33, 1);
            if (cVar.a()) {
                tTVideoEngine.setIntOption(959, 1);
            } else {
                tTVideoEngine.setIntOption(959, 0);
            }
            int c = cVar.c();
            if (c >= 0) {
                tTVideoEngine.setIntOption(11, c);
            }
            int l = cVar.l();
            if (l >= 0) {
                tTVideoEngine.setIntOption(12, l);
            }
        }
    }

    static final class a implements CacheFilePathListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.ss.ttvideoengine.CacheFilePathListener
        public final String cacheFilePath(String str, VideoInfo videoInfo) {
            String str2 = this.a;
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            return str2;
        }
    }

    public static final void d(TTVideoEngine tTVideoEngine, String str) {
        if (tTVideoEngine == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            tTVideoEngine.setCacheFilePathListener(new a(str));
        } else {
            tTVideoEngine.setCacheFilePathListener(null);
        }
    }

    public static final void h(TTVideoEngine tTVideoEngine, VoiceBgmInfo voiceBgmInfo) {
        tTVideoEngine.setIntOption(46065, voiceBgmInfo.enableDynamicMix);
        tTVideoEngine.setIntOption(1431, voiceBgmInfo.voiceRate);
        tTVideoEngine.setIntOption(1432, voiceBgmInfo.bgmRate);
    }

    public static final void f(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        Set<Map.Entry<String, String>> entrySet;
        HashMap<String, String> hashMap = playEngineInfo.engineHeader;
        if (hashMap != null && (entrySet = hashMap.entrySet()) != null) {
            Iterator<T> it2 = entrySet.iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                tTVideoEngine.setCustomHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public static final void i(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        VoiceBgmInfo voiceBgmInfo = playEngineInfo.voiceBgmInfo;
        if (voiceBgmInfo == null) {
            tTVideoEngine.setIntOption(46065, 0);
            return;
        }
        VoiceBgmInfoFromServer voiceBgmInfoFromServer = playEngineInfo.playAddress.voiceBgmInfoFromServer;
        int i = voiceBgmInfo.enableDynamicMix;
        if (i <= 0) {
            return;
        }
        tTVideoEngine.setIntOption(46065, i);
        if (voiceBgmInfo.userSetBgm) {
            tTVideoEngine.setIntOption(1431, voiceBgmInfo.voiceRate);
            tTVideoEngine.setIntOption(1432, voiceBgmInfo.bgmRate);
        } else if (voiceBgmInfoFromServer != null && voiceBgmInfoFromServer.defaultBGAdjust) {
            tTVideoEngine.setIntOption(1431, voiceBgmInfo.voiceRate);
            tTVideoEngine.setIntOption(1432, (int) voiceBgmInfoFromServer.bgMixRadio);
        }
    }

    public static final void c(TTVideoEngine tTVideoEngine, boolean z) {
        int i;
        nk6.b bVar;
        int i2;
        Log.e("VideoEngineUtil", "configVideoEngine, videoEngine = " + tTVideoEngine + ", isVideo = " + z);
        if (!z) {
            nk6.e eVar = lk6.c.a.n;
            if (eVar != null && eVar.m()) {
                j.f();
                tTVideoEngine.setIntOption(160, 1);
                tTVideoEngine.setIntOption(0, lk6.c.a.n.k());
                tTVideoEngine.setIntOption(161, lk6.c.a.n.K());
            }
            nk6.b bVar2 = lk6.c.a.l;
            if (bVar2 != null) {
                tTVideoEngine.setIntOption(204, bVar2.B());
                int x0 = bVar2.x0();
                if (x0 >= 0) {
                    tTVideoEngine.setIntOption(11, x0);
                }
                int j = bVar2.j();
                if (j >= 0) {
                    tTVideoEngine.setIntOption(12, j);
                }
                if (bVar2.V()) {
                    tTVideoEngine.setIntOption(541, 1);
                } else {
                    tTVideoEngine.setIntOption(541, 0);
                }
                if (bVar2.k() >= 0) {
                    tTVideoEngine.setIntOption(987, bVar2.k());
                    tTVideoEngine.setIntOption(565, bVar2.e());
                }
                if (bVar2.a()) {
                    tTVideoEngine.setIntOption(509, 1);
                    tTVideoEngine.setIntOption(402, 1);
                } else {
                    tTVideoEngine.setIntOption(509, 0);
                    tTVideoEngine.setIntOption(402, 0);
                }
            }
            tTVideoEngine.setIntOption(480, 1);
            nk6.e eVar2 = lk6.c.a.n;
            if (eVar2 != null) {
                i2 = eVar2.L();
            } else {
                i2 = 1;
            }
            if (i2 > 1) {
                tTVideoEngine.setIntOption(11, i2);
            }
        } else {
            nk6.b bVar3 = lk6.c.a.l;
            if (bVar3 != null && bVar3.q()) {
                tTVideoEngine.setIntOption(42850, 1);
                tTVideoEngine.setIntOption(42853, 1);
            }
            nk6.b bVar4 = lk6.c.a.l;
            if (bVar4 != null) {
                i = bVar4.A();
            } else {
                i = 0;
            }
            tTVideoEngine.setIntOption(204, i);
            tTVideoEngine.setIntOption(33, 1);
        }
        nk6.b bVar5 = lk6.c.a.l;
        if (bVar5 != null) {
            bVar5.l(tTVideoEngine, z);
        }
        nk6.e eVar3 = lk6.c.a.n;
        if (eVar3 != null && eVar3.r()) {
            if (!z) {
                tTVideoEngine.setIntOption(604, eVar3.A());
            } else {
                tTVideoEngine.setIntOption(604, eVar3.x());
            }
            tTVideoEngine.setIntOption(605, eVar3.p());
            tTVideoEngine.setIntOption(857, eVar3.d());
            if (!TextUtils.isEmpty(eVar3.j())) {
                tTVideoEngine.setStringOption(715, eVar3.j());
            }
        }
        nk6.b bVar6 = lk6.c.a.l;
        if (bVar6 != null) {
            tTVideoEngine.setIntOption(322, bVar6.Q());
            if (lk6.c.a.l.v() > 0) {
                tTVideoEngine.setIntOption(118, bVar6.v());
            }
            if (lk6.c.a.l.h() > 0) {
                tTVideoEngine.setIntOption(202, bVar6.h());
            }
            if (lk6.c.a.l.p() > 0) {
                tTVideoEngine.setIntOption(0, bVar6.p());
            }
            tTVideoEngine.setIntOption(603, bVar6.g() ? 1 : 0);
            tTVideoEngine.setIntOption(472, bVar6.z() ? 1 : 0);
            if (bVar6.W()) {
                TTVideoEngine.setIntValue(TTVideoEngineInterface.PLAYER_OPTION_KERNAL_LOG_LEVER, bVar6.L());
                TTVideoEngine.setLongValue(217, bVar6.getALogSimpleWriteFuncAddr());
            }
            if (bVar6.p0()) {
                tTVideoEngine.setIntOption(721, 0);
            }
        }
        tTVideoEngine.setCacheControlEnabled(true);
        tTVideoEngine.setIntOption(471, 1);
        lk6.b bVar7 = lk6.c.a;
        if (bVar7 != null && (bVar = bVar7.l) != null && bVar.C()) {
            TTVideoEngine.enableNewMDLFetcher(true);
            tTVideoEngine.setIntOption(450, 1);
        }
        a(z);
    }

    public static final void g(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        String str;
        int i;
        int i2 = playEngineInfo.playAddress.volumeBalanceType;
        if (i2 == 3) {
            bl6.a aVar = a;
            StringBuilder sb = new StringBuilder();
            sb.append("tryInitEngineBalance, use volume balance 3, ae config = ");
            PlayAddress playAddress = playEngineInfo.playAddress;
            if (playAddress != null) {
                str = playAddress.aeConfigJsonStr;
            } else {
                str = null;
            }
            sb.append(str);
            aVar.d(sb.toString(), new Object[0]);
            tTVideoEngine.setIntOption(329, 1);
            tTVideoEngine.setIntOption(343, 7);
            BalanceData balanceData = playEngineInfo.playAddress.balanceData;
            if (balanceData != null) {
                i = balanceData.needVolInfoFromStream;
            } else {
                i = 0;
            }
            if (i == 0) {
                tTVideoEngine.setIntOption(5031, 1);
            }
            if (!TextUtils.isEmpty(playEngineInfo.playAddress.aeConfigJsonStr)) {
                tTVideoEngine.setStringOption(355, playEngineInfo.playAddress.aeConfigJsonStr);
            }
            PlayAddress playAddress2 = playEngineInfo.playAddress;
            if (playAddress2.forceBackCompressor) {
                tTVideoEngine.setFloatOption(344, playAddress2.volumeBalanceTargetLoudness);
                BalanceData balanceData2 = playEngineInfo.playAddress.balanceData;
                if (balanceData2 != null) {
                    tTVideoEngine.setIntOption(46009, 1);
                    tTVideoEngine.setFloatOption(325, balanceData2.preGain);
                    tTVideoEngine.setFloatOption(326, balanceData2.threshold);
                    tTVideoEngine.setFloatOption(327, balanceData2.ratio);
                    tTVideoEngine.setFloatOption(328, balanceData2.preDelay);
                }
            }
            gk6.b bVar = lk6.c.a.r;
            if (bVar != null && bVar.c()) {
                tTVideoEngine.setIntOption(46008, 1);
            }
            PlayAddress playAddress3 = playEngineInfo.playAddress;
            Intrinsics.checkExpressionValueIsNotNull(playAddress3, "playEngineInfo.playAddress");
            if (playAddress3.isFourChannelSource()) {
                tTVideoEngine.setIntOption(329, 1);
                tTVideoEngine.setIntOption(343, 0);
                tTVideoEngine.setFloatOption(344, 0.0f);
                BalanceData balanceData3 = playEngineInfo.playAddress.balanceData;
                if (balanceData3 != null) {
                    tTVideoEngine.setFloatOption(325, balanceData3.preGain);
                    tTVideoEngine.setFloatOption(326, balanceData3.threshold);
                    tTVideoEngine.setFloatOption(327, balanceData3.ratio);
                    tTVideoEngine.setFloatOption(328, balanceData3.preDelay);
                    return;
                }
                return;
            }
            return;
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 0) {
                tTVideoEngine.setIntOption(329, 1);
                tTVideoEngine.setIntOption(343, 0);
                tTVideoEngine.setFloatOption(344, 0.0f);
                BalanceData balanceData4 = playEngineInfo.playAddress.balanceData;
                if (balanceData4 != null) {
                    tTVideoEngine.setFloatOption(325, balanceData4.preGain);
                    tTVideoEngine.setFloatOption(326, balanceData4.threshold);
                    tTVideoEngine.setFloatOption(327, balanceData4.ratio);
                    tTVideoEngine.setFloatOption(328, balanceData4.preDelay);
                    return;
                }
                return;
            }
            tTVideoEngine.setIntOption(329, 0);
            tTVideoEngine.setIntOption(343, 0);
            tTVideoEngine.setFloatOption(344, 0.0f);
            return;
        }
        tTVideoEngine.setIntOption(329, 1);
        if (playEngineInfo.playAddress.volumeBalanceType == 1) {
            tTVideoEngine.setIntOption(343, 1);
        } else {
            tTVideoEngine.setIntOption(343, 5);
            BalanceData balanceData5 = playEngineInfo.playAddress.balanceData;
            if (balanceData5 != null) {
                tTVideoEngine.setFloatOption(325, balanceData5.preGain);
                tTVideoEngine.setFloatOption(326, balanceData5.threshold);
                tTVideoEngine.setFloatOption(327, balanceData5.ratio);
                tTVideoEngine.setFloatOption(328, balanceData5.preDelay);
            }
        }
        tTVideoEngine.setFloatOption(344, playEngineInfo.playAddress.volumeBalanceTargetLoudness);
        tTVideoEngine.setIntOption(347, 1);
        if (!TextUtils.isEmpty(playEngineInfo.playAddress.aeConfigJsonStr)) {
            tTVideoEngine.setStringOption(355, playEngineInfo.playAddress.aeConfigJsonStr);
        }
    }

    public static final void b(TTVideoEngine tTVideoEngine, String[] strArr, String str, boolean z) {
        String str2;
        boolean z2;
        if (tTVideoEngine == null) {
            return;
        }
        boolean z3 = true;
        if (strArr != null) {
            if (strArr.length == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (z3) {
            str2 = null;
        } else {
            str2 = strArr[0];
        }
        if (z) {
            tTVideoEngine.setLocalURL(str2);
            return;
        }
        if (lk6.c.a.n.m() && j.c()) {
            if (!TextUtils.isEmpty(str)) {
                tTVideoEngine.setDirectUrlUseDataLoaderByFilePath(strArr, xk6.e.a(str2), str);
                return;
            } else {
                tTVideoEngine.setDirectUrlUseDataLoader(str2, xk6.e.a(str2));
                return;
            }
        }
        tTVideoEngine.setDirectURL(str2);
    }
}
