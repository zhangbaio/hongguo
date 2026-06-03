package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.IRunDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h implements IRunDelegate {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    static {
        Covode.recordClassIndex(654792);
    }

    @Override // com.ttreader.tttext.IRunDelegate
    public /* synthetic */ float GetDescent() {
        return IRunDelegate.CC.$default$GetDescent(this);
    }

    @Override // com.ttreader.tttext.IRunDelegate
    public /* synthetic */ boolean Hide() {
        return IRunDelegate.CC.$default$Hide(this);
    }

    @Override // com.ttreader.tttext.IRunDelegate
    public /* synthetic */ boolean Selectable() {
        return IRunDelegate.CC.$default$Selectable(this);
    }

    @Override // com.ttreader.tttext.IRunDelegate
    public float GetAdvance() {
        return this.g;
    }

    @Override // com.ttreader.tttext.IRunDelegate
    public int GetVerticalAlign() {
        return this.i;
    }

    @Override // com.ttreader.tttext.IRunDelegate
    public float GetAscent() {
        return -this.f;
    }

    public h(int i) {
        this(i, Integer.MAX_VALUE, 0, 3);
    }

    public h(int i, int i2, int i3, int i4) {
        this.h = 0;
        this.i = 0;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }
}
