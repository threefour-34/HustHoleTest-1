package com.example.hustholetest1.view.registerandlogin.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hustholetest1.model.EditTextReaction;
import com.example.hustholetest1.network.RequestInterface;
import com.example.hustholetest1.network.TokenInterceptor;
import com.example.hustholetest1.R;
import com.example.hustholetest1.network.OkHttpUtil;
import com.githang.statusbar.StatusBarCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SetPasswordActivity extends AppCompatActivity {
    private TextView textView1;
    private EditText editText1;
    private CheckBox checkBox1;
    private Button button1;
    private ImageView back;
   // private String loginemail;
    private Retrofit retrofit;
    private RequestInterface request;
    private static final String TAG = "RegisterActivity";


    private static final String emailkey="key_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpassword);
        StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.GrayScale_100) , true);

        textView1=(TextView)findViewById(R.id.tv_setpassword_warn);
        editText1=(EditText)findViewById(R.id.et_setpassword);
        checkBox1=(CheckBox)findViewById(R.id.ck_setpassword_checkBox);
        button1=(Button)findViewById(R.id.btn_setpassword_jumptohomescreen);
        back= (ImageView) findViewById(R.id.iv_titlebarwhite_back);
        textView1.setVisibility(View.INVISIBLE);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        SpannableString string1 = new SpannableString(this.getResources().getString(R.string.login_password_2));
        EditTextReaction.EditTextSize(editText1,string1,14);
        EditTextReaction.ButtonReaction(editText1,button1);
        editText1.setTransformationMethod(new PasswordTransformationMethod());
        button1.setEnabled(false);

        //loginemail=getIntent().getStringExtra(emailkey);

        TokenInterceptor.getContext(SetPasswordActivity.this);
        System.out.println("?????????context");
        retrofit = new Retrofit.Builder()
                .baseUrl("http://hustholetest.pivotstudio.cn/api/auth/")
                .client(OkHttpUtil.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request = retrofit.create(RequestInterface.class);//??????????????????
    }
    public void onClick(View v){
        Intent intent;
        String email=getIntent().getStringExtra(emailkey);
        String password=editText1.getText().toString();
        switch (v.getId()) {

            case R.id.ck_setpassword_checkBox://??????/????????????
                if(checkBox1.isChecked()){
                    checkBox1.setText(getString(R.string.login_password_6));
                    editText1.setTransformationMethod(null);
                }else{
                    checkBox1.setText(getString(R.string.login_password_3));
                    editText1.setTransformationMethod(new PasswordTransformationMethod());
                }
                break;
            case R.id.iv_titlebarwhite_back://?????????
                finish();
                break;
            case R.id.btn_setpassword_jumptohomescreen://??????

                if(true) {//???????????????????????????????????????
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HashMap map = new HashMap();
                            map.put("email", email);
                            map.put("password", password);
                            // map.put("something", someobject);
                            // FormBody.Builder builder = new FormBody.Builder();
                            //builder.add("key","value");

                            Call<ResponseBody> call = request.register(map);//????????????

                            Log.e(TAG, "token2???");


                            call.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    String json = "null";
                                    try {
                                        if(response.body() != null){
                                            json = response.body().string();
                                        }
                                        System.out.println("cccccc");


                                    } catch (IOException e) {
                                        Log.e(TAG, "token2???9999999");
                                        e.printStackTrace();

                                    }
                                    System.out.println("???:" + json);
                                    String condition=null;
                                    try {

                                        JSONObject jsonObject = new JSONObject(json);
                                        //??????
                                        System.out.println("ddddddd");
                                        condition = jsonObject.getString("msg");
                                        String token = jsonObject.getString("token");
                                        Log.e(TAG, "conditon"+condition);
                                        System.out.println("token????????????:" + token);

                                        SharedPreferences.Editor editor = getSharedPreferences("Depository", Context.MODE_PRIVATE).edit();//???????????????
                                        editor.putString("token", token);
                                        editor.commit();//????????????
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                    //Toast.makeText(RegisterActivity.this, "????????????", Toast.LENGTH_SHORT).show();
                                    //finish();

                                    if (condition!=null&&condition.equals("????????????")) {//??????????????????????????????
                                        //???????????????????????????
                                        showResponse("????????????");
                                        Intent intent = new Intent(SetPasswordActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    } else {
                                        showResponse("??????????????????");
                                        //?????????????????????????????????????????????
                                    }

                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable tr) {
                                    Log.e(TAG, "sw.toString()");
                                    if (tr == null) {

                                    }
                                    // This is to reduce the amount of log spew that apps do in the non-error
                                    // condition of the network being unavailable.
                                    Throwable t = tr;
                                    while (t != null) {
                                        if (t instanceof UnknownHostException) {

                                        }
                                        t = t.getCause();
                                    }
                                    StringWriter sw = new StringWriter();
                                    PrintWriter pw = new PrintWriter(sw);
                                    tr.printStackTrace(pw);
                                    pw.flush();

                                    Log.e(TAG, sw.toString());
                                }

                            });




                        }
                    }).start();




                }else{
                    showResponse("????????????????????????????????????");
                    Log.d("TAG","jjjjjj3");
                    // Toast.makeText(RegisterActivity.this, "????????????????????????????????????", Toast.LENGTH_SHORT).show();
                }




                if(true){//??????????????????????????????
                    //????????????????????????????????????????????????
                    //intent=new Intent(Login2Activity.this, HomePageActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);;
                    //startActivity(intent);
                }else{
                   //??????????????????????????????

                }





                break;
            default:
                break;
        }
    }

    public  void showResponse(final String condition){
        runOnUiThread(new Runnable(){
            @Override
            public void run(){
                Toast.makeText(SetPasswordActivity.this, condition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Intent newIntent(Context packageContext, String email){
        Intent intent = new Intent(packageContext, SetPasswordActivity.class);
        intent.putExtra(emailkey,email);
        return intent;
    }
}
