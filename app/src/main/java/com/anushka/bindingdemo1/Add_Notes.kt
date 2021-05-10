package com.mynotes.notes

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mynotes.notes.adpter.Notes_Adpter
import com.mynotes.notes.databinding.FragmentAddNotesBinding
import com.mynotes.notes.db.Notes_Database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.jar.Manifest


/**
 * A simple [Fragment] subclass.
 */
class Add_Notes : Fragment(), BackPressed {
    private lateinit var binding: FragmentAddNotesBinding
    private val sharedPrefFile = "kotlinsharedpreference"
    var shar: String? = ""
    var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add__notes, container, false)
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

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


        if (sharedPreferences != null) {
            shar = sharedPreferences.getString("color", "defaultname")
            if (!shar.equals("defaultname")) {
                if (shar.toString().startsWith("orange")) {
                    requireActivity().theme.applyStyle(R.style.Oragne, true)
                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.Oragne);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.Oragne)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.red_button_with_blue_color))
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.orange
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.orange)
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.orange)
                    }

                } else if (shar.toString().startsWith("sky_blue")) {
                    requireActivity().theme.applyStyle(R.style.Sky_Blue, true)
                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.Sky_Blue);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.Sky_Blue)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.sky_blue
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.sky_blue)
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.sky_blue)
                    }

                } else if (shar.toString().startsWith("light_green")) {
                    requireActivity().theme.applyStyle(R.style.light_green, true)

                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.light_green);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.light_green)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_green))
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                        binding.noteRecycelerview.adapter =
                            Notes_Adpter(note, requireActivity(), "light_green")
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.light_green)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.light_green
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.light_green)
                            )
                        )

                    }
                } else if (shar.toString().startsWith("light_yellow")) {
                        requireActivity().theme.applyStyle(R.style.light_yellow, true)

                        if (Build.VERSION.SDK_INT > 22) {
                            binding.textView3.setTextAppearance(
                                requireActivity(),
                                R.style.light_yellow
                            );
                        } else {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                binding.textView3.setTextAppearance(R.style.light_yellow)
                            }
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_yellow))
                        }
                        CoroutineScope(Dispatchers.Main).launch {
                            val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                            binding.noteRecycelerview.adapter =
                                Notes_Adpter(note, requireActivity(), "light_yellow")
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            (activity as? AppCompatActivity)?.window?.statusBarColor =
                                ContextCompat.getColor(requireActivity(), R.color.light_yellow)
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.addFloating.setBackgroundTintList(
                                ColorStateList.valueOf(
                                    requireActivity().getColor(
                                        R.color.light_yellow
                                    )
                                )
                            )

                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.themFloating.setBackgroundTintList(
                                ColorStateList.valueOf(
                                    requireActivity().getColor(R.color.light_yellow)
                                )
                            )

                        }

                    }else if (shar.toString().startsWith("light_red")) {
                    requireActivity().theme.applyStyle(R.style.light_red, true)

                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.light_red);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.light_red)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_red))
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                        binding.noteRecycelerview.adapter =
                            Notes_Adpter(note, requireActivity(), "light_red")
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.light_red)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.light_red
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.light_red)
                            )
                        )

                    }

                }else if (shar.toString().startsWith("light_black")) {
                    requireActivity().theme.applyStyle(R.style.light_black, true)

                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.light_black);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.light_black)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_black))
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                        binding.noteRecycelerview.adapter =
                            Notes_Adpter(note, requireActivity(), "light_black")
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.light_black)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.light_black
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.light_black)
                            )
                        )

                    }

                }else if (shar.toString().startsWith("light_greay")) {
                    requireActivity().theme.applyStyle(R.style.light_greay, true)

                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.light_greay);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.light_greay)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_grey))
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                        binding.noteRecycelerview.adapter =
                            Notes_Adpter(note, requireActivity(), "light_greay")
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.light_greay)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.light_greay
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.light_greay)
                            )
                        )

                    }
                }else if (shar.toString().startsWith("light_pink")) {
                    requireActivity().theme.applyStyle(R.style.light_pink, true)

                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.light_pink);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.light_pink)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_pink))
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                        binding.noteRecycelerview.adapter =
                            Notes_Adpter(note, requireActivity(), "light_pink")
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.light_pink)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.light_pink
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.light_pink)
                            )
                        )

                    }
                }else if (shar.toString().startsWith("light_purple")) {
                    requireActivity().theme.applyStyle(R.style.light_purple, true)

                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(
                            requireActivity(),
                            R.style.light_purple
                        );
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.light_purple)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_purple))
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                        binding.noteRecycelerview.adapter =
                            Notes_Adpter(note, requireActivity(), "light_purple")
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.light_purple)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.light_purple
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(R.color.light_purple)
                            )
                        )

                    }
                }else{
                    requireActivity().theme.applyStyle(R.style.Sky_Blue, true)
                    if (Build.VERSION.SDK_INT > 22) {
                        binding.textView3.setTextAppearance(requireActivity(), R.style.Sky_Blue);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            binding.textView3.setTextAppearance(R.style.Sky_Blue)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))
                    } else {
                        binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.addFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.sky_blue
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.themFloating.setBackgroundTintList(
                            ColorStateList.valueOf(
                                requireActivity().getColor(
                                    R.color.sky_blue
                                )
                            )
                        )

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        (activity as? AppCompatActivity)?.window?.statusBarColor =
                            ContextCompat.getColor(requireActivity(), R.color.sky_blue)
                    }
                }
            } else {
                requireActivity().theme.applyStyle(R.style.Sky_Blue, true)
                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.Sky_Blue);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.Sky_Blue)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))
                } else {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.sky_blue
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.sky_blue
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.sky_blue)
                }

            }
        } else {
            requireActivity().theme.applyStyle(R.style.Sky_Blue, true)
            if (Build.VERSION.SDK_INT > 22) {
                binding.textView3.setTextAppearance(requireActivity(), R.style.Sky_Blue);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setTextAppearance(R.style.Sky_Blue)
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))
            } else {
                binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                binding.addFloating.setBackgroundTintList(
                    ColorStateList.valueOf(
                        requireActivity().getColor(
                            R.color.sky_blue
                        )
                    )
                )

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                binding.themFloating.setBackgroundTintList(
                    ColorStateList.valueOf(
                        requireActivity().getColor(
                            R.color.sky_blue
                        )
                    )
                )

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                (activity as? AppCompatActivity)?.window?.statusBarColor =
                    ContextCompat.getColor(requireActivity(), R.color.sky_blue)
            }
        }


        binding.themFloating.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(requireActivity())
// ...Irrelevant code for customizing the buttons and title
            val dialogView = layoutInflater.inflate(R.layout.theme_selection_layout, null)
            dialogBuilder.setView(dialogView)
            val alertDialog = dialogBuilder.create()
            //////type_face//////
            val typeface_sky_blue = Typeface.createFromAsset(requireActivity().assets, "delius_unicase.ttf")
            val typeface_orange = Typeface.createFromAsset(requireActivity().assets, "amaranth_bold.ttf")
            val typeface_light_green = Typeface.createFromAsset(requireActivity().assets, "eater.ttf")
            val typeface_yellow = Typeface.createFromAsset(requireActivity().assets, "cedarville_cursive.ttf")
            val typeface_light_red = Typeface.createFromAsset(requireActivity().assets, "abhaya_libre_medium.ttf")
            val typeface_light_black = Typeface.createFromAsset(requireActivity().assets, "biorhyme_light.ttf")
            val typeface_light_greay = Typeface.createFromAsset(requireActivity().assets, "crete_round_italic.ttf")
            val typeface_light_pink = Typeface.createFromAsset(requireActivity().assets, "cherry_swash.ttf")
            val typeface_light_purple = Typeface.createFromAsset(requireActivity().assets, "homemade_apple.ttf")
            //////txt declaration
            var txt_sky_blue = dialogView.findViewById<TextView>(R.id.txt_sky_blue)
            var txt_orange = dialogView.findViewById<TextView>(R.id.txt_orange)
            var txt_light_green = dialogView.findViewById<TextView>(R.id.txt_ligt_green)
            var txt_light_yellow = dialogView.findViewById<TextView>(R.id.txt_light_yellow)
            var txt_light_red = dialogView.findViewById<TextView>(R.id.txt_light_red)
            var txt_light_black = dialogView.findViewById<TextView>(R.id.txt_light_black)
            var txt_light_greay= dialogView.findViewById<TextView>(R.id.txt_light_grey)
            var txt_light_pink= dialogView.findViewById<TextView>(R.id.txt_light_pink)
            var txt_light_purple= dialogView.findViewById<TextView>(R.id.txt_light_purple)
            txt_sky_blue.setTypeface(typeface_sky_blue)
            txt_orange.setTypeface(typeface_orange)
            txt_light_green.setTypeface(typeface_light_green)
            txt_light_yellow.setTypeface(typeface_yellow)
            txt_light_red.setTypeface(typeface_light_red)
            txt_light_black.setTypeface(typeface_light_black)
            txt_light_greay.setTypeface(typeface_light_greay)
            txt_light_pink.setTypeface(typeface_light_pink)
            txt_light_purple.setTypeface(typeface_light_purple)
            alertDialog.show()

            val skyblue_cardview = dialogView.findViewById<CardView>(R.id.sky_bluecardView)
            //////sky_blue////////
            skyblue_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "sky_blue")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.Sky_Blue, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.Sky_Blue);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.Sky_Blue)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.sky_blue))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "sky_blue")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.sky_blue)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.sky_blue
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.sky_blue)
                        )
                    )

                }
                alertDialog.dismiss()
            }

            ///////////orange/////
            val orage_cardview = dialogView.findViewById<CardView>(R.id.cardView_orange)
            orage_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "orange")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.Oragne, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.Oragne);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.Oragne)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.red_button_with_blue_color))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "orange")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.orange)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.orange
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.orange)
                        )
                    )

                }
                alertDialog.dismiss()
            }
            ///////////light_green/////
            val light_green_cardview =
                dialogView.findViewById<CardView>(R.id.light_green_cardView_orange)
            light_green_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_green")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_green, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_green);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_green)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_green))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_green")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_green)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_green
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_green)
                        )
                    )

                }
                alertDialog.dismiss()
            }
            ///////////light_yellow/////
            val light_yellow_cardview =
                dialogView.findViewById<CardView>(R.id.light_yellow_cardView)
            light_yellow_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_yellow")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_yellow, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_yellow);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_yellow)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_yellow))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_yellow")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_yellow)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_yellow
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_yellow)
                        )
                    )

                }
                alertDialog.dismiss()
            }
            ///////////light_red/////
            val light_red_cardview =
                dialogView.findViewById<CardView>(R.id.light_red_cardView_orange)
            light_red_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_red")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_red, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_red);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_red)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_red))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_red")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_red)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_red
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_red)
                        )
                    )

                }
                alertDialog.dismiss()
            }
            ///////////light_black/////
            val light_black_cardview = dialogView.findViewById<CardView>(R.id.light_black_cardView)
            light_black_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_black")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_black, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_black);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_black)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_black))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_black")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_black)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_black
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_black)
                        )
                    )

                }
                alertDialog.dismiss()
            }
            ///////////light_grey/////
            val light_grey_cardview = dialogView.findViewById<CardView>(R.id.light_greay_cardView)
            light_grey_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_greay")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_greay, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_greay);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_greay)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_grey))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_greay")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_greay)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_greay
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_greay)
                        )
                    )

                }
                alertDialog.dismiss()
            }

            ///////////light_grey/////
            val light_pink_cardview = dialogView.findViewById<CardView>(R.id.cardView_light_pink)
            light_pink_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_pink")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_pink, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_pink);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_pink)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.ligt_pink))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_pink")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_pink)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_pink
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_pink)
                        )
                    )

                }
                alertDialog.dismiss()
            }
            ///////////light_white/////
            val light_white_cardview = dialogView.findViewById<CardView>(R.id.cardView_white)
            light_white_cardview.setOnClickListener {
                editor.clear()
                editor.apply()
                editor.putString("color", "light_purple")
                editor.apply()
                editor.commit()

                requireActivity().theme.applyStyle(R.style.light_purple, true)

                if (Build.VERSION.SDK_INT > 22) {
                    binding.textView3.setTextAppearance(requireActivity(), R.style.light_purple);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        binding.textView3.setTextAppearance(R.style.light_purple)
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.textView3.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.light_purple))
                }
                CoroutineScope(Dispatchers.Main).launch {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_purple")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    (activity as? AppCompatActivity)?.window?.statusBarColor =
                        ContextCompat.getColor(requireActivity(), R.color.light_purple)
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.addFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(
                                R.color.light_purple
                            )
                        )
                    )

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.themFloating.setBackgroundTintList(
                        ColorStateList.valueOf(
                            requireActivity().getColor(R.color.light_purple)
                        )
                    )

                }
                alertDialog.dismiss()
            }

        }
        binding.addFloating.setOnClickListener {

            it.findNavController().navigate(R.id.action_add_Notes_to_save_Notes)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.noteRecycelerview.setHasFixedSize(true)
        binding.noteRecycelerview.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        CoroutineScope(Dispatchers.Main).launch {
            val notes = Notes_Database(requireActivity()).getNotesDao().getAllnote()

            if (notes.size == 0) {
                binding.txtBeforeAdding.visibility = View.VISIBLE
                binding.lotterNotes.visibility = View.VISIBLE
                binding.noteRecycelerview.visibility = View.GONE
                binding.themFloating.visibility = View.GONE
          //      binding.constraint.setBackgroundDrawable(requireActivity().getDrawable(R.drawable.minion))
            } else {
                binding.txtBeforeAdding.visibility = View.GONE
                binding.lotterNotes.visibility = View.GONE
                binding.noteRecycelerview.visibility = View.VISIBLE
                if (shar != null && shar.toString().equals("orange")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "orange")
                } else if (shar != null && shar.toString().equals("sky_blue")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "sky_blue")
                } else if (shar != null && shar.toString().equals("light_green")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_green")
                } else if (shar != null && shar.toString().equals("light_yellow")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_yellow")
                } else if (shar != null && shar.toString().equals("light_red")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_red")
                } else if (shar != null && shar.toString().equals("light_black")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_black")
                } else if (shar != null && shar.toString().equals("light_greay")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_greay")
                } else if (shar != null && shar.toString().equals("light_pink")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_pink")
                } else if (shar != null && shar.toString().equals("light_purple")) {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "light_purple")
                } else {
                    val note = Notes_Database(requireActivity()).getNotesDao().getAllnote()
                    binding.noteRecycelerview.adapter =
                        Notes_Adpter(note, requireActivity(), "sky_blue")
                }
            }


        }
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().finish()
    }

}
//<resources>
//
//<!-- Base application theme. -->
//<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
//<!-- Customize your theme here. -->
//<item name="colorPrimary">@color/colorPrimary</item>
//<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
//<item name="colorAccent">@color/colorAccent</item>
//<item name="android:textColor">@android:color/white</item>
//<item name="fontFamily">sans-serif-condensed</item>
//<item name="editTextColor">@android:color/holo_blue_dark</item>
//</style>
//<style name="Second" parent="Theme.AppCompat.Light.DarkActionBar">
//<!-- Customize your theme here. -->
//<item name="colorPrimary">@android:color/holo_blue_dark</item>
//<item name="colorPrimaryDark">@android:color/holo_blue_dark</item>
//<item name="colorAccent">@android:color/holo_blue_bright</item>
//<item name="android:textColor">#000000</item>
//<item name="fontFamily">@font/amaranth_bold</item>
//<item name="editTextColor">@android:color/holo_blue_light</item>
//</style>
//<style name="Oragne" parent="Theme.AppCompat.Light.DarkActionBar">
//<!-- Customize your theme here. -->
//<item name="colorPrimary">@android:color/holo_orange_dark</item>
//<item name="colorPrimaryDark">@android:color/holo_orange_light</item>
//<item name="colorAccent">@android:color/holo_orange_dark</item>
//<item name="android:textColor">#000000</item>
//<item name="fontFamily">@font/amaranth_bold</item>
//<item name="editTextColor">@android:color/holo_orange_light</item>
//</style>
//
//</resources>

