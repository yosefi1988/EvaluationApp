package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import java.util.List;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class AbfaxSelectsObject {

    private int keyValue;
    private String textValue;
    private int type;

    public int getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(int keyValue) {
        this.keyValue = keyValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
