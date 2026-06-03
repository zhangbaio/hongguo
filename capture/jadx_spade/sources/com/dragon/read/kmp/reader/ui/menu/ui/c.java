package com.dragon.read.kmp.reader.ui.menu.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int d;
    private SnapshotStateList<sm4.d> a = SnapshotStateKt.mutableStateListOf();
    private SnapshotStateList<sm4.d> b = SnapshotStateKt.mutableStateListOf();
    private Map<sm4.d, Function2<Composer, Integer, Unit>> c = new LinkedHashMap();

    static {
        Covode.recordClassIndex(608642);
        d = 8;
    }

    public final Function2<Composer, Integer, Unit> b() {
        sm4.d dVar = (sm4.d) mk4.a.a(this.a);
        if (dVar != null) {
            return this.c.get(dVar);
        }
        return null;
    }

    public final List<sm4.d> c() {
        ArrayList arrayList = new ArrayList();
        for (sm4.d dVar : this.b) {
            if (dVar.f()) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public final Function2<Composer, Integer, Unit> d(sm4.d dVar) {
        if (dVar == null) {
            return null;
        }
        return this.c.get(dVar);
    }

    public final void a(sm4.d params, boolean z) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.e()) {
            if (z) {
                sm4.d dVar = (sm4.d) mk4.a.b(this.a);
                if (dVar != null) {
                    dVar.b();
                }
                sm4.d dVar2 = (sm4.d) mk4.a.a(this.a);
                if (dVar2 != null) {
                    dVar2.g();
                    return;
                }
                return;
            }
            sm4.d dVar3 = (sm4.d) mk4.a.a(this.a);
            if (dVar3 != null) {
                dVar3.b();
                return;
            }
            return;
        }
        sm4.d dVar4 = (sm4.d) mk4.a.b(this.b);
        if (dVar4 != null) {
            dVar4.b();
        }
    }

    public final void e(sm4.d params, Function2<? super Composer, ? super Integer, Unit> panel) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(panel, "panel");
        if (!this.a.contains(params)) {
            if (params.e()) {
                sm4.d dVar = (sm4.d) mk4.a.a(this.a);
                if (dVar != null) {
                    dVar.b();
                }
                if (mk4.a.c(this.a, params)) {
                    this.c.put(params, panel);
                    params.g();
                    return;
                }
                return;
            }
            if (mk4.a.c(this.b, params)) {
                this.c.put(params, panel);
                params.g();
            }
        }
    }
}
