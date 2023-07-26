package android.demofirebase03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    Button btnInsert, btnDelete, btnUpdate;
    ListView lvKq;

    ArrayList<User>lsUser=new ArrayList<>();
    ArrayList<String>dataLV = new ArrayList<>();
    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        //-------------------
        initData();

        //-------------------
        addEvent();


    }

    public  void addControls()
    {
        edtName=(EditText) findViewById(R.id.edtName);
        edtAge=(EditText) findViewById(R.id.edtAge);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnDelete=(Button) findViewById(R.id.btnDelete);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        lvKq = (ListView) findViewById(R.id.lvKq);
    }
    public void addEvent()
    {

    }

    public  void initData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        for(int i=0;i<5;i++)
        {
            User u = new User("Ten_"+i,20+i);
            myRef.child("User_"+i).setValue(u);
        }
    }
    public ArrayList<String> convertToArrayString(ArrayList<User>lsUs)
    {
        ArrayList<String>lsKq = new ArrayList<>();
        for (User u:lsUs ) {
            String s = "Name: " + u.getName() + " - " + "Age: " + u.getAge();
            lsKq.add(s);
        }
        return lsKq;
    }
    //Load dữ liệu từ firebase và đưa lên ListView
    public  void loadDataFromFirebase()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");

    }
}