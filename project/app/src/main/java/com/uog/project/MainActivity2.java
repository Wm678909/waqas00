package com.uog.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText name, room, complain;
    Button insert, update, delete, view;
    private DBHelp2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        name=findViewById(R.id.name);
        complain =findViewById(R.id.complain);
        room =findViewById(R.id.room);
        insert=findViewById(R.id.btnInsert);
        update=findViewById(R.id.btnupdate);
        delete=findViewById(R.id.btnDelete);
        view=findViewById(R.id.btnView);
        DB= new DBHelp2(this);

        insert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String roomTXT = room.getText().toString();
                String complainTXT = complain.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, roomTXT,complainTXT);

                if(checkinsertdata==true)
                    Toast.makeText(MainActivity2.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String roomTXT = room.getText().toString();
                String complainTXT = complain.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, roomTXT,complainTXT);

                if(checkupdatedata==true)
                    Toast.makeText(MainActivity2.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "Entry Not Updated", Toast.LENGTH_SHORT).show();

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();

                Boolean checkdeletedata = DB.deletedata(nameTXT);

                if(checkdeletedata==true)
                    Toast.makeText(MainActivity2.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity2.this, "No entry Exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name:"+res.getString(0)+"\n");
                    buffer.append("Room:" + res.getString(1) + "\n");
                    buffer.append("Complain.:"+res.getString( 2)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);
                builder.setCancelable(true);
                builder.setTitle("Student Registered");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}