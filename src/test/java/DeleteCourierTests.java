import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCourierTests {

    private CourierSteps courierSteps = new CourierSteps();

    @Before
    public void createCourier() {
        courierSteps.createCourierIfDoesNotExist();
    }

    @Test
    public void deleteCourierTest() {
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        Response deleteCourier = courierSteps.deleteCourier(postLogin.jsonPath().getString("id"));
        deleteCourier.then().statusCode(200);
    }

    @Test
    public void deleteNonExistentCourierTest() {
        Response deleteCourier = courierSteps.deleteCourier("0");
        deleteCourier.then().statusCode(404);
    }

    @Test
    public void deleteCourierWithoutIdTest() {
        Response deleteCourier = courierSteps.deleteCourier("");
        deleteCourier.then().statusCode(404);
    }

    @Test
    public void deleteCourierCheckResponseTest() {
        courierSteps.createCourierIfDoesNotExist();
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        Response deleteCourier = courierSteps.deleteCourier(postLogin.jsonPath().getString("id"));
        deleteCourier.then().body("ok", equalTo(true));
    }

    @Test
    public void deleteCourierInvalidRequestTest() {
        Response deleteCourier = courierSteps.deleteCourier(null);
        deleteCourier.then().statusCode(500);
    }

    @After
    public void deleteCourier() {
        courierSteps.deleteCourierIfExist();
    }
}
