package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import com.dragon.read.user.OnLoginStateListener;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 implements m {
    public static final c0 a;

    static {
        Covode.recordClassIndex(608867);
        a = new c0();
    }

    private c0() {
    }

    @Override // com.dragon.read.kmp.service.m
    public List<an4.d> O7() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.O7();
        }
        return null;
    }

    @Override // com.dragon.read.kmp.service.m
    public List<an4.e> Y6() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.Y6();
        }
        return null;
    }

    @Override // com.dragon.read.kmp.service.m
    public String g4() {
        String g4;
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar == null || (g4 = mVar.g4()) == null) {
            return "";
        }
        return g4;
    }

    @Override // com.dragon.read.kmp.service.m
    public String getAvatarUrl() {
        String avatarUrl;
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar == null || (avatarUrl = mVar.getAvatarUrl()) == null) {
            return "";
        }
        return avatarUrl;
    }

    @Override // com.dragon.read.kmp.service.m
    public String getEncodeUserId() {
        String encodeUserId;
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar == null || (encodeUserId = mVar.getEncodeUserId()) == null) {
            return "";
        }
        return encodeUserId;
    }

    @Override // com.dragon.read.kmp.service.m
    public long getFirstInstallTime() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.getFirstInstallTime();
        }
        return 0L;
    }

    @Override // com.dragon.read.kmp.service.m
    public int getGender() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.getGender();
        }
        return 0;
    }

    @Override // com.dragon.read.kmp.service.m
    public String getUserId() {
        String userId;
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar == null || (userId = mVar.getUserId()) == null) {
            return "";
        }
        return userId;
    }

    @Override // com.dragon.read.kmp.service.m
    public String getUserName() {
        String userName;
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar == null || (userName = mVar.getUserName()) == null) {
            return "";
        }
        return userName;
    }

    @Override // com.dragon.read.kmp.service.m
    public an4.e getVipInfo() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.getVipInfo();
        }
        return null;
    }

    @Override // com.dragon.read.kmp.service.m
    public boolean isBindDouYinAccount() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.isBindDouYinAccount();
        }
        return false;
    }

    @Override // com.dragon.read.kmp.service.m
    public boolean isLogin() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.isLogin();
        }
        return false;
    }

    @Override // com.dragon.read.kmp.service.m
    public int sa() {
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.sa();
        }
        return 0;
    }

    @Override // com.dragon.read.kmp.service.m
    public void G8(k1 cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            mVar.G8(cb);
        }
    }

    @Override // com.dragon.read.kmp.service.m
    public void U5(List<an4.d> innerPushSwitchConf) {
        Intrinsics.checkNotNullParameter(innerPushSwitchConf, "innerPushSwitchConf");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            mVar.U5(innerPushSwitchConf);
        }
    }

    @Override // com.dragon.read.kmp.service.m
    public void addLoginStateListener(OnLoginStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            mVar.addLoginStateListener(listener);
        }
    }

    @Override // com.dragon.read.kmp.service.m
    public boolean isSelf(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            return mVar.isSelf(uid);
        }
        return false;
    }

    @Override // com.dragon.read.kmp.service.m
    public void removeLoginStateListener(OnLoginStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            mVar.removeLoginStateListener(listener);
        }
    }

    @Override // com.dragon.read.kmp.service.m
    public String z(String url) {
        String z;
        Intrinsics.checkNotNullParameter(url, "url");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar == null || (z = mVar.z(url)) == null) {
            return "";
        }
        return z;
    }

    @Override // com.dragon.read.kmp.service.m
    public void K5(String from, f1 cb) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(cb, "cb");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            mVar.K5(from, cb);
        }
    }

    @Override // com.dragon.read.kmp.service.m
    public void l2(Map<String, Boolean> innerPushConfigMap, b0 cb) {
        Intrinsics.checkNotNullParameter(innerPushConfigMap, "innerPushConfigMap");
        Intrinsics.checkNotNullParameter(cb, "cb");
        m mVar = (m) eo0.c.a.a(Reflection.getOrCreateKotlinClass(m.class));
        if (mVar != null) {
            mVar.l2(innerPushConfigMap, cb);
        }
    }
}
