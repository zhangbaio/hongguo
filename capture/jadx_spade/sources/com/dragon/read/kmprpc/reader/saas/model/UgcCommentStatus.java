package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = p7.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentStatus {
    CommentStatus_Unknonw(-1),
    CommentStatus_Delete(0),
    CommentStatus_AllVisible(1),
    CommentStatus_SelfVisible(2),
    CommentStatus_FriendVisible(3),
    CommentStatus_Publish(4),
    CommentStatus_Star(5),
    CommentStatus_UnProcessed(7),
    CommentStatus_PartVisible(8),
    CommentStatus_Draft(9);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610987);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UgcCommentStatus> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UgcCommentStatus.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610986);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UgcCommentStatus$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return p7.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UgcCommentStatus(int i) {
        this.value = i;
    }
}
