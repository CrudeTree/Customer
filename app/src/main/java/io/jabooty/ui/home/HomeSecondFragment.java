package io.jabooty.ui.home;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import android.widget.TextView.OnEditorActionListener;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import io.jabooty.R;
import java.util.ArrayList;

public class HomeSecondFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home_second, container, false);
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    String myArg = HomeSecondFragmentArgs.fromBundle(getArguments()).getMyArg();
    final ListView listView = view.findViewById(R.id.listView);
    final TextView textView = view.findViewById(R.id.textview_home_second);
    final ArrayList<String> arrayList = new ArrayList<String>();
    final EditText editText = view.findViewById(R.id.editText);

    view.findViewById(R.id.button_home_second).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        NavHostFragment.findNavController(HomeSecondFragment.this)
            .navigate(R.id.action_HomeSecondFragment_to_HomeFragment);
      }
    });

    editText.setOnEditorActionListener(new OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(!editText.getText().toString().equals("")){
          editText.setText("");
          arrayList.add(editText.getText().toString());
        }
        //TODO Add arrayList values to a scrolling list to be displayed in the app.
        return false;
      }
    });
  }
}
