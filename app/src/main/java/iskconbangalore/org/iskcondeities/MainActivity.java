    package iskconbangalore.org.iskcondeities;

    import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;

    public class MainActivity extends AppCompatActivity {
        ImageView iv;
        int i=0;
        int day = 0;
        private String[] deities = {"sp","pn","sg","rk","ng","kb"};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    //
           // View view = (View) )//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    //        setSupportActionBar(toolbar);

            //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            iv = (ImageView) findViewById(R.id.img1);
    //        fab.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View view) {
    //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    //                        .setAction("Action", null).show();
    //            }
    //        });

            int drawableID = this.getResources().getIdentifier("d", "drawable", getPackageName());
          //  iv.setImageResource(drawableID);
            View view = findViewById(R.id.img1);
           // View view = new View(findViewById(R.id.img1));
          view.setOnTouchListener(new OnSwipeTouchListener(this) {
                @Override
                public void onSwipeLeft() {
                    // Whatever

                        //Log.d("info", "swipeLeft = " + "True");
                        // Toast.makeText(getApplicationContext(), "You wenf Left", Toast.LENGTH_LONG).show();
                        next_image();

                }

              public void onSwipeRight(){
                //  Toast.makeText(getApplicationContext(), "You wenf Right", Toast.LENGTH_LONG).show();
                  previous_image();
              }
            });
             day = findDay();
                    Log.d("info","Day="+day);
        }

        public void next_image()
        {     if(i<5) {

            i = i + 1;



            String display_image = ""+deities[i]+day;
            //Toast.makeText(getApplicationContext(), display_image, Toast.LENGTH_LONG).show();
            int drawableID = this.getResources().getIdentifier(display_image, "drawable", getPackageName());
            iv.setImageResource(drawableID);
        }
        }
        public void previous_image()

        {   String display_image="";
            if (i>0)
            {
                i = i - 1;
            //
                if (i==0)
                     display_image = ""+deities[i];
                else
                    display_image = ""+deities[i]+day;
                //Toast.makeText(getApplicationContext(), display_image, Toast.LENGTH_LONG).show();
                int drawableID = this.getResources().getIdentifier(display_image, "drawable", getPackageName());
                iv.setImageResource(drawableID);
            }
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        public int findDay()
        {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            int ret=0;

            switch (day) {
                case Calendar.SUNDAY:
                    // Current day is Sunday
                    ret= 0;
                    break;

                case Calendar.MONDAY:
                    // Current day is Monday
                    ret= 1;
                    break;
                case Calendar.TUESDAY:
                    ret= 2;
                    break;
                    // etc.
                case Calendar.WEDNESDAY:
                    ret= 3;
                    break;

                case Calendar.THURSDAY:
                    ret= 4;
                    break;

                case Calendar.FRIDAY:
                     ret= 5;

                case Calendar.SATURDAY:
                     ret=6;
                    break;
            }
            return ret;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
