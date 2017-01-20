package com.proppop.mobile.android.fragments.models;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by animal@martus.org on 9/30/16.
 */

public class RepairTicketsLoader extends AsyncTaskLoader<List<RepairTicket>> {

    private List<RepairTicket> repairTickets;

    public RepairTicketsLoader(Context context) {
        super(context);
    }

    @Override
    public List<RepairTicket> loadInBackground() {
        // You should perform the heavy task of getting data from
        // Internet or database or other source
        // Here, we are generating some Sample data

        return createSampleTickets();
    }

    @NonNull
    private List<RepairTicket> createSampleTickets() {
        ArrayList<RepairTicket> entries = new ArrayList<>();
//        Databasemanager.
//        entries.add(new RepairTicket("1", "Fix bathroom leak", "Low"));
//        entries.add(new RepairTicket("2", "Broken glass in front room", "Medium"));
//        entries.add(new RepairTicket("3", "Lost key", "High"));
//        entries.add(new RepairTicket("4", "Why is my water bill so low?", "Low"));

        return entries;
    }

    /**
     * Called when there is new data to deliver to the client.  The
     * super class will take care of delivering it; the implementation
     * here just adds a little more logic.
     */
    @Override public void deliverResult(List<RepairTicket> listOfData) {
        if (isReset()) {
            // An async query came in while the loader is stopped.  We
            // don't need the result.
            if (listOfData != null) {
                onReleaseResources(listOfData);
            }
        }
        List<RepairTicket> oldRepairTickets = listOfData;
        repairTickets = listOfData;

        if (isStarted()) {
            // If the Loader is currently started, we can immediately
            // deliver its results.
            super.deliverResult(listOfData);
        }

        // At this point we can release the resources associated with
        // 'oldRepairTickets' if needed; now that the new result is delivered we
        // know that it is no longer in use.
        if (oldRepairTickets != null) {
            onReleaseResources(oldRepairTickets);
        }
    }

    /**
     * Handles a request to start the Loader.
     */
    @Override protected void onStartLoading() {
        if (repairTickets != null) {
            // If we currently have a result available, deliver it immediately.
            deliverResult(repairTickets);
        }

        if (takeContentChanged() || repairTickets == null) {
            // If the data has changed since the last time it was loaded or is not currently available, start a load.
            forceLoad();
        }
    }

    /**
     * Handles a request to stop the Loader.
     */
    @Override protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

    /**
     * Handles a request to cancel a load.
     */
    @Override public void onCanceled(List<RepairTicket> repairTickets) {
        super.onCanceled(repairTickets);

        // At this point we can release the resources associated with 'repairTickets' if needed.
        onReleaseResources(repairTickets);
    }

    /**
     * Handles a request to completely reset the Loader.
     */
    @Override protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();

        // At this point we can release the resources associated with 'repairTickets' if needed.
        if (repairTickets != null) {
            onReleaseResources(repairTickets);
            repairTickets = null;
        }
    }

    /**
     * Helper function to take care of releasing resources associated
     * with an actively loaded data set.
     */
    protected void onReleaseResources(List<RepairTicket> repairTickets) {

    }
}
