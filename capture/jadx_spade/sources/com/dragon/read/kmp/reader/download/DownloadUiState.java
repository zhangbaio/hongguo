package com.dragon.read.kmp.reader.download;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DownloadUiState implements gk4.f {
    private final long a;
    private final MutableState b;
    private final MutableState c;
    private final MutableState d;
    private final MutableState e;
    private final MutableState f;
    private final MutableState g;
    private final MutableState h;
    private final MutableState i;

    static {
        Covode.recordClassIndex(608410);
    }

    @Override // gk4.f
    public long a() {
        return this.a;
    }

    public final float b() {
        return ((Number) this.e.getValue()).floatValue();
    }

    public final boolean c() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    public final Function2<cm4.i, Continuation<? super Unit>, Object> e() {
        return (Function2) this.i.getValue();
    }

    public final String f() {
        return (String) this.c.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    public final String h() {
        return (String) this.b.getValue();
    }

    public final boolean i() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public String toString() {
        return "DownloadUiState(text='" + h() + "', redDotTag='" + f() + "', isEnabled=" + i() + ", alpha=" + b() + ", needShowTips=" + d() + ", showRedRect=" + c() + ", showRedBubble=" + g() + ')';
    }

    public final void j(float f) {
        this.e.setValue(Float.valueOf(f));
    }

    public final void k(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }

    public final void l(boolean z) {
        this.g.setValue(Boolean.valueOf(z));
    }

    public final void m(boolean z) {
        this.f.setValue(Boolean.valueOf(z));
    }

    public final void n(Function2<? super cm4.i, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.i.setValue(function2);
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c.setValue(str);
    }

    public final void p(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b.setValue(str);
    }

    public DownloadUiState(long j) {
        this.a = j;
        this.b = SnapshotStateKt.mutableStateOf$default("下载", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.c = SnapshotStateKt.mutableStateOf$default("免费", (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.TRUE;
        this.d = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool2 = Boolean.FALSE;
        this.g = SnapshotStateKt.mutableStateOf$default(bool2, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = SnapshotStateKt.mutableStateOf$default(bool2, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.i = SnapshotStateKt.mutableStateOf$default(new DownloadUiState$onTextClick$2(null), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ DownloadUiState(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? wf4.e.a.a() : j);
    }
}
