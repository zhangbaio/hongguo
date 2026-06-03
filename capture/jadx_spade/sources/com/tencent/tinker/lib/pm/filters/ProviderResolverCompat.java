package com.tencent.tinker.lib.pm.filters;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.ResolveInfo;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProviderResolverCompat extends ComponentResolver {
    static {
        Covode.recordClassIndex(653785);
    }

    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    protected ComponentInfo generateComponentInfo(ResolveInfo resolveInfo, PackageParser.IntentInfo intentInfo) {
        return null;
    }

    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    protected boolean isPackageForFilter(String str, IntentFilter intentFilter) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver, com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public PackageParser.IntentInfo[] newArray(int i) {
        return new PackageParser.IntentInfo[i];
    }

    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    protected ComponentName newComponentName(PackageParser.Component component) {
        if (component instanceof PackageParser.Provider) {
            PackageParser.Provider provider = (PackageParser.Provider) component;
            return new ComponentName(provider.info.packageName, provider.info.name);
        }
        return new ComponentName(component.owner.packageName, component.className);
    }
}
