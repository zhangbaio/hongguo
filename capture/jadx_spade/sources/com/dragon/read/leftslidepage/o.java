package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int c;
    public final Set<SidebarSectionType> a;
    public final Set<FunctionItemType> b;

    static {
        Covode.recordClassIndex(611262);
        c = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Set<? extends SidebarSectionType> hiddenSections, Set<? extends FunctionItemType> hiddenFunctionTypes) {
        Intrinsics.checkNotNullParameter(hiddenSections, "hiddenSections");
        Intrinsics.checkNotNullParameter(hiddenFunctionTypes, "hiddenFunctionTypes");
        this.a = hiddenSections;
        this.b = hiddenFunctionTypes;
    }

    public /* synthetic */ o(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt__SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt__SetsKt.emptySet() : set2);
    }
}
