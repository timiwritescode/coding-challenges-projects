class JsonParser {
    private final String fileContent;
    public JsonParser(String filePath) {
        fileContent = Util.readFileContent(filePath);
    }

    public boolean isValid() {
        // first check if last and first nonspace character are { and } respectively
        if (isValidFirstAndLastCharacter()) {
            return true;
        }
        return false;
    }

    private boolean isValidFirstAndLastCharacter() {
       String firstCharacter = "" + fileContent.charAt(0);
       String lastCharacter = "" + fileContent.charAt(fileContent.length() - 1);
       return firstCharacter.equals("{") & lastCharacter.equals("}");
    }
}