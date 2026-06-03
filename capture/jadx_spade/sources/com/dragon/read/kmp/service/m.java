package com.dragon.read.kmp.service;

import com.dragon.read.user.OnLoginStateListener;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface m extends eo0.a {
    void G8(k1 k1Var);

    void K5(String str, f1 f1Var);

    List<an4.d> O7();

    void U5(List<an4.d> list);

    List<an4.e> Y6();

    void addLoginStateListener(OnLoginStateListener onLoginStateListener);

    String g4();

    String getAvatarUrl();

    String getEncodeUserId();

    long getFirstInstallTime();

    int getGender();

    String getUserId();

    String getUserName();

    an4.e getVipInfo();

    boolean isBindDouYinAccount();

    boolean isLogin();

    boolean isSelf(String str);

    void l2(Map<String, Boolean> map, b0 b0Var);

    void removeLoginStateListener(OnLoginStateListener onLoginStateListener);

    int sa();

    String z(String str);
}
