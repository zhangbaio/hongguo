package yq4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.covode.number.Covode;
import com.dragon.community.common.model.SaaSAiImageOpenParams;
import com.dragon.community.saas.ui.view.largeimage.PreviewImageData;
import com.dragon.community.saas.ui.view.preview.ImageReportData;
import com.dragon.read.saas.ugc.model.CommentExpand;
import com.dragon.read.saas.ugc.model.CommentTextExt;
import com.dragon.read.saas.ugc.model.UgcComment;
import com.dragon.read.saas.ugc.model.UgcReply;
import com.dragon.read.saas.ugc.model.UgcScrollBarV2;
import com.dragon.read.saas.ugc.model.UgcUserInfo;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Completable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import xq4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface g {
    Map<String, Object> A(List<? extends CommentTextExt> list, CommentExpand commentExpand);

    void B(br4.g gVar);

    void C(String str);

    void D(String str, Activity activity, ImageReportData imageReportData);

    m E();

    r F();

    s G();

    void H(Context context, SaaSAiImageOpenParams saaSAiImageOpenParams, vw1.e eVar);

    void I(Object obj, String str, boolean z, y82.c cVar);

    void J(UgcScrollBarV2 ugcScrollBarV2, String str, String str2, String str3, String str4, y82.c cVar);

    void K(Context context, xq4.a aVar);

    void L(Function1<? super Boolean, Unit> function1);

    void M(Context context, vw1.e eVar, int i, List<? extends PreviewImageData> list, boolean z, boolean z2, List<? extends ImageReportData> list2, List<? extends ImageReportData> list3, ArrayList<SaaSAiImageOpenParams> arrayList, Bundle bundle, boolean z3);

    View N(Context context);

    int O(UgcReply ugcReply);

    void P(Context context, Object obj);

    void Q(String str, String str2, Activity activity, ImageReportData imageReportData);

    Completable R(UgcUserInfo ugcUserInfo, boolean z, String str);

    boolean S();

    void T(Context context, UgcScrollBarV2 ugcScrollBarV2, String str, String str2, String str3, String str4, y82.c cVar);

    Map<String, Serializable> U(Activity activity, y82.c cVar, CommentTextExt commentTextExt);

    boolean V();

    String W(String str);

    void X(Context context, vw1.e eVar, int i, List<? extends PreviewImageData> list, List<? extends ImageReportData> list2, List<? extends ImageReportData> list3, boolean z);

    Completable Y(Dialog dialog, LinearLayout linearLayout, FrameLayout frameLayout, Object obj);

    void a(int i, int i2, Intent intent, Activity activity);

    void b(View view, Object obj, HashMap<String, Serializable> hashMap);

    Bitmap c(Uri uri);

    boolean checkCommentForbidden();

    d d();

    void e(String str);

    boolean f(int i);

    void g(LottieAnimationView lottieAnimationView);

    a.b h(String str);

    j i();

    boolean isPreviewImageActivity(Context context);

    boolean isReaderActivity(Activity activity);

    void j(Context context, String str);

    Completable k(Dialog dialog, LinearLayout linearLayout, FrameLayout frameLayout, Object obj);

    boolean l();

    void m(int i, int i2, Intent intent, br4.b bVar);

    boolean n();

    void o(View view, View view2, boolean z, String str, String str2, Map<String, ? extends Serializable> map);

    vw1.c p(EditText editText);

    vw1.d q(EditText editText);

    int r(UgcComment ugcComment);

    boolean s(Activity activity);

    void t(Function1<? super Boolean, Unit> function1);

    Map<String, Serializable> u(Activity activity, y82.c cVar, CommentTextExt commentTextExt);

    boolean v(String str);

    Drawable w(UgcUserInfo ugcUserInfo);

    x x();

    void y(String str, boolean z);

    void z(String str, JSONObject jSONObject, String str2);

    public static final class a {
        static {
            Covode.recordClassIndex(611368);
        }

        public static /* synthetic */ void a(g gVar, int i, int i2, Intent intent, br4.b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    bVar = null;
                }
                gVar.m(i, i2, intent, bVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleActivityResultFromSystemAlbum");
        }

        public static /* synthetic */ void b(g gVar, Context context, vw1.e eVar, int i, List list, boolean z, boolean z2, List list2, List list3, ArrayList arrayList, Bundle bundle, boolean z3, int i2, Object obj) {
            boolean z4;
            boolean z5;
            List list4;
            List list5;
            ArrayList arrayList2;
            Bundle bundle2;
            boolean z6;
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if ((i2 & 32) != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if ((i2 & 64) != 0) {
                    list4 = null;
                } else {
                    list4 = list2;
                }
                if ((i2 & 128) != 0) {
                    list5 = null;
                } else {
                    list5 = list3;
                }
                if ((i2 & 256) != 0) {
                    arrayList2 = null;
                } else {
                    arrayList2 = arrayList;
                }
                if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0) {
                    bundle2 = null;
                } else {
                    bundle2 = bundle;
                }
                if ((i2 & 1024) != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                gVar.M(context, eVar, i, list, z4, z5, list4, list5, arrayList2, bundle2, z6);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: previewImageFromNative");
        }
    }
}
