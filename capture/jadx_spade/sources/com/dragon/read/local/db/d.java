package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(611520);
        a = new d();
    }

    private d() {
    }

    public final void a(String tableName, String action, boolean z) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(action, "action");
        com.dragon.read.reader.depend.a aVar = com.dragon.read.reader.depend.a.b;
        Args args = new Args();
        args.put("tableName", tableName);
        args.put("action", action);
        args.put("isNew", Boolean.valueOf(z));
        Unit unit = Unit.INSTANCE;
        aVar.m("reader_database_user_pv", args);
    }

    public final void b(String tableName, int i, long j) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        com.dragon.read.reader.depend.a aVar = com.dragon.read.reader.depend.a.b;
        Args args = new Args();
        args.put("tableName", tableName);
        args.put("size", Integer.valueOf(i));
        args.put("duration", Long.valueOf(j));
        Unit unit = Unit.INSTANCE;
        aVar.m("reader_database_migration", args);
    }
}
