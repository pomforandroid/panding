package com.panding.main.perfecthttp.adapter;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopeer.itemtouchhelperextension.Extension;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;
import com.panding.main.R;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_hfence_del;
import com.panding.main.perfecthttp.response.Hfence_get;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HFenceSwipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_TYPE_RECYCLER_WIDTH = 1000;
    public static final int ITEM_TYPE_ACTION_WIDTH = 1001;
    public static final int ITEM_TYPE_ACTION_WIDTH_NO_SPRING = 1002;
    public static final int ITEM_TYPE_NO_SWIPE = 1003;


    private List<Hfence_get.AreaBean> area;


    public interface OnItemClickListener {
        void onItemClick(int position, View view, RecyclerView.ViewHolder vh);
    }

    private OnItemClickListener mClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(boolean sucess);
    }

    private OnDeleteClickListener mDeleteListener;

    public void setOnDeleteClickListener(OnDeleteClickListener mDeleteListener){
        this.mDeleteListener = mDeleteListener;

    }

    private String userid;


    private Context mContext;
    private ItemTouchHelperExtension mItemTouchHelperExtension;

    public HFenceSwipeAdapter(Context context, String userid) {
        area = new ArrayList<>();
        mContext = context;
        this.userid = userid;
    }

    public void setDatas(List<Hfence_get.AreaBean> datas) {
        area.clear();
        area.addAll(datas);
    }

    public void updateData(List<Hfence_get.AreaBean> datas) {
        setDatas(datas);
        notifyDataSetChanged();
    }

    public void setItemTouchHelperExtension(ItemTouchHelperExtension itemTouchHelperExtension) {
        mItemTouchHelperExtension = itemTouchHelperExtension;
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.list_item_main, parent, false);
        if (viewType == ITEM_TYPE_ACTION_WIDTH) return new ItemSwipeWithActionWidthViewHolder(view);
        if (viewType == ITEM_TYPE_NO_SWIPE) return new ItemNoSwipeViewHolder(view);
        if (viewType == ITEM_TYPE_RECYCLER_WIDTH) {
            view = getLayoutInflater().inflate(R.layout.list_item_with_single_delete, parent, false);
            return new ItemViewHolderWithRecyclerWidth(view);
        }
        return new ItemSwipeWithActionWidthNoSpringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ItemBaseViewHolder baseViewHolder = (ItemBaseViewHolder) holder;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (mClickListener != null) {
                    mClickListener.onItemClick(position, v, holder);
                }
            }
        });
        baseViewHolder.bind(area.get(position));
      /*  baseViewHolder.mViewContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, "Item Content click: #" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });*/
        if (holder instanceof ItemViewHolderWithRecyclerWidth) {
            ItemViewHolderWithRecyclerWidth viewHolder = (ItemViewHolderWithRecyclerWidth) holder;
            viewHolder.mActionViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doDelete(holder.getAdapterPosition());
                }
            });
        } else if (holder instanceof ItemSwipeWithActionWidthViewHolder) {
            ItemSwipeWithActionWidthViewHolder viewHolder = (ItemSwipeWithActionWidthViewHolder) holder;
           /* viewHolder.mActionViewRefresh.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext, "Refresh Click" + holder.getAdapterPosition()
                                    , Toast.LENGTH_SHORT).show();
                            mItemTouchHelperExtension.closeOpened();
                        }
                    }

            );*/
            viewHolder.mActionViewDelete.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            doDelete(holder.getAdapterPosition());
                        }
                    }

            );
        }
    }

    private void doDelete(final int adapterPosition) {
        String id = area.get(adapterPosition).getId();
        Req_hfence_del req_hfence_del = new Req_hfence_del();
        req_hfence_del.setId(id);
        req_hfence_del.setUserId(userid);

        String param = new Gson().toJson(req_hfence_del);
        PerfectHttp.createService(PandingService.class).hfence_del(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Hfence_get>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mDeleteListener!=null){
                            mDeleteListener.onDeleteClick(false);
                        }
                    }

                    @Override
                    public void onNext(Hfence_get hfence_get) {
                        if(hfence_get.getErrcode()==0){
                            area.remove(adapterPosition);
                            notifyItemRemoved(adapterPosition);
                            if (mDeleteListener!=null){
                                mDeleteListener.onDeleteClick(true);
                            }
                        }else{
                            if (mDeleteListener!=null){
                                mDeleteListener.onDeleteClick(false);
                            }
                        }
                    }
                });

    }

    public void move(int from, int to) {
        Hfence_get.AreaBean prev = area.remove(from);
        area.add(to > from ? to - 1 : to, prev);
        notifyItemMoved(from, to);
    }

    @Override
    public int getItemViewType(int position) {
      /*  if (area.get(position).position == 1) {
            return ITEM_TYPE_ACTION_WIDTH_NO_SPRING;
        }
        if (area.get(position).position == 2) {
            return ITEM_TYPE_RECYCLER_WIDTH;
        }
        if (area.get(position).position == 3) {
            return ITEM_TYPE_NO_SWIPE;
        }
        return ITEM_TYPE_ACTION_WIDTH;*/
        return ITEM_TYPE_ACTION_WIDTH;
    }

    @Override
    public int getItemCount() {
        return area.size();
    }

    class ItemBaseViewHolder extends RecyclerView.ViewHolder {

      /*  @BindView(R.id.view_list_repo_action_delete)
        TextView viewListRepoActionDelete;
        @BindView(R.id.view_list_repo_action_update)
        TextView viewListRepoActionUpdate;*/

        @BindView(R.id.view_list_repo_action_container)
        LinearLayout mActionContainer;

        @BindView(R.id.tv_area_name)
        TextView tvAreaName;
        @BindView(R.id.ll_delete)
        RelativeLayout llDelete;
        @BindView(R.id.view_list_main_content)
        RelativeLayout mViewContent;


        public ItemBaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Hfence_get.AreaBean areaBean) {
            String areaName = areaBean.getAreaName();
//            final String id = areaBean.getId();
            tvAreaName.setText("区域" + areaName);

            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                        mItemTouchHelperExtension.startDrag(ItemBaseViewHolder.this);
                    }
                    return true;
                }
            });
        }
    }


    class ItemViewHolderWithRecyclerWidth extends ItemBaseViewHolder {

        View mActionViewDelete;

        public ItemViewHolderWithRecyclerWidth(View itemView) {
            super(itemView);
            mActionViewDelete = itemView.findViewById(R.id.view_list_repo_action_delete);
        }

    }

    class ItemSwipeWithActionWidthViewHolder extends ItemBaseViewHolder implements Extension {

        View mActionViewDelete;
        //View mActionViewRefresh;

        public ItemSwipeWithActionWidthViewHolder(View itemView) {
            super(itemView);
            mActionViewDelete = itemView.findViewById(R.id.view_list_repo_action_delete);
            //mActionViewRefresh = itemView.findViewById(R.id.view_list_repo_action_update);
        }

        @Override
        public float getActionWidth() {
            return mActionContainer.getWidth();
        }
    }

    class ItemSwipeWithActionWidthNoSpringViewHolder extends ItemSwipeWithActionWidthViewHolder implements Extension {

        public ItemSwipeWithActionWidthNoSpringViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public float getActionWidth() {
            return mActionContainer.getWidth();
        }
    }

    class ItemNoSwipeViewHolder extends ItemBaseViewHolder {

        public ItemNoSwipeViewHolder(View itemView) {
            super(itemView);
        }
    }

}
