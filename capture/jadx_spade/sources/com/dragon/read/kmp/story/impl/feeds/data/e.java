package com.dragon.read.kmp.story.impl.feeds.data;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.TruncateFlag;
import com.bytedance.kmp.ugc.model.d6;
import com.bytedance.kmp.ugc.model.rj;
import com.bytedance.kmp.ugc.model.us;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements yo4.b {
    public static final int p;
    public final String a;
    private final yo4.b b;
    public final f c;
    public String d;
    public List<us> e;
    public final List<a> f;
    public final List<rj> g;
    public TruncateFlag h;
    public d6 i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public String n;
    public List<String> o;

    static {
        Covode.recordClassIndex(609268);
        p = 8;
    }

    @Override // yo4.b
    public int a() {
        return this.b.a();
    }

    @Override // yo4.b
    public String b() {
        return this.b.b();
    }

    @Override // yo4.b
    public String c() {
        return this.b.c();
    }

    @Override // yo4.b
    public int d() {
        return this.b.d();
    }

    @Override // yo4.b
    public List<String> e() {
        return this.b.e();
    }

    @Override // yo4.b
    public String getBookId() {
        return this.b.getBookId();
    }

    @Override // yo4.b
    public Integer getCreationStatus() {
        return this.b.getCreationStatus();
    }

    @Override // yo4.b
    public Integer getGenreType() {
        return this.b.getGenreType();
    }

    @Override // yo4.b
    public String getGroupId() {
        return this.b.getGroupId();
    }

    @Override // yo4.b
    public String getPostId() {
        return this.b.getPostId();
    }

    public final boolean g() {
        if (this.h != TruncateFlag.TruncateByContent) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        if (this.h == TruncateFlag.TruncateByLock) {
            return true;
        }
        return false;
    }

    public final int f() {
        int d;
        int coerceAtLeast;
        if (h()) {
            d = d();
        } else {
            d = d() - a();
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(d, 0);
        return coerceAtLeast;
    }

    public final boolean h() {
        TruncateFlag truncateFlag = this.h;
        if (truncateFlag != null && truncateFlag != TruncateFlag.NoTruncate && truncateFlag != TruncateFlag.NoTrunCateByLock && truncateFlag != TruncateFlag.NoTrunCateByUnLock) {
            return false;
        }
        return true;
    }

    public e(String storyId, yo4.b adapter) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.a = storyId;
        this.b = adapter;
        this.c = new f();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }
}
