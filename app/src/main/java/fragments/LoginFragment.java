package fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment3_SadikshyaShres.DashboardActivity;
import com.example.assignment3_SadikshyaShres.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText etUsername1, etPassword1;
    private Button btnLogin;
    public EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUsername1 = view.findViewById(R.id.etUsername1);
        etPassword1 = view.findViewById(R.id.etPassword1);
        btnLogin =view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
    UserLogin();
    }

    public void UserLogin(){

        SharedPreferences sharedPreferences =this.getActivity().getSharedPreferences("Details", Context.MODE_PRIVATE);
        String Username = sharedPreferences.getString("Username", "");
        String Password = sharedPreferences.getString("Password", "");
        
        if(Username.equals(etUsername1.getText().toString()) && Password.equals(etPassword1.getText().toString())){
            Toast.makeText(this.getActivity(), "Succesfully Logged In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.getActivity(), DashboardActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(this.getActivity(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
        }

    }

}
