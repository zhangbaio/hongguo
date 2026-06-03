package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {

    public static final class a implements b {
        public final int a;

        static {
            Covode.recordClassIndex(608182);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return "FocusTab(tabIndex=" + this.a + ')';
        }

        public a(int i) {
            this.a = i;
        }
    }

    /* renamed from: com.dragon.read.kmp.profile.guestprofile.viewmodel.b$b, reason: collision with other inner class name */
    public static final class C0032b implements b {
        public final String a;

        static {
            Covode.recordClassIndex(608183);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0032b) && Intrinsics.areEqual(this.a, ((C0032b) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ShowStarFansFailToast(errTips=" + this.a + ')';
        }

        public C0032b(String str) {
            this.a = str;
        }
    }

    public static final class c implements b {
        public final String a;
        public final long b;

        static {
            Covode.recordClassIndex(608184);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.a, cVar.a) && this.b == cVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + j.a(this.b);
        }

        public String toString() {
            return "ShowStarFansToast(actorUid=" + this.a + ", sum=" + this.b + ')';
        }

        public c(String actorUid, long j) {
            Intrinsics.checkNotNullParameter(actorUid, "actorUid");
            this.a = actorUid;
            this.b = j;
        }
    }
}
