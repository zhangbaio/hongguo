package cm6;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.IncapableCause;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.widget.CheckView;
import com.zhihu.matisse.internal.ui.widget.MediaGrid;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends cm6.d<RecyclerView.ViewHolder> implements MediaGrid.a {
    private final bm6.c f;
    private final Drawable g;
    private com.zhihu.matisse.internal.entity.a h;
    public c i;
    public e j;
    private RecyclerView k;
    private int l;

    public interface c {
        void onUpdate();
    }

    public interface e {
        void Sb(Album album, Item item, int i);
    }

    public interface f {
        void capture();
    }

    static {
        Covode.recordClassIndex(656137);
    }

    private void M3() {
        notifyDataSetChanged();
        c cVar = this.i;
        if (cVar != null) {
            cVar.onUpdate();
        }
    }

    private static class b extends RecyclerView.ViewHolder {
        private TextView d;

        static {
            Covode.recordClassIndex(656138);
        }

        b(View view) {
            super(view);
            this.d = (TextView) view.findViewById(2131820795);
        }
    }

    private static class d extends RecyclerView.ViewHolder {
        private MediaGrid d;

        static {
            Covode.recordClassIndex(656140);
        }

        d(View view) {
            super(view);
            this.d = (MediaGrid) view;
        }
    }

    /* renamed from: cm6.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0012a implements View.OnClickListener {
        ViewOnClickListenerC0012a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ClickAgent.onClick(view);
            if (view.getContext() instanceof f) {
                ((f) view.getContext()).capture();
            }
        }
    }

    private int L3(Context context) {
        if (this.l == 0) {
            int spanCount = this.k.getLayoutManager().getSpanCount();
            int dimensionPixelSize = (context.getResources().getDisplayMetrics().widthPixels - (context.getResources().getDimensionPixelSize(2131493605) * (spanCount - 1))) / spanCount;
            this.l = dimensionPixelSize;
            this.l = (int) (dimensionPixelSize * this.h.n);
        }
        return this.l;
    }

    @Override // cm6.d
    public int F3(int i, Cursor cursor) {
        if (Item.valueOf(cursor).isCapture()) {
            return 1;
        }
        return 2;
    }

    private boolean K3(Context context, Item item) {
        fm6.d dVar;
        IncapableCause h = this.f.h(item);
        com.zhihu.matisse.internal.entity.a aVar = this.h;
        if (aVar == null) {
            dVar = null;
        } else {
            dVar = aVar.q;
        }
        IncapableCause.a(context, h, dVar);
        if (h == null) {
            return true;
        }
        return false;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(2131040015, viewGroup, false));
            ((RecyclerView.ViewHolder) bVar).itemView.setOnClickListener(new ViewOnClickListenerC0012a());
            return bVar;
        }
        if (i == 2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(2131039899, viewGroup, false));
        }
        return null;
    }

    private void N3(Item item, MediaGrid mediaGrid) {
        if (this.h.f) {
            int d2 = this.f.d(item);
            if (d2 > 0) {
                mediaGrid.setCheckEnabled(true);
                mediaGrid.setCheckedNum(d2);
                return;
            } else if (this.f.j()) {
                mediaGrid.setCheckEnabled(false);
                mediaGrid.setCheckedNum(Integer.MIN_VALUE);
                return;
            } else {
                mediaGrid.setCheckEnabled(true);
                mediaGrid.setCheckedNum(d2);
                return;
            }
        }
        if (this.f.i(item)) {
            mediaGrid.setCheckEnabled(true);
            mediaGrid.setChecked(true);
        } else if (this.f.j()) {
            mediaGrid.setCheckEnabled(false);
            mediaGrid.setChecked(false);
        } else {
            mediaGrid.setCheckEnabled(true);
            mediaGrid.setChecked(false);
        }
    }

    @Override // cm6.d
    protected void I3(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        Drawable.ConstantState constantState;
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            Drawable[] compoundDrawables = bVar.d.getCompoundDrawables();
            TypedArray obtainStyledAttributes = viewHolder.itemView.getContext().getTheme().obtainStyledAttributes(new int[]{2130772941});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            for (int i = 0; i < compoundDrawables.length; i++) {
                Drawable drawable = compoundDrawables[i];
                if (drawable != null && (constantState = drawable.getConstantState()) != null) {
                    Drawable mutate = constantState.newDrawable().mutate();
                    mutate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    mutate.setBounds(drawable.getBounds());
                    compoundDrawables[i] = mutate;
                }
            }
            bVar.d.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return;
        }
        if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            Item valueOf = Item.valueOf(cursor);
            dVar.d.g = new MediaGrid.b(L3(dVar.d.getContext()), this.g, this.h.f, viewHolder);
            dVar.d.a(valueOf);
            dVar.d.setOnMediaGridClickListener(this);
            N3(valueOf, dVar.d);
        }
    }

    @Override // com.zhihu.matisse.internal.ui.widget.MediaGrid.a
    public void Q(ImageView imageView, Item item, RecyclerView.ViewHolder viewHolder) {
        e eVar = this.j;
        if (eVar != null) {
            eVar.Sb(null, item, viewHolder.getAdapterPosition());
        }
    }

    public a(Context context, bm6.c cVar, RecyclerView recyclerView) {
        super(null);
        this.h = com.zhihu.matisse.internal.entity.a.b();
        this.f = cVar;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{2130773620});
        this.g = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.k = recyclerView;
    }

    @Override // com.zhihu.matisse.internal.ui.widget.MediaGrid.a
    public void r3(CheckView checkView, Item item, RecyclerView.ViewHolder viewHolder) {
        if (this.h.f) {
            if (this.f.d(item) == Integer.MIN_VALUE) {
                if (K3(viewHolder.itemView.getContext(), item)) {
                    this.f.a(item);
                    M3();
                    return;
                }
                return;
            }
            this.f.o(item);
            M3();
            return;
        }
        if (this.f.i(item)) {
            this.f.o(item);
            M3();
        } else if (K3(viewHolder.itemView.getContext(), item)) {
            this.f.a(item);
            M3();
        }
    }
}
