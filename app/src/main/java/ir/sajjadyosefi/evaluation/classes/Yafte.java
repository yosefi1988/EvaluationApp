package ir.sajjadyosefi.evaluation.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.ReadBlogActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.classes.utility.DateConverterSjd;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;

import java.util.Date;
import java.util.List;

/**
 * Created by sajjad on 9/19/2018.
 */

public class Yafte {

    final int radius = 5;
    final int margin = 5;
    final Transformation transformation = new RoundedCornersTransformation(radius, margin);

    public void prepareYafteItem(final Context mContext , final EndlessList_Adapter.TimelineItemViewHolder holder, final List<TubelessObject> mTimelineItemList, final int position) {

        final boolean[] loadedImage = {false};
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
        String json0000 = gson.toJson(mTimelineItemList.get(position));
        final TimelineItem timelineItem = gson.fromJson(json0000,TimelineItem.class);

        DateConverterSjd dateUtiliti = new DateConverterSjd();





        if (timelineItem.getPicture()!= null && timelineItem.getPicture().length() > 10) {
            holder.imageviewPicture.setVisibility(View.VISIBLE);
            Picasso.with(mContext)
                .load(timelineItem.getPictureTumble())
                .placeholder(R.drawable.bg_search)
                //.centerInside()
                .transform(transformation)
                .into(holder.imageviewPicture, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        // TODO Auto-generated method stub
                        Picasso.with(mContext)
                                .load(R.drawable.png_image)
                                .transform(transformation)
                                .into(holder.imageviewPicture);
                    }
                });

        }else {
            holder.imageviewPicture.setVisibility(View.GONE);
        }


        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(timelineItem.getTitle());
        if (timelineItem.getCategoryID() == 16) {
            stringBuilder0.append(" (");
            stringBuilder0.append("گمشده");
            stringBuilder0.append(")");
        }
        if (timelineItem.getCategoryID() == 17) {
            stringBuilder0.append(" (");
            stringBuilder0.append("پیداشده");
            stringBuilder0.append(")");
        }
        if (timelineItem.getCategoryID() == 18) {
            stringBuilder0.append(" (");
            stringBuilder0.append("سرقتی");
            stringBuilder0.append(")");
        }
        holder.textViewTitle.setText(stringBuilder0.toString());


        holder.textViewLocation.setText(timelineItem.getLocation());


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(timelineItem.getDate());
        stringBuilder.append(" ( ");
        stringBuilder.append("تاریخ ثبت : ");
        stringBuilder.append(timelineItem.getRegisterDate());
        stringBuilder.append(" ) ");
        holder.textViewDate.setText(stringBuilder.toString());

        holder.textViewUserName.setText(timelineItem.getUserName());
        holder.textViewCount.setText(timelineItem.getViewCount() + "");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EndlessList_Adapter.prepareToShare(mContext, timelineItem.getTitlePicture(), timelineItem.getStatement(), false);
            }
        };

        holder.textViewShare.setOnClickListener(onClickListener);
        holder.imageViewShare.setOnClickListener(onClickListener);

        View.OnClickListener onStarClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    AsyncFavouriteBlogItem asyncFavouriteBlogItem = new AsyncFavouriteBlogItem(mContext,mProgressBar,yafteItem.getID(),Global.mUser.getUserID(),yafteItem.isInMyFavList());
//                    asyncFavouriteBlogItem.execute();

            }
        };

//        holder.imageViewFavourite.setOnClickListener(onStarClickListener);
//        holder.textViewFavourite.setOnClickListener(onStarClickListener);
//        if(yafteItem.isInMyFavList())
//            holder.imageViewFavourite.setImageResource(android.R.drawable.btn_star_big_on);
//        else
//            holder.imageViewFavourite.setImageResource(android.R.drawable.btn_star_big_off);




        Picasso.with(mContext)
                .load(timelineItem.getUserImage())
                .placeholder(R.drawable.bg_search)
                //.centerInside()
                .transform(transformation)
                .into(holder.imageViewUserAvatar, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        // TODO Auto-generated method stub
                        Picasso.with(mContext)
                                .load(R.drawable.bg_search)
                                .transform(transformation)
                                .into(holder.imageViewUserAvatar);
                    }
                });

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReadBlogActivity.class);
                Gson gson = new Gson();
                String json = gson.toJson(mTimelineItemList.get(position));
                intent.putExtra("Object", json);
                mContext.startActivity(intent);
                ((Activity) mContext).overridePendingTransition(R.anim.fadeout, R.anim.fadein);
            }
        };
        holder.textViewTitle.setOnClickListener(onclick);
        holder.textViewLocation.setOnClickListener(onclick);
        holder.textViewDate.setOnClickListener(onclick);

    }
}
