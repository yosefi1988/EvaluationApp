package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import java.util.List;

import ir.sajjadyosefi.evaluation.model.business.Task;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class DownloadObject {

    public String content ;
    public String contentType ;
    public String contentValue ;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

}
