package com.tencent.tinker.lib.pm.filters;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.pm.ComponentInfoGenerator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ServiceResolver extends ComponentResolver<PackageParser.Service, PackageParser.ServiceIntentInfo> {
    static {
        Covode.recordClassIndex(653786);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public PackageParser.ServiceIntentInfo[] newArray(int i) {
        return new PackageParser.ServiceIntentInfo[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public ComponentName newComponentName(PackageParser.Service service) {
        return new ComponentName(service.info.packageName, service.info.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.ComponentResolver
    public ComponentInfo generateComponentInfo(ResolveInfo resolveInfo, PackageParser.ServiceIntentInfo serviceIntentInfo) {
        ServiceInfo generateServiceInfo = ComponentInfoGenerator.generateServiceInfo(serviceIntentInfo.service, 0);
        resolveInfo.serviceInfo = generateServiceInfo;
        return generateServiceInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public boolean isPackageForFilter(String str, PackageParser.ServiceIntentInfo serviceIntentInfo) {
        return TextUtils.equals(str, serviceIntentInfo.service.info.packageName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public boolean allowFilterResult(PackageParser.ServiceIntentInfo serviceIntentInfo, List<ResolveInfo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ServiceInfo serviceInfo = list.get(size).serviceInfo;
            if (serviceInfo.name == serviceIntentInfo.service.info.name && serviceInfo.packageName == serviceIntentInfo.service.info.packageName) {
                return false;
            }
        }
        return true;
    }
}
