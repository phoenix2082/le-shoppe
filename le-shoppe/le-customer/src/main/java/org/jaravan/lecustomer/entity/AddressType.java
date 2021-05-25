package org.jaravan.lecustomer.entity;

public enum AddressType {
    /**
     * Represents the Office address.
     */
    OFFICE("OFFICE"),

    /**
     * Represents the Residence Address.
     */
    RESIDENCE("RESIDENCE");

    /**
     * Type of address.
     */
    private String type;

    /**
     * Creates an Address type.
     * @param addressType one of OFFICE or RESIDENCE
     */
    AddressType(final String addressType) {
        this.type = addressType;
    }
}
