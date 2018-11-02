package br.com.eds.Application.model.enumModel;

public enum Role {

    MEDICO(1, "ROLE_MEDICO"),
    ENFERMEIRO(2, "ROLE_ENFERMEIRO"),
    RECEPCIONISTA(3, "ROLE_RECEPCIONISTA");

    private int code;
    private String description;

    Role(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getdescription() {
        return description;
    }

    public static Role toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Role x : Role.values()) {
            if (id.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + id);
    }
}
