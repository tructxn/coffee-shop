package backend.order.utils;

import java.util.UUID;

public class OrderUtils {
    public static String buildOrderId() {
        return UUID.randomUUID().toString();
    }
    public static String buildOrderItemId() {
        return UUID.randomUUID().toString();
    }
}
