package com.tencent.tinker.lib.pm.filters;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.pm.ComponentInfoGenerator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProviderResolver extends ComponentResolver<PackageParser.Provider, PackageParser.ProviderIntentInfo> {
    static {
        Covode.recordClassIndex(653784);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public PackageParser.ProviderIntentInfo[] newArray(int i) {
        return new PackageParser.ProviderIntentInfo[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public ComponentName newComponentName(PackageParser.Provider provider) {
        return new ComponentName(provider.info.packageName, provider.info.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public ComponentInfo generateComponentInfo(ResolveInfo resolveInfo, PackageParser.ProviderIntentInfo providerIntentInfo) {
        ProviderInfo generateProviderInfo = ComponentInfoGenerator.generateProviderInfo(providerIntentInfo.provider, 0);
        resolveInfo.providerInfo = generateProviderInfo;
        return generateProviderInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public boolean isPackageForFilter(String str, PackageParser.ProviderIntentInfo providerIntentInfo) {
        return TextUtils.equals(str, providerIntentInfo.provider.info.packageName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public boolean allowFilterResult(PackageParser.ProviderIntentInfo providerIntentInfo, List<ResolveInfo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ProviderInfo providerInfo = list.get(size).providerInfo;
            if (providerInfo.name == providerIntentInfo.provider.info.name && providerInfo.packageName == providerIntentInfo.provider.info.packageName) {
                return false;
            }
        }
        return true;
    }
}
