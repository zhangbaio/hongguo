package zj4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserPreferenceScene;
import com.bytedance.kmp.reading.model.dl;
import com.bytedance.kmp.reading.model.i00;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607719);
            int[] iArr = new int[UserPreferenceScene.values().length];
            try {
                iArr[UserPreferenceScene.cold_start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserPreferenceScene.my_read_preference.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UserPreferenceScene.category_cell.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UserPreferenceScene.gold_coin_page.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UserPreferenceScene.unlimited_cell_read_preference.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UserPreferenceScene.single_col_snack_bar.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UserPreferenceScene.tri_col_snack_bar.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[UserPreferenceScene.single_col_category_select.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[UserPreferenceScene.dislike_category_select_category.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(607718);
        a = new b();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence h(i00 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        String str = it2.b;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String b(UserPreferenceScene userPreferenceScene) {
        int i;
        if (userPreferenceScene == null) {
            i = -1;
        } else {
            i = a.a[userPreferenceScene.ordinal()];
        }
        switch (i) {
            case 1:
                return "first_launch";
            case 2:
                return "mine";
            case 3:
                return "hot_category_module";
            case 4:
                return "gold_coin_page";
            case 5:
                return "guess_you_like";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return "video_player";
            case 7:
                return "store_sanlie";
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return "danlie_gold_banner";
            case 9:
                return "dislike";
            default:
                return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r2.intValue() != r3) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String c(com.bytedance.kmp.reading.model.dl r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L17
            java.lang.Integer r2 = r5.b
            com.bytedance.kmp.reading.model.Gender r3 = com.bytedance.kmp.reading.model.Gender.MALE
            int r3 = r3.getValue()
            if (r2 != 0) goto Lf
            goto L17
        Lf:
            int r2 = r2.intValue()
            if (r2 != r3) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            if (r2 == 0) goto L1d
            java.lang.String r5 = "male"
            goto L48
        L1d:
            if (r5 == 0) goto L31
            java.lang.Integer r2 = r5.b
            com.bytedance.kmp.reading.model.Gender r3 = com.bytedance.kmp.reading.model.Gender.FEMALE
            int r3 = r3.getValue()
            if (r2 != 0) goto L2a
            goto L31
        L2a:
            int r2 = r2.intValue()
            if (r2 != r3) goto L31
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L37
            java.lang.String r5 = "female"
            goto L48
        L37:
            if (r5 == 0) goto L3c
            java.lang.Boolean r5 = r5.c
            goto L3d
        L3c:
            r5 = 0
        L3d:
            boolean r5 = com.dragon.read.kmp.utils.g0.a(r5)
            if (r5 == 0) goto L46
            java.lang.String r5 = "all"
            goto L48
        L46:
            java.lang.String r5 = ""
        L48:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zj4.b.c(com.bytedance.kmp.reading.model.dl):java.lang.String");
    }

    public final void d(UserPreferenceScene userPreferenceScene, String str) {
        o.a.d("read_profile_enter", new ym4.a().g("enter_from", b(userPreferenceScene)).g("type", str));
    }

    public final void i(UserPreferenceScene userPreferenceScene, String str, String str2, String str3) {
        o.a.d("read_profile_click", new ym4.a().g("enter_from", b(userPreferenceScene)).g("type", str).g("clicked_content", str2).g("result", str3));
    }

    public final void f(UserPreferenceScene userPreferenceScene, String str, dl dlVar, List<i00> categoryLike) {
        Intrinsics.checkNotNullParameter(categoryLike, "categoryLike");
        o.a.d("read_profile_select", new ym4.a().g("enter_from", b(userPreferenceScene)).g("type", str).g("gender", c(dlVar)).g("category_like", CollectionsKt___CollectionsKt.joinToString$default(categoryLike, ",", null, null, 0, null, new Function1() { // from class: zj4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence h;
                h = b.h((i00) obj);
                return h;
            }
        }, 30, null)));
    }

    public static /* synthetic */ void e(b bVar, UserPreferenceScene userPreferenceScene, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "category";
        }
        bVar.d(userPreferenceScene, str);
    }

    public static /* synthetic */ void g(b bVar, UserPreferenceScene userPreferenceScene, String str, dl dlVar, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "category";
        }
        bVar.f(userPreferenceScene, str, dlVar, list);
    }

    public static /* synthetic */ void j(b bVar, UserPreferenceScene userPreferenceScene, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "category";
        }
        bVar.i(userPreferenceScene, str, str2, str3);
    }
}
