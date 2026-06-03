package vl6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.BalanceData;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    public static final b a;

    private b() {
    }

    static {
        Covode.recordClassIndex(656047);
        a = new b();
    }

    public static final int b(PlayEngineInfo playEngineInfo) {
        PlayAddress playAddress;
        if (playEngineInfo != null) {
            playAddress = playEngineInfo.playAddress;
        } else {
            playAddress = null;
        }
        if (playAddress == null) {
            return 0;
        }
        PlayAddress playAddress2 = playEngineInfo.playAddress;
        int i = playAddress2.volumeBalanceType;
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    return 0;
                }
                return 3;
            }
            return 4;
        }
        BalanceData balanceData = playAddress2.balanceData;
        if (balanceData != null) {
            Intrinsics.checkExpressionValueIsNotNull(balanceData, "playEngineInfo.playAddress.balanceData");
            if (!balanceData.isOriginalParam()) {
                return 2;
            }
        }
        return 1;
    }

    public static final PlayEngineInfo a(c cVar, PlayAddress playAddress) {
        HashMap<String, Object> hashMap;
        qk6.a playStrategy = lk6.c.a.a(cVar.a, cVar.k);
        long j = cVar.f;
        HashMap<String, Object> hashMap2 = new HashMap<>();
        HashMap<String, Object> hashMap3 = cVar.a.extras;
        if (hashMap3 != null) {
            hashMap2.putAll(hashMap3);
        }
        if (playAddress != null && (hashMap = playAddress.extras) != null) {
            hashMap2.putAll(hashMap);
        }
        HashMap<String, Object> hashMap4 = cVar.l;
        if (hashMap4 != null) {
            hashMap2.putAll(hashMap4);
        }
        PlayEngineInfo playEngineInfo = new PlayEngineInfo(playAddress, j, cVar.d);
        AbsPlayList absPlayList = cVar.a;
        Intrinsics.checkExpressionValueIsNotNull(absPlayList, "playParam.playList");
        int genreType = absPlayList.getGenreType();
        String str = cVar.b;
        int i = cVar.c;
        AbsPlayList absPlayList2 = cVar.a;
        Intrinsics.checkExpressionValueIsNotNull(absPlayList2, "playParam.playList");
        PlayEngineInfo playEngineInfo2 = playEngineInfo.appendInfo(absPlayList, genreType, str, i, absPlayList2.getListId(), cVar.e, cVar.k, hashMap2);
        playEngineInfo2.isOsPlayer = playStrategy.w(playEngineInfo2);
        Intrinsics.checkExpressionValueIsNotNull(playStrategy, "playStrategy");
        playEngineInfo2.dynamicBuffer = playStrategy.c();
        playEngineInfo2.resolution = playStrategy.s(playEngineInfo2);
        playStrategy.r(playEngineInfo2);
        playEngineInfo2.enableAudioEffect = playStrategy.a();
        playStrategy.q(playEngineInfo2);
        playEngineInfo2.voiceBgmInfo = playStrategy.t(playEngineInfo2);
        playEngineInfo2.engineHeader = playStrategy.d(playEngineInfo2);
        Map<Integer, Object> e = playStrategy.e();
        if (e != null && (!e.isEmpty())) {
            playEngineInfo2.engineOptions.putAll(e);
        }
        Intrinsics.checkExpressionValueIsNotNull(playEngineInfo2, "playEngineInfo");
        return playEngineInfo2;
    }
}
