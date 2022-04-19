package dto.order;

public enum OrderStatus {
    SUCCESS(0, "SUCCESS"),
    PENDING(1, "Order in waiting queue "),
    IN_PROCESS(2, "Order in process ."),
    CANCEL(3, "Order is cancel"),
    TIMEOUT(4, "Order Timeout ");
    private final int code;
    private final String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderStatus fromCode(int value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.code == value) {
                return orderStatus;
            }
        }
        return OrderStatus.TIMEOUT;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
