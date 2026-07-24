package com.example.online_shoe_store.Entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Các loại ý định (intent) mà người dùng có thể bày tỏ
 */
@Getter
@RequiredArgsConstructor
public enum IntentType {
    // Primary Intents - Mua sắm
    SEARCH("search", "Tìm kiếm sản phẩm"),
    RECOMMENDATION("recommendation", "Gợi ý sản phẩm"),
    PURCHASE("purchase", "Muốn mua hàng"),

    SUPPORT("support", "Hỗ trợ chung"),
    COMPLAINT("complaint", "Khiếu nại"),
    
    REFUND("refund", "Yêu cầu hoàn tiền"),
    RETURN("return", "Đổi trả hàng"),
    
    FEEDBACK("feedback", "Đánh giá sản phẩm"),
    PRICE_CHECK("price_check", "Hỏi giá/khuyến mãi"),
    SIZE_ADVICE("size_advice", "Tư vấn size"),
    STOCK_CHECK("stock_check", "Kiểm tra tồn kho"),
    TRACK_ORDER("track_order", "Theo dõi đơn hàng"),
    
    // Special
    GREETING("greeting", "Chào hỏi"),
    UNKNOWN("unknown", "Không xác định");
    
    private final String code;
    private final String description;

    public static IntentType fromCode(String code) {
        for (IntentType type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        return UNKNOWN;
    }

    public boolean requiresEscalation() {
        return this == COMPLAINT || this == REFUND;
    }
    

    public boolean isHighPriority() {
        return this == COMPLAINT || this == REFUND || this == RETURN || this == PURCHASE;
    }
}
