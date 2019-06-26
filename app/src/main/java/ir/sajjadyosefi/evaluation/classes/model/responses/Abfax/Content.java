package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

public class Content {

    public int requestContentId;
    public int frame;
    public String description;
    public int downloadEarly;

    public int getRequestContentId() {
        return requestContentId;
    }

    public void setRequestContentId(int requestContentId) {
        this.requestContentId = requestContentId;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDownloadEarly() {
        return downloadEarly;
    }

    public void setDownloadEarly(int downloadEarly) {
        this.downloadEarly = downloadEarly;
    }


}
