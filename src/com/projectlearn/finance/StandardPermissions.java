package com.projectlearn.finance;

import java.util.Collections;
import java.util.Set;

public enum StandardPermissions {
    ADMIN (Set.of(Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_PAY, Permissions.CAN_FINE, Permissions.CAN_VIEW_ACCOUNTS)),
    INTERN (Set.of(Permissions.CAN_WITHDRAW)),
    EMPLOYEE (Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW)),
    HR (Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_PAY, Permissions.CAN_VIEW_ACCOUNTS)),
    IT (Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_VIEW_ACCOUNTS));

    private final Set<Permissions> perms;

    StandardPermissions (Set<Permissions> perms) {
        this.perms = perms;
    }

    private Set permsEnabled() {
        return Collections.unmodifiableSet(perms);
    }

}

//    //ADMIN (Set<Permissions> admin = Set.of(Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_PAY, Permissions.CAN_FINE, Permissions.CAN_VIEW_ACCOUNTS))
//    Set<Permissions> admin = Set.of(Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_PAY, Permissions.CAN_FINE, Permissions.CAN_VIEW_ACCOUNTS),
//    Set<Permissions> intern = Set.of(Permissions.CAN_WITHDRAW),
//    Set<Permissions> employee = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW);
//    Set<Permissions> hr = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_PAY, Permissions.CAN_VIEW_ACCOUNTS);
//    Set<Permissions> it = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_VIEW_ACCOUNTS);
