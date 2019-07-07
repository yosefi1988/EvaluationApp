package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch;

import java.util.List;

import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class WaterBranch extends TubelessObject {


    private int id ;
    private String title;
    private AbfaxSelectsObject WaterPipeBranchStatus;
    private AbfaxSelectsObject DiameterWaterPipeBranch;
    private int Lenght;
    private List<WaterMeter> waterMeters;
    private WaterNetwork waterNetwork;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public WaterNetwork getWaterNetwork() {
        return waterNetwork;
    }

    public void setWaterNetwork(WaterNetwork waterNetwork) {
        this.waterNetwork = waterNetwork;
    }



    public AbfaxSelectsObject getWaterPipeBranchStatus() {
        return WaterPipeBranchStatus;
    }

    public void setWaterPipeBranchStatus(AbfaxSelectsObject waterPipeBranchStatus) {
        WaterPipeBranchStatus = waterPipeBranchStatus;
    }

    public AbfaxSelectsObject getDiameterWaterPipeBranch() {
        return DiameterWaterPipeBranch;
    }

    public void setDiameterWaterPipeBranch(AbfaxSelectsObject diameterWaterPipeBranch) {
        DiameterWaterPipeBranch = diameterWaterPipeBranch;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<WaterMeter> getWaterMeters() {
        return waterMeters;
    }

    public void setWaterMeters(List<WaterMeter> waterMeters) {
        this.waterMeters = waterMeters;
    }


    public int getLenght() {
        return Lenght;
    }

    public void setLenght(int lenght) {
        Lenght = lenght;
    }


}
