package com.mynotes.notes.adpter

import `in`.aabhasjindal.otptextview.OtpTextView
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.KeyEvent.KEYCODE_ENTER
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mynotes.notes.R
import com.mynotes.notes.db.Notes_Database
import com.mynotes.notes.db.Notes_Enitiy
import com.mynotes.notes.db.Password_Entity
import kotlinx.android.synthetic.main.notes_adpter.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Notes_Adpter(var notesEnitiy: List<Notes_Enitiy>, var context: Context, var color: String) :
    RecyclerView.Adapter<MyViewHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoler {
        val layoutInflater = LayoutInflater.from(parent.context)
        val list_itm = layoutInflater.inflate(R.layout.notes_adpter, parent, false)
        return MyViewHoler(list_itm)
    }

    override fun getItemCount(): Int {
        return notesEnitiy.size
    }

    override fun onBindViewHolder(holder: MyViewHoler, position: Int) {
        holder.view.txt_title.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.view.txt_title.text = notesEnitiy[position].title
        holder.view.txt_notes.text = notesEnitiy[position].note
        if (color != null) {
            if (color.equals("sky_blue")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.sky_blue))
                }
            } else if (color.equals("orange")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.orange))
                }
            } else if (color.equals("light_green")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_green))
                }
            } else if (color.equals("light_yellow")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_yellow))
                }
            } else if (color.equals("light_red")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_red))
                }
            } else if (color.equals("light_black")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_black))
                }
            } else if (color.equals("light_greay")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_greay))
                }
            } else if (color.equals("light_pink")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_pink))
                }
            } else if (color.equals("light_purple")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.view.cardView.setCardBackgroundColor(context.getColor(R.color.light_purple))
                }
            }
        }
        if (notesEnitiy[position].fav != null && notesEnitiy[position].fav.equals("true")) {
            holder.view.img_fav.setImageResource(R.drawable.ic_lock_outline_black_24dp)
            holder.view.img_fav.visibility = View.VISIBLE
            holder.view.txt_title.visibility = View.VISIBLE
            holder.view.txt_notes.text = "*****************\n**************"
            holder.view.delete.visibility = View.GONE
            //    holder.view.img_fav.textAlignment= Gravity.CENTER
            // holder.view.img_fav_lott.visibility = View.VISIBLE
        }
        holder.view.img_fav.setOnClickListener {
            //            var lock:Boolean =false
//            CoroutineScope(Dispatchers.Main).launch {
//                val favs = Notes_Database(context).getNotesDao().getAllFav()
//                if (favs.size==0){
//                    lock =true
//                }
//            }
//            if (lock){
//
//            }
            CoroutineScope(Dispatchers.Main).launch {
                val notes = Notes_Database(context).getPassword().getPassowrd()
                if (notes.size == 0) {
                    val dialog = Dialog(context)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setCancelable(false)
                    dialog.setContentView(R.layout.custom_layout_password)
                    val txt_text = dialog.findViewById(R.id.txt_text) as TextView

                    val edt_first = dialog.findViewById(R.id.edt_one) as EditText
                    val edt_second = dialog.findViewById(R.id.edt_two) as EditText
                    val edt_third = dialog.findViewById(R.id.edt_third) as EditText
                    val edt_four = dialog.findViewById(R.id.edt_four) as EditText
                    val btn_done = dialog.findViewById(R.id.done_password) as Button
                    btn_done.setText("Done")
                    val otp_view = dialog.findViewById(R.id.otp_view) as OtpTextView


                    txt_text.setText("Create Password")
//                    val password= edt_first.text.toString()+edt_second.text.toString()+edt_third.text.toString()+edt_four.text.toString()
//                    System.out.println(password)


                    btn_done.setOnClickListener {

                        val password =
                            edt_first.text.toString() + edt_second.text.toString() + edt_third.text.toString() + edt_four.text.toString()
                        System.out.println(password)
                        val otp=   otp_view.otp
                        if (!otp.equals("") &&otp!!.length == 4) {
                            val paswor = Password_Entity(otp)
                            CoroutineScope(Dispatchers.Main).launch {
                                Notes_Database(context).getPassword().insertPassword(paswor)
                            }

                            dialog.dismiss()
                        } else {
                            Toast.makeText(
                                context,
                                "Please Enter Valid Password",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    dialog.show()
                    return@launch

                } else {
                    if (notesEnitiy[position].fav != null && notesEnitiy[position].fav.equals("false")) {
//                notesEnitiy[position].fav  ="false"
//                holder.view.img_fav.setImageResource(R.drawable.ic_lock_open_black_24dp)
                        notesEnitiy[position].fav = "true"
                        //  holder.view.img_fav.visibility = View.GONE
                        holder.view.img_fav.setImageResource(R.drawable.ic_lock_outline_black_24dp)
                        holder.view.txt_title.visibility = View.GONE
                        holder.view.txt_notes.text = "*****************\n**************"
                        holder.view.delete.visibility = View.GONE

                    } else {
                        val dialog = Dialog(context)
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                        //  dialog.setCancelable(false)
                        dialog.setContentView(R.layout.custom_layout_password)
                        val edt_first = dialog.findViewById(R.id.edt_one) as EditText
                        val edt_second = dialog.findViewById(R.id.edt_two) as EditText
                        val edt_third = dialog.findViewById(R.id.edt_third) as EditText
                        val edt_four = dialog.findViewById(R.id.edt_four) as EditText
                        val btn_done = dialog.findViewById(R.id.done_password) as Button
                        val otp_view = dialog.findViewById(R.id.otp_view) as OtpTextView
//                    val password= edt_first.text.toString()+edt_second.text.toString()+edt_third.text.toString()+edt_four.text.toString()
//                    System.out.println(password)


                        btn_done.setOnClickListener {
                            val otp=   otp_view.otp
                            val password =
                                edt_first.text.toString() + edt_second.text.toString() + edt_third.text.toString() + edt_four.text.toString()
                            System.out.println(password)
                            CoroutineScope(Dispatchers.Main).launch {
                                val db_pass = Notes_Database(context).getPassword().getPassowrd()
                                if (otp.equals(db_pass[0].pas)) {
                                    notesEnitiy[position].fav = "false"
                                    holder.view.img_fav.setImageResource(R.drawable.ic_lock_open_black_24dp)
                                    val note = Notes_Enitiy(
                                        notesEnitiy[position].title,
                                        notesEnitiy[position].note,
                                        notesEnitiy[position].fav
                                    )
                                    note.id = notesEnitiy[position].id
                                    CoroutineScope(Dispatchers.Main).launch {
                                        Notes_Database(context).getNotesDao().upDate(note)
                                    }
                                    holder.view.txt_title.visibility = View.VISIBLE
                                    holder.view.txt_notes.visibility = View.VISIBLE
                                    holder.view.delete.visibility = View.VISIBLE
                                    holder.view.txt_title.text = notesEnitiy[position].title
                                    holder.view.txt_notes.text = notesEnitiy[position].note
                                    dialog.dismiss()
                                    return@launch
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Please Enter Valid Password",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    //  dialog.dismiss()
                                    return@launch
                                }
                            }


                        }

                        dialog.show()
                    }
                    val note = Notes_Enitiy(
                        notesEnitiy[position].title,
                        notesEnitiy[position].note,
                        notesEnitiy[position].fav
                    )
                    note.id = notesEnitiy[position].id
                    CoroutineScope(Dispatchers.Main).launch {
                        Notes_Database(context).getNotesDao().upDate(note)
                    }
                }


//            else{
//
//         //       holder.view.img_fav_lott.visibility = View.VISIBLE
//                //   holder.view.img_fav_lott.setAnimation("biology.json")
//            }

            }


        }
        holder.view.delete.setOnClickListener {

            ///////////

            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)

            builder.setTitle("Are you sure?")

            builder.setPositiveButton("YES",
                DialogInterface.OnClickListener { dialog, which ->
                    // Do nothing but close the dialog
                    dialog.dismiss()
                    val note = Notes_Enitiy(
                        notesEnitiy[position].title,
                        notesEnitiy[position].note,
                        notesEnitiy[position].fav
                    )
                    note.id = notesEnitiy[position].id
                    CoroutineScope(Dispatchers.Main).launch {
                        Notes_Database(context).getNotesDao().deleteData(note)
                        it.findNavController().navigate(R.id.action_add_Notes_self)
                    }
                })

            builder.setNegativeButton("NO",
                DialogInterface.OnClickListener { dialog, which ->
                    // Do nothing
                    dialog.dismiss()
                })

            val alert: android.app.AlertDialog = builder.create()
            alert.show()


        }
        holder.view.setOnClickListener {
            try {


//            var action = Add_NotesDirections.actionAddNotesToSaveNotes()
//            action.to = notesEnitiy[position]

                if (notesEnitiy[position].fav != null && notesEnitiy[position].fav.equals("true")) {

                    val dialog = Dialog(context)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    //  dialog.setCancelable(false)
                    dialog.setContentView(R.layout.custom_layout_password)
                    val edt_first = dialog.findViewById(R.id.edt_one) as EditText
                    val edt_second = dialog.findViewById(R.id.edt_two) as EditText
                    val edt_third = dialog.findViewById(R.id.edt_third) as EditText
                    val edt_four = dialog.findViewById(R.id.edt_four) as EditText
                    val otp_view = dialog.findViewById(R.id.otp_view) as OtpTextView



                    val btn_done = dialog.findViewById(R.id.done_password) as Button
//                    val password= edt_first.text.toString()+edt_second.text.toString()+edt_third.text.toString()+edt_four.text.toString()
//                    System.out.println(password)


                    btn_done.setOnClickListener {

                        val otp=   otp_view.otp

                        val password =
                            edt_first.text.toString() + edt_second.text.toString() + edt_third.text.toString() + edt_four.text.toString()
                        System.out.println(password)
                        CoroutineScope(Dispatchers.Main).launch {
                            val db_pass = Notes_Database(context).getPassword().getPassowrd()
                            if (otp.equals(db_pass[0].pas)) {
                                notesEnitiy[position].fav = "false"
                                holder.view.img_fav.setImageResource(R.drawable.ic_lock_open_black_24dp)
                                val note = Notes_Enitiy(
                                    notesEnitiy[position].title,
                                    notesEnitiy[position].note,
                                    notesEnitiy[position].fav
                                )
                                note.id = notesEnitiy[position].id
                                CoroutineScope(Dispatchers.Main).launch {
                                    Notes_Database(context).getNotesDao().upDate(note)
                                }
                                holder.view.txt_title.visibility = View.VISIBLE
                                holder.view.txt_notes.visibility = View.VISIBLE
                                holder.view.delete.visibility = View.VISIBLE
                                holder.view.txt_title.text = notesEnitiy[position].title
                                holder.view.txt_notes.text = notesEnitiy[position].note
                                dialog.dismiss()
                                return@launch
                            } else {
                                Toast.makeText(
                                    context,
                                    "Please Enter Valid Password",
                                    Toast.LENGTH_LONG
                                ).show()
                                // dialog.dismiss()
                                return@launch
                            }
                        }


                    }

                    dialog.show()
                } else {
                    var bundle: Bundle = bundleOf(
                        "title" to notesEnitiy[position].title,
                        "notes" to notesEnitiy[position].note
                        , "id" to notesEnitiy[position].id
                    )
                    it.findNavController().navigate(R.id.action_add_Notes_to_save_Notes, bundle)
                }


            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        fun animatin() {

        }

    }
}

private fun OtpTextView.getOTP() {

}

class MyViewHoler(val view: View) : RecyclerView.ViewHolder(view)