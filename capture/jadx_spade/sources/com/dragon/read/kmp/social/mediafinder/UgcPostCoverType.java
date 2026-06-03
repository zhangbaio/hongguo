package com.dragon.read.kmp.social.mediafinder;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class UgcPostCoverType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UgcPostCoverType[] $VALUES;
    public static final UgcPostCoverType AIImage;
    public static final UgcPostCoverType AIVideo;
    public static final a Companion;
    public static final UgcPostCoverType Default;
    public static final UgcPostCoverType LocalPicture;
    public static final UgcPostCoverType LocalVideo;
    public static final UgcPostCoverType TemplateServerFallBack;
    public static final UgcPostCoverType TextTemplateAIImage;
    public static final UgcPostCoverType TextTemplateAITextImage;
    public static final UgcPostCoverType TextTemplateClient;
    private final int value;

    private static final /* synthetic */ UgcPostCoverType[] $values() {
        return new UgcPostCoverType[]{Default, TextTemplateClient, TextTemplateAITextImage, TextTemplateAIImage, TemplateServerFallBack, LocalPicture, AIImage, LocalVideo, AIVideo};
    }

    public static EnumEntries<UgcPostCoverType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static UgcPostCoverType[] values() {
        return (UgcPostCoverType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609112);
        Default = new UgcPostCoverType("Default", 0, 0);
        TextTemplateClient = new UgcPostCoverType("TextTemplateClient", 1, 1);
        TextTemplateAITextImage = new UgcPostCoverType("TextTemplateAITextImage", 2, 2);
        TextTemplateAIImage = new UgcPostCoverType("TextTemplateAIImage", 3, 3);
        TemplateServerFallBack = new UgcPostCoverType("TemplateServerFallBack", 4, 4);
        LocalPicture = new UgcPostCoverType("LocalPicture", 5, 5);
        AIImage = new UgcPostCoverType("AIImage", 6, 6);
        LocalVideo = new UgcPostCoverType("LocalVideo", 7, 7);
        AIVideo = new UgcPostCoverType("AIVideo", 8, 8);
        UgcPostCoverType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static UgcPostCoverType valueOf(String str) {
        return (UgcPostCoverType) Enum.valueOf(UgcPostCoverType.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609113);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UgcPostCoverType a(Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it2 = UgcPostCoverType.getEntries().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    int value = ((UgcPostCoverType) obj).getValue();
                    if (num != null && value == num.intValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (UgcPostCoverType) obj;
        }
    }

    private UgcPostCoverType(String str, int i, int i2) {
        this.value = i2;
    }
}
