package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

/**
 * Created by sajjad on 10/31/2016.
 */
public class UsageListItem {


    private int usageTypeIdReq;
    private int waterMainUnitQtyReq;
    private int needSeparationReq;
    private String usageDesc;


    public int getUsageTypeIdReq() {
        return usageTypeIdReq;
    }

    public void setUsageTypeIdReq(int usageTypeIdReq) {
        this.usageTypeIdReq = usageTypeIdReq;
    }

    public int getWaterMainUnitQtyReq() {
        return waterMainUnitQtyReq;
    }

    public void setWaterMainUnitQtyReq(int waterMainUnitQtyReq) {
        this.waterMainUnitQtyReq = waterMainUnitQtyReq;
    }

    public int getNeedSeparationReq() {
        return needSeparationReq;
    }

    public void setNeedSeparationReq(int needSeparationReq) {
        this.needSeparationReq = needSeparationReq;
    }

    public String getUsageDesc() {
        return usageDesc;
    }

    public void setUsageDesc(String usageDesc) {
        this.usageDesc = usageDesc;
    }

}
