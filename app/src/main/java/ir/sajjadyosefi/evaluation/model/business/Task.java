package ir.sajjadyosefi.evaluation.model.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;


import java.util.List;

import ir.sajjadyosefi.evaluation.activity.business.DetailsActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
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


    public void prepareYafteItem(Context mContext, EndlessList_Adapter.TaskViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {
        Task request = (Task) mTimelineItemList.get(position);

        holder.textViewName.setText(request.getFirstName());
        holder.textViewFamily.setText(request.getLastName());
        holder.textViewRequestType.setText(request.getRequestType()+"");
        //holder.textViewServicesType.setText(request.getAddress());
        //holder.textViewState.setText(text.toString());


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
