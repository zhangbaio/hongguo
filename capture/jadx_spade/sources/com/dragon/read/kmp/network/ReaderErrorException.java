package com.dragon.read.kmp.network;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderErrorException extends Exception {
    public static final int $stable;
    public static final a Companion;
    private final int code;
    private final String error;

    public static final class a {
        static {
            Covode.recordClassIndex(607864);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607863);
        Companion = new a(null);
        $stable = 8;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getError() {
        return this.error;
    }

    public final String getErrorMessage() {
        boolean z;
        String message = super.getMessage();
        boolean z2 = false;
        if (message != null) {
            if (message.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = true;
            }
        }
        if (z2) {
            String str = this.error;
            if (str == null) {
                return "error is empty";
            }
            return str;
        }
        Intrinsics.checkNotNull(message);
        return message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ReaderErrorException{code=" + this.code + ", error='" + this.error + "'}";
    }

    public ReaderErrorException(Integer num, String str) {
        int i;
        this.error = str;
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        this.code = i;
    }

    public /* synthetic */ ReaderErrorException(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i & 2) != 0 ? "" : str);
    }
}
