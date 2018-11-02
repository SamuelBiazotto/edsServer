package br.com.eds.Application.model.enumModel;

public enum PatientsStatus {
    ATENDIMENTO(1, "ATENDIMENTO"),
    ALTA(2, "ALTA");


    private int code;
    private String description;


    PatientsStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PatientsStatus toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (PatientsStatus x : PatientsStatus.values()) {
            if (id.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + id);
    }
}
