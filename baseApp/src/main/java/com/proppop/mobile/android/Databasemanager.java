package com.proppop.mobile.android;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proppop.mobile.android.fragments.models.RepairTicket;

/**
 * Created by animal@martus.org on 10/1/16.
 */

public class Databasemanager {

    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference reference;

    public Databasemanager() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
    }

    public static void addRepairTicket(RepairTicket repairTicketToAdd) {
        getRepairTicketsReference().push().setValue(repairTicketToAdd);
    }

    public static DatabaseReference getRepairTicketsReference() {
        return reference;
    }
}
