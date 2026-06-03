package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.bdrichtext.model.TypeDefinition;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s implements kn0.b {
    private final long a;
    private final boolean b;

    static {
        Covode.recordClassIndex(609327);
    }

    public /* synthetic */ s(long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z);
    }

    public boolean c() {
        return this.b;
    }

    public boolean b() {
        return com.dragon.read.kmp.story.impl.feeds.config.b.a.b();
    }

    private s(long j, boolean z) {
        this.a = j;
        this.b = z;
    }

    public int a(TypeDefinition.ThemeColorType themeColorType, int i, String str) {
        return n0.k(this.a);
    }
}
