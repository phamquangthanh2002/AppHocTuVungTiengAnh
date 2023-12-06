package com.example.edit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
private EditText editTextRegisterFullName, editTextRegisterEmail,
        editTextRegisterDate, editTextRegisterSdt,
        editTextRegisterPass, editTextRegisterConfirmPass;
private ProgressBar progressBar;
private RadioGroup radioGroupGioiTinh;
private RadioButton radioButtonChonGioiTinh;
private DatePickerDialog picker;
private static final String TAG="RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Đăng ký");
        Toast.makeText(RegisterActivity.this,"bạn có thể đăng ký!", Toast.LENGTH_LONG).show();
progressBar = findViewById(R.id.progressBar);
        editTextRegisterFullName =findViewById(R.id.edittext_register_full_name);
        editTextRegisterEmail =findViewById(R.id.edittext_register_email);
        editTextRegisterDate=findViewById(R.id.edittext_register_date);
                editTextRegisterSdt=findViewById(R.id.edittext_register_sdt);
        editTextRegisterPass=findViewById(R.id.edittext_register_pass);
                editTextRegisterConfirmPass=findViewById(R.id.edittext_register_confirm_pass);



                //Radio
        radioGroupGioiTinh=findViewById(R.id.radio_group_register_gioitinh);
        radioGroupGioiTinh.clearCheck();

        //setup ô ngày sinh
        editTextRegisterDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                //Data picker dialog
                picker = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextRegisterDate.setText(dayOfMonth + "/" + (month+1) +"/"+year);
                    }
                },year, month, day );
                picker.show();
            }
        });


        Button buttonRegister =findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ChonGioiTinhId = radioGroupGioiTinh.getCheckedRadioButtonId();
                radioButtonChonGioiTinh =findViewById(ChonGioiTinhId);

                //nhập dữ liệu
                String textFullName =   editTextRegisterFullName.getText().toString();
                String textEmail =   editTextRegisterEmail.getText().toString();
                String textDate =   editTextRegisterDate.getText().toString();
                String textSdt =   editTextRegisterSdt.getText().toString();
                String textPass =   editTextRegisterPass.getText().toString();
                String textConfirm =   editTextRegisterConfirmPass.getText().toString();
String textGender;




if(TextUtils.isEmpty(textFullName)){
    Toast.makeText(RegisterActivity.this,"hãy nhập tên đầy đủ của bạn ",Toast.LENGTH_LONG).show();
    editTextRegisterFullName.setError("Họ và tên là bắt buộc");
    editTextRegisterFullName.requestFocus();
}else if(TextUtils.isEmpty(textEmail)){
    Toast.makeText(RegisterActivity.this,"hãy nhập email của bạn ",Toast.LENGTH_LONG).show();
    editTextRegisterEmail.setError("Email là bắt buộc");
    editTextRegisterEmail.requestFocus();
}else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
    Toast.makeText(RegisterActivity.this,"vui lòng nhập lại email  ",Toast.LENGTH_LONG).show();
    editTextRegisterEmail.setError("yêu cầu nhập email hợp lệ");
    editTextRegisterEmail.requestFocus();
}
else if(TextUtils.isEmpty(textDate)){
    Toast.makeText(RegisterActivity.this,"hãy nhập ngày sinh của bạn ",Toast.LENGTH_LONG).show();
    editTextRegisterDate.setError("ngày sinh là bắt buộc");
    editTextRegisterDate.requestFocus();
}else if(radioGroupGioiTinh.getCheckedRadioButtonId() == -1){
    Toast.makeText(RegisterActivity.this,"hãy chọn giới tính của bạn ",Toast.LENGTH_LONG).show();
    radioButtonChonGioiTinh.setError("giới tính là bắt buộc");
    radioButtonChonGioiTinh.requestFocus();
}else if(TextUtils.isEmpty(textSdt)){
    Toast.makeText(RegisterActivity.this,"hãy nhập số điện thoại của bạn ",Toast.LENGTH_LONG).show();
    editTextRegisterSdt.setError("số điện thoại là bắt buộc");
    editTextRegisterSdt.requestFocus();
}else if(textSdt.length()!=10){
    Toast.makeText(RegisterActivity.this,"vui lòng nhập lại số điện thoại ",Toast.LENGTH_LONG).show();
    editTextRegisterSdt.setError("số điện thoại phải 10 số");
    editTextRegisterSdt.requestFocus();
}else if(TextUtils.isEmpty(textPass)){
    Toast.makeText(RegisterActivity.this,"hãy nhập mật khẩu ",Toast.LENGTH_LONG).show();
    editTextRegisterPass.setError("mật khẩu là bắt buộc");
    editTextRegisterPass.requestFocus();
}else if(textPass.length() < 6){
    Toast.makeText(RegisterActivity.this,"mật khẩu của bạn nên lớn hơn 6 ký tự ",Toast.LENGTH_LONG).show();
    editTextRegisterPass.setError("mật khẩu của bạn quá yếu ");
    editTextRegisterPass.requestFocus();
}else if(TextUtils.isEmpty(textConfirm)){
    Toast.makeText(RegisterActivity.this,"hãy nhập lại mật khẩu ",Toast.LENGTH_LONG).show();
    editTextRegisterConfirmPass.setError("mật khẩu là bắt buộc");
    editTextRegisterConfirmPass.requestFocus();
}else if(!textPass.equals(textConfirm)){
    Toast.makeText(RegisterActivity.this,"hãy nhập mật khẩu ",Toast.LENGTH_LONG).show();
    editTextRegisterConfirmPass.setError("mật khẩu không chính xác");
    editTextRegisterConfirmPass.requestFocus();

    editTextRegisterPass.clearComposingText();
    editTextRegisterConfirmPass.clearComposingText();
}else{
    textGender = radioButtonChonGioiTinh.getText().toString();
    progressBar.setVisibility(View.VISIBLE);
registerUser(textFullName, textEmail, textDate, textGender, textSdt, textPass );
}
            }


        });
    }

    private void registerUser(String textFullName, String textEmail, String textDate, String textGender, String textSdt, String textPass) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(textEmail, textPass).addOnCompleteListener(RegisterActivity.this,

                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){


    FirebaseUser firebaseUser = auth.getCurrentUser();
    //dữ liệu người dùng trong realtimedatabase

    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textFullName).build();

    firebaseUser.updateProfile(profileChangeRequest);


    ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textDate, textGender, textSdt);

    DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered Users");


    referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if(task.isSuccessful()){

                Toast.makeText(RegisterActivity.this, "User registered successfully. pls xác nhận email",
                        Toast.LENGTH_LONG).show();
                firebaseUser.sendEmailVerification();

  /*  Intent intent = new Intent (RegisterActivity.this, UserProfileActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
    finish(); */
            }else
            {
                Toast.makeText(RegisterActivity.this, "User registered không thành công",
                        Toast.LENGTH_LONG).show();

            }
            progressBar.setVisibility(View.GONE);

        }
    });

}else{
    try{
throw task.getException();
    }catch(FirebaseAuthWeakPasswordException e){
        editTextRegisterPass.setError("mật khẩu của bạn quá yếu");
        editTextRegisterPass.requestFocus();
    }catch(FirebaseAuthInvalidCredentialsException e){
        editTextRegisterPass.setError("email của bạn không hợp lệ");
        editTextRegisterPass.requestFocus();
    }catch(FirebaseAuthUserCollisionException e){
        editTextRegisterPass.setError("email hoặc user đã được sử dụng");
        editTextRegisterPass.requestFocus();
    }catch (Exception e){
        Log.e(TAG, e.getMessage());
        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

    }
    progressBar.setVisibility(View.GONE);

}
                    }
                });
    }

}