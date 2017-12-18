package com.pcsalt.example.customalertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pcsalt.example.customalertdialog.dimmer_library.ShaderSeekArc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean flag1 = false;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;

    NumberPicker np, np1, np2, np3, np5, np6, np7, np8, np9;
    Button sunday, monday, tuesday, wednesday, thusday, friday, saturday, setoperation, timerlist, settimer;
    TextView tvon, tvoff, tvvv,label;
    CheckBox  cb_rgb, cb_switch21,cb_switch51,cb_switch251,cb_switch351,cb_switch451,cb_dimmer,cb_curtain,cb_projector,cb_pir,cb_bell,cb_dog,cb_geyser,cb_sprinkler,cb_ac,cb_doorlock;
    LinearLayout repeat;
    ArrayList aa,aa1,aa2;
    String name,name1,name2;
    ListView mtv;
    Button flash, fade, strobe, smooth;
    TextView tvspeed;
    SeekBar brightness;
    Context context;
    RadioButton rb1,rb2,rb3,rb_reppattern;
    LinearLayout ld1,ld2,ld3,ld4,ld5,ld6;
    View alertLayout;
    Button colorview;
    int color_bright;
    Object fsfs_speed, tvspeed1,color_fsfs;
    Integer rrr, ggg, bbb;
    private Button save,cancel;
    private String fsfs;
    int nnp1;
    int nnp2;
    int nnp3;
    int nnp4;
    int nnp5;
    int nnp6;
    int nnp7;
    int nnp8;
    int nnp9;
    int a, b, c, d, e, f, g;
    String fromtime, totime,zero,zero1,abcd,repdata,pushtype,one, two, three, four,check1;
    String nnnp1, nnnp2, nnnp3, nnnp4, nnnp5, nnnp6, nnnp7;
    private String responseBody;
    private String r;
    private String switch_data;
    Button s1,s2,s3,s4,s5,fan_dec,fan_inc;
    Spinner  fan_speed;
    private String fanspeed;
    private String switch_onoff;
     ArrayList<Object> bulbon;
    private String rep_weekly;
    private String alert_msg;
    private String device_name;
    private String num_switch;
    private String off_data;
    private String on_data;
    private String xyz;
    private String device_type;
    private String devnum;
    private String roomnum;
    List ar_num_switch = new ArrayList();
    List ar_off_data = new ArrayList();
    List ar_on_data = new ArrayList();
    private String resp;
    private String[] numbers;
    private String[] displayedValues,displayedValues2;
    private String choosenValue,choosenValue2;
    private String rrrr,gggg,bbbb;
    private ShaderSeekArc seekArc;
    ImageView i;
    private String dim_brightness;
    private Button bthigh,btlow,btmedium,btopen,btstop,btclose,btopen_sheer,btclose_sheer,btstop_sheer,btopen_curtain,btclose_curtain,btstop_curtain;
    private String cur_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_list);
        cb_rgb = (CheckBox) findViewById(R.id.cb_rgb);
        cb_switch21 = (CheckBox) findViewById(R.id.cb_switch21);
        cb_switch51 = (CheckBox) findViewById(R.id.cb_switch51);
        cb_switch251 = (CheckBox) findViewById(R.id.cb_switch251);
        cb_switch351 = (CheckBox) findViewById(R.id.cb_switch351);
        cb_switch451 = (CheckBox) findViewById(R.id.cb_switch451);
        cb_dimmer = (CheckBox) findViewById(R.id.cb_dimmer);
        cb_curtain= (CheckBox) findViewById(R.id.cb_curtain);
        cb_projector= (CheckBox) findViewById(R.id.cb_projector);
        cb_pir= (CheckBox) findViewById(R.id.cb_pir);
        cb_bell= (CheckBox) findViewById(R.id.cb_bell);
        cb_dog= (CheckBox) findViewById(R.id.cb_dog);
        cb_geyser= (CheckBox) findViewById(R.id.cb_geyser);
        cb_sprinkler= (CheckBox) findViewById(R.id.cb_sprinkler);
        cb_ac= (CheckBox) findViewById(R.id.cb_ac);
        cb_doorlock= (CheckBox) findViewById(R.id.cb_doorlock);


        cb_switch21.setOnClickListener(this);
        cb_switch51.setOnClickListener(this);
        cb_switch251.setOnClickListener(this);
        cb_switch351.setOnClickListener(this);
        cb_switch451.setOnClickListener(this);
        cb_rgb.setOnClickListener(this);
        cb_dimmer.setOnClickListener(this);
        cb_curtain.setOnClickListener(this);
        cb_projector.setOnClickListener(this);
        cb_pir.setOnClickListener(this);

        cb_bell.setOnClickListener(this);
        cb_dog.setOnClickListener(this);
        cb_geyser.setOnClickListener(this);
        cb_sprinkler.setOnClickListener(this);
        cb_ac.setOnClickListener(this);
        cb_doorlock.setOnClickListener(this);
        context=this;
        //mtv= (ListView) findViewById(R.id.mtv);

        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox1", false);
        cb_switch21.setChecked(checked);

        boolean checked2 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox1", false);
        cb_switch51.setChecked(checked2);
    }


    @Override
    public void onClick(View view) {
        if (view == cb_rgb) {
            if (cb_rgb.isChecked()) {
                rgb();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (view == cb_switch21) {

            if (cb_switch21.isChecked()) {
               switch_data="switch21";
                roomnum="01";
                switch51();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (view == cb_switch51) {
            if (cb_switch51.isChecked()) {
               switch_data="switch51";
                roomnum="01";
                devnum="1";
                switch51();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_switch251) {
            if (cb_switch251.isChecked()) {
                switch_data="switch251";
                roomnum="01";
                devnum="4";
                switch51();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_switch351) {
            if (cb_switch351.isChecked()) {
                switch_data="switch351";
                roomnum="01";
                devnum="5";
                switch51();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_switch451) {
            if (cb_switch451.isChecked()) {
                switch_data="switch451";
                roomnum="01";
                devnum="6";
                switch51();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_dimmer) {
            if (cb_dimmer.isChecked()) {
                //switch_data="switch51";
                dimmer();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_curtain) {
            if (cb_curtain.isChecked()) {
                //switch_data="switch51";
                curtain();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_projector) {
            if (cb_projector.isChecked()) {
                //switch_data="switch51";
                projector();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_pir) {
            if (cb_pir.isChecked()) {
                //switch_data="switch51";
                pir();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_bell) {
            if (cb_bell.isChecked()) {
                //switch_data="switch51";
                bell();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_dog) {
            if (cb_dog.isChecked()) {
                //switch_data="switch51";
                dog();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_geyser) {
            if (cb_geyser.isChecked()) {
                //switch_data="switch51";
                geyser();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_sprinkler) {
            if (cb_sprinkler.isChecked()) {
                //switch_data="switch51";
                sprinkler();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_ac) {
            if (cb_ac.isChecked()) {
                //switch_data="switch51";
                ac();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
        else if (view == cb_doorlock) {
            if (cb_doorlock.isChecked()) {
                //switch_data="switch51";
                doorlock();
            }
            else{
                flag2=false;
                flag1=false;
                flag3=false;
                flag4=false;
            }
        }
    }

    private void doorlock() {
        roomnum="01";
        device_name="Dlk";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);


        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
        ar_num_switch.add("1");
        ar_off_data.add("001000000101" + "201" + "000000000000000");
        ar_on_data.add("001000000101" + "301" + "000000000000000");
    }

    private void ac() {
        roomnum="01";
        device_name="AC";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_doorlock.setChecked(false);


        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
        ar_num_switch.add("1");
        ar_off_data.add("001000000101" + "201" + "000000000000000");
        ar_on_data.add("001000000101" + "301" + "000000000000000");
    }

    private void sprinkler() {
        roomnum="01";
        device_name="SPR";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_ac.setChecked(false);
        cb_doorlock.setChecked(false);


        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
        ar_num_switch.add("1");
        ar_off_data.add("001000000101" + "201" + "000000000000000");
        ar_on_data.add("001000000101" + "301" + "000000000000000");
    }

    private void geyser() {
        roomnum="01";
        device_name="GEY";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_doorlock.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
        ar_num_switch.add("1");
        ar_off_data.add("001000000101" + "201" + "000000000000000");
        ar_on_data.add("001000000101" + "301" + "000000000000000");
    }

    private void dog() {
        roomnum="01";
        device_name="DOG";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_geyser.setChecked(false);
        cb_doorlock.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
        ar_num_switch.add("1");
        ar_off_data.add("001000000101" + "201" + "000000000000000");
        ar_on_data.add("001000000101" + "301" + "000000000000000");
    }

    private void bell() {
        roomnum="01";
        device_name="BELL";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_doorlock.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
        ar_num_switch.add("1");
        ar_off_data.add("001000000101" + "201" + "000000000000000");
        ar_on_data.add("001000000101" + "301" + "000000000000000");
    }

    private void pir() {
        roomnum="01";
        device_name="PIR";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_switch251.setChecked(false);
        cb_projector.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);
        cb_doorlock.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);
    }

    private void projector() {
        roomnum="01";
        device_name="PRO";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_switch251.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);
        cb_doorlock.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setAlpha(0);

        /*setoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertLayout = inflater1.inflate(R.layout.curtain_popup, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(TimerActivity.this, R.style.MyDialogTheme1);

                alert.setView(alertLayout);
                alert.setCancelable(true);
                final AlertDialog dialog1 = alert.create();
                dialog1.setTitle("       ");
                dialog1.show();

                save = (Button) alertLayout.findViewById(R.id.save);
                cancel = (Button) alertLayout.findViewById(R.id.cancel);

                btopen = (Button) alertLayout.findViewById(R.id.btopen);
                btclose = (Button) alertLayout.findViewById(R.id.btclose);
                btstop = (Button) alertLayout.findViewById(R.id.btstop);

                btopen_sheer = (Button) alertLayout.findViewById(R.id.btopen_sheer);
                btclose_sheer = (Button) alertLayout.findViewById(R.id.btclose_sheer);
                btstop_sheer = (Button) alertLayout.findViewById(R.id.btstop_sheer);

                btopen_curtain = (Button) alertLayout.findViewById(R.id.btopen_curtain);
                btclose_curtain = (Button) alertLayout.findViewById(R.id.btclose_curtain);
                btstop_curtain = (Button) alertLayout.findViewById(R.id.btstop_curtain);


                //  dialog1.getWindow().setLayout(400,450);
                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.45);
                dialog1.getWindow().setLayout(width, height);
                dialog1.show();;


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        *//*devnum = "7";
                        device_type="020";
                        ar_num_switch.add(0);
                        ar_on_data.add("001000000" + devnum + "01"+"201000000000000000" + ";" + "001000000" + devnum + "01" +"112"+ dim_brightness +"000000000000");
                        ar_off_data.add("001000000701301000000000000000");*//*
                        dialog1.dismiss();
                    }
                });
            }
        });*/
    }

    private void curtain() {
        roomnum="01";
        device_name="CUR";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);
        cb_doorlock.setChecked(false);


        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertLayout = inflater1.inflate(R.layout.curtain_popup, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(TimerActivity.this, R.style.MyDialogTheme1);

                alert.setView(alertLayout);
                alert.setCancelable(true);
                final AlertDialog dialog1 = alert.create();
                dialog1.setTitle("       ");
                dialog1.show();

                save = (Button) alertLayout.findViewById(R.id.save);
                cancel = (Button) alertLayout.findViewById(R.id.cancel);

                btopen = (Button) alertLayout.findViewById(R.id.btopen);
                btclose = (Button) alertLayout.findViewById(R.id.btclose);
                btstop = (Button) alertLayout.findViewById(R.id.btstop);

                btopen_sheer = (Button) alertLayout.findViewById(R.id.btopen_sheer);
                btclose_sheer = (Button) alertLayout.findViewById(R.id.btclose_sheer);
                btstop_sheer = (Button) alertLayout.findViewById(R.id.btstop_sheer);

                btopen_curtain = (Button) alertLayout.findViewById(R.id.btopen_curtain);
                btclose_curtain = (Button) alertLayout.findViewById(R.id.btclose_curtain);
                btstop_curtain = (Button) alertLayout.findViewById(R.id.btstop_curtain);


                //  dialog1.getWindow().setLayout(400,450);
                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.45);
                dialog1.getWindow().setLayout(width, height);
                dialog1.show();;

                btopen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      cur_status="101";
                    }
                });
                btstop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="103";
                    }
                });
                btclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="102";
                    }
                });

                btopen_sheer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="101";
                    }
                });
                btstop_sheer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="103";
                    }
                });
                btclose_sheer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="102";
                    }
                });

                btopen_curtain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="101";
                    }
                });
                btstop_curtain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="103";
                    }
                });
                btclose_curtain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cur_status="102";
                    }
                });


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*devnum = "7";
                        device_type="020";
                        ar_num_switch.add(0);
                        ar_on_data.add("001000000" + devnum + "01"+"201000000000000000" + ";" + "001000000" + devnum + "01" +"112"+ dim_brightness +"000000000000");
                        ar_off_data.add("001000000701301000000000000000");*/
                        dialog1.dismiss();
                    }
                });

            }
        });
    }

    public void dimmer() {

        roomnum="01";
        device_name="DMR";
        // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_rgb.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);
        cb_doorlock.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertLayout = inflater1.inflate(R.layout.dimmer_timer_popup, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(TimerActivity.this, R.style.MyDialogTheme1);

                alert.setView(alertLayout);
                alert.setCancelable(true);
                final AlertDialog dialog1 = alert.create();
                dialog1.show();

                save = (Button) alertLayout.findViewById(R.id.save);
                cancel = (Button) alertLayout.findViewById(R.id.cancel);
                bthigh = (Button) alertLayout.findViewById(R.id.bthigh);
                btmedium = (Button) alertLayout.findViewById(R.id.btmedium);
                btlow = (Button) alertLayout.findViewById(R.id.btlow);

                seekArc = (ShaderSeekArc) alertLayout.findViewById(R.id.seek_arc);
                i = (ImageView) alertLayout.findViewById(R.id.image);
                i.setImageResource(R.drawable.b1);

                bthigh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dim_brightness="255";
                        i.setImageResource(R.drawable.b9);
                        seekArc.setProgress(9);
                    }
                });
                btmedium.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dim_brightness="041";
                        i.setImageResource(R.drawable.b5);
                        seekArc.setProgress(5);
                    }
                });
                btlow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dim_brightness="002";
                        i.setImageResource(R.drawable.b1);
                        seekArc.setProgress(1);
                    }
                });


                seekArc.setOnSeekArcChangeListener(new ShaderSeekArc.OnSeekArcChangeListener() {

                    @Override
                    public void onProgressChanged(ShaderSeekArc seekArc, float progress) {

                        if (seekArc.getProgress() >= 1 && seekArc.getProgress() < 2) {
                            i.setImageResource(R.drawable.b1);
                            dim_brightness="014";
                            // tv.setText("SeekBar progress 1st division");

                        }
                        if (seekArc.getProgress() >= 2 && seekArc.getProgress() < 3) {
                            i.setImageResource(R.drawable.b2);
                            dim_brightness="016";
                            //  tv.setText("SeekBar progress 2 division");

                        }
                        if (seekArc.getProgress() >= 3 && seekArc.getProgress() < 4) {
                            i.setImageResource(R.drawable.b3);
                            dim_brightness= "035";
                            //  tv.setText("SeekBar progress 3 division");

                        }
                        if (seekArc.getProgress() >= 4 && seekArc.getProgress() < 5) {
                            i.setImageResource(R.drawable.b4);
                            dim_brightness="071";
                            // tv.setText("SeekBar progress 4 division");

                        }
                        if (seekArc.getProgress() >= 5 && seekArc.getProgress() < 6) {
                            i.setImageResource(R.drawable.b5);
                            dim_brightness="099";
                            //  tv.setText("SeekBar progress 5 division");

                        }
                        if (seekArc.getProgress() >= 6 && seekArc.getProgress() < 7) {
                            i.setImageResource(R.drawable.b6);
                            dim_brightness="155";
                            //   tv.setText("SeekBar progress 6 division");

                        }
                        if (seekArc.getProgress() >= 7 && seekArc.getProgress() < 8) {
                            i.setImageResource(R.drawable.b7);
                            dim_brightness="204";
                            //  tv.setText("SeekBar progress 7 division");

                        }
                        if (seekArc.getProgress() >= 8 && seekArc.getProgress() <= 9) {
                            i.setImageResource(R.drawable.b8);
                            dim_brightness="225";
                            //  tv.setText("SeekBar progress 8 division");

                        }

                        if (seekArc.getProgress() >= 9 && seekArc.getProgress() <= 10) {
                            i.setImageResource(R.drawable.b9);
                            dim_brightness="255";
                            //  tv.setText("SeekBar progress 9 division");

                        }


                        Log.d("TAG", "progress " + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(ShaderSeekArc seekArc) {

                        //  ShaderSeekArc sa= new ShaderSeekArc( context, attrs);

                        Log.d("TAG", "onStartTrackingTouch");
                    }

                    @Override
                    public void onStopTrackingTouch(ShaderSeekArc seekArc) {


                        //     finalI.setImageResource(R.drawable.a1);


                        Log.d("TAG", "onStopTrackingTouch");
                    }
                });




                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.40);
                dialog1.getWindow().setLayout(width, height);
                dialog1.show();;


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        devnum = "7";
                        device_type="020";
                        ar_num_switch.add(0);
                        ar_on_data.add("001000000" + devnum + "01"+"201000000000000000" + ";" + "001000000" + devnum + "01" +"112"+ dim_brightness +"000000000000");
                        ar_off_data.add("001000000701301000000000000000");
                        dialog1.dismiss();
                    }
                });



            }
        });
    }

    public  void switch51() {

        device_type="011";
       // devnum="1";
       // roomnum="01";
        if(switch_data.equals("switch51")) {
            cb_rgb.setChecked(false);
            cb_switch21.setChecked(false);
            cb_switch251.setChecked(false);
            cb_switch351.setChecked(false);
            cb_switch451.setChecked(false);
            cb_dimmer.setChecked(false);
            cb_curtain.setChecked(false);
            cb_projector.setChecked(false);
            cb_pir.setChecked(false);
            cb_bell.setChecked(false);
            cb_dog.setChecked(false);
            cb_geyser.setChecked(false);
            cb_sprinkler.setChecked(false);
            cb_ac.setChecked(false);
            cb_doorlock.setChecked(false);

        }
        else  if(switch_data.equals("switch21")) {
            cb_rgb.setChecked(false);
            cb_switch51.setChecked(false);
            cb_switch251.setChecked(false);
            cb_switch351.setChecked(false);
            cb_switch451.setChecked(false);
            cb_dimmer.setChecked(false);
            cb_curtain.setChecked(false);
            cb_projector.setChecked(false);
            cb_pir.setChecked(false);
            cb_bell.setChecked(false);
            cb_dog.setChecked(false);
            cb_geyser.setChecked(false);
            cb_sprinkler.setChecked(false);
            cb_ac.setChecked(false);
            cb_doorlock.setChecked(false);

        }
        if(switch_data.equals("switch251")) {
            cb_rgb.setChecked(false);
            cb_switch21.setChecked(false);
            cb_switch51.setChecked(false);
            cb_switch351.setChecked(false);
            cb_switch451.setChecked(false);
            cb_dimmer.setChecked(false);
            cb_curtain.setChecked(false);
            cb_projector.setChecked(false);
            cb_pir.setChecked(false);
            cb_bell.setChecked(false);
            cb_dog.setChecked(false);
            cb_geyser.setChecked(false);
            cb_sprinkler.setChecked(false);
            cb_ac.setChecked(false);
            cb_doorlock.setChecked(false);

        }
        if(switch_data.equals("switch351")) {
            cb_rgb.setChecked(false);
            cb_switch21.setChecked(false);
            cb_switch51.setChecked(false);
            cb_switch251.setChecked(false);
            cb_switch451.setChecked(false);
            cb_dimmer.setChecked(false);
            cb_curtain.setChecked(false);
            cb_projector.setChecked(false);
            cb_pir.setChecked(false);
            cb_bell.setChecked(false);
            cb_dog.setChecked(false);
            cb_geyser.setChecked(false);
            cb_sprinkler.setChecked(false);
            cb_ac.setChecked(false);
            cb_doorlock.setChecked(false);

        }
        if(switch_data.equals("switch451")) {
            cb_rgb.setChecked(false);
            cb_switch21.setChecked(false);
            cb_switch51.setChecked(false);
            cb_switch251.setChecked(false);
            cb_switch351.setChecked(false);
            cb_dimmer.setChecked(false);
            cb_curtain.setChecked(false);
            cb_projector.setChecked(false);
            cb_pir.setChecked(false);
            cb_bell.setChecked(false);
            cb_dog.setChecked(false);
            cb_geyser.setChecked(false);
            cb_sprinkler.setChecked(false);
            cb_ac.setChecked(false);
            cb_doorlock.setChecked(false);

        }
        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);


        setoperation.setOnClickListener(new View.OnClickListener() {
            public AlertDialog dialog1;
            public String sone,stwo,sthree,sfour,sfive;
            public View alertLayout1;

            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();


   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Switch5+1
                if(switch_data.equals("switch51")|| switch_data.equals("switch251")|| switch_data.equals("switch351")|| switch_data.equals("switch451")) {
                     device_name="S051";
                    alertLayout1 = inflater.inflate(R.layout.switch51_new_popup, null);
                    s1 = (Button) alertLayout1.findViewById(R.id.s1);
                    s2 = (Button) alertLayout1.findViewById(R.id.s2);
                    s3 = (Button) alertLayout1.findViewById(R.id.s3);
                    s4 = (Button) alertLayout1.findViewById(R.id.s4);
                    s5 = (Button) alertLayout1.findViewById(R.id.s5);
                    fan_dec = (Button) alertLayout1.findViewById(R.id.fan_dec);
                    fan_inc = (Button) alertLayout1.findViewById(R.id.fan_inc);
                    fan_speed = (Spinner) alertLayout1.findViewById(R.id.fan_speed);
                  //  TextView tvv = (TextView) alertLayout1.findViewById(R.id.tv);
                    save = (Button) alertLayout1.findViewById(R.id.save);
                    cancel = (Button) alertLayout1.findViewById(R.id.cancel);

                    final String[] str = {"0", "1", "2", "3", "4", "5"};
                    ArrayAdapter<String> adp2 = new ArrayAdapter<>(alertLayout.getRootView().getContext(), R.layout.spinner_item, str);
                    adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    fan_speed.setAdapter(adp2);

                    bulbon = new ArrayList<>();




                    s1.setTag(0);
                    s2.setTag(0);
                    s3.setTag(0);
                    s4.setTag(0);
                    s5.setTag(0);
                    s1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s1.setBackgroundResource(R.drawable.bulb02);
                                view.setTag(1);
                                s1.setTag(1);
                                sone="201";
                                bulbon.add(sone);
                            } else {
                                s1.setBackgroundResource(R.drawable.bulb01);
                                view.setTag(0);
                                s1.setTag(0);
                                //switch_onoff="301";
                                bulbon.remove(sone);
                            }
                          //  Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));
                        }
                    });

                    s2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s2.setBackgroundResource(R.drawable.high_volt_bulb01);
                                view.setTag(1);
                                s2.setTag(1);
                                stwo="202";
                                bulbon.add(stwo);
                            } else {
                                s2.setBackgroundResource(R.drawable.high_volt_bulb);
                                view.setTag(0);
                                s2.setTag(0);
                                //switch_onoff="302";
                                bulbon.remove(stwo);
                            }
                         //   Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));

                        }
                    });
                    s3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s3.setBackgroundResource(R.drawable.bulb02);
                                view.setTag(1);
                                s3.setTag(1);
                                sthree="203";
                                bulbon.add(sthree);
                            } else {
                                s3.setBackgroundResource(R.drawable.bulb01);
                                view.setTag(0);
                                s3.setTag(0);
                                //switch_onoff="303";
                                bulbon.remove(sthree);
                            }
                           // Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));

                        }
                    });
                    s4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s4.setBackgroundResource(R.drawable.bulb02);
                                view.setTag(1);
                                s4.setTag(1);
                                sfour="204";
                                bulbon.add(sfour);
                            } else {
                                s4.setBackgroundResource(R.drawable.bulb01);
                                view.setTag(0);
                                s4.setTag(0);
                               // switch_onoff="304";
                                bulbon.remove(sfour);
                            }
                           // Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));

                        }
                    });
                    s5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s5.setBackgroundResource(R.drawable.high_volt_bulb01);
                                view.setTag(1);
                                s5.setTag(1);
                                sfive="205";
                                bulbon.add(sfive);
                            } else {
                                s5.setBackgroundResource(R.drawable.high_volt_bulb);
                                view.setTag(0);
                                s5.setTag(0);
                               // switch_onoff="305";
                                bulbon.remove(sfive);
                            }
                           // Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));

                        }
                    });

                    fan_speed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (i == 0) {
                                fanspeed = "0";
                                //bulbon.add("71");
                            } else if (i == 1) {
                                fanspeed = "1";
                                bulbon.add("71");
                            } else if (i == 2) {
                                fanspeed = "2";
                                bulbon.add("71");
                            } else if (i == 3) {
                                fanspeed = "3";
                                bulbon.add("71");
                            } else if (i == 4) {
                                fanspeed = "4";
                                bulbon.add("71");
                            } else if (i == 5) {
                                fanspeed = "5";
                                bulbon.add("71");
                            }
                         Log.d("TAG",fanspeed);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (bulbon != null && bulbon.size()>0) {
                            for (Object area : bulbon) {
                                if (area.equals("201")) {
                                    num_switch = "1";
                                    off_data = "301";
                                    on_data="201";

                                    ar_num_switch.add(1);
                                    ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                    ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                } else if (area.equals("202")) {
                                    num_switch = "2";
                                    off_data = "302";
                                    on_data="202";

                                    ar_num_switch.add(2);
                                    ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                    ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                } else if (area.equals("203")) {
                                    num_switch = "3";
                                    off_data = "303";
                                    on_data="203";

                                    ar_num_switch.add(3);
                                    ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                    ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                } else if (area.equals("204")) {
                                    num_switch = "4";
                                    off_data = "304";
                                    on_data="204";

                                    ar_num_switch.add(4);
                                    ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                    ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                } else if (area.equals("205")) {
                                    num_switch = "5";
                                    off_data = "305";
                                    on_data="205";

                                    ar_num_switch.add(5);
                                    ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                    ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                } else if (area.equals("71")) {
                                    num_switch = "98";
                                    off_data = "723";
                                    on_data="71" + fanspeed;

                                    ar_num_switch.add(num_switch);
                                    ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                    ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                }
                            }
                               //abcd= "001000000101" + on_data + "000000000000000";
                                //xyz="001000000101" + off_data + "000000000000000";
                            }
                            else {
                                Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                            }
                           dialog1.dismiss();

                        }
                    });
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog1.dismiss();

                        }
                    });
                }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Switch2+1
                else  if(switch_data.equals("switch21")) {
                    device_name="S021";
                    alertLayout1 = inflater.inflate(R.layout.switch_21_popup_new, null);


                    s1 = (Button) alertLayout1.findViewById(R.id.s1);
                    s2 = (Button) alertLayout1.findViewById(R.id.s2);
                  /*  s3 = (Button) alertLayout1.findViewById(R.id.s3);
                    s4 = (Button) alertLayout1.findViewById(R.id.s4);
                    s5 = (Button) alertLayout1.findViewById(R.id.s5);
                    fan_dec = (Button) alertLayout1.findViewById(R.id.fan_dec);
                    fan_inc = (Button) alertLayout1.findViewById(R.id.fan_inc);*/
                    fan_speed = (Spinner) alertLayout1.findViewById(R.id.fan_speed);
                    //  TextView tvv = (TextView) alertLayout1.findViewById(R.id.tv);
                    save = (Button) alertLayout1.findViewById(R.id.save);
                    cancel = (Button) alertLayout1.findViewById(R.id.cancel);

                    final String[] str = {"0", "1", "2", "3", "4", "5"};
                    ArrayAdapter<String> adp2 = new ArrayAdapter<>(alertLayout.getRootView().getContext(), R.layout.spinner_item, str);
                    adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    fan_speed.setAdapter(adp2);

                    bulbon = new ArrayList<>();



                    s1.setTag(0);
                    s2.setTag(0);
                   /* s3.setTag(0);
                    s4.setTag(0);
                    s5.setTag(0);*/
                    s1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s1.setBackgroundResource(R.drawable.bulb02);
                                view.setTag(1);
                                s1.setTag(1);
                                sone="201";
                                bulbon.add(sone);
                            } else {
                                s1.setBackgroundResource(R.drawable.bulb01);
                                view.setTag(0);
                                s1.setTag(0);
                                //switch_onoff="301";
                                bulbon.remove(sone);
                            }
                            //  Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));
                        }
                    });

                    s2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (view.getTag().equals(0)) {
                                s2.setBackgroundResource(R.drawable.bulb02);
                                view.setTag(1);
                                s2.setTag(1);
                                stwo="202";
                                bulbon.add(stwo);
                            } else {
                                s2.setBackgroundResource(R.drawable.bulb01);
                                view.setTag(0);
                                s2.setTag(0);
                                //switch_onoff="302";
                                bulbon.remove(stwo);
                            }
                            //   Log.d("TAG",switch_onoff);
                            Log.d("TAG", String.valueOf(bulbon));

                        }
                    });

                    fan_speed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (i == 0) {
                                fanspeed = "0";
                              //  bulbon.add("0");
                            } else if (i == 1) {
                                fanspeed = "1";
                                bulbon.add("71");
                            } else if (i == 2) {
                                fanspeed = "2";
                                bulbon.add("71");
                            } else if (i == 3) {
                                fanspeed = "3";
                                bulbon.add("71");
                            } else if (i == 4) {
                                fanspeed = "4";
                                bulbon.add("71");
                            } else if (i == 5) {
                                fanspeed = "5";
                                bulbon.add("71");
                            }
                            Log.d("TAG",fanspeed);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });


                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                          //  abcd= "001000000101" + on_data + "000000000000000";
                          //  xyz="001000000101" + off_data + "000000000000000";

                            if (bulbon != null && bulbon.size()>0) {
                                for (Object area : bulbon) {
                                    if (area.equals("201")) {
                                        num_switch = "1";
                                        off_data = "301";
                                        on_data = "201";

                                        ar_num_switch.add(1);
                                        ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                        ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                    } else if (area.equals("202")) {
                                        num_switch = "2";
                                        off_data = "302";
                                        on_data = "202";

                                        ar_num_switch.add(num_switch);
                                        ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                        ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                    } else if (area.equals("71")) {
                                        num_switch = "98";
                                        off_data = "723";
                                        on_data = "71" + fanspeed;

                                        ar_num_switch.add(num_switch);
                                        ar_off_data.add("001000000"+ devnum +"01" + off_data + "000000000000000");
                                        ar_on_data.add("001000000"+ devnum +"01" + on_data + "000000000000000");
                                    }
                                }

                        }
                            else {
                                Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                            }
                            dialog1.dismiss();

                        }
                    });
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog1.dismiss();

                        }
                    });
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(TimerActivity.this, R.style.MyDialogTheme1);
                //  alert.setTitle("Login");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout1);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(true);

               dialog1 = alert.create();
                dialog1.show();
                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
                dialog1.getWindow().setLayout(width, height);
                dialog1.show();

            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //RGB

    public void rgb() {

       // roomnum="03";
        roomnum="01";
        device_name="RGB";
       // bulbon.add("");
        cb_switch21.setChecked(false);
        cb_switch51.setChecked(false);
        cb_switch251.setChecked(false);
        cb_switch351.setChecked(false);
        cb_dimmer.setChecked(false);
        cb_curtain.setChecked(false);
        cb_projector.setChecked(false);
        cb_pir.setChecked(false);
        cb_bell.setChecked(false);
        cb_dog.setChecked(false);
        cb_geyser.setChecked(false);
        cb_sprinkler.setChecked(false);
        cb_ac.setChecked(false);
        cb_doorlock.setChecked(false);

        final LayoutInflater inflater1 = getLayoutInflater();
        timersetting(inflater1);
        setoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertLayout = inflater1.inflate(R.layout.rgb_popup_new, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(TimerActivity.this, R.style.MyDialogTheme1);

                alert.setView(alertLayout);
                alert.setCancelable(true);
                final AlertDialog dialog1 = alert.create();
                dialog1.show();
                Button c1 = (Button) alertLayout.findViewById(R.id.c1);
                Button c2 = (Button) alertLayout.findViewById(R.id.c2);
                Button c3 = (Button) alertLayout.findViewById(R.id.c3);
                Button c4 = (Button) alertLayout.findViewById(R.id.c4);
                Button c5 = (Button) alertLayout.findViewById(R.id.c5);
                Button c6 = (Button) alertLayout.findViewById(R.id.c6);
                Button c7 = (Button) alertLayout.findViewById(R.id.c7);
                Button c8 = (Button) alertLayout.findViewById(R.id.c8);
                Button c9 = (Button) alertLayout.findViewById(R.id.c9);
                Button c10 = (Button) alertLayout.findViewById(R.id.c10);
                Button c11 = (Button) alertLayout.findViewById(R.id.c11);
                Button c12 = (Button) alertLayout.findViewById(R.id.c12);

                save = (Button) alertLayout.findViewById(R.id.save);
                cancel = (Button) alertLayout.findViewById(R.id.cancel);
                colorview = (Button) alertLayout.findViewById(R.id.colorview);

                final Button btup = (Button) alertLayout.findViewById(R.id.up);
                final Button btdown = (Button) alertLayout.findViewById(R.id.down);
                tvspeed = (TextView) alertLayout.findViewById(R.id.tvspeed);
                brightness = (SeekBar) alertLayout.findViewById(R.id.brightness);
                flash = (Button) alertLayout.findViewById(R.id.flash);
                strobe = (Button) alertLayout.findViewById(R.id.strobe);
                fade = (Button) alertLayout.findViewById(R.id.fade);
                smooth = (Button) alertLayout.findViewById(R.id.smooth);
                brightness.setMax(10);

                brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress,
                                                  boolean fromUser) {

                        // colorview.setText(String.valueOf(progress));

                        if (progress == 1) {
                            color_bright = 131;
                        } else if (progress == 2) {
                            color_bright = 132;
                        } else if (progress == 3) {
                            color_bright = 133;
                            // colorview.setText(String.valueOf(color_bright));
                        } else if (progress == 4) {
                            color_bright = 134;
                        } else if (progress == 5) {
                            color_bright = 135;
                        } else if (progress == 6) {
                            color_bright = 136;
                        } else if (progress == 7) {
                            color_bright = 137;
                        } else if (progress == 8) {
                            color_bright = 138;
                        } else if (progress == 9) {
                            color_bright = 139;
                        } else if (progress == 10) {
                            color_bright = 140;
                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#F9F600"));
                        colorview.setText("");

                        disableflashstrobe();
                    }
                });
                c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#FEBE50"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#F7913C"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });

                c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#F3703C"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#EA1D24"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#9F0064"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#892891"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#5F6EB3"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#0293D4"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#009F8B"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#51B747"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });
                c12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        colorview.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        colorview.setText("");
                        disableflashstrobe();

                    }
                });


                flash.setTag(0);
                flash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view.getTag().equals(0)) {
                            flash.setBackgroundResource(R.drawable.flash01);
                            strobe.setBackgroundResource(R.drawable.strobe);
                            fade.setBackgroundResource(R.drawable.fade);
                            smooth.setBackgroundResource(R.drawable.smooth);
                            colorview.setBackgroundResource(R.drawable.indicator_background);
                            // view.setTag(1);

                            String fls = "FLASH";
                            colorview.setText(fls);
                        } else {
                            flash.setBackgroundResource(R.drawable.flash);
                            //view.setTag(0);
                        }
                    }
                });

                strobe.setTag(0);
                strobe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view.getTag().equals(0)) {

                            strobe.setBackgroundResource(R.drawable.strobe01);
                            // view.setTag(1);
                            flash.setBackgroundResource(R.drawable.flash);
                            fade.setBackgroundResource(R.drawable.fade);

                            smooth.setBackgroundResource(R.drawable.smooth);
                            colorview.setBackgroundResource(R.drawable.indicator_background);
                            String str = "STROBE";
                            colorview.setText(str);
                        } else {
                            strobe.setBackgroundResource(R.drawable.strobe);
                            // view.setTag(0);
                        }
                    }
                });

                fade.setTag(0);
                fade.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view.getTag().equals(0)) {
                            fade.setBackgroundResource(R.drawable.fade01);
                            flash.setBackgroundResource(R.drawable.flash);
                            strobe.setBackgroundResource(R.drawable.strobe);
                            smooth.setBackgroundResource(R.drawable.smooth);
                            colorview.setBackgroundResource(R.drawable.indicator_background);
                            //   view.setTag(1);
                            String fad = "FADE";
                            colorview.setText(fad);
                        } else {
                            fade.setBackgroundResource(R.drawable.fade);
                            // view.setTag(0);
                        }
                    }
                });

                smooth.setTag(0);
                smooth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view.getTag().equals(0)) {
                            smooth.setBackgroundResource(R.drawable.smooth01);
                            strobe.setBackgroundResource(R.drawable.strobe);
                            flash.setBackgroundResource(R.drawable.flash);
                            fade.setBackgroundResource(R.drawable.fade);
                            colorview.setBackgroundResource(R.drawable.indicator_background);
                            // view.setTag(1);
                            String fls = "SMOOTH";
                            colorview.setText(fls);
                        } else {
                            smooth.setBackgroundResource(R.drawable.smooth);
                            //view.setTag(0);
                        }
                    }
                });

                final int[] count = {0};
                btup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btup.setEnabled(true);
                        count[0]++;
                        if (count[0] == 0) {
                            tvspeed.setBackgroundResource(R.drawable.spzero);
                            // tvspeed.setTag(0);
                        } else if (count[0] == 1) {
                            tvspeed.setBackgroundResource(R.drawable.spone);

                            tvspeed.setTag(1);
                        } else if (count[0] == 2) {
                            tvspeed.setBackgroundResource(R.drawable.sptwo);
                            tvspeed.setTag(2);
                        } else if (count[0] == 3) {
                            tvspeed.setBackgroundResource(R.drawable.spthree);
                            tvspeed.setTag(3);
                        } else if (count[0] == 4) {
                            tvspeed.setBackgroundResource(R.drawable.spfour);
                            tvspeed.setTag(4);
                        } else if (count[0] == 5) {
                            tvspeed.setBackgroundResource(R.drawable.spfive);
                            tvspeed.setTag(5);
                        } else if (count[0] == 6) {
                            tvspeed.setBackgroundResource(R.drawable.spsix);
                            tvspeed.setTag(6);
                        } else if (count[0] == 7) {
                            tvspeed.setBackgroundResource(R.drawable.spseven);
                            tvspeed.setTag(7);
                        } else if (count[0] == 8) {
                            tvspeed.setBackgroundResource(R.drawable.speight);
                            tvspeed.setTag(8);
                        } else if (count[0] == 9) {
                            tvspeed.setBackgroundResource(R.drawable.spnine);
                            tvspeed.setTag(9);
                        } else if (count[0] == 10) {
                            tvspeed.setBackgroundResource(R.drawable.spten);
                            tvspeed.setTag(10);
                        } else if (count[0] == 11) {
                            btup.setEnabled(false);
                            count[0]--;
                        }


                        //tvspeed.setText(String.valueOf(count[0]));
                        btup.setEnabled(true);

                    }
                });

                btdown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btdown.setEnabled(true);
                        count[0]--;

                        if (count[0] == -1) {
                            btdown.setEnabled(false);
                            count[0]++;
                        } else if (count[0] == 0) {
                            tvspeed.setBackgroundResource(R.drawable.spzero);
                            tvspeed.setTag(0);
                        } else if (count[0] == 1) {
                            tvspeed.setBackgroundResource(R.drawable.spone);
                            tvspeed.setTag(1);
                        } else if (count[0] == 2) {
                            tvspeed.setBackgroundResource(R.drawable.sptwo);
                            tvspeed.setTag(2);
                        } else if (count[0] == 3) {
                            tvspeed.setBackgroundResource(R.drawable.spthree);
                            tvspeed.setTag(3);
                        } else if (count[0] == 4) {
                            tvspeed.setBackgroundResource(R.drawable.spfour);
                            tvspeed.setTag(4);
                        } else if (count[0] == 5) {
                            tvspeed.setBackgroundResource(R.drawable.spfive);
                            tvspeed.setTag(5);
                        } else if (count[0] == 6) {
                            tvspeed.setBackgroundResource(R.drawable.spsix);
                            tvspeed.setTag(6);
                        } else if (count[0] == 7) {
                            tvspeed.setBackgroundResource(R.drawable.spseven);
                            tvspeed.setTag(7);
                        } else if (count[0] == 8) {
                            tvspeed.setBackgroundResource(R.drawable.speight);
                            tvspeed.setTag(8);
                        } else if (count[0] == 9) {
                            tvspeed.setBackgroundResource(R.drawable.spnine);
                            tvspeed.setTag(9);
                        } else if (count[0] == 10) {
                            tvspeed.setBackgroundResource(R.drawable.spten);
                            tvspeed.setTag(10);
                        }
                        btdown.setEnabled(true);
                    }

                });

               // dialog1.getWindow().setLayout(400, 450);
                //dialog1.show();;

                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.40);
                dialog1.getWindow().setLayout(width, height);
                dialog1.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CharSequence z = colorview.getText();
                        if (z.equals("")) {
                            fsfs_speed ="000";
                            int color ;
                            Drawable background = colorview.getBackground();
                            if (background instanceof ColorDrawable) {
                                color = ((ColorDrawable) background).getColor();
                                Integer intColor = color;
                                String hexColor = "#" + Integer.toHexString(intColor).substring(2);
                                rrr = Integer.valueOf(hexColor.substring(1, 3), 16);
                                ggg = Integer.valueOf(hexColor.substring(3, 5), 16);
                                bbb = Integer.valueOf(hexColor.substring(5, 7), 16);

                                if(rrr<=9)
                                {
                                     rrrr = "00" + rrr;
                                }
                                else if(rrr>9 && rrr<=99)
                                {
                                    rrrr= "0"+rrr;
                                }
                                else {
                                    rrrr= String.valueOf(rrr);
                                }

                                if(ggg<=9)
                                {
                                    gggg= "00"+ggg;
                                }
                                else if(ggg>9 && ggg<=99)
                                {
                                    gggg="0"+ggg;
                                }
                                else {
                                    gggg= String.valueOf(ggg);
                                }

                                if(bbb<=9)
                                {
                                    bbbb= "00"+bbb;
                                }
                                else if(bbb>9 && bbb<=99)
                                {
                                    bbbb="0"+bbb;
                                }
                                else {
                                    bbbb= String.valueOf(bbb);
                                }

                                color_fsfs = "112";
                                int m = brightness.getProgress();
                                if (m == 1) {
                                    color_bright = 131;
                                } else if (m == 2) {
                                    color_bright = 132;
                                } else if (m == 3) {
                                    color_bright = 133;
                                    // colorview.setText(String.valueOf(color_bright));
                                } else if (m == 4) {
                                    color_bright = 134;
                                } else if (m == 5) {
                                    color_bright = 135;
                                } else if (m == 6) {
                                    color_bright = 136;
                                } else if (m == 7) {
                                    color_bright = 137;
                                } else if (m == 8) {
                                    color_bright = 138;
                                } else if (m == 9) {
                                    color_bright = 139;
                                } else if (m == 10) {
                                    color_bright = 140;
                                }

                            }
                            devnum = "4";
                            // num_switch="0";
                            device_type="021";
                            //abcd = "001000000" + devnum + "03"+"102000000000000000" + ";" + "001000000" + devnum + "03" + color_fsfs + rrr + ggg + bbb + "000000;" + "001000000" + devnum + "03" + color_bright + "000000000000000;" + "001000000" + devnum + "03" + fsfs_speed + "000000000000000";
                            // xyz="001000000403103000000000000000";


                            ar_num_switch.add(0);
                            ar_on_data.add("001000000" + devnum + roomnum+"102000000000000000" + ";" + "001000000" + devnum + "03" + color_fsfs + rrrr+ gggg + bbbb + "000000;" + "001000000" + devnum + "03" + color_bright + "000000000000000;" + "001000000" + devnum + "03" + fsfs_speed + "000000000000000");
                            ar_off_data.add("001000000"+devnum+roomnum+"103000000000000000");
                        } else {
                            CharSequence fs = colorview.getText();
                            if (fs.equals("FLASH")) {
                                fsfs = "104";
                            } else if (fs.equals("STROBE")) {
                                fsfs = "105";
                            } else if (fs.equals("FADE")) {
                                fsfs = "106";
                            } else if (fs.equals("SMOOTH")) {
                                fsfs = "107";
                            }

                            color_fsfs = fsfs;
                            rrrr = "0";
                            gggg = "0";
                            bbbb = "0";


                            int m = brightness.getProgress();
                            if (m == 1) {
                                color_bright = 131;
                            } else if (m == 2) {
                                color_bright = 132;
                            } else if (m == 3) {
                                color_bright = 133;
                                // colorview.setText(String.valueOf(color_bright));
                            } else if (m == 4) {
                                color_bright = 134;
                            } else if (m == 5) {
                                color_bright = 135;
                            } else if (m == 6) {
                                color_bright = 136;
                            } else if (m == 7) {
                                color_bright = 137;
                            } else if (m == 8) {
                                color_bright = 138;
                            } else if (m == 9) {
                                color_bright = 139;
                            } else if (m == 10) {
                                color_bright = 140;
                            }


                            tvspeed1 = tvspeed.getTag();
                            //  Drawable ggggg = colorview.getBackground();
                            if (tvspeed1.equals(0)) {
                                fsfs_speed = "120";
                            }
                            if (tvspeed1.equals(1)) {
                                fsfs_speed = "121";
                            } else if (tvspeed1.equals(2)) {
                                fsfs_speed = "122";
                            } else if (tvspeed1.equals(3)) {
                                fsfs_speed = "123";
                            } else if (tvspeed1.equals(4)) {
                                fsfs_speed = "124";
                            } else if (tvspeed1.equals(5)) {
                                fsfs_speed = "125";
                            } else if (tvspeed1.equals(6)) {
                                fsfs_speed = "126";
                            } else if (tvspeed1.equals(7)) {
                                fsfs_speed = "127";
                            } else if (tvspeed1.equals(8)) {
                                fsfs_speed = "128";
                            } else if (tvspeed1.equals(9)) {
                                fsfs_speed = "129";
                            } else if (tvspeed1.equals(10)) {
                                fsfs_speed = "130";
                            } else {
                                fsfs_speed = "000";
                            }
                            devnum = "4";
                            device_type="021";
                            ar_num_switch.add(0);
                            ar_on_data.add( "001000000" + devnum + roomnum+"102000000000000000" + ";" + "001000000" + devnum + "03" + color_fsfs + rrrr + gggg + bbbb + "000000;" + "001000000" + devnum + "03" + color_bright + "000000000000000;" + "001000000" + devnum + "03" + fsfs_speed + "000000000000000");
                            ar_off_data.add("001000000"+devnum+roomnum+"103000000000000000");

                            // abcd = "001000000" + devnum + "03"+"102000000000000000" + ";" + "001000000" + devnum + "03" + color_fsfs + rrr + ggg + bbb + "000000;" + "001000000" + devnum + "03" + color_bright + "000000000000000;" + "001000000" + devnum + "03" + fsfs_speed + "000000000000000";
                            //xyz="001000000403103000000000000000";

                            //repdata = fromtime + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + devname + "@" + abcd + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + repeaweekly + "@" + totime + "@" + offdatare ;
                        }
                        dialog1.dismiss();
                    }
                });



            }
        });
        //dialog.getWindow().setLayout(450, 650);
        // dialog.dismiss();
    }

    private void timersetting(LayoutInflater inflater1) {


        alertLayout = inflater1.inflate(R.layout.layout_custom_dialog, null);
        final TextView tv = (TextView) alertLayout.findViewById(R.id.tv1);
        tvon = (TextView) alertLayout.findViewById(R.id.tvon);
        tvoff = (TextView) alertLayout.findViewById(R.id.tvoff);
        tvvv = (TextView) alertLayout.findViewById(R.id.tv);
        repeat = (LinearLayout) alertLayout.findViewById(R.id.repeat_linear);
        sunday = (Button) alertLayout.findViewById(R.id.b1);
        monday = (Button) alertLayout.findViewById(R.id.b2);
        tuesday = (Button) alertLayout.findViewById(R.id.b3);
        wednesday = (Button) alertLayout.findViewById(R.id.b4);
        thusday = (Button) alertLayout.findViewById(R.id.b5);
        friday = (Button) alertLayout.findViewById(R.id.b6);
        saturday = (Button) alertLayout.findViewById(R.id.b7);
        setoperation = (Button) alertLayout.findViewById(R.id.setoperation);
        timerlist = (Button) alertLayout.findViewById(R.id.timerlist);
        settimer = (Button) alertLayout.findViewById(R.id.settimer);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        tv.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        rb1 = (RadioButton) alertLayout.findViewById(R.id.rb1);
        rb2 = (RadioButton) alertLayout.findViewById(R.id.rb2);
        rb3 = (RadioButton) alertLayout.findViewById(R.id.rb3);
        rb_reppattern = (RadioButton) alertLayout.findViewById(R.id.rb_reppattern);

        ld1 = (LinearLayout) alertLayout.findViewById(R.id.ld1);
        ld2 = (LinearLayout) alertLayout.findViewById(R.id.ld2);
        ld3 = (LinearLayout) alertLayout.findViewById(R.id.ld3);
        ld4 = (LinearLayout) alertLayout.findViewById(R.id.ld4);
        ld5 = (LinearLayout) alertLayout.findViewById(R.id.ld5);
        ld6 = (LinearLayout) alertLayout.findViewById(R.id.ld6);

        np = (NumberPicker) alertLayout.findViewById(R.id.numberPicker1);
        np1 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker2);
        np2 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker3);
        np3 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker4);
        np5 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker5);
        np6 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker6);
        np7 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker7);
        np8 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker8);
        np9 = (NumberPicker) alertLayout.findViewById(R.id.numberPicker9);

        tvvv.setMovementMethod(new ScrollingMovementMethod());
        sunday.setTag(0);
        monday.setTag(0);
        tuesday.setTag(0);
        wednesday.setTag(0);
        thusday.setTag(0);
        friday.setTag(0);
        saturday.setTag(0);


        AlertDialog.Builder alert = new AlertDialog.Builder(TimerActivity.this, R.style.MyDialogTheme);
        //  alert.setTitle("Login");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);

        final AlertDialog dialog = alert.create();
        dialog.show();

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.80);

        dialog.getWindow().setLayout(width, height);
        dialog.show();
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    sunday.setBackgroundResource(R.drawable.sun_sat_02);
                    view.setTag(1);
                } else {
                    sunday.setBackgroundResource(R.drawable.sun_sat_01);
                    view.setTag(0);
                }
            }
        });


        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    monday.setBackgroundResource(R.drawable.mon_02);
                    view.setTag(1);
                } else {
                    monday.setBackgroundResource(R.drawable.mon_01);
                    view.setTag(0);
                }
            }
        });


        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    tuesday.setBackgroundResource(R.drawable.tues_thur_02);
                    view.setTag(1);
                } else {
                    tuesday.setBackgroundResource(R.drawable.tues_thur_01);
                    view.setTag(0);
                }
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    wednesday.setBackgroundResource(R.drawable.wed_02);
                    view.setTag(1);
                } else {
                    wednesday.setBackgroundResource(R.drawable.wed_01);
                    view.setTag(0);
                }
            }
        });

        thusday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    thusday.setBackgroundResource(R.drawable.tues_thur_02);
                    view.setTag(1);
                } else {
                    thusday.setBackgroundResource(R.drawable.tues_thur_01);
                    view.setTag(0);
                }
            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    friday.setBackgroundResource(R.drawable.fri_02);
                    view.setTag(1);
                } else {
                    friday.setBackgroundResource(R.drawable.fri_01);
                    view.setTag(0);
                }
            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    saturday.setBackgroundResource(R.drawable.sun_sat_02);
                    view.setTag(1);
                } else {
                    saturday.setBackgroundResource(R.drawable.sun_sat_01);
                    view.setTag(0);
                }
            }
        });
        timerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TimerActivity.this, EditTime.class);
                startActivity(i);

            }
        });

        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb_reppattern.setEnabled(true);

        sunday.setEnabled(false);
        monday.setEnabled(false);
        tuesday.setEnabled(false);
        wednesday.setEnabled(false);
        thusday.setEnabled(false);
        friday.setEnabled(false);
        saturday.setEnabled(false);

        np5.setEnabled(false);
        np6.setEnabled(false);
        np7.setEnabled(false);
        np8.setEnabled(false);
        np9.setEnabled(false);
        rb_reppattern.setEnabled(false);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()) {
                    rb1();
                }
            }
        });


        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb2.isChecked()) {
                    rb2();
                }
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb3.isChecked()) {
                    rb3();
                }
            }
        });

        rb_reppattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_reppattern.isChecked()) {
                    rb4();
                }
            }
        });

        numberpicker();
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        settimer.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(final View view) {

                nnp1 = np.getValue();
                nnp2 = np1.getValue();
                if (nnp1 < 10) {
                    nnnp1 = "0" + nnp1;
                } else if (nnp1 >= 10) {
                    nnnp1 = String.valueOf(nnp1);
                }
                if (nnp2 < 10) {
                    nnnp2 = "0" + nnp2;
                } else if (nnp2 >= 10) {
                    nnnp2 = String.valueOf(nnp2);
                }

                nnp3 = np2.getValue();
                nnp4 = np3.getValue();
                if (nnp3 < 10) {
                    nnnp3 = "0" + nnp3;
                } else if (nnp3 >= 10) {
                    nnnp3 = String.valueOf(nnp3);
                }
                if (nnp4 < 10) {
                    nnnp4 = "0" + nnp4;
                } else if (nnp4 >= 10) {
                    nnnp4 = String.valueOf(nnp4);
                }

                fromtime = nnnp1 + ":" + nnnp2;
                totime = nnnp3 + ":" + nnnp4;

                if (!rb_reppattern.isChecked()) {
                    Calendar cal = Calendar.getInstance();
                    rep_weekly = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));
                }


                if (rb1.isChecked()) {

                    pushtype = "rep";
                    if (sunday.getTag().equals(1)) {
                        a = 1;
                    } else if (sunday.getTag().equals(0)) {
                        a = 0;
                    }
                    if (monday.getTag().equals(1)) {
                        b = 1;
                    } else if (monday.getTag().equals(0)) {
                        b = 0;
                    }
                    if (tuesday.getTag().equals(1)) {
                        c = 1;
                    } else if (tuesday.getTag().equals(0)) {
                        c = 0;
                    }
                    if (wednesday.getTag().equals(1)) {
                        d = 1;
                    } else if (wednesday.getTag().equals(0)) {
                        d = 0;
                    }
                    if (thusday.getTag().equals(1)) {
                        e = 1;
                    } else if (thusday.getTag().equals(0)) {
                        e = 0;
                    }
                    if (friday.getTag().equals(1)) {
                        f = 1;
                    } else if (friday.getTag().equals(0)) {
                        f = 0;
                    }
                    if (saturday.getTag().equals(1)) {
                        g = 1;
                    } else if (saturday.getTag().equals(0)) {
                        g = 0;
                    }

                  /*  if (color_fsfs != null && fsfs_speed != null) {

                        abcd = "001000000" + devicenum + roomnumber+"102000000000000000" + ";" + "001000000" + devicenum + roomnumber + color_fsfs + rrr + ggg + bbb + "000000;" + "001000000" + devicenum + roomnumber + color_bright + "000000000000000;" + "001000000" + devicenum + "01" + fsfs_speed + "000000000000000";
                        repdata = fromtime + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + devname + "@" + abcd + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + repeaweekly + "@" + totime + "@" + offdatare ;
                        Log.d("TAG"+"RGB CYC",String.valueOf(repdata));
                    } else {
                        Toast.makeText(view.getContext(), " Set operation", Toast.LENGTH_LONG).show();
                    }*/
                    if (bulbon != null && bulbon.size() > 0 || (color_fsfs != null && fsfs_speed != null)|| ar_on_data!=null) {
                        if (!(fromtime.equals(totime))) {
                            if (a != 0 || b != 0 || c != 0 || d != 0 || e != 0 || f != 0 || g != 0) {
                                for (int i = 0; i < ar_on_data.size(); i++) {
                                    repdata = fromtime + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + a + "@" + device_name + "@" + ar_on_data.get(i) + "@" + device_type + "@" + devnum + "@" + ar_num_switch.get(i) + "@" + roomnum + "@" + rep_weekly + "@" + totime + "@" + ar_off_data.get(i);
                                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                    StrictMode.setThreadPolicy(policy);
                                    postupdins();
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            } else {
                                Toast.makeText(view.getContext(), "Please select days", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(view.getContext(), "please Change TO time", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                    }

                } else if (rb2.isChecked()) {

                    rep_weekly = "0";

                    pushtype = "cyc";

                    // nnp5 =np5.getValue();
                    //nnp6 = np6.getValue();

                    choosenValue = displayedValues[np5.getValue()];
                    if (choosenValue.length()==1) {
                        nnnp5 = "0" + choosenValue;
                    } else   if (choosenValue.length()==2) {
                        nnnp5 = choosenValue;
                    }

                   /* if (nnp5 < 10) {
                        nnnp5 = "0" + nnp5;
                    } else if (nnp5 >= 10) {
                        nnnp5 = String.valueOf(nnp5);
                    }*/

                    choosenValue2 = displayedValues2[np6.getValue()];
                    if (choosenValue2.length()==1) {
                        nnnp6 = "0" + choosenValue2;
                    } else   if (choosenValue2.length()==2) {
                        nnnp6 = choosenValue2;
                    }

                    /*if (nnp6 < 10) {
                        nnnp6 = "0" + nnp6;
                    } else if (nnp6 >= 10) {
                        nnnp6 = String.valueOf(nnp6);
                    }*/
                    zero = "00:" + nnnp5;
                    zero1 = "00:" + nnnp6;

                   /* if (color_fsfs != null && fsfs_speed != null) {
                        abcd = "001000000" + devicenum +roomnumber+"102000000000000000" + ";" + "001000000" + devicenum + roomnumber + color_fsfs + rrr + ggg + bbb + "000000"+";" + "001000000" + devicenum + roomnumber + color_bright + "000000000000000"+";" + "001000000" + devicenum + roomnumber + fsfs_speed + "000000000000000";
                        repdata = fromtime + "@" + totime + "@" + zero + "@" + zero1 + "@" + fromtime + "@" + dateee + "@" + "1" + "@" + "0" + "@" + "0" + "@" + devname + "@" + abcd + "@" + offdatare + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + ont + "@" + offt;
                         Log.d("TAG"+"RGB CYC",String.valueOf(repdata));

                    } else {
                        Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                    }*/



                        if ((bulbon != null && bulbon.size() > 0) || (color_fsfs != null && fsfs_speed != null) || ar_on_data!=null) {

                            if (!(fromtime.equals(totime))) {

                            for (int i = 0; i < ar_on_data.size(); i++) {
                                repdata = fromtime + "@" + totime + "@" + zero + "@" + zero1 + "@" + fromtime + "@" + "0000-00-00" + "@" + "1" + "@" + "0" + "@" + "0" + "@" + device_name + "@" + ar_on_data.get(i) + "@" + ar_off_data.get(i) + "@" + device_type + "@" + devnum + "@" + ar_num_switch.get(i) + "@" + roomnum;
                                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                StrictMode.setThreadPolicy(policy);
                                postupdins();
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            }

                            } else {
                                Toast.makeText(view.getContext(), "Please Change TO time", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                        }


                } else if (rb3.isChecked()) {

                    pushtype = "repd";
                    nnp7 = np7.getValue();

                    if (nnp7 < 10) {
                        nnnp7 = "0" + nnp7;
                    } else if (nnp7 >= 10) {
                        nnnp7 = String.valueOf(nnp7);
                    }

                    nnp8 = np8.getValue();
                    nnp9 = np9.getValue();

                    r = nnp9 + "-" + nnp8 + "-" + nnnp7;


                       /* if (color_fsfs != null && fsfs_speed != null) {

                            abcd = "001000000" + devicenum + roomnumber + "102000000000000000" + ";" + "001000000" + devicenum + roomnumber + color_fsfs + rrr + ggg + bbb + "000000;" + "001000000" + devicenum + roomnumber + color_bright + "000000000000000;" + "001000000" + devicenum + roomnumber + fsfs_speed + "000000000000000";
                            repdata = fromtime + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + devname + "@" + abcd + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + repeaweekly + "@" + totime + "@" + offdatare + "@" + r + "@" + ont;
                        } else {
                            Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                        }*/


                        if ((bulbon != null && bulbon.size() > 0) || (color_fsfs != null && fsfs_speed != null) || ar_on_data!=null) {

                            if (!(fromtime.equals(totime))) {
                            for (int i = 0; i < ar_on_data.size(); i++) {
                                a = 0;
                                b = 0;
                                c = 0;
                                d = 0;
                                e = 0;
                                f = 0;
                                g = 0;
                                repdata = fromtime + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + a + "@" + device_name + "@" + ar_on_data.get(i) + "@" + device_type + "@" + devnum + "@" + ar_num_switch.get(i) + "@" + roomnum + "@" + rep_weekly + "@" + totime + "@" + ar_off_data.get(i) + "@" + r;
                                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                                StrictMode.setThreadPolicy(policy);
                                postupdins();
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            }
                    } else {
                        Toast.makeText(view.getContext(), "Please Change TO time", Toast.LENGTH_LONG).show();
                    }
                        } else {
                            Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                        }

                    //repdata = fromtime + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + "S051" + "@" + "001000000101204000000000000000" + "@" + "011" + "@" + "1" + "@" + "1" + "@" + "01" + "@" + "0" + "@" + totime + "@" + "001000000101304000000000000000" + "@" + r ;

                } else {
                    Toast.makeText(view.getContext(), "Set timer", Toast.LENGTH_LONG).show();
                }


                try {

                    if (ar_off_data.size() > 0 && ar_on_data.size() > 0 && ar_num_switch.size() > 0) {
                        // bulbon.clear();
                        ar_num_switch.clear();
                        ar_on_data.clear();
                        ar_off_data.clear();
                    } else if (bulbon.size() > 0 && bulbon != null) {
                        bulbon.clear();
                        ar_num_switch.clear();
                        ar_on_data.clear();
                        ar_off_data.clear();
                    }

                }
                catch (Exception e){
                    Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                }


                   final Handler handler = new Handler();
                   handler.postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           //Object j = tvvv.getText();
                           Object j = resp;
                           try {
                               if (j.equals("*UACK#")) {
                                   //Toast.makeText(view.getContext(),"Data updated successfully",Toast.LENGTH_LONG).show();

                                   alert_msg = "Data updated successfully";

                                   dialog.dismiss();
                                   AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                                   builder1.setTitle("INFO");
                                   builder1.setMessage(alert_msg);
                                   builder1.setCancelable(true);
                                   builder1.setNeutralButton(android.R.string.ok,
                                           new DialogInterface.OnClickListener() {
                                               public void onClick(DialogInterface dialog123, int id) {
                                                   dialog123.cancel();
                                                   tvvv.setText("");
                                                   resp = "";
                                               }
                                           });

                                   AlertDialog alert11 = builder1.create();
                                   alert11.show();

                               } else if (j.equals("*UNACK#")) {
                                   // Toast.makeText(view.getContext(),"Data not updated",Toast.LENGTH_LONG).show();
                                   alert_msg = "Data not updated";


                               } else if (j.equals("*EACK#")) {
                                   // Toast.makeText(view.getContext(),"Data already exits",Toast.LENGTH_LONG).show();
                                   alert_msg = "Data already exist";

                                   AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                                   builder1.setTitle("INFO");
                                   builder1.setMessage(alert_msg);
                                   builder1.setCancelable(true);
                                   builder1.setNeutralButton(android.R.string.ok,
                                           new DialogInterface.OnClickListener() {
                                               public void onClick(DialogInterface dialog123, int id) {
                                                   dialog123.cancel();
                                                   tvvv.setText("");
                                                   resp = "";
                                               }
                                           });

                                   AlertDialog alert11 = builder1.create();
                                   alert11.show();

                               } else if (j.equals("*IACK#")) {
                                   // Toast.makeText(view.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                                   alert_msg = "Data inserted successfully";

                                   AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                                   builder1.setTitle("INFO");
                                   builder1.setMessage(alert_msg);
                                   builder1.setCancelable(true);
                                   builder1.setNeutralButton(android.R.string.ok,
                                           new DialogInterface.OnClickListener() {
                                               public void onClick(DialogInterface dialog123, int id) {
                                                   dialog123.cancel();
                                                   tvvv.setText("");
                                                   resp = "";
                                               }
                                           });

                                   AlertDialog alert11 = builder1.create();
                                   alert11.show();

                                   //  dialog.dismiss();

                               } else {
                                   tvvv.setText("");
                                   resp = "";
                               }
                           } catch (Exception e) {
                               // writing exception to log
                               e.printStackTrace();

                           }

                       }
                   }, 900);
               }
        });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();

                    }
                });

    }

    private void postupdins() {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        List<NameValuePair> nameValuePair = null;

        httpClient = new DefaultHttpClient();
        //Olimax ip
        httpPost = new HttpPost("http://192.168.0.204/settimer.php");

        //EBBackup ip
       // httpPost = new HttpPost("http://192.168.1.101/settimer1.php");
        String trdata = repdata;
        nameValuePair = new ArrayList<>(5);
        nameValuePair.add(new BasicNameValuePair("trdata", trdata));
        nameValuePair.add(new BasicNameValuePair("type", pushtype));
        nameValuePair.add(new BasicNameValuePair("status", "ins"));
        nameValuePair.add(new BasicNameValuePair("user", "admin12345"));
        nameValuePair.add(new BasicNameValuePair("pass", "12345678"));


        // Url Encoding the POST parameters
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        // Making HTTP Request
        try {
            final HttpResponse response = httpClient.execute(httpPost);


            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseBody = EntityUtils.toString(entity);

                /*JSONObject j = new JSONObject(responseBody);
                responseBody = j.getString("data");*/

                Log.d("TAG", "Http post Response: " + responseBody);
            }
            Log.d("TAG", responseBody);

            final String finalResponseBody = responseBody;

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resp=finalResponseBody;
                    tvvv.setText(finalResponseBody);



                }
            });
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();

        } /*catch (JSONException e) {
            e.printStackTrace();
        }*/

    }


    void disableflashstrobe()
    {
        flash.setBackgroundResource(R.drawable.flash);
        strobe.setBackgroundResource(R.drawable.strobe);
        fade.setBackgroundResource(R.drawable.fade);
        smooth.setBackgroundResource(R.drawable.smooth);
    }



    private void rb1() {
        if (!flag2) {
            rb1.setChecked(true);
            rb2.setChecked(false);
            rb3.setChecked(false);
            flag2 = true;
            flag1 = false;
            flag3 = false;
            np5.setEnabled(false);
            np6.setEnabled(false);
            np7.setEnabled(false);
            np8.setEnabled(false);
            np9.setEnabled(false);
            tvon.setEnabled(false);
            tvoff.setEnabled(false);
            rb_reppattern.setEnabled(true);

            sunday.setEnabled(true);
            monday.setEnabled(true);
            tuesday.setEnabled(true);
            wednesday.setEnabled(true);
            thusday.setEnabled(true);
            friday.setEnabled(true);
            saturday.setEnabled(true);
            // rb3.setEnabled(false);
            // rb2.setEnabled(false);
            ld3.setAlpha((float) 0.5);
            ld4.setAlpha((float) 0.5);
            ld5.setAlpha((float) 0.5);
            ld6.setAlpha((float) 0.5);
            repeat.setAlpha(1.0f);
            ld1.setAlpha((float) 1.0);
            ld2.setAlpha((float) 1.0);


        } else {
            flag2 = false;
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            tvon.setEnabled(true);
            tvoff.setEnabled(true);
            // rb3.setEnabled(true);
            // rb2.setEnabled(true);
            ld3.setAlpha((float) 1.0);
            ld4.setAlpha((float) 1.0);
            ld5.setAlpha((float) 1.0);
            ld6.setAlpha((float) 1.0);

            sunday.setEnabled(false);
            monday.setEnabled(false);
            tuesday.setEnabled(false);
            wednesday.setEnabled(false);
            thusday.setEnabled(false);
            friday.setEnabled(false);
            saturday.setEnabled(false);
            np5.setEnabled(false);
            np6.setEnabled(false);
            np7.setEnabled(false);
            np8.setEnabled(false);
            np9.setEnabled(false);
            rb_reppattern.setEnabled(false);
          //  rb_reppattern.setChecked(false);
        }
    }

    private void rb2() {
        if (!flag1) {
            rb2.setChecked(true);
            rb1.setChecked(false);
            rb3.setChecked(false);
            rb_reppattern.setChecked(false);
            flag1 = true;
            flag2 = false;
            flag3 = false;
            flag4 = false;
            np7.setEnabled(false);
            np8.setEnabled(false);
            np9.setEnabled(false);
            // rb1.setEnabled(false);
            // rb3.setEnabled(false);
            repeat.setAlpha(0.5f);
            np5.setEnabled(true);
            np6.setEnabled(true);
            tvon.setEnabled(true);
            tvoff.setEnabled(true);

            ld1.setEnabled(false);
            ld2.setEnabled(false);
            sunday.setEnabled(false);
            monday.setEnabled(false);
            tuesday.setEnabled(false);
            wednesday.setEnabled(false);
            thusday.setEnabled(false);
            friday.setEnabled(false);
            saturday.setEnabled(false);
            ld1.setAlpha((float) 0.5);
            ld2.setAlpha((float) 0.5);
            ld5.setAlpha((float) 0.5);
            ld6.setAlpha((float) 0.5);
            ld3.setAlpha((float) 1.0);
            ld4.setAlpha((float) 1.0);

            rb_reppattern.setEnabled(false);

        } else {
            flag1 = false;
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            np5.setEnabled(false);
            np6.setEnabled(false);
            np7.setEnabled(false);
            np8.setEnabled(false);
            np9.setEnabled(false);
            // rb1.setEnabled(true);
            // rb3.setEnabled(true);

            ld1.setEnabled(true);
            ld2.setEnabled(true);
            sunday.setEnabled(false);
            monday.setEnabled(false);
            tuesday.setEnabled(false);
            wednesday.setEnabled(false);
            thusday.setEnabled(false);
            friday.setEnabled(false);
            saturday.setEnabled(false);
            repeat.setAlpha(1.0f);
            ld1.setAlpha((float) 1.0);
            ld2.setAlpha((float) 1.0);
            ld5.setAlpha((float) 1.0);
            ld6.setAlpha((float) 1.0);
            rb_reppattern.setEnabled(false);

        }
    }

    private void rb3() {
        if (!flag3) {
            rb3.setChecked(true);
            rb1.setChecked(false);
            rb2.setChecked(false);
            flag3 = true;
            flag1 = false;
            flag2 = false;
            np5.setEnabled(false);
            np6.setEnabled(false);
            tvon.setEnabled(false);
            tvoff.setEnabled(false);
            //rb1.setEnabled(false);
            //rb2.setEnabled(false);
            repeat.setAlpha(0.5f);
            np7.setEnabled(true);
            np8.setEnabled(true);
            np9.setEnabled(true);
            ld1.setEnabled(false);
            ld2.setEnabled(false);
            sunday.setEnabled(false);
            monday.setEnabled(false);
            tuesday.setEnabled(false);
            wednesday.setEnabled(false);
            thusday.setEnabled(false);
            friday.setEnabled(false);
            saturday.setEnabled(false);

            ld1.setAlpha((float) 0.5);
            ld2.setAlpha((float) 0.5);
            ld3.setAlpha((float) 0.5);
            ld4.setAlpha((float) 0.5);
            ld5.setAlpha((float) 1.0);
            ld6.setAlpha((float) 1.0);
            rb_reppattern.setEnabled(true);
        } else {
            flag3 = false;
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            np5.setEnabled(false);
            np6.setEnabled(false);
            tvon.setEnabled(true);
            tvoff.setEnabled(true);
            ld1.setEnabled(true);
            ld2.setEnabled(true);
            sunday.setEnabled(false);
            monday.setEnabled(false);
            tuesday.setEnabled(false);
            wednesday.setEnabled(false);
            thusday.setEnabled(false);
            friday.setEnabled(false);
            saturday.setEnabled(false);
            np7.setEnabled(false);
            np8.setEnabled(false);
            np9.setEnabled(false);
            // rb1.setEnabled(true);
            //rb2.setEnabled(true);
            repeat.setAlpha(1.0f);
            ld1.setAlpha((float) 1.0);
            ld2.setAlpha((float) 1.0);
            ld3.setAlpha((float) 1.0);
            ld4.setAlpha((float) 1.0);
            rb_reppattern.setEnabled(false);
          //  rb_reppattern.setChecked(false);
        }
    }


    private void rb4() {
        if (!flag4) {
            rb_reppattern.setChecked(true);
            flag4 = true;

            rep_weekly="1";

        } else {
            flag4 = false;
            rb_reppattern.setChecked(false);
            //  String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Calendar cal = Calendar.getInstance();
            rep_weekly = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));
            Log.d("TAG", String.valueOf(rep_weekly));

        }
    }
    void  numberpicker(){
        //np.setPadding(10, 10, 10, 0);
        np.setMaxValue(23); // max value 100
        np.setMinValue(0);   // min value zero
        np.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        //  np.setWrapSelectorWheel(false);
        // np.setOnValueChangedListener( this);

        np1.setMaxValue(59); // max value 100
        np1.setMinValue(0);   // min value zero
        np1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


        np2.setMaxValue(23); // max value 100
        np2.setMinValue(0);   // min value zero
        np2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        np3.setMaxValue(59); // max value 100
        np3.setMinValue(0);   // min value zero
        np3.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);



     /*   int start = 2;
      numbers = new String[30];
        for(int i =0 ; i < 30 ; i++) {
            numbers[i] = start + "";
            start = start +2;
        }
       np5.setMaxValue(numbers.length-1);
        np5.setMinValue(2);
        np5.setDisplayedValues(numbers);
        //   np5.setMaxValue(59); // max value 100
      //  np5.setMinValue(0);   // min value zero*/


        int NUMBER_OF_VALUES = 29;
        int PICKER_RANGE =2;
         displayedValues  = new String[NUMBER_OF_VALUES];
        for(int i=0; i<NUMBER_OF_VALUES; i++)
            displayedValues[i] = String.valueOf(PICKER_RANGE * (i+1));

        np5.setMinValue(0);
        np5.setMaxValue(displayedValues.length-1);
        np5.setDisplayedValues(displayedValues);
        np5.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


       /* np6.setMaxValue(30);
        np6.setMinValue(02);
        np6.setDisplayedValues(numbers);
        np6.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
*/

        int NUMBER_OF_VALUES2 = 29;
        int PICKER_RANGE2 = 2;
        displayedValues2  = new String[NUMBER_OF_VALUES2];
        for(int i=0; i<NUMBER_OF_VALUES2; i++)
            displayedValues2[i] = String.valueOf(PICKER_RANGE2 * (i+1));

        np6.setMinValue(0);
        np6.setMaxValue(displayedValues2.length-1);
        np6.setDisplayedValues(displayedValues2);
        np6.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        np7.setMaxValue(31); // max value 100
        np7.setMinValue(1);   // min value zero
        np7.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        // NumberPicker pickers = new NumberPicker(this);
        String[] arrayPicker = new String[]{"","JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

        //set min value zero
        //np8.setMinValue(0);
        //set max value from length array string reduced 1
        np8.setMaxValue(arrayPicker.length-1);
        //implement array string to number picker
        np8.setDisplayedValues(arrayPicker);
        //disable soft keyboard
        np8.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        //set wrap true or false, try it you will know the difference

        np9.setMaxValue(2050); // max value 100
        np9.setMinValue(1990);   // min value zero
        np9.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String splitTime[] = date.split("-");
        one = splitTime[0];
        two = splitTime[1];
        three = splitTime[2];
        np9.setValue(Integer.parseInt(one));
        np8.setValue(Integer.parseInt(two));
        np7.setValue(Integer.parseInt(three));

        np.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np1.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np2.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np3.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np5.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np6.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np7.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        np9.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%04d", i);
            }
        });

    }

}

