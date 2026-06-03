package ys3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.dragon.read.report.PageRecorder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    boolean a(Activity activity);

    void b(String str, Context context, PageRecorder pageRecorder);

    void onActivityResult(int i, int i2, Intent intent);
}
