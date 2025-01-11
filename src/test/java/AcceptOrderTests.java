import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class AcceptOrderTests {

    private OrderSteps orderSteps = new OrderSteps();
    private CourierSteps courierSteps = new CourierSteps();

    @Before
    public void createCourier() {
        courierSteps.createCourierIfDoesNotExist();
    }

    @Test
    public void acceptOrder() {
        Integer idCourier = orderSteps.getCourierId();
        Integer orderId = orderSteps.getOrderId();
        Response acceptOrder = orderSteps.acceptOrder(orderId.toString() + "?", idCourier.toString());
        acceptOrder.then().statusCode(200);
    }

    @Test
    public void acceptOrderCheckResponse() {
        Integer idCourier = orderSteps.getCourierId();
        Integer orderId = orderSteps.getOrderId();
        Response acceptOrder = orderSteps.acceptOrder(orderId.toString() + "?", idCourier.toString());
        acceptOrder.then().body("ok", equalTo(true));
    }

    @Test
    public void acceptOrderWrongCourierId() {
        Integer orderId = orderSteps.getOrderId();
        Response acceptOrder = orderSteps.acceptOrder(orderId.toString() + "?", "0");
        acceptOrder.then().statusCode(404);
    }

    @Test
    public void acceptOrderWrongOrderId() {
        Integer idCourier = orderSteps.getCourierId();
        Response acceptOrder = orderSteps.acceptOrder("0?", idCourier.toString());
        acceptOrder.then().statusCode(404);
    }

    @Test
    public void acceptOrderWithoutOrderIdCourierId() {
        Response acceptOrder = orderSteps.acceptOrder("","");
        acceptOrder.then().statusCode(400);
    }

    @Test
    public void acceptOrderWithoutOrderId() {
        Integer idCourier = orderSteps.getCourierId();
        Response acceptOrder = orderSteps.acceptOrder("", idCourier.toString());
        acceptOrder.then().statusCode(400);
    }

    @Test
    public void acceptOrderWithoutCourierId() {
        Integer orderId = orderSteps.getOrderId();
        Response acceptOrder = orderSteps.acceptOrder(orderId.toString() + "?", "");
        acceptOrder.then().statusCode(400);
    }

    @After
    public void deleteCourier() {
        courierSteps.deleteCourierIfExist();
    }
}
