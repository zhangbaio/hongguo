package yq4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface c {
    void a(Activity activity);

    void b(Activity activity);

    void c(AppCompatActivity appCompatActivity);

    boolean d();

    void onActivityDestroy(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onActivityResult(int i, int i2, Intent intent);

    void onActivityResume(Activity activity);

    View onCreateView(String str, Context context, AttributeSet attributeSet);

    void onKeyDown(int i, KeyEvent keyEvent);

    void onKeyUp(int i, KeyEvent keyEvent);
}
