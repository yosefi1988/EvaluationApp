package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import java.util.List;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class AbfaxSelects {

    private List<AbfaxSelectsObject> object;
    private List<AbfaxSelectsUsageTypeInfoDetail> usageTypeInfoDetail;
    private TubelessException exception;

    public List<AbfaxSelectsObject> getObject() {
        return object;
    }

    public void setObject(List<AbfaxSelectsObject> object) {
        this.object = object;
    }

    public List<AbfaxSelectsUsageTypeInfoDetail> getUsageTypeInfoDetail() {
        return usageTypeInfoDetail;
    }

    public void setUsageTypeInfoDetail(List<AbfaxSelectsUsageTypeInfoDetail> usageTypeInfoDetail) {
        this.usageTypeInfoDetail = usageTypeInfoDetail;
    }

    public TubelessException getException() {
        return exception;
    }

    public void setException(TubelessException exception) {
        this.exception = exception;
    }



}
