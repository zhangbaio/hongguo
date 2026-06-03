package com.dragon.read.component.shortvideo.depend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface IAbsActivityCallbackDepend extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(599148);
        Companion = a.a;
    }

    void dispatchTouchEvent(MotionEvent motionEvent);

    void onActivityCreateEnd(Activity activity);

    void onActivityCreateStart(AppCompatActivity appCompatActivity);

    void onActivityDestroy(Activity activity);

    void onActivityDown(int i, KeyEvent keyEvent);

    void onActivityKeyUp(int i, KeyEvent keyEvent);

    void onActivityPause(Activity activity);

    void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onActivityResult(int i, int i2, Intent intent);

    void onActivityResume(Activity activity);

    View onCreateView(String str, Context context, AttributeSet attributeSet);

    boolean overridePendingTransitionIntercept();

    public static final class a {
        static final /* synthetic */ a a;
        private static final IAbsActivityCallbackDepend b;

        private a() {
        }

        static {
            Covode.recordClassIndex(599149);
            a = new a();
            b = (IAbsActivityCallbackDepend) ServiceManager.getService(IAbsActivityCallbackDepend.class);
        }
    }
}
