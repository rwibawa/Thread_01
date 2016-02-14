package com.avisow.exercise;

/**
 * Created by rwibawa on 2/13/2016.
 */
public final class ImmutableContacts {
    private final String name;
    private final String mobile;

    public ImmutableContacts(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }
}
