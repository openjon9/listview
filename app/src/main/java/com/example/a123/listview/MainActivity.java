package com.example.a123.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private List<String> groupkey=new ArrayList<String>(); //標題集合
    private List<String>  list=null;
    private List<String> aList = new ArrayList<String>();//第一組集合
    private List<String> bList = new ArrayList<String>();//第二組集合
    private List<String> cList = new ArrayList<String>();//第三組集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=(ListView)findViewById(R.id.listview);
        initData();
        MyAdapter adapter=new MyAdapter();
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!groupkey.contains(parent.getItemAtPosition(position).toString())){
                    Toast.makeText(MainActivity.this, list.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initData() {
        list = new ArrayList<String>();

        for(int i=0; i<5; i++){
            aList.add("A组"+i);
        }

        list.add("A组");
        list.addAll(aList);

       for(int i=0; i<8; i++){
            bList.add("B组"+i);
        }
        list.add("B组");
        list.addAll(bList);

        for(int i=0; i<15; i++){
            cList.add("C組"+i);
        }
        list.add("C組");
        list.addAll(cList);

        groupkey.add("A组");
        groupkey.add("B组");
        groupkey.add("C組");
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=convertView;
            if (groupkey.contains(getItem(position))){
                Log.i("AA",getItem(position)+"");
                Log.i("AA",list.get(15).toString());
                view = LinearLayout.inflate(getApplicationContext(),R.layout.list_item1,null);
            }else {
                view = LinearLayout.inflate(getApplicationContext(),R.layout.list_item2,null);
            }
            TextView item_text = (TextView) view.findViewById(R.id.item_text);
            item_text.setText(getItem(position).toString());
            return view;
        }
    }
}
