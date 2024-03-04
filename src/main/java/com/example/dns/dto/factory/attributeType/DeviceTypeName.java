package com.example.dns.dto.factory.attributeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public enum DeviceTypeName {
    REFRIGERATOR("холодильник"),
    SMARTPHONE("смартфон"),
    TELEVISION("телевизор"),
    VACUUM_CLEANER("пылесос"),
    COMPUTER("компьютер");

    private final String name;

    DeviceTypeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DeviceTypeName fromName(String name) {
        switch (name.toLowerCase()) {
            case "холодильник":
                return REFRIGERATOR;
            case "смартфон":
                return SMARTPHONE;
            case "телевизор":
                return TELEVISION;
            case "пылесос":
                return VACUUM_CLEANER;
            case "компьютер":
                return COMPUTER;
            default:
                throw new IllegalArgumentException("Invalid device name: " + name);
        }
    }
}

