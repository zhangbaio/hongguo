package com.xiaomi;

import android.content.Context;
import android.content.SharedPreferences;
import g01.b;
import pz0.d;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MiPushSettings$$SettingImpl implements MiPushSettings {
    private Context a;
    private b b;
    private final d c = new a();

    @Override // com.xiaomi.MiPushSettings
    public boolean A0() {
        b bVar = this.b;
        if (bVar != null && bVar.contains("mipush_upgrade_3616")) {
            return this.b.getBoolean("mipush_upgrade_3616");
        }
        return false;
    }

    class a implements d {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    public void unregisterValChanged(pz0.a aVar) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.unregisterValChanged(aVar);
        }
    }

    @Override // com.xiaomi.MiPushSettings
    public void Z1(boolean z) {
        b bVar = this.b;
        if (bVar != null) {
            SharedPreferences.Editor edit = bVar.edit();
            edit.putBoolean("mipush_upgrade_3616", z);
            edit.apply();
        }
    }

    public MiPushSettings$$SettingImpl(Context context, b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public void registerValChanged(Context context, String str, String str2, pz0.a aVar) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.registerValChanged(context, str, str2, aVar);
        }
    }
}
