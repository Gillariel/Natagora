package al.helmo.com.natamobile.fragment.login;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.LoginActivity;
import al.helmo.com.natamobile.model.APIUtils;
import al.helmo.com.natamobile.model.User;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    private EditText edtUsername, edtName, edtForname, edtEmail, edtPassword, edtPasswordRep ;
    private UserService userService;
    private LoginActivity loginActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Button register = (Button) view.findViewById(R.id.btnRegister);
        edtUsername = (EditText) view.findViewById(R.id.edtRegisterUsername);
        edtName = (EditText) view.findViewById(R.id.edtRegisterName);
        edtForname = (EditText) view.findViewById(R.id.edtRegisterForname);
        edtEmail = (EditText) view.findViewById(R.id.edtRegisterEmail);
        edtPassword = (EditText) view.findViewById(R.id.edtRegisterPassword);
        edtPasswordRep = (EditText) view.findViewById(R.id.edtRegisterPasswordCheck);
        userService = APIUtils.getUserService();
        loginActivity = (LoginActivity)getActivity();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtEmail.getText().toString().equals("")
                        && !edtUsername.getText().toString().equals("")
                        && !edtPasswordRep.getText().toString().equals("")
                        && !edtPassword.getText().toString().equals("")
                        && !edtForname.getText().toString().equals("")
                        && !edtName.getText().toString().equals("")){
                    if(edtPassword.getText().toString().equals(edtPasswordRep.getText().toString())){
                        User u = new User(0, edtUsername.getText().toString(), edtName.getText().toString(),edtForname.getText().toString(),edtEmail.getText().toString(),edtPassword.getText().toString());
                        Call<Void> call = userService.postNewUser(APIUtils.KEYAPI, "application/json", u);
                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() >= 200 && response.code() <= 205){
                                    Toast.makeText(getActivity(), "Registration Successful",Toast.LENGTH_SHORT).show();
                                    LogInFragment fragment = new LogInFragment();
                                    fragment.setUsername(edtUsername.getText().toString());
                                    fragment.setPassword(edtPassword.getText().toString());
                                    loginActivity.getFragmentHandler().replaceLogFragment(fragment, getFragmentManager());
                                }
                            }
                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(getActivity(), t.getMessage() ,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        Toast.makeText(getActivity(), "Passwords are not the same",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "All fields must be filled ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
