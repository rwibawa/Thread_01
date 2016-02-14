package com.avisow.exercise;

import java.util.Date;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class ImmutableReminder {
    private final Date remindingDate;

    public ImmutableReminder(Date remindingDate) {
        if (remindingDate.getTime() < System.currentTimeMillis()) {
            throw new IllegalArgumentException();
        }

        this.remindingDate = new Date(remindingDate.getTime());
    }

    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
}
