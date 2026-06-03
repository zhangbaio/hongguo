package com.dragon.read.kmp.story.impl.feeds.guide;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.guide.KmpBaseStoryExitAlertHelper;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    boolean a();

    boolean b();

    void c(KmpBaseStoryExitAlertHelper.DialogEvent dialogEvent, kp4.b bVar);

    /* renamed from: com.dragon.read.kmp.story.impl.feeds.guide.a$a, reason: collision with other inner class name */
    public interface InterfaceC0074a {
        void a(String str);

        void b(String str);

        boolean c(String str);

        boolean d(String str);

        void e(kp4.b bVar, kp4.b bVar2, boolean z, String str, Function0<Unit> function0);

        kp4.b f();

        List<kp4.b> g();

        kp4.b h(kp4.b bVar, kp4.b bVar2);

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.guide.a$a$a, reason: collision with other inner class name */
        public static final class C0075a {
            static {
                Covode.recordClassIndex(609285);
            }

            public static /* synthetic */ void a(InterfaceC0074a interfaceC0074a, kp4.b bVar, kp4.b bVar2, boolean z, String str, Function0 function0, int i, Object obj) {
                String str2;
                Function0 function02;
                if (obj == null) {
                    if ((i & 8) != 0) {
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    if ((i & 16) != 0) {
                        function02 = null;
                    } else {
                        function02 = function0;
                    }
                    interfaceC0074a.e(bVar, bVar2, z, str2, function02);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchToNextStory");
            }
        }
    }
}
