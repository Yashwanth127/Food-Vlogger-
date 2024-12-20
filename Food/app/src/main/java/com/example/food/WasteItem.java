package com.example.food;

public class WasteItem {
    private String type;
    private String quantity;
    private String reason;

    public WasteItem(String type, String quantity, String reason) {
        this.type = type;
        this.quantity = quantity;
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getReason() {
        return reason;
    }
}
