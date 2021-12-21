package com.example.prm391x_asm1option2_hoangbvfx06435funixeduvn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Toolbar toolbarDetail;
    ImageView imgDetail, imgHeart;
    TextView txtName, txtInfo;
    boolean fav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbarDetail = (Toolbar) findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbarDetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgDetail = (ImageView) findViewById(R.id.imageViewDetail);
        txtName = (TextView) findViewById(R.id.textViewName);
        txtInfo = (TextView) findViewById(R.id.textViewInfo);
        imgHeart = (ImageView) findViewById(R.id.heart);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int anh = bundle.getInt("img");
            String ten = bundle.getString("name");
            String thongTin = bundle.getString("info");

            imgDetail.setImageResource(anh);
            txtName.setText(ten);
            txtInfo.setText(thongTin);
        }




        // lấy thông tin được gửi từ Main về.
        fav = getIntent().getBooleanExtra("FAV", true);


        setHeart();

    }


    private void setHeart() {

        imgHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
                if (fav) {
                    imgHeart.setImageResource(R.drawable.ig_heart_asm1);
                    fav = false;
                } else {
                    imgHeart.setImageResource(R.drawable.ic_noheart_asm1);
                    fav = true;

                }

                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                intent.putExtra("isOn", true);
                setResult(RESULT_OK, intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
