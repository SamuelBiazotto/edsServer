package br.com.eds.Application.model.enumModel;

public enum FormularyOphtalmologistyStatus {
    ABERTO(1, "ABERTO"),
    FINALIZADO(2, "FINALIZADO");


    private int code;
    private String description;

    FormularyOphtalmologistyStatus(int code, String description) {
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

    public static FormularyOphtalmologistyStatus toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (FormularyOphtalmologistyStatus x : FormularyOphtalmologistyStatus.values()) {
            if (id.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + id);
    }
}


