package com.dragon.read.kmp.profile.guestprofile.album.view;

import android.content.Context;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.utils.g0;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.rpc.kmp.community.model.o7;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AlbumMultiCardItemKt {
    private static final float a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(String str, jl4.a aVar, int i, boolean z, boolean z2, boolean z3, float f, boolean z4, boolean z5, Function0 function0, int i2, Composer composer, int i3) {
        E(str, aVar, i, z, z2, z3, f, z4, z5, function0, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(String str, jl4.a aVar, int i, boolean z, boolean z2, boolean z3, float f, boolean z4, boolean z5, Function0 function0, int i2, Composer composer, int i3) {
        E(str, aVar, i, z, z2, z3, f, z4, z5, function0, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(jl4.b bVar, int i, int i2, Composer composer, int i3) {
        n(bVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(jl4.b bVar, int i, int i2, Composer composer, int i3) {
        n(bVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void E(final java.lang.String r79, final jl4.a r80, final int r81, final boolean r82, final boolean r83, final boolean r84, final float r85, final boolean r86, final boolean r87, final kotlin.jvm.functions.Function0<kotlin.Unit> r88, androidx.compose.runtime.Composer r89, final int r90) {
        /*
            Method dump skipped, instructions count: 2264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt.E(java.lang.String, jl4.a, int, boolean, boolean, boolean, float, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    static final class a implements Function0<Unit> {
        final /* synthetic */ hl4.a a;
        final /* synthetic */ com.dragon.read.rpc.kmp.community.model.z b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;

        a(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z) {
            this.a = aVar;
            this.b = zVar;
            this.c = i;
            this.d = z;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            AlbumMultiCardItemKt.C(this.a, this.b, this.c, this.d, false, "video");
        }
    }

    static {
        Covode.recordClassIndex(608130);
        a = x0.i.g(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState q() {
        return SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            this.a.get(i);
            return null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final float t(MutableState<x0.i> mutableState) {
        return ((x0.i) mutableState.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void u(MutableState<x0.i> mutableState, float f) {
        mutableState.setValue(x0.i.d(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableState mutableState, x0.t tVar) {
        u(mutableState, x0.i.g(d1.g((int) (tVar.j() & 4294967295L))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z) {
        D(aVar, zVar, i, z, true, null, 32, null);
        return Unit.INSTANCE;
    }

    public static final class c implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ com.dragon.read.rpc.kmp.community.model.z b;
        final /* synthetic */ jl4.b c;
        final /* synthetic */ Integer d;
        final /* synthetic */ boolean e;
        final /* synthetic */ float f;
        final /* synthetic */ Ref$BooleanRef g;
        final /* synthetic */ boolean h;
        final /* synthetic */ hl4.a i;
        final /* synthetic */ int j;

        public c(List list, com.dragon.read.rpc.kmp.community.model.z zVar, jl4.b bVar, Integer num, boolean z, float f, Ref$BooleanRef ref$BooleanRef, boolean z2, hl4.a aVar, int i) {
            this.a = list;
            this.b = zVar;
            this.c = bVar;
            this.d = num;
            this.e = z;
            this.f = f;
            this.g = ref$BooleanRef;
            this.h = z2;
            this.i = aVar;
            this.j = i;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(fVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i2 | i5;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            boolean z3 = false;
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i6 = (i3 & 112) | (i3 & 14);
                jl4.a aVar = (jl4.a) this.a.get(i);
                composer.startReplaceGroup(431105924);
                String str = this.b.a;
                if (str == null) {
                    str = "";
                }
                if (i == CollectionsKt__CollectionsKt.getLastIndex(this.c.b)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Integer num = this.d;
                if (num != null && num.intValue() == i) {
                    z3 = true;
                }
                boolean z4 = this.e;
                float f = this.f;
                boolean z5 = this.g.element;
                boolean z6 = this.h;
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(this.i) | composer.changedInstance(this.b) | composer.changed(this.j) | composer.changed(this.h);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(this.i, this.b, this.j, this.h);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                AlbumMultiCardItemKt.E(str, aVar, i, z2, z3, z4, f, z5, z6, (Function0) rememberedValue, composer, ((i6 >> 3) & 112) | ((i6 << 3) & 896));
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z) {
        C(aVar, zVar, i, z, false, "playlist_title");
        B(zVar, aVar, z, "profile_playlist_title");
        return Unit.INSTANCE;
    }

    private static final void B(com.dragon.read.rpc.kmp.community.model.z zVar, hl4.a aVar, boolean z, String str) {
        Map<String, ? extends Object> mapOf;
        zm4.d dVar = zm4.d.a;
        String str2 = zVar.a;
        if (str2 == null) {
            str2 = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("album_id", str2));
        dVar.c("//videoAlbumDetail", mapOf, k0.a.b().d("profile_user_id", aVar.a.i).g(rl4.d.a(aVar.a)).d("enter_from", str).c("is_pin_to_top", Integer.valueOf(z ? 1 : 0)));
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x04f7 A[LOOP:0: B:118:0x04d0->B:129:0x04f7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04f5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(final jl4.b r48, final int r49, androidx.compose.runtime.Composer r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt.n(jl4.b, int, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(hl4.a aVar, v6 v6Var, String str, int i, boolean z) {
        J(aVar, v6Var, str, i, z, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z, boolean z2) {
        if (z2) {
            C(aVar, zVar, i, z, false, "watch_more");
        }
        B(zVar, aVar, z, "profile_playlist_video_slide");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z, hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z2) {
        String str;
        if (z) {
            str = "cancel_favorite";
        } else {
            str = "favorite";
        }
        C(aVar, zVar, i, z2, false, str);
        kl4.a aVar2 = kl4.a.a;
        boolean z3 = !z;
        rl4.c cVar = aVar.a;
        String str2 = zVar.a;
        if (str2 == null) {
            str2 = "";
        }
        aVar2.a(z3, cVar, str2, "profile_with_video_playlist_card", i + 1, z2 ? 1 : 0);
        return Unit.INSTANCE;
    }

    private static final void J(hl4.a aVar, v6 v6Var, String str, int i, boolean z, boolean z2) {
        kl4.a.a.c(z2, aVar.a, v6Var, str, "profile_with_video_playlist_card", i + 1, z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z, boolean z2, String str) {
        kl4.a aVar2 = kl4.a.a;
        rl4.c cVar = aVar.a;
        String str2 = zVar.a;
        if (str2 == null) {
            str2 = "";
        }
        aVar2.b(z2, cVar, str2, "profile_with_video_playlist_card", i + 1, z ? 1 : 0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function0 function0, hl4.a aVar, boolean z, String str, Context context, v6 v6Var, int i) {
        function0.invoke();
        J(aVar, v6Var, str, i, z, false);
        ym4.k g = k0.a.b().d("profile_user_id", aVar.a.i).d("position", "profile_with_video_playlist_card").c("is_pin_to_top", Integer.valueOf(z ? 1 : 0)).g(rl4.d.a(aVar.a));
        String str2 = v6Var.a;
        if (str2 == null) {
            str2 = "";
        }
        com.dragon.read.kmp.u.k(str, g, context, str2);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void D(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            str = null;
        }
        C(aVar, zVar, i, z, z2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(jl4.b bVar, com.dragon.read.rpc.kmp.community.model.z zVar, Integer num, boolean z, float f, boolean z2, hl4.a aVar, int i, o0 NavigateMoreLazyRow) {
        boolean z3;
        Object obj;
        Integer num2;
        boolean z4;
        Intrinsics.checkNotNullParameter(NavigateMoreLazyRow, "$this$NavigateMoreLazyRow");
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Iterator<T> it2 = bVar.b.iterator();
        while (true) {
            z3 = false;
            if (it2.hasNext()) {
                obj = it2.next();
                o7 o7Var = ((jl4.a) obj).a.c;
                if (o7Var != null) {
                    num2 = o7Var.a;
                } else {
                    num2 = null;
                }
                if (g0.c(num2) < 5) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            z3 = true;
        }
        ref$BooleanRef.element = z3;
        List<jl4.a> list = bVar.b;
        NavigateMoreLazyRow.f(list.size(), (Function1) null, new b(list), androidx.compose.runtime.internal.t.c(2039820996, true, new c(list, zVar, bVar, num, z, f, ref$BooleanRef, z2, aVar, i)));
        return Unit.INSTANCE;
    }
}
