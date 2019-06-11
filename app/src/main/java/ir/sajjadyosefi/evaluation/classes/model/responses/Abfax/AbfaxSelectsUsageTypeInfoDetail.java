package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import java.util.List;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class AbfaxSelectsUsageTypeInfoDetail {

    private int usageTypeInfoDetailId;
    private String usageInfoDetailDesc;
    private int usageTypeId;

    public int getUsageTypeInfoDetailId() {
        return usageTypeInfoDetailId;
    }

    public void setUsageTypeInfoDetailId(int usageTypeInfoDetailId) {
        this.usageTypeInfoDetailId = usageTypeInfoDetailId;
    }

    public String getUsageInfoDetailDesc() {
        return usageInfoDetailDesc;
    }

    public void setUsageInfoDetailDesc(String usageInfoDetailDesc) {
        this.usageInfoDetailDesc = usageInfoDetailDesc;
    }

    public int getUsageTypeId() {
        return usageTypeId;
    }

    public void setUsageTypeId(int usageTypeId) {
        this.usageTypeId = usageTypeId;
    }


}
