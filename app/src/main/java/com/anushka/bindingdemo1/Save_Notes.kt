package com.mynotes.notes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mynotes.notes.databinding.FragmentSaveNotesBinding
import com.mynotes.notes.db.Notes_Database
import com.mynotes.notes.db.Notes_Enitiy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.*
import java.util.jar.Manifest


/**
 * A simple [Fragment] subclass.
 */
class Save_Notes : Fragment() {
    private var notesEnitiy: Notes_Enitiy? = null
    private lateinit var binding: FragmentSaveNotesBinding
    var title: String? = null
    var note: String? = null
    var id: Int? = null
    lateinit var bitmap: Bitmap
    lateinit var pageInfo: PdfDocument.PageInfo
    lateinit var page: PdfDocument.Page
    lateinit var canvas: Canvas
    lateinit var paint: Paint
    lateinit var fo: File
    lateinit var fout: OutputStream

    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_save__notes, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_save__notes, container, false)
        try {


            title = requireArguments().getString("title")
            note = requireArguments().getString("notes")
            id = requireArguments().getInt("id")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding.saveFloating.visibility = View.VISIBLE
        binding.shareFloating.visibility = View.VISIBLE
        binding.saveFloating.setOnClickListener {
            // it.findNavController().navigate(R.id.action_save_Notes_to_add_Notes)
            if (TextUtils.isEmpty(binding.edtNotes.text.toString())) {
                binding.edtNotes.error = "Please add notes"
                binding.edtNotes.requestFocus()
                return@setOnClickListener
            } else if (TextUtils.isEmpty(binding.edtTitle.text.toString())) {
                binding.edtTitle.error = "Please add titiles"
                binding.edtTitle.requestFocus()
                return@setOnClickListener

            } else {
                if (note == null && title == null) {
                    val note = Notes_Enitiy(
                        binding.edtTitle.text.toString(),
                        binding.edtNotes.text.toString(),
                        "false"
                    )

                    CoroutineScope(Dispatchers.IO).launch {
                        Notes_Database(requireActivity()).getNotesDao().addNote(note)
                        it.findNavController().navigate(R.id.action_save_Notes_to_add_Notes)
                        try {
                            val imm =
                                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } else {

                    val note = Notes_Enitiy(
                        binding.edtTitle.text.toString(),
                        binding.edtNotes.text.toString(),
                        "false"
                    )
                    note.id = id as Int

                    CoroutineScope(Dispatchers.IO).launch {
                        Notes_Database(requireActivity()).getNotesDao().upDate(note)
                        it.findNavController().navigate(R.id.action_save_Notes_to_add_Notes)
                        try {
                            val imm =
                                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }

            }
        }
        binding.shareFloating.setOnClickListener {
            val waIntent = Intent(Intent.ACTION_SEND)
            waIntent.setType("text/html")
            val body = binding.edtTitle.text.toString() + "\n" + binding.edtNotes.text.toString()
            waIntent.putExtra(Intent.EXTRA_TEXT, body)

            if (binding.edtTitle.text.toString() + binding.edtNotes.text.toString() != null
                && !binding.edtTitle.text.toString().equals("") && !binding.edtNotes.text.toString().equals("")) {
                val dialogBuilder = AlertDialog.Builder(requireActivity())
// ...Irrelevant code for customizing the buttons and title
                val dialogView = layoutInflater.inflate(R.layout.share_dialog, null)
                dialogBuilder.setView(dialogView)
                val alertDialog = dialogBuilder.create()
                val text_share = dialogView.findViewById<TextView>(R.id.text_share)
                val text_image = dialogView.findViewById<TextView>(R.id.image_share)
                text_share.setOnClickListener {
                    alertDialog.dismiss()
                    startActivity(Intent.createChooser(waIntent,"Share Text"))

                }
                text_image.setOnClickListener {
                    try{
                        ActivityCompat.requestPermissions(
                            requireActivity(),
                            arrayOf(
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                            ), 1
                        )
                    }catch (e :Exception){

                    }
                    card()
                    alertDialog.dismiss()

                }
                alertDialog.show()



                // layoutToImage(binding.edtNotes)


            } else {
                Toast.makeText(
                    requireActivity(),
                    "Please enter some title and notes to share",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (title != null) {
            binding.edtTitle.setText(title)
        }
        if (note != null) {
            binding.edtNotes.setText(note)
        }
    }


    fun layoutToImage(view: View) {
        // get view group using reference
        // convert view group to bitmap
        binding.edtNotes.setDrawingCacheEnabled(true)
        binding.edtNotes.buildDrawingCache()
        bitmap = binding.edtNotes.getDrawingCache()
        val share = Intent(Intent.ACTION_VIEW)
        //  share.setType("image/jpeg")
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)

        fo = File(Environment.getExternalStorageDirectory(), File.separator + "image.jpg")
        val path = Uri.fromFile(fo);

        try {
            fo.createNewFile()
            val fos = FileOutputStream(fo)
            fos.write(bytes.toByteArray())

            //shareIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("�-https://play.google.com/store/apps/details?id=in.sigmacell.sellqwik.prasyst&hl=en�"));
//shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
            //share.putExtra(Intent.EXTRA_STREAM, fo)
            share.setDataAndType(path, "application/pdf");
            share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            try {
                startActivity(share);
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), "Can't read pdf file", Toast.LENGTH_SHORT).show();
            }
//        startActivity(
//            Intent.createChooser(
//                share,
//                "Share Via"
//            )
            //   )
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }


    fun takeScreenShot(v1: View) {
        val mPath = Environment.getExternalStorageDirectory().toString() + "/" + "notes.jpg"
// create bitmap screen capture


        v1.setDrawingCacheEnabled(true);
// bitmap = Bitmap.createBitmap(v1.getDrawingCache());
        bitmap = loadBitmapFromView(v1, v1.getWidth(), v1.getHeight());
        v1.setDrawingCacheEnabled(false);


        val imageFile = File(mPath);

        try {
            fout = FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
            fout.flush();
            fout.close();
            sendScreenShot(imageFile)

        } catch (e: FileNotFoundException) {
            e.printStackTrace();
        } catch (e: IOException) {
            e.printStackTrace();
        }

    }

    fun loadBitmapFromView(v: View, width: Int, height: Int): Bitmap {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = Canvas(bitmap);
        v.layout(0, 0, width, height);
//Get the view’s background
        val bgDrawable = v.getBackground();
        if (bgDrawable != null)
//has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
//does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        v.draw(canvas);
        return bitmap;
    }

    fun sendScreenShot(imageFile: File) {
        val uri = Uri.fromFile(imageFile);
      //  val photoURI = FileProvider . getUriForFile (requireActivity(), requireActivity().getApplicationContext().getPackageName()+".provider", imageFile);
        val photoURI = FileProvider.getUriForFile(requireActivity(), BuildConfig.APPLICATION_ID + ".provider",imageFile)


        val shareIntent = Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Notes")
        shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
        shareIntent.setType("image/*")
        startActivity(Intent.createChooser(shareIntent, "Share Notes"))
    }
    fun  card(){
        var shar: String? = ""
        val sharedPrefFile = "kotlinsharedpreference"
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val dialogBuilder = AlertDialog.Builder(requireActivity())
        val dialogView = layoutInflater.inflate(R.layout.share_image_view, null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        val text_title = dialogView.findViewById<TextView>(R.id.text_title)
        val text_notes = dialogView.findViewById<TextView>(R.id.text_notes)
        val ll_image = dialogView.findViewById<LinearLayout>(R.id.ll_image)
        val share = dialogView.findViewById<Button>(R.id.share)
        val title =binding.edtTitle.text.toString()
        val notes =binding.edtNotes.text.toString()
        if (sharedPreferences != null) {
            shar = sharedPreferences.getString("color", "defaultname")
            if (shar.toString().startsWith("orange")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.red_button_with_blue_color))
                }
            }else if (shar.toString().startsWith("sky_blue")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))
                }
            } else if (shar.toString().startsWith("light_green")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_green))
                }
            }else if (shar.toString().startsWith("light_yellow")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_yellow))
                }
            }else if (shar.toString().startsWith("light_red")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_red))
                }
            }else if (shar.toString().startsWith("light_black")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_black))
                }
            }else if (shar.toString().startsWith("light_greay")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_grey))
                }
            }else if (shar.toString().startsWith("light_pink")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_pink))
                }
            }else if (shar.toString().startsWith("light_purple")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ll_image.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_purple))
                }
            }

        }
        text_title.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        text_title.setText(title)
        text_notes.setText(notes)
        alertDialog.show()
        Handler().postDelayed(
            {
                share.visibility = View.GONE
                takeScreenShot(ll_image)
                alertDialog.dismiss()
            }, 1000)

//        share.setOnClickListener {
//            share.visibility = View.GONE
//            takeScreenShot(ll_image)
//            alertDialog.dismiss()
//        }






    }


}


