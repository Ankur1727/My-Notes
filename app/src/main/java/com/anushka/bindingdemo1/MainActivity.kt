package com.mynotes.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mynotes.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var databing: ActivityMainBinding;
    private lateinit var viewmode: ViewModulClas
    private  lateinit var viewModulFactory: ViewModulFactory
    var ciunt:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databing = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        );
        //  databing.student = getdisplayStudent()
     //  viewModulFactory = ViewModulFactory(12)
        viewmode =ViewModelProvider(this).get(ViewModulClas::class.java)
        databing.myviewmodel = viewmode
        databing.lifecycleOwner = this


        //  databing.greetingTextView.text = viewmode.getCurrentCount().toString()
        // Toast.makeText(this,viewmode.getCurrentCount().toString(),Toast.LENGTH_LONG).show()
      //  databing.greetingTextView.text= (ciunt.toString())
//        viewmode.totalcount.observe(this, Observer {
//            databing.greetingTextView.text = it.toString()
//        })
       // Toast.makeText(this,viewmode.setCurrentNumber().toString(),Toast.LENGTH_LONG).show()

//        databing.submitButton.setOnClickListener {
//           viewmode.getUpdateCount()
//
//             //databing.greetingTextView.text = viewmode.getUpdateCount().toString()
//        }

        //     setContentView(R.layout.activity_main)
//        val button = findViewById<Button>(R.id.submit_button)
//        databing.submitButton.setOnClickListener {
//            displayGreeting()
//        }
    }

    private fun displayGreeting() {

//        val messageView = findViewById<TextView>(R.id.greeting_text_view)
//        val nameText = findViewById<EditText>(R.id.name_edit_text)

        databing.apply {
            val message = "Hello! " + nameEditText.text
            progresBar.visibility = View.VISIBLE
            greetingTextView.text = message
            //    progresBar.visibility =View.GONE
        }


    }




}
