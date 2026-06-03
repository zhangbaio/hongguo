package yq4;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.dragon.community.common.model.StorageResult;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e {
    SharedPreferences a(Context context, String str);

    yy1.a b();

    boolean c();

    SharedPreferences d(Context context, String str);

    StorageResult e(String str, String str2, boolean z);

    StorageResult f(String str, boolean z);

    List<Activity> g();

    Application getAppContext();

    int getAppTheme();

    String getChannel();

    int getComplianceStatus();

    Activity getCurrentActivity();

    yy1.b h();

    StorageResult i(String str, boolean z);

    void j(Activity activity, boolean z);
}
