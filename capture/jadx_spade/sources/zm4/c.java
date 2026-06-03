package zm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.hybrid.WebUrlManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(608707);
        a = new c();
    }

    private c() {
    }

    public final String a() {
        String agreementUrl = WebUrlManager.getInstance().getAgreementUrl();
        Intrinsics.checkNotNullExpressionValue(agreementUrl, "getAgreementUrl(...)");
        return agreementUrl;
    }

    public final String b() {
        String inviteAnswerUrl = WebUrlManager.getInstance().getInviteAnswerUrl();
        Intrinsics.checkNotNullExpressionValue(inviteAnswerUrl, "getInviteAnswerUrl(...)");
        return inviteAnswerUrl;
    }

    public final String c() {
        String privacyUrl = WebUrlManager.getInstance().getPrivacyUrl();
        Intrinsics.checkNotNullExpressionValue(privacyUrl, "getPrivacyUrl(...)");
        return privacyUrl;
    }

    public final String d() {
        String searchAiRobotUrl = WebUrlManager.getInstance().getSearchAiRobotUrl();
        Intrinsics.checkNotNullExpressionValue(searchAiRobotUrl, "getSearchAiRobotUrl(...)");
        return searchAiRobotUrl;
    }

    public final String e() {
        String searchAiRobotUserId = WebUrlManager.getInstance().getSearchAiRobotUserId();
        Intrinsics.checkNotNullExpressionValue(searchAiRobotUserId, "getSearchAiRobotUserId(...)");
        return searchAiRobotUserId;
    }

    public final String f() {
        String serialAreaUrl = WebUrlManager.getInstance().getSerialAreaUrl();
        Intrinsics.checkNotNullExpressionValue(serialAreaUrl, "getSerialAreaUrl(...)");
        return serialAreaUrl;
    }
}
