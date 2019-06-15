package ir.sajjadyosefi.evaluation.classes.model.request.account;

import ir.sajjadyosefi.evaluation.classes.Global;

public class DeviceRequest {

    private int IDUser = 0;
    private int IDApplicationVersion = Global.IDApplicationVersion;
    private String AndroidID;
    private String SERIAL;
    private String MODEL;
    private String BuildID;
    private String AndroidVersion;
    private int AndroidAPI;
    private String MANUFACTURER;
    private String BRAND;
    private String BOARD;
    private String DISPLAY;



//    public DeviceRequest(int IDUser, String androidID, String SERIAL, String MODEL, String buildID, String androidVersion, String androidAPI, String MANUFACTURER, String BRAND, String BOARD, String DISPLAY) {
//        this.IDUser = IDUser;
//        AndroidID = androidID;
//        this.SERIAL = SERIAL;
//        this.MODEL = MODEL;
//        BuildID = buildID;
//        AndroidVersion = androidVersion;
//        AndroidAPI = androidAPI;
//        this.MANUFACTURER = MANUFACTURER;
//        this.BRAND = BRAND;
//        this.BOARD = BOARD;
//        this.DISPLAY = DISPLAY;
//    }

    public DeviceRequest( String androidID, String SERIAL, String MODEL, String buildID, String androidVersion, int androidAPI, String MANUFACTURER, String BRAND, String BOARD, String DISPLAY) {
        AndroidID = androidID;
        this.SERIAL = SERIAL;
        this.MODEL = MODEL;
        BuildID = buildID;
        AndroidVersion = androidVersion;
        AndroidAPI = androidAPI;
        this.MANUFACTURER = MANUFACTURER;
        this.BRAND = BRAND;
        this.BOARD = BOARD;
        this.DISPLAY = DISPLAY;
    }


    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public int getIDApplicationVersion() {
        return IDApplicationVersion;
    }

    public void setIDApplicationVersion(int IDApplicationVersion) {
        this.IDApplicationVersion = IDApplicationVersion;
    }

    public String getAndroidID() {
        return AndroidID;
    }

    public void setAndroidID(String androidID) {
        AndroidID = androidID;
    }

    public String getSERIAL() {
        return SERIAL;
    }

    public void setSERIAL(String SERIAL) {
        this.SERIAL = SERIAL;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getBuildID() {
        return BuildID;
    }

    public void setBuildID(String buildID) {
        BuildID = buildID;
    }

    public String getAndroidVersion() {
        return AndroidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        AndroidVersion = androidVersion;
    }

    public int getAndroidAPI() {
        return AndroidAPI;
    }

    public void setAndroidAPI(int androidAPI) {
        AndroidAPI = androidAPI;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public void setMANUFACTURER(String MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getBOARD() {
        return BOARD;
    }

    public void setBOARD(String BOARD) {
        this.BOARD = BOARD;
    }

    public String getDISPLAY() {
        return DISPLAY;
    }

    public void setDISPLAY(String DISPLAY) {
        this.DISPLAY = DISPLAY;
    }

}
