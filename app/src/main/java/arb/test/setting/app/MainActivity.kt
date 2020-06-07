package arb.test.setting.app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_setting.*

class MainActivity : AppCompatActivity() {

    lateinit var per : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        per = getSharedPreferences("Setting" , Context.MODE_PRIVATE)
//        upSetting()

        btn_main_go.setOnClickListener {
            startActivity(Intent(this , Setting::class.java))
        }
    }

    override fun onStart() {
        upSetting()
        super.onStart()
    }

    fun upSetting(){

        val sizes = per.getFloat("setting_size" , 15f)

        tv_main_txt.textSize = sizes
//        btn_main_go.textSize = sizes

        tv_main_txt.typeface = Typeface.createFromAsset(assets,per.getString("font" , "sans.ttf"))

        val mediaPlayer = MediaPlayer.create(this , R.raw.play)

        if(per.getBoolean("setting_music" , false) == true) {
//            mediaPlayer.reset()
//            mediaPlayer.prepare()
            mediaPlayer.start()
        }
        else {
            if (mediaPlayer.isPlaying)
                mediaPlayer.stop()
        }

        val screen = per.getBoolean("setting_screen" , false)

        if (screen)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        else return

    }

}
