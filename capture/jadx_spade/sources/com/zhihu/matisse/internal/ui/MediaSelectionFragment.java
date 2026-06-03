package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bm6.b;
import bm6.c;
import cm6.a;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import em6.e;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MediaSelectionFragment extends Fragment implements b.a, a.c, a.e {
    private final b a = new b();
    private RecyclerView b;
    private cm6.a c;
    private a d;
    private a.c e;
    private a.e f;

    public interface a {
        c e0();
    }

    static {
        Covode.recordClassIndex(656133);
    }

    @Override // bm6.b.a
    public void i5() {
        this.c.J3(null);
    }

    @Override // cm6.a.c
    public void onUpdate() {
        a.c cVar = this.e;
        if (cVar != null) {
            cVar.onUpdate();
        }
    }

    public void xf() {
        this.c.notifyDataSetChanged();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.d();
    }

    @Override // bm6.b.a
    public void Ea(Cursor cursor) {
        this.c.J3(cursor);
    }

    public static MediaSelectionFragment wf(Album album) {
        MediaSelectionFragment mediaSelectionFragment = new MediaSelectionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_album", album);
        mediaSelectionFragment.setArguments(bundle);
        return mediaSelectionFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.d = (a) context;
            if (context instanceof a.c) {
                this.e = (a.c) context;
            }
            if (context instanceof a.e) {
                this.f = (a.e) context;
                return;
            }
            return;
        }
        throw new IllegalStateException("Context must implement SelectionProvider.");
    }

    public void onActivityCreated(Bundle bundle) {
        int i;
        super.onActivityCreated(bundle);
        Album album = (Album) getArguments().getParcelable("extra_album");
        cm6.a aVar = new cm6.a(getContext(), this.d.e0(), this.b);
        this.c = aVar;
        aVar.i = this;
        aVar.j = this;
        this.b.setHasFixedSize(true);
        com.zhihu.matisse.internal.entity.a b = com.zhihu.matisse.internal.entity.a.b();
        if (b.m > 0) {
            i = e.a(getContext(), b.m);
        } else {
            i = b.l;
        }
        this.b.setLayoutManager(new GridLayoutManager(getContext(), i));
        this.b.addItemDecoration(new dm6.b(i, getResources().getDimensionPixelSize(2131493605), false));
        this.b.setAdapter(this.c);
        this.a.c(getActivity(), this);
        this.a.b(album, b.k);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.b = view.findViewById(2131831173);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131036342, viewGroup, false);
    }

    @Override // cm6.a.e
    public void Sb(Album album, Item item, int i) {
        a.e eVar = this.f;
        if (eVar != null) {
            eVar.Sb((Album) getArguments().getParcelable("extra_album"), item, i);
        }
    }
}
