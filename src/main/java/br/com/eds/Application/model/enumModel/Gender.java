package br.com.eds.Application.model.enumModel;

public enum Gender {

    MASCULINO(1, "MASCULINO"),
    FEMININO(2, "FEMININO");


    private int code;
    private String description;

    Gender(int code, String description) {
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


    public static Gender toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Gender x : Gender.values()) {
            if (id.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + id);
    }
}
