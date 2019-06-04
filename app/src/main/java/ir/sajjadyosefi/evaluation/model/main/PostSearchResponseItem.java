package ir.sajjadyosefi.evaluation.model.main;

public class PostSearchResponseItem extends TubelessObject {

    private String id;
    private int fkFindedType;
    private String findDate;
    private String n;
    private String fName;
    private String lName;
    private String fatherName;
    private String identityNumber;
    private String nationalCode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFkFindedType() {
        return fkFindedType;
    }

    public void setFkFindedType(int fkFindedType) {
        this.fkFindedType = fkFindedType;
    }

    public String getFindDate() {
        return findDate;
    }

    public void setFindDate(String findDate) {
        this.findDate = findDate;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
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

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

}
