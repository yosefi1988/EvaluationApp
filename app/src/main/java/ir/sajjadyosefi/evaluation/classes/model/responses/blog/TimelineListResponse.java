package ir.sajjadyosefi.evaluation.classes.model.responses.blog;

import ir.sajjadyosefi.evaluation.model.main.TimelineItem;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajjad on 1/20/2018.
 */

public class TimelineListResponse extends ServerResponseBase {

    List<TimelineItem> timelineList = new ArrayList<TimelineItem>();

    public List<TimelineItem> getTimelineList() {
        return timelineList;
    }

    public void setTimelineList(List<TimelineItem> timelineList) {
        this.timelineList = timelineList;
    }
}
