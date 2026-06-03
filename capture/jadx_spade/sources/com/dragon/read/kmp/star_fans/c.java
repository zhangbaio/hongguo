package com.dragon.read.kmp.star_fans;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final b Companion;
    private static final Lazy<KSerializer<Object>>[] m;
    public final long a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final long g;
    public final String h;
    public final String i;
    public final String j;
    public final CommunityStartTaskStatus k;
    public final int l;

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return CommunityStartTaskStatus.Companion.serializer();
    }

    public final c d(long j, String cnTaskName, String taskId, boolean z, String taskKey, String taskType, long j2, String actorUid, String followTime, String rank, CommunityStartTaskStatus taskStatus, int i) {
        Intrinsics.checkNotNullParameter(cnTaskName, "cnTaskName");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(actorUid, "actorUid");
        Intrinsics.checkNotNullParameter(followTime, "followTime");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(taskStatus, "taskStatus");
        return new c(j, cnTaskName, taskId, z, taskKey, taskType, j2, actorUid, followTime, rank, taskStatus, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c) && this.d == cVar.d && Intrinsics.areEqual(this.e, cVar.e) && Intrinsics.areEqual(this.f, cVar.f) && this.g == cVar.g && Intrinsics.areEqual(this.h, cVar.h) && Intrinsics.areEqual(this.i, cVar.i) && Intrinsics.areEqual(this.j, cVar.j) && this.k == cVar.k && this.l == cVar.l;
    }

    public int hashCode() {
        return (((((((((((((((((((((j.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + m.a(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + j.a(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l;
    }

    public String toString() {
        return "CommunityStartTaskModel(amount=" + this.a + ", cnTaskName=" + this.b + ", taskId=" + this.c + ", isRankingList=" + this.d + ", taskKey=" + this.e + ", taskType=" + this.f + ", expireTime=" + this.g + ", actorUid=" + this.h + ", followTime=" + this.i + ", rank=" + this.j + ", taskStatus=" + this.k + ", retryCount=" + this.l + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609147);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<c> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<c> {
        public static final a a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        private a() {
        }

        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final KSerializer<?>[] b() {
            Lazy[] lazyArr = c.m;
            g1 g1Var = g1.a;
            v2 v2Var = v2.a;
            return new KSerializer[]{g1Var, v2Var, v2Var, kotlinx.serialization.internal.i.a, v2Var, v2Var, g1Var, v2Var, v2Var, v2Var, lazyArr[10].getValue(), v0.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.star_fans.CommunityStartTaskModel", aVar, 12);
            g2Var.g("amount", false);
            g2Var.g("cnTaskName", false);
            g2Var.g("taskId", false);
            g2Var.g("isRankingList", false);
            g2Var.g("taskKey", false);
            g2Var.g("taskType", false);
            g2Var.g("expireTime", false);
            g2Var.g("actorUid", false);
            g2Var.g("followTime", false);
            g2Var.g("rank", false);
            g2Var.g("taskStatus", true);
            g2Var.g("retryCount", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final c deserialize(Decoder decoder) {
            int i;
            String str;
            boolean z;
            String str2;
            CommunityStartTaskStatus communityStartTaskStatus;
            int i2;
            long j;
            String str3;
            long j2;
            String str4;
            String str5;
            String str6;
            String str7;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = c.m;
            String str8 = null;
            if (beginStructure.decodeSequentially()) {
                j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
                String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
                String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 5);
                long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 6);
                String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 7);
                String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 8);
                String decodeStringElement7 = beginStructure.decodeStringElement(serialDescriptor, 9);
                communityStartTaskStatus = (CommunityStartTaskStatus) beginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), null);
                i2 = beginStructure.decodeIntElement(serialDescriptor, 11);
                str5 = decodeStringElement7;
                str = decodeStringElement5;
                str4 = decodeStringElement6;
                str7 = decodeStringElement4;
                z = decodeBooleanElement;
                str6 = decodeStringElement3;
                j = decodeLongElement;
                i = 4095;
                str2 = decodeStringElement;
                str3 = decodeStringElement2;
            } else {
                int i3 = 11;
                CommunityStartTaskStatus communityStartTaskStatus2 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                String str12 = null;
                long j3 = 0;
                long j4 = 0;
                i = 0;
                int i4 = 0;
                boolean z2 = false;
                boolean z3 = true;
                String str13 = null;
                String str14 = null;
                while (z3) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            i3 = 11;
                            z3 = false;
                            continue;
                        case 0:
                            j3 = beginStructure.decodeLongElement(serialDescriptor, 0);
                            i |= 1;
                            i3 = 11;
                            continue;
                        case 1:
                            i |= 2;
                            str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                            continue;
                        case 2:
                            str13 = beginStructure.decodeStringElement(serialDescriptor, 2);
                            i |= 4;
                            continue;
                        case 3:
                            z2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                            i |= 8;
                            break;
                        case 4:
                            str14 = beginStructure.decodeStringElement(serialDescriptor, 4);
                            i |= 16;
                            break;
                        case 5:
                            str9 = beginStructure.decodeStringElement(serialDescriptor, 5);
                            i |= 32;
                            break;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            j4 = beginStructure.decodeLongElement(serialDescriptor, 6);
                            i |= 64;
                            break;
                        case 7:
                            str10 = beginStructure.decodeStringElement(serialDescriptor, 7);
                            i |= 128;
                            break;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            str11 = beginStructure.decodeStringElement(serialDescriptor, 8);
                            i |= 256;
                            break;
                        case 9:
                            str12 = beginStructure.decodeStringElement(serialDescriptor, 9);
                            i |= MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                            break;
                        case 10:
                            communityStartTaskStatus2 = (CommunityStartTaskStatus) beginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), communityStartTaskStatus2);
                            i |= 1024;
                            break;
                        case 11:
                            i4 = beginStructure.decodeIntElement(serialDescriptor, i3);
                            i |= 2048;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                str = str10;
                z = z2;
                String str15 = str14;
                str2 = str8;
                long j5 = j4;
                communityStartTaskStatus = communityStartTaskStatus2;
                i2 = i4;
                j = j5;
                String str16 = str9;
                str3 = str13;
                j2 = j3;
                str4 = str11;
                str5 = str12;
                str6 = str15;
                str7 = str16;
            }
            beginStructure.endStructure(serialDescriptor);
            return new c(i, j2, str2, str3, z, str6, str7, j, str, str4, str5, communityStartTaskStatus, i2, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, c value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            c.f(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609146);
        Companion = new b(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.dragon.read.kmp.star_fans.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer b2;
                b2 = c.b();
                return b2;
            }
        });
        m = new Lazy[]{null, null, null, null, null, null, null, null, null, null, lazy, null};
    }

    public static final /* synthetic */ void f(c cVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        Lazy<KSerializer<Object>>[] lazyArr = m;
        boolean z2 = false;
        dVar.encodeLongElement(serialDescriptor, 0, cVar.a);
        dVar.encodeStringElement(serialDescriptor, 1, cVar.b);
        dVar.encodeStringElement(serialDescriptor, 2, cVar.c);
        dVar.encodeBooleanElement(serialDescriptor, 3, cVar.d);
        dVar.encodeStringElement(serialDescriptor, 4, cVar.e);
        dVar.encodeStringElement(serialDescriptor, 5, cVar.f);
        dVar.encodeLongElement(serialDescriptor, 6, cVar.g);
        dVar.encodeStringElement(serialDescriptor, 7, cVar.h);
        dVar.encodeStringElement(serialDescriptor, 8, cVar.i);
        dVar.encodeStringElement(serialDescriptor, 9, cVar.j);
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 10) || cVar.k != CommunityStartTaskStatus.CLAIMED_UNFINISHED) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeSerializableElement(serialDescriptor, 10, lazyArr[10].getValue(), cVar.k);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 11) || cVar.l != 0) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeIntElement(serialDescriptor, 11, cVar.l);
        }
    }

    public c(long j, String cnTaskName, String taskId, boolean z, String taskKey, String taskType, long j2, String actorUid, String followTime, String rank, CommunityStartTaskStatus taskStatus, int i) {
        Intrinsics.checkNotNullParameter(cnTaskName, "cnTaskName");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(actorUid, "actorUid");
        Intrinsics.checkNotNullParameter(followTime, "followTime");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(taskStatus, "taskStatus");
        this.a = j;
        this.b = cnTaskName;
        this.c = taskId;
        this.d = z;
        this.e = taskKey;
        this.f = taskType;
        this.g = j2;
        this.h = actorUid;
        this.i = followTime;
        this.j = rank;
        this.k = taskStatus;
        this.l = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(long r18, java.lang.String r20, java.lang.String r21, boolean r22, java.lang.String r23, java.lang.String r24, long r25, java.lang.String r27, java.lang.String r28, java.lang.String r29, com.dragon.read.kmp.star_fans.CommunityStartTaskStatus r30, int r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r17 = this;
            r0 = r32
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto La
            com.dragon.read.kmp.star_fans.CommunityStartTaskStatus r1 = com.dragon.read.kmp.star_fans.CommunityStartTaskStatus.CLAIMED_UNFINISHED
            r15 = r1
            goto Lc
        La:
            r15 = r30
        Lc:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L14
            r0 = 0
            r16 = 0
            goto L16
        L14:
            r16 = r31
        L16:
            r2 = r17
            r3 = r18
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r12 = r27
            r13 = r28
            r14 = r29
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.star_fans.c.<init>(long, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, com.dragon.read.kmp.star_fans.CommunityStartTaskStatus, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ c(int i, long j, String str, String str2, boolean z, String str3, String str4, long j2, String str5, String str6, String str7, CommunityStartTaskStatus communityStartTaskStatus, int i2, q2 q2Var) {
        CommunityStartTaskStatus communityStartTaskStatus2;
        int i3;
        if (1023 != (i & 1023)) {
            b2.b(i, 1023, a.a.getDescriptor());
        }
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = str3;
        this.f = str4;
        this.g = j2;
        this.h = str5;
        this.i = str6;
        this.j = str7;
        if ((i & 1024) == 0) {
            communityStartTaskStatus2 = CommunityStartTaskStatus.CLAIMED_UNFINISHED;
        } else {
            communityStartTaskStatus2 = communityStartTaskStatus;
        }
        this.k = communityStartTaskStatus2;
        if ((i & 2048) == 0) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        this.l = i3;
    }
}
