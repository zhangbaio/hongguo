package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTServiceInfo {
    public int a;
    public boolean c;
    public CronetFrontierClient.d e;
    public boolean b = true;
    public ServicePriority d = ServicePriority.Low;

    static {
        Covode.recordClassIndex(654658);
    }

    public enum ServicePriority {
        Low(0),
        Medium(1),
        High(2);

        final int priority;

        public int getValue() {
            return this.priority;
        }

        static {
            Covode.recordClassIndex(654659);
        }

        ServicePriority(int i) {
            this.priority = i;
        }
    }

    public TTServiceInfo(int i, CronetFrontierClient.d dVar) {
        if (i > 0) {
            if (dVar != null) {
                this.a = i;
                this.e = dVar;
                return;
            }
            throw new IllegalArgumentException("Service listener must not be null.");
        }
        throw new IllegalArgumentException("Service identity must be set greater than 0.");
    }
}
