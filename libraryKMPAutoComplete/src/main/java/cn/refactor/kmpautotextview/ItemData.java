package cn.refactor.kmpautotextview;


/**
 * Created by s.yousefi on 11/09/2018.
 */

public class ItemData {
    String text;

    String meta;

    String imageId;

    public ItemData(String text , String meta, String imageId ){
        this.text = text;
        this.meta = meta;
        this.imageId = imageId;
    }

    public ItemData(String text , String imageId ){
        this.text = text;
        this.meta = "";
        this.imageId = imageId;
    }


    public String getText(){
        return text;
    }


    public String getImageId(){
        return imageId;
    }


    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }


}
