package ir.sajjadyosefi.evaluation.model.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;


import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.business.DetailsActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.MapActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.libraries.tofiraImagePicker.TempActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.Content;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.OldSubscribeListItem;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class Task extends TubelessObject {


    private String serialRequestCode;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String cellPhone;
    private float locationX;
    private float locationY;
    private int requestType;
    private int requestId;
    private int taskType;
    private String taskDate;
    private List<UsageListItem> usageList;
    private List<File> fileList;
    private File fileKrocki;
    private List<OldSubscribeListItem> oldSubscribeList;
    private List<Content> contentList;


    public List<ItemData> listNetwork = new ArrayList<>();
    public List<ItemData> listBranchs = new ArrayList<>();
    public List<TubelessObject> NetworkAndBranch = new ArrayList<TubelessObject>();


    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public void prepareYafteItem(Context mContext, EndlessList_Adapter.TaskViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {
        Task request = (Task) mTimelineItemList.get(position);

        holder.textViewName.setText(request.getFirstName());
        holder.textViewFamily.setText(request.getLastName());
        holder.textViewRequestType.setText(request.getRequestType()+"");
        //holder.textViewServicesType.setText(request.getAddress());
        //holder.textViewState.setText(text.toString());

        holder.buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(mContext, holder.buttonMenu);
                //inflating menu from xml resource
                popup.inflate(R.menu.main_fab);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_sms:
                                //handle menu1 click
                                String number = request.getCellPhone();  // The number on which you want to send SMS
                                (mContext).startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
                                break;
                            case R.id.menu_call:
                                //handle menu2 click
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + request.getCellPhone()));
                                (mContext).startActivity(intent);
                                break;
                            case R.id.menu_place:
                                //handle menu3 click
                                Intent intentx1 = new Intent(mContext, MapActivity.class);
                                intentx1.putExtra("latitude" , request.getLocationX());
                                intentx1.putExtra("longitude" , request.getLocationY());
                                (mContext).startActivity(intentx1);
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();
            }
        });

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                //mTimelineItemList.get(position)
                Global.CurrentTask = request;
                ((Activity)mContext).startActivity(intent);
            }
        });
    }

    public String getSerialRequestCode() {
        return serialRequestCode;
    }

    public void setSerialRequestCode(String serialRequestCode) {
        this.serialRequestCode = serialRequestCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public float getLocationX() {
        return locationX;
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public List<UsageListItem> getUsageList() {
        return usageList;
    }

    public void setUsageList(List<UsageListItem> usageList) {
        this.usageList = usageList;
    }

    public List<OldSubscribeListItem> getOldSubscribeList() {
        return oldSubscribeList;
    }

    public void setOldSubscribeList(List<OldSubscribeListItem> oldSubscribeList) {
        this.oldSubscribeList = oldSubscribeList;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public File getFileKrocki() {
        return fileKrocki;
    }

    public void setFileKrocki(File fileKrocki) {
        this.fileKrocki = fileKrocki;
    }


}
