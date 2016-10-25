package mad9132.rgba;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import model.HSVModel;

import java.util.Observable;
import java.util.Observer;

/**
 * The Controller for RGBAModel.
 */
public class MainActivity extends AppCompatActivity implements Observer
                                                            , SeekBar.OnSeekBarChangeListener
{
    // CLASS VARIABLES
    private static final String ABOUT_DIALOG_TAG = "About";
    private static final String LOG_TAG          = "HSV";

    // INSTANCE VARIABLES
    // Pro-tip: different naming style; the 'm' means 'member'
    private AboutDialogFragment mAboutDialog;
    private TextView            mColorSwatch;
    private HSVModel            mModel;
    private TextView            mHue;
    private TextView            mSaturation;
    private TextView            mValue;
    private SeekBar             mHueSB;
    private SeekBar             mSaturationSB;
    private SeekBar             mValueSB;

    private Button              mBlack;
    private Button              mLime;
    private Button              mBlue;
    private Button              mCyan;
    private Button              mMagenta;
    private Button              mSilver;
    private Button              mMaroon;
    private Button              mOlive;
    private Button              mGreen;
    private Button              mPurple;
    private Button              mTeal;
    private Button              mNavy;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a new AboutDialogFragment()
        // but do not show it (yet)
        mAboutDialog = new AboutDialogFragment();

        // Instantiate a new RGBA model
        // Initialize the model red (max), green (min), blue (min), and alpha (max)
        mModel = new HSVModel();
        mModel.setHue( HSVModel.MIN_HUE );
        mModel.setSaturation( HSVModel.MIN_SATURATION );
        mModel.setValue( HSVModel.MIN_LIGHTNESS );
        // The Model is observing this Controller (class MainActivity implements Observer)
        mModel.addObserver( this );

        // reference each View
        mColorSwatch = (TextView) findViewById( R.id.colorSwatch );
        mHue = (TextView) findViewById(R.id.Hue);
        mHueSB = (SeekBar) findViewById(R.id.HueSB);
        mSaturation = (TextView) findViewById(R.id.Saturation);
        mSaturationSB = (SeekBar) findViewById(R.id.SaturationSB);
        mValue = (TextView) findViewById(R.id.Value);
        mValueSB = (SeekBar) findViewById(R.id.ValueSB);

        mBlack = (Button) findViewById(R.id.blackButton);
        mLime = (Button) findViewById(R.id.limeButton);
        mBlue = (Button) findViewById(R.id.blueButton);
        mCyan = (Button) findViewById(R.id.cyanButton);
        mMagenta = (Button) findViewById(R.id.magentaButton);
        mSilver = (Button) findViewById(R.id.silverButton);
        mMaroon = (Button) findViewById(R.id.maroonButton);
        mOlive = (Button) findViewById(R.id.oliveButton);
        mGreen = (Button) findViewById(R.id.greenButton);
        mPurple = (Button) findViewById(R.id.purpleButton);
        mTeal = (Button) findViewById(R.id.tealButton);
        mNavy = (Button) findViewById(R.id.navyButton);

        // set the domain (i.e. max) for each component
        mHueSB.setMax((int)HSVModel.MAX_HUE);
        mSaturationSB.setMax((int)HSVModel.MAX_SATURATION);
        mValueSB.setMax((int)HSVModel.MAX_LIGHTNESS);

        // register the event handler for each <SeekBar>
        mHueSB.setOnSeekBarChangeListener(this);
        mSaturationSB.setOnSeekBarChangeListener(this);
        mValueSB.setOnSeekBarChangeListener(this);

        // Step 1: create local variables for all buttons and assign the right buttons to the right variables
        // Step 2: attach onClick listeners to all buttons.
        // Step 3: call a function to do something (


        mBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.black);
                setColorProgress(color);
            }
        });

        mMagenta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.magenta);
                setColorProgress(color);
            }
        });

        mLime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.lime);
                setColorProgress(color);
            }
        });

        mCyan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.cyan);
                setColorProgress(color);
            }
        });
        mSilver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.silver);
                setColorProgress(color);
            }
        });
        mMaroon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.maroon);
                setColorProgress(color);
            }
        });

        mGreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.green);
                setColorProgress(color);
            }
        });
        mPurple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.purple);
                setColorProgress(color);
            }
        });

        mTeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.teal);
                setColorProgress(color);
            }
        });
        mNavy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.navy);
                setColorProgress(color);
            }
        });
        mBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.blue);
                setColorProgress(color);
            }
        });
        mOlive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int color = getResources().getColor(R.color.olive);
                setColorProgress(color);
            }
        });


        // initialize the View to the values of the Model
        this.updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items

        switch (item.getItemId()) {

            case R.id.action_about:
                mAboutDialog.show(getFragmentManager(), ABOUT_DIALOG_TAG);
                return true;
            default:
                Toast.makeText(this, "Color: " + item.getTitle(), Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }


    }

    /**
     * Event handler for the <SeekBar>s: red, green, blue, and alpha.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
//        if ( fromUser == false ) {
//            return;
//        }
        switch (seekBar.getId()) {
            case R.id.HueSB:
                float prog = (float) mHueSB.getProgress();
                System.out.println(prog);
                mModel.setHue(prog);
                mHue.setText(R.string.Hue + prog + "\u00B0");
                break;
            case R.id.SaturationSB:
                mModel.setSaturation((float) mSaturationSB.getProgress());
                mSaturation.setText(R.string.Saturation + mModel.getSaturation() + "%");
                break;
            case R.id.ValueSB:
                mModel.setValue((float) mValueSB.getProgress());
                mValue.setText(R.string.Value + mModel.getValue() + "%");
                break;
        }
    }

    public void setColorProgress(int color){
        float[] hsvColor = new float[3];
        Color.colorToHSV(color, hsvColor);

        System.out.println("H: "+hsvColor[0]+" S: "+hsvColor[1]+" V: "+hsvColor[2]);
        mHueSB.setProgress((int) hsvColor[0]);
        mSaturationSB.setProgress((int) hsvColor[1] * 100);
        mValueSB.setProgress((int) hsvColor[2] * 100);

        Toast.makeText(getApplicationContext(), "H: "+ (int) hsvColor[0] +"\u00B0" +
                "S: "+(int) hsvColor[1] * 100 +"% "+
                "V: "+(int) hsvColor[2] * 100+"% ", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
       mHue.setText(R.string.Hue + "");
       mSaturation.setText(R.string.Saturation + "");
       mValue.setText(R.string.Value + "");
    }

    private void updateHueSB() {
        mHueSB.setProgress((int) mModel.getHue());
    }

    private void updateSaturationSB() {
        mSaturationSB.setProgress((int) mModel.getSaturation());
    }

    private void updateValueSB() {
        mValueSB.setProgress((int) mModel.getValue());
    }

    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor(mModel.getHSV());
    }

    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }

    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }
}
