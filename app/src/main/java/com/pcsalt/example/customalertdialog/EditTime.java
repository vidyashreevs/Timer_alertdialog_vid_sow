package com.pcsalt.example.customalertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static com.pcsalt.example.customalertdialog.CustomAdapter.datee;
import static com.pcsalt.example.customalertdialog.CustomAdapter.dateee;
import static com.pcsalt.example.customalertdialog.CustomAdapter.day;
import static com.pcsalt.example.customalertdialog.CustomAdapter.devicenum;
import static com.pcsalt.example.customalertdialog.CustomAdapter.devname;
import static com.pcsalt.example.customalertdialog.CustomAdapter.devtype;
import static com.pcsalt.example.customalertdialog.CustomAdapter.inflater;
import static com.pcsalt.example.customalertdialog.CustomAdapter.offdatare;
import static com.pcsalt.example.customalertdialog.CustomAdapter.offff;
import static com.pcsalt.example.customalertdialog.CustomAdapter.offt;
import static com.pcsalt.example.customalertdialog.CustomAdapter.on;
import static com.pcsalt.example.customalertdialog.CustomAdapter.ondatare;
import static com.pcsalt.example.customalertdialog.CustomAdapter.ont;
import static com.pcsalt.example.customalertdialog.CustomAdapter.repeaweekly;
import static com.pcsalt.example.customalertdialog.CustomAdapter.roomnumber;
import static com.pcsalt.example.customalertdialog.CustomAdapter.switchnumber;
import static com.pcsalt.example.customalertdialog.CustomAdapter.typ;
import static com.pcsalt.example.customalertdialog.R.array.spinnerItems;

public class EditTime extends AppCompatActivity {

    ArrayList num, devicename, devicetype, status, ontime, offtime, type, data, edit, delete, switchnum, days, devinum, date, time, ontimerep, ondatarep, offdatarep, repeatweekly, offtimerep;
    String num1, devicename1, devicetype1, ontime1, offtime1, devnum, type1, switchnum1, days1, date1, time1, ontimerep1, ondatarep1, offdatarep1, repeatweekly1, offtimerep1;
    String offtime3;
    ListView simpleListView;
    Spinner spinner;
    ImageButton editimg, deleteimg;
    Button deleteall;
    JSONArray jsonarray;
     boolean flag1 = false;
     boolean flag2 = false;
     boolean flag3 = false;
     boolean flag4 = false;
    NumberPicker np, np1, np2, np3, np5, np6, np7, np8, np9;
    Button sunday, monday, tuesday, wednesday, thusday, friday, saturday, setoperation, timerlist, settimer,cancel;
    TextView tvon, tvoff, tvvv;
    Button colorview;
    int nnp1, nnp2, nnp3, nnp4, nnp5, nnp6, nnp7, nnp8, nnp9;
    int a, b, c, d, e, f, g;
    LinearLayout repeat;
    RadioButton rb1, rb2, rb3,rb4;
    LinearLayout ld1, ld2, ld3, ld4, ld5, ld6;
    View alertLayout;
    int check2, check3;
    Button flash, fade, strobe, smooth;
    TextView tvspeed;
    SeekBar brightness;
     String fromtime, totime,zero,zero1,abcd,repdata,pushtype,one, two, three, four,check1,fsfs,name, name1;
     String nnnp1, nnnp2, nnnp3, nnnp4, nnnp5, nnnp6, nnnp7;
     int color_bright;
     Object fsfs_speed, tvspeed1,color_fsfs;
     Integer rrr, ggg, bbb;
    AlertDialog dialog;
     TextView tv;
    private String l1,r;
    private String yyy;
    private String dd;
     TextView tvvvb;
    static String responseBody;
    private String roomnum;
    private String[] displayedValues,displayedValues2;
    private String choosenValue,choosenValue2;
    private String rep_weekly;
    private String rrrr,gggg,bbbb;
    private String x1,x2,x3,x4;
    private Button bthigh,btmedium,btlow;
    private SeekBar seek_arc;
    private ShaderSeekArc seekArc;
    private ImageView i;
    private String dim_brightness;
    private int fan_speed_dis;
    private Spinner fan_speed;
    private String fanspeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_timer_activity);

        simpleListView = (ListView) findViewById(R.id.simpleListView);
        spinner = (Spinner) findViewById(R.id.spinner);
        editimg = (ImageButton) findViewById(R.id.edit);
        deleteimg = (ImageButton) findViewById(R.id.delete);
        deleteall = (Button) findViewById(R.id.deleteall);
        tvvvb = (TextView) findViewById(R.id.tvd);


        deleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //simpleListView.setAdapter(null);
                dd = "deleteall";
                Thread t = new Thread() {

                    public void run() {

                        postupdins();

                    }

                };
                t.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (responseBody.equals("*DACK#\r\n")) {
                            //Toast.makeText(view.getContext(),"Data updated successfully",Toast.LENGTH_LONG).show();
                            //dialog.dismiss();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                            builder1.setTitle("INFO");
                            builder1.setMessage(" All Deleted successfully");
                            builder1.setCancelable(true);
                            builder1.setNeutralButton(android.R.string.ok,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog123, int id) {
                                            dialog123.cancel();

                                        }
                                    });

                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        }
                        else {
                            Toast.makeText(view.getContext(),"Data not deleted",Toast.LENGTH_LONG).show();
                        }


                    }
                }, 900);
            }

            });



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(EditTime.this, "No data", Toast.LENGTH_LONG).show();
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(EditTime.this, 0, 0);
                    simpleListView.setAdapter(adapter);
                }
                if (i == 1) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                roomnum="01";
                             //   yyy="http://192.168.0.204/timerstatus.php?roomno=01&user=admin12345&pass=12345678";
                                //yyy="http://192.168.1.101/tstatus1.php?roomno=01&user=admin12345&pass=12345678";
                                post();
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }


                    };
                    t.start();
                }
                if (i == 2) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                roomnum="02";
                             //   yyy="http://192.168.0.204/timerstatus.php?roomno=02&user=admin12345&pass=12345678";
                                 //yyy="http://192.168.1.101/tstatus1.php?roomno=02&user=admin12345&pass=12345678";
                                post();
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }


                    };
                    t.start();
                }
                if (i == 3) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                roomnum="03";
                           //    yyy="http://192.168.0.204/timerstatus.php?roomno=02&user=admin12345&pass=12345678";
                             //   yyy="http://192.168.1.101/tstatus1.php?roomno=03&user=admin12345&pass=12345678";
                               // yyy="http://192.168.1.101/timerstatus.php?roomno=03&user=admin12345&pass=12345678";
                                post();
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }


                    };
                    t.start();
                }
                if (i == 4) {
                    Toast.makeText(EditTime.this, "No data", Toast.LENGTH_LONG).show();
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(EditTime.this, 0, 0);
                    simpleListView.setAdapter(adapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        if(spinner!=null) {

           // spinner.setId(0);
            Thread t = new Thread() {
                public void run() {
                    try {
                        roomnum = "01";
                      //  yyy="http://192.168.0.204/timerstatus.php?roomno=01&user=admin12345&pass=12345678";
                      // yyy = "http://192.168.1.101/tstatus1.php?roomno=01&user=admin12345&pass=12345678";
                        post();
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }


            };
            t.start();

            }

    }


    public void post() throws JSONException, IOException {

        // Creating HTTP client
        HttpClient httpClient = new DefaultHttpClient();
        // Creating HTTP Post
        HttpPost httpPost =new HttpPost("http://192.168.0.204/timerstatus.php");
        List<NameValuePair> nameValuePair = new ArrayList<>(3);
        nameValuePair.add(new BasicNameValuePair("roomno", roomnum));
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
            String responseBody = null;

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseBody = EntityUtils.toString(entity);
                jsonarray = new JSONArray(responseBody);
                num = new ArrayList();
                devicename = new ArrayList();
                devicetype = new ArrayList();
                status = new ArrayList();
                ontime = new ArrayList();
                offtime = new ArrayList();
                type = new ArrayList();
                data = new ArrayList();
                edit = new ArrayList();
                switchnum = new ArrayList();
                days = new ArrayList();
                date = new ArrayList();
                time = new ArrayList();
                ontimerep = new ArrayList();
                ondatarep = new ArrayList();
                offdatarep = new ArrayList();
                repeatweekly = new ArrayList();
                offtimerep = new ArrayList();
                delete = new ArrayList();

                devinum = new ArrayList();
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    //   num1 = jsonobject.getString("DeviceName");
                    name = jsonobject.getString("ModelName");
                    name1 = jsonobject.getString("OperatedType");


                    if (name1.equals("Cyclic")) {
                        devicename1 = jsonobject.getString("ModelName");
                        devicetype1 = jsonobject.getString("ModelNumber");
                        type1 = jsonobject.getString("OperatedType");

                        switchnum1 = jsonobject.getString("SwitchNumber");
                        //  days1 = jsonobject.getString("Days");
                        date1 = jsonobject.getString("Date");
                        time1 = jsonobject.getString("Time");

                        offtime3 = jsonobject.getString("OperationData");
                        ondatarep1 = jsonobject.getString("OnCyclicData");
                        offdatarep1 = jsonobject.getString("OffCyclicData");
                        repeatweekly1 = jsonobject.getString("RepeatWeekly");
                        ontimerep1 = jsonobject.getString("FromTimecyclic");
                        offtimerep1 = jsonobject.getString("ToTimecyclic");
                        ontime1 = jsonobject.getString("OnTimecyclic");
                        offtime1 = jsonobject.getString("OffTimecyclic");
                        devnum = jsonobject.getString("DeviceNO");

                        num.add(num1);
                        devicename.add(devicename1);
                        devicetype.add(devicetype1);
                        type.add(type1);
                        switchnum.add(switchnum1);
                        // days.add(days1);
                        date.add(date1);
                        time.add(time1);
                        ontimerep.add(ontimerep1);
                        ondatarep.add(ondatarep1);
                        offdatarep.add(offdatarep1);
                        repeatweekly.add(repeatweekly1);
                        ontime.add(ontime1);
                        offtime.add(offtime1);
                        offtimerep.add(offtimerep1);
                        days.add(offtime3);
                        devinum.add(devnum);
                    }
                    //   if (jsonarray.equals("Repeat On Days")) {

                    else {
                        devicename1 = jsonobject.getString("ModelName");
                        devicetype1 = jsonobject.getString("ModelNumber");
                        type1 = jsonobject.getString("OperatedType");
                        switchnum1 = jsonobject.getString("SwitchNumber");
                        days1 = jsonobject.getString("Days");
                        date1 = jsonobject.getString("Date");
                        time1 = jsonobject.getString("Time");
                        ontimerep1 = jsonobject.getString("FromTimeRep");
                        offtimerep1 = jsonobject.getString("ToTimeRep");
                        ondatarep1 = jsonobject.getString("OnDataRep");
                        offdatarep1 = jsonobject.getString("OffDataRep");
                        repeatweekly1 = jsonobject.getString("RepeatWeekly");
                        ontime1 = jsonobject.getString("FromTimeRep");
                        offtime1 = jsonobject.getString("ToTimeRep");
                        devnum = jsonobject.getString("DeviceNO");


                        num.add(num1);
                        devicename.add(devicename1);
                        devicetype.add(devicetype1);
                        type.add(type1);
                        switchnum.add(switchnum1);
                        days.add(days1);
                        date.add(date1);
                        time.add(time1);
                        ontimerep.add(ontimerep1);
                        ondatarep.add(ondatarep1);
                        offdatarep.add(offdatarep1);
                        repeatweekly.add(repeatweekly1);
                        ontime.add(ontime1);
                        offtime.add(offtime1);
                        offtimerep.add(offtimerep1);
                        devinum.add(devnum);

                    }
                }

                Log.d("TAG", "Http post Response: " + responseBody);
            }
            Log.d("TAG", responseBody);

            //final String finalResponseBody = responseBody;

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    simpleListView.setAdapter(new CustomAdapter(EditTime.this, num, devicename, devicetype, type, switchnum, days, date, time, ontimerep, ondatarep, offdatarep, repeatweekly, ontime, offtime, offtimerep, devinum));

                }
            });
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();

        } /*catch (JSONException e) {
            e.printStackTrace();
        }*/
    }


    public void switch21() {

        dd = "upd";
        abcd= String.valueOf(ondatare);
        Log.d("TAG",abcd);
        alertLayout = inflater.inflate(R.layout.switch_edit_layout_custom_dialog, null);
      //  AlertDialog.Builder alert2 = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);
        tv = (TextView) alertLayout.findViewById(R.id.tv1);
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

        rb1 = (RadioButton) alertLayout.findViewById(R.id.rb1);
        rb2 = (RadioButton) alertLayout.findViewById(R.id.rb2);
        rb3 = (RadioButton) alertLayout.findViewById(R.id.rb3);
        rb4 = (RadioButton) alertLayout.findViewById(R.id.rb_reppattern);
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

        set_timer();



        setoperation.setOnClickListener(new View.OnClickListener() {
            public String[] arraySpinner;

            @Override
            public void onClick(View view) {
                alertLayout = inflater.inflate(R.layout.switch_fansped_alert, null);
                fan_speed = (Spinner) alertLayout.findViewById(R.id.fan_speed);
                final String[] str = {"0", "1", "2", "3", "4", "5"};
                ArrayAdapter<String> adp2 = new ArrayAdapter<>(alertLayout.getRootView().getContext(),android.R.layout.simple_spinner_item, str);
                adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                fan_speed.setAdapter(adp2);

     AlertDialog.Builder alert = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);

                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(true);

                final AlertDialog dialog1 = alert.create();
                dialog1.show();


                dialog1.getWindow().setLayout(500, 350);
                dialog1.show();

                fan_speed_dis = Integer.parseInt(abcd.substring(14, 15));
                fan_speed.setSelection(adp2.getPosition(String.valueOf(fan_speed_dis)));

                fan_speed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i == 0) {
                            fanspeed = "0";
                            //bulbon.add("71");
                        } else {
                            
                        }
                        Log.d("TAG",fanspeed);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
                
                
                
                
                


            }
        });



    }

    private void postupdins() {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        List<NameValuePair> nameValuePair = null;
       if(dd.equals("upd")) {
            httpClient = new DefaultHttpClient();
           httpPost = new HttpPost("http://192.168.0.204/settimer.php");
         //httpPost = new HttpPost("http://192.168.1.101/settimer1.php");
          // httpPost = new HttpPost("http://192.168.1.101/settimer1.php");
           String trdata = repdata;
            nameValuePair = new ArrayList<>(5);
           nameValuePair.add(new BasicNameValuePair("trdata", trdata));
           nameValuePair.add(new BasicNameValuePair("type", pushtype));
           nameValuePair.add(new BasicNameValuePair("status", dd));
           nameValuePair.add(new BasicNameValuePair("user", "admin12345"));
           nameValuePair.add(new BasicNameValuePair("pass", "12345678"));
       }
        else if( dd.equals("del")) {
            httpClient = new DefaultHttpClient();
          httpPost = new HttpPost("http://192.168.0.204/settimer.php");
          // httpPost = new HttpPost("http://192.168.1.101/settimer1.php");
            String trdata = repdata;
            nameValuePair = new ArrayList<>(5);
            nameValuePair.add(new BasicNameValuePair("trdata", trdata));
            nameValuePair.add(new BasicNameValuePair("type", pushtype));
            nameValuePair.add(new BasicNameValuePair("status", dd));
            nameValuePair.add(new BasicNameValuePair("user", "admin12345"));
            nameValuePair.add(new BasicNameValuePair("pass", "12345678"));
        }
        else if(dd.equals("deleteall")) {
            httpClient = new DefaultHttpClient();
           httpPost = new HttpPost("http://192.168.0.204/timerdelete.php");
           //httpPost = new HttpPost("http://192.168.1.101/timerdelete.php");
            nameValuePair = new ArrayList<>(3);
            //nameValuePair.add(new BasicNameValuePair("trdata", trdata));
           // nameValuePair.add(new BasicNameValuePair("type", pushtype));
            nameValuePair.add(new BasicNameValuePair("roomno", roomnum));
            nameValuePair.add(new BasicNameValuePair("user", "admin12345"));
            nameValuePair.add(new BasicNameValuePair("pass", "12345678"));
        }
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

                    if(dd.equals("upd"))
                    {
                        tvvv.setText(finalResponseBody);

                    }
                     if(dd.equals("del"))
                    {

                    }

                    if(dd.equals("deleteall"))
                    {
                        tvvvb.setText(finalResponseBody);
                    }


                }
            });
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();

        } /*catch (JSONException e) {
            e.printStackTrace();
        }*/

    }


    public void rgb() {
        dd = "upd";
        alertLayout = inflater.inflate(R.layout.rgb_edit_layout_custom_dialog, null);
       // AlertDialog.Builder alert2 = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);
        tv = (TextView) alertLayout.findViewById(R.id.tv1);
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


        rb1 = (RadioButton) alertLayout.findViewById(R.id.rb1);
        rb2 = (RadioButton) alertLayout.findViewById(R.id.rb2);
        rb3 = (RadioButton) alertLayout.findViewById(R.id.rb3);
        rb4 = (RadioButton) alertLayout.findViewById(R.id.rb_reppattern);
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

         set_timer();


        setoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   LayoutInflater inflater = getLayoutInflater();
                alertLayout = inflater.inflate(R.layout.rgb_popup, null);

                AlertDialog.Builder alert = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);
                //  alert.setTitle("Login");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(true);

                final AlertDialog dialog1 = alert.create();
                dialog1.show();


                dialog1.getWindow().setLayout(400, 450);
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

                Button save = (Button) alertLayout.findViewById(R.id.save);
                Button cancel = (Button) alertLayout.findViewById(R.id.cancel);
                colorview = (Button) alertLayout.findViewById(R.id.colorview);

                final Button btup = (Button) alertLayout.findViewById(R.id.up);
                final Button btdown = (Button) alertLayout.findViewById(R.id.down);
                tvspeed = (TextView) alertLayout.findViewById(R.id.tvspeed);
                brightness = (SeekBar) alertLayout.findViewById(R.id.brightness);
                flash = (Button) alertLayout.findViewById(R.id.flash);
                strobe = (Button) alertLayout.findViewById(R.id.strobe);
                fade = (Button) alertLayout.findViewById(R.id.fade);
                smooth = (Button) alertLayout.findViewById(R.id.smooth);


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


                Object ondatarepp = ondatare;
                String ondat = ondatarepp.toString();


                String splitTime[] = ondat.split(";");
                one = splitTime[0];
                two = splitTime[1];
                three = splitTime[2];
                four = splitTime[3];

                check1 = two.substring(12, 15);
                if (check1.equals("112")) {
                    color();
                } else {
                    flashfadesmooth();
                }


                check2 = Integer.parseInt(four.substring(12, 15));
                if (check2 >= 121 && check2 <= 130) {
                    speed();
                }


                check3 = Integer.parseInt(three.substring(12, 15));
                if (check3 >= 131 && check2 <= 130) {
                    brightness();
                }

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
                            fsfs_speed = check2;
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
                                fsfs_speed = check2;
                            }

                        }
                        abcd = "001000000" + devicenum + roomnumber+"102000000000000000" + ";" + "001000000" + devicenum + roomnumber + color_fsfs + rrrr + gggg + bbbb + "000000;" + "001000000" + devicenum + roomnumber + color_bright + "000000000000000;" + "001000000" + devicenum +roomnumber + fsfs_speed + "000000000000000";
                        dialog1.dismiss();
                    }
                });

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

                // dialog.dismiss();
            }
        });


    }


    public void dimmer() {
        dd = "upd";
        alertLayout = inflater.inflate(R.layout.rgb_edit_layout_custom_dialog, null);
        // AlertDialog.Builder alert2 = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);
        tv = (TextView) alertLayout.findViewById(R.id.tv1);
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


        rb1 = (RadioButton) alertLayout.findViewById(R.id.rb1);
        rb2 = (RadioButton) alertLayout.findViewById(R.id.rb2);
        rb3 = (RadioButton) alertLayout.findViewById(R.id.rb3);
        rb4 = (RadioButton) alertLayout.findViewById(R.id.rb_reppattern);
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

        set_timer();


        setoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   LayoutInflater inflater = getLayoutInflater();
                alertLayout = inflater.inflate(R.layout.dimmer_timer_popup, null);

                AlertDialog.Builder alert = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);
                //  alert.setTitle("Login");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(true);

                final AlertDialog dialog1 = alert.create();
                dialog1.show();


                dialog1.getWindow().setLayout(500, 350);
                dialog1.show();

                 bthigh = (Button) alertLayout.findViewById(R.id.bthigh);
                 btmedium = (Button) alertLayout.findViewById(R.id.btmedium);
                 btlow = (Button) alertLayout.findViewById(R.id.btlow);
                 Button save = (Button) alertLayout.findViewById(R.id.save);
                 Button cancel = (Button) alertLayout.findViewById(R.id.cancel);
                 seekArc = (ShaderSeekArc) alertLayout.findViewById(R.id.seek_arc);
                 i = (ImageView) alertLayout.findViewById(R.id.image);
                 i.setImageResource(R.drawable.b1);

                Object ondatarepp = ondatare;
                String ondat = ondatarepp.toString();


                String splitTime[] = ondat.split(";");
                one = splitTime[0];
                two = splitTime[1];

                check2 = Integer.parseInt(two.substring(15, 18));
                if (check2 >= 000 && check2 <= 255) {
                    brightness_dimmer();
                }

                dim_brightness= String.valueOf(check2);
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


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                        abcd = "001000000" + devicenum + roomnumber+"102000000000000000" + ";" + "001000000" + devicenum + roomnumber +"112"+ dim_brightness+ "000000";
                        dialog1.dismiss();
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


            }
                });


            }

    private void brightness_dimmer() {
        if(check2>=0 && check2<=14){
            i.setImageResource(R.drawable.b1);
            seekArc.setProgress(1);
        }
       else if(check2>=15 && check2<=16){
            i.setImageResource(R.drawable.b2);
            seekArc.setProgress(2);
        }
        else if(check2>=17 && check2<=35){
            i.setImageResource(R.drawable.b3);
            seekArc.setProgress(3);
        }
        else if(check2>=36 && check2<=71){
            i.setImageResource(R.drawable.b4);
            seekArc.setProgress(4);
        }
        else if(check2>=72 && check2<=99){
            i.setImageResource(R.drawable.b5);
            seekArc.setProgress(5);
        }
        else if(check2>=100 && check2<=155){
            i.setImageResource(R.drawable.b6);
            seekArc.setProgress(6);
        }
        else if(check2>=156 && check2<=204){
            i.setImageResource(R.drawable.b7);
            seekArc.setProgress(7);
        }
        else if(check2>=205 && check2<=225){
            i.setImageResource(R.drawable.b8);
            seekArc.setProgress(8);
        }
        else if(check2>=226 && check2<=255){
            i.setImageResource(R.drawable.b9);
            seekArc.setProgress(9);
        }
        /*else if(check2==255){
            i.setImageResource(R.drawable.b10);
        }*/
    }


    private void set_timer() {

        sunday.setTag(0);
        monday.setTag(0);
        tuesday.setTag(0);
        wednesday.setTag(0);
        thusday.setTag(0);
        friday.setTag(0);
        saturday.setTag(0);

        AlertDialog.Builder alert = new AlertDialog.Builder(alertLayout.getRootView().getContext(), R.style.MyDialogTheme1);
        //  alert.setTitle("Login");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);

        final AlertDialog dialog = alert.create();
        dialog.show();
        dialog.getWindow().setLayout(500, 850);
        dialog.show();
        //dialog.getWindow().setLayout(450, 650);

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    sunday.setBackgroundResource(R.drawable.sun_sat_02);
                    view.setTag(1);
                    sunday.setTag(1);
                } else {
                    sunday.setBackgroundResource(R.drawable.sun_sat_01);
                    view.setTag(0);
                    sunday.setTag(0);
                }
            }
        });


        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    monday.setBackgroundResource(R.drawable.mon_02);
                    view.setTag(1);
                    monday.setTag(1);
                } else {
                    monday.setBackgroundResource(R.drawable.mon_01);
                    view.setTag(0);
                    monday.setTag(0);
                }
            }
        });


        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    tuesday.setBackgroundResource(R.drawable.tues_thur_02);
                    view.setTag(1);
                    tuesday.setTag(1);
                } else {
                    tuesday.setBackgroundResource(R.drawable.tues_thur_01);
                    view.setTag(0);
                    tuesday.setTag(0);
                }
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    wednesday.setBackgroundResource(R.drawable.wed_02);
                    view.setTag(1);
                    wednesday.setTag(1);
                } else {
                    wednesday.setBackgroundResource(R.drawable.wed_01);
                    view.setTag(0);
                    wednesday.setTag(0);
                }
            }
        });

        thusday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    thusday.setBackgroundResource(R.drawable.tues_thur_02);
                    view.setTag(1);
                    thusday.setTag(1);
                } else {
                    thusday.setBackgroundResource(R.drawable.tues_thur_01);
                    view.setTag(0);
                    thusday.setTag(0);
                }
            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    friday.setBackgroundResource(R.drawable.fri_02);
                    view.setTag(1);
                    friday.setTag(1);
                } else {
                    friday.setBackgroundResource(R.drawable.fri_01);
                    view.setTag(0);
                    friday.setTag(0);
                }
            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view.getTag().equals(0)) {
                    saturday.setBackgroundResource(R.drawable.sun_sat_02);
                    view.setTag(1);
                    saturday.setTag(1);
                } else {
                    saturday.setBackgroundResource(R.drawable.sun_sat_01);
                    view.setTag(0);
                    saturday.setTag(0);
                }
            }
        });
        timerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent i = new Intent(Roomlist.this,EditTime.class);
                //startActivity(i);

            }
        });

        tv.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(false);

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
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb4.isChecked()) {
                    rb4();
                }
            }
        });


        numberpicker();

        settimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // numberpicker();

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

                if (!rb4.isChecked()) {
                    Calendar cal = Calendar.getInstance();
                    rep_weekly = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));
                }

                if (rb1.isChecked()) {
                    // rb1();

                    switch (l1) {
                        case "cyc":
                            pushtype = "cyc_rep";
                            break;
                        case "repd":
                            pushtype = "repd_rep";
                            break;
                        default:
                            pushtype = "rep";
                            break;
                    }
                    //  pushtype = "rep";
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

                    if (((color_fsfs != null && fsfs_speed != null) || abcd != null)) {
                        if (!(fromtime.equals(totime))) {
                            if (a != 0 || b != 0 || c != 0 || d != 0 || e != 0 || f != 0 || g != 0) {
                                // abcd = "001000000" + devicenum + roomnumber+"102000000000000000" + ";" + "001000000" + devicenum + roomnumber + color_fsfs + rrr + ggg + bbb + "000000;" + "001000000" + devicenum + roomnumber + color_bright + "000000000000000;" + "001000000" + devicenum + roomnumber + fsfs_speed + "000000000000000";
                                repdata = fromtime + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + devname + "@" + abcd + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + rep_weekly + "@" + totime + "@" + offdatare + "@" + ont;
                               // repdata = fromtime +totime+ "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + date + "@" + switchnumber + "@" + devname + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + rep_weekly + "@" + totime + "@" + offdatare + "@" + ont;


                                Log.d("TAG" + "RGB CYC", String.valueOf(repdata));
                            } else {
                                Toast.makeText(view.getContext(), "Please select days", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(view.getContext(), "Please Change TO time", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                    }
                }


                if (rb2.isChecked()) {
                    //rb2();
                    rep_weekly = "0";
                    switch (l1) {
                        case "rep":
                            pushtype = "rep_cyc";
                            break;
                        case "repd":
                            pushtype = "repd_cyc";
                            break;
                        default:
                            pushtype = "cyc";
                            break;
                    }
                    // pushtype = "cyc";
                    choosenValue = displayedValues[np5.getValue()];
                    if (choosenValue.length()==1) {
                        nnnp5 = "0" + choosenValue;
                    } else   if (choosenValue.length()==2) {
                        nnnp5 = choosenValue;
                    }


                    choosenValue2 = displayedValues2[np6.getValue()];
                    if (choosenValue2.length()==1) {
                        nnnp6 = "0" + choosenValue2;
                    } else   if (choosenValue2.length()==2) {
                        nnnp6 = choosenValue2;
                    }
                    zero = "00:" + nnnp5;
                    zero1 = "00:" + nnnp6;

                    if (((color_fsfs != null && fsfs_speed != null) || abcd != null)) {
                        if (!(fromtime.equals(totime))) {
                            repdata = fromtime + "@" + totime + "@" + zero + "@" + zero1 + "@" + fromtime + "@" + dateee + "@" + "1" + "@" + "0" + "@" + "0" + "@" + devname + "@" + abcd + "@" + offdatare + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + ont + "@" + offt;
                            Log.d("TAG" + "RGB CYC", String.valueOf(repdata));
                        } else {
                            Toast.makeText(view.getContext(), "Please Change TO time", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                    }


                }


                if (rb3.isChecked()) {
                    // rb3();

                    switch (l1) {
                        case "rep":
                            pushtype = "rep_repd";
                            break;
                        case "cyc":
                            pushtype = "cyc_repd";
                            break;
                        default:
                            pushtype = "repd";
                            break;
                    }
                    // pushtype = "repd";
                    nnp7 = np7.getValue();

                    if (nnp7 < 10) {
                        nnnp7 = "0" + nnp7;
                    } else if (nnp7 >= 10) {
                        nnnp7 = String.valueOf(nnp7);
                    }

                    nnp8 = np8.getValue();
                    nnp9 = np9.getValue();

                    r = nnp9 + "-" + nnp8 + "-" + nnnp7;

                    a = 0;
                    b = 0;
                    c = 0;
                    d = 0;
                    e = 0;
                    f = 0;
                    g = 0;

                    if (((color_fsfs != null && fsfs_speed != null) || abcd != null)) {
                        if (!(fromtime.equals(totime))) {
                            repdata = fromtime + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g + "@" + devname + "@" + abcd + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + rep_weekly + "@" + totime + "@" + offdatare + "@" + r + "@" + ont;
                        } else {
                            Toast.makeText(view.getContext(), "Please Change TO time", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                    }

                }

                Thread t = new Thread() {

                    public void run() {

                        postupdins();

                    }

                };
                t.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Object j = tvvv.getText();
                        if(j.equals("*UACK#"))
                        {
                            Toast.makeText(view.getContext(),"Data updated successfully",Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                          /* Thread t = new Thread() {
                                public void run() {
                                    try {

                                        roomnum="01";
                                        //yyy="http://192.168.0.204/tstatus1.php?roomno=01&user=admin12345&pass=12345678";
                                        yyy="http://192.168.1.101/tstatus1.php?roomno=01&user=admin12345&pass=12345678";
                                        post();
                                    } catch (JSONException | IOException e) {
                                        e.printStackTrace();
                                    }
                                }


                            };
                            t.start();*/
                        }
                        else if(j.equals("*UNACK#"))
                        {
                            Toast.makeText(view.getContext(),"Data not updated",Toast.LENGTH_LONG).show();
                        }
                        else if(j.equals("*EACK#"))
                        {
                            Toast.makeText(view.getContext(),"Data already exits",Toast.LENGTH_LONG).show();

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



        Object ontime = ont;
        Object offtime = offt;
        Object type = typ;

        String time = ontime.toString();


        if (ontime.equals("0")) {
            time = "00:00";
            String splitTime[] = time.split(":");
            String hours = splitTime[0];
            String minutes = splitTime[1];
            np.setValue(Integer.parseInt(hours));
            np1.setValue(Integer.parseInt(minutes));

        } else if (ontime.equals("null")) {
            np.setValue(Integer.parseInt("00"));
            np1.setValue(Integer.parseInt("00"));
        } else {
            String splitTime[] = time.split(":");
            String hours = splitTime[0];
            String minutes = splitTime[1];
            np.setValue(Integer.parseInt(hours));
            np1.setValue(Integer.parseInt(minutes));

        }


        String time2 = offtime.toString();
        if (offtime.equals("0")) {
            time2 = "00:00";
            String splitTime1[] = time2.split(":");
            String hours1 = splitTime1[0];
            String minutes1 = splitTime1[1];
            np2.setValue(Integer.parseInt(hours1));
            np3.setValue(Integer.parseInt(minutes1));
        } else if (offtime.equals("null")) {
            np2.setValue(Integer.parseInt("0"));
            np3.setValue(Integer.parseInt("0"));
        } else {
            String splitTime1[] = time2.split(":");
            String hours1 = splitTime1[0];
            String minutes1 = splitTime1[1];
            np2.setValue(Integer.parseInt(hours1));
            np3.setValue(Integer.parseInt(minutes1));
        }


        if (type.equals("Repeat On Days")) {

            l1="rep";
            rb1();
            Object days = day;
            String dayss = days.toString();
            String splitDay[] = dayss.split(",");

            String day2 = splitDay[0];
            String day3 = splitDay[1];
            String day4 = splitDay[2];
            String day5 = splitDay[3];
            String day6 = splitDay[4];
            String day7 = splitDay[5];
            String day1 = splitDay[6];


            if (day1.equals("1")) {
                sunday.setBackgroundResource(R.drawable.sun_sat_02);
                sunday.setTag(1);
            } else if (day1.equals("0")) {
                sunday.setBackgroundResource(R.drawable.sun_sat_01);
                sunday.setTag(0);
            }
            if (day2.equals("1")) {
                monday.setBackgroundResource(R.drawable.mon_02);
                monday.setTag(1);
            } else if (day2.equals("0")) {
                monday.setBackgroundResource(R.drawable.mon_01);
                monday.setTag(0);
            }
            if (day3.equals("1")) {
                tuesday.setBackgroundResource(R.drawable.tues_thur_02);
                tuesday.setTag(1);
            } else if (day3.equals("0")) {
                tuesday.setBackgroundResource(R.drawable.tues_thur_01);
                tuesday.setTag(0);
            }
            if (day4.equals("1")) {
                wednesday.setBackgroundResource(R.drawable.wed_02);
                wednesday.setTag(1);
            } else if (day4.equals("0")) {
                wednesday.setBackgroundResource(R.drawable.wed_01);
                wednesday.setTag(0);
            }
            if (day5.equals("1")) {
                thusday.setBackgroundResource(R.drawable.tues_thur_02);
                thusday.setTag(1);
            } else if (day5.equals("0")) {
                thusday.setBackgroundResource(R.drawable.tues_thur_01);
                thusday.setTag(0);
            }
            if (day6.equals("1")) {
                friday.setBackgroundResource(R.drawable.fri_02);
                friday.setTag(1);
            } else if (day6.equals("0")) {
                friday.setBackgroundResource(R.drawable.fri_01);
                friday.setTag(0);
            }
            if (day7.equals("1")) {
                saturday.setBackgroundResource(R.drawable.sun_sat_02);
                saturday.setTag(1);
            } else if (day7.equals("0")) {
                saturday.setBackgroundResource(R.drawable.sun_sat_01);
                saturday.setTag(0);
            }


            rep_weekly= String.valueOf(repeaweekly);
            if(rep_weekly.equals("1"))
            {
                rb4.setChecked(true);
            }
            else{
                rb4.setChecked(false);
            }

        } else if (type.equals("Cyclic")) {
            rb2();
            l1="cyc";
            Object ontm = on;
            Object offtm = offff;

            String ont = ontm.toString();
            String splitOnt[] = ont.split(":");
            String ont1 = splitOnt[0];
            String ont2 =splitOnt[1];


            if(ont2.startsWith("0"))
            {
                x1 = ont2.substring(0,1);
                x2 = ont2.substring(1);
            }
            else
            {
                x2= ont2;
            }
            //choosenValue = displayedValues[np5.getValue()];



            for( int i=0; i<displayedValues.length ; i++ ) {

                if (displayedValues[i].equals(x2))
                    np5.setValue(i);
            }


            //np5.setValue(ont2);

            String off = offtm.toString();
            String offt[] = off.split(":");
               String offt1 = offt[0];
            String offt2 = offt[1];

            if(offt2.startsWith("0"))
            {
                x3 = offt2.substring(0,1);
                x4 = offt2.substring(1);
            }
            else
            {
                x4= offt2;
            }

            for( int i=0; i<displayedValues.length ; i++ ) {
                if (displayedValues[i].equals(x4))
                    np6.setValue(i);
            }

           // np6.setValue(Integer.parseInt(offt2));
        } else if (type.equals("Repeat On Date")) {
            rb3();
            l1="repd";
            Object date = datee;
            String ont = date.toString();
            String splitOnt[] = ont.split("-");
            String year = splitOnt[0];
            String month = splitOnt[1];
            String day = splitOnt[2];
            np7.setValue(Integer.parseInt(day));
            np8.setValue(Integer.parseInt(month));
            np9.setValue(Integer.parseInt(year));


            rep_weekly= String.valueOf(repeaweekly);
            if(rep_weekly.equals("1"))
            {
                rb4.setChecked(true);
            }
            else{
                rb4.setChecked(false);
            }

        }

    }



    void brightness()
      {
          brightness.setMax(10);
          if(check3==131)
          {
              brightness.setProgress(1);

          }
          else if(check3==132)
          {
              brightness.setProgress(2);

          }
          else if(check3==133)
          {
              brightness.setProgress(3);
          }
          else if(check3==134)
          {
              brightness.setProgress(4);
          }
          else if(check3==135)
          {
              brightness.setProgress(5);
          }
          else if(check3==136)
          {
              brightness.setProgress(6);
          }
          else if(check3==137)
          {
              brightness.setProgress(7);
          }
          else if(check3==138)
          {
              brightness.setProgress(8);
          }
          else if(check3==139)
          {
              brightness.setProgress(9);
          }
          else if(check3==140)
          {
              brightness.setProgress(10);
          }
          else
          {
              brightness.setProgress(0);
          }

      }
      void speed()
      {
          if(check2==121)
          {
              tvspeed.setBackgroundResource(R.drawable.spone);

          }
          else if(check2==122)
          {
              tvspeed.setBackgroundResource(R.drawable.sptwo);
          }
          else if(check2==123)
          {
              tvspeed.setBackgroundResource(R.drawable.spthree);
          }
          else if(check2==124)
          {
              tvspeed.setBackgroundResource(R.drawable.spfour);
          }
          else if(check2==125)
          {
              tvspeed.setBackgroundResource(R.drawable.spfive);
          }
          else if(check2==126)
          {
              tvspeed.setBackgroundResource(R.drawable.spsix);
          }
          else if(check2==127)
          {
              tvspeed.setBackgroundResource(R.drawable.spseven);
          }
          else if(check2==128)
          {
              tvspeed.setBackgroundResource(R.drawable.speight);
          }
          else if(check2==129)
          {
              tvspeed.setBackgroundResource(R.drawable.spnine);
          }
          else if(check2==130)
          {
              tvspeed.setBackgroundResource(R.drawable.spten);
          }
          else
          {
              tvspeed.setBackgroundResource(R.drawable.spzero);
          }

      }

     void disableflashstrobe()
     {
         flash.setBackgroundResource(R.drawable.flash);
         strobe.setBackgroundResource(R.drawable.strobe);
         fade.setBackgroundResource(R.drawable.fade);
         smooth.setBackgroundResource(R.drawable.smooth);
     }

    void color() {
        int r = Integer.parseInt(two.substring(15,18));
       int g = Integer.parseInt(two.substring(18, 21));
        int b = Integer.parseInt(two.substring(21, 24));
        colorview.setBackgroundColor(Color.rgb(r, g, b));


      /* // Color color = new Color(Integer.parseInt(two.substring(15, 24)));
        String hexValue = Integer.toHexString(Integer.parseInt(two.substring(15, 24)));
      if( r==112)
      {
          String splitOnt[] = two.split("112");
      }

       // String ont = two.toString(13,16);

        String splitOnt[] = two.split("");
        String ont1 = splitOnt[0];
        colorview.setBackground(Drawable.createFromPath(hexValue));*/
    }
    void  flashfadesmooth()
    {
        switch (check1) {
            case "104": {

                flash.setBackgroundResource(R.drawable.flash01);
                strobe.setBackgroundResource(R.drawable.strobe);
                fade.setBackgroundResource(R.drawable.fade);
                smooth.setBackgroundResource(R.drawable.smooth);
                // view.setTag(1);

                String fls = "FLASH";
                colorview.setText(fls);
                break;
            }
            case "105":
                strobe.setBackgroundResource(R.drawable.strobe01);
                // view.setTag(1);
                flash.setBackgroundResource(R.drawable.flash);
                fade.setBackgroundResource(R.drawable.fade);

                smooth.setBackgroundResource(R.drawable.smooth);
                String str = "STROBE";
                colorview.setText(str);
                break;
            case "106":
                fade.setBackgroundResource(R.drawable.fade01);
                flash.setBackgroundResource(R.drawable.flash);
                strobe.setBackgroundResource(R.drawable.strobe);
                smooth.setBackgroundResource(R.drawable.smooth);
                //   view.setTag(1);
                String fad = "FADE";
                colorview.setText(fad);
                break;
            case "107": {
                smooth.setBackgroundResource(R.drawable.smooth01);
                strobe.setBackgroundResource(R.drawable.strobe);
                flash.setBackgroundResource(R.drawable.flash);
                fade.setBackgroundResource(R.drawable.fade);
                // view.setTag(1);
                String fls = "SMOOTH";
                colorview.setText(fls);
                break;
            }
        }
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
            rb4.setEnabled(true);
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
            rb4.setEnabled(false);
        }
    }

    private void rb2() {
        if (!flag1) {
            rb2.setChecked(true);
            rb1.setChecked(false);
            rb3.setChecked(false);
            rb4.setChecked(false);
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
            rb4.setEnabled(false);
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
            rb4.setEnabled(false);
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
            rb4.setEnabled(true);
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
            rb4.setEnabled(false);
        }
    }

    private void rb4() {
        if (!flag4) {
            rb4.setChecked(true);
            flag4 = true;

            rep_weekly="1";

        } else {
            flag4 = false;
            rb4.setChecked(false);
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

        int NUMBER_OF_VALUES = 29;
        int PICKER_RANGE = 2;
        displayedValues  = new String[NUMBER_OF_VALUES];
        for(int i=0; i<NUMBER_OF_VALUES; i++)
            displayedValues[i] = String.valueOf(PICKER_RANGE * (i+1));

        np5.setMinValue(0);
        np5.setMaxValue(displayedValues.length-1);
        np5.setDisplayedValues(displayedValues);
        np5.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);



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



    public void delete_reprow() {

        dd = "del";
        if (typ.equals("Repeat On Days")) {
            pushtype= "rep";

            Object days = day;
            String dayss = days.toString();
            String splitDay[] = dayss.split(",");
            String a = splitDay[0];
            String b = splitDay[1];
            String c = splitDay[2];
            String d = splitDay[3];
            String e = splitDay[4];
            String f = splitDay[5];
            String g = splitDay[6];

            repdata = ont + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g  + "@" + devname + "@" + ont + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + repeaweekly + "@" + offt + "@" + offdatare + "@" + ont;

        } else if (typ.equals("Repeat On Date")) {
            pushtype= "repd";

            Object days = day;
            String dayss = days.toString();
            String splitDay[] = dayss.split(",");
            String a = splitDay[0];
            String b = splitDay[1];
            String c = splitDay[2];
            String d = splitDay[3];
            String e = splitDay[4];
            String f = splitDay[5];
            String g = splitDay[6];

            repdata = ont + "@" + a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + f + "@" + g  + "@" + devname + "@" + ont + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + repeaweekly + "@" + offt + "@" + offdatare + "@" + dateee + "@" + ont;

        }

        Thread t = new Thread() {

            public void run() {

                postupdins();

            }

        };
        t.start();

       /* yyy="http://192.168.1.101/tstatus1.php?roomno=01&user=admin12345&pass=12345678";
        try {
            post();
        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/
    }

    public void delete_cycrow() {
        pushtype = "cyc";
        dd = "del";
        repdata = ont + "@" + offt + "@" + on + "@" + offff + "@" + ont + "@" + dateee + "@" + "1" + "@" + "0" + "@" + "0" + "@" + devname + "@" + ondatare + "@" + offdatare + "@" + devtype + "@" + devicenum + "@" + switchnumber + "@" + roomnumber + "@" + ont + "@" + offt;

        Thread t = new Thread() {

            public void run() {

                postupdins();
            }

        };
        t.start();
    }



}