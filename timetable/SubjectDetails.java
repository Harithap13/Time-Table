package com.example.timetable;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetails extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        toolbar = (Toolbar) findViewById(R.id.ToolbarSubjectDetails);
        listview = (ListView)findViewById(R.id.lvSubjectDetails);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){

        String subjectSelected = SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF, null);
        String syllabus[] = new String[] {};
        String titles[] = getResources().getStringArray(R.array.titles);

        if(subjectSelected.equalsIgnoreCase("English")){
            syllabus =  getResources().getStringArray(R.array.English);
        }
        else if(subjectSelected.equalsIgnoreCase("Mathematics")){
            syllabus =  getResources().getStringArray(R.array.Mathematics);
        }
        else if(subjectSelected.equalsIgnoreCase("Physics")) {
            syllabus = getResources().getStringArray(R.array.Physics);
        }
        else if(subjectSelected.equalsIgnoreCase("Chemistry")) {
            syllabus = getResources().getStringArray(R.array.Chemistry);
        }
        else if(subjectSelected.equalsIgnoreCase("EG")) {
            syllabus = getResources().getStringArray(R.array.EG);
        }
        else{
            syllabus =  getResources().getStringArray(R.array.ScienceLab);
        }


        SubjectsDetailsAdapter subjectsDetailsAdapter = new SubjectsDetailsAdapter(this, titles, syllabus);
        listview.setAdapter(subjectsDetailsAdapter);
    }
    public class SubjectsDetailsAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,syllabus;
        private String[] titleArray;
        private String[] syllabusArray;

        public SubjectsDetailsAdapter(Context context, String[] title, String[] syllabus){
            mContext=context;
            titleArray=title;
            syllabusArray=syllabus;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.subject_details_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvSubjectTitle);
            syllabus = (TextView)convertView.findViewById(R.id.tvSyllabus);

            title.setText(titleArray[position]);
            syllabus.setText(syllabusArray[position]);
            return convertView;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}