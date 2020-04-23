package id.ac.polinema.prokjekuts.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import id.ac.polinema.prokjekuts.R;

public class DetailActivity extends AppCompatActivity {
    private TextView tName;
    private TextView tRemarks;
    private TextView tDesc;
    private ImageView tPhoto;

    private String name, remarks, desc, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tName = (TextView) findViewById(R.id.item_name);
        tRemarks = (TextView) findViewById(R.id.item_remarks);
        tDesc = (TextView) findViewById(R.id.item_desc);
        tPhoto = (ImageView) findViewById(R.id.item_img);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        remarks = intent.getStringExtra("remarks");
        desc = intent.getStringExtra("desc");
        photo = intent.getStringExtra("photo");

        tName.setText(name);
        tRemarks.setText(remarks);
        tDesc.setText(desc);

        Glide.with(this)
                .load(photo)
                .override(150, 150)
                .crossFade()
                .into(tPhoto);
    }
}
