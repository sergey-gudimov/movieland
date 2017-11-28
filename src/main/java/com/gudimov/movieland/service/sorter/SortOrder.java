package com.gudimov.movieland.service.sorter;

public enum SortOrder {
    ACS("ACS"), DESC("DESC");

    private String direction;


    SortOrder(String direction) {
        this.direction = direction.toUpperCase();
    }

    public static SortOrder getSortOrderByDirection(String direction) {
        for (SortOrder sortOrder : SortOrder.values()) {
            if (sortOrder.direction.equalsIgnoreCase(direction.toUpperCase())) {
                return sortOrder;
            }
        }
        throw new IllegalArgumentException("Incorect sort direction " + direction);
    }
}
