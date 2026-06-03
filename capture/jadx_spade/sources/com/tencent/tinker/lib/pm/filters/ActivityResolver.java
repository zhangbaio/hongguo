package com.tencent.tinker.lib.pm.filters;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.pm.ComponentInfoGenerator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ActivityResolver extends ComponentResolver<PackageParser.Activity, PackageParser.ActivityIntentInfo> {
    static {
        Covode.recordClassIndex(653780);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public PackageParser.ActivityIntentInfo[] newArray(int i) {
        return new PackageParser.ActivityIntentInfo[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public ComponentName newComponentName(PackageParser.Activity activity) {
        return new ComponentName(activity.info.packageName, activity.info.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public ComponentInfo generateComponentInfo(ResolveInfo resolveInfo, PackageParser.ActivityIntentInfo activityIntentInfo) {
        ActivityInfo generateActivityInfo = ComponentInfoGenerator.generateActivityInfo(activityIntentInfo.activity, 0);
        resolveInfo.activityInfo = generateActivityInfo;
        return generateActivityInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public boolean isPackageForFilter(String str, PackageParser.ActivityIntentInfo activityIntentInfo) {
        return TextUtils.equals(str, activityIntentInfo.activity.info.packageName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public boolean allowFilterResult(PackageParser.ActivityIntentInfo activityIntentInfo, List<ResolveInfo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ActivityInfo activityInfo = list.get(size).activityInfo;
            if (activityInfo.name == activityIntentInfo.activity.info.name && activityInfo.packageName == activityIntentInfo.activity.info.packageName) {
                return false;
            }
        }
        return true;
    }
}
