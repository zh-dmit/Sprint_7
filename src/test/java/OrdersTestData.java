import java.util.Arrays;

public class OrdersTestData {

    public static Order bodyPostWithBlack() {
        return new Order("Evgeny", "Dmitriev", "Staropetr pr. 4", 4, "+7 800 355 35 35", 5, "2020-06-06", "fast as can", Arrays.asList("BLACK"));
    }

    public static Order bodyPostWithGrey() {
        return new Order("Evgeny", "Dmitriev", "Staropetr pr. 4", 4, "+7 800 355 35 35", 5, "2020-06-06", "fast as can", Arrays.asList("GREY"));
    }

    public static Order bodyPostWithBothColors() {
        return new Order("Evgeny", "Dmitriev", "Staropetr pr. 4", 4, "+7 800 355 35 35", 5, "2020-06-06", "fast as can", Arrays.asList("BLACK", "GREY"));
    }

    public static Order bodyPostWithNonColors() {
        return new Order("Evgeny", "Dmitriev", "Staropetr pr. 4", 4, "+7 800 355 35 35", 5, "2020-06-06", "fast as can", Arrays.asList());
    }

}
