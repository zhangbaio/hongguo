package yq4;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.UgcCommentGroupTypeOutter;
import com.dragon.read.saas.ugc.model.UgcUserInfo;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.Single;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface f {
    int A(Context context);

    Map<String, String> B(String str);

    String C(String str);

    boolean a(LottieAnimationView lottieAnimationView, int i, float f);

    boolean b();

    u c();

    String d(Throwable th, String str);

    void e(Context context, String str, String str2, String str3, String str4, Map<String, ? extends Serializable> map);

    void ensureNotReachHere(Throwable th, String str);

    yy1.p f(UgcUserInfo ugcUserInfo, UgcCommentGroupTypeOutter ugcCommentGroupTypeOutter);

    List<yy1.p> g(UgcUserInfo ugcUserInfo, Object obj, y82.c cVar, UgcCommentGroupTypeOutter ugcCommentGroupTypeOutter, String str, boolean z);

    p92.e getErrorView(Context context, FrameLayout frameLayout);

    Pair<String, String> getErrorViewLottieUrl(String str);

    p92.f getLoadingView(Context context, FrameLayout frameLayout);

    Dialog h(yy1.h hVar);

    Dialog i(yy1.r rVar);

    t j();

    void k(Context context, String str, vw1.e eVar, Map<String, ? extends Serializable> map, boolean z, boolean z2);

    boolean l(String str);

    boolean m(LottieAnimationView lottieAnimationView, int i, float f);

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    List<yy1.p> n(UgcUserInfo ugcUserInfo, Object obj, y82.c cVar, String str, boolean z, boolean z2, boolean z3);

    void o(SimpleDraweeView simpleDraweeView, String str, ScalingUtils.ScaleType scaleType);

    yy1.e p(String str, long j);

    void q(String str, y82.c cVar);

    void r(String str, String str2, String str3);

    vw1.f s();

    void t(SimpleDraweeView simpleDraweeView, String str, ScalingUtils.ScaleType scaleType, BaseControllerListener<ImageInfo> baseControllerListener, boolean z, float f);

    void u(String str, double d);

    void v(xy1.b bVar);

    void w(String str, JSONObject jSONObject);

    Single<Boolean> x(Context context, vw1.e eVar, String str);

    void y(Context context, String str, vw1.e eVar);

    void z(Context context, vw1.e eVar, String str, Bundle bundle);

    public static final class a {
        static {
            Covode.recordClassIndex(611366);
        }

        public static /* synthetic */ Map a(f fVar, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return fVar.B(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRequestSharkParam");
        }

        public static /* synthetic */ yy1.p b(f fVar, UgcUserInfo ugcUserInfo, UgcCommentGroupTypeOutter ugcCommentGroupTypeOutter, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    ugcCommentGroupTypeOutter = null;
                }
                return fVar.f(ugcUserInfo, ugcCommentGroupTypeOutter);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSelfTag");
        }

        public static /* synthetic */ void d(f fVar, Context context, vw1.e eVar, String str, Bundle bundle, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    bundle = null;
                }
                fVar.z(context, eVar, str, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openProfile");
        }

        public static /* synthetic */ void e(f fVar, Context context, String str, vw1.e eVar, Map map, boolean z, boolean z2, int i, Object obj) {
            boolean z3;
            boolean z4;
            if (obj == null) {
                if ((i & 8) != 0) {
                    map = null;
                }
                Map map2 = map;
                if ((i & 16) != 0) {
                    z3 = true;
                } else {
                    z3 = z;
                }
                if ((i & 32) != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                fVar.k(context, str, eVar, map2, z3, z4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openUrl");
        }

        public static /* synthetic */ List c(f fVar, UgcUserInfo ugcUserInfo, Object obj, y82.c cVar, String str, boolean z, boolean z2, boolean z3, int i, Object obj2) {
            String str2;
            boolean z4;
            boolean z5;
            boolean z6;
            if (obj2 == null) {
                if ((i & 8) != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                if ((i & 16) != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if ((i & 32) != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if ((i & 64) != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                return fVar.n(ugcUserInfo, obj, cVar, str2, z4, z5, z6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserTagModels");
        }
    }
}
