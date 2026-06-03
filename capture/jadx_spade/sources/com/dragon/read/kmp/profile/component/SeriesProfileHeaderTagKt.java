package com.dragon.read.kmp.profile.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.bm0;
import com.bytedance.kmp.reading.model.tl0;
import com.bytedance.kmp.reading.model.vl0;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.kmp.service.d1;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesProfileHeaderTagKt {
    static {
        Covode.recordClassIndex(608039);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(dl4.e eVar, bm0 bm0Var, GuestProfileViewModel guestProfileViewModel, int i, Composer composer, int i2) {
        h(eVar, bm0Var, guestProfileViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(dl4.e eVar, bm0 bm0Var, GuestProfileViewModel guestProfileViewModel, int i, Composer composer, int i2) {
        h(eVar, bm0Var, guestProfileViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(dl4.e eVar, bm0 bm0Var, GuestProfileViewModel guestProfileViewModel, int i, Composer composer, int i2) {
        h(eVar, bm0Var, guestProfileViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(tl0 tl0Var, Function1 function1, String str, GuestProfileViewModel guestProfileViewModel, int i, int i2, Composer composer, int i3) {
        m(tl0Var, function1, str, guestProfileViewModel, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(vl0 vl0Var, String str, bm0 bm0Var, String str2, String str3, Function1 function1, int i, int i2, Composer composer, int i3) {
        o(vl0Var, str, bm0Var, str2, str3, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final String t(bm0 bm0Var) {
        if (Intrinsics.areEqual(bm0Var.b, "臻果剧评官")) {
            return "to_video_comment_expert_popup";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(bm0 bm0Var) {
        if (Intrinsics.areEqual(bm0Var.g, Boolean.TRUE)) {
            return "vip";
        }
        String str = bm0Var.b;
        if (str == null) {
            return "other";
        }
        return str;
    }

    private static final String v(String str) {
        boolean z;
        JsonPrimitive jsonPrimitive;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        try {
            JsonElement jsonElement = (JsonElement) JsonElementKt.getJsonObject(gn6.a.d.e(str)).get("jump_schema");
            if (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) {
                return null;
            }
            return jsonPrimitive.getContent();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(GuestProfileViewModel guestProfileViewModel, String str, bm0 bm0Var, dl4.e eVar) {
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        rVar.u(guestProfileViewModel.r0(), str, "profile_page", rVar.e(), rVar.d(), "to_annual_ranking_page");
        com.dragon.read.kmp.star_fans.e.a.b(bm0Var.a, false, "actor_profile");
        com.dragon.read.kmp.profile.params.a aVar = guestProfileViewModel.f;
        if (aVar != null) {
            aVar.s(eVar.f, guestProfileViewModel.a.f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, bm0 bm0Var, String str2, String str3, Function1 function1) {
        boolean z;
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        String e = rVar.e();
        String d = rVar.d();
        boolean z2 = true;
        if (str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            rVar.u(str2, u(bm0Var), str, e, d, t(bm0Var));
        }
        if (str3 != null && str3.length() != 0) {
            z2 = false;
        }
        if (!z2 && function1 != null) {
            function1.invoke(s(str3, bm0Var, str, e, d));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[Catch: all -> 0x00b3, TryCatch #0 {all -> 0x00b3, blocks: (B:8:0x001f, B:12:0x0028, B:14:0x002e, B:20:0x003b, B:22:0x0050, B:28:0x005f, B:32:0x0067, B:38:0x0075, B:41:0x007a, B:44:0x0087), top: B:7:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String s(java.lang.String r8, com.bytedance.kmp.reading.model.bm0 r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.component.SeriesProfileHeaderTagKt.s(java.lang.String, com.bytedance.kmp.reading.model.bm0, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static final void h(final dl4.e eVar, final bm0 bm0Var, final GuestProfileViewModel guestProfileViewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        String str;
        List<String> list;
        ArrayList arrayList;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(332410278);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(eVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(bm0Var)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332410278, i2, -1, "com.dragon.read.kmp.profile.component.BuildExpandTextTag (SeriesProfileHeaderTag.kt:260)");
            }
            if (eVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.component.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit i6;
                            i6 = SeriesProfileHeaderTagKt.i(dl4.e.this, bm0Var, guestProfileViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                            return i6;
                        }
                    });
                    return;
                }
                return;
            }
            final String str2 = eVar.a;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.component.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit j;
                            j = SeriesProfileHeaderTagKt.j(dl4.e.this, bm0Var, guestProfileViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                            return j;
                        }
                    });
                    return;
                }
                return;
            }
            og4.a aVar = og4.a.a;
            boolean d = d1.d(aVar.e(startRestartGroup, og4.a.b));
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(eVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                if (d) {
                    str = eVar.c;
                } else {
                    str = eVar.b;
                }
                rememberedValue = l0.j(com.dragon.read.kmp.utils.j.b(str, aVar.d().f()));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            long x = ((l0) rememberedValue).x();
            startRestartGroup.endReplaceGroup();
            if (d) {
                list = eVar.e;
            } else {
                list = eVar.d;
            }
            startRestartGroup.startReplaceGroup(1618715564);
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(l0.j(com.dragon.read.kmp.utils.j.b((String) it2.next(), og4.a.a.h(startRestartGroup, og4.a.b).x())));
                    x = x;
                }
            }
            long j = x;
            startRestartGroup.endReplaceGroup();
            float g = x0.i.g(2);
            startRestartGroup.startReplaceGroup(-344996060);
            boolean z3 = false;
            a3.a(SizeKt.x(Modifier.Companion, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            l0 j2 = l0.j(j);
            org.jetbrains.compose.resources.b D = d2.D(f2.a.a);
            startRestartGroup.startReplaceGroup(-1224400529);
            if ((i2 & 896) == 256) {
                z3 = true;
            }
            boolean changed2 = startRestartGroup.changed(str2) | z3 | startRestartGroup.changedInstance(bm0Var) | startRestartGroup.changedInstance(eVar);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.profile.component.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit k;
                        k = SeriesProfileHeaderTagKt.k(GuestProfileViewModel.this, str2, bm0Var, eVar);
                        return k;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            d.c(str2, null, j2, null, arrayList, true, D, (Function0) rememberedValue2, startRestartGroup, 196608, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.profile.component.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = SeriesProfileHeaderTagKt.l(dl4.e.this, bm0Var, guestProfileViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0241, code lost:
    
        if (kotlin.Result.m779isFailureimpl(r0) != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01bf, code lost:
    
        if (kotlin.Result.m779isFailureimpl(r0) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0149, code lost:
    
        if (kotlin.Result.m779isFailureimpl(r0) != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(final com.bytedance.kmp.reading.model.tl0 r24, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r25, java.lang.String r26, final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 1063
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.component.SeriesProfileHeaderTagKt.m(com.bytedance.kmp.reading.model.tl0, kotlin.jvm.functions.Function1, java.lang.String, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v20 ??, still in use, count: 1, list:
          (r0v20 ?? I:java.lang.Object) from 0x01b3: INVOKE (r15v0 ?? I:androidx.compose.runtime.Composer), (r0v20 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:151519667)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static final void o(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v20 ??, still in use, count: 1, list:
          (r0v20 ?? I:java.lang.Object) from 0x01b3: INVOKE (r15v0 ?? I:androidx.compose.runtime.Composer), (r0v20 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:151519667)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r33v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
}
