package fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment3_SadikshyaShres.R;


public class RegistrationFragment extends Fragment implements View.OnClickListener {

    private EditText etFullname, etAddress, etUsername, etPassword, etCoPassword;
    private Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        etFullname = view.findViewById(R.id.etFullname);
        etAddress = view.findViewById(R.id.etAddress);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etCoPassword = view.findViewById(R.id.etCoPassword);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(etPassword.getText().toString().equals(etCoPassword.getText().toString())){
            UserRegister();
        } else {
            Toast.makeText(this.getActivity(), "Error While Registering", Toast.LENGTH_SHORT).show();
        }
    }

    public void UserRegister(){

        SharedPreferences sharedPreferences =this.getActivity().getSharedPreferences("Details", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Fullname", etFullname.getText().toString());
        editor.putString("Address", etAddress.getText().toString());
        editor.putString("Username", etUsername.getText().toString());
        editor.putString("Password", etPassword.getText().toString());
        editor.putString("Confirm Password", etCoPassword.getText().toString());
        editor.commit();

        Toast.makeText(this.getActivity(), "Registered Succesfully", Toast.LENGTH_SHORT).show();



    }
}
