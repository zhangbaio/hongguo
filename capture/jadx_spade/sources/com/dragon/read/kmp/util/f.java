package com.dragon.read.kmp.util;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final a e;
    private static final f f;
    public float a;
    public float b;
    public float c;
    public float d;

    public static final class a {
        static {
            Covode.recordClassIndex(609469);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f() {
    }

    static {
        Covode.recordClassIndex(609468);
        e = new a(null);
        f = new f(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "KmpRect(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ')';
    }

    public f(float f2, float f3, float f4, float f5) {
        this();
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }

    public final void a(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }
}
