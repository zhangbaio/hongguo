package yq4;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface o {
    void a(Dialog dialog);

    void b(Activity activity, View view);

    void c(Context context, vw1.e eVar, String str);

    float calcScaleSize(float f);

    z d();

    void e(Activity activity, View view);

    ClipData f();

    Activity findTopAudioPlayActivityWithBookId(String str);

    void g(TextView textView);

    c getActivityHelper();

    void h(Activity activity, View view);

    void i(Activity activity);

    boolean isGlobalPlayerViewAttachAndVisible();

    boolean isListenType(String str);

    void j(Activity activity);

    void k();

    void l(Context context, vw1.e eVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3);

    boolean m(String str);

    void notifyPermissionsChange(Activity activity, int i, String[] strArr, int[] iArr);

    void setPrimaryClip(ClipData clipData);

    void updateWebDarkStatus(boolean z, boolean z2);

    public static final class a {
        static {
            Covode.recordClassIndex(611381);
        }

        public static /* synthetic */ void a(o oVar, Context context, vw1.e eVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i, Object obj) {
            String str4;
            String str5;
            boolean z4;
            boolean z5;
            if (obj == null) {
                if ((i & 8) != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if ((i & 16) != 0) {
                    str5 = null;
                } else {
                    str5 = str3;
                }
                if ((i & 64) != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if ((i & 128) != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                oVar.l(context, eVar, str, str4, str5, z, z4, z5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchAudio");
        }
    }
}
