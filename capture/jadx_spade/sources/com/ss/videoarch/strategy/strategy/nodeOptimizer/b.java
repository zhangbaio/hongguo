package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import com.bytedance.covode.number.Covode;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    protected final String a;
    public int b = 2;

    static {
        Covode.recordClassIndex(653203);
    }

    public List<String> a() {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(this.a);
            ArrayList arrayList = new ArrayList();
            if (allByName != null && allByName.length > 0) {
                boolean z = false;
                boolean z2 = false;
                for (InetAddress inetAddress : allByName) {
                    arrayList.add(inetAddress.getHostAddress());
                    if (!z && (inetAddress instanceof Inet6Address)) {
                        z = true;
                    }
                    if (!z2 && (inetAddress instanceof Inet4Address)) {
                        z2 = true;
                    }
                }
                if (z && !z2) {
                    this.b = 1;
                } else if (!z && z2) {
                    this.b = 0;
                }
            }
            return arrayList;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    b(String str) {
        this.a = str;
    }
}
