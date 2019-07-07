package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch;

import java.util.List;

import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class WaterNetwork  extends TubelessObject {

    private int id ;
    private AbfaxSelectsObject DiameterWaterPipeNetwork;
    private AbfaxSelectsObject WaterPipeNetworkMaterial;
    private String title;
    private List<WaterBranch> waterBranches;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<WaterBranch> getWaterBranches() {
        return waterBranches;
    }

    public void setWaterBranches(List<WaterBranch> waterBranches) {
        this.waterBranches = waterBranches;
    }


    public AbfaxSelectsObject getDiameterWaterPipeNetwork() {
        return DiameterWaterPipeNetwork;
    }

    public void setDiameterWaterPipeNetwork(AbfaxSelectsObject diameterWaterPipeNetwork) {
        DiameterWaterPipeNetwork = diameterWaterPipeNetwork;
    }

    public AbfaxSelectsObject getWaterPipeNetworkMaterial() {
        return WaterPipeNetworkMaterial;
    }

    public void setWaterPipeNetworkMaterial(AbfaxSelectsObject waterPipeNetworkMaterial) {
        WaterPipeNetworkMaterial = waterPipeNetworkMaterial;
    }

}
