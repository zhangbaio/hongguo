package com.xs.fm.player.base.play.data;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AbsPlayList implements Serializable {
    public int cacheType;
    public final HashMap<String, Object> extras = new HashMap<>();

    static {
        Covode.recordClassIndex(655816);
    }

    public abstract int getGenreType();

    public abstract String getListId();
}
