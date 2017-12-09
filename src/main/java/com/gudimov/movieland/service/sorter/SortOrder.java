package com.gudimov.movieland.service.sorter;

public enum SortOrder {
    ACS("ACS"), DESC("DESC");

    private final String direction;


    SortOrder(String direction) {
        this.direction = direction.toUpperCase();
    }

    public static SortOrder getSortOrderByDirection(String direction) {
        if (direction == null) {
            return null;
        }
        for (SortOrder sortOrder : SortOrder.values()) {
            if (sortOrder.direction.equalsIgnoreCase(direction.toUpperCase())) {
                return sortOrder;
            }
        }
        throw new IllegalArgumentException("Incorrect sort direction " + direction);
    }
}
