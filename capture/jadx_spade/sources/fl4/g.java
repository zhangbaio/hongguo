package fl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    static {
        Covode.recordClassIndex(608092);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(j jVar, GuestProfileViewModel guestProfileViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        e(jVar, guestProfileViewModel, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(j jVar, GuestProfileViewModel guestProfileViewModel) {
        jVar.setShown(true);
        guestProfileViewModel.g1(jVar.a, jVar.f);
        guestProfileViewModel.j1(jVar.a, jVar.f, "recommend_user_profile");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(GuestProfileViewModel guestProfileViewModel, j jVar) {
        guestProfileViewModel.w0(jVar.a, jVar.f, jVar.g);
        guestProfileViewModel.f1("profile");
        guestProfileViewModel.i1(jVar.a, jVar.f, "recommend_user_profile");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(j jVar, GuestProfileViewModel guestProfileViewModel) {
        Map<String, Object> mutableMapOf;
        String str;
        int i = jVar.d;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("rank", Integer.valueOf(jVar.f)));
        guestProfileViewModel.l1(jVar.a, Integer.valueOf(i), "recommend_user_profile", mutableMapOf);
        if (i != UserRelationType.None.getValue() && i != UserRelationType.Followed.getValue()) {
            str = "cancel_follow_user";
        } else {
            str = "follow_user";
        }
        guestProfileViewModel.f1(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final fl4.j r44, final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r45, androidx.compose.ui.Modifier r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 1803
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fl4.g.e(fl4.j, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
