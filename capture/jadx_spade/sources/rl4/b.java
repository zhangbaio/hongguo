package rl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import kotlin.jvm.internal.Intrinsics;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608152);
            int[] iArr = new int[ProfileTab.values().length];
            try {
                iArr[ProfileTab.Album.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileTab.SubscribeWorks.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileTab.All.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileTab.Talk_BookComment.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608151);
        a = new b();
    }

    private b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r0.intValue() != r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int b(com.dragon.read.rpc.kmp.community.model.c7 r5, com.dragon.read.rpc.kmp.community.model.ProfileTab r6) {
        /*
            r4 = this;
            com.dragon.read.rpc.kmp.community.model.ProfileTab r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Album
            r1 = 1
            if (r6 != r0) goto L7
            goto L79
        L7:
            com.dragon.read.rpc.kmp.community.model.ProfileTab r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.All
            r2 = 3
            r3 = 2
            if (r6 != r0) goto L29
            gl4.b r6 = gl4.b.a
            boolean r6 = r6.a()
            if (r6 == 0) goto L27
            java.lang.Integer r5 = r5.b
            com.dragon.read.rpc.kmp.community.model.ProfileTab r6 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Video
            int r6 = r6.getValue()
            if (r5 != 0) goto L20
            goto L27
        L20:
            int r5 = r5.intValue()
            if (r5 != r6) goto L27
            goto L2d
        L27:
            r1 = 3
            goto L79
        L29:
            com.dragon.read.rpc.kmp.community.model.ProfileTab r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.SubscribeWorks
            if (r6 != r0) goto L2f
        L2d:
            r1 = 2
            goto L79
        L2f:
            com.dragon.read.rpc.kmp.community.model.ProfileTab r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Talk_BookComment
            if (r6 != r0) goto L34
            goto L79
        L34:
            java.lang.Integer r0 = r5.b
            com.dragon.read.rpc.kmp.community.model.ProfileTab r1 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Select
            int r1 = r1.getValue()
            if (r0 != 0) goto L3f
            goto L46
        L3f:
            int r0 = r0.intValue()
            if (r0 != r1) goto L46
            goto L2d
        L46:
            gl4.b r0 = gl4.b.a
            boolean r0 = r0.a()
            if (r0 == 0) goto L60
            java.lang.Integer r0 = r5.b
            com.dragon.read.rpc.kmp.community.model.ProfileTab r1 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Video
            int r1 = r1.getValue()
            if (r0 != 0) goto L59
            goto L60
        L59:
            int r0 = r0.intValue()
            if (r0 != r1) goto L60
            goto L2d
        L60:
            if (r6 == 0) goto L6b
            boolean r6 = com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.b(r6)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L6c
        L6b:
            r6 = 0
        L6c:
            boolean r6 = com.dragon.read.kmp.utils.g0.b(r6)
            if (r6 == 0) goto L27
            boolean r5 = yk4.a.a(r5)
            if (r5 == 0) goto L27
            goto L2d
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: rl4.b.b(com.dragon.read.rpc.kmp.community.model.c7, com.dragon.read.rpc.kmp.community.model.ProfileTab):int");
    }

    public final rl4.a a(c7 userProfileTab, ProfileTab profileTab) {
        int i;
        float g;
        float g2;
        boolean z;
        Intrinsics.checkNotNullParameter(userProfileTab, "userProfileTab");
        int b = b(userProfileTab, profileTab);
        if (profileTab == null) {
            i = -1;
        } else {
            i = a.a[profileTab.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        Integer num = userProfileTab.b;
                        int value = ProfileTab.Select.getValue();
                        if (num != null && num.intValue() == value) {
                            float f = 8;
                            return new rl4.a(b, i.g(f), i.g(f), i.g(12), true, false, 0.0f, 0.0f, 224, null);
                        }
                        if (gl4.b.a.a()) {
                            Integer num2 = userProfileTab.b;
                            int value2 = ProfileTab.Video.getValue();
                            if (num2 != null && num2.intValue() == value2) {
                                float f2 = 8;
                                return new rl4.a(b, i.g(f2), i.g(f2), i.g(12), true, false, 0.0f, 0.0f, 224, null);
                            }
                        }
                        return new rl4.a(b, i.g(8), i.g(15), i.g(16), false, false, 0.0f, 0.0f, 240, null);
                    }
                    float f3 = 0;
                    float f4 = 16;
                    return new rl4.a(b, i.g(f3), i.g(f4), i.g(f3), false, true, i.g(f4), i.g((float) 0.5d), 16, null);
                }
                gl4.b bVar = gl4.b.a;
                if (bVar.a()) {
                    g = i.g(12);
                } else {
                    g = i.g(16);
                }
                float f5 = g;
                if (bVar.a()) {
                    g2 = i.g(8);
                } else {
                    g2 = i.g(15);
                }
                float g3 = i.g(8);
                if (b == 2 && bVar.a()) {
                    z = true;
                } else {
                    z = false;
                }
                return new rl4.a(b, g3, g2, f5, z, false, 0.0f, 0.0f, 224, null);
            }
            float f6 = 8;
            return new rl4.a(b, i.g(f6), i.g(f6), i.g(12), false, false, 0.0f, 0.0f, 240, null);
        }
        float f7 = 0;
        return new rl4.a(b, i.g(f7), i.g(16), i.g(f7), false, false, 0.0f, 0.0f, 240, null);
    }
}
