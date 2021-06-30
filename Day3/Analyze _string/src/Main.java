public class Main {
    public static void main(String[] args) {

        StringsClass object = new StringsClass();
        String one = object.betterString("ali", "mohsen", (str1, str2) -> str1.length() > str2.length());
        System.out.println(one);

        Boolean result = object.checkString("ali54", StringsClass::allLetters);
        System.out.println(result);


    }
}