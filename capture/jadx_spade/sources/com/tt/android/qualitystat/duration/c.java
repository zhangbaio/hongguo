package com.tt.android.qualitystat.duration;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.util.KotlinExtKt;
import kotlin.jvm.internal.Intrinsics;
import tj6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public final EventType a;
    public final sj6.b b;
    public final g c;
    public final int d;
    public EventStatus e;
    public final long f;
    public final int g;

    static {
        Covode.recordClassIndex(654089);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c)) {
                    if ((this.d == cVar.d) && Intrinsics.areEqual(this.e, cVar.e)) {
                        if (this.f == cVar.f) {
                            if (this.g == cVar.g) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        EventType eventType = this.a;
        int hashCode = (eventType != null ? eventType.hashCode() : 0) * 31;
        sj6.b bVar = this.b;
        int hashCode2 = (hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
        g gVar = this.c;
        int hashCode3 = (((hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31) + this.d) * 31;
        EventStatus eventStatus = this.e;
        int hashCode4 = (hashCode3 + (eventStatus != null ? eventStatus.hashCode() : 0)) * 31;
        long j = this.f;
        return ((hashCode4 + ((int) (j ^ (j >>> 32)))) * 31) + this.g;
    }

    public final EventType getType() {
        return this.a;
    }

    public String toString() {
        return "UserTimeEvent(index=" + this.d + ", type=" + this.a + ", scene=" + this.b.getScene() + ", status=" + this.e + ", param=" + this.c + ", ts=" + KotlinExtKt.c(Long.valueOf(this.f)) + ')';
    }

    public final void a(EventStatus eventStatus) {
        this.e = eventStatus;
    }

    public c(EventType eventType, sj6.b bVar, g gVar, int i, EventStatus eventStatus, long j, int i2) {
        this.a = eventType;
        this.b = bVar;
        this.c = gVar;
        this.d = i;
        this.e = eventStatus;
        this.f = j;
        this.g = i2;
    }
}
