package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.net.UnknownHostException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class el {

    static class a {
        eh a;

        /* renamed from: a, reason: collision with other field name */
        String f381a;

        static {
            Covode.recordClassIndex(655491);
        }

        a() {
        }
    }

    static {
        Covode.recordClassIndex(655490);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m384a(Exception exc) {
        if (exc != null) {
        } else {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    static a a(Exception exc) {
        m384a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = fb.a(exc2);
        if (a2 != 0) {
            aVar.a = eh.a(eh.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = eh.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == eh.GSLB_TCP_ERR_OTHER) {
            aVar.f381a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Throwable] */
    static a b(Exception exc) {
        Throwable cause;
        m384a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fb.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            eh a3 = eh.a(eh.CONN_SUCCESS.a() + a2);
            aVar.a = a3;
            if (a3 == eh.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = eh.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = eh.CONN_XMPP_ERR;
        }
        eh ehVar = aVar.a;
        if (ehVar == eh.CONN_TCP_ERR_OTHER || ehVar == eh.CONN_XMPP_ERR || ehVar == eh.CONN_BOSH_ERR) {
            aVar.f381a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    static a c(Exception exc) {
        m384a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fb.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 105) {
            if (a2 != 199) {
                if (a2 != 499) {
                    if (a2 != 109) {
                        if (a2 != 110) {
                            aVar.a = eh.BIND_XMPP_ERR;
                        } else {
                            aVar.a = eh.BIND_TCP_BROKEN_PIPE;
                        }
                    } else {
                        aVar.a = eh.BIND_TCP_CONNRESET;
                    }
                } else {
                    aVar.a = eh.BIND_BOSH_ERR;
                    if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                        aVar.a = eh.BIND_BOSH_ITEM_NOT_FOUND;
                    }
                }
            } else {
                aVar.a = eh.BIND_TCP_ERR;
            }
        } else {
            aVar.a = eh.BIND_TCP_READ_TIMEOUT;
        }
        eh ehVar = aVar.a;
        if (ehVar == eh.BIND_TCP_ERR || ehVar == eh.BIND_XMPP_ERR || ehVar == eh.BIND_BOSH_ERR) {
            aVar.f381a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    static a d(Exception exc) {
        m384a(exc);
        boolean z = exc instanceof fh;
        Exception exc2 = exc;
        if (z) {
            fh fhVar = (fh) exc;
            exc2 = exc;
            if (fhVar.a() != null) {
                exc2 = fhVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fb.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 105) {
            if (a2 != 199) {
                if (a2 != 499) {
                    if (a2 != 109) {
                        if (a2 != 110) {
                            aVar.a = eh.CHANNEL_XMPPEXCEPTION;
                        } else {
                            aVar.a = eh.CHANNEL_TCP_BROKEN_PIPE;
                        }
                    } else {
                        aVar.a = eh.CHANNEL_TCP_CONNRESET;
                    }
                } else {
                    aVar.a = eh.CHANNEL_BOSH_EXCEPTION;
                    if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                        aVar.a = eh.CHANNEL_BOSH_ITEMNOTFIND;
                    }
                }
            } else {
                aVar.a = eh.CHANNEL_TCP_ERR;
            }
        } else {
            aVar.a = eh.CHANNEL_TCP_READTIMEOUT;
        }
        eh ehVar = aVar.a;
        if (ehVar == eh.CHANNEL_TCP_ERR || ehVar == eh.CHANNEL_XMPPEXCEPTION || ehVar == eh.CHANNEL_BOSH_EXCEPTION) {
            aVar.f381a = str;
        }
        return aVar;
    }
}
