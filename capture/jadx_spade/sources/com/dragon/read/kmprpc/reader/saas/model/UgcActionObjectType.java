package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = l7.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcActionObjectType {
    User(1),
    Comment(2),
    Topic(3),
    Post(4),
    Forum(5),
    Item(6),
    DouyinVideo(7),
    Reply(8),
    DouyinUser(9),
    Book(10),
    Category(11),
    UgcVideo(12),
    Author(13),
    BookEndForum(14),
    MaterialVideo(15),
    VideoSeriesPost(16),
    AdvertiseCreative(17),
    MissingVideo(18),
    WishVideo(19),
    FamousScene(20),
    Danmaku(21);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610973);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UgcActionObjectType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UgcActionObjectType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610972);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UgcActionObjectType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return l7.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UgcActionObjectType(int i) {
        this.value = i;
    }
}
