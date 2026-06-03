package qn4;

import ao4.b0;
import ao4.f;
import ao4.g;
import ao4.g0;
import ao4.h0;
import ao4.l;
import ao4.m;
import ao4.r;
import ao4.w;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.dragon.read.app.App;
import com.dragon.read.util.UriUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import un4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final Map<String, ao4.a> b;
    public static final int c;

    private a() {
    }

    public final Map<String, ao4.a> f() {
        return b;
    }

    static {
        Covode.recordClassIndex(608906);
        a = new a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        b = linkedHashMap;
        linkedHashMap.put("copy_link", new f());
        linkedHashMap.put("douyin_feed", new g());
        linkedHashMap.put("douyin_im", new l());
        linkedHashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, new w());
        linkedHashMap.put("moments", new g0());
        linkedHashMap.put("weibo", new b0());
        linkedHashMap.put("sys_share", new r());
        linkedHashMap.put("image_share", new m());
        linkedHashMap.put("xhs", new h0());
        c = 8;
    }

    public final boolean g(String shareChannelId) {
        Intrinsics.checkNotNullParameter(shareChannelId, "shareChannelId");
        ao4.a aVar = b.get(shareChannelId);
        if (aVar == null || !aVar.a()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Pair<Integer, Integer> d(String shareChannelType) {
        Intrinsics.checkNotNullParameter(shareChannelType, "shareChannelType");
        switch (shareChannelType.hashCode()) {
            case -1777292293:
                if (shareChannelType.equals("image_share")) {
                    return TuplesKt.to(2130844580, 2130844581);
                }
                return null;
            case -791770330:
                if (shareChannelType.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    return TuplesKt.to(2130844599, 2130844599);
                }
                return null;
            case -333314600:
                if (shareChannelType.equals("long_image")) {
                    return TuplesKt.to(2130844586, 2130844586);
                }
                return null;
            case -150184081:
                if (shareChannelType.equals("douyin_im")) {
                    return TuplesKt.to(2130844544, 2130844544);
                }
                return null;
            case 3616:
                if (shareChannelType.equals("qq")) {
                    return TuplesKt.to(2130844571, 2130844571);
                }
                return null;
            case 118659:
                if (shareChannelType.equals("xhs")) {
                    return TuplesKt.to(2130844605, 2130844604);
                }
                return null;
            case 108102557:
                if (shareChannelType.equals("qzone")) {
                    return TuplesKt.to(2130844575, 2130844575);
                }
                return null;
            case 113011944:
                if (shareChannelType.equals("weibo")) {
                    return TuplesKt.to(2130844603, 2130844603);
                }
                return null;
            case 540697581:
                if (shareChannelType.equals("sys_share")) {
                    return TuplesKt.to(2130844589, 2130844592);
                }
                return null;
            case 1235271283:
                if (shareChannelType.equals("moments")) {
                    return TuplesKt.to(2130844561, 2130844561);
                }
                return null;
            case 1505434244:
                if (shareChannelType.equals("copy_link")) {
                    return TuplesKt.to(2130844555, 2130844555);
                }
                return null;
            case 1701892393:
                if (shareChannelType.equals("douyin_feed")) {
                    return TuplesKt.to(2130844539, 2130844539);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Pair<Integer, Integer> e(String shareChannelType) {
        Intrinsics.checkNotNullParameter(shareChannelType, "shareChannelType");
        switch (shareChannelType.hashCode()) {
            case -1777292293:
                if (shareChannelType.equals("image_share")) {
                    return TuplesKt.to(2130844578, 2130844579);
                }
                return null;
            case -791770330:
                if (shareChannelType.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    return TuplesKt.to(2130844596, 2130844596);
                }
                return null;
            case -333314600:
                if (shareChannelType.equals("long_image")) {
                    return TuplesKt.to(2130844547, 2130844548);
                }
                return null;
            case -150184081:
                if (shareChannelType.equals("douyin_im")) {
                    return TuplesKt.to(2130844540, 2130844541);
                }
                return null;
            case 3616:
                if (shareChannelType.equals("qq")) {
                    return TuplesKt.to(2130844568, 2130844568);
                }
                return null;
            case 118659:
                if (shareChannelType.equals("xhs")) {
                    return TuplesKt.to(2130844604, 2130844604);
                }
                return null;
            case 108102557:
                if (shareChannelType.equals("qzone")) {
                    return TuplesKt.to(2130844572, 2130844572);
                }
                return null;
            case 113011944:
                if (shareChannelType.equals("weibo")) {
                    return TuplesKt.to(2130844600, 2130844600);
                }
                return null;
            case 540697581:
                if (shareChannelType.equals("sys_share")) {
                    return TuplesKt.to(2130844588, 2130844588);
                }
                return null;
            case 1235271283:
                if (shareChannelType.equals("moments")) {
                    return TuplesKt.to(2130844558, 2130844558);
                }
                return null;
            case 1505434244:
                if (shareChannelType.equals("copy_link")) {
                    return TuplesKt.to(2130844551, 2130844552);
                }
                return null;
            case 1701892393:
                if (shareChannelType.equals("douyin_feed")) {
                    return TuplesKt.to(2130844535, 2130844535);
                }
                return null;
            default:
                return null;
        }
    }

    public final ShareContent.b b(ShareChannelType channelType, String imageUrl) {
        Intrinsics.checkNotNullParameter(channelType, "channelType");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        ShareContent.b B = new ShareContent.b().v(imageUrl).A(channelType).B(ShareContentType.IMAGE);
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(imageUrl);
        if (polarisFileWrapper.exists()) {
            B.q(UriUtils.getIntentUri(App.context(), polarisFileWrapper).toString());
        }
        Intrinsics.checkNotNull(B);
        return B;
    }

    public final ShareContent.b c(ShareChannelType channelType, String title) {
        Intrinsics.checkNotNullParameter(channelType, "channelType");
        Intrinsics.checkNotNullParameter(title, "title");
        ShareContent.b B = new ShareContent.b().L(title).A(channelType).B(ShareContentType.TEXT);
        Intrinsics.checkNotNullExpressionValue(B, "setShareContentType(...)");
        return B;
    }

    public final ShareContent.b a(ShareChannelType channelType, e kmpShareContent, String str) {
        Intrinsics.checkNotNullParameter(channelType, "channelType");
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        ShareContent.b J = new ShareContent.b().B(ShareContentType.H5).A(channelType).L(kmpShareContent.c).K(kmpShareContent.d).v(kmpShareContent.e).J(str);
        Intrinsics.checkNotNullExpressionValue(J, "setTargetUrl(...)");
        return J;
    }
}
