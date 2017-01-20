package com.proppop.mobile.android.fragments.models;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.proppop.mobile.android.Databasemanager;
import com.proppop.mobile.android.R;

/**
 * Created by animal@martus.org on 9/27/16.
 */

public class RepairTicketsListActivity extends Fragment
{
    private FirebaseRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_repair_tickets_recycler, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();

        mAdapter = new FirebaseRecyclerAdapter<RepairTicket, RepairTicketViewHolder>(RepairTicket.class, R.layout.repair_tickets_list_row, RepairTicketViewHolder.class, Databasemanager.getRepairTicketsReference())
        {
            @Override
            public void populateViewHolder(RepairTicketViewHolder chatMessageViewHolder, RepairTicket repairTicket, int position)
            {
                String description = repairTicket.getDescription();
                chatMessageViewHolder.descriptionTextView.setText(description);

                String statusCode = repairTicket.getStatusCode();
                String statusLabel = new StatusQuestion().findStatusLabel(statusCode);
                chatMessageViewHolder.statusTextView.setText(statusLabel);
            }
        };

        mRecyclerView.setAdapter(mAdapter);
    }

    private static class RepairTicketViewHolder extends RecyclerView.ViewHolder
    {
        private TextView descriptionTextView;
        private TextView statusTextView;

        public RepairTicketViewHolder(View itemView)
        {
            super(itemView);

            descriptionTextView = (TextView) itemView.findViewById(R.id.description);
            statusTextView = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
