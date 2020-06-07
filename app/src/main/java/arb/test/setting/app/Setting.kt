package arb.test.setting.app

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_setting.*

class Setting : AppCompatActivity() {

    lateinit var per : SharedPreferences
    val size1 = 15f
    val size2 = 20f
    val size3 = 25f
    val font1 = "sans.ttf"
    val font2 = "yekan.ttf"
    val font3 = "sharp.ttf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        per = getSharedPreferences("Setting" , Context.MODE_PRIVATE)

//        upSetting()

        chb_Setting_music.setOnCheckedChangeListener { buttonView, isChecked ->

            val edit = per.edit()
            edit.putBoolean("setting_music" , isChecked)
            edit.apply()

//            Toast.makeText(this , per.getBoolean("setting_music" , false).toString() , Toast.LENGTH_SHORT).show()
        }

        chb_Setting_screen.setOnCheckedChangeListener { buttonView, isChecked ->

            val edit = per.edit()
            edit.putBoolean("setting_screen" , isChecked)
            edit.apply()

//            Toast.makeText(this , per.getBoolean("setting_screen" , false).toString() , Toast.LENGTH_SHORT).show()
        }

        rad_Setting_size1.setOnClickListener {

            val edit = per.edit()
            edit.putFloat("setting_size" , size1)
            edit.apply()

            tv_Setting_view.textSize = per.getFloat("setting_size" , 15f)

//            Toast.makeText(this , per.getFloat("setting_size" , 15f).toString() , Toast.LENGTH_SHORT).show()
        }

        rad_Setting_size2.setOnClickListener {

            val edit = per.edit()
            edit.putFloat("setting_size" , size2)
            edit.apply()

            tv_Setting_view.textSize = per.getFloat("setting_size" , 15f)

//            Toast.makeText(this , per.getFloat("setting_size" , 15f).toString() , Toast.LENGTH_SHORT).show()
        }

        rad_Setting_size3.setOnClickListener {

            val edit = per.edit()
            edit.putFloat("setting_size" , size3)
            edit.apply()

            tv_Setting_view.textSize = per.getFloat("setting_size" , 15f)

//            Toast.makeText(this , per.getFloat("setting_size" , 15f).toString() , Toast.LENGTH_SHORT).show()
        }

        rad_Setting_font1.setOnClickListener {

            val edit = per.edit()
            edit.putString("font" , font1)
            edit.apply()

            tv_Setting_view.typeface = Typeface.createFromAsset(assets , per.getString("font" , font1))

        }

        rad_Setting_font2.setOnClickListener {

            val edit = per.edit()
            edit.putString("font" , font2)
            edit.apply()

            tv_Setting_view.typeface = Typeface.createFromAsset(assets , per.getString("font" , font2))

        }

        rad_Setting_font3.setOnClickListener {

            val edit = per.edit()
            edit.putString("font" , font3)
            edit.apply()

            tv_Setting_view.typeface = Typeface.createFromAsset(assets , per.getString("font" , font3))

        }


    }

    override fun onResume() {
        upSetting()
        super.onResume()
    }

    fun upSetting(){

        chb_Setting_music.isChecked = per.getBoolean("setting_music" , false)

        chb_Setting_screen.isChecked = per.getBoolean("setting_screen" , false)

        val sizes = per.getFloat("setting_size" , 15f)

        if (sizes == 15f)
            rad_Setting_size1.isChecked = true
            else if (sizes == 20f)
            rad_Setting_size2.isChecked = true
            else if (sizes == 25f)
            rad_Setting_size3.isChecked = true

        val fonts = per.getString("font" , font1)

        if (fonts == font1)
            rad_Setting_font1.isChecked = true
            else if (fonts == font2)
            rad_Setting_font2.isChecked = true
            else if (fonts == font3)
            rad_Setting_font3.isChecked = true

        tv_Setting_view.textSize = sizes
        tv_Setting_view.typeface = Typeface.createFromAsset(assets,per.getString("font" , "sans.ttf"))
    }
}
