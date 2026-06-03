package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class TTAppInfoProvider {
    static {
        Covode.recordClassIndex(654517);
    }

    public abstract AppInfo a();

    public static class AppInfo {
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String F;
        public String G;
        public String H;
        public String I;
        public String J;
        public String K;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        static {
            Covode.recordClassIndex(654518);
        }

        public String getAbSdkVersion() {
            return this.f;
        }

        public String getAbi() {
            return this.E;
        }

        public String getAppId() {
            return this.a;
        }

        public String getAppName() {
            return this.w;
        }

        public String getCarrierRegion() {
            return this.o;
        }

        public String getChannel() {
            return this.e;
        }

        public String getDeviceBrand() {
            return this.A;
        }

        public String getDeviceId() {
            return this.t;
        }

        public String getDeviceModel() {
            return this.B;
        }

        public String getDevicePlatform() {
            return this.b;
        }

        public String getDeviceType() {
            return this.v;
        }

        public String getDomainBoe() {
            return this.k;
        }

        public String getDomainBoeHttps() {
            return this.l;
        }

        public String getDomainHttpDns() {
            return this.j;
        }

        public String getHostFirst() {
            return this.g;
        }

        public String getHostSecond() {
            return this.h;
        }

        public String getHostThird() {
            return this.i;
        }

        public String getHttpDnsRequestFlags() {
            return this.q;
        }

        public String getInitRegion() {
            return this.p;
        }

        public String getIsDomestic() {
            return this.K;
        }

        public String getIsDropFirstTnc() {
            return this.F;
        }

        public String getManifestVersionCode() {
            return this.D;
        }

        public String getNetAccessType() {
            return this.u;
        }

        public String getOSApi() {
            return this.s;
        }

        public String getOSVersion() {
            return this.z;
        }

        public String getRegion() {
            return this.m;
        }

        public String getSdkAppID() {
            return this.x;
        }

        public String getSdkVersion() {
            return this.y;
        }

        public String getStoreIdc() {
            return this.G;
        }

        public String getSysRegion() {
            return this.n;
        }

        public String getTNCRequestFlags() {
            return this.J;
        }

        public String getTNCRequestHeader() {
            return this.H;
        }

        public String getTNCRequestQuery() {
            return this.I;
        }

        public String getUpdateVersionCode() {
            return this.d;
        }

        public String getUserId() {
            return this.r;
        }

        public String getVersionCode() {
            return this.c;
        }

        public String getVersionName() {
            return this.C;
        }
    }
}
