package personal.john.app;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCustomListAdapter extends ArrayAdapter<MyCustomListData> {
    private static LayoutInflater layoutInflater;
    private static int selectedPosition = -1;
    private Context context;
    
    private static class ViewHolder {
        ImageView imageView;
        TextView textViewHotelName;
        TextView textViewHotelInfo;
        TextView textViewHotelDistance;
        TextView textViewHotelMinCharge;

    }
    
    public MyCustomListAdapter(Context context, int viewResourceId, List<MyCustomListData> objects) {
        super(context, viewResourceId, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View cv = convertView;
        
        // 特定の行(position)のデータを得る
        MyCustomListData item = (MyCustomListData) getItem(position);

        // リスト用のレイアウトを初回のみ作成
        if (cv == null) {
            cv = layoutInflater.inflate(R.layout.result_listitem, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) cv.findViewById(R.id.listImg);
            holder.textViewHotelName = (TextView) cv.findViewById(R.id.listHotelName);
            holder.textViewHotelInfo = (TextView) cv.findViewById(R.id.listHotelInfo);
            holder.textViewHotelDistance = (TextView) cv.findViewById(R.id.listHotelDistance);
            holder.textViewHotelMinCharge = (TextView) cv.findViewById(R.id.listHotelMinCharge);
            cv.setTag(holder);
        } else {
            holder = (ViewHolder) cv.getTag();
        }

        // イメージ画像のセット
        holder.imageView.setImageBitmap(item.getHotelImage());

        // ホテル名のセット
        holder.textViewHotelName.setText(item.getHotelName());

        // ホテル情報のセット
        holder.textViewHotelInfo.setText(item.getHotelInfo());

        // 現在地からホテルまでの距離
        holder.textViewHotelDistance.setText(item.getHotelDistance());

        // ホテルの再安値のセット
        holder.textViewHotelMinCharge.setText(item.getHotelMinCharge());
        
        if (selectedPosition > -1) {
            if (position == selectedPosition) {
                cv.setBackgroundColor(context.getResources().getColor(R.color.purple));
            } else {
                cv.setBackgroundColor(context.getResources().getColor(R.color.white));
            }
        }
        return cv;
    }
    
    public String getHotelName(int position) {
        // 特定の行(position)のデータを得る
        MyCustomListData item = getItem(position);
        return item.getHotelName();
        
    }
    
    public void setSelectedItemPosition(int position) {
        selectedPosition = position;
    }
}
