package ir.sajjadyosefi.evaluation.classes.model.request;

public class SearchRequest {

    private String fName;
    private String lName;
    private String fatherName;
    private String nationalCode;
    private String type;


    public SearchRequest(String fName, String lName, String fatherName , String searchType) {
        this.fName = fName;
        this.lName = lName;
        this.fatherName = fatherName;
        this.type = searchType;
        this.nationalCode = "" ;
    }

    public SearchRequest(String nationalCode, String searchType) {
        this.nationalCode = nationalCode;
        this.type = searchType;
        this.fName  = "" ;
        this.lName  = "" ;
        this.fatherName  = "" ;
        this.type = searchType;
    }


    public SearchRequest() {
        this.type = "-1";
    }



    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
