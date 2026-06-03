package kotlin.collections.builders;

import com.bytedance.covode.number.Covode;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SerializedCollection implements Externalizable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private Collection<?> collection;
    private final int tag;

    public static final class a {
        static {
            Covode.recordClassIndex(658249);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658248);
        Companion = new a(null);
    }

    private final Object readResolve() {
        return this.collection;
    }

    public SerializedCollection() {
        this(CollectionsKt__CollectionsKt.emptyList(), 0);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it2 = this.collection.iterator();
        while (it2.hasNext()) {
            output.writeObject(it2.next());
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        Set build;
        Set createSetBuilder;
        Set build2;
        Intrinsics.checkNotNullParameter(input, "input");
        byte readByte = input.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                int i2 = 0;
                if (i != 0) {
                    if (i == 1) {
                        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder(readInt);
                        while (i2 < readInt) {
                            createSetBuilder.add(input.readObject());
                            i2++;
                        }
                        build2 = SetsKt__SetsJVMKt.build(createSetBuilder);
                        build = build2;
                    } else {
                        throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
                    }
                } else {
                    List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(readInt);
                    while (i2 < readInt) {
                        createListBuilder.add(input.readObject());
                        i2++;
                    }
                    build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
                }
                this.collection = build;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    public SerializedCollection(Collection<?> collection, int i) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = i;
    }
}
