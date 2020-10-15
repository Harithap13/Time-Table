package com.example.timetable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

public class FacultyActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar= (Toolbar) findViewById(R.id.ToolbarFaculty);
        listView=(ListView)findViewById(R.id.lvFaculty);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
    }

    private void setupListView(){

        String[] name = getResources().getStringArray(R.array.staff);
        String[] email = getResources().getStringArray(R.array.email);
        String[] phone = getResources().getStringArray(R.array.phone);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, name, email, phone);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        String aEmailList[] = { "anithak@gmail.com"};
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                        emailIntent.setType("plain/text");
                        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
                        break;
                    }
                    case 1: {
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        String aEmailList[] = { "raman_v@gmail.com"};
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                        emailIntent.setType("plain/text");
                        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
                        break;
                    }
                    case 2: {
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        String aEmailList[] = { "keerthanaS@hotmail.com"};
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                        emailIntent.setType("plain/text");
                        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
                        break;
                    }
                    case 3: {
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        String aEmailList[] = { "profjenny@gmail.com"};
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                        emailIntent.setType("plain/text");
                        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
                        break;
                    }
                    case 4: {
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        String aEmailList[] = { "murhty_a@hotmail.com"};
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                        emailIntent.setType("plain/text");
                        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
                        break;
                    }

                }
            }
        });

    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView name,email,phone;
        private String[] nameArray;
        private String[] emailArray;
        private String[] phoneArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description, String[] phone){
            mContext=context;
            nameArray=title;
            emailArray=description;
            phoneArray=phone;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return nameArray.length;
        }

        @Override
        public Object getItem(int position) {
            return nameArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_faculty_single_item, null);
            }

            name = (TextView)convertView.findViewById(R.id.tvFaculty);
            email = (TextView)convertView.findViewById(R.id.tvEmail);
            phone = (TextView)convertView.findViewById(R.id.tvNum);
            imageView = (ImageView)convertView.findViewById(R.id.ivFaculty);

            name.setText(nameArray[position]);
            email.setText(emailArray[position]);
            phone.setText(phoneArray[position]);
            imageView.setImageResource(R.drawable.fac1);

            return convertView;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}