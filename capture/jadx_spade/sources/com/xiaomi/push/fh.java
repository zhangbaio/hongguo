package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fh extends Exception {
    private fq a;

    /* renamed from: a, reason: collision with other field name */
    private fr f451a;

    /* renamed from: a, reason: collision with other field name */
    private Throwable f452a;

    static {
        Covode.recordClassIndex(655522);
    }

    public Throwable a() {
        return this.f452a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public fh() {
        this.a = null;
        this.f451a = null;
        this.f452a = null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fq fqVar;
        fr frVar;
        String message = super.getMessage();
        if (message == null && (frVar = this.f451a) != null) {
            return frVar.toString();
        }
        if (message == null && (fqVar = this.a) != null) {
            return fqVar.toString();
        }
        return message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        fr frVar = this.f451a;
        if (frVar != null) {
            sb.append(frVar);
        }
        fq fqVar = this.a;
        if (fqVar != null) {
            sb.append(fqVar);
        }
        if (this.f452a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f452a);
        }
        return sb.toString();
    }

    public fh(fq fqVar) {
        this.f451a = null;
        this.f452a = null;
        this.a = fqVar;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f452a != null) {
            printStream.println("Nested Exception: ");
            this.f452a.printStackTrace(printStream);
        }
    }

    public fh(String str) {
        super(str);
        this.a = null;
        this.f451a = null;
        this.f452a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f452a != null) {
            printWriter.println("Nested Exception: ");
            this.f452a.printStackTrace(printWriter);
        }
    }

    public fh(Throwable th) {
        this.a = null;
        this.f451a = null;
        this.f452a = th;
    }

    public fh(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f451a = null;
        this.f452a = th;
    }
}
