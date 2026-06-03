package qk6;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a {
    static {
        Covode.recordClassIndex(655828);
    }

    public boolean a() {
        return false;
    }

    public abstract void b(PlayEngineInfo playEngineInfo);

    public sk6.a c() {
        return null;
    }

    public Map<Integer, Object> e() {
        return null;
    }

    public String f(AbsPlayList absPlayList, int i) {
        return null;
    }

    public abstract String g(AbsPlayList absPlayList, String str);

    public abstract String h(AbsPlayList absPlayList, String str);

    public abstract void i(jl6.d dVar, ok6.a aVar);

    public abstract int k(AbsPlayList absPlayList);

    public abstract pk6.c l(AbsPlayList absPlayList, String str);

    public abstract int n(pk6.c cVar);

    public abstract String o(AbsPlayList absPlayList, String str);

    public abstract vk6.a p();

    public pk6.a q(PlayEngineInfo playEngineInfo) {
        return null;
    }

    public pk6.a r(PlayEngineInfo playEngineInfo) {
        return null;
    }

    public Resolution s(PlayEngineInfo playEngineInfo) {
        return null;
    }

    public VoiceBgmInfo t(PlayEngineInfo playEngineInfo) {
        return null;
    }

    public boolean u(IPlayer iPlayer, int i, int i2) {
        return false;
    }

    public void v(pk6.c cVar, String str) {
    }

    public boolean w(PlayEngineInfo playEngineInfo) {
        return false;
    }

    public HashMap<String, String> d(PlayEngineInfo playEngineInfo) {
        return new HashMap<>();
    }

    public String j(jl6.d dVar) {
        if (dVar == null) {
            return "";
        }
        AbsPlayList absPlayList = dVar.a;
        String str = dVar.b;
        int i = dVar.d;
        if (absPlayList != null) {
            return absPlayList.getGenreType() + "_" + str + "_" + i;
        }
        return str + "_" + i;
    }

    public pk6.c m(AbsPlayList absPlayList, String str, HashMap<String, String> hashMap) {
        return l(absPlayList, str);
    }
}
