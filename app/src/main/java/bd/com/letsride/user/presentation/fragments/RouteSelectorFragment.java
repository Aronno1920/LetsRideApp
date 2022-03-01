package bd.com.letsride.user.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import bd.com.letsride.user.R;
import bd.com.letsride.user.utilities.BaseFragment;

public class RouteSelectorFragment extends BaseFragment {

    Spinner spinnerZoneFrom;
    Spinner spinnerZoneTo;
    AutoCompleteTextView autocompleteFrom;
    AutoCompleteTextView autocompleteTo;

    public RouteSelectorFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route_selector, container, false);

        spinnerZoneFrom = view.findViewById(R.id.SpinnerZoneFrom);
        spinnerZoneTo = view.findViewById(R.id.SpinnerZoneTo);
        autocompleteFrom = (AutoCompleteTextView)view.findViewById(R.id.autoCompletePickup);
        autocompleteTo = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteDropoff);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.select_dialog_item, arr);
        //autocomplete.setThreshold(2);
        autocompleteFrom.setAdapter(adapter);
        autocompleteTo.setAdapter(adapter);

        spinnerZoneFrom.setAdapter(adapter);
        spinnerZoneTo.setAdapter(adapter);

        return view;
    }

    String[] arr = { "Paries,France", "PA,United States","Parana,Brazil",
            "Padua,Italy", "Pasadena,CA,United States"};
}