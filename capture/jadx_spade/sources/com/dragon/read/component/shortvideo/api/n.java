package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface n {
    String a(boolean z, boolean z2, boolean z3, boolean z4);

    String b();

    String c(boolean z, boolean z2, boolean z3, boolean z4);

    String d(boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    String e(boolean z);

    String f();

    public static final class a {
        static {
            Covode.recordClassIndex(598141);
        }

        public static /* synthetic */ String b(n nVar, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = false;
                }
                if ((i & 4) != 0) {
                    z3 = false;
                }
                if ((i & 8) != 0) {
                    z4 = false;
                }
                return nVar.a(z, z2, z3, z4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unfollowDefaultText");
        }

        public static /* synthetic */ String c(n nVar, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = false;
                }
                if ((i & 4) != 0) {
                    z3 = false;
                }
                if ((i & 8) != 0) {
                    z4 = false;
                }
                return nVar.c(z, z2, z3, z4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unfollowFailText");
        }

        public static /* synthetic */ String a(n nVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            if (obj == null) {
                if ((i & 2) != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i & 4) != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if ((i & 8) != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if ((i & 16) != 0) {
                    z9 = false;
                } else {
                    z9 = z5;
                }
                return nVar.d(z, z6, z7, z8, z9);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: followText");
        }
    }
}
