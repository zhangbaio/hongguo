package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = j3.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum NovelTopicType {
    Top(1),
    Announcement(2),
    Activity(3),
    Recruit(4),
    Official(5),
    List(6),
    Interview(7),
    Topic(8),
    UgcTopic(9),
    InBookTopic(10),
    Celebrity(11),
    Author(12),
    AuthorReward(13),
    AuthorSpeak(14),
    AuthorReferralTraffic(15),
    TagTopic(16),
    AuthorNewBookPreheat(17),
    ImageActivityBanner(18),
    StoryQuestion(19),
    ForumDiscussion(20),
    Fm(100),
    FizzoAuthorSpeak(201);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610431);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NovelTopicType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) NovelTopicType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610430);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.NovelTopicType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return j3.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    NovelTopicType(int i) {
        this.value = i;
    }
}
