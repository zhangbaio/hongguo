package com.dragon.read.kmp.share.business.series;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e0 extends un4.a {
    public static final int w;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public VideoContentType o;
    public boolean p;
    public Map<String, String> q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public String v;

    static {
        Covode.recordClassIndex(608923);
        w = 8;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.s = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(String scene, String entrance, String groupId, yn4.b bVar) {
        super(scene, entrance, groupId, bVar);
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.s = "";
    }
}
