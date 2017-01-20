package com.proppop.mobile.android.fragments.models;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.proppop.mobile.android.Databasemanager;
import com.proppop.mobile.android.R;

import java.util.ArrayList;

/**
 * Created by animal@martus.org on 9/30/16.
 */

public class RepairTicketDetailsFragment extends Fragment {

    private Spinner prioritySpinner;
    public RepairTicketDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repair_ticket_details, container, false);

        Button createTicketButton = (Button) view.findViewById(R.id.done_new_repair_ticket);
        createTicketButton.setOnClickListener(new CreateTicketHandler());

        Button cancelCreateTicketButton = (Button) view.findViewById(R.id.cancel_create_repair_ticket);
        cancelCreateTicketButton.setOnClickListener(new CancelNewTicketHandler());

        prioritySpinner = (Spinner) view.findViewById(R.id.prioritySpinner);
        ArrayList<ChoiceItem> priorityChoices = new PriorityQuestion().getChoices();
        ArrayAdapter<ChoiceItem> dataAdapter = new ArrayAdapter<ChoiceItem>(getActivity(), android.R.layout.simple_dropdown_item_1line, priorityChoices);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(dataAdapter);

        return view;
    }

    private void createRepairTicket() {
        EditText repairTicketDescription = (EditText) getView().findViewById(R.id.repair_ticket_description);

        ChoiceItem selectedItem = (ChoiceItem) prioritySpinner.getSelectedItem();
        Databasemanager.addRepairTicket(new RepairTicket(getUid(), getUid(), repairTicketDescription.getText().toString(), selectedItem.getCode()));
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    private void closeFragment() {
        getActivity().getFragmentManager().popBackStack();
    }

    public class CreateTicketHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            createRepairTicket();
            closeFragment();
        }
    }

    public class CancelNewTicketHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            closeFragment();
        }
    }
}
