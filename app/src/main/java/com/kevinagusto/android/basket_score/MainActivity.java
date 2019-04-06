package com.kevinagusto.android.basket_score;

import java.text.NumberFormat;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.content.Intent;
import android.widget.ImageButton;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import org.w3c.dom.Text;



public class MainActivity extends AppCompatActivity {
    int boleh = 1;
    int daftar0[] = {R.id.gambarA, R.id.gambarB};
    int daftar1[] = {R.drawable.menang, R.drawable.seri, R.drawable.kalah};
    int daftar2[] = {R.drawable.menang_black, R.drawable.seri_black, R.drawable.kalah_black};
    int daftar3[] = {R.drawable.ball_submit, R.drawable.ball_submit, R.drawable.lamp, R.drawable.finish};
    int daftar4[] = {R.drawable.ball_submit_black, R.drawable.ball_submit_black, R.drawable.lamp_black, R.drawable.finish_black};
    int daftar5[] = {R.id.ball1, R.id.ball2, R.id.lampu, R.id.finish};
    int tombol_home[] = { R.id.tombol_home1, R.id.tombol_home2, R.id.tombol_home3, R.id.tombol_home4 };
    int tombol[] = {R.id.undo, R.id.reset, R.id.menu, R.id.tombol_home1, R.id.tombol_home1, R.id.tombol_home2, R.id.tombol_home3, R.id.tombol_home4};
    //int to_edit_bolak_balik0[]={R.id.bawah};
    //int to_edit_bolak_balik1[]={R.id.waktu}; //waktu ga jadi
    Drawable tombol_default[] = new Drawable[this.tombol.length];
    int to_edit[] = {R.id.teamA, R.id.teamB, R.id.scoreA, R.id.scoreB, R.id.scoreTextA, R.id.scoreTextB, R.id.reset, R.id.undo, R.id.menu};
    int scoreA = 0;
    int scoreB = 0;
    String teamA = "Team A";
    String teamB = "Team B";
    int malam = 0;
    String bg = "#000000";
    int bintang[] = {R.id.bintang0,R.id.bintang1, R.id.bintang2, R.id.bintang4, R.id.bintang5, R.id.bintang6};
    String undo = "";

    String SNI_warna1 = this.malam==1?"#00e8f4":"#ffffff";
    String SNI_warna2 = this.malam==1?"#000000":"#005cb2";
    String SNI_warna3 = this.malam==1?"#ffffff":"#000000";
    String SNI_warna4 = this.malam==1?"#000000":"#ffffff";
    String bincol = this.malam==0?"#ff4081":"#f2ea07";
    int textfitur[] = {R.id.fitur0, R.id.fitur1, R.id.fitur2, R.id.fitur3};
    int textabout[] = {R.id.about0, R.id.about1, R.id.about2};
    public void tunggu(int detik)
    {
        try
        {
            Thread.sleep(1000*detik);
        }catch (Exception error) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hor_layout);

        tunggu(3);
        //startActivity(MainActivity, MainActivity)
    }
    public void update_gambar()
    {
            int dipakai[] = this.malam==0?this.daftar2:this.daftar1;
        int dipakai1[] = this.malam==1?this.daftar4:this.daftar5;
        ImageView oke = (ImageView) findViewById(this.daftar0[0]);
        ImageView eko = (ImageView) findViewById(this.daftar0[1]);
        ImageButton wow0 = (ImageButton) findViewById(this.daftar5[0]);
        ImageButton wow1 = (ImageButton) findViewById(this.daftar5[1]);
        ImageButton wow2 = (ImageButton) findViewById(this.daftar5[2]);

            switch (this.malam)
            {
                case 0:
                    dipakai = this.daftar1;
                    break;
                case 1:
                    dipakai = this.daftar2;
                    break;
            }
            if (this.scoreA > this.scoreB)
            {

                oke.setImageResource(dipakai[0]);
                eko.setImageResource(dipakai[2]);

            }
            if (this.scoreA < this.scoreB)
            {
                oke.setImageResource(dipakai[2]);
                eko.setImageResource(dipakai[0]);
            }
            if (this.scoreB == this.scoreA)
            {
                oke.setImageResource(dipakai[1]);
                eko.setImageResource(dipakai[1]);
            }
            //update gambar Button

        String warna = this.malam==0?"#ffffff":"#000000";
        for (int i = 0; i < this.daftar5.length; i++)
        {
            int gmbr[] = this.malam==0?this.daftar3:this.daftar4;
            int to_edit = this.daftar5[i];
            ImageButton nana = (ImageButton) findViewById(to_edit);
            nana.setImageResource(gmbr[i]);
            nana.setBackgroundColor(Color.parseColor(warna));
        }
    }
    private void setScoreA()
    {
        TextView oke = (TextView) findViewById(R.id.scoreA);
        Animation eko = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        oke.startAnimation(eko);
        oke.setText(Integer.toString(this.scoreA));
    }
    private void setScoreB()
    {
        TextView oke = (TextView) findViewById(R.id.scoreB);
        Animation eko = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        oke.startAnimation(eko);
        oke.setText(Integer.toString(this.scoreB));
    }
    private void refresh()
    {
        int starlist[] = {R.id.bintang0, R.id.bintang1, R.id.bintang2, R.id.bintang4, R.id.bintang5, R.id.bintang6};
        for (int i = 0; i < starlist.length; i++)
        {
            RatingBar oke = (RatingBar) findViewById(starlist[i]);
            oke.setRating(0F);
        }
        this.update_gambar();
        //update color
        this.update_color();
        this.setScoreA();
        this.setScoreB();

    }
    public void update_button_border()
    {
        try{
            for (int i = 0; i < this.tombol.length; i++)
            {
                int to_edit = this.tombol[i];
                Button oke = (Button) findViewById(to_edit);
                if (this.boleh==1)
                {this.tombol_default[i] = oke.getBackground();}//default one harus  dikasih tau bahwa ini hanya akan terjadi sekali
                if (this.malam==1) {
                    oke.setBackground((Drawable) getDrawable(R.drawable.tombol));
                }
                else{
                    //XmlResourceParser yoi = getResources().getLayout(R.layout.tombol1);
                    //setContentView(R.layout.hor_layout);
                    oke.setBackground(this.tombol_default[i]);
                    //{eko.setBackgroundColor(getResources().getColor(R.color.latbe1));
                }
            }
        }catch (Exception error)
        {
            int yaudah = 0;
        }

    }
    public void update_color()
    {
        String SNI_warna = this.malam==1?"#00e8f4":"#000000";
        String SNI_warna1 = this.malam==1?"#00e8f4":"#ffffff";
        String SNI_warna2 = this.malam==1?"#000000":"#005cb2";
        String SNI_warna3 = this.malam==1?"#ffffff":"#000000";
        String SNI_warna4 = this.malam==1?"#000000":"#ffffff";
        String bincol = this.malam==0?"#ff4081":"#f2ea07";
        /*
        for (int i = 0; i < this.to_edit_bolak_balik0.length; i++)
        {
            int what = this.to_edit_bolak_balik0[i];
            View oke = findViewById(what);
            oke.setBackgroundColor(Color.parseColor(SNI_warna4));
        }
        //update yang paling bawah
        //((View) findViewById(R.id.bawah)).setBackgroundColor(Color.parseColor(SNI_warna3));
        //((View) findViewById(R.id.waktu)).setBackgroundColor(Color.parseColor(SNI_warna3));
        ((TextView) findViewById(R.id.waktu)).setTextColor(Color.parseColor(SNI_warna1));
        //edit text
        */
        for (int i = 0; i<this.to_edit.length; i++)
        {
            int edit = this.to_edit[i];
            TextView oke = (TextView) findViewById(edit);
            oke.setTextColor(Color.parseColor(SNI_warna));
        }
        for (int i = 0; i < this.bintang.length; i++) {
            RatingBar okee = (RatingBar) findViewById(this.bintang[i]);
            LayerDrawable draw = (LayerDrawable) okee.getProgressDrawable();
            draw.getDrawable(0).setColorFilter(Color.parseColor(SNI_warna), PorterDuff.Mode.SRC_ATOP);
            draw.getDrawable(2).setColorFilter(Color.parseColor(bincol), PorterDuff.Mode.SRC_ATOP);
        }
        //pesan
        TextView pesan = (TextView) findViewById(R.id.pesan);
        pesan.setTextColor(Color.parseColor(SNI_warna1));
        //button border
        this.update_button_border();
        this.boleh=0;
        //update garis_tengah
        LinearLayout ganteng = (LinearLayout) findViewById(R.id.garis_tengah);
        ganteng.setBackgroundColor(Color.parseColor(SNI_warna2));
    }

    public void reset(View view)
    {
        //reset background
        this.malam=1;
        update_session(findViewById(R.id.lampu));
        this.scoreB=0;
        this.scoreA=0;
        this.setScoreA();
        this.setScoreB();
        this.refresh();
        this.setmessage("Message");
        this.undo = "";
    }
    private void setmessage(String a)
    {
        TextView b = (TextView) findViewById(R.id.pesan);
        b.setMaxLines(2);
        Animation mulai = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        b.startAnimation(mulai);
        b.setText(a);
        this.refresh();
    }
    public int update_session(View view)
    {

        //update background color
        View oke = (View) findViewById(R.id.latbel);
        View eko = oke.getRootView();
        int dipakai[] = this.malam==0?this.daftar2:this.daftar1;
        if (this.malam==0)
        {eko.setBackgroundColor(getResources().getColor(R.color.latbe1));
            //update ratingbar color
            //update ImageView

        this.malam=1;
            this.refresh();
        return 0;}

        if (this.malam==1)
        {eko.setBackgroundColor(getResources().getColor(R.color.latbe0));
        //update ratingbar color
            //draw.setColorFilter(Color.parseColor("#f2ea07"), PorterDuff.Mode.SRC_ATOP);
            //okee.setTint
        this.malam=0;
            this.refresh();
            return 0;}
        return 0;
    }
    public void undo(View view)
    {
        String to_un[] = this.undo.split(" "); // {"A-1", "A-2"}
        String to_edit0[] = to_un[to_un.length-1].split("-");
        String to_edit1[] = to_edit0;
        switch (to_edit1[0])
        {
            case "A":
                this.scoreA -= Integer.parseInt(to_edit1[1]);
                break;
            case "B":
                this.scoreB -= Integer.parseInt(to_edit1[1]);
                break;
        }
        this.refresh();
        /*
        //if (to_un.length>0)
        {
        try{
        for (int i = to_un.length-1; i != 0; i--)
        {

            String to_effect0 = to_un[i];
            String to_effect1[] = to_effect0.split("-");
            switch (to_effect1[0])
            {
                case "A":
                    this.scoreA -= Integer.parseInt(to_effect1[1]);
                    break;
                case "B":
                    this.scoreB -= Integer.parseInt(to_effect1[1]);
                    break;
            }
        }
        //hapus jejak
            String set_undo = "";
            for (int i = 0; i < (to_un.length)-1;i++)
            {
                set_undo += to_un[i];
            }
            this.undo = set_undo;
            this.refresh();

        }catch (Exception oke)
        {
            int yaudah=0;
        }
    }*/
    }
    public void submitA(View view)
    {
     int total = 0;
     RatingBar A0 = (RatingBar) findViewById(R.id.bintang0);
     RatingBar A1 = (RatingBar) findViewById(R.id.bintang1);
     RatingBar A2 = (RatingBar) findViewById(R.id.bintang2);
     total  +=  A0.getRating() + A1.getRating() + A2.getRating();
        this.scoreA += total;
     //find Team Name
        TextView nama = (TextView) findViewById(R.id.teamA);
        this.teamA = nama.getText().toString();
        String pesan = this.teamA  + " + " + total;
        switch (total)
        {
            case 1:
                this.setmessage(this.teamA + " Free Throw");
                break;
            default:
                this.setmessage(pesan);
                break;
        }
        this.undo += "A-" + Integer.toString(total) + " ";
     this.setScoreA();
    }
    public void submitB(View view)
    {
        int total = 0;
        RatingBar A0 = (RatingBar) findViewById(R.id.bintang4);
        RatingBar A1 = (RatingBar) findViewById(R.id.bintang5);
        RatingBar A2 = (RatingBar) findViewById(R.id.bintang6);
        total  +=  A0.getRating() + A1.getRating() + A2.getRating();
        this.scoreB += total;
        //find Team Name
        TextView nama = (TextView) findViewById(R.id.teamB);
        this.teamB = nama.getText().toString();
        String pesan = this.teamB  + " + " + total;
        this.undo += "B-" + Integer.toString(total) + " ";
        switch (total)
        {
            case 1:
                this.setmessage(this.teamB + " Free Throw");
                break;
            default:
                this.setmessage(pesan);
                break;
        }
        this.setScoreB();
    }
    public void menu(View view)
    {

        setContentView(R.layout.menu);
        this.update_button_border();
        //mantap jiwa
    }
    public void home(View view)
    {
        //View oke = (View) findViewById(R.id.tombol_home0);
        setContentView(R.layout.hor_layout);
        this.refresh();
        //this.update_session(oke);
    }
    public void home1()
    {
        //View oke = (View) findViewById(R.id.tombol_home0);
        setContentView(R.layout.hor_layout);
        this.refresh();
    }
    public void fitur(View view)
    {
        String SNI_warna = this.malam==1?"#00e8f4":"#000000";
        setContentView(R.layout.fitur);
        for (int i = 0; i < this.textfitur.length; i++)
        {
            int to_edit = this.textfitur[i];
            TextView goo = findViewById(to_edit);
            goo.setTextColor(Color.parseColor(SNI_warna));
        }
    }
    public void settings(View view)
    {
        setContentView(R.layout.activity_settings);
    }
    public void about(View view)
    {
        setContentView(R.layout.about);
        String SNI_warna = this.malam==1?"#00e8f4":"#000000";
        for (int i = 0; i < this.textabout.length; i++)
        {
            int to_edit = this.textabout[i];
            TextView goo = findViewById(to_edit);
            goo.setTextColor(Color.parseColor(SNI_warna));
        }
    }

    public void pemenang(View view)
    {
        /*
        Animation mulai = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        b.startAnimation(mulai);
        b.setText(a);*/
        String SNI_warnaa = this.malam==1?"#00e8f4":"#000000";
        setContentView(R.layout.pemenang);
        TextView twi = findViewById(R.id.the_winner_is);
        TextView wt = findViewById(R.id.winner_team);
        Animation mulai = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein3);
        Animation mulai1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein8);
        twi.startAnimation(mulai);
        twi.setTextColor(Color.parseColor(SNI_warnaa));
        wt.setTextColor(Color.parseColor(SNI_warnaa));
        twi.setText("THE WINNER IS");
        //twi.startAnimation(berhenti);
        String pemenang="DRAW";
        if (this.scoreA>this.scoreB)
        {
            pemenang = this.teamA;
        }
        if (this.scoreB>this.scoreA)
        {
            pemenang = this.teamB;
        }
        wt.setText(pemenang);
        //twi.setText("");
        wt.startAnimation(mulai1);
    }
}
