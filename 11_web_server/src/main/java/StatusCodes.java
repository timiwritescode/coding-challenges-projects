public enum StatusCodes {
    OK(200, "ok");

    private final int code;
    private final String description;

    StatusCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getStatusCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}