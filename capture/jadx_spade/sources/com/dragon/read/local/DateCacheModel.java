package com.dragon.read.local;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import er4.r;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DateCacheModel<T extends Serializable> implements Serializable {
    public static final int $stable;
    public static final a Companion;
    private static final long serialVersionUID = 0;

    @SerializedName("data")
    private T data;

    @SerializedName("date")
    private String date = r.a();

    public static final class a {
        static {
            Covode.recordClassIndex(611465);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611464);
        Companion = new a(null);
        $stable = 8;
    }

    public final T getData() {
        return this.data;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }
}
