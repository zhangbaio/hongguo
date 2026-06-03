package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class s extends NetworkChangeNotifierAutoDetect.h implements ApplicationStatus.b {
    private boolean b;

    static {
        Covode.recordClassIndex(654510);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.h
    protected void a() {
        if (this.b) {
            return;
        }
        ApplicationStatus.g(this);
        this.b = true;
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.h
    protected void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.b(networkChangeNotifierAutoDetect);
        ApplicationStatus.f(this);
        e(0);
    }

    public void e(int i) {
        if (ApplicationStatus.hasVisibleActivities()) {
            c();
        } else {
            d();
        }
    }
}
