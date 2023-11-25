package com.example.edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
private EditText editTextRegisterFullName, editTextRegisterEmail,
        editTextRegisterDate, editTextRegisterSdt,
        editTextRegisterPass, editTextRegisterConfirmPass;
private ProgressBar progressBar;
private RadioGroup radioGroupGioiTinh;
private RadioButton radioButtonChonGioiTinh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Đăng ký");
        Toast.makeText(RegisterActivity.this,"bạn có thể đăng ký!", Toast.LENGTH_LONG).show();

        editTextRegisterFullName =findViewById(R.id.edittext_register_full_name);
        editTextRegisterEmail =findViewById(R.id.edittext_register_email);
        editTextRegisterDate=findViewById(R.id.edittext_register_date);
                editTextRegisterSdt=findViewById(R.id.edittext_register_sdt);
        editTextRegisterPass=findViewById(R.id.edittext_register_pass);
                editTextRegisterConfirmPass=findViewById(R.id.edittext_register_confirm_pass);



                //Radio
        radioGroupGioiTinh=findViewById(R.id.radio_group_register_gioitinh);
        radioGroupGioiTinh.clearCheck();
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

}
            }


        });
    }
}