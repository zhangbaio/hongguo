package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = k8.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum VideoContentType {
    ShortSeriesPlay(1),
    ScenePlay(2),
    ExpertRecommendBook(3),
    PPTRecommendBook(4),
    Movie(5),
    TelePlay(6),
    ShortPlay(7),
    DropMaterial(1000),
    PUGC(1001),
    UnrealShortPlay(1002),
    Album(1003),
    MotionComic(1004),
    FamousSceneVideo(1005),
    UgcPostVideo(1006),
    UnrealMotionComic(1007);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611144);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VideoContentType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) VideoContentType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(611143);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.VideoContentType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return k8.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    VideoContentType(int i) {
        this.value = i;
    }
}
