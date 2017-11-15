package al.helmo.com.natamobile.res;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import al.helmo.com.natamobile.R;

public class MenuBurgerAdapter extends BaseAdapter {

    private Context context;
    private List<ItemSlideMenu> listItem;

    public MenuBurgerAdapter(Context context, List<ItemSlideMenu> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item_menu, null);

        ImageView img = (ImageView)v.findViewById(R.id.imgItem);
        TextView txt = (TextView)v.findViewById(R.id.txtItem);

        ItemSlideMenu item = listItem.get(i);
        txt.setText(item.getTitle());

        return v;
    }
}
