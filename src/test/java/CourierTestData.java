public class CourierTestData {

    public static Courier bodyPost() {
        return new Courier("dmit", "1234", "Evgeny");
    }

    public static Courier notFullBodyPost() {
        return new Courier("dmit", "", "Evgeny");
    }

    public static Courier notCompleteBodyPost() {
        return new Courier("dmit", null, "Evgeny");
    }

    public static Courier bodyPostWithExistingLogin() {
        return new Courier("dmit", "12345", "Evgeny");
    }

    public static Courier bodyPostWithIncorrectData() {
        return new Courier("%!0-={}[", "%!0-={}[", "Evgeny");
    }

    public static Courier bodyPostWithNonExistentData() {
        return new Courier("Login", "password", "Evgeny");
    }
}
