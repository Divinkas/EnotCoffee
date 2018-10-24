package com.example.divin.enotcoffe.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.divin.enotcoffe.Data.CavaItemInfo;
import com.example.divin.enotcoffe.Data.SellCoffee;
import com.example.divin.enotcoffe.Model.DatabaseModel;
import com.example.divin.enotcoffe.R;

import java.util.List;

public class RenderCoffeeListAdapter extends RecyclerView.Adapter<RenderCoffeeListAdapter.CoffeeViewHolder> {

    private List<SellCoffee> sellCavaList_for_currentDay;
    private Context context;

    private DatabaseModel databaseModel;

    public RenderCoffeeListAdapter(List<SellCoffee> sellCavaList, Context context) {
        this.sellCavaList_for_currentDay = sellCavaList;
        this.context = context;
        databaseModel = new DatabaseModel(this.context);

    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new CoffeeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_coffee_cart, viewGroup, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder coffeeViewHolder, int position) {
        coffeeViewHolder.setIsRecyclable(false);

        CavaItemInfo cavaItemInfo = databaseModel.getCavaIntemInfoById(sellCavaList_for_currentDay.get(position).getKod_cava_item());

        coffeeViewHolder.tvNameCoffee.setText(cavaItemInfo.getName());
        coffeeViewHolder.tvPriceCoffee.setText(cavaItemInfo.getPrice() + "грн ");
        coffeeViewHolder.tvVolumeCoffee.setText("(" +cavaItemInfo.getVolume() + "мл.)");

        coffeeViewHolder.tvCountSellsCoffee.setText(String.valueOf(sellCavaList_for_currentDay.get(position).getCount()));
        coffeeViewHolder.llContainer.
                setOnClickListener(v -> {
                    sellCavaList_for_currentDay.get(position).setCount(databaseModel
                            .addOneItemsInSellsById(sellCavaList_for_currentDay.get(position).getId()));
                    notifyDataSetChanged();
                });
    }

    @Override
    public int getItemCount() {
        return sellCavaList_for_currentDay.size();
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder{
        LinearLayout llContainer;
        TextView tvNameCoffee, tvCountSellsCoffee, tvPriceCoffee, tvVolumeCoffee;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountSellsCoffee = itemView.findViewById(R.id.tvItemCoffeeCountSellForCurrentDay);
            tvNameCoffee = itemView.findViewById(R.id.tvItemCoffeeName);
            tvPriceCoffee = itemView.findViewById(R.id.tvItemCoffeePrice);
            tvVolumeCoffee = itemView.findViewById(R.id.tvItemCoffeeVolume);
            llContainer = itemView.findViewById(R.id.itemCoffeeContainer);
        }
    }
}
