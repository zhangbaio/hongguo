package wj4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.mine.profile.ProfileItemType;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607711);
            int[] iArr = new int[ProfileItemType.values().length];
            try {
                iArr[ProfileItemType.AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileItemType.NICKNAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileItemType.ACCOUNTID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileItemType.GENDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileItemType.SIGNATURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileItemType.BACKGROUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(607710);
        a = new b();
    }

    private b() {
    }

    public final String a(ProfileItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (a.a[type.ordinal()]) {
            case 1:
                return "key_avatar_verify_fail_tag_show";
            case 2:
                return "key_user_name_verify_fail_tag_show";
            case 3:
                return "key_biz_user_id_fail_tag_show";
            case 4:
                return "key_gender_verify_fail_tag_show";
            case 5:
                return "key_desc_verify_fail_tag_show";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return "key_bg_verify_fail_tag_show";
            default:
                return "";
        }
    }
}
