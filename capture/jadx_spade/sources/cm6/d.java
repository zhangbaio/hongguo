package cm6;

import android.database.Cursor;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class d<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public Cursor d;
    private int e;

    static {
        Covode.recordClassIndex(656146);
    }

    protected abstract int F3(int i, Cursor cursor);

    protected abstract void I3(VH vh, Cursor cursor);

    public int getItemCount() {
        if (G3(this.d)) {
            return this.d.getCount();
        }
        return 0;
    }

    d(Cursor cursor) {
        setHasStableIds(true);
        J3(cursor);
    }

    private boolean G3(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            return true;
        }
        return false;
    }

    public void J3(Cursor cursor) {
        if (cursor == this.d) {
            return;
        }
        if (cursor != null) {
            this.d = cursor;
            this.e = cursor.getColumnIndexOrThrow("_id");
            notifyDataSetChanged();
        } else {
            notifyItemRangeRemoved(0, getItemCount());
            this.d = null;
            this.e = -1;
        }
    }

    public long getItemId(int i) {
        if (G3(this.d)) {
            if (this.d.moveToPosition(i)) {
                return this.d.getLong(this.e);
            }
            throw new IllegalStateException("Could not move cursor to position " + i + " when trying to get an item id");
        }
        throw new IllegalStateException("Cannot lookup item id when cursor is in invalid state.");
    }

    public int getItemViewType(int i) {
        if (this.d.moveToPosition(i)) {
            return F3(i, this.d);
        }
        throw new IllegalStateException("Could not move cursor to position " + i + " when trying to get item view type.");
    }

    public void onBindViewHolder(VH vh, int i) {
        if (G3(this.d)) {
            if (this.d.moveToPosition(i)) {
                I3(vh, this.d);
                return;
            }
            throw new IllegalStateException("Could not move cursor to position " + i + " when trying to bind view holder");
        }
        throw new IllegalStateException("Cannot bind view holder when cursor is in invalid state.");
    }
}
