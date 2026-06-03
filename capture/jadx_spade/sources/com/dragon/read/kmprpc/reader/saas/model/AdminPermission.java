package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = e.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AdminPermission {
    DELETE(1),
    SET_FEATURED(2),
    ADD_ORDINARY_IDEA_TO_OUTSHOW_CANDIDATE(3),
    KICK_OUTSHOW_IDEA(4),
    MUTE(5),
    STATUS_BE_MUTED(50),
    UGC_EditReport(100),
    UGC_ProduceTask(101),
    UGC_ProduceBookForumVideo(102),
    UGC_ProduceBookstoreVideo(103),
    UGC_AddBooklistPicture(104);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609733);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AdminPermission> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) AdminPermission.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609732);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.AdminPermission$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return e.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    AdminPermission(int i) {
        this.value = i;
    }
}
