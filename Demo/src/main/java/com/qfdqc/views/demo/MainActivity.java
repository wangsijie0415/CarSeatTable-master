package com.qfdqc.views.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qfdqc.views.seattable.SeatTable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public SeatTable seatTableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        seatTableView = (SeatTable) findViewById(R.id.seatView);
        seatTableView.setScreenName("8号厅荧幕");//设置屏幕名称
        seatTableView.setMaxSelected(3);//设置最多选中

        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            /**
             * 设置不可用座位
             * @param row   从0开始算
             * @param column 从0开始算
             * @return
             */
            @Override
            public boolean isValidSeat(int row, int column) {
                if((row == 0||row == 1||row == 2||row == 3) && (column == 1||column == 4||column == 2||column == 3)){
                    return false;
                }else if((row == 4||row == 5||row == 6||row == 7||row == 8 )  &&(column == 2||column == 3)){
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if(row==6&&column==5){
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {

            }

            @Override
            public void unCheck(int row, int column) {

            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        seatTableView.setData(10,6);

    }

}
