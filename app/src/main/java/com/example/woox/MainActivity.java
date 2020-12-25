package com.example.woox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.woox.fargment.home.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.group_man)
    RadioGroup mGroupMan;

    @BindView(R.id.but_1)
    RadioButton mBut1;

    @BindView(R.id.but_2)
    RadioButton mBut2;

    @BindView(R.id.but_3)
    RadioButton mBut3;

    @BindView(R.id.but_4)
    RadioButton mBut4;

    @BindView(R.id.but_5)
    RadioButton mBut5;
    private FragmentManager manager;
    private HomeFragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        mBut1.setChecked(true);
    }

    public void initView() {
        //底部
        tabClick();

        homeFragment = new HomeFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.add(R.id.frag_man,homeFragment);
        tran.commit();
    }

    private void tabClick() {

        mGroupMan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but_1:

                        break;
                    case R.id.but_2:

                        break;
                    case R.id.but_3:

                        break;
                    case R.id.but_4:

                        break;
                    case R.id.but_5:

                        break;
                }
            }
        });
    }
}