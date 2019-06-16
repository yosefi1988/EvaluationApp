package cn.refactor.kmpautotextview;

import java.io.Serializable;

public class PopupTextBean implements Serializable {
    public ItemData mTarget;
    public int mStartIndex = -1;
    public int mEndIndex = -1;

    public PopupTextBean(ItemData target) {
        this.mTarget = target;
    }

    public PopupTextBean(ItemData itemData, int startIndex) {
        this.mTarget = itemData;
        this.mStartIndex = startIndex;
        if (-1 != startIndex) {
            this.mEndIndex = startIndex + itemData.getText().length();
        }
    }

    public PopupTextBean(ItemData target, int startIndex, int endIndex) {
        this.mTarget = target;
        this.mStartIndex = startIndex;
        this.mEndIndex = endIndex;
    }
}