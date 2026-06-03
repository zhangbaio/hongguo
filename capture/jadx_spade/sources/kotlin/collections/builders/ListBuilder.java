package kotlin.collections.builders;

import com.bytedance.covode.number.Covode;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    private static final a Companion;
    private static final ListBuilder Empty;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        static {
            Covode.recordClassIndex(658233);
        }

        private static final class a<E> implements ListIterator<E>, KMutableListIterator {
            private final BuilderSubList<E> a;
            private int b;
            private int c;
            private int d;

            static {
                Covode.recordClassIndex(658234);
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.b;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                if (this.b > 0) {
                    return true;
                }
                return false;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                if (this.b < ((BuilderSubList) this.a).length) {
                    return true;
                }
                return false;
            }

            private final void c() {
                if (((AbstractList) ((BuilderSubList) this.a).root).modCount == this.d) {
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                c();
                if (this.b < ((BuilderSubList) this.a).length) {
                    int i = this.b;
                    this.b = i + 1;
                    this.c = i;
                    return (E) ((BuilderSubList) this.a).backing[((BuilderSubList) this.a).offset + this.c];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public E previous() {
                c();
                int i = this.b;
                if (i > 0) {
                    int i2 = i - 1;
                    this.b = i2;
                    this.c = i2;
                    return (E) ((BuilderSubList) this.a).backing[((BuilderSubList) this.a).offset + this.c];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                boolean z;
                c();
                int i = this.c;
                if (i != -1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.a.remove(i);
                    this.b = this.c;
                    this.c = -1;
                    this.d = ((AbstractList) this.a).modCount;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }

            @Override // java.util.ListIterator
            public void add(E e) {
                c();
                BuilderSubList<E> builderSubList = this.a;
                int i = this.b;
                this.b = i + 1;
                builderSubList.add(i, e);
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator
            public void set(E e) {
                boolean z;
                c();
                int i = this.c;
                if (i != -1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.a.set(i, e);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }

            public a(BuilderSubList<E> list, int i) {
                Intrinsics.checkNotNullParameter(list, "list");
                this.a = list;
                this.b = i;
                this.c = -1;
                this.d = ((AbstractList) list).modCount;
            }
        }

        private final boolean isReadOnly() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        private final void registerModification() {
            ((AbstractList) this).modCount++;
        }

        @Override // kotlin.collections.AbstractMutableList
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        private final void checkIsMutable() {
            if (!isReadOnly()) {
            } else {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i;
            checkForComodification();
            i = kotlin.collections.builders.b.i(this.backing, this.offset, this.length);
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            if (this.length == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] eArr = this.backing;
            int i = this.offset;
            return ArraysKt___ArraysJvmKt.copyOfRange(eArr, i, this.length + i);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String j;
            checkForComodification();
            j = kotlin.collections.builders.b.j(this.backing, this.offset, this.length, this);
            return j;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.root).modCount == ((AbstractList) this).modCount) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        private final Object writeReplace() {
            if (isReadOnly()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        private final boolean contentEquals(List<?> list) {
            boolean h;
            h = kotlin.collections.builders.b.h(this.backing, this.offset, this.length, list);
            return h;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E e) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, e);
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.c(i, this.length);
            return new a(this, i);
        }

        private final E removeAtInternal(int i) {
            E e;
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                e = builderSubList.removeAtInternal(i);
            } else {
                e = (E) this.root.removeAtInternal(i);
            }
            this.length--;
            return e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            int size = elements.size();
            addAllInternal(this.offset + this.length, elements, size);
            if (size > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            checkForComodification();
            if (obj != this && (!(obj instanceof List) || !contentEquals((List) obj))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.b(i, this.length);
            return this.backing[this.offset + i];
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            checkForComodification();
            for (int i = 0; i < this.length; i++) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            checkForComodification();
            for (int i = this.length - 1; i >= 0; i--) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            checkIsMutable();
            checkForComodification();
            int indexOf = indexOf(obj);
            if (indexOf >= 0) {
                remove(indexOf);
            }
            if (indexOf >= 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, elements, false) <= 0) {
                return false;
            }
            return true;
        }

        @Override // kotlin.collections.AbstractMutableList
        public E removeAt(int i) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.b(i, this.length);
            return removeAtInternal(this.offset + i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            checkForComodification();
            int length = array.length;
            int i = this.length;
            if (length < i) {
                E[] eArr = this.backing;
                int i2 = this.offset;
                T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, array.getClass());
                Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
                return tArr;
            }
            E[] eArr2 = this.backing;
            int i3 = this.offset;
            ArraysKt___ArraysJvmKt.copyInto(eArr2, array, 0, i3, i + i3);
            return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(this.length, array);
        }

        private final void addAtInternal(int i, E e) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAtInternal(i, e);
            } else {
                this.root.addAtInternal(i, e);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        private final void removeRangeInternal(int i, int i2) {
            if (i2 > 0) {
                registerModification();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.removeRangeInternal(i, i2);
            } else {
                this.root.removeRangeInternal(i, i2);
            }
            this.length -= i2;
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.c(i, this.length);
            addAtInternal(this.offset + i, e);
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.b(i, this.length);
            E[] eArr = this.backing;
            int i2 = this.offset;
            E e2 = eArr[i2 + i];
            eArr[i2 + i] = e;
            return e2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i, int i2) {
            kotlin.collections.AbstractList.Companion.d(i, i2, this.length);
            return new BuilderSubList(this.backing, this.offset + i, i2 - i, this, this.root);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.c(i, this.length);
            int size = elements.size();
            addAllInternal(this.offset + i, elements, size);
            if (size > 0) {
                return true;
            }
            return false;
        }

        private final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAllInternal(i, collection, i2);
            } else {
                this.root.addAllInternal(i, collection, i2);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += i2;
        }

        private final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
            int retainOrRemoveAllInternal;
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                retainOrRemoveAllInternal = builderSubList.retainOrRemoveAllInternal(i, i2, collection, z);
            } else {
                retainOrRemoveAllInternal = this.root.retainOrRemoveAllInternal(i, i2, collection, z);
            }
            if (retainOrRemoveAllInternal > 0) {
                registerModification();
            }
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }

        public BuilderSubList(E[] backing, int i, int i2, BuilderSubList<E> builderSubList, ListBuilder<E> root) {
            Intrinsics.checkNotNullParameter(backing, "backing");
            Intrinsics.checkNotNullParameter(root, "root");
            this.backing = backing;
            this.offset = i;
            this.length = i2;
            this.parent = builderSubList;
            this.root = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }
    }

    private static final class a {
        static {
            Covode.recordClassIndex(658235);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    private static final class b<E> implements ListIterator<E>, KMutableListIterator {
        private final ListBuilder<E> a;
        private int b;
        private int c;
        private int d;

        static {
            Covode.recordClassIndex(658236);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.b > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.b < ((ListBuilder) this.a).length) {
                return true;
            }
            return false;
        }

        private final void c() {
            if (((AbstractList) this.a).modCount == this.d) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public E previous() {
            c();
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                return (E) ((ListBuilder) this.a).backing[this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            c();
            if (this.b < ((ListBuilder) this.a).length) {
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return (E) ((ListBuilder) this.a).backing[this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            boolean z;
            c();
            int i = this.c;
            if (i != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.a.remove(i);
                this.b = this.c;
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            c();
            ListBuilder<E> listBuilder = this.a;
            int i = this.b;
            this.b = i + 1;
            listBuilder.add(i, e);
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            boolean z;
            c();
            int i = this.c;
            if (i != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.a.set(i, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }

        public b(ListBuilder<E> list, int i) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.a = list;
            this.b = i;
            this.c = -1;
            this.d = ((AbstractList) list).modCount;
        }
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    private final void checkIsMutable() {
        if (!this.isReadOnly) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length > 0) {
            return this;
        }
        return Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i;
        i = kotlin.collections.builders.b.i(this.backing, 0, this.length);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt___ArraysJvmKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String j;
        j = kotlin.collections.builders.b.j(this.backing, 0, this.length, this);
        return j;
    }

    static {
        Covode.recordClassIndex(658232);
        Companion = new a(null);
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacityInternal(this.length + i);
    }

    public ListBuilder(int i) {
        this.backing = (E[]) kotlin.collections.builders.b.d(i);
    }

    private final boolean contentEquals(List<?> list) {
        boolean h;
        h = kotlin.collections.builders.b.h(this.backing, 0, this.length, list);
        return h;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        kotlin.collections.AbstractList.Companion.b(i, this.length);
        return this.backing[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        kotlin.collections.AbstractList.Companion.c(i, this.length);
        return new b(this, i);
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.b(i, this.length);
        return removeAtInternal(i);
    }

    private final void ensureCapacityInternal(int i) {
        if (i >= 0) {
            E[] eArr = this.backing;
            if (i > eArr.length) {
                this.backing = (E[]) kotlin.collections.builders.b.e(this.backing, kotlin.collections.AbstractList.Companion.e(eArr.length, i));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E removeAtInternal(int i) {
        registerModification();
        E[] eArr = this.backing;
        E e = eArr[i];
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i, i + 1, this.length);
        kotlin.collections.builders.b.f(this.backing, this.length - 1);
        this.length--;
        return e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        checkIsMutable();
        addAtInternal(this.length, e);
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof List) || !contentEquals((List) obj))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.backing[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.backing[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, elements, true) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.length, elements, size);
        if (size > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i = this.length;
        if (length < i) {
            T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i, array.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
            return tArr;
        }
        ArraysKt___ArraysJvmKt.copyInto(this.backing, array, 0, 0, i);
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(this.length, array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAtInternal(int i, E e) {
        registerModification();
        insertAtInternal(i, 1);
        this.backing[i] = e;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.c(i, this.length);
        addAtInternal(i, e);
    }

    private final void insertAtInternal(int i, int i2) {
        ensureExtraCapacity(i2);
        E[] eArr = this.backing;
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i + i2, i, this.length);
        this.length += i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeRangeInternal(int i, int i2) {
        if (i2 > 0) {
            registerModification();
        }
        E[] eArr = this.backing;
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i, i + i2, this.length);
        E[] eArr2 = this.backing;
        int i3 = this.length;
        kotlin.collections.builders.b.g(eArr2, i3 - i2, i3);
        this.length -= i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.c(i, this.length);
        int size = elements.size();
        addAllInternal(i, elements, size);
        if (size > 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.b(i, this.length);
        E[] eArr = this.backing;
        E e2 = eArr[i];
        eArr[i] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        kotlin.collections.AbstractList.Companion.d(i, i2, this.length);
        return new BuilderSubList(this.backing, i, i2 - i, null, this);
    }

    public /* synthetic */ ListBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
        registerModification();
        insertAtInternal(i, i2);
        Iterator<? extends E> it2 = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.backing[i + i3] = it2.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.backing[i5]) == z) {
                E[] eArr = this.backing;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.backing;
        ArraysKt___ArraysJvmKt.copyInto(eArr2, eArr2, i + i4, i2 + i, this.length);
        E[] eArr3 = this.backing;
        int i7 = this.length;
        kotlin.collections.builders.b.g(eArr3, i7 - i6, i7);
        if (i6 > 0) {
            registerModification();
        }
        this.length -= i6;
        return i6;
    }
}
