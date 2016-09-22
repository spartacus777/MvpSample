package kizema.anton.mvpsample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import kizema.anton.mvpsample.model.StationModel;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BaseViewHolder> {

    private List<StationModel> stationList;

    public MainAdapter(List<StationModel> stationList) {
        this.stationList = stationList;
        notifyDataSetChanged();
    }


    public MainAdapter() {}

    public void setData(List<StationModel> busModels){
        this.stationList = busModels;
        notifyDataSetChanged();
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle, tvId;

        public BaseViewHolder(View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView;
        }
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = new TextView(parent.getContext());
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        p.addRule(RelativeLayout.CENTER_HORIZONTAL);
        tv.setLayoutParams(p);
//        tv.setPadding(UIHelper.getPixel(60), UIHelper.getPixel(20), UIHelper.getPixel(60), UIHelper.getPixel(20));
        tv.setGravity(Gravity.CENTER);

        return new BaseViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {

        StationModel model = stationList.get(position);
        holder.tvTitle.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        if (stationList == null) {
            return 0;
        }

        return stationList.size();
    }

}
