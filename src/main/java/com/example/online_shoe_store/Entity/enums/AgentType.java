package com.example.online_shoe_store.Entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AgentType {
    // Current active agents
    PRODUCT("product_agent", "Tìm kiếm & tư vấn sản phẩm"),
    SUPPORT_SERVICES("support_services_agent", "Hỗ trợ, kiểm kho, vận chuyển"),
    AGGREGATION("aggregation_agent", "Tổng hợp & tóm tắt"),
    ORCHESTRATOR("orchestrator_agent", "Điều phối agent"),
    
    // Legacy values (kept for database compatibility)
    SEARCH("search_agent", "Tìm kiếm sản phẩm"),
    SALES("sales_agent", "Tư vấn bán hàng"),
    INVENTORY("inventory_agent", "Kiểm kho"),
    COMPLAINTS("complaints_agent", "Khiếu nại"),
    SUPPORT("support_agent", "Hỗ trợ"),
    CART("cart_agent", "Giỏ hàng"),
    RECOMMEND("recommend_agent", "Gợi ý sản phẩm"),
    FAQ("faq_agent", "FAQ"),
    MARKETING("marketing_agent", "Marketing"),
    RETURNS("returns_agent", "Đổi trả hoàn tiền"),
    LOGISTICS("logistics_agent", "Tracking giao hàng");


    private final String code;
    private final String description;

    public static AgentType fromCode(String code) {
        for (AgentType type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        return SUPPORT_SERVICES; // Default mới
    }

    public boolean isSensitive() {
        return this == RETURNS || this == SUPPORT_SERVICES;
    }
    }
