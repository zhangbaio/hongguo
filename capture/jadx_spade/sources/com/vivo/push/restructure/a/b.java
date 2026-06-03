package com.vivo.push.restructure.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements a {
    private Intent a;
    private com.vivo.push.restructure.request.a.a c;
    private InsideNotificationItem e;
    private UnvarnishedMessage f;
    private String b = "";
    private String d = "";

    static {
        Covode.recordClassIndex(655121);
    }

    @Override // com.vivo.push.restructure.a.a
    public final Intent b() {
        return this.a;
    }

    private boolean n() {
        if (j() == 4) {
            return true;
        }
        return false;
    }

    private boolean o() {
        if (j() == 3) {
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final long d() {
        Intent intent = this.a;
        if (intent == null) {
            return 0L;
        }
        return intent.getLongExtra("ipc_start_time", 0L);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean e() {
        Intent intent = this.a;
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("core_support_monitor", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean k() {
        if (j() == 5) {
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String a() {
        long j;
        Bundle extras;
        Intent intent = this.a;
        if (intent != null && (extras = intent.getExtras()) != null) {
            j = extras.getLong("notify_id", 0L);
        } else {
            j = 0;
        }
        if (j != 0) {
            return String.valueOf(j);
        }
        return "";
    }

    @Override // com.vivo.push.restructure.a.a
    public final String c() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = this.a.getStringExtra("req_id");
        }
        return this.b;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean f() {
        Bundle extras;
        Intent intent = this.a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean g() {
        com.vivo.push.restructure.request.a.a h = h();
        if (h != null && h.a() == 2018) {
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String i() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = this.a.getStringExtra("content");
        }
        return this.d;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int j() {
        Intent intent = this.a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            return this.a.getIntExtra("method", -1);
        }
        return intExtra;
    }

    @Override // com.vivo.push.restructure.a.a
    public final com.vivo.push.restructure.request.a.a h() {
        String stringExtra;
        com.vivo.push.restructure.request.a.a.a aVar;
        if (this.c == null && (stringExtra = this.a.getStringExtra("cf_content")) != null) {
            try {
                aVar = new com.vivo.push.restructure.request.a.a.a(stringExtra);
            } catch (JSONException unused) {
                aVar = null;
            }
            if (aVar != null) {
                this.c = (com.vivo.push.restructure.request.a.a) com.vivo.push.restructure.request.a.a.a.a(aVar);
            }
        }
        return this.c;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int l() {
        if (this.a == null) {
            return 0;
        }
        if (n() && p() != null) {
            return p().getTargetType();
        }
        if (!o() || q() == null) {
            return 0;
        }
        return q().getTargetType();
    }

    @Override // com.vivo.push.restructure.a.a
    public final String m() {
        if (this.a == null) {
            return "";
        }
        if (n() && p() != null) {
            return p().getTargetContent();
        }
        if (!o() || q() == null) {
            return "";
        }
        return q().getTragetContent();
    }

    private InsideNotificationItem p() {
        Exception e;
        InsideNotificationItem insideNotificationItem;
        String stringExtra;
        InsideNotificationItem insideNotificationItem2 = this.e;
        if (insideNotificationItem2 != null) {
            return insideNotificationItem2;
        }
        Intent intent = this.a;
        InsideNotificationItem insideNotificationItem3 = null;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("notification_v1");
            } catch (Exception e2) {
                e = e2;
                insideNotificationItem = null;
            }
            if (stringExtra != null) {
                insideNotificationItem = u.a(stringExtra);
                if (insideNotificationItem != null) {
                    try {
                        insideNotificationItem.setMsgId(Long.parseLong(a()));
                    } catch (Exception e3) {
                        e = e3;
                        t.a("ReceivedMessageImpl", "getNotificationMessage " + e.getMessage());
                        insideNotificationItem3 = insideNotificationItem;
                        this.e = insideNotificationItem3;
                        return insideNotificationItem3;
                    }
                }
                insideNotificationItem3 = insideNotificationItem;
            }
        }
        this.e = insideNotificationItem3;
        return insideNotificationItem3;
    }

    private UnvarnishedMessage q() {
        UnvarnishedMessage unvarnishedMessage = this.f;
        if (unvarnishedMessage != null) {
            return unvarnishedMessage;
        }
        Intent intent = this.a;
        UnvarnishedMessage unvarnishedMessage2 = null;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("msg_v1");
                if (!TextUtils.isEmpty(stringExtra)) {
                    UnvarnishedMessage unvarnishedMessage3 = new UnvarnishedMessage(stringExtra);
                    try {
                        unvarnishedMessage3.setMsgId(Long.parseLong(a()));
                        unvarnishedMessage2 = unvarnishedMessage3;
                    } catch (Exception e) {
                        e = e;
                        unvarnishedMessage2 = unvarnishedMessage3;
                        t.a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
                        this.f = unvarnishedMessage2;
                        return unvarnishedMessage2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        this.f = unvarnishedMessage2;
        return unvarnishedMessage2;
    }

    public b(Intent intent) {
        this.a = intent;
    }
}
