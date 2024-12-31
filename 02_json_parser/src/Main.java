public class Main {
    public static void main(String[] args) {
        String filePath = "/home/alterego/personal_projects/coding-challenges-projects/02_json_parser/src/test.json";
        JsonParser jsonFile = new JsonParser(filePath);
        if (jsonFile.isValid()) {
            System.out.println("Valid file");
        } else {
            System.out.println("Not valid Json file");
        }
    }

}